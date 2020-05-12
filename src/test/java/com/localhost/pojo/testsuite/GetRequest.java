package com.localhost.pojo.testsuite;

import com.localhost.pojo.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest extends TestBase {
    @Test
    public void getStudentList() {
        given()
                .log()
                .uri()
                .when()
                .log()
                .uri()
                .get("/list")
                .then()
                .log()
                .body()
                .body("id.size", equalTo(100))
                .statusCode(200);

    }

    @Test
    public void getStudentById() {
        given()
                .log()
                .headers()
                .when()
                .log()
                .uri()
                .get("/2")

                .then()
                .log()
                .body()
                .body("firstname", equalTo("murphy"))
                .statusCode(200);
    }

    @Test
    public void getStudentByProgramme() {
        given()
                .log()
                .parameters()
                .param("programme", "Computer Science")
                .when()
                .get("/list")
                .then()
                .log()
                .body()
                .body("id.size", equalTo(14))
                .statusCode(200);
    }

    @Test
    public void getLimitedStudentByProgramme() {
        given()
                .param("programme", "Law")
                .queryParam("limit", "3")
                .when()
                .get("/list")
                .then()
                .log()
                .body()
                .body("id.size", equalTo(3))
                .statusCode(200);


    }

}
