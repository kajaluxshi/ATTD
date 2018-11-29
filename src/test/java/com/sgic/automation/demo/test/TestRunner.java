package com.sgic.automation.demo.test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features = {"src/test/resources/features/"},
    glue = {"com.sgic.automation.demo.steps"},
    tags = {"@Login"} // we can run multiple tags also for that we can just add comma and add the another tag {"@1,@2,@3"} 
//    strict = true
//plugin = { "pretty", "html:target/cucumber-reports"},
//  monochrome = true,
//  
)
@RunWith(Cucumber.class)
public class TestRunner {

}
