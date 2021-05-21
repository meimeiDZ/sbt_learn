# SpringBoot使用数据库

> 这一篇简单介绍一下SpringBoot配置数据库的配置（依赖和application.properties）,以下全是以本地数据库为例子，具体用户名密码地址都根据实际去修改。

## Mysql数据库

pom文件：

```xml
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<scope>runtime</scope>
</dependency>
```

application.properties:

```properties
##数据库地址
spring.datasource.url=jdbc:mysql://localhost:3306/testcharacterEncoding=utf8&useSSL=false
##数据库用户名
spring.datasource.username=root
##数据库密码
spring.datasource.password=123
##数据库驱动
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

## Sql Server数据库

pom文件：

```xml
<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>mssql-jdbc</artifactId>
    <scope>runtime</scope>
</dependency>
```

application.properties:

```properties
##数据库地址
spring.datasource.url=jdbc:sqlserver://xxx.xxx.xxx.xxx:1433;databaseName=dev
##数据库用户名
spring.datasource.username=sa
##数据库密码
spring.datasource.password=123
##数据库驱动
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
```

## oracle数据库

没有找到仓库中oracle得jar 需要自己下载然后加入

application.properties:

```properties
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
spring.datasource.username=root
spring.datasource.password=123
```

## mongodb数据库

pom文件：

```xml
<dependencies>
	<dependency> 
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-data-mongodb</artifactId>
	</dependency> 
</dependencies>
```

application.properties:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/test
```

## h2数据库

pom文件：

```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

application.properties:

```properties
spring.datasource.url=jdbc:h2:file:D:/roncoo_h2/roncoo_spring_boot;AUTO_SERVER=TRUE;DBCLOSE_ON_EXIT=FALSE
spring.datasource.username=root
spring.datasource.password=123
```