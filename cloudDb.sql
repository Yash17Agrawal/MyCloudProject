CREATE DATABASE  IF NOT EXISTS `complete` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `complete`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: complete
-- ------------------------------------------------------
-- Server version	5.5.25a

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accounts` (
  `user_id` int(11) DEFAULT NULL,
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_type` text,
  `amount` double DEFAULT NULL,
  `pin` int(11) DEFAULT NULL,
  `loan_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (7,1,NULL,0,1,NULL),(7,2,'savings',0,2234,NULL),(7,3,'current',0,11,NULL),(7,4,'current',0,1234,NULL),(7,5,'savings',1101,101,NULL),(7,6,'savings',2,101,NULL),(7,7,'savings',0,23,NULL),(7,8,'savings',23,23,NULL),(7,9,'savings',0,1235,NULL),(7,10,'savings',234,1235,NULL);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_table`
--

DROP TABLE IF EXISTS `admin_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_table` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(256) DEFAULT NULL,
  `admin_password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_table`
--

LOCK TABLES `admin_table` WRITE;
/*!40000 ALTER TABLE `admin_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan_table`
--

DROP TABLE IF EXISTS `loan_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan_table` (
  `loan_id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `rate` double NOT NULL,
  `principal` double NOT NULL,
  `duration` double NOT NULL,
  PRIMARY KEY (`loan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan_table`
--

LOCK TABLES `loan_table` WRITE;
/*!40000 ALTER TABLE `loan_table` DISABLE KEYS */;
INSERT INTO `loan_table` VALUES (1,13,7,8.3,24354,2),(2,13,7,7.2,67,7),(3,13,7,7.2,3245,2),(4,14,7,8.3,101,2);
/*!40000 ALTER TABLE `loan_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_table`
--

DROP TABLE IF EXISTS `transaction_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_table` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id_from` int(11) DEFAULT NULL,
  `user_id_to` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `payment_mode` varchar(256) DEFAULT NULL,
  `current_status` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_table`
--

LOCK TABLES `transaction_table` WRITE;
/*!40000 ALTER TABLE `transaction_table` DISABLE KEYS */;
INSERT INTO `transaction_table` VALUES (1,2,3,456,NULL,'cash','sef'),(2,7,8,3456,NULL,'online','success'),(3,7,8,5678,NULL,'online','success'),(4,7,6,5678,NULL,'online','success'),(5,7,8,999,NULL,'online','success'),(6,7,9,0,NULL,'online','success'),(7,7,9,0,NULL,'online','success'),(8,7,999,67890,NULL,'online','success'),(9,7,10,546789,NULL,'online','success'),(10,7,9,845,NULL,'online','success'),(11,7,9,845,NULL,'online','success'),(12,7,7,0,NULL,'online','success'),(13,7,7,0,NULL,'online','success'),(14,-1,7,101,NULL,'online','success');
/*!40000 ALTER TABLE `transaction_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdata`
--

DROP TABLE IF EXISTS `userdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userdata` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `password` text,
  `verification_type` text,
  `verification_number` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT 'Active',
  `security_question` text,
  `security_answer` text,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdata`
--

LOCK TABLES `userdata` WRITE;
/*!40000 ALTER TABLE `userdata` DISABLE KEYS */;
INSERT INTO `userdata` VALUES (7,'yash','yash','adhaarcard',456,'null','friend','yash'),(8,'yash2','yash','adhaarcard',456,'null','friend','yash'),(9,'null','null','null',NULL,'null','null','null'),(10,'ut','ut','adhaarcard',787,NULL,'ghjk','gvhjblk'),(11,'ut','ut','adhaarcard',787,NULL,'ghjk','gvhjblk'),(12,'','','adhaarcard',787,NULL,'ghjk','gvhjblk'),(13,'aditya','yash',NULL,NULL,'active',NULL,NULL),(14,'po','po','po',56789,'active','po',NULL),(15,'','','',56789,'active','po',NULL),(16,'','','',3454,'active','',NULL),(17,'','','',3454,'active','',NULL),(18,'sir','sir','adhaar',34,'active','sir',NULL);
/*!40000 ALTER TABLE `userdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-07 20:05:21
