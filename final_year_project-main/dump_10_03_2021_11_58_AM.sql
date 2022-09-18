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
  `create_on` datetime DEFAULT NULL,
  `create_by` varchar(200) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `deleted_by` varchar(200) DEFAULT NULL,
  `update_on` datetime DEFAULT NULL,
  `update_by` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
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
  `create_on` datetime DEFAULT NULL,
  `create_by` varchar(45) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `deleted_by` varchar(200) DEFAULT NULL,
  `update_on` datetime DEFAULT NULL,
  `update_by` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_reg_data`
--

LOCK TABLES `patient_reg_data` WRITE;
/*!40000 ALTER TABLE `patient_reg_data` DISABLE KEYS */;
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
  `create_on` datetime DEFAULT NULL,
  `create_by` varchar(200) DEFAULT NULL,
  `update_on` datetime DEFAULT NULL,
  `update_by` varchar(200) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `deleted_by` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor_data`
--

LOCK TABLES `sensor_data` WRITE;
/*!40000 ALTER TABLE `sensor_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensor_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'healthcare_automation'
--

--
-- Dumping routines for database 'healthcare_automation'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-03 11:59:04
