-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 30, 2022 at 02:59 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pemeliharaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `kd_admin` varchar(11) NOT NULL,
  `nama_admin` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `keterangan` varchar(100) NOT NULL,
  `telepon` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`kd_admin`, `nama_admin`, `email`, `username`, `keterangan`, `telepon`, `password`) VALUES
('AD0001', 'Akmal', 'akmal@gmail.com', 'akmal', 'Admin Gudang', '0212334', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `kd_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `stok` varchar(50) NOT NULL,
  `satuan` varchar(50) NOT NULL,
  `kd_admin` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kd_barang`, `nama_barang`, `jenis`, `stok`, `satuan`, `kd_admin`) VALUES
('KB0001', 'Bohlam', 'Kelistrikan', '78', 'pcs', '0'),
('KB0002', 'Komputer', 'IT', '66', 'Komponen', '0'),
('KB0003', 'Kabel', 'Kelistrikan', '91', 'm', '0'),
('KB0004', 'Kabel Lan', 'IT', '94', 'm', '0'),
('KB0005', 'RJ-45', 'IT', '25', 'pcs', '0');

-- --------------------------------------------------------

--
-- Table structure for table `barang_keluar`
--

CREATE TABLE `barang_keluar` (
  `kd_lapor` varchar(50) NOT NULL,
  `kd_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `stok` int(20) NOT NULL,
  `satuan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang_keluar`
--

INSERT INTO `barang_keluar` (`kd_lapor`, `kd_barang`, `nama_barang`, `stok`, `satuan`) VALUES
('LP0001', 'KB0002', 'Komputer', 1, 'Komponen');

--
-- Triggers `barang_keluar`
--
DELIMITER $$
CREATE TRIGGER `stok_keluar` BEFORE INSERT ON `barang_keluar` FOR EACH ROW BEGIN 
UPDATE barang SET stok = stok - NEW.stok
WHERE kd_barang = NEW.kd_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `barang_masuk`
--

CREATE TABLE `barang_masuk` (
  `kd_spr` varchar(50) NOT NULL,
  `tgl_brg` varchar(50) NOT NULL,
  `kd_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `stok` int(20) NOT NULL,
  `satuan` varchar(50) NOT NULL,
  `jenis` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang_masuk`
--

INSERT INTO `barang_masuk` (`kd_spr`, `tgl_brg`, `kd_barang`, `nama_barang`, `stok`, `satuan`, `jenis`) VALUES
('SP0002', '2022-06-24', 'KB0004', 'Kabel Lan', 1, 'm', 'IT'),
('SP0002', '2022-06-24', 'KB0001', 'Bohlam', 1, 'pcs', 'Kelistrikan');

--
-- Triggers `barang_masuk`
--
DELIMITER $$
CREATE TRIGGER `stok_masuk` AFTER INSERT ON `barang_masuk` FOR EACH ROW BEGIN 
INSERT INTO barang SET kd_barang = NEW.kd_barang, 
stok = NEW.stok, 
nama_barang = NEW.nama_barang,
satuan = NEW.satuan,
jenis = NEW.jenis
ON DUPLICATE KEY UPDATE stok = stok + NEW.stok;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `kpl_area`
--

CREATE TABLE `kpl_area` (
  `kd_kplarea` varchar(20) NOT NULL,
  `nama_kplarea` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `ruang` varchar(50) NOT NULL,
  `telepon` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kpl_area`
--

INSERT INTO `kpl_area` (`kd_kplarea`, `nama_kplarea`, `email`, `username`, `password`, `ruang`, `telepon`) VALUES
('KA0001', 'rizky', 'rizky@gmail.com', 'rizky', 'area', 'R-0001', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `kpl_teknisi`
--

CREATE TABLE `kpl_teknisi` (
  `kd_kplteknisi` varchar(50) NOT NULL,
  `nama_kplteknisi` varchar(50) NOT NULL,
  `j_kelamin` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `telepon` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kpl_teknisi`
--

INSERT INTO `kpl_teknisi` (`kd_kplteknisi`, `nama_kplteknisi`, `j_kelamin`, `alamat`, `username`, `password`, `telepon`) VALUES
('KP0001', 'ismi', 'Laki-Laki', 'mampang', 'ismi', 'kepala', '02212');

-- --------------------------------------------------------

--
-- Table structure for table `layanan`
--

CREATE TABLE `layanan` (
  `kd_layanan` varchar(11) NOT NULL,
  `nama_layanan` varchar(50) NOT NULL,
  `keterangan` varchar(100) NOT NULL,
  `kd_admin` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `layanan`
--

INSERT INTO `layanan` (`kd_layanan`, `nama_layanan`, `keterangan`, `kd_admin`) VALUES
('KL0001', 'Listrik', 'perbaikan listrik', 'AD0001'),
('KL0002', 'Pam & Air', 'perbaikan air', 'AD0003'),
('KL0003', 'Internet & Telepon', 'Perbaikan Internet dll', 'AD0003'),
('KL0004', 'properti', 'Perbaikan Properti', 'AD0003'),
('KL0005', 'Mesin ', 'pebaikan mesin dsb', 'AD0003');

-- --------------------------------------------------------

--
-- Table structure for table `pengaduan`
--

CREATE TABLE `pengaduan` (
  `kd_lapor` varchar(50) NOT NULL,
  `tgl` varchar(50) NOT NULL,
  `kd_layanan` varchar(20) NOT NULL,
  `kd_kplarea` varchar(20) NOT NULL,
  `keluhan` varchar(50) NOT NULL,
  `kd_teknisi` varchar(11) DEFAULT NULL,
  `tgl_perbaikan` varchar(50) NOT NULL DEFAULT '',
  `status` varchar(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengaduan`
--

INSERT INTO `pengaduan` (`kd_lapor`, `tgl`, `kd_layanan`, `kd_kplarea`, `keluhan`, `kd_teknisi`, `tgl_perbaikan`, `status`) VALUES
('LP0001', '2022-06-30', 'KL0002', 'KA0001', 'Air mati', 'KT0001', '2022-06-30', 'Diterima');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `kd_spr` varchar(50) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_tlp` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`kd_spr`, `Nama`, `alamat`, `no_tlp`, `email`) VALUES
('SP0001', 'Solusi', 'Mampang', '002993', 'klks');

-- --------------------------------------------------------

--
-- Table structure for table `teknisi`
--

CREATE TABLE `teknisi` (
  `kd_teknisi` varchar(11) NOT NULL,
  `nama_teknisi` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `keterangan` varchar(100) NOT NULL,
  `telepon` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teknisi`
--

INSERT INTO `teknisi` (`kd_teknisi`, `nama_teknisi`, `email`, `username`, `password`, `keterangan`, `telepon`) VALUES
('KT0001', 'muflih', 'muflih@gmail.com', 'muflih', 'teknisi', 'Teknisi Listrik', '09994');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `level` varchar(50) NOT NULL,
  `telepon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nama`, `username`, `password`, `level`, `telepon`) VALUES
('AD0001', 'Akmal', 'akmal', 'admin', 'Admin', '0212334'),
('KA0001', 'rizky', 'rizky', 'area', 'Area', '12345'),
('KP0001', 'ismi', 'ismi', 'kepala', 'Kepala Teknisi', '02212'),
('KT0001', 'muflih', 'muflih', 'teknisi', 'Teknisi', '09994');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`kd_admin`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kd_barang`),
  ADD KEY `stok` (`stok`),
  ADD KEY `kd_admin` (`kd_admin`);

--
-- Indexes for table `barang_keluar`
--
ALTER TABLE `barang_keluar`
  ADD KEY `kd_lapor` (`kd_lapor`),
  ADD KEY `kd_barang` (`kd_barang`);

--
-- Indexes for table `barang_masuk`
--
ALTER TABLE `barang_masuk`
  ADD KEY `kd_spr` (`kd_spr`),
  ADD KEY `kd_barang` (`kd_barang`);

--
-- Indexes for table `kpl_area`
--
ALTER TABLE `kpl_area`
  ADD PRIMARY KEY (`kd_kplarea`);

--
-- Indexes for table `kpl_teknisi`
--
ALTER TABLE `kpl_teknisi`
  ADD PRIMARY KEY (`kd_kplteknisi`);

--
-- Indexes for table `layanan`
--
ALTER TABLE `layanan`
  ADD PRIMARY KEY (`kd_layanan`),
  ADD KEY `kd_admin` (`kd_admin`);

--
-- Indexes for table `pengaduan`
--
ALTER TABLE `pengaduan`
  ADD PRIMARY KEY (`kd_lapor`),
  ADD KEY `kd_layanan` (`kd_layanan`),
  ADD KEY `kd_area` (`kd_kplarea`),
  ADD KEY `kd_teknisi` (`kd_teknisi`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`kd_spr`);

--
-- Indexes for table `teknisi`
--
ALTER TABLE `teknisi`
  ADD PRIMARY KEY (`kd_teknisi`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang_keluar`
--
ALTER TABLE `barang_keluar`
  ADD CONSTRAINT `barang_keluar_ibfk_2` FOREIGN KEY (`kd_barang`) REFERENCES `barang` (`kd_barang`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `barang_keluar_ibfk_3` FOREIGN KEY (`kd_lapor`) REFERENCES `pengaduan` (`kd_lapor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pengaduan`
--
ALTER TABLE `pengaduan`
  ADD CONSTRAINT `pengaduan_ibfk_1` FOREIGN KEY (`kd_kplarea`) REFERENCES `kpl_area` (`kd_kplarea`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `pengaduan_ibfk_3` FOREIGN KEY (`kd_layanan`) REFERENCES `layanan` (`kd_layanan`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `pengaduan_ibfk_4` FOREIGN KEY (`kd_teknisi`) REFERENCES `teknisi` (`kd_teknisi`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
