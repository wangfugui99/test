import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class WeatherApi {

    @Test
    public void weather(){
       Response res =  given()
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then().log().all().extract().response();

        System.out.println(res.time());
        System.out.println(res.getStatusCode());
        System.out.println(res.path("headers.Host").toString());
        String vaule = res.path("headers.Host").toString();
        assertThat(vaule, Matchers.equalTo("httpbin.ceshiren.com"));

    }
}
