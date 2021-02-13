package com.springboot.New;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication(scanBasePackages = { "com.springboot.New" })
public class NewApplication {
    

	public static void main(String[] args) {
		SpringApplication.run(NewApplication.class, args);
                System.out.println("Application Started");
	}
  
}
    