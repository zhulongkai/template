package com.zlk.web.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com")
@ImportResource({"classpath:dubbo/provider.xml"})
public class WebManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebManagerApplication.class, args);
    }

}
