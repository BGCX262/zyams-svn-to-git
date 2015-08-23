/*
Navicat MySQL Data Transfer

Source Server         : zy_jxw
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : zy_jxw

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2012-05-27 01:10:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `zy_contact_and_type`
-- ----------------------------
DROP TABLE IF EXISTS `zy_contact_and_type`;
CREATE TABLE `zy_contact_and_type` (
  `type_id` int(4) DEFAULT NULL,
  `contact_id` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_contact_and_type
-- ----------------------------
INSERT INTO `zy_contact_and_type` VALUES ('1', '5');
INSERT INTO `zy_contact_and_type` VALUES ('2', '5');
INSERT INTO `zy_contact_and_type` VALUES ('2', '1');
INSERT INTO `zy_contact_and_type` VALUES ('3', '1');
INSERT INTO `zy_contact_and_type` VALUES ('1', '6');
INSERT INTO `zy_contact_and_type` VALUES ('3', '6');
