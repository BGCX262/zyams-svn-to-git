/*
Navicat MySQL Data Transfer

Source Server         : zy_jxw
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : zy_jxw

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2012-04-27 01:04:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `zy_msg`
-- ----------------------------
DROP TABLE IF EXISTS `zy_msg`;
CREATE TABLE `zy_msg` (
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(50) NOT NULL,
  `content` text,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `msgId` bigint(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`msgId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_msg
-- ----------------------------
INSERT INTO `zy_msg` VALUES ('0', 'sdsdsdsdsd', 'ggggeeeeeeeeeeeeeesdsdsddsds', 'gg', 'gg222', '1', '2012-04-26 22:38:25', '3');
INSERT INTO `zy_msg` VALUES ('0', 'wwwwwwwwwwwwwww', 'wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww', 'wwwwwwwwwwwwww', 'wwwwwwww', '0', '2012-04-26 22:45:02', '4');
INSERT INTO `zy_msg` VALUES ('0', 'dsffds', 'sdfgdsfgdfsgdf', 'sdfg', 'gdsfgdsf', '0', '2012-04-27 00:08:29', '8');
INSERT INTO `zy_msg` VALUES ('3', 'saadsdsa', 'sdfasdfsadfsad', 'sdaf', 'sadfsadasdsadfasd', '0', '2012-04-27 00:47:24', '9');
INSERT INTO `zy_msg` VALUES ('0', 'ssas', 'asdfsd', 'sdfs', 'sdfsa', '0', '2012-04-27 00:47:56', '10');
INSERT INTO `zy_msg` VALUES ('10', 'dsdffd', 'dsfsdfsdfsdf', 'dsffdssdf', 'sdfdfssdf', '0', '2012-04-27 00:51:55', '11');
INSERT INTO `zy_msg` VALUES ('0', 'dddaaa', 'aaaaa', 'aa', 'aaa', '0', '2012-04-27 00:55:55', '12');
INSERT INTO `zy_msg` VALUES ('17', 'sssd', 'ssdsdsd', '', 'sss', '0', '2012-04-27 00:56:28', '13');
