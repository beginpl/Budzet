-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 16 Lut 2017, 17:56
-- Wersja serwera: 5.5.21-log
-- Wersja PHP: 5.4.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `budzetdomowy`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dochod`
--

CREATE TABLE IF NOT EXISTS `dochod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cena` double NOT NULL,
  `opis` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=3 ;

--
-- Zrzut danych tabeli `dochod`
--

INSERT INTO `dochod` (`id`, `cena`, `opis`) VALUES
(1, 303, 'Test');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wydatek`
--

CREATE TABLE IF NOT EXISTS `wydatek` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `cena` double NOT NULL,
  `opis` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=2 ;

--
-- Zrzut danych tabeli `wydatek`
--

INSERT INTO `wydatek` (`id`, `cena`, `opis`) VALUES
(1, 20, 'test');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
