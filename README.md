# Introduction

Paper [Exploit Spring Boot Actuator 之 Spring Cloud Env 学习笔记
](https://mp.weixin.qq.com/s/rGRHb5IteCDAO6IMCwst3A)

Spring Boot Actuator + Spring Cloud Vul Env for RCE by modifying `spring.cloud.bootstrap.location` in https://www.veracode.com/blog/research/exploiting-spring-boot-actuators

# Branch

- `master`: Spring Boot Actuator 1.5.22 + Spring Cloud Dalston.RELEASE
- `2.2.1-cloud`: Spring Boot Actuator 2.2.1 + Spring Cloud Hoxton.RELEASE

# Code

- `src/main/resources/payload` remote jar payload 
- `src/test/java/com/b1ngz/sec/SnakeYAMLTest.java` some tests
