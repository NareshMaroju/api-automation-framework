
package runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.*;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", glue={"stepdefinitions","hooks"}, plugin={"pretty","html:target/report.html"})
public class TestRunner {}
