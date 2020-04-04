create table user_role
(
	id int auto_increment,
	role_id int null,
	user_id int null,
	remark varchar(64) null,
	constraint user_role_pk
		primary key (id)
);

-- vistual data
INSERT INTO admin_user.user_role (id, role_id, user_id, remark) VALUES (1, 3, 1, 'zhuyz1是editor');
INSERT INTO admin_user.user_role (id, role_id, user_id, remark) VALUES (2, 1, 3, 'zhuyz3是admin');
INSERT INTO admin_user.user_role (id, role_id, user_id, remark) VALUES (3, 2, 3, 'zhuyz3是root');
INSERT INTO admin_user.user_role (id, role_id, user_id, remark) VALUES (4, 3, 3, 'zhuyz3是editor');
INSERT INTO admin_user.user_role (id, role_id, user_id, remark) VALUES (5, 1, 2, 'zhuyz2是admin');