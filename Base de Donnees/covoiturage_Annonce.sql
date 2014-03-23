CREATE DATABASE  IF NOT EXISTS `covoiturage` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `covoiturage`;
-- MySQL dump 10.13  Distrib 5.5.35, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: covoiturage
-- ------------------------------------------------------
-- Server version	5.5.35-0ubuntu0.13.10.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Annonce`
--

DROP TABLE IF EXISTS `Annonce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Annonce` (
  `AnnonceID` int(11) NOT NULL AUTO_INCREMENT,
  `VilleDepart` int(11) DEFAULT NULL,
  `EndroitDepart` varchar(500) DEFAULT NULL,
  `VilleArrivee` int(11) DEFAULT NULL,
  `EndroitArrivee` varchar(500) DEFAULT NULL,
  `Titre` varchar(250) DEFAULT NULL,
  `Description` text,
  `DateDepart` date DEFAULT NULL,
  `HeureDepart` varchar(45) DEFAULT NULL,
  `TotalTemp` varchar(45) DEFAULT NULL,
  `Prix` varchar(100) DEFAULT NULL,
  `NombrePlace` int(11) DEFAULT NULL,
  `AutresEndroitsPasses` varchar(500) DEFAULT NULL,
  `DateCreate` date DEFAULT NULL,
  `VoitureID` int(11) DEFAULT NULL,
  `UtilisateurID` int(11) DEFAULT NULL,
  PRIMARY KEY (`AnnonceID`),
  KEY `VilleDepartFK_idx` (`VilleDepart`),
  KEY `VilleArriveeFK_idx` (`VilleArrivee`),
  KEY `VoitureFK_idx` (`VoitureID`),
  KEY `Utilisateur_AnnonceFK_idx` (`UtilisateurID`),
  CONSTRAINT `Utilisateur_AnnonceFK` FOREIGN KEY (`UtilisateurID`) REFERENCES `Utilisateur` (`UtilisateurID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `VilleArriveeFK` FOREIGN KEY (`VilleArrivee`) REFERENCES `Ville` (`VilleID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `VilleDepartFK` FOREIGN KEY (`VilleDepart`) REFERENCES `Ville` (`VilleID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `VoitureFK` FOREIGN KEY (`VoitureID`) REFERENCES `Voiture` (`VoitureID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Annonce`
--

LOCK TABLES `Annonce` WRITE;
/*!40000 ALTER TABLE `Annonce` DISABLE KEYS */;
INSERT INTO `Annonce` VALUES (1,1,'adsf',1,'adsfad','haaha ahaha ahaha ahaha','haaha ahaha ahaha ahaha','2014-12-10','12h30','2 Ngay','1000000',2,'khong','2014-03-23',1,1),(2,1,'asdf',1,'adsfad','haaha ahaha ahaha ahaha','haaha ahaha ahaha ahaha','2014-12-10','12h30','2 Ngay','1000000',0,'khong','2014-03-23',1,1);
/*!40000 ALTER TABLE `Annonce` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-23 10:20:15
