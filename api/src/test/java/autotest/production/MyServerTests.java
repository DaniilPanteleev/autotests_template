package autotest.production;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyServerTests extends TestBase {

//    @Test
//    @ExpectedResponse("GetUserInfoExpectedResponse.json")
//    @ExpectedJsonSchema("PostUserInfoExpectedResponse.json")
//    @DeserializeResponse(GetUserinfoResponse.class)
//    void checkUserResponseTest1() {
//        stepWithCheckingSchemaAndResponse("1. Check user info response", () -> new UserHelper().getUserInfo("1"));
//    }
//
//    @Test
//    @ExpectedResponse("PostUserInfoExpectedResponse.json")
//    @ExpectedJsonSchema("PostUserInfoExpectedResponse.json")
//    @DeserializeResponse(GetUserinfoResponse.class)
//    void checkUserPostTest1() {
//        stepWithCheckingSchemaAndResponse("2. Check create info response", () -> new UserHelper().postUserInfo(PostUserinfoToServer
//                .builder()
//                .name("abc")
//                .lastName("abc")
//                .info(PostUserinfoToServerInfo.builder().age(10).growth(150).build())
//                .colors(Arrays.asList("red" , "black"))
//                .build())
//        );
//    }
//
//    @Test
//    @ExpectedResponse("PutUserUpdateInfoExpectedResponse.json")
//    @ExpectedJsonSchema("PutUserInfoUpdateJsonSchema.json")
//    @DeserializeResponse(GetUserinfoResponse.class)
//    void checkUserPutTest() {
//        stepWithCheckingSchemaAndResponse("3. Check update info response", () -> new UserHelper().putUserInfo(PutUserinfoToServer
//                .builder()
//                .name("Boris")
//                .lastName("Huyoris")
//                .build()));
//    }
//
//    @Test
//    void checkDeleteUserinfo() {
//        step("4 Delete user info", () -> new UserHelper().deleteUserInfo("{\n" +
//                "     \"id\": 1, \n" +
//                "        \"name\": \"Boris\",\n" +
//                "    \"lastName\": \"Huyoris\"\n" +
//                "}"));
//    }

    @Test
    void testJenkins() {
        Assertions.assertEquals(1,1);

    }

}
