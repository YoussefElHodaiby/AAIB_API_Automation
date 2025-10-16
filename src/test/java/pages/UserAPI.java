package pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UserAPI {

    public Response createUser(String name, String email, String password) {
       
        String requestBody = "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}";

        
        Response response = given()
                .body(requestBody)                      
                .when()
                .post("/users");

        return response;
    }

    public Response updateUser(int userId, String email) {
        
        String requestBody = "{\n" +
                "  \"email\": \"" + email + "\"\n" +
                "}";

        
        Response response = given()
                .body(requestBody)
                .when()
                .put("/users/" + userId);

        return response;
    }


    public Response getUser(int userId) {
        Response response = given()
                .when()
                .get("/users/" + userId);

        return response;
    }


    public Response deleteUser(int userId) {
        Response response = given()
                .when()
                .delete("/users/" + userId);

        return response;
    }
}
