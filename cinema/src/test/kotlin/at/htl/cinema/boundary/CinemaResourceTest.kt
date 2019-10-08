package at.htl.cinema.boundary

import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
open class CinemaResourceTest {

    @Test
    fun testCinemaEndpoint() {
        given().`when`().post("/cinema/initialize")

        given()
          .`when`().get("/cinema")
          .then()
             .statusCode(200)
             .body( "size()", `is`(2))
    }

}