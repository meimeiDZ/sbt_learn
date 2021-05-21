package com.mmdz.controller;

import com.mmdz.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: MMDZ
 * @Date: 2021/5/20
 * @Desc:
 */
@RestController
public class UserController {

    @PostMapping("/")
    public String testDemo(@RequestBody @Valid User user, BindingResult bindingResult){
        StringBuffer stringBuffer = new StringBuffer();
        // 如有任何一个错误
        if(bindingResult.hasErrors()){
            List<ObjectError> list =bindingResult.getAllErrors();
            for (ObjectError objectError:list) {
                stringBuffer.append(objectError.getDefaultMessage());
                stringBuffer.append("---");
            }
        }
        return stringBuffer!=null?stringBuffer.toString():"";
    }

}
