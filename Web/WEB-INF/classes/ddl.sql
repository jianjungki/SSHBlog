drop database myssh;
create database if not exists myssh;
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `uname` varchar(30) NOT NULL COMMENT '用户名',
  `sex` varchar(10) NOT NULL DEFAULT 'male',
  `password` varchar(20) NOT NULL,
  `telphone` varchar(15) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uname` (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';
insert into userinfo values(1,'zhangsan','female','123','12334312312','广东省深圳市');