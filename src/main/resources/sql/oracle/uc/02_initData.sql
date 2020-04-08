-- T_BASE_DICT_GROUP
INSERT INTO T_BASE_DICT_GROUP (ID, NAME, KEY, SORT, DESCRIPTION, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('1', '性别', 'SEX', 1, null, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_GROUP (ID, NAME, KEY, SORT, DESCRIPTION, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('2', '专业', 'PROFESSIONAL', 2, null, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_GROUP (ID, NAME, KEY, SORT, DESCRIPTION, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('33', '字段类型', 'MYSQL_COLUMN_TYPE', 7, null, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_GROUP (ID, NAME, KEY, SORT, DESCRIPTION, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('32', '实体属性类型', 'ENTITY_FIELD_TYPE', 6, null, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_GROUP (ID, NAME, KEY, SORT, DESCRIPTION, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('31', '通用（0: 否； 1: 是）', 'COMMON_YES_NO', 4, null, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_GROUP (ID, NAME, KEY, SORT, DESCRIPTION, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('30', '数据库类型', 'DB_TYPE', 3, null, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_GROUP (ID, NAME, KEY, SORT, DESCRIPTION, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('34', '生成文件类型', 'FILE_TYPE', 8, null, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_GROUP (ID, NAME, KEY, SORT, DESCRIPTION, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('04B2CFDB42CD4C559480BFBE220841D6', '资源类型', 'RESOURCE_TYPE', 10, null, null, null, null, null, null, null, null, null, null, 0);

-- T_BASE_DICT_ITEM
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('1', '1', null, '男', '1', null, null, 1, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('2', '1', null, '女', '2', null, null, 2, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('10', '30', null, 'oracle', '1', null, null, 1, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('11', '30', null, 'mysql', '2', null, null, 2, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('12', '30', null, 'postgreSql', '3', null, null, 3, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('13', '30', null, 'sqlServer', '4', null, null, 4, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('14', '31', null, '否', '0', null, null, 1, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('15', '31', null, '是', '1', null, null, 2, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('16', '32', null, 'String', 'String', null, null, 1, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('17', '32', null, 'Integer', 'Integer', null, null, 2, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('18', '32', null, 'Long', 'Long', null, null, 3, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('19', '32', null, 'Double', 'Double', null, null, 4, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('20', '33', null, 'VARCHAR', 'VARCHAR', null, null, 1, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('21', '33', null, 'BIGINT', 'BIGINT', null, null, 2, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('22', '33', null, 'INTEGER', 'INTEGER', null, null, 3, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('23', '33', null, 'DATE', 'DATE', null, null, 4, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('24', '33', null, 'DATETIME', 'DATETIME', null, null, 5, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('25', '33', null, 'CHAR', 'CHAR', null, null, 6, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('26', '34', null, '实体', 'ENTITY', null, null, 1, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('27', '34', null, '服务层接口', 'SERVICE', null, null, 2, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('28', '34', null, 'mapper接口', 'MAPPER', null, null, 3, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('29', '34', null, 'mapper xml', 'MAPPER_XML', null, null, 4, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('30', '34', null, '服务层实现', 'SERVICE_IMPL', null, null, 5, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('31', '34', null, '控制层', 'CONTROLLER', null, null, 6, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('32', '34', null, 'javascript', 'JS', null, null, 7, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('33', '34', null, 'jsp', 'JSP', null, null, 8, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('34', '33', null, 'TINYINT', 'TINYINT', null, null, 7, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('35', '33', null, 'INT', 'INT', null, null, 8, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('36', '33', null, 'VARCHAR2', 'VARCHAR2', null, null, 9, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('13FD86FA00EF48E1A89D1D23E1D84A83', '33', null, 'NUMBER', 'NUMBER', null, null, 10, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('2CBCE2F4BDD149D094B70AE1037A7F54', '04B2CFDB42CD4C559480BFBE220841D6', null, '菜单', '1', null, null, 1, null, null, null, null, null, null, null, null, null, 0);
INSERT INTO T_BASE_DICT_ITEM (ID, GROUP_ID, KEY, NAME, VALUE, PID, DESCRIPTION, SORT, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('6DC515C803B846E8B23CF8B68C9CA3EC', '04B2CFDB42CD4C559480BFBE220841D6', null, '操作', '2', null, '也称为按钮级权限', 2, null, null, null, null, null, null, null, null, null, 0);


-- T_BASE_ORG
INSERT INTO T_BASE_ORG (ID, PID, FULL_NAME, SIMPLE_NAME, CODE, PHONE, BUILD_DATE, SORT, REMARKS) VALUES ('CDC53286176D481884ABCF1B7B0945A9', 'R', 'zzz设计公司', 'zzz设计公司', '1001', '0526-12379991293', TO_DATE('2018-04-09 13:27:41', 'YYYY-MM-DD HH24:MI:SS'), 0, 'zzz设计总公司');
INSERT INTO T_BASE_ORG (ID, PID, FULL_NAME, SIMPLE_NAME, CODE, PHONE, BUILD_DATE, SORT, REMARKS) VALUES ('C1D9707A31CB481FA2DC763117755870', 'CDC53286176D481884ABCF1B7B0945A9', '南京zzz设计', '南京zzz设计', '1009', 'xxxx-xxxxxxxx', TO_DATE('2018-04-09 13:27:41', 'YYYY-MM-DD HH24:MI:SS'), 0, '南京zzz设计分公司');
INSERT INTO T_BASE_ORG (ID, PID, FULL_NAME, SIMPLE_NAME, CODE, PHONE, BUILD_DATE, SORT, REMARKS) VALUES ('DA464BF6CEC74916A2611BA67A3B04C0', 'C1D9707A31CB481FA2DC763117755870', '营销部', '营销部', '1003', 'xxxx-xxxxxxxx', TO_DATE('2018-04-09 13:27:41', 'YYYY-MM-DD HH24:MI:SS'), 0, '南京zzz-营销部');
INSERT INTO T_BASE_ORG (ID, PID, FULL_NAME, SIMPLE_NAME, CODE, PHONE, BUILD_DATE, SORT, REMARKS) VALUES ('E8232442749B4A378E4F9AB9F8EE0CD2', 'C1D9707A31CB481FA2DC763117755870', '技术部', '技术部', '1004', 'xxxx-xxxxxxxx', TO_DATE('2018-04-09 13:27:41', 'YYYY-MM-DD HH24:MI:SS'), 0, '南京zzz-技术部');
INSERT INTO T_BASE_ORG (ID, PID, FULL_NAME, SIMPLE_NAME, CODE, PHONE, BUILD_DATE, SORT, REMARKS) VALUES ('R', '-1', 'ROOT_ORG', 'ROOT_ORG', '0000', null, TO_DATE('2018-04-09 13:27:41', 'YYYY-MM-DD HH24:MI:SS'), 0, '根组织，只有root用户，用于系统初始化');

-- T_BASE_USER
INSERT INTO T_BASE_USER (ID, USERNAME, PASSWORD, SALT, FULL_NAME, BIRTHDAY, SEX, ICON, EMAIL, PHONE, ADDRESS, STATUS, SORT, REMARKS) VALUES ('EF35357D34C748708268A9818DAF00EC', 'zhuyz', 'c4ca4238a0b923820dcc509a6f75849b', '1', '祝友政', TO_DATE('2018-04-09 13:18:04', 'YYYY-MM-DD HH24:MI:SS'), 1, null, null, null, null, 2, 1, null);
INSERT INTO T_BASE_USER (ID, USERNAME, PASSWORD, SALT, FULL_NAME, BIRTHDAY, SEX, ICON, EMAIL, PHONE, ADDRESS, STATUS, SORT, REMARKS) VALUES ('92439DDC5B9F4843AAAADCAFEB77FB57', 'admin', 'c4ca4238a0b923820dcc509a6f75849b', null, '管理员', null, 1, null, null, null, null, null, 2, null);
INSERT INTO T_BASE_USER (ID, USERNAME, PASSWORD, SALT, FULL_NAME, BIRTHDAY, SEX, ICON, EMAIL, PHONE, ADDRESS, STATUS, SORT, REMARKS) VALUES ('R', 'root', 'c4ca4238a0b923820dcc509a6f75849b', null, 'root', null, 1, null, null, null, null, 2, 1, '系统root用户');

-- T_BASE_ORG_USER
INSERT INTO T_BASE_ORG_USER (ORG_ID, USER_ID) VALUES ('CDC53286176D481884ABCF1B7B0945A9', '92439DDC5B9F4843AAAADCAFEB77FB57');
INSERT INTO T_BASE_ORG_USER (ORG_ID, USER_ID) VALUES ('CDC53286176D481884ABCF1B7B0945A9', 'A6ADF2AE2FF8440A839D8B06A34121DF');
INSERT INTO T_BASE_ORG_USER (ORG_ID, USER_ID) VALUES ('CDC53286176D481884ABCF1B7B0945A9', 'E68305EB6605426A8DD98C9735642EAF');
INSERT INTO T_BASE_ORG_USER (ORG_ID, USER_ID) VALUES ('CDC53286176D481884ABCF1B7B0945A9', 'EC3E5CEB52D64E0685E2020168647CBA');
INSERT INTO T_BASE_ORG_USER (ORG_ID, USER_ID) VALUES ('E8232442749B4A378E4F9AB9F8EE0CD2', 'EF35357D34C748708268A9818DAF00EC');
INSERT INTO T_BASE_ORG_USER (ORG_ID, USER_ID) VALUES ('R', 'R');

-- T_BASE_ROLE
INSERT INTO T_BASE_ROLE (ID, NAME, CODE, ENABLED, ORG_ID, SORT, REMARKS) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '超级管理员', '100', 1, 'CDC53286176D481884ABCF1B7B0945A9', 2, '系统超级管理员，是开发单位使用的角色，用于代码生成器，API生成器等。');
INSERT INTO T_BASE_ROLE (ID, NAME, CODE, ENABLED, ORG_ID, SORT, REMARKS) VALUES ('R', 'ROOT', '000', 1, 'R', 0, 'ROOT角色，系统初始化，授权');


-- T_BASE_RESOURCE
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('FD0815F2BF2C438B9920C23D852F210D', '定时任务', '29A43DB0286E452786C2A072D70C8189', '1', '/schedules', 'schedule', 1, 10, '调度任务列表，系统通用定时任务功能', 'uc');
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('703CF09B52FE4738A42C31A6B41785C5', '基础信息', '-1', '1', null, null, 1, 1, '本菜单是基础信息系统的顶级菜单。', null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('9D257F7814F1478093357C90161D76CB', '机构管理', '29A43DB0286E452786C2A072D70C8189', '1', '/sys/orgs', 'org:view', 1, 1, null, 'uc');
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('ABF43161B0DC412799F07AFE5E11A2E5', '机构管理-新增', '9D257F7814F1478093357C90161D76CB', '2', null, 'org:add', 1, 1, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('203B28E8CCE44AB8BB0B54FDB18CD987', '机构管理-修改', '9D257F7814F1478093357C90161D76CB', '2', null, 'org:update', 1, 2, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('D9FD0B68A4D447BCADEA9218DFE392B6', '机构管理-删除', '9D257F7814F1478093357C90161D76CB', '2', null, 'org:delete', 1, 3, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('29A43DB0286E452786C2A072D70C8189', '系统管理', '703CF09B52FE4738A42C31A6B41785C5', '1', null, null, 1, 1, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('DEE9E8FCD63849CBBCED930E1462F736', '用户管理', '29A43DB0286E452786C2A072D70C8189', '1', '/sys/users', 'user:view', 1, 2, null, 'uc');
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('C0F456801F4442D88325CB9BAD1EC28E', '用户管理-新增', 'DEE9E8FCD63849CBBCED930E1462F736', '2', null, 'user:add', 1, 1, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('62B5ED0D93F545EB904B500343D3B809', '用户管理-修改', 'DEE9E8FCD63849CBBCED930E1462F736', '2', null, 'user:update', 1, 2, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('021949CE211D4D6684DBF17FE72B4309', '用户管理-删除', 'DEE9E8FCD63849CBBCED930E1462F736', '2', null, 'user:delete', 1, 3, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('FD1449D85C784834AF63F4D85698884C', '资源管理', '29A43DB0286E452786C2A072D70C8189', '1', '/sys/resources', 'resource:view', 1, 3, null, 'uc');
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('375348D22AF046F4856E694E42FCC123', '资源管理-新增', 'FD1449D85C784834AF63F4D85698884C', '2', null, 'resource:add', 1, 1, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('4E9D1E44D73047AC8AF5BCE4D30DDA09', '资源管理-修改', 'FD1449D85C784834AF63F4D85698884C', '2', null, 'resource:update', 1, 2, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('BD1ABA4CBCF244CB9FA63DF5E7CFFD56', '资源管理-删除', 'FD1449D85C784834AF63F4D85698884C', '2', null, 'resource:delete', 1, 3, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('421A4A5D43574E16BF69019D4A5A9FE9', '角色管理', '29A43DB0286E452786C2A072D70C8189', '1', '/sys/roles', 'role:view', 1, 4, null, 'uc');
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('D61E1C600D8F41BCA6B5A654E25EACB8', '角色管理-新增', '421A4A5D43574E16BF69019D4A5A9FE9', '2', null, 'role:add', 1, 1, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('733DC43C78AA4725A311A8A0D3B58099', '角色管理-修改', '421A4A5D43574E16BF69019D4A5A9FE9', '2', null, 'role:update', 1, 2, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('D0A1614DD0E144678527F0AD93C045C8', '角色管理-角色删除', '421A4A5D43574E16BF69019D4A5A9FE9', '2', null, 'role:delete', 1, 3, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('0F6C698CB78B414B9E83EF98091ACE95', '服务器管理', '29A43DB0286E452786C2A072D70C8189', '1', '/sys/servers', 'server:view', 1, 7, null, 'uc');
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('C5EABC4494A446A7AF0BDFC32618CD73', '字典管理', '29A43DB0286E452786C2A072D70C8189', '1', '/sys/dicts', 'dict:view', 1, 5, null, 'uc');
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('7CC7E0797C0648B295935DF41DCDCE25', '字典管理-新增', 'C5EABC4494A446A7AF0BDFC32618CD73', '2', null, 'dict:add', 1, 1, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('99F13F03938447A7B09A6845010BD5BA', '字典管理-修改', 'C5EABC4494A446A7AF0BDFC32618CD73', '2', null, 'dict:update', 1, 2, null, null);
INSERT INTO T_BASE_RESOURCE (ID, NAME, PID, TYPE, URI, PERMISSION, ENABLED, SORT, REMARKS, PROJECT_NO) VALUES ('79D7574DCE0D40ACBBDB39E8E822CE30', '字典管理-删除', 'C5EABC4494A446A7AF0BDFC32618CD73', '2', null, 'dict:delete', 1, 3, null, null);


-- T_BASE_ROLE_RESOURCE
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '021949CE211D4D6684DBF17FE72B4309');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '021949CE211D4D6684DBF17FE72B4309');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '0F6C698CB78B414B9E83EF98091ACE95');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '203B28E8CCE44AB8BB0B54FDB18CD987');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '203B28E8CCE44AB8BB0B54FDB18CD987');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '29A43DB0286E452786C2A072D70C8189');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '29A43DB0286E452786C2A072D70C8189');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '375348D22AF046F4856E694E42FCC123');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '375348D22AF046F4856E694E42FCC123');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '421A4A5D43574E16BF69019D4A5A9FE9');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '421A4A5D43574E16BF69019D4A5A9FE9');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '4E9D1E44D73047AC8AF5BCE4D30DDA09');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '4E9D1E44D73047AC8AF5BCE4D30DDA09');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '62B5ED0D93F545EB904B500343D3B809');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '62B5ED0D93F545EB904B500343D3B809');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '703CF09B52FE4738A42C31A6B41785C5');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '703CF09B52FE4738A42C31A6B41785C5');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '733DC43C78AA4725A311A8A0D3B58099');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '733DC43C78AA4725A311A8A0D3B58099');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '79D7574DCE0D40ACBBDB39E8E822CE30');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '79D7574DCE0D40ACBBDB39E8E822CE30');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '7CC7E0797C0648B295935DF41DCDCE25');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '7CC7E0797C0648B295935DF41DCDCE25');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '99F13F03938447A7B09A6845010BD5BA');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '99F13F03938447A7B09A6845010BD5BA');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', '9D257F7814F1478093357C90161D76CB');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', '9D257F7814F1478093357C90161D76CB');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', 'ABF43161B0DC412799F07AFE5E11A2E5');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', 'ABF43161B0DC412799F07AFE5E11A2E5');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', 'BD1ABA4CBCF244CB9FA63DF5E7CFFD56');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', 'BD1ABA4CBCF244CB9FA63DF5E7CFFD56');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', 'C0F456801F4442D88325CB9BAD1EC28E');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', 'C0F456801F4442D88325CB9BAD1EC28E');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', 'C5EABC4494A446A7AF0BDFC32618CD73');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', 'C5EABC4494A446A7AF0BDFC32618CD73');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', 'D0A1614DD0E144678527F0AD93C045C8');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', 'D0A1614DD0E144678527F0AD93C045C8');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', 'D61E1C600D8F41BCA6B5A654E25EACB8');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', 'D61E1C600D8F41BCA6B5A654E25EACB8');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', 'D9FD0B68A4D447BCADEA9218DFE392B6');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', 'D9FD0B68A4D447BCADEA9218DFE392B6');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', 'DEE9E8FCD63849CBBCED930E1462F736');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', 'DEE9E8FCD63849CBBCED930E1462F736');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', 'FD0815F2BF2C438B9920C23D852F210D');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('E3C546AA426B4F68BF669808E22F1ED8', 'FD1449D85C784834AF63F4D85698884C');
INSERT INTO T_BASE_ROLE_RESOURCE (ROLE_ID, RESOURCE_ID) VALUES ('R', 'FD1449D85C784834AF63F4D85698884C');

-- T_BASE_USER_ROLE
INSERT INTO T_BASE_USER_ROLE (USER_ID, ROLE_ID) VALUES ('92439DDC5B9F4843AAAADCAFEB77FB57', 'E3C546AA426B4F68BF669808E22F1ED8');
INSERT INTO T_BASE_USER_ROLE (USER_ID, ROLE_ID) VALUES ('A6ADF2AE2FF8440A839D8B06A34121DF', 'E3C546AA426B4F68BF669808E22F1ED8');
INSERT INTO T_BASE_USER_ROLE (USER_ID, ROLE_ID) VALUES ('E68305EB6605426A8DD98C9735642EAF', 'E3C546AA426B4F68BF669808E22F1ED8');
INSERT INTO T_BASE_USER_ROLE (USER_ID, ROLE_ID) VALUES ('EC3E5CEB52D64E0685E2020168647CBA', 'E3C546AA426B4F68BF669808E22F1ED8');
INSERT INTO T_BASE_USER_ROLE (USER_ID, ROLE_ID) VALUES ('EF35357D34C748708268A9818DAF00EC', 'E3C546AA426B4F68BF669808E22F1ED8');
INSERT INTO T_BASE_USER_ROLE (USER_ID, ROLE_ID) VALUES ('R', 'R');

-- T_BASE_SERVER
INSERT INTO T_BASE_SERVER (ID, SERVER_NAME, URI, PROJECT_NO, CREATE_TIME, CREATE_USER_NAME, UPDATE_TIME, UPDATE_USER_NAME, DELETE_TIME, DELETE_USER_NAME, CREATE_USER, UPDATE_USER, DELETE_USER, DELETE_FLAG) VALUES ('B2222183A6864B7FAF3F0FD38B628235', 'local', 'http://127.0.0.1:8080/uc', 'uc', null, null, null, null, null, null, null, null, null, 0);