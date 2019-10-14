package com.example.mplus;

import com.example.mplus.entity.User;
import com.example.mplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest(){
        User user = new User();
        user.setName("xxxxxx");
        user.setAge(18);
        user.setEmail("1612820162@qq.com");

        int result = userMapper.insert(user);
        System.out.println(result);
    }
}
