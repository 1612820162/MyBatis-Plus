package com.example.mplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mplus.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author idmin
 */
//这个注解可以让Bean被注入其他类时没有报错（虽然实际上没有错也能正常运行，但是看起来很别扭）
//（产生报错的原因是我们写的UserMapper是一个接口没有被实现所以编译器在编译之前会报错，即显示那道红线）
@Repository
public interface UserMapper extends BaseMapper<User> {
}
