create database truyum;
use truyum;

create table MenuItems (
menu_item_id int auto_increment primary key,
menu_item_name varchar(30) not null,
menu_item_price decimal(10,2) not null,
menu_item_active enum("Yes","No") not null,
menu_item_dateOfLaunch date not null,
menu_item_category varchar(30) not null,
menu_item_freeDelivery enum("Yes","No") not null
);

create table Users (
user_id int auto_increment primary key,
user_first_name varchar(30) not null,
user_last_name varchar(30) default null
);

create table Cart (
cart_user_id int,
cart_item_id int,
constraint primary key(cart_user_id,cart_item_id),
foreign key (cart_user_id) references Users(user_id),
foreign key (cart_item_id) references MenuItems(menu_item_id)
);