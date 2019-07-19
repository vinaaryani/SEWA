-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2019 at 08:46 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sewakamera`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  `level` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`, `level`) VALUES
('admin', 'admin', 'admin'),
('petugas', 'petugas', 'petugas');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjam` char(10) NOT NULL,
  `id_petugas` char(10) NOT NULL,
  `id_penyewa` char(10) NOT NULL,
  `id_kamera` char(10) NOT NULL,
  `merk_kamera` varchar(20) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `jaminan_pinjam` varchar(20) NOT NULL,
  `harga_sewa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjam`, `id_petugas`, `id_penyewa`, `id_kamera`, `merk_kamera`, `tanggal_pinjam`, `jaminan_pinjam`, `harga_sewa`) VALUES
('P01', '12345', 'P001', 'K002', 'Canon 650D', '2019-09-11', 'KTP', 100000),
('P02', '12345', 'P002', 'K001', 'Canon 1100D', '2019-09-08', 'Kartu Identitas', 75000);

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id_pengembalian` char(10) NOT NULL,
  `id_peminjam` char(10) NOT NULL,
  `id_petugas` char(10) NOT NULL,
  `id_penyewa` char(10) NOT NULL,
  `id_kamera` char(10) NOT NULL,
  `merk_kamera` varchar(20) NOT NULL,
  `jaminan_pinjam` varchar(20) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `lama_sewa` int(11) NOT NULL,
  `harga_sewa` int(11) NOT NULL,
  `denda` int(11) NOT NULL,
  `total_bayar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`id_pengembalian`, `id_peminjam`, `id_petugas`, `id_penyewa`, `id_kamera`, `merk_kamera`, `jaminan_pinjam`, `tanggal_pinjam`, `tanggal_kembali`, `lama_sewa`, `harga_sewa`, `denda`, `total_bayar`) VALUES
('PK01', 'P01', '12345', 'P001', 'K002', 'Canon 650D', '100000', '2019-09-11', '2019-09-16', 5, 100000, 30000, 530000),
('PK03', 'P02', '12345', 'P002', 'K001', 'Canon 1100D', '75000', '2019-09-08', '2019-09-14', 3, 75000, 30000, 330000);

-- --------------------------------------------------------

--
-- Table structure for table `penyewa`
--

CREATE TABLE `penyewa` (
  `id_penyewa` char(10) NOT NULL,
  `nama_penyewa` varchar(30) NOT NULL,
  `alamat` varchar(25) NOT NULL,
  `no_telepon` char(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penyewa`
--

INSERT INTO `penyewa` (`id_penyewa`, `nama_penyewa`, `alamat`, `no_telepon`) VALUES
('P001', 'Vina', 'Ngemplak', '081567891015'),
('P002', 'Aryani', 'Surakarta', '089668267861');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` char(10) NOT NULL,
  `nama_petugas` varchar(30) NOT NULL,
  `alamat` varchar(25) NOT NULL,
  `no_telepon` char(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama_petugas`, `alamat`, `no_telepon`) VALUES
('12345', 'Vina Aryani', 'Solo', '089668413915');

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `id_kamera` char(10) NOT NULL,
  `merk_kamera` varchar(20) NOT NULL,
  `jenis_kamera` varchar(25) NOT NULL,
  `harga_sewa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`id_kamera`, `merk_kamera`, `jenis_kamera`, `harga_sewa`) VALUES
('K001', 'Canon 1100D', 'Dslr Camera', 75000),
('K002', 'Canon 650D', 'Dslr Camera', 100000),
('K003', 'Fujifilm Xa10', 'Mirrorless Camera', 100000),
('K004', 'Sony A6000', 'Mirrorless Camera', 120000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjam`),
  ADD KEY `id_petugas` (`id_petugas`),
  ADD KEY `id_penyewa` (`id_penyewa`),
  ADD KEY `id_kamera` (`id_kamera`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`),
  ADD KEY `id_peminjam` (`id_peminjam`),
  ADD KEY `id_petugas` (`id_petugas`),
  ADD KEY `id_penyewa` (`id_penyewa`),
  ADD KEY `id_kamera` (`id_kamera`);

--
-- Indexes for table `penyewa`
--
ALTER TABLE `penyewa`
  ADD PRIMARY KEY (`id_penyewa`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id_kamera`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`id_peminjam`) REFERENCES `pengembalian` (`id_peminjam`),
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`id_kamera`) REFERENCES `produk` (`id_kamera`),
  ADD CONSTRAINT `peminjaman_ibfk_3` FOREIGN KEY (`id_penyewa`) REFERENCES `penyewa` (`id_penyewa`),
  ADD CONSTRAINT `peminjaman_ibfk_4` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
