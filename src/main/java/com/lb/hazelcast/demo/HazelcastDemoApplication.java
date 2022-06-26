package com.lb.hazelcast.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class HazelcastDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(HazelcastDemoApplication.class, args);
	}
}
