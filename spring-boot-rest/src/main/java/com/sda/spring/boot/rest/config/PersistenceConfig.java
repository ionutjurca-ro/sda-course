package com.sda.spring.boot.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.sda.spring.boot.rest.repository"})
public class PersistenceConfig {
}
