package intermedioCucumber2;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/Test/java/intermedioCucumber2/Features",
        glue = "intermedioCucumber2/StepDef",
        plugin = {"pretty"},
        tags = "@compras or @spotify"
)

public class runner {

}
