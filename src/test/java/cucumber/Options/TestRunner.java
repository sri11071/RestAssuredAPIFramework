package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinations")
@RunWith(Cucumber.class)
public class TestRunner {

}
