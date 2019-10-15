package com.example.mplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

//自动填充
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    //插入的时候自动填充
    @Override
    public void insertFill(MetaObject metaObject) {

        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    //更新的时候自动填充
    @Override
    public void updateFill(MetaObject metaObject) {

        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
