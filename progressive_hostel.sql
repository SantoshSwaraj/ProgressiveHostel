CREATE DATABASE  IF NOT EXISTS `progressive_hostel` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `progressive_hostel`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: progressive_hostel
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `class_hostel_monthly_fee`
--

DROP TABLE IF EXISTS `class_hostel_monthly_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_hostel_monthly_fee` (
  `CLASS_HOSTEL_MONTHLY_FEE_ID` int(3) NOT NULL AUTO_INCREMENT,
  `CLASS_ID` int(2) DEFAULT NULL,
  `FEE` int(10) DEFAULT NULL,
  PRIMARY KEY (`CLASS_HOSTEL_MONTHLY_FEE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_hostel_monthly_fee`
--

LOCK TABLES `class_hostel_monthly_fee` WRITE;
/*!40000 ALTER TABLE `class_hostel_monthly_fee` DISABLE KEYS */;
INSERT INTO `class_hostel_monthly_fee` VALUES (1,1,5000),(2,2,5000),(3,3,5000),(4,4,5400),(5,5,5400),(6,8,600000);
/*!40000 ALTER TABLE `class_hostel_monthly_fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_section`
--

DROP TABLE IF EXISTS `class_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_section` (
  `CLASS_SECTION_ID` int(4) NOT NULL AUTO_INCREMENT,
  `CLASS_ID` int(2) DEFAULT NULL,
  `SECTION_ID` int(2) DEFAULT NULL,
  PRIMARY KEY (`CLASS_SECTION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_section`
--

LOCK TABLES `class_section` WRITE;
/*!40000 ALTER TABLE `class_section` DISABLE KEYS */;
INSERT INTO `class_section` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4);
/*!40000 ALTER TABLE `class_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classes` (
  `CLASS_ID` int(2) NOT NULL AUTO_INCREMENT,
  `CLASS_NAME` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`CLASS_ID`),
  UNIQUE KEY `CLASS_NAME` (`CLASS_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (4,'1'),(13,'10'),(5,'2'),(6,'3'),(7,'4'),(8,'5'),(9,'6'),(10,'7'),(11,'8'),(12,'9'),(2,'KG 1'),(3,'KG 2'),(1,'PLAY GROUP');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collection` (
  `COLLECTION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(11) DEFAULT NULL,
  `BILL_NO` varchar(45) DEFAULT NULL,
  `PAID_AMT` int(8) DEFAULT NULL,
  `ENTRY_ID` int(8) DEFAULT NULL,
  `ENTRY_DATE` date DEFAULT NULL,
  `ENTRY_DATE_TIME` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`COLLECTION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
INSERT INTO `collection` VALUES (1,1,'1/5/2018',7500,1,'2018-05-05','2018-05-05 12:43:01'),(2,1,'1/5/2018',1500,1,'2018-05-05','2018-05-05 12:50:31'),(3,1,'1/5/2018',1000,1,'2018-05-05','2018-05-05 12:52:06');
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hostel_monthly_fee_ledger`
--

DROP TABLE IF EXISTS `hostel_monthly_fee_ledger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hostel_monthly_fee_ledger` (
  `HOSTEL_MONTHLY_FEE_LEDGER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(11) DEFAULT NULL,
  `ADMISSION_NO` varchar(20) DEFAULT NULL,
  `CLASS_ID` int(2) DEFAULT NULL,
  `SECTION_ID` int(2) DEFAULT NULL,
  `BILL_NO` varchar(25) DEFAULT NULL,
  `BILL_MONTH_ID` int(2) DEFAULT NULL,
  `BILL_YEAR` varchar(4) DEFAULT NULL,
  `CURRENT_MONTH_FEE` int(10) DEFAULT '0',
  `ARREARS_AMT` int(10) DEFAULT '0',
  `TOTAL_TO_PAY` int(10) DEFAULT '0',
  `TOTAL_PAID_AMT` int(10) DEFAULT '0',
  `BALANCE_AMT` int(10) DEFAULT '0',
  `IS_PAID_ONCE` int(1) DEFAULT '0',
  `ENTRY_ID` int(8) DEFAULT NULL,
  `ENTRY_DATE` date DEFAULT NULL,
  `ENTRY_DATE_TIME` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`HOSTEL_MONTHLY_FEE_LEDGER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hostel_monthly_fee_ledger`
--

LOCK TABLES `hostel_monthly_fee_ledger` WRITE;
/*!40000 ALTER TABLE `hostel_monthly_fee_ledger` DISABLE KEYS */;
INSERT INTO `hostel_monthly_fee_ledger` VALUES (1,1,'0001-2018',1,1,'1/5/2018',5,'2018',5000,5000,5000,1000,4000,1,1,'2018-05-05','2018-05-05 12:52:06');
/*!40000 ALTER TABLE `hostel_monthly_fee_ledger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `month`
--

DROP TABLE IF EXISTS `month`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `month` (
  `MONTH_ID` int(2) NOT NULL AUTO_INCREMENT,
  `MONTH` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MONTH_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `month`
--

LOCK TABLES `month` WRITE;
/*!40000 ALTER TABLE `month` DISABLE KEYS */;
INSERT INTO `month` VALUES (1,'JAN'),(2,'FEB'),(3,'MAR'),(4,'APR'),(5,'MAY'),(6,'JUNE'),(7,'JULY'),(8,'AUG'),(9,'SEP'),(10,'OCT'),(11,'NOV'),(12,'DEC');
/*!40000 ALTER TABLE `month` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `one_time_charges`
--

DROP TABLE IF EXISTS `one_time_charges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `one_time_charges` (
  `ONE_TIME_CHARGE_ID` int(2) NOT NULL AUTO_INCREMENT,
  `CHARGE_NAME` varchar(45) DEFAULT NULL,
  `CHARGE_AMOUNT` int(10) DEFAULT NULL,
  PRIMARY KEY (`ONE_TIME_CHARGE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `one_time_charges`
--

LOCK TABLES `one_time_charges` WRITE;
/*!40000 ALTER TABLE `one_time_charges` DISABLE KEYS */;
INSERT INTO `one_time_charges` VALUES (1,'Securtiy Money',8000),(2,'Packet Money',1000),(3,'Securtiy Money',50000);
/*!40000 ALTER TABLE `one_time_charges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section` (
  `SECTION_ID` int(2) NOT NULL AUTO_INCREMENT,
  `SECTION_NAME` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`SECTION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
INSERT INTO `section` VALUES (1,'A'),(2,'B'),(3,'C'),(4,'D'),(5,'E'),(6,'5');
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `session` (
  `SESSION_ID` int(5) NOT NULL AUTO_INCREMENT,
  `SESSION` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`SESSION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES (1,'2018-2019'),(2,'2019-2020'),(3,'2020-2021');
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_address_details`
--

DROP TABLE IF EXISTS `student_address_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_address_details` (
  `STUDENT_ADDRESS_DETAILS_ID` int(5) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(11) DEFAULT NULL,
  `STUDENT_C_ADDRESS` varchar(45) DEFAULT NULL,
  `STUDENT_C_STATE` varchar(45) DEFAULT NULL,
  `STUDENT_C_CITY` varchar(45) DEFAULT NULL,
  `STUDENT_C_PIN_CODE` varchar(6) DEFAULT NULL,
  `STUDENT_P_ADDRESS` varchar(45) DEFAULT NULL,
  `STUDENT_P_STATE` varchar(45) DEFAULT NULL,
  `STUDENT_P_CITY` varchar(45) DEFAULT NULL,
  `STUDENT_P_PIN_CODE` varchar(6) DEFAULT NULL,
  `ENTRY_ID` int(8) DEFAULT NULL,
  `ENTRY_DATE` date DEFAULT NULL,
  `ENTRY_DATE_TIME` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`STUDENT_ADDRESS_DETAILS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_address_details`
--

LOCK TABLES `student_address_details` WRITE;
/*!40000 ALTER TABLE `student_address_details` DISABLE KEYS */;
INSERT INTO `student_address_details` VALUES (1,1,'Check Post , Chas','Jharkhand','Bokaro','827013','Check Post , Chas','Jharkhand','Bokaro','827013',1,'2018-05-05','2018-05-05 12:30:09'),(2,2,'jgg','gjg','jgkjg','656311','jgg','gjg','jgkjg','656311',1,'2018-05-05','2018-05-05 13:49:49');
/*!40000 ALTER TABLE `student_address_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_document_details`
--

DROP TABLE IF EXISTS `student_document_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_document_details` (
  `STUDENT_DOCUMENT_DETAILS_ID` int(5) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(11) DEFAULT NULL,
  `STUDENT_PHOTO_DOC` varchar(45) DEFAULT NULL,
  `STUDENT_AADHAR_DOC` varchar(45) DEFAULT NULL,
  `STUDENT_SCHOOL_ID_DOC` varchar(45) DEFAULT NULL,
  `ENTRY_ID` int(8) DEFAULT NULL,
  `ENTRY_DATE` date DEFAULT NULL,
  `ENTRY_DATE_TIME` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`STUDENT_DOCUMENT_DETAILS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_document_details`
--

LOCK TABLES `student_document_details` WRITE;
/*!40000 ALTER TABLE `student_document_details` DISABLE KEYS */;
INSERT INTO `student_document_details` VALUES (1,1,'','','',1,'2018-05-05','2018-05-05 12:30:09'),(2,2,'1525528262876@Photo.jpg','1525528262939@Aadhar.jpg','1525528263001@SchoolId.jpg',1,'2018-05-05','2018-05-05 13:49:49');
/*!40000 ALTER TABLE `student_document_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_master`
--

DROP TABLE IF EXISTS `student_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_master` (
  `STUDENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_NAME` varchar(45) DEFAULT NULL,
  `SESSION_ID` int(2) DEFAULT NULL,
  `CLASS_ID` int(2) DEFAULT NULL,
  `SECTION_ID` int(2) DEFAULT NULL,
  `STUDENT_ROLL_NO` int(2) DEFAULT NULL,
  `STUDENT_DOB` date DEFAULT NULL,
  `ADMISSION_NO` varchar(20) DEFAULT NULL,
  `IS_ACTIVE` int(1) DEFAULT '0',
  `ENTRY_ID` int(8) DEFAULT NULL,
  `ENTRY_DATE` date DEFAULT NULL,
  `ENTRY_DATE_TIME` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`STUDENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_master`
--

LOCK TABLES `student_master` WRITE;
/*!40000 ALTER TABLE `student_master` DISABLE KEYS */;
INSERT INTO `student_master` VALUES (1,'TestA',1,1,1,1,'2015-06-02','0001-2018',1,1,'2018-05-05','2018-05-05 12:30:09'),(2,'tanay',1,1,2,12455,'2015-03-05','0002-2018',1,1,'2018-05-05','2018-05-05 13:49:49');
/*!40000 ALTER TABLE `student_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_one_time_charge_details`
--

DROP TABLE IF EXISTS `student_one_time_charge_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_one_time_charge_details` (
  `STUDENT_ONE_TIME_CHARGE_DETAILS_ID` int(5) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(11) DEFAULT NULL,
  `SECURITY_MONEY` int(8) DEFAULT NULL,
  `PACKET_MONEY` int(8) DEFAULT NULL,
  `TOTAL_TO_PAY` int(8) DEFAULT NULL,
  `TOTAL_PAID_AMT` int(8) DEFAULT NULL,
  `BALANCE_AMT` int(8) DEFAULT NULL,
  `IS_PAID` int(1) DEFAULT '0',
  `IS_REFUNDED` int(1) DEFAULT '0',
  `ENTRY_ID` int(8) DEFAULT NULL,
  `ENTRY_DATE` date DEFAULT NULL,
  `ENTRY_DATE_TIME` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`STUDENT_ONE_TIME_CHARGE_DETAILS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_one_time_charge_details`
--

LOCK TABLES `student_one_time_charge_details` WRITE;
/*!40000 ALTER TABLE `student_one_time_charge_details` DISABLE KEYS */;
INSERT INTO `student_one_time_charge_details` VALUES (1,1,8000,1000,9000,7500,1500,1,0,1,'2018-05-05','2018-05-05 12:43:01');
/*!40000 ALTER TABLE `student_one_time_charge_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_parent_details`
--

DROP TABLE IF EXISTS `student_parent_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_parent_details` (
  `STUDENT_PARENT_DETAILS_ID` int(5) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(11) DEFAULT NULL,
  `STUDENT_FATHER_NAME` varchar(45) DEFAULT NULL,
  `STUDENT_FATHER_MOBILE_NUMBER` varchar(45) DEFAULT NULL,
  `STUDENT_FATHER_OCCUPATION` varchar(45) DEFAULT NULL,
  `STUDENT_MOTHER_NAME` varchar(45) DEFAULT NULL,
  `STUDENT_MOTHER_MOBILE_NUMBER` varchar(45) DEFAULT NULL,
  `STUDENT_MOTHER_OCCUPATION` varchar(45) DEFAULT NULL,
  `STUDENT_GUARDIAN_NAME` varchar(45) DEFAULT NULL,
  `STUDENT_GUARDIAN_MOBILE` varchar(45) DEFAULT NULL,
  `ENTRY_ID` int(8) DEFAULT NULL,
  `ENTRY_DATE` date DEFAULT NULL,
  `ENTRY_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`STUDENT_PARENT_DETAILS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_parent_details`
--

LOCK TABLES `student_parent_details` WRITE;
/*!40000 ALTER TABLE `student_parent_details` DISABLE KEYS */;
INSERT INTO `student_parent_details` VALUES (1,1,'TestAf','9874563210','Farmer','testam','1478523690','HouseWife',NULL,NULL,1,'2018-05-05','2018-05-05 12:30:57'),(2,2,'xyz','8787878787','jhgjgkjgkj','abc','787878787878','gjkgkjgbkj','jgkjbkjk',NULL,1,'2018-05-05','2018-05-05 13:50:16');
/*!40000 ALTER TABLE `student_parent_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USER_ID` int(8) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` int(8) DEFAULT NULL,
  `EMP_NAME` varchar(50) DEFAULT NULL,
  `MOBILE_NO` varchar(11) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `USER_TYPE_ID` int(8) DEFAULT NULL,
  `STATUS` int(2) DEFAULT NULL,
  `ENTRY_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (5,1,'Santosh Kushwaha','9534138753','santosh@courses18.com','santosh@123','12345',1,1,'2018-05-05 10:42:57');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_type` (
  `USER_TYPE_ID` int(3) NOT NULL AUTO_INCREMENT,
  `USER_TYPE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`USER_TYPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_type`
--

LOCK TABLES `user_type` WRITE;
/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
INSERT INTO `user_type` VALUES (1,'ADMIN'),(2,'WARDEN'),(3,'ACCOUNTS');
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-08 17:18:13
