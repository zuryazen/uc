create table user_role
(
	id int auto_increment,
	role_id int null,
	user_id int null,
	remark varchar(64) null,
	constraint user_role_pk
		primary key (id)
);
