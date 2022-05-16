package autotest.production.helpers;

import autotest.production.entities.BaseBody;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.tuple.Pair;

public class UserHelper extends BaseHelper<UserHelper> {

    public ValidatableResponse getUserInfo(String id) {
        return withChangesToRequestSpec(requestSpecBuilder -> requestSpecBuilder.addQueryParam("id", id))
                .sendRequest(Pair.of(Method.GET, "/info"));
    }

    public ValidatableResponse postUserInfo(BaseBody body) {
        return withChangesToRequestSpec(requestSpecBuilder -> requestSpecBuilder.setBody(body.toJson()))
                .sendRequest(Pair.of(Method.POST, "/create"));
    }

    public ValidatableResponse putUserInfo(BaseBody body) {
        return withChangesToRequestSpec(requestSpecBuilder -> requestSpecBuilder.setBody(body.toJson()))
                .sendRequest(Pair.of(Method.PUT, "/update" ));
    }

    public ValidatableResponse deleteUserInfo(String body) {
        return withChangesToRequestSpec(requestSpecBuilder -> requestSpecBuilder.setBody(body))
                .sendRequest(Pair.of(Method.DELETE, "/delete"));
    }

}
