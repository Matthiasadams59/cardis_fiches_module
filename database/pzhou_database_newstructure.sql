-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 10 mai 2018 à 13:39
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
-- Base de données :  `cardis_newstructure`
--

-- --------------------------------------------------------

--
-- Structure de la table `course_skills`
--

CREATE TABLE `course_skills` (
  `id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `sheet_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `course_skills`
--

INSERT INTO `course_skills` (`id`, `skill_id`, `sheet_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1),
(5, 5, 1),
(6, 6, 1),
(7, 7, 1);

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
(3);

-- --------------------------------------------------------

--
-- Structure de la table `sheet`
--

CREATE TABLE `sheet` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `title` varchar(250) CHARACTER SET utf8 NOT NULL,
  `ECTS` int(11) NOT NULL,
  `login` tinytext CHARACTER SET utf8 NOT NULL,
  `hours` text CHARACTER SET utf8,
  `isteamwork` tinyint(1) DEFAULT NULL,
  `description` text CHARACTER SET utf8,
  `requirement` text CHARACTER SET utf8,
  `content` text CHARACTER SET utf8,
  `teacher_tools` text CHARACTER SET utf8,
  `student_tools` text CHARACTER SET utf8,
  `next_module` text CHARACTER SET utf8,
  `learning_method` text CHARACTER SET utf8,
  `grade_rating` text CHARACTER SET utf8,
  `language` text CHARACTER SET utf8,
  `bibliography` text CHARACTER SET utf8,
  `is_published` tinyint(1) NOT NULL,
  `keywords` text CHARACTER SET utf8 NOT NULL,
  `ecsts` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sheet`
--

INSERT INTO `sheet` (`id`, `user_id`, `title`, `ECTS`, `login`, `hours`, `isteamwork`, `description`, `requirement`, `content`, `teacher_tools`, `student_tools`, `next_module`, `learning_method`, `grade_rating`, `language`, `bibliography`, `is_published`, `keywords`, `ecsts`) VALUES
(1, 2, 'Électronique des objets', 5, 'IE.2307 – IE2407', '150 Heures dont 46 heures encadrées', 1, 'Le marché des IOT connait une croissance exponentielle avec des besoins et des services de plus en plus\r\ninnovants. Ces objets connectés qui envahissent de plus en plus notre vie quotidienne sont composés du\r\npoint de vue matériel, de nombreuses briques fonctionnelles indispensables comme les capteurs pour la\r\ncollecte des données, les microcontrôleurs qui gèrent les données collectées, les batteries et les modules de transmission Radio Fréquence.\r\nCe module fournit à l’élève ingénieur toutes les bases qui concernent la conception électronique d’un objet\r\ncommunicant allant du capteur vers le module RF.', 'Connaissance de base en électronique et en programmation. IE.1101 II.1101', 'En fin de module, les élèves auront plus spécifiquement appris à :\r\n• A opérer le choix des capteurs, leur fabrication, les spécificités liées aux applications particulières\r\n(biomédicale, télémédecine, smart home, smart city, énergie, automobile, ...), le conditionnement\r\ndu signal brut issu du capteur physique, les interfaces de communication numérique des capteurs\r\nstandards, etc.\r\n• A maitriser l’alimentation et la gestion d’énergie\r\n• A utiliser le mini-calculateur embarqué\r\n• A utiliser les différents protocoles de communication avec ou sans fils permettant la transmission de\r\ndonnées entre les capteurs et serveur.\r\n• A concevoir des objets technologiques à base de microcontrôleur, de capteurs et d’électronique de\r\nconditionnement.\r\n• A modéliser les problèmes de conception de ce type d’objet.\r\n• A Communiquer, lire et rédiger des documents en anglais dans un environnement culturellement\r\ndiversifié.\r\n• A assimiler des termes techniques pour comprendre la documentation liée aux systèmes IoT\r\n• A agir en bon communicant, écouter et mener un dialogue, argumenter, convaincre, présenter et\r\ndéfendre leur solution.\r\nConnaissances\r\nLes enseignements donnés dans ce module permettent d’élaborer les concepts et savoir-faire suivants.\r\nConcepts\r\n• Introduction sur les capteurs numériques et analogiques, les paramètres mesurés (physiques,\r\nchimiques ou biologique...)\r\n• Les capteurs et réseaux de capteurs, leurs applications\r\n• Interface capteur-électronique\r\n• Optimisation d’énergie (niveau capteur, niveau réseau, niveau système)\r\n• Les bus de communication I2C et SPI\r\n• Les protocoles de communications\r\n• Partitionnement de charge entre objets et serveurs\r\nSavoir-faire\r\n• Conception et optimisation d’un nœud de mesure et de commande communicant\r\n• Optimisation et maitrise de l’énergie en fonction des différents critères de gestion des capteurs, de\r\nl’application, des moyens de communication...', 'Maquettes microcontrôleur, composants électroniques, capteurs, modules radio (LORA, BLUETOOTH...)', 'N/A', 'N/A', 'En termes d’approche pédagogique ce module est constitué par :\r\n• Un cours / TP qui présente les principaux concepts liés à la conception d’objets communicants pour\r\ndes applications dans les domaines suivants : la télémédecine, les transports, le \"smart home \" et \"smart\r\ncity\". Il insiste particulièrement sur les évolutions en cours et à venir, et sur les problématiques encore\r\nouvertes de ces modules communicants. Les TP permettent de développer et mettre en œuvre les\r\ndifférentes notions.\r\n• Un mini projet en atelier permet aux étudiants d’appliquer les notions étudiées en cours et de\r\nconcevoir un objet communicant.', 'L’évaluation sera effectuée par un contrôle continu lors des TP et des mini-projets et atelier et par un examen\r\nécrit qui permettra d\'évaluer les compétences acquises au travers les différentes problématiques traitées.\r\nLes compétences transverses seront estimées lors du déroulement du travail par équipe mais également par\r\nla qualité du travail final présenté.', 'Module entièrement délivré en anglais, productions des élèves en anglais', '• Polycopié de cours\r\n• WebSystèmes radiofréquences', 1, 'capteurs, microcontrôleurs, périphériques, communications I2C SPI, Protocoles radio, énergie,', 0);

-- --------------------------------------------------------

--
-- Structure de la table `sheet_skills`
--

CREATE TABLE `sheet_skills` (
  `sheet_id` int(11) NOT NULL,
  `skills_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `skill`
--

CREATE TABLE `skill` (
  `id` int(11) NOT NULL,
  `skill` text CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `skill`
--

INSERT INTO `skill` (`id`, `skill`) VALUES
(1, 'Agir en acteur dynamique et efficace dans un groupe'),
(2, 'Travailler en équipe en réseau, et dans un environnement culturellement diversifié'),
(3, 'Etre force de proposition'),
(4, 'Agir en bon communicant dans un environnement scientifique et technique ouvert à l’international'),
(5, 'Ecouter et se faire écouter'),
(6, 'Mener un dialogue, argumenter convaincre'),
(7, 'Communiquer dans plusieurs langues');

-- --------------------------------------------------------

--
-- Structure de la table `SPRING_SESSION`
--

CREATE TABLE `SPRING_SESSION` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Structure de la table `SPRING_SESSION_ATTRIBUTES`
--

CREATE TABLE `SPRING_SESSION_ATTRIBUTES` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

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
-- Index pour la table `course_skills`
--
ALTER TABLE `course_skills`
  ADD PRIMARY KEY (`id`),
  ADD KEY `skill_id` (`skill_id`),
  ADD KEY `sheet_id` (`sheet_id`);

--
-- Index pour la table `sheet`
--
ALTER TABLE `sheet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_supervisor` (`user_id`);

--
-- Index pour la table `sheet_skills`
--
ALTER TABLE `sheet_skills`
  ADD PRIMARY KEY (`sheet_id`,`skills_id`),
  ADD KEY `FKmgp77aj5qtk3354qdjthxjlbr` (`skills_id`);

--
-- Index pour la table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `SPRING_SESSION`
--
ALTER TABLE `SPRING_SESSION`
  ADD PRIMARY KEY (`PRIMARY_ID`),
  ADD UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  ADD KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  ADD KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`);

--
-- Index pour la table `SPRING_SESSION_ATTRIBUTES`
--
ALTER TABLE `SPRING_SESSION_ATTRIBUTES`
  ADD PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  ADD KEY `SPRING_SESSION_ATTRIBUTES_IX1` (`SESSION_PRIMARY_ID`);

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
-- AUTO_INCREMENT pour la table `course_skills`
--
ALTER TABLE `course_skills`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `sheet`
--
ALTER TABLE `sheet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `skill`
--
ALTER TABLE `skill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `course_skills`
--
ALTER TABLE `course_skills`
  ADD CONSTRAINT `course_skills_ibfk_1` FOREIGN KEY (`sheet_id`) REFERENCES `sheet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `course_skills_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `sheet`
--
ALTER TABLE `sheet`
  ADD CONSTRAINT `sheet_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `SPRING_SESSION_ATTRIBUTES`
--
ALTER TABLE `SPRING_SESSION_ATTRIBUTES`
  ADD CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `SPRING_SESSION` (`PRIMARY_ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
