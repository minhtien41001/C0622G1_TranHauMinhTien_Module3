drop database if exists bt1;
create  database bt1;
use bt1;

create table Class(
class_id int,
class_name varchar(45) 
);

create table Teacher(
teacher_id int,
teacher_name varchar(45),
teacher_age int,
teacher_country varchar(45)
);

select * from Class;