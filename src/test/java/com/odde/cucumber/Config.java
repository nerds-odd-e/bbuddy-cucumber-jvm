package com.odde.cucumber;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonEncoder;

@CucumberContextConfiguration
@SpringBootTest
@EnableFeignClients(basePackages = {"com.odde.cucumber"})
public class Config {
    @Configuration
    @EnableAutoConfiguration
    public static class Feign implements RequestInterceptor {
        public static String authorization = "";
        @Override
        public void apply(RequestTemplate template) {
            template.header("Authorization", authorization);
        }
    }
}
