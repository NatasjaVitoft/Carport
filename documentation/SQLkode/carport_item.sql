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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `item_id` int NOT NULL,
  `description` varchar(100) NOT NULL,
  `length` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `unit` varchar(45) NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'understernbrædder til for & bag ende',360,'25x200 mm. trykimp. Brædt','stk',205),(2,'understernbrædder til siderne',540,'25x200 mm. trykimp. Brædt','stk',305),(3,'oversternbrædder til forenden',360,'25x125mm. trykimp. Brædt','stk',130),(4,'for & bagende',540,'25x125mm. trykimp. Brædt','stk',195),(5,'til z på bagside af dør',420,'38x73 mm. Lægte ubh.','stk',65),(6,'løsholter til skur gavle',270,'45x95 mm. Reglar ub.','stk',55),(7,'løsholter til skur sider',240,'45x95 mm. Reglar ub.','stk',45),(8,'Remme i sider, sadles ned i stolper',600,'45x195 mm. spærtræ ubh.','stk',250),(9,'Remme i sider, sadles ned i stolper ( skur del,',480,'45x195 mm. spærtræ ubh.','stk',200),(10,'Spær, monteres på rem',600,'45x195 mm. spærtræ ubh.','stk',250),(11,'Stolper nedgraves 90 cm. i jord',300,'97x97 mm. trykimp. Stolpe','stk',150),(12,'til beklædning af skur 1 på 2',210,'19x100 mm. trykimp. Brædt','stk',20),(13,'vandbrædt på stern i sider',540,'19x100 mm. trykimp. Brædt','stk',50),(14,'vandbrædt på stern i forende',360,'19x100 mm. trykimp. Brædt','stk',30),(15,'tagplader monteres på spær',600,'Plastmo Ecolite blåtonet','stk',330),(16,'tagplader monteres på spær',360,'Plastmo Ecolite blåtonet','stk',200);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-03 13:31:58
