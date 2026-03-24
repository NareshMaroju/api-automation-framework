
package stepdefinitions;

import io.cucumber.java.en.*;
import utils.*;
import java.util.*;
import static org.hamcrest.Matchers.*;

public class ObjectSteps {
 TestContext context = new TestContext();
 APIClient api = new APIClient();
 Map<String,Object> body = new HashMap<>();

 @Given("user prepares object with name {string}")
 public void name(String name){ body.put("name", name); }

 @And("CPU model is {string}")
 public void cpu(String cpu){
  Map<String,Object> data=new HashMap<>();
  data.put("CPU model", cpu);
  body.put("data", data);
 }

 @And("price is {string}")
 public void price(String price){
  ((Map<String,Object>)body.get("data")).put("price", price);
 }

 @When("user sends POST request")
 public void post(){
  context.response = api.createObject(body);
  context.objectId = context.response.jsonPath().getString("id");
 }

 @Then("response status should be {int}")
 public void status(int code){
  context.response.then().statusCode(code);
 }

 @And("response should contain name {string}")
 public void validate(String name){
  context.response.then().body("name", equalTo(name));
 }

 @Given("an item is already created")
 public void create(){
  name("Test"); cpu("i5"); price("100"); post();
 }

 @When("user sends GET request for that item")
 public void get(){
  context.response = api.getObject(context.objectId);
 }

 @When("user sends DELETE request")
 public void delete(){
  context.response = api.deleteObject(context.objectId);
 }

 @When("user sends GET request for all objects")
 public void getAll(){
  context.response = api.getAllObjects();
 }

 @And("response should contain list")
 public void list(){
  context.response.then().body("$", not(empty()));
 }
}
