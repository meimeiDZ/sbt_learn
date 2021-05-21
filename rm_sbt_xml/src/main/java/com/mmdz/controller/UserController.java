package com.mmdz.controller;

import com.mmdz.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MMDZ
 * @Date: 2021/5/20
 * @Desc:
 */
@RestController
public class UserController {

    //http://localhost:8080/json
    @GetMapping(value = "/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public User index(){
        User user = new User("mmdz", "26", "深圳");
        return user;
    }


    //http://localhost:8080/xml
    @GetMapping(value = "/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public User XML(){
        User user = new User("mmdz", "26", "深圳");
        return user;
    }

}
