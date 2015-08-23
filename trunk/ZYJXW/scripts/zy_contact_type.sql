/*
Navicat MySQL Data Transfer

Source Server         : zy_jxw
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : zy_jxw

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2012-05-27 01:10:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `zy_contact_type`
-- ----------------------------
DROP TABLE IF EXISTS `zy_contact_type`;
CREATE TABLE `zy_contact_type` (
  `reserved` varchar(50) DEFAULT NULL,
  `type_name` varchar(20) NOT NULL,
  `typeId` int(2) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_contact_type
-- ----------------------------
INSERT INTO `zy_contact_type` VALUES (null, 'wewe', '1');
INSERT INTO `zy_contact_type` VALUES (null, '4334', '2');
INSERT INTO `zy_contact_type` VALUES (null, '2332', '3');
