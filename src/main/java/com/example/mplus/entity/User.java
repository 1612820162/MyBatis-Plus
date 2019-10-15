package com.example.mplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    //让其自动生成id的格式，不加注解会自动生成一个随机的19位的Long整型id
    //@TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String email;

    //自动填充插入时的时间（需要新建类实现MetaObjectHandler并在里面编写填充的逻辑）
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //自动填充插入以及修改时的时间（需要新建类实现MetaObjectHandler并在里面编写填充的逻辑）
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //乐观锁的注解
    @Version
    private Integer version;

    //逻辑删除的字段
    @TableLogic
    private Integer deleted;
}