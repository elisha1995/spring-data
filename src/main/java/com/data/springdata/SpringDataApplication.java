package com.data.springdata;

import com.data.springdata.model.*;
import com.data.springdata.services.MongoService;
import com.data.springdata.services.RedisService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Bean
    public CommandLineRunner seedRedisData(RedisService redisService) {
        return args -> {
            // Check if data already exists
            if (redisService.getAllEmployees().isEmpty()) {
                System.out.println("Seeding Redis with sample data...");

                // Create and save sample RedisEmployee objects
                RedisEmployee employee1 = new RedisEmployee(
                        "RE001", "RE001", "Smith", "John",
                        "123 Main St", "555-1234", "DOCTOR",
                        "Cardiology", null
                );
                redisService.createEmployee(employee1);

                RedisEmployee employee2 = new RedisEmployee(
                        "RE002", "RE002", "Johnson", "Emily",
                        "456 Elm St", "555-5678", "NURSE",
                        null, "Day"
                );
                redisService.createEmployee(employee2);

                RedisEmployee employee3 = new RedisEmployee(
                        "RE003", "RE003", "Brown", "Michael",
                        "789 Oak St", "555-9012", "DOCTOR",
                        "Pediatrics", null
                );
                redisService.createEmployee(employee3);

                RedisEmployee employee4 = new RedisEmployee(
                        "RE004", "RE004", "Davis", "Sarah",
                        "101 Pine St", "555-3456", "NURSE",
                        null, "Night"
                );
                redisService.createEmployee(employee4);

                RedisEmployee employee5 = new RedisEmployee(
                        "RE005", "RE005", "Wilson", "David",
                        "202 Maple St", "555-7890", "DOCTOR",
                        "Orthopedics", null
                );
                redisService.createEmployee(employee5);

                System.out.println("Redis seeding completed.");
            } else {
                System.out.println("Redis already contains data, skipping seeding.");
            }
        };
    }
}
