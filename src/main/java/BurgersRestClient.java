import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import pojo.RootUser;

import static io.restassured.RestAssured.given;

public class BurgersRestClient {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @Step("Register user POST /api/auth/register")
    public ValidatableResponse createUser(UserData data) {
        return given()
                .baseUri(BASE_URL)
                //.log().all()
                .header("Content-Type", "application/json")
                .body(data)
                .post("/api/auth/register")
                .then();
                //.log().all();
    }

    @Step("delete user DELETE /api/auth/user")
    public void deleteUser(RootUser rootUser) {
        given()
                .baseUri(BASE_URL)
                //.log().all()
                .header("authorization", rootUser.getAccessToken())
                //.log().all()
                .delete("/api/auth/user");
    }

    @Step("Login user POST /api/auth/login")
    public ValidatableResponse loginUser(UserData data) {
        return given()
                //.log().all()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(data)
                .post("/api/auth/login")
                .then();
                ///.log().all();
    }

    @Step("Update user data PATCH /api/auth/user")
    public ValidatableResponse updateUser(String data, RootUser rootUser) {
        return given()
                //.log().all()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .header("authorization", rootUser.getAccessToken())
                .body(data)
                .patch("/api/auth/user")
                .then();
                //.log().all();
    }
}

