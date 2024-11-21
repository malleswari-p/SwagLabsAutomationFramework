package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
        glue={"stepdefinitions","hooks"},
        publish=true,
        monochrome = true,         
 //       tags = "@twitterLink",
        plugin={"pretty","html:target/CucumberReports/CucumberReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner {
}
