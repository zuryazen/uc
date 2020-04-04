create table role
(
    id     int auto_increment
        primary key,
    name   varchar(128) null,
    description varchar(32) null
);

-- vistual data
INSERT INTO admin_user.role (id, name, description) VALUES (1, 'admin', '普通管理员');
INSERT INTO admin_user.role (id, name, description) VALUES (2, 'root', '超级管理员');
INSERT INTO admin_user.role (id, name, description) VALUES (3, 'editor', '审核人员');