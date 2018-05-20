-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ticketing_system
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `customername` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (4,'nicosan','nicosan','Nix','Baguio City','nico@gmail.com'),(5,'nekosan','nekosan','Naeko','Baguio City','neko@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `eventid` int(11) NOT NULL AUTO_INCREMENT,
  `eventname` varchar(45) NOT NULL,
  `totalTickets` int(11) NOT NULL,
  `soldTickets` int(11) NOT NULL,
  `description` varchar(45) NOT NULL,
  `eventDate` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `poster` longblob,
  PRIMARY KEY (`eventid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'ICT Congress',400,8,'An event...','April 26, 2018','In-Progress',400,NULL),(2,'Paramore',600,0,'Rock all night with Paramore','May 29, 2018','In-Progress',800,NULL),(3,'Concert for a Cause',200,0,'Join and sing along while donating','June 11, 2018','In-Progress',450,NULL),(4,'Deadpool 2',320,0,'Name says it all...','May 16, 2018','In-Progress',220,NULL);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_customers`
--

DROP TABLE IF EXISTS `event_customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_customers` (
  `idevent_customers` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `eventid` int(11) NOT NULL,
  `eventname` varchar(45) NOT NULL,
  PRIMARY KEY (`idevent_customers`),
  KEY `customid_idx` (`customerid`),
  KEY `eventid_idx` (`eventid`),
  CONSTRAINT `customid` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `eventid` FOREIGN KEY (`eventid`) REFERENCES `event` (`eventid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_customers`
--

LOCK TABLES `event_customers` WRITE;
/*!40000 ALTER TABLE `event_customers` DISABLE KEYS */;
INSERT INTO `event_customers` VALUES (1,4,1,'ICT Congress');
/*!40000 ALTER TABLE `event_customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_handler`
--

DROP TABLE IF EXISTS `event_handler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_handler` (
  `eventhandlerid` int(11) NOT NULL AUTO_INCREMENT,
  `handlerusername` varchar(45) NOT NULL,
  `handlerpassword` varchar(45) NOT NULL,
  `eventidhandler` int(11) DEFAULT NULL,
  PRIMARY KEY (`eventhandlerid`),
  KEY `eventidhandler_idx` (`eventidhandler`),
  CONSTRAINT `eventidhandler` FOREIGN KEY (`eventidhandler`) REFERENCES `event` (`eventid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_handler`
--

LOCK TABLES `event_handler` WRITE;
/*!40000 ALTER TABLE `event_handler` DISABLE KEYS */;
INSERT INTO `event_handler` VALUES (1,'admin','admin',NULL);
/*!40000 ALTER TABLE `event_handler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `notifid` int(11) NOT NULL AUTO_INCREMENT,
  `notifMessage` varchar(45) NOT NULL,
  `eventid` int(11) NOT NULL,
  `eventhandlerid` int(11) NOT NULL,
  PRIMARY KEY (`notifid`),
  KEY `eventhandlerid_idx` (`eventhandlerid`),
  CONSTRAINT `eventhandlerid` FOREIGN KEY (`eventhandlerid`) REFERENCES `event_handler` (`eventhandlerid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-21  2:16:50
