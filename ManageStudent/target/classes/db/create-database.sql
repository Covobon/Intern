drop database managestudent;
create database managestudent;
use managestudent;

create table teacher(
	id_teacher varchar(255) primary key,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255)
);

create table student(
	id_student varchar(255) primary key,
    class varchar(255)
);

create table class(
	id_teacher varchar(255),
    id_student varchar(255),
    primary key(id_teacher, id_student),
    foreign key (id_teacher) references teacher(id_teacher),
    foreign key (id_student) references student(id_student)
);