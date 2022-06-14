-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-06-2022 a las 05:47:40
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionproductos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `article`
--

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `description` varchar(240) NOT NULL,
  `image` varchar(255) NOT NULL,
  `name` varchar(60) NOT NULL,
  `price` decimal(19,2) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `users_id` int(11) DEFAULT NULL,
  `register_date` datetime DEFAULT NULL,
  `stock` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `article`
--

INSERT INTO `article` (`id`, `code`, `description`, `image`, `name`, `price`, `category_id`, `users_id`, `register_date`, `stock`) VALUES
(136, 45647, 'Libro de Herman Hesse', '689341092e54ab794c825b48ff03ee95-1654792447475.jpg', 'El lobo estepario ', '14.00', 5, 105, '2022-06-09 16:34:07', 27),
(100, 142567, 'Remasterización del famoso album de Muse', '71gL27VZEIL-1652813822187.jpg', 'Muse (Origin of Simetry', '42.00', 2, 54, '2022-05-17 18:57:02', 33),
(107, 654, 'zapato de muelles', '5068b980cf47495a6bda3aa70e22f982-1653003307140.jpg', 'Zapato', '24.00', 3, 105, '2022-05-27 23:35:07', 27),
(135, 156, 'pentium 3', '5068b980cf47495a6bda3aa70e22f982-1653936809388.jpg', 'Ordenador', '1.00', 4, 54, '2022-05-30 18:53:29', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKy5kkohbk00g0w88fi05k2hcw` (`category_id`),
  ADD KEY `FK6qwjxued33ulih2djfjep0hva` (`users_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
