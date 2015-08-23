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
-- Table structure for `zy_contact`
-- ----------------------------
DROP TABLE IF EXISTS `zy_contact`;
CREATE TABLE `zy_contact` (
  `mobile` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `usertype` int(2) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `contactId` int(8) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`contactId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_contact
-- ----------------------------
INSERT INTO `zy_contact` VALUES ('222', null, null, '222', '1');
INSERT INTO `zy_contact` VALUES ('12132312', '2012-05-27 00:25:14', null, '222222', '4');
INSERT INTO `zy_contact` VALUES ('23232332', null, null, '232', '5');
INSERT INTO `zy_contact` VALUES ('34534534', '2012-05-27 00:37:14', null, 'wewer', '6');
