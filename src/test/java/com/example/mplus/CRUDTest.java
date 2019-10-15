package com.example.mplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mplus.entity.User;
import com.example.mplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDTest {

    @Autowired
    private UserMapper userMapper;

    //插入
    @Test
    public void insertTest(){
        User user = new User();
        user.setName("xxxxxx");
        user.setAge(18);
        user.setEmail("1612820162@qq.com");

        int result = userMapper.insert(user);
        System.out.println(result);
    }

    //更新
    @Test
    public void updateByIdTest(){
        User user = new User();
        user.setId(1183928430226903042L);
        user.setAge(18);

        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    //通过ID查询（实际操作是新建一个实体类对象，给对象的id赋值，然后将对象传进查询方法中）
    @Test
    public void selectByIdTest(){
        User user = new User();
        user = userMapper.selectById(2L);
        System.out.println(user);
    }

    //根据一个ID的List列表批量查询
    @Test
    public void selectBatchIdsTest(){
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        userList.forEach(System.out::println);
    }

    //条件查询（局限性较大,只能精确匹配，用=号，不能用like、大于小于之类的模糊查询）
    @Test
    public void selectByMapTest(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", 22);

        List<User> userList = userMapper.selectByMap(map);
        userList.forEach(System.out::println);
    }

    //分页查询
    @Test
    public void selectPageTest(){
        Page<User> page = new Page<>(2, 5);
        IPage<User> userIPage = userMapper.selectPage(page, null);

        long current = userIPage.getCurrent();//当前页码
        long pages = userIPage.getPages();//总页数
        long size = userIPage.getSize();//每页记录数
        long total = userIPage.getTotal();//总记录数

        System.out.println("当前页码："+current);
        System.out.println("总页数："+pages);
        System.out.println("每页记录数："+size);
        System.out.println("总记录数："+total);

        List<User> userList = userIPage.getRecords();
        userList.forEach(System.out::println);
    }

    //根据ID删除（逻辑删除的语句在配置好之后和正常删除一样）
    @Test
    public void deleteByIdTest(){
        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }

    //根据条件删除
    @Test
    public void deleteByMapTest(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("age", 28);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    //根据一个ID的List列表批量删除
    @Test
    public void deleteBatchIds(){
        int result = userMapper.deleteBatchIds(Arrays.asList(1183929154197360642L, 1183928759832125442L, 1183928430226903042L));
        System.out.println(result);
    }

}
