@@ -1,225 +0,0 @@
CREATE DATABASE  IF NOT EXISTS `healthcare_automation` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `healthcare_automation`;
-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: healthcare_automation
-- ------------------------------------------------------
-- Server version	5.7.34-log

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
-- Table structure for table `admin_user`
--

DROP TABLE IF EXISTS `admin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_user_name` varchar(200) DEFAULT NULL,
  `admin_user_password` varchar(200) DEFAULT NULL,
  `status` varchar(1) DEFAULT 'A',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_user`
--

LOCK TABLES `admin_user` WRITE;
/*!40000 ALTER TABLE `admin_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guardian`
--

DROP TABLE IF EXISTS `guardian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guardian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(450) DEFAULT NULL,
  `contact_no` varchar(45) DEFAULT NULL,
  `contact_sms` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `status` varchar(1) DEFAULT 'A',
  `remark` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guardian`
--

LOCK TABLES `guardian` WRITE;
/*!40000 ALTER TABLE `guardian` DISABLE KEYS */;
INSERT INTO `guardian` VALUES (2,'a','121','456','abc','A','');
/*!40000 ALTER TABLE `guardian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_treatment_history`
--

DROP TABLE IF EXISTS `medical_treatment_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_treatment_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `type` varchar(450) DEFAULT NULL,
  `detail` varchar(450) DEFAULT NULL,
  `done_by` varchar(450) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `remark` varchar(450) DEFAULT NULL,
  `create_on` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(200) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `deleted_by` varchar(200) DEFAULT NULL,
  `update_on` datetime DEFAULT NULL,
  `update_by` varchar(200) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idx` (`patient_id`),
  CONSTRAINT `fk` FOREIGN KEY (`patient_id`) REFERENCES `patient_reg_data` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_treatment_history`
--

LOCK TABLES `medical_treatment_history` WRITE;
/*!40000 ALTER TABLE `medical_treatment_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_treatment_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_guardian_relation`
--

DROP TABLE IF EXISTS `patient_guardian_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_guardian_relation` (
  `id` int(11) NOT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `guardian_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_4_idx` (`patient_id`),
  KEY `fk_5_idx` (`guardian_id`),
  CONSTRAINT `fk_4` FOREIGN KEY (`patient_id`) REFERENCES `patient_reg_data` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_5` FOREIGN KEY (`guardian_id`) REFERENCES `guardian` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_guardian_relation`
--

LOCK TABLES `patient_guardian_relation` WRITE;
/*!40000 ALTER TABLE `patient_guardian_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_guardian_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_reg_data`
--

DROP TABLE IF EXISTS `patient_reg_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_reg_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(450) DEFAULT NULL,
  `current_address` varchar(450) DEFAULT NULL,
  `permanent_address` varchar(450) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `contact_1` varchar(50) DEFAULT NULL,
  `contact_2` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` char(1) DEFAULT 'A',
  `remark` varchar(450) DEFAULT NULL,
  `create_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(45) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `deleted_by` varchar(200) DEFAULT NULL,
  `update_on` datetime DEFAULT NULL,
  `update_by` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_reg_data`
--

LOCK TABLES `patient_reg_data` WRITE;
/*!40000 ALTER TABLE `patient_reg_data` DISABLE KEYS */;
INSERT INTO `patient_reg_data` VALUES (8,'amal','abc','abc2','1991-02-24','04456565','','','A','','2021-11-07 17:52:33',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `patient_reg_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor_data`
--

DROP TABLE IF EXISTS `sensor_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sensor_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) DEFAULT NULL,
  `pulse_rate_string` varchar(200) DEFAULT NULL,
  `pulse_rate_decimal` decimal(10,2) DEFAULT NULL,
  `spo2_level_string` varchar(200) DEFAULT NULL,
  `spo2_level_decimal` decimal(10,2) DEFAULT NULL,
  `temp_string` varchar(200) DEFAULT NULL,
  `temp_decimal` decimal(10,2) DEFAULT NULL,
  `status` char(1) DEFAULT 'A',
  `remark` char(5) DEFAULT NULL,
  `create_on` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(200) DEFAULT NULL,
  `update_on` datetime DEFAULT NULL,
  `update_by` varchar(200) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `deleted_by` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_2_idx` (`patient_id`),
  CONSTRAINT `fk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient_reg_data` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor_data`
--

LOCK TABLES `sensor_data` WRITE;
/*!40000 ALTER TABLE `sensor_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensor_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-27 22:51:08