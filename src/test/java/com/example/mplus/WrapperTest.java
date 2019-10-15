package com.example.mplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mplus.entity.User;
import com.example.mplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    //根据条件删除
    @Test
    public void deleteTest(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .isNull("name")     //name字段为空
                .ge("age", 22)      //age>=22
                .isNotNull("email");       //email字段不为空
        int result = userMapper.delete(queryWrapper);
        System.out.println("结果："+result);
    }

    //根据条件查询某条数据
    @Test
    public void selectOneTest(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("name", "Sandy");//     "name" = "Sandy"
        User user=userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    //根据条件查询满足条件的记录数（Between包含边界）查不到逻辑删除过的记录
    @Test
    public void selectCountTest(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .between("age", 20, 30);
        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println("满足条件的总数为：" + count);
    }

    //查询满足条件的结果集合
    @Test
    public void selectListTest(){

    }

}
