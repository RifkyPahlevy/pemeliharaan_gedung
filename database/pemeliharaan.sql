-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2022 at 05:08 AM
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
  `kd_admin` varchar(20) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `keterangan` varchar(100) NOT NULL,
  `telepon` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `stok` varchar(50) NOT NULL,
  `satuan` varchar(50) NOT NULL,
  `keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id`, `nama`, `jenis`, `stok`, `satuan`, `keterangan`) VALUES
('KB0001', 'Bohlam', 'Kelistrikan', '30', 'pcs', 'Lampu'),
('KB0002', 'Komputer', 'IT', '62', 'Komponen', 'Komputer Untuk resepsionis'),
('KB0003', 'Kabel', 'Kelistrikan', '92', 'm', 'Kabel'),
('KB0004', 'Kabel Lan', 'IT', '94', 'm', 'Perbaikan Internet dan Telepon'),
('KB0005', 'RJ-45', 'IT', '25', 'pcs', 'Perbaikan Internet Dan Telepon');

-- --------------------------------------------------------

--
-- Table structure for table `i_brg`
--

CREATE TABLE `i_brg` (
  `kd_spr` varchar(50) NOT NULL,
  `tgl_brg` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jml` varchar(50) NOT NULL,
  `satuan` varchar(50) NOT NULL,
  `keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `i_brg`
--

INSERT INTO `i_brg` (`kd_spr`, `tgl_brg`, `nama`, `jml`, `satuan`, `keterangan`) VALUES
('SP0001', '2022-06-22', 'Komputer', '1', 'Komponen', 'Komputer Untuk resepsionis');

-- --------------------------------------------------------

--
-- Table structure for table `i_pengaduan`
--

CREATE TABLE `i_pengaduan` (
  `kd_lapor` varchar(50) NOT NULL,
  `tgl` varchar(50) NOT NULL,
  `kd_layanan` varchar(20) NOT NULL,
  `layanan` varchar(50) NOT NULL,
  `kd_area` varchar(20) NOT NULL,
  `kpl_area` varchar(50) NOT NULL,
  `ruang` varchar(50) NOT NULL,
  `telepon` varchar(50) NOT NULL,
  `keluhan` varchar(50) NOT NULL,
  `kd_teknisi` varchar(20) NOT NULL DEFAULT '',
  `teknisi` varchar(50) NOT NULL DEFAULT '',
  `tlp` varchar(50) NOT NULL DEFAULT '',
  `tgl_p` varchar(50) NOT NULL DEFAULT '',
  `status` varchar(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `kpl_teknisi`
--

CREATE TABLE `kpl_teknisi` (
  `id_kpl` varchar(50) NOT NULL,
  `nm_kpl` varchar(50) NOT NULL,
  `j_kelamin` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `telepon` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `k_area`
--

CREATE TABLE `k_area` (
  `kd_area` varchar(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `ruang` varchar(50) NOT NULL,
  `telepon` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `layanan`
--

CREATE TABLE `layanan` (
  `kd_layanan` varchar(11) NOT NULL,
  `nm_layanan` varchar(100) NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `layanan`
--

INSERT INTO `layanan` (`kd_layanan`, `nm_layanan`, `keterangan`) VALUES
('1', 'Internet & Telepon', 'Perbaikan internet di setiap gedung'),
('2', 'Listrik', 'Perbaikan listrik pada setiap gedung');

-- --------------------------------------------------------

--
-- Table structure for table `teknisi`
--

CREATE TABLE `teknisi` (
  `kd_teknisi` varchar(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `keterangan` varchar(100) NOT NULL,
  `telepon` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `t_barang`
--

CREATE TABLE `t_barang` (
  `kd_spr` varchar(50) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_tlp` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_barang`
--

INSERT INTO `t_barang` (`kd_spr`, `Nama`, `alamat`, `no_tlp`, `email`) VALUES
('SP0001', 'solusi', 'mampang', '021356', 'solusi@gmail,com');

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

-- --------------------------------------------------------

--
-- Table structure for table `use_brg`
--

CREATE TABLE `use_brg` (
  `kd_lapor` varchar(50) NOT NULL,
  `kode` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `qty` varchar(50) NOT NULL,
  `satuan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  ADD PRIMARY KEY (`id`),
  ADD KEY `stok` (`stok`);

--
-- Indexes for table `i_brg`
--
ALTER TABLE `i_brg`
  ADD KEY `kd_spr` (`kd_spr`);

--
-- Indexes for table `i_pengaduan`
--
ALTER TABLE `i_pengaduan`
  ADD PRIMARY KEY (`kd_lapor`),
  ADD KEY `kd_layanan` (`kd_layanan`),
  ADD KEY `kd_area` (`kd_area`),
  ADD KEY `kd_teknisi` (`kd_teknisi`);

--
-- Indexes for table `kpl_teknisi`
--
ALTER TABLE `kpl_teknisi`
  ADD PRIMARY KEY (`id_kpl`);

--
-- Indexes for table `k_area`
--
ALTER TABLE `k_area`
  ADD PRIMARY KEY (`kd_area`);

--
-- Indexes for table `layanan`
--
ALTER TABLE `layanan`
  ADD PRIMARY KEY (`kd_layanan`);

--
-- Indexes for table `teknisi`
--
ALTER TABLE `teknisi`
  ADD PRIMARY KEY (`kd_teknisi`);

--
-- Indexes for table `t_barang`
--
ALTER TABLE `t_barang`
  ADD PRIMARY KEY (`kd_spr`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `use_brg`
--
ALTER TABLE `use_brg`
  ADD KEY `kd_lapor` (`kd_lapor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
