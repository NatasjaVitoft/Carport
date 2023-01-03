-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: carport
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `itemvariant`
--

DROP TABLE IF EXISTS `itemvariant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemvariant` (
  `itemvariant_id` int NOT NULL,
  `description` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `unit` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  PRIMARY KEY (`itemvariant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemvariant`
--

LOCK TABLES `itemvariant` WRITE;
/*!40000 ALTER TABLE `itemvariant` DISABLE KEYS */;
INSERT INTO `itemvariant` VALUES (1,'Skrue til tagplader','plastmo bundskruer 200stk','pakke','430'),(2,'til vindkryds på spær','hulbån ','rulle','200'),(3,'til montering af spær på rem','universal højre','stk','50'),(4,'til montering af spær på rem','universal venstre','stk','50'),(5,'til montering af stern&vandbrædt','skruer 200stk','pakke','250'),(6,'til montering af unvisalbeslag+hulbånd','beslagskruer 250stk','pakke','300'),(7,'til montering af rem på stolper','bræddebolt','stk','20'),(8,'til montering af rem på stolper','firkantskriver','stk','20'),(9,'til montering af yderste beklædning','skruer 400 stk','pakke','300'),(10,'til montering af inderste beklædning','skrue 300stk','pakke','250'),(11,'til lås på skur','stalddørsgre','sæt','50'),(12,'til skurdør','t hængsel','stk','20'),(13,'til montering af løsholter i skur','vinkelbeslag','stk','50');
/*!40000 ALTER TABLE `itemvariant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-03 13:31:59
