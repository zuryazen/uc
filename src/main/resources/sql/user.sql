CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `password` varchar(50) NOT NULL,
  `address` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
commit

-- 2020/03/29 增加字段 isSwitch 用于是否启用当前用户
alter table user add isSwitch boolean default 1 not null;

-- vistual data
insert into user values (1, 'zhuyz1', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (2, 'zhuyz2', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (3, 'zhuyz3', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (4, 'zhuyz4', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (5, 'zhuyz5', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (6, 'zhuyz6', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (7, 'zhuyz7', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (8, 'zhuyz8', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (9, 'zhuyz9', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (10, 'zhuyz10', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (11, 'zhuyz11', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (12, 'zhuyz12', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (13, 'zhuyz13', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (14, 'zhuyz14', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (15, 'zhuyz15', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (16, 'zhuyz16', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (17, 'zhuyz17', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (18, 'zhuyz18', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (19, 'zhuyz19', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (20, 'zhuyz20', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (21, 'zhuyz21', '123456', 'China', 'XXX@qq.com', 1);
insert into user values (22, 'zhuyz22', '123456', 'China', 'XXX@qq.com', 1);

