/*
create database intern;
*/

use intern;
/*
<!------------------ CREATE TABLES ENTITIES------------>

create table if not exists khachhang(
	makhachhang int primary key,
    tencongty varchar(255),
    tengiaodich varchar(255),
    diachi varchar(255),
    email varchar(255),
    dienthoai varchar(255),
    fax varchar(255)
);

create table if not exists nhanvien(
	manhanvien int primary key,
    ho varchar(255),
    ten varchar(255),
    ngaysinh date,
	ngaylamviec varchar(),
    diachi varchar(255),
    dienthoai varchar(255),
    luongcoban int,
    phucap int
);

create table if not exists loaihang(
	maloaihang int primary key,
    tenloaihang varchar(255)
);

create table if not exists nhacungcap(
	macongty int primary key,
    tencongty varchar(255),
    tengiaodich varchar(255),
    diachi varchar(255),
    dienthoai varchar(255),
    fax varchar(255),
    email varchar(255)
);

create table if not exists dondathang(
	sohoadon int primary key,
    makhachhang int,
    manhanvien int,
    ngaydathang date,
    ngaychuyenhang date,
    noigiaohang varchar(255),
    foreign key (makhachhang) references khachhang(makhachhang),
    foreign key (manhanvien) references nhanvien(manhanvien)
);

create table if not exists mathang(
	mahang int primary key,
    tenhang varchar(255),
    macongty int,
    maloaihang int,
    soluong int,
    donvitinh varchar(255),
    giahang int,
    foreign key (macongty) references nhacungcap(macongty),
    foreign key (maloaihang) references loaihang(maloaihang)
);

create table if not exists chitietdathang(
	sohoadon int,
    mahang int,
    giaban int,
    mucgiamgia float,
    primary key (sohoadon, mahang),
    foreign key (sohoadon) references dondathang(sohoadon),
    foreign key (mahang) references mathang(mahang)
);


<!---------------- END CREATE TABLES ENTITIES------------->

<!---------------- CREATE TABLES DATA ----------- >



create table if not exists name_data(
	id int auto_increment primary key,
	firstname varchar(25),
	middlename varchar(25),
	lastname varchar(25)
);

create table if not exists address_data(
	id int auto_increment primary key,
    phuong varchar(25),
    quan varchar(25),
    thanhpho varchar(25)
);

insert into name_data(firstname, middlename, lastname) values
('Do', 'Xuan', 'Cuong'),
('Le', 'Tien', 'Chieu'),
('Vu', 'Van', 'Dung'),
('Nguyen','Thi','Dai'),
('Tran', 'Dieu', 'Tuyen'),
('Le', 'Ba', 'Thin'),
('Pham', 'Manh', 'Tam'),
('Huynh', 'Duc', 'Giang'),
('Hoang', 'Mau', 'Mai'),
('Vo', 'Nhu', 'Duong'),
('Dang', 'Thu', 'Thuy'),
('Bui', 'Cam', 'Phuong'),
('Ho', 'Chau', 'Thao'),
('Ngo', 'Cao', 'Tuan'),
('Duong', 'Ky', 'Thinh'),
('Ly', 'Thanh', 'Cong');

drop function if exists getId;

delimiter //
create function getId(maxresult int) returns int deterministic
begin
    declare id int unsigned default FLOOR( 1 + RAND() * maxresult );
    return id;
end //
delimiter ;


drop function if exists getFullName;
delimiter //
create function getFullName() returns varchar(25) reads sql data
begin
	declare lastN varchar(25);
    declare middle varchar(25);
    declare firstN varchar(25);
    declare ind1 int unsigned default getId(12);
    declare ind2 int unsigned default getId(12);
    declare ind3 int unsigned default getId(12);
    select middlename into middle from name_data where id = ind1 limit 1;
    select firstname into firstN from name_data where id = ind2 limit 1;
    select lastname into lastN from name_data where id = ind3 limit 1;
    return concat(firstN, ' ', middle, ' ', lastN);
end //

delimiter ;

drop function if exists getDate;
delimiter //

create function getDate() returns date deterministic
begin
	declare rand date;
    return
    FROM_UNIXTIME(
        UNIX_TIMESTAMP('2017-04-30 14:53:27') + FLOOR(0 + (RAND() * 63072000))
		);
	
end//
delimiter ;

drop function getCompany;
delimiter //
create function getCompany() returns varchar(25) deterministic
begin
	return ELT(1+FLOOR(RAND() * 52), 'Apple','Google','Amazon',
    'Microsoft','Coca-cola','Samsung','Toyota','Mercedes-Benz',
    'Facebook','McDonalds','Intel','IBM','BMW','Disney','Cisco',
    'General Electric','Nike','Louis Vuitton','Oracle','Honda',
    'SAP','Pepsi','Channel','American Express','Zara','JP Morg',
    'Ikea','Gilette','UPS','H&M','Pampers','Hermes','Budweiser',
    'Accenture','Ford','Hyndai','Nescafe','Ebay','Gucci','Nissan',
    'Volkswagen','Audi','Philips','Goldman Sachs','Citi','HSBC',
    'Axa','L\'Oreal','Allianz','Adidas','Adobe','Porche');
end//

delimiter ;

drop function if exists getAddress;
delimiter //
create function getAddress() returns varchar(60) deterministic
begin
	declare randnumber int unsigned default getId(200);
	return concat(
		' ', ELT(1+FLOOR(RAND() * 11), 'Cong Vi', 
        'Giang Vo', 'Kim Ma', 'Lieu Giai', 'Doi Can', 
        'Ngoc Ha', 'Ngoc Khanh', 'Phuc Xa', 'Quan Thanh', 
        'Thanh Cong', 'Truc Bach'),
        ' ', ELT(1+FLOOR(RAND() * 12), 'Ba Dinh', 
        'Ba Vi', 'Bac Tu Liem', 'Cau Giay', 'Chuong My', 
        'Thanh Oai', 'Dan Phuong', 'Dong Anh', 'Dong Da', 
        'Ha Dong', 'Hai Ba Trung', 'Hoai Duc'), 
        ' ', ELT(1+FLOOR(RAND() * 7), 'An Giang', 
        'Bac Kan', 'Ben Tre', 'Binh Dinh', 'Binh Phuoc', 'Ca Mau', 
        'Ha Noi'));
end//

delimiter ;


DROP function if exists genstring;
delimiter $$
CREATE FUNCTION genstring(in_strlen int) RETURNS VARCHAR(500) DETERMINISTIC
BEGIN
set @var:='';
while(in_strlen>0) do
set @var:=concat(@var,ELT(1+FLOOR(RAND() * 26), 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
set in_strlen:=in_strlen-1;
end while;
RETURN @var;
END $$



delimiter //
create function getEmail() returns varchar(255) deterministic
begin
	return CONCAT(genstring(ROUND((RAND() * (15-5))+5)), '@', genstring(ROUND((RAND() * (10-5))+5)), '.',  genstring(ROUND((RAND() * (5-2))+2)));

end//
delimiter ;

drop function if exists getPhoneNumber;
delimiter //
create function getPhoneNumber() returns varchar(255) deterministic
begin
	set @phonenumber := "84";
    set @dem := 0;
    while(@dem < 8) do
		set @phonenumber := concat(@phonenumber, ELT(1+FLOOR(RAND()*10), '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        set @dem:=@dem+1;
    end while;
    return @phonenumber;
end//
delimiter ;
*/

delimiter //
create procedure generateDataKhachHang() 
begin
	
end //

delimiter ;