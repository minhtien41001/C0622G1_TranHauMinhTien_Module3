drop database if exists products;
create database products;
use products;

create table product
(id int primary key auto_increment,
product_code varchar(20),
product_name varchar(45),
product_price double,
product_amount int,
product_description varchar(30),
product_status bit);
-- Bước 2: Tạo bảng Products với các trường dữ liệu sau:
insert into product(id,product_code,product_name,product_price,product_amount,product_description,product_status)
 values(1,'ip11','IPhone11',250,3,'Den',1),
 (2,'ip11prmax','IPhone11promax',400,5,'xanh la',0),
 (3,'ip12pro','IPhone12pro',600,7,'hong',1),
 (4,'ip13','Iphone13',850,9,'tim',1);
 -- Bước 3:-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
 create unique index  i_product
 on product(product_code);
 -- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
 create index i_composite_product 
 on product (product_name,product_price);
 -- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
 explain select*from product 
 where product_description='hong'; 
 -- So sánh câu truy vấn trước và sau khi tạo index 
 explain select * 
 from product  
 where product_name='IPhone11promax';
 -- Bước 4:-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
 create view product_views as 
 select product_code,product_name,product_price,product_statusfrom product;
-- Tiến hành sửa đổi view
create or replace view product_views as 
select product_name from product 
where product_name='IPhone13';
-- xoa view
delete from product where product_code='ip11';
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
create  procedure sp_product ()
begin select *from product;
end //Delimiter ;
call sp_product;
-- Tạo store procedure thêm một sản phẩm mới
Delimiter //
create procedure add_sp_product(
in id int ,
product_code varchar(10),
product_name varchar(30),
product_price double,
product_amount int,
product_description varchar(60),
product_status bit)
begin insert into product()
values (id,product_code,product_name,product_price,product_amount,product_description,product_status);
end //Delimiter;
call add_sp_product(5,'ip14','IPhone14',900,7,'xanh duong',1);
-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
create procedure update_sp_product(
in p_id int ,
p_code varchar(10),
p_name varchar(30),
p_price double,
p_amount int,
p_description varchar(60),
p_status bit)
begin update product set product_code = p_code,
product_name = p_name,
product_price =p_price,
product_amount = p_amount,
product_description = p_description,
product_status =p_status 
where id =p_id;
end //Delimiter ;
call update_product(7,'ip14pro','IPhone14Pro',12000,5,'den kim cuong',2);
-- Tạo store procedure xoá sản phẩm theo id
DELIMITER //
create procedure delete_sp_product_by_id (in p_id int)
begin delete from product 
where id =p_id;
end//DELIMITER ;
call delete_sp_product_by_id(2);
call sp_product()