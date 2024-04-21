package com.itheima.controller;

import com.itheima.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Rest模式
@RestController
@Slf4j
public class BookController {

    @Resource
            private TestService testService;
     ExecutorService executorService = Executors.newSingleThreadExecutor();


    @GetMapping(value = "/test01")
    public String test01(){
        testService.test01();
        return "springboot is running...";
    }

}
