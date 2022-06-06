package com.odde.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@CucumberContextConfiguration
public class Config {
    @TestConfiguration
    @ComponentScan("com.odde.cucumber")
    public static  class Configuration {

    }
}
