package com.localhost.pojo.testsuite;

import com.localhost.pojo.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest extends TestBase {
    @Test
    public void deleteStudent() {
        given()

                .log()

                .uri()

                .when()
                .delete("/2")

                .then()
                .log()
                .status()
                .statusCode(204);


    }

}
