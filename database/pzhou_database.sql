-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 08 mai 2018 à 10:01
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
  `modality_id` int(11) DEFAULT NULL,
  `purpose_id` int(11) DEFAULT NULL,
  `description` text CHARACTER SET utf8,
  `bibliography` text CHARACTER SET utf8
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `description`
--

INSERT INTO `description` (`id`, `modality_id`, `purpose_id`, `description`, `bibliography`) VALUES
(1, 1, 1, 'Le marché des IOT connait une croissance exponentielle avec des besoins et des services de plus en plus\r\ninnovants. Ces objets connectés qui envahissent de plus en plus notre vie quotidienne sont composés du\r\npoint de vue matériel, de nombreuses briques fonctionnelles indispensables comme les capteurs pour la\r\ncollecte des données, les microcontrôleurs qui gèrent les données collectées, les batteries et les modules de\r\ntransmission Radio Fréquence.\r\nCe module fournit à l’élève ingénieur toutes les bases qui concernent la conception électronique d’un objet\r\ncommunicant allant du capteur vers le module RF.', 'N/A');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `hour`
--

CREATE TABLE `hour` (
  `id` int(11) NOT NULL,
  `total` int(11) DEFAULT NULL,
  `tutorial` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hour`
--

INSERT INTO `hour` (`id`, `total`, `tutorial`) VALUES
(1, 150, 46);

-- --------------------------------------------------------

--
-- Structure de la table `information`
--

CREATE TABLE `information` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `hour_id` int(11) DEFAULT NULL,
  `login` varchar(250) DEFAULT NULL,
  `isTeamWork` tinyint(1) DEFAULT NULL,
  `tag` text,
  `devices` varchar(250) DEFAULT NULL,
  `is_team_work` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `information`
--

INSERT INTO `information` (`id`, `user_id`, `hour_id`, `login`, `isTeamWork`, `tag`, `devices`, `is_team_work`) VALUES
(1, 2, 1, 'IE.2307/IE.2407\r\n', 1, 'capteurs, microcontrôleurs, périphériques, communications I2C SPI, Protocoles radio, énergie', 'Salle équipée des logiciels et matériel nécessaires', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `modality`
--

CREATE TABLE `modality` (
  `id` int(11) NOT NULL,
  `evaluation` text,
  `learning` text,
  `language` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `modality`
--

INSERT INTO `modality` (`id`, `evaluation`, `learning`, `language`) VALUES
(1, 'L’évaluation sera effectuée par un contrôle continu lors des TP et des mini-projets et atelier et par un examen écrit qui permettra d\'évaluer les compétences acquises au travers les différentes problématiques traitées.\r\nLes compétences transverses seront estimées lors du déroulement du travail par équipe mais également par la qualité du travail final présenté.', 'En termes d’approche pédagogique ce module est constitué par :\r\n• Un cours / TP qui présente les principaux concepts liés à la conception d’objets communicants pour des applications dans les domaines suivants : la télémédecine, les transports, le \"smart home \" et \"smart city\". Il insiste particulièrement sur les évolutions en cours et à venir, et sur les problématiques encore ouvertes de ces modules communicants. Les TP permettent de développer et mettre en œuvre les\r\ndifférentes notions.\r\n• Un mini projet en atelier permet aux étudiants d’appliquer les notions étudiées en cours et de concevoir un objet communicant', 'Anglais');

-- --------------------------------------------------------

--
-- Structure de la table `purpose`
--

CREATE TABLE `purpose` (
  `id` int(11) NOT NULL,
  `sheet_id` int(11) DEFAULT NULL,
  `contents` text CHARACTER SET utf8,
  `teacher_tools` text CHARACTER SET utf8,
  `student_tools` text CHARACTER SET utf8
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `purpose`
--

INSERT INTO `purpose` (`id`, `sheet_id`, `contents`, `teacher_tools`, `student_tools`) VALUES
(1, NULL, 'Bla bla Bla', 'Maquettes microcontrôleur, composants électroniques, capteurs, modules radio (LORA, BLUETOOTH...)', 'N/A');

-- --------------------------------------------------------

--
-- Structure de la table `sheet`
--

CREATE TABLE `sheet` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `information_id` int(11) DEFAULT NULL,
  `description_id` int(11) DEFAULT NULL,
  `title` varchar(250) CHARACTER SET utf8 NOT NULL,
  `date_creation` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `is_published` tinyint(1) NOT NULL,
  `academic_year` varchar(250) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sheet`
--

INSERT INTO `sheet` (`id`, `user_id`, `information_id`, `description_id`, `title`, `date_creation`, `is_published`, `academic_year`) VALUES
(1, 2, 1, 1, 'Sheet quelconque', '2018-05-07 21:47:40.303471', 1, '2017/2018');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `firstname`, `mail`, `role`, `lastname`) VALUES
(1, 'dmutombo', 'ISEP2018', 'Dikembe', 'dikembe.mutombo@isep.fr', 'admin', 'Mutombo'),
(2, 'jmara', 'ISEP2018', 'Jean', 'jean.mara@isep.fr', 'teacher', 'Mara'),
(3, 'jdickinson', 'ISEP2018', 'Jack', 'jack.dickison@isep.fr', 'student', 'Dickison');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `description`
--
ALTER TABLE `description`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_modality` (`modality_id`),
  ADD KEY `id_purpose` (`purpose_id`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `hour`
--
ALTER TABLE `hour`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `information`
--
ALTER TABLE `information`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`user_id`),
  ADD KEY `id_hour` (`hour_id`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `modality`
--
ALTER TABLE `modality`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `purpose`
--
ALTER TABLE `purpose`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_sheet_isep` (`sheet_id`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `sheet`
--
ALTER TABLE `sheet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`user_id`),
  ADD KEY `id_information` (`information_id`),
  ADD KEY `id_description` (`description_id`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_id_uindex` (`id`),
  ADD UNIQUE KEY `users_mail_uindex` (`mail`),
  ADD UNIQUE KEY `users_userName_uindex` (`username`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `description`
--
ALTER TABLE `description`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `hour`
--
ALTER TABLE `hour`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `information`
--
ALTER TABLE `information`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `modality`
--
ALTER TABLE `modality`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `purpose`
--
ALTER TABLE `purpose`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `sheet`
--
ALTER TABLE `sheet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `description`
--
ALTER TABLE `description`
  ADD CONSTRAINT `description_ibfk_1` FOREIGN KEY (`modality_id`) REFERENCES `modality` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `description_ibfk_2` FOREIGN KEY (`purpose_id`) REFERENCES `purpose` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `information`
--
ALTER TABLE `information`
  ADD CONSTRAINT `information_ibfk_1` FOREIGN KEY (`hour_id`) REFERENCES `hour` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `information_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `purpose`
--
ALTER TABLE `purpose`
  ADD CONSTRAINT `purpose_ibfk_1` FOREIGN KEY (`sheet_id`) REFERENCES `sheet` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `sheet`
--
ALTER TABLE `sheet`
  ADD CONSTRAINT `FKm0g3pt4p4ua3vs2x9cix06jyq` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `sheet_ibfk_1` FOREIGN KEY (`description_id`) REFERENCES `description` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sheet_ibfk_2` FOREIGN KEY (`information_id`) REFERENCES `information` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
