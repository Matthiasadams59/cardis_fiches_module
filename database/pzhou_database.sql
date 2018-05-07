-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 07 mai 2018 à 12:53
-- Version du serveur :  10.1.22-MariaDB
-- Version de PHP :  7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cardis_adams`
--

-- --------------------------------------------------------

--
-- Structure de la table `description`
--

CREATE TABLE `description` (
  `id` int(11) NOT NULL,
  `id_modality` int(11) DEFAULT NULL,
  `id_purpose` int(11) DEFAULT NULL,
  `description` text CHARACTER SET utf8,
  `bibliography` text CHARACTER SET utf8
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `description`
--

INSERT INTO `description` (`id`, `id_modality`, `id_purpose`, `description`, `bibliography`) VALUES
(1, 1, 1, 'Le marché des IOT connait une croissance exponentielle avec des besoins et des services de plus en plus\r\ninnovants. Ces objets connectés qui envahissent de plus en plus notre vie quotidienne sont composés du\r\npoint de vue matériel, de nombreuses briques fonctionnelles indispensables comme les capteurs pour la\r\ncollecte des données, les microcontrôleurs qui gèrent les données collectées, les batteries et les modules de\r\ntransmission Radio Fréquence.\r\nCe module fournit à l’élève ingénieur toutes les bases qui concernent la conception électronique d’un objet\r\ncommunicant allant du capteur vers le module RF.', 'N/A');

-- --------------------------------------------------------

--
-- Structure de la table `information`
--

CREATE TABLE `information` (
  `id` int(11) NOT NULL,
  `id_supervisor` int(11) NOT NULL,
  `id_hour` int(11) NOT NULL,
  `login` varchar(250) NOT NULL,
  `isTeamWork` tinyint(1) NOT NULL,
  `tag` text,
  `devices` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `information`
--

INSERT INTO `information` (`id`, `id_supervisor`, `id_hour`, `login`, `isTeamWork`, `tag`, `devices`) VALUES
(1, 2, 1, 'IE.2307/IE.2407\r\n', 1, 'capteurs, microcontrôleurs, périphériques, communications I2C SPI, Protocoles radio, énergie', 'Salle équipée des logiciels et matériel nécessaires');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `description`
--
ALTER TABLE `description`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_modality` (`id_modality`),
  ADD KEY `id_purpose` (`id_purpose`);

--
-- Index pour la table `information`
--
ALTER TABLE `information`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_supervisor`),
  ADD KEY `id_hour` (`id_hour`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `description`
--
ALTER TABLE `description`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `information`
--
ALTER TABLE `information`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `description`
--
ALTER TABLE `description`
  ADD CONSTRAINT `description_ibfk_1` FOREIGN KEY (`id_modality`) REFERENCES `modality` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `description_ibfk_2` FOREIGN KEY (`id_purpose`) REFERENCES `purpose` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `information`
--
ALTER TABLE `information`
  ADD CONSTRAINT `information_ibfk_1` FOREIGN KEY (`id_hour`) REFERENCES `hours` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `information_ibfk_2` FOREIGN KEY (`id_supervisor`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
