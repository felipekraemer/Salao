CREATE DATABASE  IF NOT EXISTS `salao` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `salao`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: salao
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `publicadores`
--

DROP TABLE IF EXISTS `publicadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publicadores` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(70) COLLATE utf8_bin NOT NULL,
  `endereco` varchar(70) COLLATE utf8_bin DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `telefone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `data_batismo` date DEFAULT NULL,
  `ungido_outra_ovelha` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `privilegio` varchar(3) COLLATE utf8_bin NOT NULL,
  `observacoes` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `sexo` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `usuario` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `senha` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `situacao` varchar(3) COLLATE utf8_bin DEFAULT NULL,
  `participa_escola` varchar(1) COLLATE utf8_bin DEFAULT 'S',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicadores`
--

LOCK TABLES `publicadores` WRITE;
/*!40000 ALTER TABLE `publicadores` DISABLE KEYS */;
INSERT INTO `publicadores` VALUES (1,'Felipe Kraemer','Rua Sacadura Cabral, nº 56, apto 201','1984-12-04','992824533','felipekraemer@atlassian.com','2000-12-09','OO','SEM','Observações.\nLinha 2\nLinha 3','M','fkraemer','30183015','','S'),(2,'Juliana Adriane Dutra da Cruz Kraemer','Rua Sacadura Cabral, nº 56, apto 201','1985-05-02','994038448','juliana.cruz.kraemer@gmail.com','2004-04-18','OO','PUB','','F',NULL,NULL,NULL,'S'),(3,'André Bitencourt','Rua Itália',NULL,'','',NULL,'OO','ANC','','M','andre','andre','','S'),(4,'Roberto Fortes','Rua Tamoio',NULL,'','',NULL,'OO','ANC','','M','roberto','roberto','','S'),(5,'Valter Ferreira','Rua Farroupilha',NULL,'','',NULL,'OO','ANC','','M','valter','valter','','S'),(6,'Levi Fortes','Rua Tamoio',NULL,'','',NULL,'OO','PUB','','M','levi','levi','','S'),(7,'Sidnei Vargas','Rua Assis Brasil',NULL,'','',NULL,'OO','PUB','','M','','','','S'),(8,'Lucas Baumgraz','',NULL,'','',NULL,'OO','PNB','','M','','','','S'),(9,'Felipe Leal','',NULL,'','',NULL,'OO','PNB','','M','','','','S'),(10,'Lucas Ferreira','',NULL,'','',NULL,'OO','SEM','','M','','','','S');
/*!40000 ALTER TABLE `publicadores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-16 23:29:34
