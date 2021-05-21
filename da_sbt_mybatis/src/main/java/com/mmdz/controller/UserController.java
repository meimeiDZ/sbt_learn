package com.mmdz.controller;

import com.mmdz.dao.UserMapper;
import com.mmdz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: MMDZ
 * @Date: 2021/5/21
 * @Desc:
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    //http://localhost:8081/getUser?username=l4
    @RequestMapping("/getUser")
    public String getUser(String username){
        User user = userMapper.findUserByUsername(username);
        return user!=null ? username+"的密码是："+user.getUser_password():"不存在用户名为"+username+"的用户";
    }

    //http://localhost:8081/updateUser?username=w5&password=123
    @RequestMapping("/updateUser")
    public String updateUser(String password,String username){
        User user = new User(username,password);
        userMapper.updateUserByUsername(user);
        return "success!";
    }

    //http://localhost:8081/addUser?username=m6&password=123
    @RequestMapping("/addUser")
    public String addUser(String username,String password){
        User user = new User(username,password);
        userMapper.saveUser(user);
        return "success!";
    }

    //http://localhost:8081/deleteUser?username=z3
    @RequestMapping("/deleteUser")
    public String deleteUser(String username){
        userMapper.deleteUserByUsername(username);
        return "success!";
    }

    //http://localhost:8081/getUserList
    @RequestMapping("/getUserList")
    public List getUserList(String username, String password){
        return userMapper.getUserList();
    }

}
