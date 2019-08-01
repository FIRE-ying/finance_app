package com.qf.test;

import com.qf.mapper.UserMapper;
import com.qf.pojo.User;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 生活很好，记得微笑🙂
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class Test {
    @Resource
    private UserMapper userMapper;

    @org.junit.Test
    public void test(){
        User user=new User();
        user.setAddress("beijing");
        user.setRealname("lizhuangzhuang");

        int i = userMapper.insert(user);
        System.out.println(i);
    }
}
