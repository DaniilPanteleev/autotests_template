package autotest.production;


import autotest.production.annotations.DeserializeResponse;
import autotest.production.annotations.ExpectedJsonSchema;
import autotest.production.annotations.ExpectedResponse;
import autotest.production.entities.BaseBody;
import autotest.production.interfaces.Step;
import autotest.production.interfaces.StepWithChecks;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.util.Optional;
import java.util.UUID;

public abstract class TestBase extends BaseBody {

    private Object expectedResponse;
    private String jsonSchema;
    private Class classToDeserialize;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        ExpectedResponse expectedResponse = testInfo.getTestMethod().get().getAnnotation(ExpectedResponse.class);
        if (Optional.ofNullable(expectedResponse).isPresent()) {
           this.expectedResponse = expectedResponse.value();
        }

        ExpectedJsonSchema expectedJsonSchema = testInfo.getTestMethod().get().getAnnotation(ExpectedJsonSchema.class);
        if (Optional.ofNullable(expectedJsonSchema).isPresent()) {
            jsonSchema = expectedJsonSchema.value();
        }

        DeserializeResponse deserializeResponse = testInfo.getTestMethod().get().getAnnotation(DeserializeResponse.class);
        if (Optional.ofNullable(deserializeResponse).isPresent()) {
            classToDeserialize = deserializeResponse.value();
        }
    }

    protected void checkResponse(Object actualResponse) {
        Assertions.assertEquals(expectedResponse, actualResponse);
    }

    public void checkJsonSchema(Response actualJsonResponse) {
        actualJsonResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(jsonSchema));
    }

    @SneakyThrows
    protected void step(String stepName, Step stepsToExecute) {
        String stepId = UUID.randomUUID().toString();

        Allure.getLifecycle().startStep(stepId, new StepResult().setName(stepName).setStatus(Status.PASSED));
        try {
            stepsToExecute.doStep();
        } catch (Throwable e) {
            throw new AssertionError(e);
        }
        Allure.getLifecycle().stopStep(stepId);
    }

    @SneakyThrows
    protected void stepWithCheckingSchemaAndResponse(String stepName, StepWithChecks stepsToExecute) {
        String stepId = UUID.randomUUID().toString();

        Allure.getLifecycle().startStep(stepId, new StepResult().setName(stepName).setStatus(Status.PASSED));
        try {
            ValidatableResponse validatableResponse = stepsToExecute.doStep();

            checkJsonSchema(validatableResponse.extract().response());

            checkResponse(validatableResponse.extract().as(classToDeserialize));
        } catch (Throwable e) {
            Allure.getLifecycle().updateStep(stepId, s -> s.setStatus(Status.FAILED));
            throw new AssertionError(e);
        }
        Allure.getLifecycle().stopStep(stepId);
    }

}
