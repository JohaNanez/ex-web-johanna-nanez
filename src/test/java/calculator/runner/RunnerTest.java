package calculator.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json"},
        stepNotifications = true,
        features = "src/test/resources/features",
        glue = "calculator.stepsdefinitions",
        tags = "@testFeature"
)

public class RunnerTest {
}
