package com.localhost.pojo.testsuite;

import com.localhost.pojo.StudentPojo;
import com.localhost.pojo.testbase.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutRequest extends TestBase {

    @Test
    public void updateStudentDetails() {
        List<String> courses = new ArrayList<>();
        courses.add("Downloaded");
        courses.add("Unzip");
        courses.add("copy");
        courses.add("paste");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Primeone");
        studentPojo.setLastName("Testingtwo");
        studentPojo.setEmail("whyru1@gmail.com");
        studentPojo.setProgramme("computer");
        studentPojo.setCourses(courses);

        given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .put("/88")


                .then()
                .log()
                .body()
                .body("msg", equalTo("Student Updated"))
                .statusCode(200);


    }
}


