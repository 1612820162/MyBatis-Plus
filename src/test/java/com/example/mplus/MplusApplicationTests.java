package com.example.mplus;

import com.example.mplus.entity.User;
import com.example.mplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testOptimisticLocker(){
        //必须先查询，拿到version
        User user=userMapper.selectById(2L);
        //修改
        user.setAge(22);
        //执行更新
        int result = userMapper.updateById(user);
        System.out.println(result);
    }
}
