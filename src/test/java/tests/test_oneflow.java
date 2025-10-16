package tests;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserAPI;
import base.BaseTest;

public class test_oneflow extends BaseTest {

    private final UserAPI userAPI = new UserAPI();

    @Test
    @Description("Full flow: Create , Update , Get  Delete ")
    public void testFullUserFlow() {
        
        System.out.println("STEP 1: Create User ");
        Response createResponse = userAPI.createUser("Youssef", "you@gmail.com", "123");
        createResponse.prettyPrint();
        Assert.assertEquals(createResponse.getStatusCode(), 201, " User not created successfully!");

        int userId = createResponse.jsonPath().getInt("id");
        System.out.println(" Created User ID: " + userId);

        
        System.out.println("STEP 2: Update User ");
        String newEmail = "hod@gmail";
        Response updateResponse = userAPI.updateUser(userId, newEmail);
        updateResponse.prettyPrint();
        
        
        Assert.assertEquals(updateResponse.getStatusCode(), 200, " User not updated!");
        
        
        String updatedEmail = updateResponse.jsonPath().getString("email");
        Assert.assertEquals(updatedEmail, newEmail, " Email field was not updated correctly!");

        
        String updatedAt = updateResponse.jsonPath().getString("updatedAt");
        Assert.assertNotNull(updatedAt, "updatedAt timestamp should not be null!");

        System.out.println("User updated successfully with email: " + updatedEmail);
        System.out.println("Update timestamp: " + updatedAt);

        
        System.out.println("STEP 3: Get User");
        
        int existingUserId = 2; 
        Response getResponse = userAPI.getUser(existingUserId);
        getResponse.prettyPrint();
        Assert.assertEquals(getResponse.getStatusCode(), 200, "User not found!");
        
        
        Assert.assertNotNull(getResponse.jsonPath().get("data"), " User data should not be null!");
        System.out.println(" Successfully retrieved user with ID: " + existingUserId);

        
        System.out.println("STEP 4: Delete User ");
        int userToDelete = 2; 
        Response deleteResponse = userAPI.deleteUser(userToDelete);
        Assert.assertEquals(deleteResponse.getStatusCode(), 204, " User not deleted");
        System.out.println(" Delete request completed successfully with status: " + deleteResponse.getStatusCode());

        
        System.out.println("STEP 5: Verify User Deletion ");

        int nonExistentUserId = 98;
        Response verifyDeleteResponse = userAPI.getUser(nonExistentUserId);
        verifyDeleteResponse.prettyPrint();
        Assert.assertEquals(verifyDeleteResponse.getStatusCode(), 404, " Expected 404 for nonexistent user");
        System.out.println(" Correctly received 404 for nonexistent user ID: " + nonExistentUserId);

        System.out.println(" All user flow steps passed successfully");

    }
}
