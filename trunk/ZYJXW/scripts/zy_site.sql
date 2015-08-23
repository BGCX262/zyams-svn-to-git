/*
Navicat MySQL Data Transfer

Source Server         : nst
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : zy_jxw

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2012-04-26 13:03:00
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `zy_site`
-- ----------------------------
DROP TABLE IF EXISTS `zy_site`;
CREATE TABLE `zy_site` (
  `view_time` datetime DEFAULT NULL,
  `ip` varchar(20) NOT NULL,
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_site
-- ----------------------------
INSERT INTO `zy_site` VALUES ('2012-04-26 12:58:31', '127.0.0.1', '6');
