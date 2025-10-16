package com.example.proxy_payments_openfeign.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
//abilita il client apenfeign scansionando
@EnableFeignClients(basePackages = "com.example.proxy_payments_openfeign.proxy")
public class ProjectConfig {
}
