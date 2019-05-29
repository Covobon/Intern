
drop database if exists intern;
create database intern;


use intern;

drop table if exists khachhang;
create table if not exists khachhang(
	makhachhang int auto_increment primary key,
    tencongty varchar(255),
    tengiaodich varchar(255),
    diachi varchar(255),
    email varchar(255),
    dienthoai varchar(255),
    fax varchar(255)
);

create table if not exists nhanvien(
	manhanvien int auto_increment primary key,
    ho varchar(255),
    ten varchar(255),
    ngaysinh date,

    diachi varchar(255),
    dienthoai varchar(255),
    luongcoban int,
    phucap int
);

create table if not exists loaihang(
	maloaihang int auto_increment primary key,
    tenloaihang varchar(255)
);

create table if not exists nhacungcap(
	macongty int auto_increment primary key,
    tencongty varchar(255),
    tengiaodich varchar(255),
    diachi varchar(255),
    dienthoai varchar(255),
    fax varchar(255),
    email varchar(255)
);

create table if not exists dondathang(
	sohoadon int auto_increment primary key,
    makhachhang int,
    manhanvien int,
    ngaydathang date,
    ngaygiaohang date,
    ngaychuyenhang date,
    noigiaohang varchar(255),
    foreign key (makhachhang) references khachhang(makhachhang),
    foreign key (manhanvien) references nhanvien(manhanvien)
);

create table if not exists mathang(
	mahang int auto_increment primary key,
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
    giaban long,
    soluong int,
    mucgiamgia float,
    primary key (sohoadon, mahang),
    foreign key (sohoadon) references dondathang(sohoadon),
    foreign key (mahang) references mathang(mahang)
);

drop function if exists getId;

delimiter //
create function getId(maxresult int) returns int deterministic
begin
    declare id int unsigned default FLOOR( 1 + RAND() * maxresult );
    return id;
end //
delimiter ;


drop function if exists getLastName;
delimiter //
create function getLastName() returns varchar(25) reads sql data
begin
    return concat(ELT(1+FLOOR(RAND() * 16), 'Nguyen', 'Tran', 'Le', 'Pham', 'Huynh', 'Hoang', 
					'Phan', 'Vu', 'Vo', 'Dang', 'Bui', 'Do', 'Ho', 'Ngo', 'Duong', 'Ly'),
                    ' ',
                    ELT(1+FLOOR(RAND() * 19), 'Ai', 'Lan', 'Thao', 'Nhu', 'Quynh', 'Thu', 
                    'Thuy', 'Tram', 'Van', 'Xuan', 'Cong', 'Duc', 'Duy', 'Hai', 'Hieu', 'Huy', 'Khai', 'Manh', 'Thanh'));
end //

delimiter ;

drop function if exists getFirstName;
delimiter //
create function getFirstName() returns varchar(25) reads sql data
begin
    return concat(ELT(1+FLOOR(RAND() * 20), 'Cuong', 'Phuong', 'Duong', 'Phu', 'Thuy', 'Dung', 
					'Phan', 'Vu', 'Mai', 'Dang', 'Tam', 'Dai', 'Tuyen', 'Hop', 'Cong', 'Chieu',
                    'Yen', 'Nhung', 'Tra', 'My'));
end //

delimiter ;

drop function if exists getDate;
delimiter //

create function getDate(numberyear int, phamvi int) returns date deterministic
begin
	declare rand date;
    return
    FROM_UNIXTIME(
        UNIX_TIMESTAMP('2019-04-30 14:53:27') + FLOOR(0 + (RAND() * 31072000 * phamvi) - numberyear*31536000)
		);
	
