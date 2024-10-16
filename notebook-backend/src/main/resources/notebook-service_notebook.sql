-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: notebook-service
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `notebook`
--

DROP TABLE IF EXISTS `notebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notebook` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) NOT NULL,
  `gpu` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `processor` varchar(255) NOT NULL,
  `ram` int NOT NULL,
  `storage` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notebook`
--

LOCK TABLES `notebook` WRITE;
/*!40000 ALTER TABLE `notebook` DISABLE KEYS */;
INSERT INTO `notebook` VALUES (3,'Samsung','3060TI','Galaxy',700,'intel i7',8,'1TB'),(4,'Dell','Intel UHD Graphics','XPS 13',900,'Intel i5',8,'512GB SSD'),(5,'Samsung','3060TI','Galaxy',700,'Intel i7',8,'1TB'),(6,'HP','Intel Iris Plus','Spectre x360',1200,'Intel i7',16,'1TB SSD'),(7,'Lenovo','NVIDIA GeForce GTX 1650','ThinkPad X1',1800,'Intel i9',32,'1TB SSD'),(8,'Asus','NVIDIA GTX 1650','ZenBook 14',1000,'AMD Ryzen 7',16,'512GB SSD'),(9,'Apple','Apple M1 Pro GPU','MacBook Pro 16',2500,'Apple M1 Pro',16,'1TB SSD'),(10,'Microsoft','Intel Iris Xe','Surface Laptop 4',1300,'Intel i7',16,'512GB SSD'),(11,'Razer','NVIDIA RTX 3070','Blade 15',2000,'Intel i7',16,'1TB SSD'),(12,'Acer','NVIDIA RTX 3080','Predator Helios 300',2200,'Intel i9',32,'1TB SSD'),(13,'HP','NVIDIA GTX 1650','Omen 15',900,'Intel i5',8,'512GB SSD'),(14,'Lenovo','NVIDIA GTX 1660 Ti','Legion 5',1000,'AMD Ryzen 5',16,'1TB SSD'),(15,'Asus','NVIDIA RTX 2060','TUF Gaming F15',1200,'Intel i7',16,'512GB SSD'),(16,'Dell','NVIDIA GTX 1660 Ti','G5 15',1300,'Intel i7',16,'1TB SSD'),(17,'Apple','Apple M1 GPU','MacBook Air M1',1000,'Apple M1',8,'256GB SSD'),(18,'Microsoft','NVIDIA GTX 1660 Ti','Surface Book 3',1500,'Intel i7',16,'512GB SSD'),(19,'Acer','AMD Radeon Vega 8','Swift 3',600,'AMD Ryzen 5',8,'256GB SSD'),(20,'HP','Intel UHD Graphics','Envy 13',700,'Intel i5',8,'512GB SSD');
/*!40000 ALTER TABLE `notebook` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 17:52:25
