create database QL_CuaHangDienLanh
GO
use QL_CuaHangDienLanh
GO
set dateformat dmy
GO
create table NhanVien
(	
	manv int not null primary key IDENTITY,
	hoten nvarchar(50),
	taikhoan nvarchar(50),
	matkhau nvarchar(50),
	sdt nvarchar(50),
	chucvu nvarchar(50),
	hinh nvarchar(max)
	 
)
GO
create table NhaCungCap
(
	mancc int not null primary key IDENTITY,
	tenncc nvarchar(50),
	diachi nvarchar(50),
	sdt nvarchar(50),
)
GO
create table SanPham
(
	masp int not null  primary key IDENTITY,
	tensp nvarchar(50),
	giatien float,
	soluong int,
	mancc int,
	loaisp nvarchar(50),
	hinh nvarchar(max),
	constraint fk_sp_ncc foreign key (mancc) references NhaCungCap(mancc)
)
GO


create table HoaDonNhap
(
	mahdn int not null  primary key IDENTITY,
	ngaynhap date,
	mancc int ,
	manv int,
	tongtien float,
	constraint fk_hdn_ncc foreign key (mancc) references NhaCungCap(mancc),
	constraint fk_hdn_nv foreign key (manv) references NhanVien(manv),
)
GO


create table ChiTietHoaDonNhap
(	
	macthdn int not null  IDENTITY,
	mahdn int,
	masp int,
	soluongnhap int,
	dongianhap float,
	thanhtien float,
	constraint fk_cthdn_hdn foreign key (mahdn) references HoaDonNhap(mahdn),
	constraint fk_cthdn_sp foreign key (masp) references SanPham(masp),
	constraint pk_cthdn primary key (mahdn,macthdn)

)
GO

create table HoaDonXuat
(
	mahdx int not null primary key IDENTITY,
	manv int,
	ngayxuat date,
	hotenkh nvarchar(50),
	sdt nvarchar(50),
	tongtien float,
	constraint fk_hdx_nv foreign key (manv) references NhanVien(manv)
)
GO

create table ChiTietHoaDonXuat
(
	macthdx int IDENTITY,
	mahdx int,
	masp int,
	soluongxuat int, 
	dongiaxuat float,
	thanhtien float,
	constraint fk_cthdx_hdx foreign key (mahdx) references HoaDonXuat(mahdx),
	constraint fk_cthdx_sp foreign key (masp) references SanPham(masp),
	constraint pk_cthdx primary key (mahdx,macthdx)
)
GO
--===================================================================================================================================
create trigger capnhatbanvattu on ChiTietHoaDonXuat 
after insert 
as
begin
	update SanPham
	set soluong=soluong-(
	select soluongxuat
	from inserted
	where masp=SanPham.masp
	)
	from SanPham
	join inserted on SanPham.masp=inserted.masp
end
go
create trigger capnhatthemvattu on ChiTietHoaDonNhap 
after insert 
as
begin
	update SanPham
	set soluong=soluong+(
	select soluongnhap
	from inserted
	where masp=SanPham.masp
	)
	from SanPham
	join inserted on SanPham.masp=inserted.masp
end
go
--========================================================================================================================

create trigger capnhattongtien_hdnhap_khithemcthdnhap on ChiTietHoaDonNhap 
after insert 
as
begin
	update HoaDonNhap
	set TONGTIEN=TONGTIEN+(
	select THANHTIEN
	from inserted
	where mahdn=HoaDonNhap.mahdn
	)
	from HoaDonNhap
	join inserted on HoaDonNhap.mahdn=inserted.mahdn
end
go
create trigger capnhattongtien_hdnhap_khixoacthdnhap on ChiTietHoaDonNhap 
after delete 
as
begin
	update HoaDonNhap
	set TONGTIEN=TONGTIEN-(
	select THANHTIEN
	from deleted
	where mahdn=HoaDonNhap.mahdn
	)
	from HoaDonNhap
	join deleted on HoaDonNhap.mahdn=deleted.mahdn
end

--=====================================================================================================================================================
go
create trigger capnhattongtien_hdxuat_khithemcthdxuat on ChiTietHoaDonXuat
after insert 
as
begin
	update HoaDonXuat
	set TONGTIEN=TONGTIEN+(
	select THANHTIEN
	from inserted
	where mahdx=HoaDonXuat.mahdx
	)
	from HoaDonXuat
	join inserted on HoaDonXuat.mahdx=inserted.mahdx
