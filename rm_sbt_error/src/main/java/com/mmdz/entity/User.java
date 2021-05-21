package com.mmdz.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: MMDZ
 * @Date: 2021/5/20
 * @Desc:
 */
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private Integer age;

    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
