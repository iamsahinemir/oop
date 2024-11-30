-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 30 Kas 2024, 14:51:27
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
  `dateofbirth` date DEFAULT NULL,
  `dateofstart` date DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `employees`
--

INSERT INTO `employees` (`e_id`, `username`, `password`, `role`, `name`, `surname`, `phone_number`, `dateofbirth`, `dateofstart`, `email`) VALUES
(1, 'iamsahinemir', 'emir12345', 'manager', 'Emir Esad', 'Şahin', '05438813007', '2000-12-15', '2022-09-09', 'iamsahinemir@sezai.com'),
(2, 'dede', 'dede1234', 'intern', 'Tunahan', 'Tüze', '05320564506', '2000-06-25', '2021-09-20', 'tunahantuze@stu.khas.edu.tr'),
(3, 'sezowastaken', 'sezo1234', 'technician', 'Sezai', 'Araplarlı', '05337918337', '2004-01-01', '2022-09-20', 'sezowastaken@stu.khas.edu.tr'),
(4, 'dilvinn2', 'dilvin1234', 'intern', 'Dilvin', 'Aydın', '05433770681', '2000-01-01', '2020-09-20', 'dilvinaydin@stu.khas.edu.tr'),
(5, 'zülal1', 'zülal1234', 'intern', 'Zülal', 'Sönmez', '05303049250', '2000-01-01', '2020-09-09', 'zulalsonmez@stu.khas.edu.tr'),
(6, 'jdoe', '12345', 'manager', 'John', 'Doe', '555-1234', '1980-01-01', '2020-01-01', 'jdoe@example.com'),
(7, 'asmith', 'password', 'engineer', 'Alice', 'Smith', '555-5678', '1990-02-15', '2021-06-01', 'asmith@example.com'),
(8, 'deneme', 'deneme', 'intern', 'deneme1', 'deneme2', NULL, NULL, NULL, NULL);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`e_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `employees`
--
ALTER TABLE `employees`
  MODIFY `e_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
