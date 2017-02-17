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
-- Table structure for table `licoes`
--

DROP TABLE IF EXISTS `licoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `licoes` (
  `numero` int(11) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `licoes`
--

LOCK TABLES `licoes` WRITE;
/*!40000 ALTER TABLE `licoes` DISABLE KEYS */;
INSERT INTO `licoes` VALUES (1,'Leitura exata'),(2,'Articulação clara'),(3,'Pronúncia correta'),(4,'Fluência'),(5,'Uso correto de pausas'),(6,'Ênfase segundo o sentido'),(7,'Ênfase nas ideias principais'),(8,'Volume apropriado'),(9,'Modulação'),(10,'Entusiasmo'),(11,'Cordialidade e sentimento'),(12,'Gestos e expressões faciais'),(13,'Contato visual'),(14,'Naturalidade'),(15,'Boa aparência'),(16,'Equilíbrio'),(17,'Uso do microfone'),(18,'Uso da Bíblia ao responder a perguntas'),(19,'Incentivo ao uso da Bíblia'),(20,'Introdução eficaz de textos bíblicos'),(21,'Leitura de textos com ênfase adequada'),(22,'Aplicação correta dos textos'),(23,'Esclarecer o valor prático da matéria'),(24,'Escolha de palavras'),(25,'Uso de esboço'),(26,'Apresentação lógica da matéria'),(27,'Proferimento espontâneo'),(28,'Estilo conversante'),(29,'Qualidade da voz'),(30,'Mostrar interesse nos outros'),(31,'Respeito pelos outros'),(32,'Falar com convicção'),(33,'Falar com tato, mas de modo firme'),(34,'Ser edificante e positivo'),(35,'Repetição para dar ênfase'),(36,'Desenvolvimento do tema'),(37,'Destacar os pontos principais'),(38,'Introdução que desperta interesse'),(39,'Conclusão eficaz'),(40,'Exatidão das declarações'),(41,'Clareza'),(42,'Apresentação instrutiva'),(43,'Usar a matéria designada'),(44,'Uso eficaz de perguntas'),(45,'Ilustrações instrutivas'),(46,'Ilustrações baseadas em situações conhecidas'),(47,'Uso eficaz de recursos visuais'),(48,'Argumentação que estimula o raciocínio'),(49,'Argumentos convincentes'),(50,'Tocar o coração'),(51,'Controle e boa distribuição do tempo'),(52,'Exortação eficaz'),(53,'Encorajar e fortalecer os ouvintes');
/*!40000 ALTER TABLE `licoes` ENABLE KEYS */;
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
