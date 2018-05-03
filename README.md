#简介
>分布式文件管理系统，采用SpringBoot、MyBatis、Redis、RabbitMQ、Hadoop、MongDB，
>目的：练习分布式编程技术

#模块划分
- dfsm-sdk SDK模块
- dfsm-web 接口服务模块
- dfsm-file 文件管理模块
- dfsm-auth 权限管理模块
- dfsm-user 用户管理模块
- dfsm-mybatis 数据库操作模块

#表划分
- user
> id name nickname password role createdate modifydate

- file
> id name size path description createdate modifydate
