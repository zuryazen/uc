create table permission
(
	id int auto_increment,
	name varchar(128) null,
	url varchar(128) null,
	constraint permission_pk
		primary key (id)
);