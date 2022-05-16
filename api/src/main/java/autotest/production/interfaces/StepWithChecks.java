package autotest.production.interfaces;

import io.restassured.response.ValidatableResponse;

@FunctionalInterface
public interface StepWithChecks {

    ValidatableResponse doStep() throws Throwable;

}
