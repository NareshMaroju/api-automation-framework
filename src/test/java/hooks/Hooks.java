
package hooks;
import io.cucumber.java.After;
import utils.*;
public class Hooks {
 TestContext context = new TestContext();
 APIClient api = new APIClient();
 @After
 public void cleanup(){
  if(context.objectId!=null){
   api.deleteObject(context.objectId);
  }
 }
}
