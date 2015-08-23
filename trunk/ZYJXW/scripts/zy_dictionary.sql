/*
SQLyog Ultimate v9.51 
MySQL - 5.5.13 : Database - zy_jxw
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zy_jxw` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zy_jxw`;

/*Table structure for table `zy_dictionary` */

DROP TABLE IF EXISTS `zy_dictionary`;

CREATE TABLE `zy_dictionary` (
  `DictID` varchar(50) DEFAULT NULL,
  `Code` int(2) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Flag` int(4) DEFAULT NULL,
  `Remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `zy_dictionary` */

insert  into `zy_dictionary`(`DictID`,`Code`,`Name`,`Flag`,`Remarks`) values ('101',1,'主任',0,NULL),('101',2,'科员',0,NULL),('101',3,'科长',0,NULL),('102',4,'雨山区',0,NULL),('102',5,'花山区',0,NULL),('102',6,'金家庄区',0,NULL),('102',7,'当涂县',0,NULL),('102',8,'市开发区',0,NULL),('102',9,'慈湖工业园',0,NULL),('102',10,'当涂工业园',0,NULL),('102',11,'市属',0,NULL),('102',12,'其他重点企业',0,NULL),('102',13,'含山县',0,NULL),('102',14,'和县',0,NULL),('102',15,'博望新区',0,NULL),('102',16,'示范园区',0,NULL),('103',17,'卖方企业',2,NULL),('103',18,'买方企业',2,NULL),('103',19,'代理企业',2,NULL),('103',20,'邀请合作',2,NULL),('104',21,'其它有限责任公司',0,NULL),('104',22,'有限责任公司',0,NULL),('107',23,'市属经济',0,'0'),('107',24,'马钢',0,NULL),('107',25,'县区经济',0,NULL),('108',26,'黑色金属冶炼及压延加工业',0,NULL),('108',27,'交通运输设备制造业',0,NULL),('108',28,'食品制造业',0,NULL),('108',29,'化学原料及化学制品制造业',0,NULL),('108',30,'化学原料及化学制品制造业',0,NULL),('108',31,'生物化学及医药制造业',0,NULL),('108',32,'通用及专用设备制造业',0,NULL),('108',33,'电气机械及器材制造行业',0,NULL),('108',34,'非金属矿物制品业',0,NULL),('108',35,'金属制品业',0,NULL),('108',36,'建材行业',0,NULL),('108',37,'光伏行业',0,NULL),('108',38,'其它行业',0,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
