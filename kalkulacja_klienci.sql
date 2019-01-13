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
-- Table structure for table `klienci`
--

DROP TABLE IF EXISTS `klienci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `klienci` (
  `id_klienta` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(45) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(45) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `login` varchar(20) CHARACTER SET utf8 COLLATE utf8_polish_ci DEFAULT NULL,
  `haslo` varchar(45) COLLATE utf8_polish_ci DEFAULT NULL,
  `e_mail` varchar(45) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `nazwa_firmy` varchar(45) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `NIP` int(11) DEFAULT NULL,
  `nr_telefonu` int(11) NOT NULL,
  `adres_firmy_ulica` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `adres_firmy_kod` varchar(6) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `adres_firmy_miasto` varchar(45) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `data_dodania` datetime DEFAULT NULL,
  PRIMARY KEY (`id_klienta`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klienci`
--

LOCK TABLES `klienci` WRITE;
/*!40000 ALTER TABLE `klienci` DISABLE KEYS */;
INSERT INTO `klienci` VALUES (1,'Paweł','Gaudziak','admin','admin','pawel.gaudziak@gmail.com','Fortes',1222,504098019,'Malczewkiego 37/41 m.1','02-622','Warszawa','2017-02-11 00:00:00'),(2,'Mark','Twain','qqq','www','mark.twain@wp.pl','PiszPol',3334,650650650,'ul. Zachodnia 12','06-523','Otwock','2016-03-26 00:00:00'),(3,'Staś','Tarkowski','aaa','sss','stast@gmail.com','Afrikans',555,601602603,'ul. Promienna 56','01-312','Radzymin','2014-12-26 00:00:00'),(4,'Roald','Amundsen','zzz','xxx','r.amundsen@gazeta.pl','PolSopel',666,504895632,'ul. Lodowata 16','06-987','Suwałki','1900-02-23 00:00:00'),(5,'Jack','Daniels','eee','rrr','johnny.d@vp.pl','Napitek',777,603602608,'ul. Wyskokowa 15','02-622','Kraków','1986-07-08 00:00:00'),(6,'Darek ','Michalak','ddd','fff','darek.michalak@xlpromotin.pl','XL Promotion',888,123456789,'Wiosenna_ 20','02-050','Warszawa','2017-02-11 00:00:00'),(7,'Andrzej','Gołota','ttt','yyy','a.golota@golota.pl','Ring',123,456,'Wiejska 12','02-622','Warszawa',NULL);
/*!40000 ALTER TABLE `klienci` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12  9:16:03
