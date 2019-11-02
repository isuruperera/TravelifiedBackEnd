-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: tourism_app
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.37-MariaDB

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
-- Table structure for table `chat_group`
--

DROP TABLE IF EXISTS `chat_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat_group` (
  `chat_group_id` int(11) NOT NULL,
  `group_title` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` date NOT NULL,
  PRIMARY KEY (`chat_group_id`),
  KEY `created_by` (`created_by`),
  CONSTRAINT `chat_group_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_group`
--

LOCK TABLES `chat_group` WRITE;
/*!40000 ALTER TABLE `chat_group` DISABLE KEYS */;
INSERT INTO `chat_group` VALUES (1,'title3','B','123456789','2019-08-25'),(2,'title3','B','123456789','2019-08-25'),(3,'title3','D','12345','2019-08-28'),(4,'title4','D','12345','2019-09-03'),(5,'title5','D','12345','2019-09-07'),(6,'title5','D','12345','2019-09-07'),(7,'title3','B','123456789','2019-08-25'),(8,'title5','D','12345','2019-09-07'),(9,'title5','D','12345','2019-09-07'),(12,'title13','D','12345','2019-09-14'),(13,'title13','D','12345','2019-09-14'),(14,'title13','D','12345','2019-09-14'),(15,'title13','D','12345','2019-09-14'),(20,'title13','D','12345','2019-09-14');
/*!40000 ALTER TABLE `chat_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_participation`
--

DROP TABLE IF EXISTS `event_participation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_participation` (
  `participation_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`participation_id`),
  KEY `event_user_idx` (`username`),
  KEY `event_event_idx` (`event_id`),
  CONSTRAINT `event_event` FOREIGN KEY (`event_id`) REFERENCES `tourist_event` (`event_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `event_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_participation`
--

LOCK TABLES `event_participation` WRITE;
/*!40000 ALTER TABLE `event_participation` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_participation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend_list`
--

DROP TABLE IF EXISTS `friend_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend_list` (
  `username` varchar(100) NOT NULL,
  `friendname` varchar(100) NOT NULL,
  PRIMARY KEY (`username`,`friendname`),
  KEY `username` (`friendname`),
  CONSTRAINT `username` FOREIGN KEY (`friendname`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `username_of_friend` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend_list`
--

LOCK TABLES `friend_list` WRITE;
/*!40000 ALTER TABLE `friend_list` DISABLE KEYS */;
INSERT INTO `friend_list` VALUES ('128945','admin1@travelified.com'),('admin1@travelified.com','128945');
/*!40000 ALTER TABLE `friend_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_participant`
--

DROP TABLE IF EXISTS `group_participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_participant` (
  `username` varchar(100) NOT NULL,
  `chat_group_id` int(11) NOT NULL,
  `added_by` varchar(100) DEFAULT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`,`chat_group_id`),
  KEY `added_by` (`added_by`),
  KEY `chat_group_id` (`chat_group_id`),
  CONSTRAINT `group_participant_ibfk_1` FOREIGN KEY (`added_by`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `group_participant_ibfk_2` FOREIGN KEY (`chat_group_id`) REFERENCES `chat_group` (`chat_group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `group_participant_ibfk_3` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_participant`
--

LOCK TABLES `group_participant` WRITE;
/*!40000 ALTER TABLE `group_participant` DISABLE KEYS */;
INSERT INTO `group_participant` VALUES ('10216489463407145',5,'12345',0),('10216489463407145',6,'12345',0),('10216489463407145',8,'12345',0),('10216489463407145',9,'12345',0),('10216489463407145',12,'12345',1),('10216489463407145',13,'12345',0),('10216489463407145',14,'12345',0),('10216489463407145',15,'12345',0),('10216489463407145',20,'12345',0),('12345',3,NULL,1),('12345',4,NULL,1),('12345',5,NULL,1),('12345',6,NULL,1),('12345',8,NULL,1),('12345',9,NULL,1),('12345',12,NULL,1),('12345',13,NULL,1),('12345',14,NULL,1),('12345',15,NULL,1),('12345',20,NULL,1),('123456789',1,NULL,1),('123456789',2,NULL,1),('123456789',5,'12345',0),('123456789',7,NULL,1),('789456123',12,'12345',0),('789456123',13,'12345',0),('789456123',14,'12345',0),('789456123',15,'12345',0),('789456123',20,'12345',0),('admin1@travelified.com',3,'12345',0),('admin1@travelified.com',7,'123456789',0);
/*!40000 ALTER TABLE `group_participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_details`
--

DROP TABLE IF EXISTS `message_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_details` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `chat_group_id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `message` varchar(500) NOT NULL,
  `created_date` date NOT NULL,
  PRIMARY KEY (`message_id`),
  KEY `message_details_ibfk_1` (`username`),
  KEY `message_details_ibfk_2` (`chat_group_id`),
  CONSTRAINT `message_details_ibfk_1` FOREIGN KEY (`username`) REFERENCES `group_participant` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `message_details_ibfk_2` FOREIGN KEY (`chat_group_id`) REFERENCES `group_participant` (`chat_group_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_details`
--

LOCK TABLES `message_details` WRITE;
/*!40000 ALTER TABLE `message_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `message_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_details_guide`
--

DROP TABLE IF EXISTS `message_details_guide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_details_guide` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `message` varchar(500) NOT NULL,
  `created_date` date NOT NULL,
  PRIMARY KEY (`message_id`),
  KEY `service_id` (`service_id`),
  KEY `username` (`username`),
  CONSTRAINT `message_details_guide_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `service_providers` (`service_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `message_details_guide_ibfk_2` FOREIGN KEY (`username`) REFERENCES `service_providers` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_details_guide`
--

LOCK TABLES `message_details_guide` WRITE;
/*!40000 ALTER TABLE `message_details_guide` DISABLE KEYS */;
INSERT INTO `message_details_guide` VALUES (1,2,'10216489463407145','udan','message789456123','2019-09-04'),(2,2,'10216489463407145','udan','message789456123','2019-09-09');
/*!40000 ALTER TABLE `message_details_guide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_providers`
--

DROP TABLE IF EXISTS `service_providers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_providers` (
  `service_id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`service_id`,`username`),
  KEY `username` (`username`),
  CONSTRAINT `service_providers_ibfk_2` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `service_providers_ibfk_3` FOREIGN KEY (`service_id`) REFERENCES `tourist_service` (`service_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_providers`
--

LOCK TABLES `service_providers` WRITE;
/*!40000 ALTER TABLE `service_providers` DISABLE KEYS */;
INSERT INTO `service_providers` VALUES (2,'10216489463407145');
/*!40000 ALTER TABLE `service_providers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_rating_profile`
--

DROP TABLE IF EXISTS `service_rating_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_rating_profile` (
  `profile_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` int(11) DEFAULT NULL,
  `rating` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`profile_id`),
  KEY `service_id` (`service_id`),
  CONSTRAINT `service_rating_profile_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `tourist_service` (`service_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_rating_profile`
--

LOCK TABLES `service_rating_profile` WRITE;
/*!40000 ALTER TABLE `service_rating_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_rating_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_subscription`
--

DROP TABLE IF EXISTS `service_subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_subscription` (
  `subscription_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL,
  `start_timestamp` int(11) DEFAULT NULL,
  `end_timestamp` int(11) DEFAULT NULL,
  `fee` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`subscription_id`),
  KEY `sub_user_user_idx` (`username`),
  KEY `service_id` (`service_id`),
  CONSTRAINT `service_subscription_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `tourist_service` (`service_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sub_user_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_subscription`
--

LOCK TABLES `service_subscription` WRITE;
/*!40000 ALTER TABLE `service_subscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist_attraction`
--

DROP TABLE IF EXISTS `tourist_attraction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tourist_attraction` (
  `attraction_id` int(11) NOT NULL AUTO_INCREMENT,
  `attraction_name` varchar(50) NOT NULL,
  `description` varchar(500) NOT NULL,
  `rating_profile_id` varchar(100) NOT NULL,
  `title_photo_url` varchar(100) NOT NULL,
  `photo_collection_id` varchar(100) NOT NULL,
  `lng` double NOT NULL,
  `lat` double NOT NULL,
  PRIMARY KEY (`attraction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist_attraction`
--

LOCK TABLES `tourist_attraction` WRITE;
/*!40000 ALTER TABLE `tourist_attraction` DISABLE KEYS */;
INSERT INTO `tourist_attraction` VALUES (2,'attractionName5','description5','ratingProfileId5','7cd32bf4-18ae-46ef-84e5-87d6dc7c3ea0','8fdc0182-ee6f-4c93-9c9d-2d428f67e51c',5,5.8),(3,'attractionName8','description8','ratingProfileId8','53b9f1e5-402e-4a07-a6fa-75b57208ceb3','c7d4dc3b-d4ec-4e77-9062-eb5a08615b2e',8,6);
/*!40000 ALTER TABLE `tourist_attraction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist_attraction_photo_collection`
--

DROP TABLE IF EXISTS `tourist_attraction_photo_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tourist_attraction_photo_collection` (
  `photo_collection_id` varchar(100) NOT NULL,
  `photo_url` varchar(100) NOT NULL,
  PRIMARY KEY (`photo_collection_id`,`photo_url`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist_attraction_photo_collection`
--

LOCK TABLES `tourist_attraction_photo_collection` WRITE;
/*!40000 ALTER TABLE `tourist_attraction_photo_collection` DISABLE KEYS */;
/*!40000 ALTER TABLE `tourist_attraction_photo_collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist_event`
--

DROP TABLE IF EXISTS `tourist_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tourist_event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_title` varchar(1000) DEFAULT NULL,
  `event_description` varchar(5000) DEFAULT NULL,
  `location_url` varchar(45) DEFAULT NULL,
  `event_type` varchar(45) DEFAULT NULL,
  `title_photo_url` varchar(500) DEFAULT NULL,
  `photo_collection_id` varchar(100) DEFAULT NULL,
  `rating_profile_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist_event`
--

LOCK TABLES `tourist_event` WRITE;
/*!40000 ALTER TABLE `tourist_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `tourist_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist_service`
--

DROP TABLE IF EXISTS `tourist_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tourist_service` (
  `service_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_title` varchar(100) NOT NULL,
  `service_description` varchar(500) NOT NULL,
  `owner_uname` varchar(100) NOT NULL,
  `title_photo_url` varchar(100) NOT NULL,
  `photo_collection_id` varchar(100) NOT NULL,
  `rating_profile_id` varchar(100) NOT NULL,
  `lng` decimal(10,0) NOT NULL,
  `lat` decimal(10,0) NOT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist_service`
--

LOCK TABLES `tourist_service` WRITE;
/*!40000 ALTER TABLE `tourist_service` DISABLE KEYS */;
INSERT INTO `tourist_service` VALUES (1,'serviceTitle2','serviceDescription2','ownername2','44eef65b-6d56-4bc8-9ef7-22713ace4dcb','45763cd5-1aac-4a7d-babf-8d29b5c9557e','1',0,0),(2,'serviceTitle2','serviceDescription2','ownername2','e16ed24e-557f-4eb7-8c19-456f831863a1','7288fcfa-749f-4c32-873d-263751583173','1',0,0),(3,'serviceTitle1234','serviceDescription1234','ownername1234','9c0cc5b6-9107-4e4f-ba58-71c07d04a7a9','c7daa8d2-93ad-4fb1-913d-9a5f73fb4ef9','1',0,0),(4,'serviceTitle1234','serviceDescription1234','ownername1234','748d1080-8b12-4861-b014-2f614c85c70a','db9a60e5-16f9-4ad5-bc6d-36fb8b8f99c4','1',5,6),(5,'serviceTitle1234','serviceDescription1234','ownername1234','06dbff49-9869-405c-92ca-18398baddaf8','cb03cff0-d1c5-4e1f-82ed-e270f035f4e8','1',5,6),(6,'serviceTitle1234','serviceDescription1234','ownername1234','0979672f-ab48-4973-b9d3-20f73e45892f','c41f2f93-30a1-4799-afcb-2e69a380973c','1',6,8),(7,'serviceTitle1234','serviceDescription1234','ownername1234','f14cf7f9-82bc-49e4-ae3c-2566a0422950','21fc54fb-6bc7-4ad2-b3ce-c22c8caf67fa','1',6,8),(8,'serviceTitle1234','serviceDescription1234','ownername1234','1399c28c-1d3e-4455-9df4-6b56f3369d0b','13a5251d-fe5e-4c57-99f1-9447392d6a70','1',5,6);
/*!40000 ALTER TABLE `tourist_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist_service_photo_collection`
--

DROP TABLE IF EXISTS `tourist_service_photo_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tourist_service_photo_collection` (
  `photo_collection_id` varchar(100) NOT NULL,
  `photo_url` varchar(100) NOT NULL,
  PRIMARY KEY (`photo_collection_id`,`photo_url`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist_service_photo_collection`
--

LOCK TABLES `tourist_service_photo_collection` WRITE;
/*!40000 ALTER TABLE `tourist_service_photo_collection` DISABLE KEYS */;
INSERT INTO `tourist_service_photo_collection` VALUES ('13a5251d-fe5e-4c57-99f1-9447392d6a70','2724854b-173b-4f01-8e1e-4da3dc484896'),('13a5251d-fe5e-4c57-99f1-9447392d6a70','39c9dbfe-2ff6-4750-9fcc-a79ba20ac202');
/*!40000 ALTER TABLE `tourist_service_photo_collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist_transport`
--

DROP TABLE IF EXISTS `tourist_transport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tourist_transport` (
  `service_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_title` varchar(1000) DEFAULT NULL,
  `from_url` varchar(500) DEFAULT NULL,
  `to_url` varchar(500) DEFAULT NULL,
  `per_km_fee` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist_transport`
--

LOCK TABLES `tourist_transport` WRITE;
/*!40000 ALTER TABLE `tourist_transport` DISABLE KEYS */;
/*!40000 ALTER TABLE `tourist_transport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport_subscription`
--

DROP TABLE IF EXISTS `transport_subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transport_subscription` (
  `subscription_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` int(11) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `from_url` varchar(500) DEFAULT NULL,
  `to_url` varchar(500) DEFAULT NULL,
  `fee` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`subscription_id`),
  KEY `sub_transport_service_idx` (`service_id`),
  KEY `transport_user_idx` (`username`),
  CONSTRAINT `sub_transport_service` FOREIGN KEY (`service_id`) REFERENCES `tourist_transport` (`service_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transport_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport_subscription`
--

LOCK TABLES `transport_subscription` WRITE;
/*!40000 ALTER TABLE `transport_subscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `transport_subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(100) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `country` varchar(45) NOT NULL,
  `contact_number` varchar(45) NOT NULL,
  `pwd_salt` varchar(500) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `picture_link` varchar(150) DEFAULT NULL,
  `location_id` varchar(45) DEFAULT NULL,
  `is_admin` int(11) DEFAULT NULL,
  `is_active` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('10216489463407145','udan','isuranga','male','Sri lanka','0761237895','pwd_salt_udan','password_udan','picture_link udan','location id 1',NULL,1),('12345','kasun','sachintha','male','Sri lanka','07108932454','pwdSalt_kasun','password_kasun','pictureLnk_kasun','locationId_kasun',1,1),('123456789','janaka','sandaruwan','male','Sri lanka','0758932154','pwdSalt_janaka','password_janaka','pictureLnk_janaka','locationId_janaka',NULL,1),('128945','sandaru','sachintha','male','Sri lanka','07108932454','pwdSalt_sandaru','password_sandaru','pictureLnk_sandaru','locationId_sandaru',NULL,1),('789456123','dilan','sachintha','male','Sri lanka','0718932454','pwdSalt_dilan','password_dilan','pictureLnk_dilan','locationId_dilan',NULL,1),('admin1@travelified.com','Senali','Devindi','Female','Sri Lanka','0777123456','8a415ddf','31a5745564c4ee1cc003abbfa021987e1446faf9cdb7f21a1938f56fa70c7044','17becd8e-1466-4d97-89c1-756bfa0f71b5','40926730-5d5f-4dc5-a3fa-e7ca12a947aa',1,1),('user1@travelified.com','Senali','Devindi','Female','Sri Lanka','0777123456','b34ebeac','67773f197dfd5229775942ead3b64a7d73e1c11102fdbe582d0c3b555c5b4edd','96d99648-75df-4ef7-8025-57cd0e4a666b','fc3d523a-b6c4-4f7b-af23-d17bc42ce6ea',NULL,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_rating_profile`
--

DROP TABLE IF EXISTS `user_rating_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_rating_profile` (
  `rating_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `rated_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`rating_id`),
  KEY `rating_user_idx` (`username`),
  CONSTRAINT `rated_by_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rating_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_rating_profile`
--

LOCK TABLES `user_rating_profile` WRITE;
/*!40000 ALTER TABLE `user_rating_profile` DISABLE KEYS */;
INSERT INTO `user_rating_profile` VALUES (2,'10216489463407145','A',3,NULL),(3,'10216489463407145','B',2,NULL),(4,'10216489463407145','A',5,NULL),(5,'10216489463407145','C',3,NULL),(6,'10216489463407145','B',2,NULL),(7,'10216489463407145','A',4,NULL),(8,'10216489463407145','B',5,NULL),(9,'10216489463407145','B',5,NULL),(10,'10216489463407145','B',5,NULL),(11,'10216489463407145','D',2,'10216489463407145'),(12,'10216489463407145','New',3,'10216489463407145'),(13,'10216489463407145','New',5,'10216489463407145'),(14,'10216489463407145','D',1,'10216489463407145'),(15,'10216489463407145','D',1,'10216489463407145'),(16,'10216489463407145','Killer',3,'10216489463407145'),(17,'10216489463407145','Matta',2,'10216489463407145'),(18,'789456123','A',4,NULL),(19,'123456789','B',3,NULL),(20,'789456123','B',2,NULL),(21,'789456123','C',5,NULL),(22,'789456123','New',2,NULL),(23,'123456789','C',5,NULL),(24,'123456789','D',1,NULL),(25,'123456789','New',5,NULL),(26,'12345','A',2,NULL),(27,'12345','A',3,NULL),(28,'12345','A',1,NULL),(31,'128945','A',2,NULL);
/*!40000 ALTER TABLE `user_rating_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tourism_app'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-02 18:45:07
