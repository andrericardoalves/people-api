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

    @Test
    void shouldInsertUpdatePeopleBatchAndReturnOk() {
        String people = """
                    [
          {
            "firstName": "John",
            "lastName": "Doe",
            "email": "john.doe@example.com",
            "nickname": "johnny d",
            "dateOfBirth": "1990-01-01",
            "createdAt": "2026-01-01T10:15:30",
            "updatedAt": "2026-01-01T10:15:30"
          },
          {
            "firstName": "Jane",
            "lastName": "Smith",
            "email": "jane.smith@example.com",
            "nickname": "janie",
            "dateOfBirth": "1991-02-02",
            "createdAt": "2026-01-01T10:16:30",
            "updatedAt": "2026-01-01T10:16:30"
          },
          {
            "firstName": "Michael",
            "lastName": "Brown",
            "email": "michael.brown@example.com",
            "nickname": "mike",
            "dateOfBirth": "1989-03-03",
            "createdAt": "2026-01-01T10:17:30",
            "updatedAt": "2026-01-01T10:17:30"
          },
          {
            "firstName": "Emily",
            "lastName": "Davis",
            "email": "emily.davis@example.com",
            "nickname": "em",
            "dateOfBirth": "1992-04-04",
            "createdAt": "2026-01-01T10:18:30",
            "updatedAt": "2026-01-01T10:18:30"
          },
          {
            "firstName": "Daniel",
            "lastName": "Wilson",
            "email": "daniel.wilson@example.com",
            "nickname": "dan",
            "dateOfBirth": "1988-05-05",
            "createdAt": "2026-01-01T10:19:30",
            "updatedAt": "2026-01-01T10:19:30"
          },
          {
            "firstName": "Olivia",
            "lastName": "Taylor",
            "email": "olivia.taylor@example.com",
            "nickname": "liv",
            "dateOfBirth": "1993-06-06",
            "createdAt": "2026-01-01T10:20:30",
            "updatedAt": "2026-01-01T10:20:30"
          },
          {
            "firstName": "William",
            "lastName": "Anderson",
            "email": "william.anderson@example.com",
            "nickname": "will",
            "dateOfBirth": "1987-07-07",
            "createdAt": "2026-01-01T10:21:30",
            "updatedAt": "2026-01-01T10:21:30"
          },
          {
            "firstName": "Sophia",
            "lastName": "Thomas",
            "email": "sophia.thomas@example.com",
            "nickname": "soph",
            "dateOfBirth": "1994-08-08",
            "createdAt": "2026-01-01T10:22:30",
            "updatedAt": "2026-01-01T10:22:30"
          },
          {
            "firstName": "James",
            "lastName": "Moore",
            "email": "james.moore@example.com",
            "nickname": "jim",
            "dateOfBirth": "1986-09-09",
            "createdAt": "2026-01-01T10:23:30",
            "updatedAt": "2026-01-01T10:23:30"
          },
          {
            "firstName": "Ava",
            "lastName": "Martin",
            "email": "ava.martin@example.com",
            "nickname": "av",
            "dateOfBirth": "1995-10-10",
            "createdAt": "2026-01-01T10:24:30",
            "updatedAt": "2026-01-01T10:24:30"
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
