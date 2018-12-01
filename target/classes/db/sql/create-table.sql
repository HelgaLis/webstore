
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
DROP TABLE CART_ITEM IF EXISTS;
DROP TABLE CART IF EXISTS;
CREATE TABLE CART (
ID VARCHAR(50) PRIMARY KEY
);
CREATE TABLE CART_ITEM (
ID VARCHAR(75),
PRODUCT_ID VARCHAR(25) FOREIGN KEY REFERENCES
PRODUCTS(ID),
CART_ID varchar(50) FOREIGN KEY REFERENCES
CART(ID),
QUANTITY BIGINT,
CONSTRAINT CART_ITEM_PK PRIMARY KEY (ID,CART_ID)
);