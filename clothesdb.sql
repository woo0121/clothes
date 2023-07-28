-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: clothesdb
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `tbl_coupon`
--

DROP TABLE IF EXISTS `tbl_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_coupon` (
  `coupon_code` int NOT NULL AUTO_INCREMENT,
  `member_id` int NOT NULL,
  `product_code` int NOT NULL,
  `sale_price` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`coupon_code`,`member_id`),
  KEY `FK_MEMBER_ID_idx` (`member_id`),
  KEY `FK_PRODUCT_CODE_idx` (`product_code`),
  CONSTRAINT `COUPON_FK_MEMBER_ID` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`member_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `COUPON_FK_PRODUCT_CODE` FOREIGN KEY (`product_code`) REFERENCES `tbl_product` (`product_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_coupon`
--

LOCK TABLES `tbl_coupon` WRITE;
/*!40000 ALTER TABLE `tbl_coupon` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_emailcode`
--

DROP TABLE IF EXISTS `tbl_emailcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_emailcode` (
  `emailcode_id` int NOT NULL AUTO_INCREMENT,
  `emailcode` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `email_date` date NOT NULL,
  `email` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`emailcode_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_emailcode`
--

LOCK TABLES `tbl_emailcode` WRITE;
/*!40000 ALTER TABLE `tbl_emailcode` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_emailcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_manager`
--

DROP TABLE IF EXISTS `tbl_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_manager` (
  `manager_id` int NOT NULL AUTO_INCREMENT,
  `id` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `pw` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `email` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`manager_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_manager`
--

LOCK TABLES `tbl_manager` WRITE;
/*!40000 ALTER TABLE `tbl_manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_member`
--

DROP TABLE IF EXISTS `tbl_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_member` (
  `member_id` int NOT NULL AUTO_INCREMENT,
  `pwd` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `name` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `phone` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `addr` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `email` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`member_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_member`
--

LOCK TABLES `tbl_member` WRITE;
/*!40000 ALTER TABLE `tbl_member` DISABLE KEYS */;
INSERT INTO `tbl_member` VALUES (22,'a','b','c','d','e');
/*!40000 ALTER TABLE `tbl_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_non_member`
--

DROP TABLE IF EXISTS `tbl_non_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_non_member` (
  `non_member_id` int NOT NULL AUTO_INCREMENT,
  `pwd` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `phone` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `addr` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `order_id` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `email` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`non_member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_non_member`
--

LOCK TABLES `tbl_non_member` WRITE;
/*!40000 ALTER TABLE `tbl_non_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_non_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_order`
--

DROP TABLE IF EXISTS `tbl_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_order` (
  `order_number` int NOT NULL AUTO_INCREMENT,
  `order_date` date NOT NULL,
  `payment` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `order_amount` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `member_id` int NOT NULL,
  `non_member_id` int NOT NULL,
  `product_code` int NOT NULL,
  `order_id` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`order_number`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`),
  KEY `ORDER_FK_MEMBER_ID_idx` (`member_id`),
  KEY `ORDER_FK_NON_MEMBER_ID_idx` (`non_member_id`),
  KEY `ORDER_FK_PRODUCT_CODE_idx` (`product_code`),
  CONSTRAINT `ORDER_FK_MEMBER_ID` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`member_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ORDER_FK_NON_MEMBER_ID` FOREIGN KEY (`non_member_id`) REFERENCES `tbl_non_member` (`non_member_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ORDER_FK_PRODUCT_CODE` FOREIGN KEY (`product_code`) REFERENCES `tbl_product` (`product_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_order`
--

LOCK TABLES `tbl_order` WRITE;
/*!40000 ALTER TABLE `tbl_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_product`
--

DROP TABLE IF EXISTS `tbl_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_product` (
  `product_code` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `product_class` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `brand` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `price` int NOT NULL,
  `product_picture` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `amount` int NOT NULL,
  `amount_lapping` int NOT NULL,
  `product_id` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`product_code`),
  UNIQUE KEY `product_picture_UNIQUE` (`product_picture`),
  UNIQUE KEY `product_id_UNIQUE` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_product`
--

LOCK TABLES `tbl_product` WRITE;
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_review`
--

DROP TABLE IF EXISTS `tbl_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_review` (
  `review_code` int NOT NULL AUTO_INCREMENT,
  `starpoint` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `comment` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `member_id` int NOT NULL,
  `non_member_id` int NOT NULL,
  `order_number` int NOT NULL,
  PRIMARY KEY (`review_code`),
  KEY `REVIEW_FK_MEMBER_ID_idx` (`member_id`),
  KEY `REVIEW_FK_NON_MEMBER_ID_idx` (`non_member_id`),
  KEY `REVIEW_FK_ORDER_NUMBER_idx` (`order_number`),
  CONSTRAINT `REVIEW_FK_MEMBER_ID` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`member_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `REVIEW_FK_NON_MEMBER_ID` FOREIGN KEY (`non_member_id`) REFERENCES `tbl_non_member` (`non_member_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `REVIEW_FK_ORDER_NUMBER` FOREIGN KEY (`order_number`) REFERENCES `tbl_order` (`order_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_review`
--

LOCK TABLES `tbl_review` WRITE;
/*!40000 ALTER TABLE `tbl_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'clothesdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-27 23:20:43
