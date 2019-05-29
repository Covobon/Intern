drop database managestudent;
create database managestudent;
use managestudent;

create table teacher(
	id_teacher varchar(255) primary key,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255) unique
);

create table student(
	id_student varchar(255) primary key,
    first_name varchar(255),
    last_name varchar(255),
    address varchar(255),
    email varchar(255) unique,
    phonenumber varchar(255) unique
);

create table class(
	id_class varchar(255) primary key,
    name_class varchar(255) unique,
	id_teacher varchar(255),
    id_joined varchar(255),
    foreign key (id_teacher) references teacher(id_teacher)
);

create table joined(
	id_student varchar(255),
    id_class varchar(255),
    primary key(id_student, id_class),
    foreign key (id_student) references student(id_student),
    foreign key (id_class) references class(id_class)
);

