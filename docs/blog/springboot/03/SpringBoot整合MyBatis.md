# SpringBoot整合Mybatis

![](../../../_media/imgs/03/mb01.png)

介绍一下SpringBoot整合mybatis，数据库选用的是mysql。

## 项目目录 

```
java—
|---------controller	//包负责测试整合
|---------dao			//包作为数据操作层
|---------entity		//作为数据实体类

resources—
|---------mapper		//写dao层对应实现的sql
|---------mybatis		//里面是mybatis配置，包含typeAlias等等
|---------sql			//里面放的是上面写的建表数据及sql
```



## 数据库建表

```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'dalaoyang', '13');
INSERT INTO `user` VALUES (2, 'xiaoli', '123');
INSERT INTO `user` VALUES (3, 'xiaoxiongmao', '123');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
```

##  启动类 

```java
package com.dalaoyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }
}
```

##  pom文件 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.dalaoyang</groupId>
    <artifactId>springboot_mybatis</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>springboot_mybatis</name>
    <description>springboot_mybatis</description>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.9.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.1</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

##  properties文件配置 

application.properties包含了数据库配置，mybatis配置，代码如下:

```properties
##端口号
server.port=8081

##检查 mybatis 配置是否存在，一般命名为 mybatis-config.xml
mybatis.check-config-location =true
##配置文件位置
mybatis.config-location=classpath:mybatis/mybatis-config.xml
## mapper xml 文件地址
mybatis.mapper-locations=classpath*:mapper/*Mapper.xml
##日志级别
logging.level.com.yang.dao=debug

##数据库url
spring.datasource.url=jdbc:mysql://localhost:3306/demo?characterEncoding=utf8&useSSL=false
##数据库用户名
spring.datasource.username=root
##数据库密码
spring.datasource.password=123
##数据库驱动
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

##  mybatis配置文件

mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD SQL Map Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <typeAliases>
        <typeAlias alias="Integer" type="java.lang.Integer" />
        <typeAlias alias="Long" type="java.lang.Long" />
        <typeAlias alias="HashMap" type="java.util.HashMap" />
        <typeAlias alias="LinkedHashMap" type="java.util.LinkedHashMap" />
        <typeAlias alias="ArrayList" type="java.util.ArrayList" />
        <typeAlias alias="LinkedList" type="java.util.LinkedList" />
        <typeAlias alias="user" type="com.mmdz.entity.User"/>
    </typeAliases>
</configuration>
```

## 实体类User

```java
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
```

## dao

```java
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
```

## UserMapper

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.mmdz.dao.UserMapper">
    <resultMap id="user" type="com.mmdz.entity.User"/>
    <parameterMap id="user" type="com.mmdz.entity.User"/>
    <select id="findUserByUsername" parameterType="String" resultMap="user">
        SELECT * FROM user
        WHERE user_name=#{1}
    </select>

    <update id="updateUserByUsername" parameterMap="user">
        UPDATE USER SET USER_PASSWORD=#{user_password} WHERE USER_NAME=#{user_name}
    </update>

    <delete id="deleteUserByUsername" parameterType="String">
        DELETE FROM USER WHERE USER_NAME=#{1}
    </delete>

    <!-- 使用alias自定义的parameterType-->
    <insert id="saveUser" parameterType="user">
        INSERT INTO USER (user_password,user_name) VALUES (#{user_password},#{user_name})
    </insert>

    <select id="getUserList" resultMap="user">
        SELECT  * FROM USER
    </select>
</mapper>
```

##  controller 

```java
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
```

启动项目，访问controller上面对应的注释上的地址即可以测试，
其中包含了简单的增删改查，SpringBoot整合Mybatis就这样完成了。