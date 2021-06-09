package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ConnectionSettings.class)
public class FeedbackClientConfiguration {

    @Autowired
    ConnectionSettings connectionSettings;

}
