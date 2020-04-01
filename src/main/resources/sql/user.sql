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


