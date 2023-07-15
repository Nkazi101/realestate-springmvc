package com.realestate.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration


@EnableJpaRepositories(basePackages = "com.realestate.repo")

@EntityScan(basePackages = "com.realestate.model")
public class ApplicationConfig {
    

}
