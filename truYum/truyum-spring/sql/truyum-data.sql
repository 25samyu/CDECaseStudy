/* Using truyum database */
use truyum;

/* 1. View Menu Item List Admin (TYUC001) */
/* 1. a) Frame insert scripts to add data into menu_item table */
insert into MenuItems (menu_item_name, menu_item_price, menu_item_active, menu_item_dateOfLaunch, menu_item_category, menu_item_freeDelivery) values (
"Sandwich", 99.00, "Yes", "2017-03-15", "Main Course", "Yes");
insert into MenuItems (menu_item_name, menu_item_price, menu_item_active, menu_item_dateOfLaunch, menu_item_category, menu_item_freeDelivery) values (
"Burger", 129.00, "Yes", "2017-12-23", "Main Course", "No");
insert into MenuItems (menu_item_name, menu_item_price, menu_item_active, menu_item_dateOfLaunch, menu_item_category, menu_item_freeDelivery) values (
"Pizza", 149.00, "Yes", "2017-08-21", "Main Course", "No");
insert into MenuItems (menu_item_name, menu_item_price, menu_item_active, menu_item_dateOfLaunch, menu_item_category, menu_item_freeDelivery) values (
"French Fries", 57.00, "No", "2017-07-02", "Starters", "Yes");
insert into MenuItems (menu_item_name, menu_item_price, menu_item_active, menu_item_dateOfLaunch, menu_item_category, menu_item_freeDelivery) values (
"Chocolate Brownie", 32.00, "Yes", "2022-11-02", "Dessert", "Yes");

/* 1. b) Frame SQL query to get all menu items */
select * from MenuItems;

/* 2. View Menu Item List Customer (TYUC002) */
/* 2. a) Frame SQL query to get all menu items which after launch date and is active */
select * from MenuItems where current_timestamp()>menu_item_dateOfLaunch and menu_item_active="Yes";

/* 3. Edit Menu Item (TYUC003) */
/* 3. a) Frame SQL query to get a menu items based on Menu Item Id */
select * from MenuItems where menu_item_id=1;
select * from MenuItems where menu_item_id=2;
select * from MenuItems where menu_item_id=3;
select * from MenuItems where menu_item_id=4;
select * from MenuItems where menu_item_id=5;

/* 3. b) Frame update SQL menu_items table to update all the columns values based on Menu Item Id */
insert into MenuItems (menu_item_name, menu_item_price, menu_item_active, menu_item_dateOfLaunch, menu_item_category, menu_item_freeDelivery) values (
"Nachos Mini", 20.00, "Yes", "2022-08-25", "Dessert", "No");

update MenuItems set
menu_item_name="Nachos",
menu_item_price=50.00,
menu_item_active="No",
menu_item_dateOfLaunch="2021-10-25",
menu_item_category="Starters",
menu_item_freeDelivery="Yes"
where menu_item_id=6;

/* 4. Add to Cart (TYUC004) */
/* 4. a) Frame insert scripts for adding data into user and cart tables.
		 In user table create two users. Once user will not have any entries in cart, 
         while the other will have at least 3 items in the cart. */
insert into Users (user_first_name, user_last_name) values ("William","Turner");
insert into Users (user_first_name, user_last_name) values ("Elizabeth","Swann");

insert into Cart values(2,1);
insert into Cart values(2,2);
insert into Cart values(2,3);

/* 5. View Cart (TYUC005) */
/* 5. a) Frame SQL query to get all menu items in a particular user’s cart */
select MenuItems.* from MenuItems join Cart on MenuItems.menu_item_id = Cart.cart_item_id where Cart.cart_user_id=2;

/* 5. b) Frame SQL query to get the total price of all menu items in a particular user’s cart */
select SUM(MenuItems.menu_item_price) as TOTAL_PRICE from MenuItems join Cart on MenuItems.menu_item_id = Cart.cart_item_id where Cart.cart_user_id=2;

/* 6. Remove Item from Cart (TYUC006) */
/* 6. a) Frame SQL query to remove a menu items from Cart based on User Id and Menu Item Id */
delete from Cart where cart_user_id=2 and cart_item_id=1;