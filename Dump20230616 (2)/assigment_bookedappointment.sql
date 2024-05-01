-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: assigment
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
-- Table structure for table `bookedappointment`
--

DROP TABLE IF EXISTS `bookedappointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookedappointment` (
  `Appointment_Id` int NOT NULL AUTO_INCREMENT,
  `Doctor_Name` varchar(50) NOT NULL,
  `Patient_Email` varchar(50) NOT NULL,
  `Patient_Name` varchar(50) DEFAULT NULL,
  `Appointment_Date` varchar(50) NOT NULL,
  `Appointment_Time` varchar(50) NOT NULL,
  `Doctor_Specialist` varchar(45) NOT NULL,
  PRIMARY KEY (`Appointment_Id`),
  KEY `Doctor_Name_idx` (`Doctor_Name`),
  KEY `Patient_Id_idx` (`Patient_Email`),
  CONSTRAINT `patient email` FOREIGN KEY (`Patient_Email`) REFERENCES `patient` (`Patient_Email`)
) ENGINE=InnoDB AUTO_INCREMENT=2013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookedappointment`
--

LOCK TABLES `bookedappointment` WRITE;
/*!40000 ALTER TABLE `bookedappointment` DISABLE KEYS */;
INSERT INTO `bookedappointment` VALUES (2011,'faris akram','fasial@gmail.com','fasial ali','2023-06-05','10:30PM','surguy'),(2012,'zyed mayoof','ayoub@gmail.com','ayoub ali','2023-02-05','2:30PM','dentist');
/*!40000 ALTER TABLE `bookedappointment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-16 23:46:46
