package com.CucumberRest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Bala\\study\\eclipse-workspace\\RestAssured\\src\\main\\resources\\API.feature",
				glue="com.CucumberRest")
public class RunnerClass {

}
