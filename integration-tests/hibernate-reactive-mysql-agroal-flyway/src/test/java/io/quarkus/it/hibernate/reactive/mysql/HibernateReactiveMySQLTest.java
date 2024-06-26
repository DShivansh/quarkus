package io.quarkus.it.hibernate.reactive.mysql;

import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

/**
 * Test various Reactive Hibernate operations running in Quarkus using MySQL
 */
@QuarkusTest
public class HibernateReactiveMySQLTest {

    @Test
    public void reactiveFindMutiny() {
        RestAssured.when()
                .get("/tests/reactiveFindMutiny")
                .then()
                .body(is("{\"id\":5,\"name\":\"Aloi\"}"));
    }

    @Test
    public void jdbcFind() {
        RestAssured.when()
                .get("/tests/jdbcFind")
                .then()
                .body(is("{\"id\":6,\"name\":\"Iola\"}"));
    }

    @Test
    public void reactivePersist() {
        RestAssured.when()
                .get("/tests/reactivePersist")
                .then()
                .body(is("Tulip"));
    }

    @Test
    public void reactiveRemoveTransientEntity() {
        RestAssured.when()
                .get("/tests/reactiveRemoveTransientEntity")
                .then()
                .body(is("OK"));
    }

    @Test
    public void reactiveRemoveManagedEntity() {
        RestAssured.when()
                .get("/tests/reactiveRemoveManagedEntity")
                .then()
                .body(is("OK"));
    }

    @Test
    public void reactiveUpdate() {
        RestAssured.when()
                .get("/tests/reactiveUpdate")
                .then()
                .body(is("Tina"));
    }
}
