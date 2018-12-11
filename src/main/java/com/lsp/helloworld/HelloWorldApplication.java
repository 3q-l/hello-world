package com.lsp.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
//@MapperScan("com.lsp.helloworld.dao")
public class HelloWorldApplication {

    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(HelloWorldApplication.class);
//        springApplication.setAddCommandLineProperties(false);
        SpringApplication.run(HelloWorldApplication.class,args);

    }

    @GetMapping("hi")
    public String hi(){
        return "Hi,I'm forezp";
    }
}
