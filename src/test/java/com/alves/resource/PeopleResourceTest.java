package com.alves.resource;



import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import config.PostgresTestContainerConfig;

@QuarkusTest
@QuarkusTestResource(value = PostgresTestContainerConfig.class)
class PeopleResourceTest {

    @Test
    void shouldInsertPeopleAndReturnOk() {

        String people = """
            [
              {
                "firstName": "John",
                "lastName": "Doe",
                "email": "john-doe.alves.com",
                "nickname": "johnny",
                "dateOfBirth": "1990-01-01",
                "createdAt": "2026-01-01T10:15:30",
                "updatedAt": "2026-01-01T10:15:30"
              }
            ]
            """;

        Response response =
            RestAssured.given()
                .contentType("application/json")
                .body(people)
                .when()
                .post("/v1/people");

        Assertions.assertEquals(200, response.getStatusCode());
    }
}
