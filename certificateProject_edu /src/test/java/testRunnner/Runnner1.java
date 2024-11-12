package testRunnner;






import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


		@CucumberOptions(
				dryRun=false,
			    features = "src/test/resources/feautres",
			    glue = {"stepdefinitions"},
			    plugin= {"pretty","html:target/htmlReports.html"}
				)
			
	
public class Runnner1 extends AbstractTestNGCucumberTests {

}