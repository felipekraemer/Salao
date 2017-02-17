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
-- Table structure for table `programa_semanal`
--

DROP TABLE IF EXISTS `programa_semanal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `programa_semanal` (
  `semana` date NOT NULL,
  `cantico_inicial` int(11) NOT NULL,
  `cantico_intermediario` int(11) NOT NULL,
  `cantico_final` int(11) NOT NULL,
  `presidente` int(11) DEFAULT NULL,
  `oracao_inicial` int(11) DEFAULT NULL,
  `oracao_final` int(11) DEFAULT NULL,
  `tesouros_discurso_tema` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `tesouros_discurso_orador` int(11) DEFAULT NULL,
  `tesouros_joias_orador` int(11) DEFAULT NULL,
  `tesouros_leitura_orador` int(11) DEFAULT NULL,
  `tesouros_leitura_licao` int(11) DEFAULT NULL,
  `ministerio_um_discurso_tema` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ministerio_um_discurso_orador` int(11) DEFAULT NULL,
  `ministerio_tres_visita_orador` int(11) DEFAULT NULL,
  `ministerio_tres_visita_aux` int(11) DEFAULT NULL,
  `ministerio_tres_visita_licao` int(11) DEFAULT NULL,
  `ministerio_tres_revisita_orador` int(11) DEFAULT NULL,
  `ministerio_tres_revisita_aux` int(11) DEFAULT NULL,
  `ministerio_tres_revisita_licao` int(11) DEFAULT NULL,
  `ministerio_tres_estudo_orador` int(11) DEFAULT NULL,
  `ministerio_tres_estudo_aux` int(11) DEFAULT NULL,
  `ministerio_tres_estudo_licao` int(11) DEFAULT NULL,
  `ministerio_tres_discurso_orador` int(11) DEFAULT NULL,
  `ministerio_tres_discurso_tema` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ministerio_tres_discurso_licao` int(11) DEFAULT NULL,
  `vida_parte1_tema` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `vida_parte1_orador` int(11) DEFAULT NULL,
  `vida_parte1_tempo` int(11) DEFAULT NULL,
  `vida_parte2_tema` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `vida_parte2_orador` int(11) DEFAULT NULL,
  `vida_parte2_tempo` int(11) DEFAULT NULL,
  `estudo_dirigente` int(11) DEFAULT NULL,
  `estudo_leitor` int(11) DEFAULT NULL,
  PRIMARY KEY (`semana`),
  KEY `FK1_idx` (`tesouros_leitura_licao`,`ministerio_tres_visita_licao`,`ministerio_tres_revisita_licao`,`ministerio_tres_estudo_licao`,`ministerio_tres_discurso_licao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programa_semanal`
--

LOCK TABLES `programa_semanal` WRITE;
/*!40000 ALTER TABLE `programa_semanal` DISABLE KEYS */;
INSERT INTO `programa_semanal` VALUES ('2017-02-06',1,2,123,3,NULL,NULL,'Tesouros da Palavra de Deus - Tema do Discurso',NULL,NULL,NULL,NULL,'Uma designação, cujo tema é',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Nossa vida Cristã, parte 1',NULL,6,'Nossa vida Cristã, parte 2',NULL,9,NULL,NULL);
/*!40000 ALTER TABLE `programa_semanal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-16 23:29:35
