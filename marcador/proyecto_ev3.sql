-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 14-06-2021 a las 16:42:26
-- Versión del servidor: 10.4.10-MariaDB
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_ev3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anunciantes`
--

DROP TABLE IF EXISTS `anunciantes`;
CREATE TABLE IF NOT EXISTS `anunciantes` (
  `id_anunciante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `logo` varchar(50) NOT NULL,
  `precio` int(11) NOT NULL,
  PRIMARY KEY (`id_anunciante`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `anunciantes`
--

INSERT INTO `anunciantes` (`id_anunciante`, `nombre`, `logo`, `precio`) VALUES
(21, 'zowie', 'zowie.png', 16000),
(2, 'DHL', 'dhl.png', 20000),
(3, 'Logitech', 'logitech.png', 25000),
(4, 'Twitch', 'twitch2.png', 19000),
(5, 'Youtube', 'youtube.png', 150000),
(6, 'AOC', '', 21000),
(22, 'strafe', 'strafe.png', 10000),
(20, 'ggbet', 'ggbet.png', 22000),
(19, 'SecretLab', 'secretLab.png', 25000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

DROP TABLE IF EXISTS `equipos`;
CREATE TABLE IF NOT EXISTS `equipos` (
  `id_equipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `logo` varchar(100) NOT NULL,
  `localizacion` varchar(100) NOT NULL,
  `coach` varchar(100) NOT NULL,
  `fundado` date NOT NULL,
  PRIMARY KEY (`id_equipo`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`id_equipo`, `nombre`, `logo`, `localizacion`, `coach`, `fundado`) VALUES
(1, 'NaVi', 'poner logo', 'Ucrania', 'B1ad3', '2009-12-17'),
(2, 'AVANGAR', 'avangar.png', 'Kazakhstan', 'dastan', '2017-07-17'),
(3, 'Team Liquid', 'otra prueba', 'Estados Unidos', 'adreN', '2000-08-11'),
(4, 'NIP', 'otra prueba', 'test', 'test', '2021-05-22'),
(5, 'Astralis', 'astralis.png', 'Dinamarca', 'zonic', '2016-01-18'),
(7, 'Inventado', 'inventado', 'test', 'test', '2021-05-08'),
(8, 'test1', 'test2', 'test3', 'test4', '2021-05-14'),
(9, 'test', 'test', 'test', 'test', '2021-05-15'),
(10, 'a', 'aa', 'aaa', 'aaaa', '2021-05-20'),
(11, 'prueba', 'p', 'p', 'p', '2021-05-20'),
(14, 'unNombre', 'ponerlogo', 'locali', 'nadie', '2021-05-14'),
(15, 'h', 'h', 'h', 'h', '2021-05-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadisticas_jugador`
--

DROP TABLE IF EXISTS `estadisticas_jugador`;
CREATE TABLE IF NOT EXISTS `estadisticas_jugador` (
  `id_estadistica` int(11) NOT NULL AUTO_INCREMENT,
  `id_partida` int(11) NOT NULL,
  `id_jugador` int(11) NOT NULL,
  `k` int(11) NOT NULL,
  `d` int(11) NOT NULL,
  `a` int(11) NOT NULL,
  `adr` int(11) NOT NULL,
  PRIMARY KEY (`id_estadistica`),
  KEY `id_partida` (`id_partida`),
  KEY `id_jugador` (`id_jugador`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estadisticas_jugador`
--

INSERT INTO `estadisticas_jugador` (`id_estadistica`, `id_partida`, `id_jugador`, `k`, `d`, `a`, `adr`) VALUES
(1, 9, 7, 0, 0, 0, 0),
(2, 9, 8, 0, 0, 0, 0),
(3, 9, 9, 1, 2, 3, 0),
(4, 9, 10, 0, 0, 0, 0),
(5, 9, 21, 0, 0, 0, 0),
(6, 9, 11, 2, 1, 3, 64),
(7, 9, 12, 0, 0, 0, 0),
(8, 9, 13, 0, 0, 0, 0),
(9, 9, 14, 0, 0, 0, 0),
(10, 9, 15, 4, 1, 0, 189);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
CREATE TABLE IF NOT EXISTS `jugadores` (
  `id_jugador` int(11) NOT NULL AUTO_INCREMENT,
  `id_equipo` int(11) NOT NULL,
  `nombre` varchar(125) NOT NULL,
  `aka` varchar(25) NOT NULL,
  `nacionalidad` varchar(100) NOT NULL,
  `rol` varchar(25) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `anhos_activo` varchar(25) NOT NULL,
  `salario` int(11) NOT NULL,
  PRIMARY KEY (`id_jugador`),
  KEY `id_equipo` (`id_equipo`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`id_jugador`, `id_equipo`, `nombre`, `aka`, `nacionalidad`, `rol`, `fecha_nacimiento`, `anhos_activo`, `salario`) VALUES
(1, 1, 'Oleksandr Olehovych Kostyliev', 'S1mple', 'Ucraniania', 'AWPer', '1997-10-02', '2013 – Presente', 125000),
(2, 1, 'Denis Sharipov', 'electronic', 'Rusa', 'Rifler', '1998-09-02', '2015 - Presente', 100000),
(3, 1, 'Egor Vasilev', 'flamie', 'Rusa', 'Rifler', '1997-04-05', '2012 - Presente', 80000),
(4, 1, 'Ilya Zalutskiy', 'Perfecto', 'Rusa', 'Rifler', '1999-11-24', '2018 - Presente', 85000),
(5, 1, 'Kirill Mikhailov', 'Boombl4', 'Rusa', 'IGL', '1998-12-20', '2016 - Presente', 78000),
(21, 2, 'Timur Tulepov', 'buster', 'Kazakhstan', 'rifler', '1999-12-17', '2016 - Presente', 89000),
(7, 2, 'Alexey Golubev', 'qikert', 'Kazakhstan', 'Rifler', '1999-01-01', '2015 - Presente', 75000),
(8, 2, 'Dzhami Ali', 'Jame', 'Rusa', 'AWPer', '1998-08-23', '2017 - Presente', 110000),
(9, 2, 'Sanjar Kuliev', 'SANJI', 'Uzbekistan', 'Rifler', '1998-11-18', '2015 - Presente', 97000),
(10, 2, 'Dauren Kystaubayev', 'AdreN', 'Kazakhastan', 'IGL', '1990-02-04', '2003 - Presente', 115000),
(11, 5, 'Lukas Egholm Rossander', 'gla1ve', 'Danes', 'IGL', '1995-06-07', '2010 - Presente', 100000),
(12, 5, 'Andreas Højsleth', 'Xyp9x', 'Danes', 'rifler', '1995-09-11', '2011 - Presente', 90000),
(13, 5, 'Peter Rothmann Rasmussen', 'dupreeh', 'Danes', 'rifler', '1993-03-26', '2012 - Presente', 90000),
(14, 5, 'Emil Hoffmann Reif', 'Magisk', 'Danes', 'rifler', '1998-03-05', '2015 - Presente', 80000),
(15, 5, 'Nicolai Hvilshøj Reedtz', 'device', 'Danes', 'AWPer', '1995-09-08', '2009 - Presente', 112000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidas`
--

DROP TABLE IF EXISTS `partidas`;
CREATE TABLE IF NOT EXISTS `partidas` (
  `id_partida` int(11) NOT NULL AUTO_INCREMENT,
  `id_equipo1` int(11) NOT NULL,
  `id_equipo2` int(11) NOT NULL,
  `ganador` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora_comienzo` time NOT NULL,
  `hora_finalizacion` time NOT NULL,
  `resultado_rondas` varchar(10) NOT NULL,
  `resultado_total` varchar(10) NOT NULL,
  PRIMARY KEY (`id_partida`),
  KEY `id_equipo1` (`id_equipo1`),
  KEY `id_equipo2` (`id_equipo2`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `partidas`
--

INSERT INTO `partidas` (`id_partida`, `id_equipo1`, `id_equipo2`, `ganador`, `fecha`, `hora_comienzo`, `hora_finalizacion`, `resultado_rondas`, `resultado_total`) VALUES
(9, 2, 5, 5, '2021-05-01', '00:00:00', '00:30:00', '0 - 2', '5 - 16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneos`
--

DROP TABLE IF EXISTS `torneos`;
CREATE TABLE IF NOT EXISTS `torneos` (
  `id_torneo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `equipo_ganador` varchar(50) NOT NULL,
  `lugar` varchar(50) NOT NULL,
  `fecha_comienzo` date NOT NULL,
  `fecha_finalizacion` date NOT NULL,
  `premio` int(11) NOT NULL,
  PRIMARY KEY (`id_torneo`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `torneos`
--

INSERT INTO `torneos` (`id_torneo`, `nombre`, `equipo_ganador`, `lugar`, `fecha_comienzo`, `fecha_finalizacion`, `premio`) VALUES
(3, 'StarLadder Major Berlin 2019', 'Astralis', 'Berlin', '2019-08-23', '2019-09-08', 1000000),
(5, 'b', 'a', 'a', '2021-05-25', '2021-05-25', 1455),
(9, 'test', 'test', 'test', '2021-05-27', '2021-05-28', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneos_anunciantes`
--

DROP TABLE IF EXISTS `torneos_anunciantes`;
CREATE TABLE IF NOT EXISTS `torneos_anunciantes` (
  `id_torneo_anunciante` int(11) NOT NULL AUTO_INCREMENT,
  `id_torneo` int(11) NOT NULL,
  `id_anunciante` int(11) NOT NULL,
  PRIMARY KEY (`id_torneo_anunciante`),
  KEY `id_torneo` (`id_torneo`),
  KEY `id_anunciante` (`id_anunciante`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `torneos_anunciantes`
--

INSERT INTO `torneos_anunciantes` (`id_torneo_anunciante`, `id_torneo`, `id_anunciante`) VALUES
(6, 3, 3),
(3, 50, 351);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneos_equipos`
--

DROP TABLE IF EXISTS `torneos_equipos`;
CREATE TABLE IF NOT EXISTS `torneos_equipos` (
  `id_torneo_equipo` int(11) NOT NULL AUTO_INCREMENT,
  `id_torneo` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  PRIMARY KEY (`id_torneo_equipo`),
  KEY `id_torneo` (`id_torneo`),
  KEY `id_equipo` (`id_equipo`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `torneos_equipos`
--

INSERT INTO `torneos_equipos` (`id_torneo_equipo`, `id_torneo`, `id_equipo`) VALUES
(2, 800, 950),
(5, 12, 25);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
