-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 03 Mars 2018 à 15:40
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `autisme`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `admin`
--

INSERT INTO `admin` (`id`, `nom`, `prenom`, `login`, `pass`) VALUES
(1, 'el madhoun', 'soumia', 'soso', 'elma'),
(2, 'el atifi', 'ghizlane', 'ghazl', 'ghazl'),
(3, 'benmabrok', 'kenza', 'lala', 'lala'),
(4, 'el madhoun', 'hajar', 'hajar', 'hajar');

-- --------------------------------------------------------

--
-- Structure de la table `crise`
--

CREATE TABLE IF NOT EXISTS `crise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomE` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `duree` int(11) NOT NULL,
  `cause` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `crise`
--

INSERT INTO `crise` (`id`, `nomE`, `date`, `duree`, `cause`) VALUES
(1, 'ALAOUI', '2018-02-27', 2, 'stress et un besoin non assouvi'),
(2, 'ALAOUI', '2018-02-20', 1, 'l''apprentissage d''un cours de math '),
(3, 'ALAOUI', '2018-02-20', 1, 'stress'),
(4, 'MOTAKI', '2018-02-16', 3, 'stress');

-- --------------------------------------------------------

--
-- Structure de la table `enfant`
--

CREATE TABLE IF NOT EXISTS `enfant` (
  `idE` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `nomM` varchar(255) NOT NULL,
  `nomP` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  PRIMARY KEY (`idE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `enfant`
--

INSERT INTO `enfant` (`idE`, `nom`, `prenom`, `age`, `nomM`, `nomP`, `tel`, `Email`) VALUES
(1, 'MOTAKI', 'Ayman ', 11, 'Aicha RAMI', 'Ahmad MOTAKI', '06 55 44 33 22', 'motaki@gmail.com'),
(2, 'ALAOUI', 'Sanaa', 8, 'Karima RARI', 'Yassin ALAOUI', '06 44 33 22 11', 'ALAOUI@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `result`
--

CREATE TABLE IF NOT EXISTS `result` (
  `idR` int(11) NOT NULL AUTO_INCREMENT,
  `nomCours` varchar(255) NOT NULL,
  `note` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `NomE` varchar(255) NOT NULL,
  `heure` varchar(255) NOT NULL,
  PRIMARY KEY (`idR`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `result`
--

INSERT INTO `result` (`idR`, `nomCours`, `note`, `date`, `NomE`, `heure`) VALUES
(2, 'Cours Annimal', 100, '2018,02,24', 'ALAOUI', ''),
(3, 'Cours Fruit', 60, '2018,02,25', 'ALAOUI', ''),
(4, 'Cours Nombres', 80, '2018,02,26', 'ALAOUI', ''),
(5, 'Cours Fruit', 20, '2018,02,21', 'MOTAKI', ''),
(6, 'Cours Annimal', 40, '2018,02,22', 'MOTAKI', ''),
(7, 'Cours Nombres', 20, '2018,02,23', 'MOTAKI', ''),
(8, 'Cours Nombres', 20, '2018,02,24', 'MOTAKI', ''),
(9, 'Cours Fruit', 90, '2018,02,27', 'ALAOUI', '10:36:45'),
(10, 'Cours Annimal', 20, '2018,02,28', 'ALAOUI', '00:36:45'),
(11, 'Cours Fruit', 60, '2018,02,25', 'MOTAKI', '10:36:45'),
(12, 'Cours Annimal', 100, '2018,02,26', 'MOTAKI', '22:36:10'),
(13, 'Cours Fruit', 20, '2018,02,27', 'MOTAKI', '01:36:45'),
(14, 'Cours Annimal', 100, '2018,02,28', 'MOTAKI', '02:36:45'),
(15, 'Cours Annimal', 40, '2018,03,01', 'MOTAKI', '12:19:57'),
(16, 'Cours Nombres', 100, '2018,03,02', 'MOTAKI', '12:21:27');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
