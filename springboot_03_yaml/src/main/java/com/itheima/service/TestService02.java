package com.itheima.service;

import com.itheima.entity.User;
import com.itheima.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class TestService02 {
    @Resource
    UserRepository userRepository;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public  void test2(String name3){

        User byName3 = userRepository.findByName(name3);
        log.info("byName2{}",byName3.getName());
    }
}
