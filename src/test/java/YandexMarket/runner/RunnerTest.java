package YandexMarket.runner;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-reports/runnertest", "json:target/cucumber.json"},
        features = "src/test/java/YandexMarket/features/Steps.features",
        glue = "YandexMarket.steps",
        dryRun = false,
        strict = true
)

public class RunnerTest {
    @BeforeClass
    static public void testSetup()
    {
        Configuration.timeout = 10000;

    }
}