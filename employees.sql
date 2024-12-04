-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 04 Ara 2024, 18:26:40
-- Sunucu sürümü: 10.4.32-MariaDB
-- PHP Sürümü: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `firm_management_11`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `employees`
--

CREATE TABLE `employees` (
  `e_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` enum('manager','engineer','technician','intern') NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `dateofbirth` varchar(50) DEFAULT NULL,
  `dateofstart` varchar(50) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `employees`
--

INSERT INTO `employees` (`e_id`, `username`, `password`, `role`, `name`, `surname`, `phone_number`, `dateofbirth`, `dateofstart`, `email`) VALUES
(1, 'iamsahinemir', 'asd', 'manager', 'emir', 'şahin', '05555555559', '2000-12-15', '2022-09-09', 'esad.emir34@stu.khas.edu.tr'),
(2, 'dede', '123', 'intern', 'Tunahan', 'Tüze', '05694712305', '2000-06-25', '2021-09-20', 'deneme@tuna.com'),
(3, 'sezowastaken', 'sezo1234', 'manager', 'Sezai', 'Büyükdalga', '05337918339', '2004-01-01', '2022-09-20', 'sezowastaken@stu.khas.edu.tr'),
(5, 'zülal1', 'zülal1234', 'intern', 'Zülal', 'Sönmez', '05303049250', '2000-01-01', '2020-09-09', 'zulalsonmez@stu.khas.edu.tr'),
(6, 'jdoe', '12345', 'intern', 'emir', 'emir', '05555555569', '1980-01-01', '2020-01-01', 'jdoe@example.com'),
(7, 'asmith', 'password', 'engineer', 'Alice', 'Smith', '05555575559', '1990-02-15', '2021-06-01', 'asmith@example.com'),
(8, 'abc', 'abc', 'technician', 'abc', 'abc', '05555555551', '1990-02-15', '2021-06-01', 'abc@abc.com'),
(9, 'hasanco', 'hasanco', 'manager', 'hasan', 'coşkun', '05438813007', '2000-12-15', '2022-12-15', 'example@example.com'),
(10, 'mirayköksal', 'miray', 'manager', 'miray', 'köksal', '05555555555', '2000-12-15', '2022-12-15', 'miray@miray.com'),
(11, 'berilk', 'beril1234', 'intern', 'Berili', 'Kurt', '05313254678', '2002-06-21', '2022-09-20', 'beril@beril.com'),
(12, 'proje2', 'proje2', 'technician', 'Proje', '2', '05313254677', '2002-06-21', '2022-09-20', 'projee@ilktanhoca.com'),
(13, 'proje3', 'proje3', 'engineer', 'Proje', '3', '05313254676', '2002-06-21', '2022-09-20', 'proje@ilktanhoca.com'),
(14, 'proje4', 'proje4', 'engineer', 'Proje', '4', '05313254675', '2002-06-21', '2022-09-20', 'proje4@ilktanhoca.com'),
(15, 'proje6', 'proje6', 'technician', 'Proje', '6', '05313254674', '2002-06-21', '2022-09-20', 'proje3@ilktanhoca.com'),
(16, 'proje5', 'proje5', 'intern', 'Proje', '5', '05313254673', '2002-06-21', '2022-09-20', 'proje5@ilktanhoca.com'),
(17, 'oop', 'oop', 'engineer', 'OOP', 'ders', '05313254672', '2002-06-21', '2022-09-20', 'oop@ilktanhoca.com'),
(18, 'khas', 'khas', 'intern', 'Khas', 'Khas', '05313254671', '2002-06-21', '2022-09-20', 'khas@khas.com'),
(19, 'Okul', 'Okul', 'intern', 'Okul', 'Okul', '05313254670', '2002-06-21', '2022-09-20', 'proje9@ilktanhoca.com'),
(20, 'Sınav', 'Sınav', 'intern', 'Sınav', 'Sınav', '05313254699', '2002-06-21', '2022-09-20', 'sınav@ilktanhoca.com');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`e_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `username_2` (`username`),
  ADD UNIQUE KEY `unique_columns` (`username`,`phone_number`,`email`),
  ADD UNIQUE KEY `phone_number` (`phone_number`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `employees`
--
ALTER TABLE `employees`
  MODIFY `e_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
