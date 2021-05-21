package com.mmdz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @Author: MMDZ
 * @Date: 2021/5/21
 * @Desc:
 */
/*  @Alias 用法：实体类直接加注解，这样Mapper.xml中的返回值就直接可以用你自己定义的别名了。  */
@Data
@AllArgsConstructor
@Alias("user")
public class User {

    private int id;
    private String user_name;
    private String user_password;

    public User(String user_name, String user_password) {
        this.user_name = user_name;
        this.user_password = user_password;
    }
}
