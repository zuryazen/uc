create table role_permission
(
	id int auto_increment,
	role_id int null,
	permission_id int null,
	constraint role_permission_pk
		primary key (id)
);

-- vistual data
INSERT INTO admin_user.role_permission (id, role_id, permission_id) VALUES (1, 3, 1);
INSERT INTO admin_user.role_permission (id, role_id, permission_id) VALUES (2, 3, 2);
INSERT INTO admin_user.role_permission (id, role_id, permission_id) VALUES (3, 3, 3);
INSERT INTO admin_user.role_permission (id, role_id, permission_id) VALUES (4, 2, 1);
INSERT INTO admin_user.role_permission (id, role_id, permission_id) VALUES (5, 2, 2);
INSERT INTO admin_user.role_permission (id, role_id, permission_id) VALUES (6, 2, 3);
INSERT INTO admin_user.role_permission (id, role_id, permission_id) VALUES (7, 2, 4);
INSERT INTO admin_user.role_permission (id, role_id, permission_id) VALUES (9, 1, 1);
INSERT INTO admin_user.role_permission (id, role_id, permission_id) VALUES (10, 1, 2);