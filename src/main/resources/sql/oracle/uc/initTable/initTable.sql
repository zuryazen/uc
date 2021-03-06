create table T_BASE_DICT_GROUP
(
    ID               VARCHAR2(32) default NULL not null
        primary key,
    NAME             VARCHAR2(50)              not null
        constraint T_DICT_GROUP_NAME_UINDEX
            unique,
    KEY              VARCHAR2(200)             not null
        constraint T_DICT_GROUP_KEY_UINDEX
            unique,
    SORT             NUMBER(5)                 not null
        constraint T_DICT_GROUP_SORT_UINDEX
            unique,
    DESCRIPTION      VARCHAR2(500),
    CREATE_TIME      DATE,
    CREATE_USER_NAME VARCHAR2(100),
    UPDATE_TIME      DATE,
    UPDATE_USER_NAME VARCHAR2(100),
    DELETE_TIME      DATE,
    DELETE_USER_NAME VARCHAR2(100),
    CREATE_USER      VARCHAR2(32),
    UPDATE_USER      VARCHAR2(32),
    DELETE_USER      VARCHAR2(32),
    DELETE_FLAG      NUMBER(1)    default 0    not null
)
/

create table T_BASE_DICT_ITEM
(
    ID               VARCHAR2(32) default NULL not null
        primary key,
    GROUP_ID         VARCHAR2(32) default NULL not null,
    KEY              VARCHAR2(200),
    NAME             VARCHAR2(200)             not null,
    VALUE            VARCHAR2(300)             not null,
    PID              VARCHAR2(32) default NULL,
    DESCRIPTION      VARCHAR2(500),
    SORT             NUMBER(5)                 not null,
    CREATE_TIME      DATE,
    CREATE_USER_NAME VARCHAR2(100),
    UPDATE_TIME      DATE,
    UPDATE_USER_NAME VARCHAR2(100),
    DELETE_TIME      DATE,
    DELETE_USER_NAME VARCHAR2(100),
    CREATE_USER      VARCHAR2(32),
    UPDATE_USER      VARCHAR2(32),
    DELETE_USER      VARCHAR2(32),
    DELETE_FLAG      NUMBER(1)    default 0    not null
)
/

create table T_BASE_ORG
(
    ID               VARCHAR2(32) default NULL not null
        primary key,
    PID              VARCHAR2(32) default NULL not null,
    FULL_NAME        VARCHAR2(100)             not null,
    SIMPLE_NAME      VARCHAR2(50),
    CODE             VARCHAR2(50)              not null
        constraint T_BASE_ORG_CODE_UINDEX
            unique,
    PHONE            VARCHAR2(50),
    BUILD_DATE       DATE,
    SORT             NUMBER                    not null,
    REMARKS          VARCHAR2(500),
    CREATE_TIME      DATE,
    CREATE_USER_NAME VARCHAR2(100),
    UPDATE_TIME      DATE,
    UPDATE_USER_NAME VARCHAR2(100),
    DELETE_TIME      DATE,
    DELETE_USER_NAME VARCHAR2(100),
    CREATE_USER      VARCHAR2(32),
    UPDATE_USER      VARCHAR2(32),
    DELETE_USER      VARCHAR2(32),
    DELETE_FLAG      NUMBER(1)    default 0    not null,
    ORG_LEVEL        VARCHAR2(50) default '0'  not null,
    DISTRICT         VARCHAR2(32)
)
/

create table T_BASE_ORG_USER
(
    ORG_ID  VARCHAR2(32) default NULL not null,
    USER_ID VARCHAR2(32) default NULL not null,
    primary key (ORG_ID, USER_ID)
)
/

create table T_BASE_RESOURCE
(
    ID               VARCHAR2(32) default NULL not null
        primary key,
    NAME             VARCHAR2(100)             not null,
    PID              VARCHAR2(32) default NULL not null,
    TYPE             CHAR                      not null,
    URI              VARCHAR2(200),
    PERMISSION       VARCHAR2(100),
    ENABLED          NUMBER(1)                 not null,
    SORT             NUMBER                    not null,
    REMARKS          VARCHAR2(500),
    PROJECT_NO       VARCHAR2(50),
    CREATE_TIME      DATE,
    CREATE_USER_NAME VARCHAR2(100),
    UPDATE_TIME      DATE,
    UPDATE_USER_NAME VARCHAR2(100),
    DELETE_TIME      DATE,
    DELETE_USER_NAME VARCHAR2(100),
    CREATE_USER      VARCHAR2(32),
    UPDATE_USER      VARCHAR2(32),
    DELETE_USER      VARCHAR2(32),
    DELETE_FLAG      NUMBER(1)    default 0    not null,
    ICON             VARCHAR2(64),
    COMPONENT_NAME   VARCHAR2(64)
)
/

