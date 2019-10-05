package at.htl.cinema.boundary

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
open class CinemaResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/C:/Program Files/Git/cinema")
          .then()
             .statusCode(200)
             .body(`is`("hello"))
    }

}