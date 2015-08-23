/*
Navicat MySQL Data Transfer

Source Server         : zy_jxw
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : zy_jxw

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2012-05-14 23:52:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `zy_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `zy_dictionary`;
CREATE TABLE `zy_dictionary` (
  `DictID` varchar(50) DEFAULT NULL,
  `Code` int(2) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Flag` int(4) DEFAULT NULL,
  `Remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_dictionary
-- ----------------------------
INSERT INTO `zy_dictionary` VALUES ('101', '1', '主任', '0', null);
INSERT INTO `zy_dictionary` VALUES ('101', '2', '科员', '0', null);
INSERT INTO `zy_dictionary` VALUES ('101', '3', '科长', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '4', '雨山区', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '5', '花山区', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '6', '金家庄区', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '7', '当涂县', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '8', '市开发区', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '9', '慈湖工业园', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '10', '当涂工业园', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '11', '市属', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '12', '其他重点企业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '13', '含山县', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '14', '和县', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '15', '博望新区', '0', null);
INSERT INTO `zy_dictionary` VALUES ('102', '16', '示范园区', '0', null);
INSERT INTO `zy_dictionary` VALUES ('103', '17', '卖方企业', '2', null);
INSERT INTO `zy_dictionary` VALUES ('103', '18', '买方企业', '2', null);
INSERT INTO `zy_dictionary` VALUES ('103', '19', '代理企业', '2', null);
INSERT INTO `zy_dictionary` VALUES ('103', '20', '邀请合作', '2', null);
INSERT INTO `zy_dictionary` VALUES ('104', '21', '其它有限责任公司', '0', null);
INSERT INTO `zy_dictionary` VALUES ('104', '22', '有限责任公司', '0', null);
INSERT INTO `zy_dictionary` VALUES ('107', '23', '市属经济', '0', '0');
INSERT INTO `zy_dictionary` VALUES ('107', '24', '马钢', '0', null);
INSERT INTO `zy_dictionary` VALUES ('107', '25', '县区经济', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '26', '黑色金属冶炼及压延加工业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '27', '交通运输设备制造业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '28', '食品制造业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '29', '化学原料及化学制品制造业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '30', '纺织服装业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '31', '生物化学及医药制造业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '32', '通用及专用设备制造业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '33', '电气机械及器材制造行业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '34', '非金属矿物制品业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '35', '金属制品业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '36', '建材行业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '37', '光伏行业', '0', null);
INSERT INTO `zy_dictionary` VALUES ('108', '38', '其它行业', '0', null);
