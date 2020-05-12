package com.localhost.pojo.testsuite;

import com.localhost.pojo.StudentPojo;
import com.localhost.pojo.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchRequest extends TestBase {

    @Test
    public void updateSingleFieldEmail() {

        StudentPojo studentPojo = new StudentPojo();

        studentPojo.setEmail("andcdef123@gmail.com");

        given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .patch("/10")


                .then()
                .log()
                .body()
                .body("msg", equalTo("Updated"))
                .statusCode(200);


    }
}
