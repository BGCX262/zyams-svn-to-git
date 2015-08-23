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

/*Table structure for table `zy_corporation` */

DROP TABLE IF EXISTS `zy_corporation`;

CREATE TABLE `zy_corporation` (
  `RowID` int(4) NOT NULL AUTO_INCREMENT,
  `ID` varchar(20) NOT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `areaID` varchar(2) DEFAULT NULL,
  `tradeID` varchar(2) DEFAULT NULL,
  `activation` varchar(1) DEFAULT NULL,
  `IS50` varchar(60) DEFAULT NULL,
  `IS100` varchar(60) DEFAULT NULL,
  `orderno` varchar(20) DEFAULT NULL,
  `IsNew` varchar(50) DEFAULT NULL,
  `Area` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `TaxNumber` varchar(50) DEFAULT NULL,
  `WorkerName` varchar(50) DEFAULT NULL,
  `Tel` varchar(50) DEFAULT NULL,
  `Mobile` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Postcode` varchar(50) DEFAULT NULL,
  `Faxes` varchar(50) DEFAULT NULL,
  `Infor` varchar(1000) DEFAULT NULL,
  `Remark` varchar(10000) DEFAULT NULL,
  `WebUrl` varchar(200) DEFAULT NULL,
  `ByOrder` int(4) DEFAULT NULL,
  `Bak1` varchar(50) DEFAULT NULL,
  `Bak2` varchar(50) DEFAULT NULL,
  `Bak3` varchar(50) DEFAULT NULL,
  `Bak4` int(4) DEFAULT NULL,
  `Bak5` int(4) DEFAULT NULL,
  `Bak6` int(4) DEFAULT NULL,
  PRIMARY KEY (`RowID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `zy_corporation` */

insert  into `zy_corporation`(`RowID`,`ID`,`Password`,`name`,`areaID`,`tradeID`,`activation`,`IS50`,`IS100`,`orderno`,`IsNew`,`Area`,`Address`,`TaxNumber`,`WorkerName`,`Tel`,`Mobile`,`Email`,`Postcode`,`Faxes`,`Infor`,`Remark`,`WebUrl`,`ByOrder`,`Bak1`,`Bak2`,`Bak3`,`Bak4`,`Bak5`,`Bak6`) values (1,'A07001','340860342742','马鞍山钢铁股份有限公司','4','38','1','是','否','001','是','其他重点企业',NULL,NULL,'1','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `zy_corporation_product` */

DROP TABLE IF EXISTS `zy_corporation_product`;

CREATE TABLE `zy_corporation_product` (
  `RowID` int(4) NOT NULL AUTO_INCREMENT,
  `corporationID` varchar(20) NOT NULL,
  `productID` varchar(3) NOT NULL,
  `S01` decimal(13,0) DEFAULT NULL,
  `V01` decimal(13,0) DEFAULT NULL,
  `activation` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`RowID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `zy_corporation_product` */

insert  into `zy_corporation_product`(`RowID`,`corporationID`,`productID`,`S01`,`V01`,`activation`) values (1,'A07001','002','0','0','1');

/*Table structure for table `zy_dictclass` */

DROP TABLE IF EXISTS `zy_dictclass`;

CREATE TABLE `zy_dictclass` (
  `DictID` varchar(3) NOT NULL,
  `DictName` varchar(50) NOT NULL,
  `Visible` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`DictID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zy_dictclass` */

insert  into `zy_dictclass`(`DictID`,`DictName`,`Visible`) values ('101','公司职务','1'),('102','企业区域','1'),('103','注册类型','1'),('104','企业类型','1'),('105','投诉类型','1'),('106','性别类型','1'),('107','地区管理','1'),('108','行业管理','1');

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

/*Table structure for table `zy_product` */

DROP TABLE IF EXISTS `zy_product`;

CREATE TABLE `zy_product` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `productID` bigint(20) DEFAULT NULL COMMENT '产品ID',
  `product_name` varchar(40) DEFAULT NULL COMMENT '产品名称',
  `unit` varchar(10) DEFAULT NULL COMMENT '产品单位',
  `orderno` varchar(40) DEFAULT NULL COMMENT '订单号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `zy_product` */

insert  into `zy_product`(`ID`,`productID`,`product_name`,`unit`,`orderno`) values (9,1,'1','1','1'),(10,2,'Test2','斤','2'),(11,3,'test我','吨','3');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
