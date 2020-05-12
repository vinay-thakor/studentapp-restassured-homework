package com.localhost.pojo.testsuite;

import com.localhost.pojo.StudentPojo;
import com.localhost.pojo.testbase.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest extends TestBase {

    @Test
    public void createNewStudnet(){
        List<String> courses = new ArrayList<String>();
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("prime");
        studentPojo.setLastName("Testing");
        studentPojo.setEmail("wra@gmail.com");
        studentPojo.setProgramme("computer");
        studentPojo.setCourses(courses);

        given()
                .header("Content-Type", "application/json")
                .log()
                .body()

                .when()
                .body(studentPojo)
                .post()

                .then()
                .log()
                .body()
                .body("msg",equalTo("Student added"))
                .statusCode(200);
    }

}
