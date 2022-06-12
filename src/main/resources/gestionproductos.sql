-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2022 a las 00:56:16
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
  `register_date` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `article`
--

INSERT INTO `article` (`id`, `code`, `description`, `image`, `name`, `price`, `category_id`, `users_id`, `register_date`) VALUES
(108, 4578, 'Libro de Herman Hesse', '689341092e54ab794c825b48ff03ee95-1653415355330.jpg', 'El lobo estepario ', '14.00', 5, 54, '2022-05-24 18:02:35'),
(100, 142567, 'Remasterización del famoso album de Muse', '71gL27VZEIL-1652813822187.jpg', 'Muse (Origin of Simetry', '42.00', 2, 54, '2022-05-17 18:57:02'),
(107, 654, 'zapato de muelles', '5068b980cf47495a6bda3aa70e22f982-1653003307140.jpg', 'Zapato', '24.00', 3, 105, '2022-05-27 23:35:07'),
(135, 156, 'pentium 3', '5068b980cf47495a6bda3aa70e22f982-1653936809388.jpg', 'Ordenador', '1.00', 4, 54, '2022-05-30 18:53:29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(60) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(5, 'Libros'),
(4, 'Tecnología'),
(3, 'Moda'),
(2, 'Música'),
(1, 'Deportes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `text` varchar(1024) NOT NULL,
  `author_id` int(11) DEFAULT NULL,
  `receiver_id` int(11) DEFAULT NULL,
  `register_date` datetime DEFAULT NULL,
  `stars` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comments`
--

INSERT INTO `comments` (`id`, `text`, `author_id`, `receiver_id`, `register_date`, `stars`) VALUES
(1, 'Quiero mostrar mi satisfacción con este vendedor.', 54, 105, '2022-05-20 22:00:00', 0),
(2, 'Quiero quejarme del comportamiento de este vendedor', 105, 54, '2022-05-27 13:01:35', 0),
(3, 'Magnifica compra!!', 105, 54, '2022-05-27 13:01:35', 0),
(121, 'Una de las mejores compras de mi vida', 54, 105, '2022-05-28 17:47:27', 0),
(132, 'Todo perfecto, magnífico vendedor!!', 54, 105, '2022-05-29 17:07:44', 5),
(133, 'Bravisimo es un gran vendedor.', 54, 105, '2022-05-29 19:26:36', 4),
(134, 'sdfasdf', 54, 105, '2022-05-29 19:27:00', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `confirmation_token`
--

CREATE TABLE `confirmation_token` (
  `token_id` bigint(20) NOT NULL,
  `confirmation_token` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `confirmation_token`
--

INSERT INTO `confirmation_token` (`token_id`, `confirmation_token`, `created_date`, `id`) VALUES
(93, 'b5ab2e25-eae2-4e97-961a-77604d200d9c', '2022-05-14 19:11:50', 92),
(95, '66e3da87-234f-4972-8c7a-a6d878e85524', '2022-05-14 19:13:55', 94),
(106, '92f5aa94-aa57-4c8a-8972-7aa4e2aff6bf', '2022-05-19 23:34:29', 105);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(136);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `balance` double(19,2) DEFAULT NULL,
  `birthday` datetime NOT NULL,
  `dni` varchar(9) NOT NULL,
  `email` varchar(50) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `name` varchar(40) NOT NULL,
  `password` varchar(60) NOT NULL,
  `password_confirm` varchar(60) NOT NULL,
  `register_date` datetime DEFAULT NULL,
  `surname` varchar(90) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `num_ventas` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `balance`, `birthday`, `dni`, `email`, `enabled`, `name`, `password`, `password_confirm`, `register_date`, `surname`, `phone`, `num_ventas`) VALUES
(12, 5400.22, '2022-05-20 22:00:00', '7777777d', 'carmen@gmail.com2', b'0', 'Carmen', '$2a$10$zcpsyNLM1rcTJWXtLhXXYOqWfdvqj4LZYYXZURd/46EInCV/fn7Py', '$2a$10$/U09iqXy5VKrha9Awqwa.eRFZmusgwmIcN1r2KYs1eReCGqlGgJDa', '2022-05-14 19:13:55', 'Castrillon', '626545898', 6),
(54, 2406.17, '2022-05-13 22:00:00', '76084354D', 'ignacastrisa@gmail.com', b'0', 'Ignacio', '$2a$10$Q6qQd5ZAKSOKCrqQAJ91hewH/f4A7lC2E6pMo2VfD5E1cRY2QF1Ma', '$2a$10$mWGM0TrfF3CFh2Y1CR3J.Ocibs2EKqUs0z2fpgaXyg0X9850G0G4a', '2022-05-14 19:11:50', 'Suarez', '645897874', 104),
(105, 40.00, '2022-05-13 22:00:00', '76084354D', 'antonio@gmail.com', b'0', 'Antonio', '$2a$10$xQP83I1o6ji7oNwKlwdWtOqAOXnrtlnybnfTQ6/zrTmEQ2DUy4vkC', '$2a$10$DnB7za.PQF5FR5l4vCtNG.vvnjhRXZh/Jx.4LYMcjAInBLwWcLF7O', '2022-05-19 23:34:29', 'Vazquez', '601386780', 32);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valuation`
--

CREATE TABLE `valuation` (
  `id` int(11) NOT NULL,
  `register_date` datetime DEFAULT NULL,
  `value` int(11) NOT NULL,
  `author_id` int(11) DEFAULT NULL,
  `receiver_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

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

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn2na60ukhs76ibtpt9burkm27` (`author_id`),
  ADD KEY `FKpxfn7ilgawc0x7m694fpjud62` (`receiver_id`);

--
-- Indices de la tabla `confirmation_token`
--
ALTER TABLE `confirmation_token`
  ADD PRIMARY KEY (`token_id`),
  ADD KEY `FK9w4f2glynfjh5utjtbxpfgpgh` (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `valuation`
--
ALTER TABLE `valuation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKler65m99et4mts57yd43ka63b` (`author_id`),
  ADD KEY `FK99k3yvq1hl6lvonm7mpcp0ex2` (`receiver_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
