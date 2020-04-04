CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `password` varchar(50) NOT NULL,
  `address` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
   `open` tinyint(1) default 1 not null,
   `create_time` datetime null,
   `salt` varchar(128) null
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
commit

-- vistual data
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (1, 'zhuyz1', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (2, 'zhuyz2', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (3, 'zhuyz3', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (4, 'zhuyz4', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (5, 'zhuyz5', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (6, 'zhuyz6', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (7, 'zhuyz7', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (8, 'zhuyz8', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (9, 'zhuyz9', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (10, 'zhuyz10', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (11, 'zhuyz11', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (12, 'zhuyz12', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (13, 'zhuyz13', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (14, 'zhuyz14', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (15, 'zhuyz15', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (16, 'zhuyz16', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (17, 'zhuyz17', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (18, 'zhuyz18', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (19, 'zhuyz19', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (20, 'zhuyz20', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (21, 'zhuyz21', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (22, 'zhuyz22', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);
INSERT INTO admin_user.user (id, name, password, address, email, open, create_time, salt) VALUES (23, '祝友政', '4280d89a5a03f812751f504cc10ee8a5', 'China', 'XXX@qq.com', 1, '2020-04-03 14:48:13', null);

