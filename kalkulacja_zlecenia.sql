-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: kalkulacja
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `zlecenia`
--

DROP TABLE IF EXISTS `zlecenia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `zlecenia` (
  `id_zlecenia` int(11) NOT NULL AUTO_INCREMENT,
  `Klienci_id_klienta` int(11) NOT NULL,
  `id_m` int(11) DEFAULT NULL,
  `naklad` int(11) NOT NULL,
  `gramatura` int(11) NOT NULL,
  `cena_za_kg` double DEFAULT NULL,
  `waga_papieru` double DEFAULT NULL,
  `cena_papieru` double DEFAULT NULL,
  `ilosc_arkuszy_do_druku` int(11) DEFAULT NULL,
  `Papier_id_p` int(11) NOT NULL,
  `Rodzaj_pracy_id_r` int(11) DEFAULT NULL,
  `Format_ulotki_id_u` int(11) NOT NULL,
  `z_format_pap_ulotka` int(11) DEFAULT NULL,
  `data_zlozenia` datetime DEFAULT NULL,
  `format_do_druku` bit(1) NOT NULL,
  `format_ulotki` bit(1) NOT NULL,
  `id_klienta` bigint(20) NOT NULL,
  PRIMARY KEY (`id_zlecenia`),
  KEY `fk_Zlecenia_Klienci1_idx` (`Klienci_id_klienta`),
  KEY `id_m_idx` (`id_m`),
  KEY `fk_Zlecenia_Papier1_idx` (`Papier_id_p`),
  KEY `fk_Zlecenia_Rodzaj pracy1_idx` (`Rodzaj_pracy_id_r`),
  KEY `fk_Zlecenia_Format_ulotki1_idx` (`Format_ulotki_id_u`),
  KEY `fk_Zlecenia_formatpapieru_has_Format_ulotki1_idx` (`z_format_pap_ulotka`),
  CONSTRAINT `fk_Zlecenia_Format_ulotki1` FOREIGN KEY (`Format_ulotki_id_u`) REFERENCES `format_ulotki` (`id_u`),
  CONSTRAINT `fk_Zlecenia_Klienci1` FOREIGN KEY (`Klienci_id_klienta`) REFERENCES `klienci` (`id_klienta`),
  CONSTRAINT `fk_Zlecenia_Papier1` FOREIGN KEY (`Papier_id_p`) REFERENCES `papier` (`id_p`),
  CONSTRAINT `fk_Zlecenia_Rodzaj pracy1` FOREIGN KEY (`Rodzaj_pracy_id_r`) REFERENCES `rodzaj_pracy` (`id_r`),
  CONSTRAINT `fk_Zlecenia_formatpapieru_has_Format_ulotki1` FOREIGN KEY (`z_format_pap_ulotka`) REFERENCES `format_pap_ulotka` (`id`),
  CONSTRAINT `id_m` FOREIGN KEY (`id_m`) REFERENCES `maszyna` (`id_m`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zlecenia`
--

LOCK TABLES `zlecenia` WRITE;
/*!40000 ALTER TABLE `zlecenia` DISABLE KEYS */;
INSERT INTO `zlecenia` VALUES (1,2,1,2000,130,4.5,18.02,82,500,1,1,1,1,NULL,'\0','\0',0),(2,4,1,5000,115,123,39.85,4902,1250,1,1,1,2,NULL,'\0','\0',0),(3,5,2,10000,170,3,58.9,177,625,1,1,2,1,NULL,'\0','\0',0),(4,1,2,1000,150,5,5.2,26,125,1,1,2,2,NULL,'\0','\0',0),(5,3,1,1600,130,3,3.6,11,100,1,1,3,1,NULL,'\0','\0',0),(6,2,1,3000,150,5,7.8,39,188,1,1,3,2,NULL,'\0','\0',0),(7,2,NULL,5000,130,4.5,45.04,203,625,1,1,1,NULL,NULL,'\0','\0',0),(9,3,NULL,6000,150,4.5,41.58,188,1000,1,1,5,NULL,NULL,'\0','\0',0),(10,3,NULL,10000,170,5.5,29.45,162,313,2,1,3,NULL,NULL,'\0','\0',0),(15,3,NULL,2000,115,NULL,NULL,NULL,NULL,1,1,1,NULL,'2018-10-22 18:55:01','\0','\0',0),(16,2,NULL,6000,150,NULL,NULL,NULL,NULL,1,1,1,NULL,NULL,'\0','\0',0),(18,2,NULL,6000,150,NULL,NULL,NULL,NULL,1,2,1,NULL,NULL,'\0','\0',0),(19,3,NULL,5000,150,NULL,NULL,NULL,NULL,1,NULL,1,NULL,NULL,'\0','\0',0),(20,4,NULL,9000,150,3,93.56,281,1125,1,1,1,NULL,NULL,'\0','\0',0),(21,3,NULL,4000,115,NULL,NULL,NULL,NULL,1,1,2,NULL,'2018-10-23 14:20:15','\0','\0',0),(22,3,NULL,6500,115,NULL,NULL,NULL,NULL,1,1,1,NULL,'2018-10-25 20:38:50','\0','\0',0),(23,3,NULL,500000,200,NULL,NULL,NULL,NULL,2,1,1,NULL,'2018-10-25 20:45:18','\0','\0',0);
/*!40000 ALTER TABLE `zlecenia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

ALTER TABLE `kalkulacja`.`zlecenia` DROP COLUMN `id_klienta`, DROP COLUMN `format_ulotki`, DROP COLUMN `format_do_druku`;

-- Dump completed on 2018-12-12  9:16:07