create table T_BASE_ROLE
(
    ID               VARCHAR2(32) default NULL not null
        primary key,
    NAME             VARCHAR2(100)             not null,
    CODE             VARCHAR2(50),
    ENABLED          NUMBER(1)                 not null,
    ORG_ID           VARCHAR2(32) default NULL not null,
    SORT             NUMBER                    not null,
    REMARKS          VARCHAR2(500),
    CREATE_TIME      DATE,
    CREATE_USER_NAME VARCHAR2(100),
    UPDATE_TIME      DATE,
    UPDATE_USER_NAME VARCHAR2(100),
    DELETE_TIME      DATE,
    DELETE_USER_NAME VARCHAR2(100),
    CREATE_USER      VARCHAR2(32),
    UPDATE_USER      VARCHAR2(32),
    DELETE_USER      VARCHAR2(32),
    DELETE_FLAG      NUMBER(1)    default 0    not null
)
/

create table T_BASE_ROLE_RESOURCE
(
    ROLE_ID     VARCHAR2(32) default NULL not null,
    RESOURCE_ID VARCHAR2(32) default NULL not null,
    primary key (RESOURCE_ID, ROLE_ID)
)
/

create table T_BASE_USER
(
    ID               VARCHAR2(32)  default NULL not null
        primary key,
    USERNAME         VARCHAR2(50)               not null
        constraint T_BASE_USER_USERNAME_UINDEX
            unique,
    PASSWORD         VARCHAR2(50)               not null,
    SALT             VARCHAR2(200) default NULL,
    FULL_NAME        VARCHAR2(100)              not null,
    BIRTHDAY         DATE,
    SEX              NUMBER(1)                  not null,
    ICON             VARCHAR2(200),
    EMAIL            VARCHAR2(200),
    PHONE            VARCHAR2(100),
    ADDRESS          VARCHAR2(200),
    STATUS           NUMBER(1)     default NULL,
    SORT             NUMBER                     not null,
    REMARKS          VARCHAR2(500),
    CREATE_TIME      DATE,
    CREATE_USER_NAME VARCHAR2(100),
    UPDATE_TIME      DATE,
    UPDATE_USER_NAME VARCHAR2(100),
    DELETE_TIME      DATE,
    DELETE_USER_NAME VARCHAR2(100),
    CREATE_USER      VARCHAR2(32),
    UPDATE_USER      VARCHAR2(32),
    DELETE_USER      VARCHAR2(32),
    DELETE_FLAG      NUMBER(1)     default 0    not null,
    DISTRICT         VARCHAR2(32)
)
/

create table T_BASE_USER_ROLE
(
    USER_ID VARCHAR2(32) default NULL not null,
    ROLE_ID VARCHAR2(32) default NULL not null,
    primary key (ROLE_ID, USER_ID)
)
/

create table T_BASE_SERVER
(
    ID               VARCHAR2(32)        not null
        primary key,
    SERVER_NAME      VARCHAR2(50)        not null,
    URI              VARCHAR2(50)        not null,
    PROJECT_NO       VARCHAR2(50)        not null,
    CREATE_TIME      DATE,
    CREATE_USER_NAME VARCHAR2(100),
    UPDATE_TIME      DATE,
    UPDATE_USER_NAME VARCHAR2(100),
    DELETE_TIME      DATE,
    DELETE_USER_NAME VARCHAR2(100),
    CREATE_USER      VARCHAR2(32),
    UPDATE_USER      VARCHAR2(32),
    DELETE_USER      VARCHAR2(32),
    DELETE_FLAG      NUMBER(1) default 0 not null
)
/

create table T_BASE_SCHEDULE_JOB
(
    ID              VARCHAR2(32) not null
        primary key,
    JOB_NAME        VARCHAR2(200),
    JOB_GROUP       VARCHAR2(200),
    JOB_STATUS      VARCHAR2(10),
    IS_CONCURRENT   VARCHAR2(10),
    CRON_EXPRESSION VARCHAR2(100),
    BEAN_CLASS      VARCHAR2(200),
    METHOD_NAME     VARCHAR2(100),
    SPRING_BEAN     VARCHAR2(200),
    DESCRIPTION     VARCHAR2(500)
)
/

create table T_BASE_FILE(
  ID VARCHAR2(32) not null,   --  文件表主键
  FILE_NAME VARCHAR2(500),   --  文件名称
  FILE_PATH VARCHAR2(500),   --  文件路径
  FILE_SUFFIX VARCHAR2(50),   --  文件后缀名
  FILE_SIZE NUMBER(20,0),   --  文件大小
  FILE_CREATE_TIME DATE,   --  文件创建时间
  FILE_UPDATE_TIME DATE,   --  文件修改时间
  CREATE_USER VARCHAR2(32),   --  登记人
  CREATE_USER_NAME VARCHAR2(100),   --  登记人姓名（冗余）
  CREATE_TIME DATE,   --  登记时间
  UPDATE_USER VARCHAR2(32),   --  变更人
  UPDATE_USER_NAME VARCHAR2(100),   --  变更人姓名（冗余）
  UPDATE_TIME DATE,   --  变更时间
  DELETE_USER VARCHAR2(32),   --  删除人
  DELETE_USER_NAME VARCHAR2(100),   --  删除人姓名（冗余）
  DELETE_TIME DATE,   --  删除时间
  DELETE_FLAG NUMBER(1) DEFAULT 0 not null,   --  删除标记（0：未删除 1：已删除）,
  Primary Key(ID)
)

  /



