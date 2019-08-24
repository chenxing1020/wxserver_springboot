--用户信息表
create table if not exists users(
    userId varchar(32) not null,
    openId varchar(64),
    stuId varchar(16),
    name varchar(64),
    avatar varchar(3000),
    campus varchar(16),
    college varchar(64),
    role integer,
    primary key (userId)
)default charset=utf8;
--商品信息表
create table if not exists goods(
    goodsId varchar(32) not null,
    userId varchar(32) not null,
    category varchar(64),
    title varchar(128),
    description varchar(128),
    price double,
    originalPrice double,
    createAt datetime,
    primary key(goodsId)
)default charset=utf8;
--图片表
create table if not exists images(
    imageId varchar(32) not null,
    imgUrl varchar(128),
    primary key(imageId)
)default charset=utf8;
--商品图片
create table if not exists goodimages(
    goodsId varchar(32) not null,
    imageId varchar(32) not null
)default charset=utf8;
--商品收藏信息
create table if not exists favors(
    id varchar(32) not null,
    goodsId varchar(32) not null,
    userId varchar(32) not null,
    createAt datetime,
    primary key (id),
    foreign key(goodsId) references goods(goodsId),
    foreign key(userId) references users(userId)
)default charset=utf8;
--评论表
create table if not exists comments(
    commentId varchar(32) not null,
    goodsId varchar(32) not null,
    userId varchar(32) not null,
    parentId varchar(32),
    comment varchar(128),
    createAt datetime,
    primary key(commentId),
    foreign key(goodsId) references goods(goodsId),
    foreign key (userId) references users(userId)
)default charset=utf8;