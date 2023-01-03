package org.Testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Feature\\CoinMarketCap.feature",glue="org.Stepdefinition",dryRun=true,monochrome=true,
snippets = SnippetType.CAMELCASE)
public class TestRunnerClass {

}
