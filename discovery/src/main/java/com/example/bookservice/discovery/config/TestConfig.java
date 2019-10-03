package com.example.bookservice.discovery.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "custom", configuration = CustomConfiguration.class)
public class TestConfig {
}
