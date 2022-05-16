package autotest.production.helpers;

import autotest.production.config.Config;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.extern.java.Log;
import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Consumer;
import java.util.function.Function;

import static io.restassured.RestAssured.given;

@Log
public abstract class BaseHelper<T extends BaseHelper> {

    private final RequestSpecBuilder baseRequestSpecBuilder = new RequestSpecBuilder()
            .setBasePath("/user")
            .setBaseUri(Config.url)
            .setPort(Config.port)
            .setContentType(ContentType.JSON)
            .addFilter(new AllureRestAssured());

    private final ResponseSpecBuilder baseResponseSpecBuilder = new ResponseSpecBuilder();

    private Function<ValidatableResponse, ValidatableResponse> responseValidationFunction =
            response -> response.log().ifValidationFails().statusCode(200);

    protected RequestSpecBuilder getBaseRequestSpecBuilder() {
        return baseRequestSpecBuilder;
    }

    protected ResponseSpecBuilder getBaseResponseSpecBuilder() {
        return baseResponseSpecBuilder;
    }

    public RequestSpecification getRequestSpecification() {
        return getBaseRequestSpecBuilder()
                .build()
                .log()
                .ifValidationFails();
    }

    public T withChangesToRequestSpec(Consumer<RequestSpecBuilder> specBuilderConsumer) {
        specBuilderConsumer.accept(this.baseRequestSpecBuilder);
        return (T) this;
    }

    protected ValidatableResponse sendRequest(Pair<Method, String> endpointInfoPair) {
        ValidatableResponse response = this.responseValidationFunction
                .apply(
                        given(this.getRequestSpecification(), this.getBaseResponseSpecBuilder().build())
                                .request(endpointInfoPair.getLeft(), endpointInfoPair.getRight())
                                .then()
                );
        log.info(() -> String.format("Finished request [%s] within %s ms",
                endpointInfoPair.getLeft() + " " + endpointInfoPair.getRight(),
                response.extract().time()));
        return response;
    }

}
