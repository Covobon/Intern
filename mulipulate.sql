use intern;

delimiter // Cau 3
select dx.dongxe from dongxe as dx
where dx.sochongoi > 5;

delimiter // Cau 4
select ncc.tennhacc from nhacungcap as ncc join dangkycungcap as dkcc
on ncc.manhacc = dkcc.manhacc
join mucphi as mp
on ncc.maphi = dkcc=maphi
where (ncc.dongxe = 'TOYOTA' and mp.dongia = 15000) or (ncc.dongxe = 'KIA' and mp.dongia=20000);

delimiter // Cau 5
select * from nhacungcap as ncc
order by ncc.tennhacc asc, ncc.masothue desc;

delimiter // Cau 6
select khachhang.makhachhang, khachhang.tencongty , sum(chitietdathang.giaban) from khachhang join dondathang
on khachhang.makhachhang = dondathang.makhachhang
join chitietdathang
on dondathang.sohoadon = chitietdathang.sohoadon
group by khachhang.makhachhang;

delimiter ;

delimiter // Cau 8
select month(dondathang.ngaydathang) as 'Thang', sum(chitietdathang.giaban) as 'Tong tien' from dondathang 
join chitietdathang 
on chitietdathang.sohoadon = dondathang.sohoadon
group by month(dondreturn 0 if null mysqlreturn 0 if null mysqlathang.ngaydathang)
order by month(dondathang.ngaydathang);

delimiter // Cau 9
select mathang.mahang as 'Ma hang'
		,mathang.tenhang as 'Ten hang'
        ,mathang.soluong as 'Ton kho'
        ,ifnull(sum(chitietdathang.soluong),0) as 'Da ban'
        from mathang left join chitietdathang 
        on mathang.mahang = chitietdathang.mahang
        group by mathang.mahang;
        
delimiter // Cau 10
select nhanvien.manhanvien as 'Ma nhan vien',
		nhanvien.ten as 'Ten nhan vien',
        sum(chitietdathang.soluong) as 'Tong so ban ra' from nhanvien 
        join dondathang 
        on nhanvien.manhanvien = dondathang.manhanvien
        join chitietdathang
        on dondathang.sohoadon = chitietdathang.sohoadon
        group by nhanvien.manhanvien
        order by sum(chitietdathang.soluong) desc
        limit 1;

delimiter ;

delimiter // Cau 11
select chitietdathang.sohoadon, group_concat(mathang.tenhang), sum(chitietdathang.giaban) from chitietdathang
join mathang on chitietdathang.mahang = mathang.mahang
group by chitietdathang.sohoadon;

delimiter ;

delimiter // Cau 12
select loaihang.maloaihang, group_concat(mathang.mahang), sum(mathang.soluong), (select sum(mathang.soluong) from mathang) 
from loaihang
join mathang on loaihang.maloaihang = mathang.maloaihang
group by loaihang.maloaihang;
delimiter ;

delimiter // Cau 13
select basemonth.mahang, basemonth.thang, basemonth.counter from
(select mathang.mahang as mahang, month(dondathang.ngaydathang) as thang , chitietdathang.soluong as counter from mathang
join chitietdathang on mathang.mahang = chitietdathang.mahang
join dondathang on chitietdathang.sohoadon = dondathang.sohoadon
where year(dondathang.ngaydathang) = 2003) t1
join left 
select mathang.mahang as mahang, sum(chitietdathang.soluong) as counter from mathang
join chitietdathang on mathang.mahang = chitietdathang.mahang
join dondathang on chitietdathang.sohoadon = dondathang.sohoadon
where year(dondathang.ngaydathang) = 2003
group by (mathang.mahang) t2
on baseyear.mahang = basemonth.mahang;
delimiter ;