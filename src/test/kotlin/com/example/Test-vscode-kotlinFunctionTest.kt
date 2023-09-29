package com.example
import io.micronaut.http.*
import org.junit.jupiter.api.Test
import io.micronaut.gcp.function.http.*
import org.junit.jupiter.api.Assertions

class Test-vscode-kotlinFunctionTest {

    @Test
    fun testFunction() {
        HttpFunction().use { function ->
           val response = function.invoke(HttpMethod.GET, "/test-vscode-kotlin")
            Assertions.assertEquals(HttpStatus.OK, response.status)
        }
    }


    @Test
    fun testPost(){
        HttpFunction().use { function ->
            val input = SampleInputMessage("Test Name")
            val request = HttpRequest.POST("/test-vscode-kotlin", input).contentType(MediaType.APPLICATION_JSON_TYPE)
            val response = function.invoke(request)
            Assertions.assertEquals(HttpStatus.OK, response.status)
        }
    }
}
