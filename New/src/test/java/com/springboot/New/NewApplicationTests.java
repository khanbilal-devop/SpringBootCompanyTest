package com.springboot.New;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
class NewApplicationTests {
    
@Autowired
private Environment env;    // Environment Object containts the port number

 public String serverPort()
    {
   return "it is runing on"+(env.getProperty("local.server.port"));
    }
	@Test
	void contextLoads() {
	}

}
