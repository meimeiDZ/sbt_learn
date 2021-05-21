package com.mmdz.dao;

import com.mmdz.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: MMDZ
 * @Date: 2021/5/21
 * @Desc:
 */
@Mapper
public interface UserMapper {

    User findUserByUsername(String username);

    void updateUserByUsername(User user);

    void deleteUserByUsername(String username);

    void saveUser(User user);

    List<User> getUserList();

}
