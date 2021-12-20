-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: elections
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Party`
--

DROP TABLE IF EXISTS `party`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `party` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Party`
--

LOCK TABLES `party` WRITE;
/*!40000 ALTER TABLE `party` DISABLE KEYS */;
INSERT INTO `party` VALUES (1,'Socialdemokratiet'),(2,'Det konservative Folkeparti '),(3,'SF, Socialistisk Folkeparti\n'),(4,'Dansk Folkeparti'),(5,'Venstre, Danmarks Liberale Parti\n'),(6,'Enhedslisten + De Rød GrønnePoliticiansname');
/*!40000 ALTER TABLE `party` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Politicians`
--

DROP TABLE IF EXISTS `politicians`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `politicians` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `party_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`,`party_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_politicians_Party_idx` (`party_id`),
  CONSTRAINT `fk_politicians_party` FOREIGN KEY (`party_id`) REFERENCES `party` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Politicians`
--

LOCK TABLES `politicians` WRITE;
/*!40000 ALTER TABLE `politicians` DISABLE KEYS */;
INSERT INTO `politicians` VALUES (1,'Marcel Meijer',1),(2,'Michael Kristensen',1),(3,'Helle Hansen',1),(4,'Karina Knobelauch',1),(5,'Stefan Hafstein Wolffbrandt',1),(6,'Robert V. Rasmussen',1),(7,'Pia Ramsing',1),(8,'Anders Baun Sørensen',1),(9,'Per Urban Olsen',2),(10,'Peter Askjær',2),(11,'Martin Sørensen',2),(12,'Ulla Holm',3),(13,'Kjeld Bønkel',3),(14,'Børge S. Buur',3),(15,'Per Mortensen',4),(16,'Søren Wiese',5),(17,'Anja Guldborg',5),(18,'Jette M. Søgaard',6),(19,'Pia Birkmand',6);
/*!40000 ALTER TABLE `politicians` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Votes`
--

DROP TABLE IF EXISTS `votes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `votes` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `CPR` varchar(45) NOT NULL,
  `politicians_id` int unsigned NOT NULL,
  `party_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`,`politicians_id`,`party_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `CPR_UNIQUE` (`CPR`),
  KEY `fk_votes_politicians1_idx` (`politicians_id`),
  KEY `fk_votes_party1_idx` (`party_id`),
  CONSTRAINT `fk_votes_party1` FOREIGN KEY (`party_id`) REFERENCES `party` (`id`),
  CONSTRAINT `fk_votes_politicians1` FOREIGN KEY (`politicians_id`) REFERENCES `politicians` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Votes`
--

LOCK TABLES `votes` WRITE;
/*!40000 ALTER TABLE `votes` DISABLE KEYS */;
/*!40000 ALTER TABLE `votes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 17:50:38
