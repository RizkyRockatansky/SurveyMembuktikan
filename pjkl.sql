-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 23 Agu 2021 pada 11.10
-- Versi server: 10.4.6-MariaDB
-- Versi PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pjkl`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_resets_table', 1),
(5, '2021_08_04_153704_create_tb_kuisioner_table', 2),
(6, '2021_08_04_155007_create_tb_tentang_table', 2),
(10, '2021_08_05_202451_create_tb_hasil_kuisioner_table', 3),
(11, '2021_08_05_203359_create_tb_fuzzyfikasi_table', 3),
(12, '2021_08_05_204757_create_tb_defuzzyfikasi_table', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_admin`
--

CREATE TABLE `tb_admin` (
  `id_admin` int(8) NOT NULL,
  `nama_admin` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_admin`
--

INSERT INTO `tb_admin` (`id_admin`, `nama_admin`, `email`, `password`) VALUES
(3, 'Septian Alhad', 'Septian@gmail.com', 'password'),
(4, 'Nana Mardiana', 'nana@gmail.com', 'password');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_defuzzyfikasi`
--

CREATE TABLE `tb_defuzzyfikasi` (
  `id_defuzzy` bigint(20) UNSIGNED NOT NULL,
  `id_fuzzy` int(11) NOT NULL,
  `harapan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `persepsi` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gap` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `tb_defuzzyfikasi`
--

INSERT INTO `tb_defuzzyfikasi` (`id_defuzzy`, `id_fuzzy`, `harapan`, `persepsi`, `gap`, `created_at`, `updated_at`) VALUES
(24, 24, '3.9666666666666663', '2.7000000000000006', '-1.2666666666666657', NULL, NULL),
(25, 25, '3.933333333333333', '3.2000000000000006', '-0.7333333333333325', NULL, NULL),
(26, 26, '4.066666666666666', '3.0666666666666664', '-1', NULL, NULL),
(27, 27, '4.066666666666666', '2.4', '-1.6666666666666665', NULL, NULL),
(28, 28, '4.033333333333334', '2.7999999999999994', '-1.2333333333333347', NULL, NULL),
(29, 29, '4.133333333333333', '3', '-1.1333333333333329', NULL, NULL),
(30, 30, '4', '2.7000000000000006', '-1.2999999999999994', NULL, NULL),
(31, 31, '4.033333333333334', '2.7999999999999994', '-1.2333333333333347', NULL, NULL),
(32, 32, '3.6666666666666665', '3', '-0.6666666666666665', NULL, NULL),
(33, 33, '4.066666666666666', '3.1', '-0.9666666666666663', NULL, NULL),
(34, 34, '3.9666666666666663', '3.6666666666666665', '-0.2999999999999998', NULL, NULL),
(35, 35, '3.8666666666666667', '2.7000000000000006', '-1.166666666666666', NULL, NULL),
(36, 36, '4.033333333333334', '2.9', '-1.1333333333333342', NULL, NULL),
(37, 37, '4.033333333333334', '3', '-1.033333333333334', NULL, NULL),
(38, 38, '3.933333333333333', '2.966666666666667', '-0.9666666666666663', NULL, NULL),
(39, 39, '3.766666666666667', '2.9', '-0.8666666666666671', NULL, NULL),
(40, 40, '3.9666666666666663', '3.0666666666666664', '-0.8999999999999999', NULL, NULL),
(41, 41, '3.766666666666667', '3.3666666666666667', '-0.40000000000000036', NULL, NULL),
(42, 42, '3.766666666666667', '2.5', '-1.266666666666667', NULL, NULL),
(43, 43, '4.033333333333334', '3.1', '-0.933333333333334', NULL, NULL),
(44, 44, '3.9666666666666663', '3.2000000000000006', '-0.7666666666666657', NULL, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_fuzzyfikasi`
--

CREATE TABLE `tb_fuzzyfikasi` (
  `id_fuzzy` bigint(20) UNSIGNED NOT NULL,
  `id_hasil` int(11) NOT NULL,
  `batasBawahHarapan` int(11) NOT NULL,
  `batasTengahHarapan` int(11) NOT NULL,
  `batasAtasHarapan` int(11) NOT NULL,
  `batasBawahPersepsi` int(11) NOT NULL,
  `batasTengahPersepsi` int(11) NOT NULL,
  `batasAtasPersepsi` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `tb_fuzzyfikasi`
--

INSERT INTO `tb_fuzzyfikasi` (`id_fuzzy`, `id_hasil`, `batasBawahHarapan`, `batasTengahHarapan`, `batasAtasHarapan`, `batasBawahPersepsi`, `batasTengahPersepsi`, `batasAtasPersepsi`, `created_at`, `updated_at`) VALUES
(24, 74, 3, 4, 5, 0, 1, 2, NULL, NULL),
(25, 75, 4, 5, 5, 2, 3, 4, NULL, NULL),
(26, 76, 3, 4, 5, 1, 2, 3, NULL, NULL),
(27, 77, 3, 4, 5, 1, 2, 3, NULL, NULL),
(28, 78, 3, 4, 5, 1, 2, 3, NULL, NULL),
(29, 79, 3, 4, 5, 2, 3, 4, NULL, NULL),
(30, 80, 3, 4, 5, 2, 3, 4, NULL, NULL),
(31, 81, 3, 4, 5, 2, 3, 4, NULL, NULL),
(32, 82, 3, 4, 5, 2, 3, 4, NULL, NULL),
(33, 83, 3, 4, 5, 2, 3, 4, NULL, NULL),
(34, 84, 3, 4, 5, 2, 3, 4, NULL, NULL),
(35, 85, 2, 3, 4, 1, 2, 3, NULL, NULL),
(36, 86, 3, 4, 5, 2, 3, 4, NULL, NULL),
(37, 87, 3, 4, 5, 1, 2, 3, NULL, NULL),
(38, 88, 3, 4, 5, 1, 2, 3, NULL, NULL),
(39, 89, 3, 4, 5, 1, 2, 3, NULL, NULL),
(40, 90, 3, 4, 5, 1, 2, 3, NULL, NULL),
(41, 91, 3, 4, 5, 2, 3, 4, NULL, NULL),
(42, 92, 2, 3, 4, 1, 2, 3, NULL, NULL),
(43, 93, 3, 4, 5, 2, 3, 4, NULL, NULL),
(44, 94, 3, 4, 5, 2, 3, 4, NULL, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_hasil_kuisioner`
--

CREATE TABLE `tb_hasil_kuisioner` (
  `id_hasil` bigint(20) UNSIGNED NOT NULL,
  `id_mhs` int(11) NOT NULL,
  `id_periode` int(11) NOT NULL,
  `id_kuis` int(11) NOT NULL,
  `jawaban_persepsi` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jawaban_harapan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `tb_hasil_kuisioner`
--

INSERT INTO `tb_hasil_kuisioner` (`id_hasil`, `id_mhs`, `id_periode`, `id_kuis`, `jawaban_persepsi`, `jawaban_harapan`, `created_at`, `updated_at`) VALUES
(74, 5, 2, 5, '1', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(75, 5, 2, 6, '3', '5', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(76, 5, 2, 8, '2', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(77, 5, 2, 9, '2', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(78, 5, 2, 10, '2', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(79, 5, 2, 11, '3', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(80, 5, 2, 12, '3', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(81, 5, 2, 13, '3', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(82, 5, 2, 14, '3', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(83, 5, 2, 15, '3', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(84, 5, 2, 16, '3', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(85, 5, 2, 17, '2', '3', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(86, 5, 2, 18, '3', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(87, 5, 2, 20, '2', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(88, 5, 2, 21, '2', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(89, 5, 2, 22, '2', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(90, 5, 2, 23, '2', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(91, 5, 2, 24, '3', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(92, 5, 2, 25, '2', '3', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(93, 5, 2, 26, '3', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(94, 5, 2, 27, '3', '4', '2021-08-22 14:34:08', '2021-08-22 14:34:08'),
(95, 6, 2, 5, '4', '4', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(96, 6, 2, 6, '3', '3', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(97, 6, 2, 8, '3', '3', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(98, 6, 2, 9, '3', '4', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(99, 6, 2, 10, '2', '2', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(100, 6, 2, 11, '3', '3', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(101, 6, 2, 12, '4', '4', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(102, 6, 2, 13, '3', '3', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(103, 6, 2, 14, '3', '2', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(104, 6, 2, 15, '3', '3', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(105, 6, 2, 16, '4', '4', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(106, 6, 2, 17, '3', '3', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(107, 6, 2, 18, '2', '2', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(108, 6, 2, 20, '4', '3', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(109, 6, 2, 21, '2', '3', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(110, 6, 2, 22, '3', '2', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(111, 6, 2, 23, '3', '4', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(112, 6, 2, 24, '3', '2', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(113, 6, 2, 25, '2', '2', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(114, 6, 2, 26, '4', '3', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(115, 6, 2, 27, '4', '4', '2021-08-22 14:42:58', '2021-08-22 14:42:58'),
(116, 7, 2, 5, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(117, 7, 2, 6, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(118, 7, 2, 8, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(119, 7, 2, 9, '2', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(120, 7, 2, 10, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(121, 7, 2, 11, '4', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(122, 7, 2, 12, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(123, 7, 2, 13, '2', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(124, 7, 2, 14, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(125, 7, 2, 15, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(126, 7, 2, 16, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(127, 7, 2, 17, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(128, 7, 2, 18, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(129, 7, 2, 20, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(130, 7, 2, 21, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(131, 7, 2, 22, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(132, 7, 2, 23, '4', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(133, 7, 2, 24, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(134, 7, 2, 25, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(135, 7, 2, 26, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(136, 7, 2, 27, '3', '5', '2021-08-22 15:02:11', '2021-08-22 15:02:11'),
(137, 10, 2, 5, '4', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(138, 10, 2, 6, '3', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(139, 10, 2, 8, '3', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(140, 10, 2, 9, '2', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(141, 10, 2, 10, '3', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(142, 10, 2, 11, '1', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(143, 10, 2, 12, '2', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(144, 10, 2, 13, '2', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(145, 10, 2, 14, '3', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(146, 10, 2, 15, '3', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(147, 10, 2, 16, '4', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(148, 10, 2, 17, '3', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(149, 10, 2, 18, '3', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(150, 10, 2, 20, '4', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(151, 10, 2, 21, '4', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(152, 10, 2, 22, '3', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(153, 10, 2, 23, '3', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(154, 10, 2, 24, '4', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(155, 10, 2, 25, '3', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(156, 10, 2, 26, '3', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(157, 10, 2, 27, '3', '5', '2021-08-22 15:09:57', '2021-08-22 15:09:57'),
(158, 11, 2, 5, '3', '5', '2021-08-22 15:16:29', '2021-08-22 15:16:29'),
(159, 11, 2, 6, '4', '5', '2021-08-22 15:16:29', '2021-08-22 15:16:29'),
(160, 11, 2, 8, '5', '5', '2021-08-22 15:16:29', '2021-08-22 15:16:29'),
(161, 11, 2, 9, '2', '5', '2021-08-22 15:16:29', '2021-08-22 15:16:29'),
(162, 11, 2, 10, '3', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(163, 11, 2, 11, '2', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(164, 11, 2, 12, '1', '4', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(165, 11, 2, 13, '3', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(166, 11, 2, 14, '4', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(167, 11, 2, 15, '3', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(168, 11, 2, 16, '5', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(169, 11, 2, 17, '3', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(170, 11, 2, 18, '3', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(171, 11, 2, 20, '2', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(172, 11, 2, 21, '3', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(173, 11, 2, 22, '4', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(174, 11, 2, 23, '2', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(175, 11, 2, 24, '3', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(176, 11, 2, 25, '2', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(177, 11, 2, 26, '2', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(178, 11, 2, 27, '4', '5', '2021-08-22 15:16:30', '2021-08-22 15:16:30'),
(179, 12, 2, 5, '2', '4', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(180, 12, 2, 6, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(181, 12, 2, 8, '3', '4', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(182, 12, 2, 9, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(183, 12, 2, 10, '3', '4', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(184, 12, 2, 11, '3', '4', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(185, 12, 2, 12, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(186, 12, 2, 13, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(187, 12, 2, 14, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(188, 12, 2, 15, '3', '4', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(189, 12, 2, 16, '3', '4', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(190, 12, 2, 17, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(191, 12, 2, 18, '3', '4', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(192, 12, 2, 20, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(193, 12, 2, 21, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(194, 12, 2, 22, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(195, 12, 2, 23, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(196, 12, 2, 24, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(197, 12, 2, 25, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(198, 12, 2, 26, '2', '3', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(199, 12, 2, 27, '2', '4', '2021-08-22 15:25:53', '2021-08-22 15:25:53'),
(200, 13, 2, 5, '2', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(201, 13, 2, 6, '3', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(202, 13, 2, 8, '4', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(203, 13, 2, 9, '3', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(204, 13, 2, 10, '3', '5', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(205, 13, 2, 11, '3', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(206, 13, 2, 12, '3', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(207, 13, 2, 13, '4', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(208, 13, 2, 14, '2', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(209, 13, 2, 15, '4', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(210, 13, 2, 16, '4', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(211, 13, 2, 17, '3', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(212, 13, 2, 18, '3', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(213, 13, 2, 20, '3', '5', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(214, 13, 2, 21, '3', '5', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(215, 13, 2, 22, '4', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(216, 13, 2, 23, '3', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(217, 13, 2, 24, '4', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(218, 13, 2, 25, '3', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(219, 13, 2, 26, '3', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(220, 13, 2, 27, '3', '4', '2021-08-22 15:36:49', '2021-08-22 15:36:49'),
(221, 14, 2, 5, '2', '1', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(222, 14, 2, 6, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(223, 14, 2, 8, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(224, 14, 2, 9, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(225, 14, 2, 10, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(226, 14, 2, 11, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(227, 14, 2, 12, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(228, 14, 2, 13, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(229, 14, 2, 14, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(230, 14, 2, 15, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(231, 14, 2, 16, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(232, 14, 2, 17, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(233, 14, 2, 18, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(234, 14, 2, 20, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(235, 14, 2, 21, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(236, 14, 2, 22, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(237, 14, 2, 23, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(238, 14, 2, 24, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(239, 14, 2, 25, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(240, 14, 2, 26, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(241, 14, 2, 27, '3', '3', '2021-08-22 15:47:55', '2021-08-22 15:47:55'),
(242, 16, 2, 5, '3', '4', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(243, 16, 2, 6, '4', '3', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(244, 16, 2, 8, '2', '4', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(245, 16, 2, 9, '2', '4', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(246, 16, 2, 10, '3', '4', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(247, 16, 2, 11, '4', '5', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(248, 16, 2, 12, '2', '4', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(249, 16, 2, 13, '3', '5', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(250, 16, 2, 14, '4', '2', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(251, 16, 2, 15, '2', '4', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(252, 16, 2, 16, '4', '2', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(253, 16, 2, 17, '2', '4', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(254, 16, 2, 18, '2', '5', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(255, 16, 2, 20, '4', '5', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(256, 16, 2, 21, '5', '3', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(257, 16, 2, 22, '2', '3', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(258, 16, 2, 23, '4', '3', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(259, 16, 2, 24, '5', '3', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(260, 16, 2, 25, '2', '4', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(261, 16, 2, 26, '4', '5', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(262, 16, 2, 27, '4', '2', '2021-08-22 15:58:26', '2021-08-22 15:58:26'),
(263, 17, 2, 5, '3', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(264, 17, 2, 6, '4', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(265, 17, 2, 8, '3', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(266, 17, 2, 9, '3', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(267, 17, 2, 10, '3', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(268, 17, 2, 11, '4', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(269, 17, 2, 12, '4', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(270, 17, 2, 13, '3', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(271, 17, 2, 14, '3', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(272, 17, 2, 15, '4', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(273, 17, 2, 16, '4', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(274, 17, 2, 17, '3', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(275, 17, 2, 18, '4', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(276, 17, 2, 20, '3', '4', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(277, 17, 2, 21, '3', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(278, 17, 2, 22, '3', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(279, 17, 2, 23, '5', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(280, 17, 2, 24, '4', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(281, 17, 2, 25, '3', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(282, 17, 2, 26, '4', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06'),
(283, 17, 2, 27, '3', '5', '2021-08-22 16:05:06', '2021-08-22 16:05:06');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kategori`
--

CREATE TABLE `tb_kategori` (
  `id_kategori` int(8) NOT NULL,
  `nama_kategori` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_kategori`
--

INSERT INTO `tb_kategori` (`id_kategori`, `nama_kategori`) VALUES
(2, 'Tangible'),
(3, 'Reliability'),
(4, 'Responsiveness'),
(5, 'Assurance'),
(6, 'Emphaty');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kuisioner`
--

CREATE TABLE `tb_kuisioner` (
  `id_kuis` bigint(20) UNSIGNED NOT NULL,
  `pertanyaan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `kode_kuis` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pilihanA` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pilihanB` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pilihanC` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pilihanD` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pilihanE` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `tb_kuisioner`
--

INSERT INTO `tb_kuisioner` (`id_kuis`, `pertanyaan`, `id_kategori`, `kode_kuis`, `pilihanA`, `pilihanB`, `pilihanC`, `pilihanD`, `pilihanE`, `created_at`, `updated_at`) VALUES
(5, 'Kenyamanan, kebersihan, dan keamanan ruang kuliah ?', 2, 'P1', '1', '2', '3', '4', '5', NULL, NULL),
(6, 'Kelengkapan, kenyamanan, kebersihan lab komputer ?', 2, 'P2', '1', '2', '3', '4', '5', NULL, NULL),
(8, 'Kenyamanan, kebersihan dan ketersediaan lahan tempat parkir ?', 2, 'P3', '1', '2', '3', '4', '5', NULL, NULL),
(9, 'Kenyamanan, kebersihan, kelengkapan, dan keamanan ruang UKM ?', 2, 'P4', '1', '2', '3', '4', '5', NULL, NULL),
(10, 'Ketersedian bandwidth hotspot ?', 2, 'P5', '1', '2', '3', '4', '5', NULL, NULL),
(11, 'Kenyamanan, kebersihan dan keamanan Ruang Ibadah (Masjid) ?', 2, 'P6', '1', '2', '3', '4', '5', NULL, NULL),
(12, 'Kenyamanan, kelengkapan, kebersihan dan keamanan Ruang Tunggu waktu jeda kuliah ?', 2, 'P7', '1', '2', '3', '4', '5', NULL, NULL),
(13, 'Ketersediaan Green Area ?', 2, 'P8', '1', '2', '3', '4', '5', NULL, NULL),
(14, 'Kenyamanan, kelengkapan dan kebersihan ruang Toilet-WC ?', 2, 'P9', '1', '2', '3', '4', '5', NULL, NULL),
(15, 'Kurikulum dan proses pembelajaran ?', 3, 'P10', '1', '2', '3', '4', '5', NULL, NULL),
(16, 'Kualitas dan kualifikasi dosen ?', 3, 'P11', '1', '2', '3', '4', '5', NULL, NULL),
(17, 'Suasana perkuliahaan dan praktikum ?', 3, 'P12', '1', '2', '3', '4', '5', NULL, NULL),
(18, 'Materi yang disampaikan dosen jelas dan mudah dimengerti ?', 3, 'P13', '1', '2', '3', '4', '5', NULL, NULL),
(20, 'Respon dan kecepatan dalam pelayanaan ?', 4, 'P14', '1', '2', '3', '4', '5', NULL, NULL),
(21, 'Kualitas layanan secara keseluruhan dalam menunjang kelancaran aktivitas perkuliahan ?', 4, 'P15', '1', '2', '3', '4', '5', NULL, NULL),
(22, 'Relevansi, Akurasi dan tepat waktu SIAKAD POLINDRA ?', 4, 'P16', '1', '2', '3', '4', '5', NULL, NULL),
(23, 'Pengetahuan dan keterampilan yang diperoleh setelah kuliah penguasaan terhadap bidang pekerjaannya ?', 5, 'P17', '1', '2', '3', '4', '5', NULL, NULL),
(24, 'Keamanan kampus ?', 5, 'P18', '1', '2', '3', '4', '5', NULL, NULL),
(25, 'Inisiatif membantu ?', 6, 'P19', '1', '2', '3', '4', '5', NULL, NULL),
(26, 'Keramahan, kesopanan dan sikap dalam pelayanan ?', 6, 'P20', '1', '2', '3', '4', '5', NULL, NULL),
(27, 'Komunikasi yang baik antara mahasiswa dengan pihak jurusan terjalin ?', 6, 'P21', '1', '2', '3', '4', '5', NULL, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_mahasiswa`
--

CREATE TABLE `tb_mahasiswa` (
  `id_mhs` int(8) NOT NULL,
  `nama_mhs` varchar(255) NOT NULL,
  `nim` int(13) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_mahasiswa`
--

INSERT INTO `tb_mahasiswa` (`id_mhs`, `nama_mhs`, `nim`, `email`, `password`) VALUES
(5, 'Rahma', 1703040, 'rahma@admin.com', 'password'),
(6, 'Ridwan', 1705070, 'ridwan@gmail.com', 'password'),
(7, 'Annisa Anjani', 1705017, 'Annisa@gmail.com', 'password'),
(10, 'Muhammad Riko', 1705020, 'Muhammadriko@gmail.com', 'password'),
(11, 'Fathurahman', 1705079, 'fathurahman@gmail.com', 'password'),
(12, 'Ikhwan Isbatullah', 1705027, 'ikhwan@gmail.com', 'password'),
(13, 'Eka Rahadi', 1705003, 'eka@gmail.com', 'password'),
(14, 'Dedi Maulana', 1705025, 'dedi123@gmail.com', 'password'),
(16, 'Anzas Febriyana', 1705001, 'Anzas01@gmail.com', 'password'),
(17, 'Asep Saepudin', 1705080, 'asep@gmail.com', 'password');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_periode`
--

CREATE TABLE `tb_periode` (
  `id_periode` int(8) NOT NULL,
  `nama_periode` varchar(255) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_periode`
--

INSERT INTO `tb_periode` (`id_periode`, `nama_periode`, `tanggal`) VALUES
(2, 'Periode 2', '2021-08-10');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_tentang`
--

CREATE TABLE `tb_tentang` (
  `id_tentang` bigint(20) UNSIGNED NOT NULL,
  `deskripsi` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `tb_tentang`
--

INSERT INTO `tb_tentang` (`id_tentang`, `deskripsi`, `created_at`, `updated_at`) VALUES
(1, 'aplikasi ini tentang kuisioner terhadap kampus Politeknik Negeri Indramayu', NULL, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `email_verified_at`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'Admin', 'admin@gmail.com', NULL, '$2y$10$ncmoI.4BJv5gDMHOgx.d1uM1v1W1kY1HZFsDQlsrOzmdTsHeS0Ioq', NULL, '2021-08-03 12:15:59', '2021-08-03 12:15:59');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`);

--
-- Indeks untuk tabel `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indeks untuk tabel `tb_defuzzyfikasi`
--
ALTER TABLE `tb_defuzzyfikasi`
  ADD PRIMARY KEY (`id_defuzzy`);

--
-- Indeks untuk tabel `tb_fuzzyfikasi`
--
ALTER TABLE `tb_fuzzyfikasi`
  ADD PRIMARY KEY (`id_fuzzy`);

--
-- Indeks untuk tabel `tb_hasil_kuisioner`
--
ALTER TABLE `tb_hasil_kuisioner`
  ADD PRIMARY KEY (`id_hasil`);

--
-- Indeks untuk tabel `tb_kategori`
--
ALTER TABLE `tb_kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indeks untuk tabel `tb_kuisioner`
--
ALTER TABLE `tb_kuisioner`
  ADD PRIMARY KEY (`id_kuis`);

--
-- Indeks untuk tabel `tb_mahasiswa`
--
ALTER TABLE `tb_mahasiswa`
  ADD PRIMARY KEY (`id_mhs`);

--
-- Indeks untuk tabel `tb_periode`
--
ALTER TABLE `tb_periode`
  ADD PRIMARY KEY (`id_periode`);

--
-- Indeks untuk tabel `tb_tentang`
--
ALTER TABLE `tb_tentang`
  ADD PRIMARY KEY (`id_tentang`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT untuk tabel `tb_admin`
--
ALTER TABLE `tb_admin`
  MODIFY `id_admin` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `tb_defuzzyfikasi`
--
ALTER TABLE `tb_defuzzyfikasi`
  MODIFY `id_defuzzy` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT untuk tabel `tb_fuzzyfikasi`
--
ALTER TABLE `tb_fuzzyfikasi`
  MODIFY `id_fuzzy` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT untuk tabel `tb_hasil_kuisioner`
--
ALTER TABLE `tb_hasil_kuisioner`
  MODIFY `id_hasil` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=284;

--
-- AUTO_INCREMENT untuk tabel `tb_kategori`
--
ALTER TABLE `tb_kategori`
  MODIFY `id_kategori` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `tb_kuisioner`
--
ALTER TABLE `tb_kuisioner`
  MODIFY `id_kuis` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT untuk tabel `tb_mahasiswa`
--
ALTER TABLE `tb_mahasiswa`
  MODIFY `id_mhs` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT untuk tabel `tb_periode`
--
ALTER TABLE `tb_periode`
  MODIFY `id_periode` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `tb_tentang`
--
ALTER TABLE `tb_tentang`
  MODIFY `id_tentang` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
