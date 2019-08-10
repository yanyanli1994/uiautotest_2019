package com.netease.AcFunTest.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
        features = "src/test/features/first_cucumber.feature",
        format = {"pretty",
                "html:target/site/cucumber-pretty",
                "rerun:target/cucumberjson.json"
        },
        tags = {"~@p2"},
        glue = {"com.steps"}
)
public class RunTest extends AbstractTestNGCucumberTests{

}

