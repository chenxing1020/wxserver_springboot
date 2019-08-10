create table if not exists user(
    userId varchar(32) not null,
    openId varchar(64),
    stuId varchar(16),
    name varchar(64),
    avatar varchar(128),
    campus varchar(16),
    college varchar(64),
    primary key (userId)
)default charset=utf8;