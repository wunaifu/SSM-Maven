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

/*Table structure for table `user_tab` */

DROP TABLE IF EXISTS `user_tab`;

CREATE TABLE `user_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(15) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_tab` */

insert  into `user_tab`(`id`,`phone`,`password`,`nickname`,`name`,`gender`,`age`,`habit`,`birthday`,`job`,`address`,`weigh`,`height`,`xingZuo`,`signature`) values (1,'1','1','1','1',1,1,'1','1','1','1','1','1','1','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
