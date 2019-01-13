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
-- Table structure for table `format_pap_ulotka`
--

DROP TABLE IF EXISTS `format_pap_ulotka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `format_pap_ulotka` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FPU_id_fp` int(11) NOT NULL,
  `FPU_id_u` int(11) NOT NULL,
  `ilosc_ul_arkusz` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_formatpapieru_has_Format_ulotki_Format_ulotki1_idx` (`FPU_id_u`),
  KEY `fk_formatpapieru_has_Format_ulotki_formatpapieru1_idx` (`FPU_id_fp`),
  CONSTRAINT `fk_formatpapieru_has_Format_ulotki_Format_ulotki1` FOREIGN KEY (`FPU_id_u`) REFERENCES `format_ulotki` (`id_u`),
  CONSTRAINT `fk_formatpapieru_has_Format_ulotki_formatpapieru1` FOREIGN KEY (`FPU_id_fp`) REFERENCES `formatpapieru` (`id_fp`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `format_pap_ulotka`
--

LOCK TABLES `format_pap_ulotka` WRITE;
/*!40000 ALTER TABLE `format_pap_ulotka` DISABLE KEYS */;
INSERT INTO `format_pap_ulotka` VALUES (1,1,1,8),(2,2,1,4),(3,1,2,16),(4,2,2,8),(5,1,3,32),(6,2,3,16),(7,1,4,24),(8,2,4,12),(9,1,5,12),(10,2,5,6);
/*!40000 ALTER TABLE `format_pap_ulotka` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12  9:16:02
