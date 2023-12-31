package com.xfnews.user.controller;

import com.xfnews.api.controller.user.HelloControllerApi;
import com.xfnews.grace.result.GraceJSONResult;
import com.xfnews.grace.result.xfnewsJSONResult;
import com.xfnews.grace.result.ResponseStatusEnum;
import com.xfnews.utils.RedisOperator;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloControllerApi {

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private RedisOperator redis;

//    Swagger2 文档生成工具
    public Object hello() {

        logger.debug("debug: hello~");
        logger.info("info: hello~");
        logger.warn("warn: hello~");
        logger.error("error: hello~");

//        return "hello";
//        return xfnewsJSONResult.ok();
//        return xfnewsJSONResult.ok("hello");
//        return xfnewsJSONResult.errorMsg("您的信息有误~！");
        return GraceJSONResult.ok();
    }

    @GetMapping("/redis")
    public Object redis() {
        redis.set("age", "18");
        return GraceJSONResult.ok(redis.get("age"));
    }

}
