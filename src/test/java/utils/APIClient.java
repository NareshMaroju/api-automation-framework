
package utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class APIClient {
 private static final String BASE_URL = ConfigReader.get("base.url");
 public Response createObject(Object body){
  return RestAssured.given().baseUri(BASE_URL).header("Content-Type","application/json").body(body).post("/objects");
 }
 public Response getObject(String id){
  return RestAssured.given().baseUri(BASE_URL).get("/objects/"+id);
 }
 public Response getAllObjects(){
  return RestAssured.given().baseUri(BASE_URL).get("/objects");
 }
 public Response deleteObject(String id){
  return RestAssured.given().baseUri(BASE_URL).delete("/objects/"+id);
 }
}
