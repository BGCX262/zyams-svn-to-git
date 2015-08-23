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

/*Table structure for table `zy_corporation_product` */

DROP TABLE IF EXISTS `zy_corporation_product`;

CREATE TABLE `zy_corporation_product` (
  `RowID` int(11) NOT NULL AUTO_INCREMENT,
  `CorportationID` varchar(20) CHARACTER SET utf8 NOT NULL,
  `productID` varchar(3) CHARACTER SET utf8 NOT NULL,
  `S01` decimal(30,0) DEFAULT '0',
  `V01` decimal(30,0) DEFAULT '0',
  `activation` varchar(1) CHARACTER SET utf8 DEFAULT '1',
  PRIMARY KEY (`RowID`)
) ENGINE=InnoDB AUTO_INCREMENT=1353 DEFAULT CHARSET=latin1;

/*Data for the table `zy_corporation_product` */

insert  into `zy_corporation_product`(`RowID`,`CorportationID`,`productID`,`S01`,`V01`,`activation`) values (936,'P03069','025','0','0','1'),(938,'J01001','024','0','0','1'),(940,'G09002','021','0','0','1'),(943,'E06002','015','0','0','1'),(944,'D06004','012','0','0','1'),(945,'F05002','022','0','0','1'),(946,'D03021','124','0','0','1'),(947,'G05004','025','0','0','1'),(948,'F06001','010','0','0','1'),(950,'F08003','022','0','0','1'),(951,'E06001','011','0','0','1'),(952,'G08001','019','0','0','1'),(953,'G08001','020','0','0','1'),(954,'I05004','023','0','0','1'),(955,'J08003','018','0','0','1'),(956,'K05004','001','0','0','1'),(957,'K05004','018','0','0','1'),(960,'03156','008','0','0','1'),(961,'01006','018','0','0','1'),(964,'10113','023','0','0','1'),(965,'G03033','124','0','0','1'),(967,'B70001','001','0','0','1'),(968,'B70001','002','0','0','1'),(973,'06010','004','0','0','1'),(979,'B70001','003','0','0','1'),(980,'B70001','004','0','0','1'),(1096,'K11111','024','0','0','1'),(1112,'D06001','009','0','0','1'),(1115,'A06009','011','0','0','1'),(1116,'F06002','015','0','0','1'),(1117,'M06001','010','0','0','1'),(1118,'G05002','022','0','0','1'),(1121,'H09002','021','0','0','1'),(1132,'I05006','014','0','0','1'),(1143,'A07002','001','0','0','1'),(1145,'K11112','018','0','0','1'),(1149,'G08003','022','0','0','1'),(1151,'z09001','124','0','0','1'),(1152,'z09002','015','0','0','1'),(1155,'D02005','124','0','0','1'),(1167,'A09003','002','0','0','1'),(1168,'A09003','003','0','0','1'),(1169,'A09003','004','0','0','1'),(1179,'dlsp','024','0','0','1'),(1181,'E03004','','0','0','1'),(1182,'L05002','029','0','0','1'),(1183,'L05002','','0','0','1'),(1193,'F05004','034','0','0','1'),(1195,'kdjd','052','0','0','1'),(1197,'B05001','005','0','0','1'),(1198,'B05001','006','0','0','1'),(1199,'B05001','032','0','0','1'),(1231,'E01076','','0','0','1'),(1232,'E01076','','0','0','1'),(1233,'E01076','','0','0','1'),(1234,'E01076','','0','0','1'),(1235,'E01076','','0','0','1'),(1236,'E01076','','0','0','1'),(1237,'E01076','','0','0','1'),(1238,'E01076','','0','0','1'),(1239,'E01076','','0','0','1'),(1240,'B03005','','0','0','1'),(1241,'B03005','','0','0','1'),(1242,'B03005','','0','0','1'),(1243,'B03005','','0','0','1'),(1244,'B03005','','0','0','1'),(1245,'B03005','','0','0','1'),(1246,'B03005','','0','0','1'),(1247,'B03005','','0','0','1'),(1248,'B03005','','0','0','1'),(1249,'H05004','025','0','0','1'),(1250,'H05004','','0','0','1'),(1251,'H05004','','0','0','1'),(1252,'H05004','','0','0','1'),(1253,'H05004','','0','0','1'),(1254,'H05004','','0','0','1'),(1255,'H05004','','0','0','1'),(1256,'H05004','','0','0','1'),(1257,'H05004','','0','0','1'),(1258,'H05004','','0','0','1'),(1279,'D01075','012','0','0','1'),(1280,'D01075','013','0','0','1'),(1283,'rsgm','060','0','0','1'),(1284,'rsgm','','0','0','1'),(1285,'rsgm','','0','0','1'),(1286,'rsgm','','0','0','1'),(1287,'rsgm','','0','0','1'),(1288,'rsgm','','0','0','1'),(1289,'rsgm','','0','0','1'),(1290,'rsgm','','0','0','1'),(1291,'rsgm','','0','0','1'),(1292,'A06010','031','0','0','1'),(1293,'A06010','','0','0','1'),(1294,'A06010','','0','0','1'),(1295,'A06010','','0','0','1'),(1296,'A06010','','0','0','1'),(1297,'A06010','','0','0','1'),(1298,'A06010','','0','0','1'),(1299,'A06010','','0','0','1'),(1300,'A06010','','0','0','1'),(1303,'E09002','030','0','0','1'),(1304,'E09002','126','0','0','1'),(1306,'I06002','014','0','0','1'),(1307,'H08001','019','0','0','1'),(1308,'H08001','020','0','0','1'),(1309,'K01001','024','0','0','1'),(1310,'J10113','023','0','0','1'),(1312,'D06003','008','0','0','1'),(1313,'JTJX','128','0','0','1'),(1314,'JTJX','127','0','0','1'),(1320,'A07001','002','0','0','1'),(1321,'A07001','003','0','0','1'),(1322,'A07001','004','0','0','1'),(1324,'F03005','175','0','0','1'),(1331,'K05003','024','0','0','1'),(1335,'B05002','050','0','0','1'),(1337,'ztwz','017','0','0','1'),(1338,'ztwz','150','0','0','1'),(1339,'rjsn','017','0','0','1'),(1340,'J10111','023','0','0','1'),(1341,'K01002','024','0','0','1'),(1342,'J05004','023','0','0','1'),(1343,'D09002','035','0','0','1'),(1344,'L05001','029','0','0','1'),(1345,'C05003','017','0','0','1'),(1346,'C05005','017','0','0','1'),(1347,'C05005','029','0','0','1'),(1349,'F03030','015','0','0','1'),(1350,'C08001','016','0','0','1'),(1351,'A03008','001','0','0','1'),(1352,'mxgn','1','0','0','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