end
go
create trigger capnhattongtien_hdxuat_khixoacthdxuat on ChiTietHoaDonXuat 
after delete 
as
begin
	update HoaDonXuat
	set TONGTIEN=TONGTIEN-(
	select THANHTIEN
	from deleted
	where mahdx=HoaDonXuat.mahdx
	)
	from HoaDonXuat
	join deleted on HoaDonXuat.mahdx=deleted.mahdx
end

--=====================================================================================================================================================
insert into NhanVien(hoten,taikhoan,matkhau,sdt,chucvu,hinh) values
(N'Như Đạt','dat','dat','0123456789','nhanvien',null),
(N'Quốc Dương','duong','duong','0987654321','nhanvien',null),
(N'Admin','admin','123','0123456789','admin','admin.png')
insert into NhaCungCap(tenncc,diachi,sdt) values ('DAT OC','BINH HUNG HOA','0123456789')
insert into NhaCungCap(tenncc,diachi,sdt) values ('DAT 09','TRAN DUY HUNG','0123456789')
insert into NhaCungCap(tenncc,diachi,sdt) values ('DAT 1 LIT','PHU YEN','0123456789')
insert into NhaCungCap(tenncc,diachi,sdt) values ('DAT TUNG PHIN','DONG XOAI','0123456789')
insert into NhaCungCap(tenncc,diachi,sdt) values ('CHO DAT','BINH TAN','0123456789')

insert into SanPham( tensp, giatien, soluong, mancc,loaisp,hinh) values ( N'Tủ lạnh side by side inverter Coex RS-4001MSG 546L', 11990000, 10,1,N'tủ lạnh','kjhasgdfika.jpg')
insert into SanPham( tensp, giatien, soluong, mancc,loaisp,hinh) values ( N'Máy lạnh di động Casper PC-09TL33', 5490000, 20,2,N'máy lạnh','17902_dieu_hoa_di_dong_casper_pc_09tl33.jpg')
insert into SanPham(tensp, giatien, soluong, mancc,loaisp,hinh) values ( N'Tủ mát Sanaky VH-1520HP - 1.400 lít', 34990000, 30, 3,N'tủ mát','abcd.jpg')
insert into SanPham( tensp, giatien, soluong, mancc,loaisp,hinh) values (N'Tủ đông Smart Inverter Darling ', 19400000, 40, 4,N'tủ đông','tu-dong-dmf-1079asi.jpg')
insert into SanPham( tensp, giatien, soluong, mancc,loaisp,hinh) values ( N'Điều hòa Daikin Inverter 1 chiều 18000BTU', 17200000, 50, 5,N'tủ lạnh','Tim-hieu-ve-dieu-hoa-daikin-1-chieu-18000btu-inverter0.jpg')

set dateformat dmy
GO
insert into HoaDonNhap(mancc,manv,ngaynhap,tongtien) values
(1,1,'20-5-2023',0),
(2,2,'21-5-2023',0),
(3,3,'22-5-2023',0),
(4,1,'23-5-2023',0),
(5,2,'24-5-2023',0)
insert into ChiTietHoaDonNhap(mahdn,masp,soluongnhap,dongianhap,thanhtien) values
(1,1,10,10000,100000),
(2,2,10,10000,100000),
(3,3,10,10000,100000),
(4,4,10,10000,100000),
(5,5,10,10000,100000)
select * from NhanVien
select * from NhaCungCap
select loaisp from SanPham
group by loaisp
select * from HoaDonNhap
select * from ChiTietHoaDonNhap
select * from HoaDonXuat
select * from ChiTietHoaDonXuat
insert into HoaDonXuat(manv,ngayxuat,hotenkh,sdt,tongtien) values
(1,'26-5-2023',N'đạt','123456789',0),
(2,'27-5-2023',N'đạt baby','123563485',0),
(1,'28-5-2023',N'đạt men','123254986',0),
(2,'29-5-2023',N'đạt lỏd','123875634',0),
(1,'23-5-2023',N'đạt 69','123534785',0)
insert into ChiTietHoaDonXuat(mahdx,masp,soluongxuat,dongiaxuat, thanhtien) values
(1,1,10,20000,200000),
(2,2,10,20000,200000),
(3,3,10,20000,200000),
(4,4,10,20000,200000),
(5,5,10,20000,200000)