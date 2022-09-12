drop database if exists abc;
create database abc;
use abc;

create table student(
student_id int ,
student_name varchar(45)
);

insert into student (student_id,student_name)
value(1,'Tien'),
(2,'Nam');

select * from student;

