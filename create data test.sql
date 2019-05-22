use intern;
/*
drop table fullname;
	create table fullname(
		id int auto_increment primary key,
        firstname varchar(25),
        middlename varchar(25),
        lastname varchar(25)
    );
    
    insert into fullname(firstname, middlename, lastname) values
    ('do', 'xuan', 'cuong'),
    ('le', 'tien', 'chieu'),
    ('vu', 'van', 'dung');

drop function if exists getId;

delimiter //
create function getId(maxresult int) returns int deterministic
begin
    declare id int unsigned default FLOOR( 1 + RAND() * maxresult );
    return id;
end //
delimiter ;

drop function if exists getFirstName;
delimiter //
create function getFirstName(ind int) returns varchar(25) reads sql data
begin
	declare result varchar(25);
    select firstname into result from fullname where id=ind limit 1;
    
    return result;
end //

delimiter //


drop function if exists getMiddleName;
delimiter //
create function getMiddleName(ind int) returns varchar(25) reads sql data
begin
	declare result varchar(25);
    select middlename into result from fullname where id=ind limit 1;
    
    return result;
end //

delimiter //

drop function if exists getLastName;
delimiter //
create function getLastName(ind int) returns varchar(25) reads sql data
begin
	declare result varchar(25);
    select lastname into result from fullname where id=ind limit 1;
    
    return result;
end //

delimiter ;
*/

drop table fullname;
create table datainfo(
	id int auto_increment primary key;
);

drop function if exists getFullName;
delimiter //
create function getFullName() returns varchar(25) no sql
begin
	declare result varchar(255);
    set result = concat(getFirstName(getId(3))," ", getMiddleName(getId(3))," ", getLastName(getId(3)));
    return result;
end //
delimiter ;
select getFullName();