end//
delimiter ;

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
    declare varcharnumber varchar(4) default convert(getId(200), char(4));
	return concat( varcharnumber,
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


drop procedure if exists generateDataKhachHang;
delimiter //
create procedure generateDataKhachHang(counter1 int) 
begin
	set @counter := 0;
    while @counter < counter1 do
		insert into khachhang(tencongty, tengiaodich, diachi, email, dienthoai, fax) value
        (getCompany(), genstring(3), getAddress(), getEmail(), getPhoneNumber(), getPhoneNumber());
        set @counter = @counter + 1;
    end while;
end //

delimiter ;

drop procedure if exists generateDataNhanVien;
delimiter //
create procedure generateDataNhanVien(counter1 int) 
begin
	set @counter := 0;
    while @counter < counter1 do
		insert into nhanvien(ho, ten, ngaysinh ,diachi, dienthoai, luongcoban, phucap) value
        (getLastName(), getFirstName(), getDate(30, 10), getAddress(), getPhoneNumber(), 1000000 + getId(3000000), 100000 + getId(300000));
        set @counter = @counter + 1;
    end while;
end //

delimiter ;

drop procedure if exists generateDataNhaCungCap;
delimiter //
create procedure generateDataNhaCungCap(counter1 int)
begin
	set @counter := 0;
    while @counter < counter1 do
		insert into nhacungcap(tencongty, tengiaodich, diachi, dienthoai, fax, email) value
        (getCompany(), genstring(3) , getAddress(), getPhoneNumber(), getPhoneNumber(), getEmail());
        set @counter = @counter + 1;
    end while;
end //

delimiter;


drop procedure if exists generateDataDonDatHang;
delimiter //
create procedure generateDataDonDatHang(counter1 int)
begin
	set @counter := 0;
    set @idkhachhang := 2;
    set @idnhanvien := 1;
    
    while @counter < counter1 do
		select makhachhang into @idkhachhang from khachhang order by rand() limit 1;
		select manhanvien into @idnhanvien from nhanvien order by rand() limit 1;
		insert into dondathang(makhachhang, manhanvien, ngaydathang, ngaygiaohang, ngaychuyenhang, noigiaohang) value
        (@idkhachhang, @idnhanvien, getDate(27, 15), getDate(2, 1), getDate(1, 1), getAddress());
        set @counter = @counter + 1;
    end while;
end //

delimiter ;

drop procedure if exists generateDataMatHang;
delimiter //
create procedure generateDataMatHang(counter1 int)
begin
	set @counter := 0;
    set @idcongty := 2;
    set @idloaihang := 1;
    while @counter < counter1 do
		set @nameproduct := concat(ELT(1+FLOOR(RAND()*12), 'Dien thoai', 'May tinh', 
									'May anh', 'May in', 'Thuoc', 'Do an', 'Phe pham', 
                                    'My pham', 'Van phong pham', 'Man hinh', 'Gear', 'Balo'),
                                    ' ', ELT(1+FLOOR(RAND() * 26), 'a','b','c','d','e','f','g',
                                    'h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'),
                                    ELT(1+FLOOR(RAND()*10), '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        set @donvitinh := ELT(1+FLOOR(RAND()*3), 'cai', 'l', 'kg');
		select macongty into @idcongty from nhacungcap order by rand() limit 1;
		select maloaihang into @idloaihang from loaihang order by rand() limit 1;
		insert into mathang(tenhang, macongty, maloaihang, soluong, donvitinh, giahang) value
        (@nameproduct, @idcongty, @idloaihang, getId(1000), @donvitinh, getId(10000000));
        set @counter = @counter + 1;
    end while;
end //
delimiter ;

drop procedure if exists generateDataChiTietDatHang;
delimiter //
create procedure generateDataChiTietDatHang(counter1 int)
begin
	set @counter := 0;
    set @idhoadon := 2;
    set @idmahang := 1;
    set @giabansanpham := 0;
    set @soluongtong := 0;
    set @soluongdon := 0;
    while @counter < counter1 do
		select sohoadon into @idhoadon from dondathang order by rand() limit 1;
		select mahang into @idmahang from mathang order by rand() limit 1;
        set @giamgia := elt(1+floor(rand()*5), 0.1, 0.2, 0.3, 0.4, 0.5);
        set @soluongdon = getId(1000);
        select giahang into @giabansanpham from mathang where mahang = @idmahang limit 1;
		insert into chitietdathang(sohoadon, mahang, giaban, soluong, mucgiamgia) value
        (@idhoadon, @idmahang, @giabansanpham*@soluongdon, @soluongdon, @giamgia);
        set @counter = @counter + 1;
    end while;
end //

delimiter ;

drop procedure if exists generateDataLoaiHang;
delimiter //
create procedure generateDataLoaiHang()
begin
    set @ind = 1;
    while  @ind < 5 do
		set @tenloaihang = elt(@ind, 'hang cong nghe', 'hang de vo', 'hang doc hai', 'hang cu');
		insert into loaihang(tenloaihang) value (@tenloaihang);
        set @ind = @ind + 1;
    end while ;
end //

delimiter ;

call generateDataKhachHang(100);
call generateDataNhanVien(100);
call generateDataDonDatHang(100);
call generateDataNhaCungCap(100);
call generateDataLoaiHang();
call generateDataMatHang(100);
call generateDataChiTietDatHang(100);


