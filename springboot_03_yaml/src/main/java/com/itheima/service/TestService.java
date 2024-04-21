package com.itheima.service;

import com.itheima.entity.User;
import com.itheima.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class TestService {
    ExecutorService executorService1 = Executors.newSingleThreadExecutor();

    @Autowired
    private ApplicationContext applicationContext;
    @Resource
    UserRepository userRepository;
    @Autowired
    private TestService02 testService02;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test01(){
        log.info("test01");
        String name =String.valueOf( System.currentTimeMillis());
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        test02(name);
        TestService bean = applicationContext.getBean(TestService.class);
        bean.test02(name);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test02(String name){
        log.info("test02");
        User byName2 = null;
        byName2 = userRepository.findByName(name);
        log.info("byName2{}",byName2.getName());
        executorService1.submit(()->{

            try {

            } catch (Exception e) {
                log.error(e.getMessage(),e);
            }

        });
        User byName1 = userRepository.findByName(name);
        log.info("byName1{}",byName1.getName());
    }
}
