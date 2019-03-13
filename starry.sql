/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.51 : Database - starry
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`starry` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `starry`;

/*Table structure for table `test_tab` */

DROP TABLE IF EXISTS `test_tab`;

CREATE TABLE `test_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `test_tab` */

insert  into `test_tab`(`id`,`name`,`age`) values (1,'张三',22),(2,'李四',10);

/*Table structure for table `user_tab` */

DROP TABLE IF EXISTS `user_tab`;

CREATE TABLE `user_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(15) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `habit` varchar(30) DEFAULT NULL,
  `birthday` varchar(35) DEFAULT NULL,
  `job` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `weigh` varchar(20) DEFAULT NULL,
  `height` varchar(20) DEFAULT NULL,
  `xingZuo` varchar(20) DEFAULT NULL,
  `signature` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `user_tab` */

insert  into `user_tab`(`id`,`phone`,`password`,`nickname`,`name`,`gender`,`age`,`habit`,`birthday`,`job`,`address`,`weigh`,`height`,`xingZuo`,`signature`) values (5,'18219111626','123456','666@co.com','wunaifu',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'18219111625','123456',NULL,'wunaifu',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'18219111624','123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'18219111623','123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'18219111622','dfg','6662@2.c','wunaifu',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'18219111621','123456','张三','wunaifu',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'18219111620','123456','666','wunaifu',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'18219111619','123456','666','张三',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,'18219111630','123456','666','555',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,'18219111631','123456','666@co.com','wunaifu',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,'18219111632','123456','6662@2.c','wunaifu',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,'18219111633','123456','666@co.com','wunaifu',0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `users_tab` */

DROP TABLE IF EXISTS `users_tab`;

CREATE TABLE `users_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `users_tab` */

insert  into `users_tab`(`id`,`firstname`,`lastname`,`phone`,`email`) values (3,'fname1','lname1','(000)000-0000','name1@gmail.com'),(4,'fname2','lname2','(000)000-0000','name2@gmail.com'),(5,'fname3','lname3','(000)000-0000','name3@gmail.com'),(7,'fname4','lname4','(000)000-0000','name4@gmail.com'),(8,'fname5','lname5','(000)000-0000','name5@gmail.com'),(9,'fname6','lname6','(000)000-0000','name6@gmail.com'),(10,'fname7','lname7','(000)000-0000','name7@gmail.com'),(11,'fname8','lname8','(000)000-0000','name8@gmail.com'),(12,'fname9','lname9','(000)000-0000','name9@gmail.com'),(13,'fname10','lname10','(000)000-0000','name10@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
