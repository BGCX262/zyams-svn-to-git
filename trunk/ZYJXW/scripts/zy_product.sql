/*
Navicat MySQL Data Transfer

Source Server         : nst
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : zy_jxw

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2012-04-26 16:37:02
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `zy_product`
-- ----------------------------
DROP TABLE IF EXISTS `zy_product`;
CREATE TABLE `zy_product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `productID` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `product_name` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `unit` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `orderno` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of zy_product
-- ----------------------------
INSERT INTO `zy_product` VALUES ('1', '001', '成品矿', '吨', '0');
INSERT INTO `zy_product` VALUES ('2', '002', '生铁', '吨', '0');
INSERT INTO `zy_product` VALUES ('3', '003', '钢', '吨', '0');
INSERT INTO `zy_product` VALUES ('4', '004', '钢材', '吨', '0');
INSERT INTO `zy_product` VALUES ('5', '005', '散装水泥车', '辆', '0');
INSERT INTO `zy_product` VALUES ('6', '006', '混凝土搅拌车', '辆', '0');
INSERT INTO `zy_product` VALUES ('8', '008', '柠檬酸', '吨', '0');
INSERT INTO `zy_product` VALUES ('9', '009', '碳黑', '吨', '0');
INSERT INTO `zy_product` VALUES ('10', '010', '漆包线', '吨', '0');
INSERT INTO `zy_product` VALUES ('11', '011', '球铁管', '吨', '0');
INSERT INTO `zy_product` VALUES ('12', '012', '硫酸(100%)', '吨', '0');
INSERT INTO `zy_product` VALUES ('13', '013', '钛白粉', '吨', '0');
INSERT INTO `zy_product` VALUES ('14', '014', '回转支承', '套', '0');
INSERT INTO `zy_product` VALUES ('15', '015', '钢绞线', '吨', '0');
INSERT INTO `zy_product` VALUES ('16', '016', '机制纸板', '吨', '0');
INSERT INTO `zy_product` VALUES ('17', '017', '水泥', '吨', '0');
INSERT INTO `zy_product` VALUES ('18', '018', '啤酒', '千升', '0');
INSERT INTO `zy_product` VALUES ('19', '19', '纱', '吨', '0是说谁');
INSERT INTO `zy_product` VALUES ('20', '020', '布', '万米', '0');
INSERT INTO `zy_product` VALUES ('21', '021', '毛巾', '万条', '0');
INSERT INTO `zy_product` VALUES ('22', '022', '磁粉', '吨', '0');
INSERT INTO `zy_product` VALUES ('23', '023', '金属切削机床', '台', '0');
INSERT INTO `zy_product` VALUES ('24', '024', '食品', '吨', '0');
INSERT INTO `zy_product` VALUES ('25', '025', '服装', '万件', '0');
INSERT INTO `zy_product` VALUES ('26', '124', '油漆', '吨', '0');
INSERT INTO `zy_product` VALUES ('27', '026', '铸铁管道', '吨', '0');
INSERT INTO `zy_product` VALUES ('28', '29', '商品混凝土', '立方米', '1');
INSERT INTO `zy_product` VALUES ('30', '030', '吡啶', '吨', null);
INSERT INTO `zy_product` VALUES ('31', '031', '角钢', '吨', null);
INSERT INTO `zy_product` VALUES ('32', '032', '泵车', '辆', null);
INSERT INTO `zy_product` VALUES ('33', '033', '新闻纸', '吨', null);
INSERT INTO `zy_product` VALUES ('34', '034', '钢筋焊网', '吨', null);
INSERT INTO `zy_product` VALUES ('35', '035', '生态肥', '吨', null);
INSERT INTO `zy_product` VALUES ('41', '052', '生产线成套装置', '套', null);
INSERT INTO `zy_product` VALUES ('42', '050', '汽车底盘', '辆', null);
INSERT INTO `zy_product` VALUES ('43', '060', '橡胶传动带', '万米', null);
INSERT INTO `zy_product` VALUES ('55', '126', '双甘膦', '吨', null);
INSERT INTO `zy_product` VALUES ('56', '128', '脂肪醇聚氧乙烯醚硫酸盐（AES）', '吨', null);
INSERT INTO `zy_product` VALUES ('57', '127', '磺酸（LAS）', '吨', null);
INSERT INTO `zy_product` VALUES ('58', '175', '挖掘机', '台', null);
INSERT INTO `zy_product` VALUES ('63', '073', '草甘膦', '吨', null);
INSERT INTO `zy_product` VALUES ('64', '150', '商品熟料', '吨', null);
