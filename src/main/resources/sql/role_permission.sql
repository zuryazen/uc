create table role_permission
(
	id int auto_increment,
	role_id int null,
	permission_id int null,
	constraint role_permission_pk
		primary key (id)
);
