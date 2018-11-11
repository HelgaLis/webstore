drop table products if exists;

create table products(
ID varchar(25) primary key,
NAME varchar(50),
DESCRIPTION varchar(250),
UNIT_PRICE decimal,
MANUFACTURER varchar(50),
CATEGORY varchar(50),
CONDITION varchar(50),
UNITS_IN_STOCK bigint,
UNITS_IN_ORDER bigint,
DISCONTINUED boolean
);

drop table customers if exists;

create table customers(
ID varchar(25) primary key,
NAME varchar(50),
ORDERS_COUNT int,
ADDRESS varchar(100),
);
