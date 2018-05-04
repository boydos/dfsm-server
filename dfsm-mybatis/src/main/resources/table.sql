
CREATE DATABASE dfsm;

USE dfsm;

CREATE TABLE IF NOT EXISTS user (
  id BIGINT UNSIGNED NOT NULL  PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  `name` CHAR(50) NOT NULL COMMENT '账号',
  `nickname` CHAR(50) NOT NULL COMMENT '昵称',
  `password` CHAR(200) NOT NULL COMMENT '密码',
  `role` TINYINT UNSIGNED NOT NULL DEFAULT 2 COMMENT '角色,0:超级管理员,1:管理员,2:普通用户',
  `is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '1：删除，2：未删除',
  `gmt_create` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间'
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS file (
  id BIGINT UNSIGNED NOT NULL  PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  `name` CHAR(50) NOT NULL COMMENT '文件名',
  `path` CHAR(200) NOT NULL COMMENT '文件路径',
  `description` CHAR(300) NOT NULL COMMENT '描述信息',
  `is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '1：删除，2：未删除',
  `gmt_create` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间'
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
