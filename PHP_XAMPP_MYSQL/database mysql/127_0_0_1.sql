-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Des 2021 pada 08.35
-- Versi server: 10.4.18-MariaDB
-- Versi PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `car_catalog`
--
CREATE DATABASE IF NOT EXISTS `car_catalog` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `car_catalog`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phoneNumber` varchar(30) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `phoneNumber`, `username`, `password`) VALUES
(1, 'admin', 'admin@gmail.com', '081297507252', 'admin', 'admin'),
(2, 'pergun', 'pergun@gmail.com', '081297507252', 'pergun', 'pergun'),
(3, 'kelvin', 'kelvinchandra@gmail.com', '081386479090', 'kelvin', '32190041'),
(4, 'felix', 'felixsetiawan@gmail.com', '082111211221', 'felix', '32190034'),
(5, 'reynaldo', 'reynaldokrisno@gmail.com', '0895331059723', 'reynaldo', '32190097'),
(6, 'samuel', 'samuelsulianto@gmail.com', '08232313213', 'samuel', 'samuel'),
(8, 'yurino', 'yurino@gmail.com', '0832213123', 'yurino', 'yurino123'),
(9, 'pandu', 'pandu@gmail.com', '08128493332', 'pandu', 'pandu123'),
(10, 'reynaldi', 'reynaldiphenato@gmail.com', '08123332133', 'reynaldi', 'aldi123'),
(11, 'kusuma', 'kevinkusuma@gmail.com', '08192312454', 'kusuma', 'kusuma123'),
(12, 'arya', 'aryapraditya@gmail.com', '08581232132', 'artzy', 'arya123'),
(13, 'christopher', 'christopher@gmail.com', '085771232126', 'christopher', 'toper123'),
(14, 'davin', 'davinchristian@gmail.com', '085787262134', 'davin', 'davin123'),
(15, 'juandi', 'juandi@gmail.com', '081388231567', 'juandi', 'juandi123'),
(16, 'robert', 'robert@gmail.com', '0856771238', 'robert', 'robert123'),
(17, 'fendyanto', 'fendyanto@gmail.com', '085812776590', 'fendy', 'fendyanto123'),
(18, 'michael', 'michaelaswita@gmail.com', '081284927586', 'michael', 'michael123'),
(19, 'vintonius', 'vintonius@gmail.com', '0823746392', 'vintonius', 'vinto123'),
(20, 'dicky', 'dickychandra@gmail.com', '085690977264', 'dicky', 'dicky123'),
(21, 'eko', 'ekoraharja@gmail.com', '081283219312', 'raharja', 'eko123');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`,`email`,`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
