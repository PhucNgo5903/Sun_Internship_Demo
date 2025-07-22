package com.example.SpringCorePractice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.example.SpringCorePractice")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class AppConfig {
}