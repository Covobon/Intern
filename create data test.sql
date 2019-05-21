use intern;

drop function if exists getId;

delimiter //
create function getId() returns int deterministic
begin
    declare id int unsigned default FLOOR( 1 + RAND( ) *150 );
    return id;
end //
delimiter ;

drop function if exists generateFirstName;

delimiter //

create function generateFirstName(vitri int) returns varchar(255) charset latin1
begin
    declare min int unsigned default 1;
    declare result varchar(255) default null;
    set @myArrayFirstName = ('do', 'nguyen', 'tien', 'dao');
    set result = elt(vitri, @myArrayFirstName);
    return result;
end //
delimiter ;

select generateFirstName(1);