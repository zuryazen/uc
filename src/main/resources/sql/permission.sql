create table permission
(
	id int auto_increment,
	name varchar(128) null,
	url varchar(128) null,
	constraint permission_pk
		primary key (id)
);

-- vistual data
INSERT INTO admin_user.permission (id, name, url) VALUES (1, 'video_update', '/api/video/udpate');
INSERT INTO admin_user.permission (id, name, url) VALUES (2, 'video_delete', '/api/video/delete');
INSERT INTO admin_user.permission (id, name, url) VALUES (3, 'video_add', '/api/video/add');
INSERT INTO admin_user.permission (id, name, url) VALUES (4, 'order_list', '/api/order/list');
INSERT INTO admin_user.permission (id, name, url) VALUES (5, 'user_list', '/api/user/list');