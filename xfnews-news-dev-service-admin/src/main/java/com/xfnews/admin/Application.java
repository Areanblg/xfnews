package com.xfnews.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication//(exclude = MongoAutoConfiguration.class)
@MapperScan(basePackages = "com.xfnews.admin.mapper")
@ComponentScan(basePackages = {"com.xfnews", "org.n3r.idworker"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
