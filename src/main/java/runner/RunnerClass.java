package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = { "@Test01" }, 
        features = { "src/test/java/features" },
        glue = { "stepDefinition" })

public class RunnerClass {

}
