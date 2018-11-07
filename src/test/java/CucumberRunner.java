import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources" },
        glue = {"stepdefs"},
        tags = {"@all"},
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"}

)
public class CucumberRunner {
}