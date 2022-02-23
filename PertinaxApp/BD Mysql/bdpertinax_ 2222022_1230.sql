-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: bdpertinax
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `bdpertinax`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bdpertinax` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `bdpertinax`;

--
-- Table structure for table `tb_bobst_coated`
--

DROP TABLE IF EXISTS `tb_bobst_coated`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_bobst_coated` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `grm_cartao` int DEFAULT NULL,
  `pertinax` float(2,1) DEFAULT NULL,
  `fresa1` float(2,1) DEFAULT NULL,
  `fresa2` float(2,1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_bobst_coated`
--

LOCK TABLES `tb_bobst_coated` WRITE;
/*!40000 ALTER TABLE `tb_bobst_coated` DISABLE KEYS */;
INSERT INTO `tb_bobst_coated` VALUES (1,'TP White Plus',225,0.5,1.3,1.2),(2,'TP White Plus',240,0.5,1.3,1.2),(3,'TP White Plus',262,0.5,1.3,1.2),(4,'TP White Plus',275,0.6,1.5,1.4),(5,'TP White Plus',285,0.6,1.5,1.4),(6,'TP White Plus',310,0.6,1.5,1.4),(7,'TP White Plus',330,0.7,1.6,1.5),(8,'TP White Plus',350,0.7,1.6,1.5),(9,'Supremo Duo Design',250,0.4,1.2,1.1),(10,'Supremo Duo Design',300,0.4,1.2,1.1),(11,'Supremo Duo Design',350,0.5,1.3,1.2),(12,'Supremo Alta Alvura',240,0.4,1.2,1.1),(13,'Supremo Alta Alvura',250,0.4,1.2,1.1),(14,'Supremo Alta Alvura',300,0.5,1.3,1.2),(15,'Supremo Alta Alvura',350,0.5,1.5,1.4),(16,'Super 6 Plus',225,0.4,1.2,1.1),(17,'Super 6 Plus',240,0.5,1.3,1.2),(18,'Super 6 Plus',260,0.5,1.3,1.2),(19,'Super 6 Plus',275,0.5,1.3,1.2),(20,'Super 6 Plus',295,0.6,1.5,1.4),(21,'Super 6 Plus',320,0.6,1.5,1.4),(22,'Super 6 Plus',340,0.7,1.6,1.5),(23,'Supera',200,0.4,1.2,1.1),(24,'Supera',215,0.5,1.3,1.2),(25,'Supera',240,0.5,1.3,1.2),(26,'Supera',265,0.6,1.5,1.4),(27,'Supera',280,0.6,1.5,1.4),(28,'Supera',295,0.6,1.5,1.4),(29,'Supera',310,0.7,1.6,1.5),(30,'Supera',325,0.7,1.6,1.5),(31,'Supera',350,0.7,1.7,1.6),(32,'Speciala',200,0.4,1.2,1.1),(33,'Speciala',225,0.5,1.3,1.2),(34,'Speciala',250,0.5,1.3,1.2),(35,'Speciala',275,0.6,1.5,1.4),(36,'Speciala',300,0.6,1.5,1.4),(37,'Speciala',325,0.7,1.6,1.5),(38,'Speciala',350,0.7,1.6,1.5),(39,'Speciala',375,0.7,1.7,1.6),(40,'Ibema Ipona',190,0.4,1.2,1.1),(41,'Ibema Ipona',200,0.4,1.2,1.1),(42,'Ibema Ipona',210,0.4,1.2,1.1),(43,'Ibema Ipona',225,0.4,1.2,1.1),(44,'Ibema Ipona',250,0.5,1.3,1.2),(45,'Ibema Ipona',272,0.5,1.3,1.2),(46,'Ibema Ipona',300,0.6,1.5,1.4),(47,'Ibema Ipona',325,0.6,1.5,1.4),(48,'Ibema Ipona',350,0.7,1.6,1.5),(49,'Pack Plus',200,0.4,1.2,1.1),(50,'Pack Plus',210,0.4,1.2,1.1),(51,'Pack Plus',225,0.4,1.2,1.1),(52,'Pack Plus',250,0.5,1.3,1.2),(53,'Pack Plus',275,0.5,1.3,1.2),(54,'Pack Plus',300,0.6,1.5,1.4),(55,'Pack Plus',325,0.6,1.5,1.4),(56,'Pack Plus',350,0.6,1.5,1.4),(57,'Vitamax',225,0.4,1.2,1.1),(58,'Vitamax',250,0.5,1.3,1.2),(59,'Vitamax',275,0.5,1.3,1.2),(60,'Vitamax',300,0.6,1.5,1.4),(61,'Vitamax',325,0.6,1.5,1.4),(62,'Vitamax',350,0.6,1.5,1.4),(63,'Vitamax',375,0.7,1.6,1.5),(64,'Vitabianco',225,0.4,1.2,1.1),(65,'Vitabianco',250,0.5,1.3,1.2),(66,'Vitabianco',275,0.5,1.3,1.2),(67,'Vitabianco',300,0.5,1.3,1.2),(68,'Vitabianco',325,0.6,1.5,1.4),(69,'Vitabianco',350,0.6,1.5,1.4),(70,'Vitabianco',375,0.6,1.5,1.4),(71,'Vitacarta',210,0.4,1.2,1.1),(72,'Vitacarta',250,0.4,1.2,1.1),(73,'Vitacarta',300,0.5,1.3,1.2),(74,'Vitacarta',350,0.6,1.5,1.4),(75,'Vitacarta',375,0.6,1.5,1.4),(76,'Vitasolid',225,0.4,1.2,1.1),(77,'Vitasolid',250,0.4,1.2,1.1),(78,'Vitasolid',300,0.5,1.3,1.2),(79,'Vitasolid',350,0.6,1.5,1.4),(80,'Ecopack',190,0.4,1.2,1.1),(81,'Ecopack',210,0.4,1.2,1.1),(82,'Ecopack',230,0.4,1.2,1.1),(83,'Ecopack',250,0.4,1.2,1.1),(84,'Ecopack',280,0.5,1.3,1.2),(85,'Ecopack',300,0.5,1.3,1.2),(86,'Ecopack',330,0.5,1.3,1.2),(87,'Ecopack',350,0.6,1.5,1.4),(88,'Ecopack',370,0.6,1.5,1.4),(89,'Ecopack',410,0.7,1.6,1.5),(90,'Natura Card',230,0.4,1.2,1.1),(91,'Natura Card',250,0.5,1.3,1.2),(92,'Natura Card',280,0.5,1.3,1.2),(93,'Natura Card',300,0.5,1.3,1.2),(94,'Natura Card',330,0.5,1.3,1.2),(95,'Natura Card',350,0.6,1.5,1.4);
/*!40000 ALTER TABLE `tb_bobst_coated` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cartao`
--

DROP TABLE IF EXISTS `tb_cartao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cartao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cartao`
--

LOCK TABLES `tb_cartao` WRITE;
/*!40000 ALTER TABLE `tb_cartao` DISABLE KEYS */;
INSERT INTO `tb_cartao` VALUES (2,'TP White Plus'),(3,'Supremo Duo Design'),(4,'Supremo Alta Alvura'),(5,'Super 6 Plus'),(6,'Supera'),(7,'Speciala'),(8,'Ibema Ipona'),(9,'Pack Plus'),(10,'Vitamax'),(11,'Vitabianco'),(12,'Vitacarta'),(13,'Vitasolid'),(14,'Ecopack'),(15,'Natura Card'),(16,'Ritagli White'),(17,'Sulfite Alta Alvura'),(18,'Klakarton'),(19,'CMPC Maule'),(20,'Ensocoat ');
/*!40000 ALTER TABLE `tb_cartao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_carton_acoplado`
--

DROP TABLE IF EXISTS `tb_carton_acoplado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_carton_acoplado` (
  `id` int NOT NULL AUTO_INCREMENT,
  `faca` varchar(10) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `grm_cartao1` int DEFAULT NULL,
  `grm_cartao2` int DEFAULT NULL,
  `grm_total` int DEFAULT NULL,
  `uv` varchar(5) DEFAULT NULL,
  `pertinax` float(2,1) DEFAULT NULL,
  `fresa1` float(2,1) DEFAULT NULL,
  `fresa2` float(2,1) DEFAULT NULL,
  `observacao` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_carton_acoplado`
--

LOCK TABLES `tb_carton_acoplado` WRITE;
/*!40000 ALTER TABLE `tb_carton_acoplado` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_carton_acoplado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_carton_coated`
--

DROP TABLE IF EXISTS `tb_carton_coated`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_carton_coated` (
  `id` int NOT NULL AUTO_INCREMENT,
  `faca` varchar(10) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `grm_cartao` int DEFAULT NULL,
  `uv` varchar(5) DEFAULT NULL,
  `pertinax` float(2,1) DEFAULT NULL,
  `fresa1` float(2,1) DEFAULT NULL,
  `fresa2` float(2,1) DEFAULT NULL,
  `observacao` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_carton_coated`
--

LOCK TABLES `tb_carton_coated` WRITE;
/*!40000 ALTER TABLE `tb_carton_coated` DISABLE KEYS */;
INSERT INTO `tb_carton_coated` VALUES (1,'25920P','Super 6 Plus',295,'Sim',0.5,1.5,1.4,'Verso'),(2,'26644','Ecopack',300,'Não',0.5,1.4,1.3,'Alterou para 1.4 e 1.3 conforme Vanderlei em 08/07/20.'),(4,'25858','Supremo Alta Alvura',350,'Não',0.6,1.6,1.5,''),(5,'24370P','Super 6 Plus',225,'Não',0.6,1.4,1.3,''),(6,'26677','Super 6 Plus',275,'Não',0.5,1.3,1.2,'Terá vz UV no verso, mas não precisará aumentar as fresas em 0.10mm'),(7,'26972','Super 6 Plus',295,'Não',0.6,1.5,1.4,''),(8,'27177P','Super 6 Plus',295,'Não',0.6,1.6,1.4,'Magazine sem impressão com picote.'),(9,'27020','TP White Plus',285,'Não',0.5,1.5,1.4,''),(11,'18306','Natura Card',300,'Não',0.5,1.5,1.4,'Alterado para 1.5 e 1.4 conforme Marcelinho em 29/07/20'),(12,'27239P','Super 6 Plus',295,'Não',0.5,1.7,1.5,'Alteração solicitada pelo Vanderlei às 10H no dia 07/08/20. (Aprovado em Máquina).'),(13,'26973P','Super 6 Plus',295,'Sim',0.5,1.5,1.4,''),(14,'26574','TP White Plus',225,'Não',0.5,1.5,1.3,'Picote vincos 1 e 3'),(15,'25456P','TP White Plus',285,'Não',0.5,1.7,1.5,'Com picote'),(16,'27319P','TP White Plus',285,'Não',0.5,1.5,1.4,''),(17,'27031P','TP White Plus',285,'Não',0.5,1.5,1.4,''),(18,'27230P','Supera',280,'Não',0.5,1.7,1.5,'Configuração vista com Vanderlei. No picote usar 1.7 demais 1.5'),(19,'27371P','TP White Plus',350,'Não',0.6,1.6,1.5,''),(20,'14631P','TP White Plus',240,'Sim',0.5,1.5,1.3,''),(21,'26291P','Vitabianco',300,'Não',0.5,1.5,1.3,'Com picotes'),(22,'27457P','Super 6 Plus',295,'Sim',0.5,1.5,1.4,''),(23,'27404P','TP White Plus',285,'Não',0.5,1.7,1.5,'Com picotes'),(24,'19161P','TP White Plus',330,'Não',0.5,1.5,1.4,'Atualizado e conferido com Marcelo 21/09/20'),(25,'26983P','Natura Card',350,'Sim',0.5,1.7,1.6,'Com picote'),(26,'23359P','TP White Plus',310,'Não',0.5,1.6,1.4,'Foi alterado a fresa no picote e feito a remoção das elipses no fundo do cartucho. Alteração à pedido do Vanderlei 20/10/20'),(27,'14801','Sulfite Alta Alvura',150,'Não',0.4,0.9,0.9,''),(28,'27583P','TP White Plus',240,'Não',0.5,1.5,1.3,'Picote'),(29,'15141P','CMPC Maule',250,'Não',0.5,1.3,1.2,''),(30,'27740PM','Klakarton',276,'Não',0.6,1.5,1.4,''),(31,'24327P','Supera',225,'Não',0.5,1.2,1.1,'Alterado dia 04/01/21'),(32,'27508P','TP White Plus',285,'Não',0.5,1.7,1.5,'Alterado à pedido do Vanderlei  no dia 12/01/21. Motivo da alteração: A espessura 0.6 do pertinax quebrava o cartão.'),(33,'24687P','TP White Plus',310,'Não',0.5,1.5,1.4,''),(34,'27979P','TP White Plus',275,'Não',0.5,1.7,1.5,''),(35,'28052P','Supera',240,'Não',0.5,1.3,1.2,''),(36,'27735','Super 6 Plus',320,'Não',0.6,1.7,1.5,'Com picote'),(37,'16143PM','Ritagli White',275,'Não',0.5,1.5,1.4,'Foi solicitado para alterar o pertinax de 0.60 para 0.50.\n'),(38,'28215','Ensocoat ',240,'Não',0.5,1.4,1.3,''),(39,'28244P','Super 6 Plus',340,'Não',0.6,1.7,1.6,'Com Picote'),(40,'24093P','Super 6 Plus',260,'Sim',0.5,1.4,1.3,''),(41,'27568P','Super 6 Plus',296,'Sim',0.5,1.6,1.5,''),(42,'27571','Supera',295,'Não',0.5,1.5,1.4,''),(43,'27056P','TP White Plus',225,'Não',0.5,1.3,1.2,''),(44,'28708','Supremo Duo Design',250,'Sim',0.5,1.3,1.2,'Alterado para 0.50 conforme Vanderlei\nPara próxima produção confirmar com Vanderlei se as fresas precisarão ser alteradas.'),(45,'26725P','Natura Card',350,'Sim',0.5,1.6,1.5,''),(46,'28308','Supremo Alta Alvura',300,'Não',0.5,1.5,1.3,'Com picote'),(47,'20170P','Super 6 Plus',340,'Não',0.6,1.6,1.5,''),(49,'28184P','TP White Plus',330,'Sim',0.5,1.6,1.5,''),(50,'29133P','TP White Plus',262,'Não',0.5,1.4,1.3,''),(51,'29113','Ritagli White',0,'Não',0.5,1.4,1.3,'Conforme solicitado pelo Vanderlei 01/09/21'),(52,'29523P','TP White Plus',275,'Não',0.5,1.5,1.4,''),(53,'13940P','Ibema Ipona',0,'Não',0.5,1.4,1.4,'Arquivo refeito do Laser Line para o ArtiosCAD.'),(55,'12496CM','*',0,'*',0.4,1.4,1.3,''),(56,'16105M','*',0,'*',0.4,1.4,1.3,'');
/*!40000 ALTER TABLE `tb_carton_coated` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_carton_laminado`
--

DROP TABLE IF EXISTS `tb_carton_laminado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_carton_laminado` (
  `id` int NOT NULL AUTO_INCREMENT,
  `faca` varchar(10) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `grm_cartao` int DEFAULT NULL,
  `grm_laminado` int DEFAULT NULL,
  `grm_total` int DEFAULT NULL,
  `uv` varchar(5) DEFAULT NULL,
  `pertinax` float(2,1) DEFAULT NULL,
  `fresa1` float(2,1) DEFAULT NULL,
  `fresa2` float(2,1) DEFAULT NULL,
  `observacao` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_carton_laminado`
--

LOCK TABLES `tb_carton_laminado` WRITE;
/*!40000 ALTER TABLE `tb_carton_laminado` DISABLE KEYS */;
INSERT INTO `tb_carton_laminado` VALUES (2,'17488','TP White Plus',240,21,261,'Sim',0.6,1.6,1.5,''),(3,'27260','TP White Plus',275,21,296,'Sim',0.6,1.7,1.6,''),(4,'26752P','TP White Plus',275,21,296,'Sim',0.6,1.7,1.6,''),(5,'15611P','Supera',300,21,321,'Sim',0.5,1.5,1.4,''),(6,'27000P','TP White Plus',240,21,261,'Não',0.6,1.5,1.4,''),(7,'25673P','TP White Plus',240,21,261,'Não',0.6,1.5,1.4,''),(8,'26485P','TP White Plus',262,21,283,'Não',0.6,1.6,1.5,''),(9,'25442P','TP White Plus',262,21,283,'Não',0.6,1.6,1.5,''),(10,'27000P','Speciala',250,21,271,'Sim',0.5,1.5,1.4,''),(11,'27455P','Ritagli White',250,21,271,'Sim',0.5,1.5,1.4,''),(12,'25443','Ritagli White',275,21,296,'Não',0.5,1.7,1.5,''),(13,'25524P','Supera',240,21,261,'Sim',0.5,1.4,1.3,''),(14,'27568 P','Super 6 Plus',275,21,296,'Sim',0.5,1.6,1.5,''),(15,'26485','Supera',260,21,281,'Não',0.5,1.5,1.4,'');
/*!40000 ALTER TABLE `tb_carton_laminado` ENABLE KEYS */;
UNLOCK TABLES;
