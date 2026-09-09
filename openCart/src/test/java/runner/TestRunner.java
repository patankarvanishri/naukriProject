package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/Features", // Path to feature files
glue = {"stepdefinitions"}, // Package containing step definitions
plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"},
//tags = "@smoke and not @ignore",
monochrome = true, // remove un-nesessary char from console window like(?/specialchar)/provide clear-cut o/p
dryRun = false, //cross-check every step having corresponding method implemented or not
publish=true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
