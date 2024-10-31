package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.util.Properties;


public class MyHooks {

    WebDriver driver;

    @Before
    public void setup() {

        Properties prop = new ConfigReader().intializeProperties();
        driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed()) {
            String scenarioName = scenario.getName().replaceAll(" ","_");
            byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png", scenarioName);
        }
        driver.quit();
    }
}