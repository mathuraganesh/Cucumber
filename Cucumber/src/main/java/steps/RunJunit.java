package steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import wdMethods.SeMethods;

	@RunWith(Cucumber.class)
	@CucumberOptions(features= {"src/test/java/features/DuplicateLead.feature"}
	,glue={"pages","steps"}
	,tags= {"@smoke or @sanity or @regression"}
	,monochrome= true) 
	public class RunJunit{
		

	}



