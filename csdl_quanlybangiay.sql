-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 31, 2020 at 05:49 AM
-- Server version: 10.5.2-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `csdl_quanlybangiay`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `MaAdmin` int(11) NOT NULL,
  `Username` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `HoTen` varchar(50) DEFAULT NULL,
  `DiaChi` varchar(50) DEFAULT NULL,
  `DienThoai` varchar(11) DEFAULT NULL,
  `CMND` varchar(9) DEFAULT NULL,
  `NgaySinh` datetime DEFAULT NULL,
  `GioiTinh` tinyint(4) DEFAULT NULL,
  `NgayDangKy` datetime NOT NULL,
  `Avatar` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `banner`
--

CREATE TABLE `banner` (
  `MaBanner` int(11) NOT NULL,
  `TenBanner` varchar(200) DEFAULT NULL,
  `MoTaBanner` varchar(200) DEFAULT NULL,
  `Link` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `banner`
--

INSERT INTO `banner` (`MaBanner`, `TenBanner`, `MoTaBanner`, `Link`) VALUES
(1, 'Bitis 8/3', 'Nhân dịp ngày 8/3, Bitis hân hạnh mang đến cho chị em phụ nữ ưu đãi bất ngờ.', '/Images/Banner/Banner_8Thang3.jpg'),
(2, 'Adidas 1', NULL, '/Images/Banner/Banner_Adidas.jpg'),
(3, 'Adidas 2', NULL, '/Images/Banner/Banner_Adidas2.jpg'),
(4, 'Adidas 3', NULL, '/Images/Banner/Banner_Adidas3.jpg'),
(5, 'Adidas 4', NULL, '/Images/Banner/Banner_Adidas4.jpg'),
(6, 'Adidas 5', NULL, '/Images/Banner/Banner_Adidas5.jpg'),
(7, 'Bitis Captain', NULL, '/Images/Banner/Banner_Captain.jpg'),
(8, 'Adidas Thể Thao 1', NULL, '/Images/Banner/Banner_AdidasTheThao1.jpg'),
(9, 'Adidas Thể Thao 2', NULL, '/Images/Banner/Banner_AdidasTheThao2.jpg'),
(10, 'Adidas Thể Thao 3', NULL, '/Images/Banner/Banner_AdidasTheThao3.jpg'),
(11, 'Nike And Adidas', NULL, '/Images/Banner/Banner_HangGiay.jpg'),
(12, 'Bitis Hunter 1', NULL, '/Images/Banner/Banner_Nam1.jpg'),
(13, 'Bitis Hunter 2', NULL, '/Images/Banner/Banner_Nam2.jpg'),
(14, 'Bitis Hunter 3', NULL, '/Images/Banner/Banner_Nam3.jpg'),
(15, 'Bitis Hunter 4', NULL, '/Images/Banner/Banner_Nam4.jpg'),
(16, 'Bitis Sandal', NULL, '/Images/Banner/Banner_Sandal.jpg'),
(17, 'Bitis Tết', NULL, '/Images/Banner/Banner_Tet.jpg'),
(18, 'Bitis Trẻ Em 1', NULL, '/Images/Banner/Banner_TreEm.jpg'),
(19, 'Bitis Trẻ Em 2', NULL, '/Images/Banner/Banner_TreEm2.jpg'),
(20, 'Bitis Trẻ Em 3', NULL, '/Images/Banner/Banner_TreEm33jpg'),
(21, 'Nike 1', NULL, '/Images/Banner/Banner_Nike1.jpg'),
(22, 'Nike 2', NULL, '/Images/Banner/Banner_Nike2.jpg'),
(23, 'Nike 3', NULL, '/Images/Banner/Banner_Nike3.jpg'),
(24, 'Nike 4', NULL, '/Images/Banner/Banner_Nike4.jpg'),
(25, 'Nike 5', NULL, '/Images/Banner/Banner_Nike5.jpg'),
(26, 'Nike 6', NULL, '/Images/Banner/Banner_Nike6.jpg'),
(27, 'Nike 7', NULL, '/Images/Banner/Banner_Nam1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `MaDonHang` int(11) NOT NULL,
  `MaGiay` int(11) NOT NULL,
  `Soluong` int(11) DEFAULT NULL,
  `DonGia` decimal(18,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`MaDonHang`, `MaGiay`, `Soluong`, `DonGia`) VALUES
(1, 13, 1, '800000'),
(2, 13, 2, '800000'),
(1002, 13, 1, '800000'),
(1002, 59, 1, '950000');

-- --------------------------------------------------------

--
-- Table structure for table `cuahang`
--

CREATE TABLE `cuahang` (
  `MaCH` int(11) NOT NULL,
  `TenCH` varchar(200) DEFAULT NULL,
  `DiaChiCH` varchar(200) DEFAULT NULL,
  `MoTaCH` longtext DEFAULT NULL,
  `SĐT` varchar(15) DEFAULT NULL,
  `EmailCH` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cuahang`
--

INSERT INTO `cuahang` (`MaCH`, `TenCH`, `DiaChiCH`, `MoTaCH`, `SĐT`, `EmailCH`) VALUES
(1, 'VSS TP. HCM', NULL, 'Là cửa hàng đầu tiên của hệ thống', '0808310850', 'vsstphcm@gmail.com'),
(2, 'VSS Đồng Nai', NULL, 'Là cửa hàng thứ 2 của hệ thống VSS', '0808310851', 'vssdongnai@gmail.com'),
(3, 'VSS Phú Yên', NULL, 'Là cửa hàng thứ 3 của hệ thống VSS', '0808310852', 'vssphuyen@gmail.com'),
(4, 'VSS Kiên Giang', NULL, 'Là cửa hàng thứ 4 của hệ thống VSS', '0808310853', 'vsskiengiang@gmail.com'),
(5, 'VSS Hà Nội', NULL, 'Là cửa hàng thứ 5 của hệ thống VSS', '0808310854', 'vsshanoi@gmail.com'),
(6, 'VSS Đà Nẵng', NULL, 'Là cửa hàng mới nhất của hệ thống VSS', '0808310855', 'vssdanang@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `danhmuc`
--

CREATE TABLE `danhmuc` (
  `MaDM` int(11) NOT NULL,
  `TenDM` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `danhmuc`
--

INSERT INTO `danhmuc` (`MaDM`, `TenDM`) VALUES
(1, 'Giày đi bộ'),
(2, 'Giày thể thao'),
(3, 'Giày khác'),
(4, 'Áo thun'),
(5, 'Phụ kiện');

-- --------------------------------------------------------

--
-- Table structure for table `dondathang`
--

CREATE TABLE `dondathang` (
  `MaDonHang` int(11) NOT NULL,
  `DaThanhToan` tinyint(4) DEFAULT NULL,
  `TinhTrangGiaoHang` tinyint(4) DEFAULT NULL,
  `NgayDat` datetime(3) DEFAULT NULL,
  `NgayGiao` datetime(3) DEFAULT NULL,
  `MaKH` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dondathang`
--

INSERT INTO `dondathang` (`MaDonHang`, `DaThanhToan`, `TinhTrangGiaoHang`, `NgayDat`, `NgayGiao`, `MaKH`) VALUES
(1, 0, 0, '2019-03-26 22:54:56.977', NULL, 2),
(2, 0, 0, '2019-03-28 20:55:07.027', NULL, 2),
(1002, 0, 0, '2019-03-29 10:17:40.393', NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `giay`
--

CREATE TABLE `giay` (
  `MaGiay` int(11) NOT NULL,
  `MaDM` int(11) DEFAULT NULL,
  `MaNSX` int(11) DEFAULT NULL,
  `TenGiay` varchar(100) NOT NULL,
  `TieuDe` varchar(255) NOT NULL,
  `Mota` longtext DEFAULT NULL,
  `Size` varchar(100) DEFAULT NULL,
  `Mau` varchar(50) DEFAULT NULL,
  `Anhbia` varchar(50) DEFAULT NULL,
  `Giaban` decimal(18,0) DEFAULT NULL,
  `NgayCapNhat` datetime(3) DEFAULT NULL,
  `SoLuongBan` int(11) DEFAULT NULL,
  `SoLuongTon` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `giay`
--

INSERT INTO `giay` (`MaGiay`, `MaDM`, `MaNSX`, `TenGiay`, `TieuDe`, `Mota`, `Size`, `Mau`, `Anhbia`, `Giaban`, `NgayCapNhat`, `SoLuongBan`, `SoLuongTon`) VALUES
(1, 4, 1, 'Áo Thun Bitis Hunter X Đen', '', 'Áo vải thun. Có logo Bitis Hunter X', 'X', 'BLA', '/Product/Accessories/Ao1.jpg', '150000', '2018-01-01 00:00:00.000', 35, 30),
(2, 4, 1, 'Áo thun Bitis Hunter', '', 'Áo vải thun. Có logo Bitis Hunter', 'X', 'BLA', '/Product/Accessories/Ao2.jpg', '100000', '2018-01-02 00:00:00.000', 20, 40),
(3, 4, 1, 'Áo thun Bitis Hunter X Trắng', '', 'Áo vải thun. Có logo Bitis Hunter X', 'X', 'WHI', '/Product/Accessories/Ao3.jpg', '150000', '2018-01-03 00:00:00.000', 15, 25),
(4, 4, 3, 'Áo thun Adidas Chữ', '', 'Áo vải thun. Chứa nhiều dòng chữ Adidas', 'M', 'WHI', '/Product/Accessories/Ao4.jpg', '500000', '2018-01-04 00:00:00.000', 50, 20),
(5, 4, 3, 'Áo thể thao Adidas Cam', '', 'Áo vải thun lạnh. Có logo Adidas', 'X', 'ORA', '/Product/Accessories/Ao5.jpg', '750000', '2018-01-05 00:00:00.000', 45, 25),
(6, 4, 3, 'Áo thể thao Adidas Xanh Dương', '', 'Áo vải thun lạnh. Có logo Adidas', 'X', 'BLU', '/Product/Accessories/Ao6.jpg', '750000', '2018-01-06 00:00:00.000', 20, 20),
(7, 4, 3, 'Áo thể thao Nữ Adidas Sọc Xanh Dương', '', 'Áo vải thun lạnh. Có logo Adidas', 'X', 'BLU', '/Product/Accessories/Ao7.jpg', '750000', '2018-01-07 00:00:00.000', 10, 10),
(8, 4, 3, 'Áo thun Adidas Xanh Dương Đậm', '', 'Áo vải thun. Có logo Adidas.', 'M', 'BLU', '/Product/Accessories/Ao8.jpg', '650000', '2018-01-08 00:00:00.000', 25, 25),
(9, 4, 3, 'Áo thun Nữ Adidas', '', 'Áo vải thun. Có logo Adidas.', 'M', 'WHI', '/Product/Accessories/Ao9.jpg', '650000', '2018-01-09 00:00:00.000', 10, 10),
(10, 4, 3, 'Áo thun Nữ Adidas Chữ', '', 'Áo vải thun. Có logo Adidas.', 'M', 'WHI', '/Product/Accessories/Ao10.jpg', '700000', '2018-01-10 00:00:00.000', 15, 5),
(11, 4, 2, 'Áo thun Nike Xám Đen', '', 'Áo vải thun lạnh. Có logo Nike.', 'X', 'BLA', '/Product/Accessories/Ao11.jpg', '800000', '2018-01-11 00:00:00.000', 20, 2),
(12, 4, 2, 'Áo thun Nike Đỏ', '', 'Áo vải thun lạnh. Có logo Nike.', 'X', 'RED', '/Product/Accessories/Ao12.jpg', '800000', '2018-01-12 00:00:00.000', 10, 12),
(13, 4, 2, 'Áo thun Nike Xanh Dương', '', 'Áo vải thun lạnh. Có logo Nike.', 'X', 'BLU', '/Product/Accessories/Ao13.jpg', '800000', '2018-01-13 00:00:00.000', 50, 20),
(14, 4, 2, 'Áo thun Nike Cam', '', 'Áo vải thun lạnh. Có logo Nike.', 'X', 'ORA', '/Product/Accessories/Ao15.jpg', '800000', '2018-01-14 00:00:00.000', 25, 12),
(15, 4, 2, 'Áo Nike Jordan', '', 'Áo vải thun cao cấp. Có logo Jordan.', 'M', 'BLA', '/Product/Accessories/Ao14.jpg', '1000000', '2018-01-15 00:00:00.000', 30, 15),
(16, 4, 2, 'Áo Nike Army', '', 'Áo vải hoạ tiết quân đội.', 'M', 'BLA', '/Product/Accessories/Ao15.jpg', '950000', '2018-01-16 00:00:00.000', 35, 25),
(17, 5, 4, 'Dây giày Trắng', '', 'Giây vải dù màu trắng.', NULL, 'WHI', '/Product/Accessories/DayGiay1.jpg', '10000', '2018-01-17 00:00:00.000', 24, 10),
(18, 5, 4, 'Dây giày Cam', '', 'Giây vải dù màu cam.', NULL, 'ORA', '/Product/Accessories/DayGiay2.jpg', '10000', '2018-01-18 00:00:00.000', 22, 10),
(19, 5, 4, 'Dây giày Đen', '', 'Giây vải dù màu đen đậm.', NULL, 'BLA', '/Product/Accessories/DayGiay3.jpg', '10000', '2018-01-19 00:00:00.000', 30, 10),
(20, 5, 4, 'Dây giày Đen Xám', '', 'Giây vải dù màu đen xám.', NULL, 'BLA', '/Product/Accessories/DayGiay4.jpg', '10000', '2018-01-20 00:00:00.000', 10, 30),
(21, 5, 4, 'Miếng lót Giày Đen', '', 'Miếng lót giày nhựa mỏng.', NULL, 'BLA', '/Product/Accessories/MiengLotGiay1.jpg', '50000', '2018-01-21 00:00:00.000', 12, 34),
(22, 5, 4, 'Miếng lót Giày Đen Xanh Dương', '', 'Miếng lót giày nhựa mỏng.', NULL, 'BLA', '/Product/Accessories/MiengLotGiay2.jpg', '50000', '2018-01-22 00:00:00.000', 20, 23),
(23, 5, 1, 'Nón Bitis', '', 'Nón vải Bitis màu Đen', NULL, 'BLA', '/Product/Accessories/Non1.jpg', '75000', '2018-01-23 00:00:00.000', 15, 20),
(24, 1, 3, 'Stain Smith Trắng', '', 'Giày cổ điển của Adidas.', '39', 'WHI', '/Product/Adidas/Adidas1.jpg', '1200000', '2018-01-24 00:00:00.000', 23, 20),
(25, 1, 3, 'Stain Smith Đen', '', 'Giày cổ điển của Adidas.', '39', 'BLA', '/Product/Adidas/Adidas3.jpg', '1200000', '2018-01-25 00:00:00.000', 14, 20),
(26, 1, 3, 'Stain Smith Xanh Dương', '', 'Giày cổ điển của Adidas.', '39', 'BLU', '/Product/Adidas/Adidas4.jpg', '1200000', '2018-01-26 00:00:00.000', 21, 10),
(28, 1, 3, 'Stain Smith Vàng', '', 'Giày cổ điển của Adidas.', '39', 'YEL', '/Product/Adidas/Adidas5.jpg', '1200000', '2018-01-26 00:00:00.000', 25, 15),
(29, 1, 3, 'Stain Smith Xanh Dương nhạt', '', 'Giày cổ điển của Adidas.', '39', 'BLU', '/Product/Adidas/Adidas6.jpg', '1200000', '2018-01-26 00:00:00.000', 15, 19),
(31, 1, 3, 'Stain Smith Hồng', '', 'Giày cổ điển của Adidas.', '39', 'PIN', '/Product/Adidas/Adidas7.jpg', '1200000', '2018-01-26 00:00:00.000', 14, 21),
(32, 1, 3, 'Stain Smith Truyền Thống', '', 'Giày cổ điển của Adidas.', '39', 'WHI', '/Product/Adidas/Adidas10.jpg', '1200000', '2018-01-26 00:00:00.000', 21, 30),
(33, 2, 3, 'Adidas Army', '', 'Giày cổ điển hoạ tiết quân đội.', '40', 'BLA', '/Product/Adidas/Adidas13.jpg', '1300000', '2018-01-17 00:00:00.000', 15, 9),
(34, 1, 3, 'Adidas Đen', '', 'Giày phổ biến nhất của Adidas.', '39', 'BLA', '/Product/Adidas/Adidas15.jpg', '1100000', '2018-01-26 00:00:00.000', 10, 19),
(35, 1, 3, 'Adidas Hồng', '', 'Giày phổ biến nhất của Adidas.', '39', 'PIN', '/Product/Adidas/Adidas16.jpg', '1100000', '2018-01-26 00:00:00.000', 19, 20),
(36, 1, 3, 'Adidas Hồng Đen', '', 'Giày phổ biến nhất của Adidas.', '39', 'BLA', '/Product/Adidas/Adidas17.jpg', '1100000', '2018-01-26 00:00:00.000', 25, 16),
(37, 1, 3, 'Adidas Trắng', '', 'Giày phổ biến nhất của Adidas.', '39', 'WHI', '/Product/Adidas/Adidas18.jpg', '1100000', '2018-01-26 00:00:00.000', 30, 15),
(38, 1, 3, 'Adidas Nâu', '', 'Giày phổ biến nhất của Adidas.', '39', 'BRO', '/Product/Adidas/Adidas19.jpg', '1100000', '2018-01-26 00:00:00.000', 40, 10),
(41, 1, 3, 'Adidas Cam', '', 'Giày phổ biến nhất của Adidas.', '39', 'ORA', '/Product/Adidas/Adidas20.jpg', '1100000', '2018-01-26 00:00:00.000', 45, 15),
(42, 1, 3, 'Adidas New Đen Xanh Rêu', '', 'Giày mẫu mới của Adidas.', '38', 'BLA', '/Product/Adidas/Adidas21.jpg', '1050000', '2018-01-26 00:00:00.000', 30, 25),
(43, 1, 3, 'Adidas New Hồng', '', 'Giày mẫu mới của Adidas.', '38', 'PIN', '/Product/Adidas/Adidas22.jpg', '1050000', '2018-01-26 00:00:00.000', 39, 13),
(44, 2, 3, 'Giày Đá Bóng Adidas Đế Bằng Vàng Xanh', '', 'Giày chuyên dụng cho vận động viên hay người chơi thể thao. Đế giày bằng', '39', 'YEL', '/Product/Adidas/AdidasTheThao1.jpg', '900000', '2018-01-23 00:00:00.000', 40, 11),
(46, 2, 3, 'Giày Đá Bóng Adidas Đế Bằng Xanh Dương', '', 'Giày chuyên dụng cho vận động viên hay người chơi thể thao. Đế giày bằng', '39', 'BLU', '/Product/Adidas/AdidasTheThao2.jpg', '900000', '2018-01-23 00:00:00.000', 45, 18),
(47, 2, 3, 'Giày Đá Bóng Adidas Đế Bằng Đỏ', '', 'Giày chuyên dụng cho vận động viên hay người chơi thể thao. Đế giày bằng', '39', 'RED', '/Product/Adidas/AdidasTheThao3.jpg', '900000', '2018-01-23 00:00:00.000', 39, 15),
(48, 2, 3, 'Giày Đá Bóng Adidas Đế Bằng Đen Xanh Lá', '', 'Giày chuyên dụng cho vận động viên hay người chơi thể thao. Đế giày bằng', '39', 'BLA', '/Product/Adidas/AdidasTheThao4.jpg', '900000', '2018-01-23 00:00:00.000', 37, 16),
(49, 2, 3, 'Giày Đá Bóng Adidas Đế Bằng Trắng Xám', '', 'Giày chuyên dụng cho vận động viên hay người chơi thể thao. Đế giày bằng', '39', 'WHI', '/Product/Adidas/AdidasTheThao5.jpg', '900000', '2018-01-22 00:00:00.000', 36, 18),
(50, 2, 3, 'Giày Đá Bóng Adidas Đế Bằng Đen', '', 'Giày chuyên dụng cho vận động viên hay người chơi thể thao. Đế giày bằng', '39', 'BLA', '/Product/Adidas/AdidasTheThao6.jpg', '900000', '2018-01-22 00:00:00.000', 28, 21),
(51, 2, 3, 'Giày Đá Bóng Adidas Đế Bằng Trắng Đen', '', 'Giày chuyên dụng cho vận động viên hay người chơi thể thao. Đế giày bằng', '39', 'WHI', '/Product/Adidas/AdidasTheThao7.jpg', '900000', '2018-01-22 00:00:00.000', 24, 14),
(52, 2, 3, 'Giày Đá Bóng Adidas Đế Đinh Xanh Dương', '', 'Giày chuyên dụng cho vận động viên hay người chơi thể thao. Đế giày đinh', '39', 'BLU', '/Product/Adidas/AdidasTheThao10.jpg', '1000000', '2018-01-22 00:00:00.000', 30, 15),
(53, 2, 3, 'Giày Đá Bóng Adidas Đế Đinh Đen Đỏ', '', 'Giày chuyên dụng cho vận động viên hay người chơi thể thao. Đế giày đinh', '39', 'BLA', '/Product/Adidas/AdidasTheThao11.jpg', '1000000', '2018-01-22 00:00:00.000', 28, 22),
(54, 2, 3, 'Giày Đá Bóng Adidas Đế Đinh Cam', '', 'Giày chuyên dụng cho vận động viên hay người chơi thể thao. Đế giày đinh', '39', 'ORA', '/Product/Adidas/AdidasTheThao14.jpg', '1000000', '2018-01-22 00:00:00.000', 26, 24),
(56, 2, 3, 'Giày Chạy Bộ Adidas Đỏ', '', 'Giày chuyên dụng cho người chạy bộ', '38', 'RED', '/Product/Adidas/AdidasTheThao15.jpg', '1200000', '2018-01-19 00:00:00.000', 31, 19),
(57, 2, 3, 'Giày Chạy Bộ Adidas Đen', '', 'Giày chuyên dụng cho người chạy bộ', '38', 'BLA', '/Product/Adidas/AdidasTheThao16.jpg', '1200000', '2018-01-19 00:00:00.000', 25, 15),
(58, 2, 3, 'Giày Chạy Bộ Adidas Xanh Dương', '', 'Giày chuyên dụng cho người chạy bộ', '38', 'BLU', '/Product/Adidas/AdidasTheThao19.jpg', '1200000', '2018-01-10 00:00:00.000', 19, 45),
(59, 2, 3, 'Giày Thể Thao Cổ Điển', '', 'Giày thể thao phổ biến của Adidas', '38', 'ORA', '/Product/Adidas/AdidasTheThao13.jpg', '950000', '2018-01-10 00:00:00.000', 50, 45),
(60, 1, 1, 'Giày Bitis Đen Đỏ', '', 'Giày cổ điển Bitis', '39', 'BLA', '/Product/Bitis/Bitis1.jpg', '350000', '2018-01-22 00:00:00.000', 50, 25),
(61, 1, 1, 'Giày Bitis Hồng', '', 'Giày cổ điển Bitis', '39', 'PIN', '/Product/Bitis/Bitis2.jpg', '350000', '2018-01-22 00:00:00.000', 23, 22),
(63, 1, 1, 'Giày Bitis Trắng', '', 'Giày cổ điển Bitis', '39', 'WHI', '/Product/Bitis/Bitis3.jpg', '350000', '2018-01-22 00:00:00.000', 10, 25),
(64, 1, 1, 'Giày Bitis Đen Trắng', '', 'Giày cổ điển Bitis', '39', 'BLA', '/Product/Bitis/Bitis4.jpg', '350000', '2018-01-22 00:00:00.000', 30, 19),
(65, 1, 1, 'Giày Bitis Hunter Trắng Xám', '', 'Giày dòng Bitis Hunter', '39', 'WHI', '/Product/Bitis/Bitis5.jpg', '650000', '2018-01-10 00:00:00.000', 14, 39),
(66, 1, 1, 'Giày Bitis Hunter Cam', '', 'Giày dòng Bitis Hunter', '39', 'ORA', '/Product/Bitis/Bitis6.jpg', '650000', '2018-01-10 00:00:00.000', 23, 45),
(67, 1, 1, 'Giày Bitis Hunter Hồng', '', 'Giày dòng Bitis Hunter', '39', 'PIN', '/Product/Bitis/Bitis7.jpg', '650000', '2018-01-10 00:00:00.000', 12, 45),
(68, 1, 1, 'Giày Bitis Hunter Xanh Dương', '', 'Giày dòng Bitis Hunter', '39', 'BLU', '/Product/Bitis/Bitis8.jpg', '650000', '2018-01-10 00:00:00.000', 45, 35),
(69, 1, 1, 'Giày Bitis Cổ Cao Đen', '', 'Giày Bitis cổ cao', '38', 'BLA', '/Product/Bitis/Bitis10.jpg', '750000', '2018-01-10 00:00:00.000', 30, 10),
(70, 1, 1, 'Giày Bitis Cổ Cao Trắng', '', 'Giày Bitis cổ cao', '38', 'WHI', '/Product/Bitis/Bitis11.jpg', '750000', '2018-01-10 00:00:00.000', 35, 15),
(71, 1, 1, 'Giày Bitis Cổ Cao Hồng', '', 'Giày Bitis cổ cao', '38', 'PIN', '/Product/Bitis/Bitis12.jpg', '750000', '2018-01-10 00:00:00.000', 16, 35),
(72, 3, 1, 'Giày Cao Gót Đen Mũi Bằng', '', 'Giày cao gót mũi bằng', '25', 'BLA', '/Product/Bitis/BitisCaoGot1.jpg', '500000', '2018-01-10 00:00:00.000', 18, 35),
(73, 3, 1, 'Giày Cao Gót Đỏ Mũi Bằng', '', 'Giày cao gót mũi bằng', '25', 'RED', '/Product/Bitis/BitisCaoGot2.jpg', '500000', '2018-01-10 00:00:00.000', 10, 40),
(74, 3, 1, 'Giày Cao Gót Đen Mũi Nhọn', '', 'Giày cao gót mũi nhọn', '25', 'BLA', '/Product/Bitis/BitisCaoGot4.jpg', '500000', '2018-01-10 00:00:00.000', 29, 25),
(75, 3, 1, 'Giày Cao Gót Đen Xanh Dương Mũi Nhọn', '', 'Giày cao gót mũi nhọn', '25', 'BLU', '/Product/Bitis/BitisCaoGot5.jpg', '500000', '2018-01-10 00:00:00.000', 41, 35),
(76, 3, 1, 'Sandal Bitis Cam', '', 'Sandal của hãng Bitis', '35', 'ORA', '/Product/Bitis/BitisSandal1.jpg', '350000', '2018-01-10 00:00:00.000', 35, 70),
(77, 3, 1, 'Sandal Bitis Đen', '', 'Sandal của hãng Bitis', '35', 'BLA', '/Product/Bitis/BitisSandal2.jpg', '350000', '2018-01-10 00:00:00.000', 40, 65),
(78, 3, 1, 'Sandal Bitis Xanh Dương', '', 'Sandal của hãng Bitis', '35', 'BLU', '/Product/Bitis/BitisSandal3.jpg', '350000', '2018-01-10 00:00:00.000', 15, 55),
(79, 3, 1, 'Sandal Bitis Xanh Lá', '', 'Sandal của hãng Bitis', '35', 'GRE', '/Product/Bitis/BitisSandal6.jpg', '350000', '2018-01-10 00:00:00.000', 20, 60),
(80, 3, 1, 'Sandal Bitis Đỏ', '', 'Sandal của hãng Bitis', '35', 'RED', '/Product/Bitis/BitisSandal7.jpg', '350000', '2018-01-10 00:00:00.000', 12, 63),
(81, 2, 1, 'Giày Bitis Hunter X Đen', '', 'Giày dòng Bitis Hunter X', '39', 'BLA', '/Product/Bitis/BitisTheThao2.jpg', '950000', '2018-01-10 00:00:00.000', 5, 80),
(82, 2, 1, 'Giày Bitis Hunter X Hồng', '', 'Giày dòng Bitis Hunter X', '39', 'PIN', '/Product/Bitis/BitisTheThao9.jpg', '950000', '2018-01-10 00:00:00.000', 10, 75),
(83, 2, 1, 'Giày Bitis Hunter X Xanh Dương', '', 'Giày dòng Bitis Hunter X', '39', 'BLU', '/Product/Bitis/BitisTheThao11.jpg', '950000', '2018-01-01 00:00:00.000', 15, 80),
(84, 2, 1, 'Giày Bitis Hunter X Đỏ', '', 'Giày dòng Bitis Hunter X', '39', 'RED', '/Product/Bitis/BitisTheThao12.jpg', '950000', '2018-01-10 00:00:00.000', 35, 65),
(85, 2, 1, 'Giày Bitis Việt Nam', '', 'Giày Bitis đặc biệt theo sự kiện', '39', 'RED', '/Product/Bitis/BitisTheThao10.jpg', '1000000', '2018-01-01 00:00:00.000', 50, 100),
(86, 1, 2, 'Giày Nike Classic Trắng Đen', '', 'Giày cổ điển Nike', '38', 'BLA', '/Product/Nike/Nike1.jpg', '1300000', '2018-01-10 00:00:00.000', 25, 20),
(87, 1, 2, 'Giày Nike Air Đen Xanh Dương', '', 'Giày dòng Air của Nike', '39', 'BLA', '/Product/Nike/Nike3.jpg', '1500000', '2018-01-10 00:00:00.000', 30, 25),
(88, 1, 2, 'Giày Nike Air Đen Xám', '', 'Giày dòng Air của Nike', '39', 'BLA', '/Product/Nike/Nike4.jpg', '1500000', '2018-01-10 00:00:00.000', 47, 25),
(89, 1, 2, 'Giày Nike Air Hồng', '', 'Giày dòng Air của Nike', '39', 'PIN', '/Product/Nike/Nike5.jpg', '1500000', '2018-01-10 00:00:00.000', 38, 20),
(90, 1, 2, 'Giày Nike Air Đỏ', '', 'Giày dòng Air của Nike', '39', 'RED', '/Product/Nike/Nike10.jpg', '1500000', '2018-01-10 00:00:00.000', 29, 15),
(91, 1, 2, 'Giày Nike Zoom X Đen', '', 'Giày Nike dòng cải tiến mới', '38', 'BLA', '/Product/Nike/Nike12.jpg', '1750000', '2018-01-10 00:00:00.000', 26, 28),
(92, 1, 2, 'Giày Nike Zoom X Xanh Dương', '', 'Giày Nike dòng cải tiến mới', '38', 'BLU', '/Product/Nike/Nike9.jpg', '1750000', '2018-01-10 00:00:00.000', 25, 28),
(93, 2, 2, 'Giày Đá Bóng Nike Đỏ', '', 'Giày thể thao Nike', '39', 'RED', '/Product/Nike/NikeTheThao1.jpg', '1100000', '2018-01-10 00:00:00.000', 32, 25),
(94, 2, 2, 'Giày Đá Bóng Nike Xanh Dương', '', 'Giày thể thao Nike', '39', 'BLU', '/Product/Nike/NikeTheThao2.jpg', '1100000', '2018-01-10 00:00:00.000', 21, 20),
(95, 2, 2, 'Giày Đá Bóng Nike Đen', '', 'Giày thể thao Nike', '39', 'BLA', '/Product/Nike/NikeTheThao3.jpg', '1100000', '2018-01-10 00:00:00.000', 30, 15),
(96, 2, 2, 'Giày Đá Bóng Nike Đen Tím', '', 'Giày thể thao Nike', '39', 'BLA', '/Product/Nike/NikeTheThao4.jpg', '1100000', '2018-01-10 00:00:00.000', 10, 35),
(97, 2, 2, 'Giày Đá Bóng Nike Xanh Lá', '', 'Giày thể thao Nike', '39', 'GRE', '/Product/Nike/NikeTheThao5.jpg', '1100000', '2018-01-10 00:00:00.000', 19, 24),
(98, 2, 2, 'Giày Đá Bóng Nike Đen Đế Đinh', '', 'Giày thể thao Nike', '39', 'BLA', '/Product/Nike/NikeTheThao6.jpg', '1100000', '2018-01-10 00:00:00.000', 25, 19),
(99, 2, 2, 'Giày Đá Bóng Nike Đỏ Tím', '', 'Giày thể thao Nike', '39', 'RED', '/Product/Nike/NikeTheThao7.jpg', '1100000', '2018-01-10 00:00:00.000', 35, 20),
(100, 2, 2, 'Giày Đá Bóng Nike Trắng Xanh Dương', '', 'Giày thể thao Nike', '39', 'WHI', '/Product/Nike/NikeTheThao8.jpg', '1100000', '2018-01-10 00:00:00.000', 45, 16),
(101, 1, 2, 'Giày Nike Zoom X Trắng', '', 'Giày Nike dòng cải tiến mới', '38', 'WHI', '/Product/Nike/Nike11.jpg', '1750000', '2018-01-10 00:00:00.000', NULL, 14);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` int(11) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `DiachiKH` varchar(200) DEFAULT NULL,
  `DienthoaiKH` varchar(50) DEFAULT NULL,
  `Ngaysinh` datetime(3) DEFAULT NULL,
  `Taikhoan` varchar(50) DEFAULT NULL,
  `Matkhau` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `HoTen`, `Email`, `DiachiKH`, `DienthoaiKH`, `Ngaysinh`, `Taikhoan`, `Matkhau`) VALUES
(1, 'Trần Gia Huy', 'bang_lang_tim_tim0123@yahoo.com.vn', 'Quận 12', '0365247372', '1998-05-12 00:00:00.000', 'trangiahuysn1998', 'huybin1205'),
(2, 'Tao La Hao', '123', '123', '123', '1998-12-12 00:00:00.000', '123', '123');

-- --------------------------------------------------------

--
-- Table structure for table `nhasanxuat`
--

CREATE TABLE `nhasanxuat` (
  `MaNSX` int(11) NOT NULL,
  `TenNSX` varchar(50) NOT NULL,
  `Diachi` varchar(200) DEFAULT NULL,
  `DienThoai` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nhasanxuat`
--

INSERT INTO `nhasanxuat` (`MaNSX`, `TenNSX`, `Diachi`, `DienThoai`) VALUES
(1, 'Biti\'s', '22 Lý Chiêu Hoàng, Phường 10, Quận 6, TP HCM', '0808310850'),
(2, 'Nike', 'SHOP G3 &G5, G/F, PROVIDENT CENTRE, NORTH POINT, HONG KONG\r\nHong Kong', '0808310851'),
(3, 'Adidas', 'Nguyễn Oanh, Phường 7, 8-10, Hồ Chí Minh', '0808310852'),
(4, 'Khác', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `phanquyen_admin`
--

CREATE TABLE `phanquyen_admin` (
  `MaPQ` int(11) NOT NULL,
  `MaAdmin` int(11) DEFAULT NULL,
  `PQ_NhaSanXuat` tinyint(4) DEFAULT NULL,
  `PQ_Giay` tinyint(4) DEFAULT NULL,
  `PQ_KhachHang` tinyint(4) DEFAULT NULL,
  `PQ_Banner` tinyint(4) DEFAULT NULL,
  `PQ_DonDatHang` tinyint(4) DEFAULT NULL,
  `PQ_CuaHang` tinyint(4) DEFAULT NULL,
  `PQ_DanhMuc` tinyint(4) DEFAULT NULL,
  `PQ_QuangCao` tinyint(4) DEFAULT NULL,
  `PQ_QuanTriAdmin` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `quangcao`
--

CREATE TABLE `quangcao` (
  `MaQC` int(11) NOT NULL,
  `TenQC` varchar(200) DEFAULT NULL,
  `Link` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`MaAdmin`);

--
-- Indexes for table `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`MaBanner`);

--
-- Indexes for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`MaDonHang`,`MaGiay`);

--
-- Indexes for table `cuahang`
--
ALTER TABLE `cuahang`
  ADD PRIMARY KEY (`MaCH`);

--
-- Indexes for table `danhmuc`
--
ALTER TABLE `danhmuc`
  ADD PRIMARY KEY (`MaDM`);

--
-- Indexes for table `dondathang`
--
ALTER TABLE `dondathang`
  ADD PRIMARY KEY (`MaDonHang`);

--
-- Indexes for table `giay`
--
ALTER TABLE `giay`
  ADD PRIMARY KEY (`MaGiay`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Indexes for table `nhasanxuat`
--
ALTER TABLE `nhasanxuat`
  ADD PRIMARY KEY (`MaNSX`);

--
-- Indexes for table `phanquyen_admin`
--
ALTER TABLE `phanquyen_admin`
  ADD PRIMARY KEY (`MaPQ`);

--
-- Indexes for table `quangcao`
--
ALTER TABLE `quangcao`
  ADD PRIMARY KEY (`MaQC`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `MaAdmin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `banner`
--
ALTER TABLE `banner`
  MODIFY `MaBanner` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `cuahang`
--
ALTER TABLE `cuahang`
  MODIFY `MaCH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `danhmuc`
--
ALTER TABLE `danhmuc`
  MODIFY `MaDM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `dondathang`
--
ALTER TABLE `dondathang`
  MODIFY `MaDonHang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1003;

--
-- AUTO_INCREMENT for table `giay`
--
ALTER TABLE `giay`
  MODIFY `MaGiay` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MaKH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nhasanxuat`
--
ALTER TABLE `nhasanxuat`
  MODIFY `MaNSX` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `phanquyen_admin`
--
ALTER TABLE `phanquyen_admin`
  MODIFY `MaPQ` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `quangcao`
--
ALTER TABLE `quangcao`
  MODIFY `MaQC` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
