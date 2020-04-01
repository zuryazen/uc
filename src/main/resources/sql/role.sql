create table role
(
    id     int auto_increment
        primary key,
    name   varchar(128) null,
    `desc` varchar(32) null
);

alter table role change `desc` description varchar(32) null;