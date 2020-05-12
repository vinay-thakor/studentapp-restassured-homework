package com.localhost.pojo.testsuite;

import com.localhost.pojo.testbase.TestBase;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class OptionsRequest extends TestBase {

    @Test
    public void checkRequestOptions() {
        given()

                .when()
                .options()

                .then()
                .log()
                .headers()
                .statusCode(200);

    }

}
