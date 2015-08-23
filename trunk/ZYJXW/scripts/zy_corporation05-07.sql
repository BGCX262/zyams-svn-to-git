/*
Navicat MySQL Data Transfer

Source Server         : nst
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : zy_jxw

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2012-05-07 12:18:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `zy_corporation`
-- ----------------------------
DROP TABLE IF EXISTS `zy_corporation`;
CREATE TABLE `zy_corporation` (
  `RowID` int(11) NOT NULL AUTO_INCREMENT,
  `ID` varchar(20) CHARACTER SET utf8 NOT NULL,
  `Password` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `NAME` varchar(100) CHARACTER SET utf8 NOT NULL,
  `AREAID` varchar(2) CHARACTER SET utf8 DEFAULT NULL,
  `TRADEID` varchar(2) CHARACTER SET utf8 DEFAULT NULL,
  `ACTIVATION` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `IS50` varchar(60) CHARACTER SET utf8 DEFAULT NULL,
  `IS100` varchar(60) CHARACTER SET utf8 DEFAULT NULL,
  `ORDERNO` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `IsNew` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Area` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Address` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `TaxNumber` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `WorkerName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Tel` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Mobile` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Postcode` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Faxes` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Infor` text CHARACTER SET utf8,
  `Remark` text CHARACTER SET utf8,
  `WebUrl` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `ByOrder` int(11) DEFAULT '0',
  `Bak1` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Bak2` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Bak3` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Bak4` int(11) DEFAULT NULL,
  `Bak5` int(11) DEFAULT NULL,
  `Bak6` int(11) DEFAULT NULL,
  PRIMARY KEY (`RowID`)
) ENGINE=InnoDB AUTO_INCREMENT=298 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of zy_corporation
-- ----------------------------
INSERT INTO `zy_corporation` VALUES ('142', 'A07001', '340860342742', '马鞍山钢铁股份有限公司', '24', '26', '1', '是', '否', '001', '是', '其他重点企业', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('143', 'A07002', '482584', '马钢(集团)控股有限公司', '24', '26', '1', '是', '否', '003', '是', '其他重点企业', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('144', 'A09003', '0', '安徽长江钢铁股份有限公司', '25', '26', '1', '是', '否', '005', '是', '当涂县', '', '', '1', '1', '', '', '', '', '', '', '', '100', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('145', 'B05001', '3038', '安徽星马汽车股份公司', '23', '27', '1', '是', '否', '007', '是', '开发区', '', '', '1', '1', '', '', '', '', '', '', '', '30', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('146', 'B05002', '941515', '安徽华菱汽车有限公司', '23', '27', '1', '是', '否', '011', '是', '市开发区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('147', 'C08001', '6301', '安徽山鹰纸业股份有限公司', '25', '38', '1', '是', '否', '009', '是', '金家庄区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('148', 'D06001', '1', '中橡(马鞍山)化学工业有限公司', '23', '29', '1', '是', '是', '013', '是', '慈湖工业园', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('149', 'D09002', '1', '马鞍山科邦生态肥有限公司', '25', '29', '1', '否', '否', '051', '是', '当涂工业园', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('150', 'D06003', '713907286', '马鞍山丰原生物化学有限公司', '23', '31', '1', '是', '是', '031', '是', '慈湖工业园', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('151', 'D02005', '666727', '马鞍山市意尔涂料有限公司', '25', '29', '1', '是', '是', '081', '是', '花山区', '', '', '1', '1', '', '', '', '', '', '', '', '1', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('152', 'A06009', '1', '圣戈班管道系统有限公司', '23', '26', '1', '是', '是', '017', '是', '慈湖工业园', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('153', 'F06002', '726', '奥盛新材料股份有限公司', '23', '35', '1', '是', '是', '025', '是', '慈湖工业园', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('154', 'F04003', '1', '马鞍山市玉龙金属公司', '25', '35', '1', '是', '是', '023', '是', '金家庄区', '', '', '1', '1', '', '', '', '', '', '', '', '100', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('155', 'F05004', '1', '马钢比亚西钢筋焊网有限公司', '23', '35', '1', '是', '是', '043', '是', '市开发区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('156', 'F05005', '1', '马钢和菱实业有限公司', '23', '27', '1', '是', '是', '033', '是', '市开发区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('157', 'F03006', '1', '马鞍山市华科实业有限公司', '25', '35', '1', '否', '是', '059', '是', '雨山区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('158', 'M06001', '123', '格力电工(马鞍山)有限公司', '23', '33', '1', '是', '是', '021', '是', '慈湖工业园', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('159', 'G05002', '737315488', '安徽天源科技股份有限公司', '23', '33', '1', '是', '是', '039', '是', '市开发区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('160', 'G08003', '123456', '市高科磁性材料有限公司', '23', '26', '1', '否', '是', '222', '是', '市开发区', '', '', '范志华', '2480004', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('161', 'G03004', '1', '马鞍山市鑫洋永磁有限公司', '25', '33', '1', '是', '是', '075', '是', '雨山区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('162', 'H08001', '116', '马鞍山市天成纺织有限责任公司', '23', '30', '1', '是', '是', '029', '是', '市属', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('163', 'H09002', '123456', '马鞍山市海狮织造有限公司', '25', '30', '1', '是', '是', '055', '是', '当涂工业园', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('164', 'H01003', '6061118', '马鞍山市金姿装饰品有限公司', '25', '30', '1', '是', '是', '077', '是', '当涂县', '', '', '1', '1', '', '', '', '', '', '', '', '20', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('165', 'E09001', '123', '桂龙药业(安徽)有限公司', '25', '31', '1', '是', '是', '037', '是', '当涂县', '', '', '1', '1', '', '', '', '', '', '', '', '99', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('166', 'I01001', '6144186', '马鞍山市沪马机械设备制造有限公司', '25', '32', '1', '否', '是', '027', '是', '当涂县', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('167', 'I06002', '1', '马鞍山方圆回转支承股份有限公司', '23', '32', '1', '是', '是', '047', '是', '慈湖工业园', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('168', 'I05003', '710720', '安徽泰尔重工股份有限公司', '23', '32', '1', '是', '是', '067', '是', '市开发区', '安徽马鞍山经济技术开发区红旗南路18号', '', '雷海涛', '0555-2215520', '15205558766', 'hyf0712@126.com', '243000', '0555-2229287', '', '', 'www.taier.info', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('169', 'J05004', 'wmjc', '马鞍山万马机床制造有限公司', '23', '32', '1', '否', '是', '085', '是', '市开发区', '', '', '陆俊', '2108172', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('170', 'K01001', '6191318', '马鞍山市黄池食品(集团)公司', '25', '28', '1', '是', '是', '035', '是', '当涂县', '', '', '1', '1', '', '', '', '', '', '', '', '25', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('171', 'K01002', '6740082', '安徽雪润肉食品公司', '25', '28', '1', '否', '是', '069', '是', '当涂县', '姑孰路627号', '', '1', '6731072', '', '', '243100', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('172', 'L05001', '720922', '马钢嘉华商品混凝土有限公司', '23', '36', '1', '是', '是', '041', '是', '市开发区', '', '', '潘菊香', '2106519', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('173', 'L05002', '2108818', '深马建材(马鞍山)有限公司', '23', '34', '1', '否', '是', '065', '是', '市开发区', '', '', '陆佳丽', '2108818', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('174', 'C05004', '123456', '安徽昕源集团有限公司', '23', '38', '1', '是', '是', '063', '是', '市开发区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('175', 'H05004', '1', '马鞍山市天平服装有限公司', '23', '30', '1', '否', '是', '073', '是', '市开发区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('176', 'L03004', '964178', '马鞍山市双诚商品砼有限公司', '25', '26', '1', '否', '是', '061', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('177', 'C05003', '1125', '海螺水泥(马鞍山)有限公司', '23', '36', '1', '是', '否', '019', '是', '花山区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('178', 'D04009', '1', '安徽盾安化工有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('179', 'E05111', '1', '神鹿科瑞药业有限公司', '25', '26', '1', '否', '否', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('180', 'F06111', '0', '安徽华菱西厨装备股份有限公司', '25', '35', '1', '是', '是', '053', '是', '当涂县', '马鞍山市当涂县博望工业开发区', '340521766871838', '陈业敏', '7168559', '13665550169', '', '243131', '6769511', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('181', 'I09111', '2100606', '市双益机械制造有限公司', '25', '32', '1', '否', '是', '093', '是', '雨山区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('182', 'I09112', '13905559695', '市联盟模具机械工业有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('183', 'I09113', '1', '福臻科技发展有限公司', '23', '26', '1', '否', '否', '091', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('184', 'J10111', '9', '安徽省三力机床制造股份有限公司', '25', '32', '1', '否', '是', '087', '是', '当涂工业园', '当涂经济开发区(205国道1338公里处)', '340521704927680', '周爱国', '0555-6612936', '18955509168', 'zhou_love_china@126.com', '243104', '0555-6611238', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('185', 'J10113', '666', '马鞍山市中亚机床制造有限公司', '25', '32', '1', '是', '是', '057', '是', '金家庄区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('186', 'K11111', '7118017', '蒙牛乳业(马鞍山)有限公司', '23', '28', '1', '是', '否', '015', '是', '花山区', '', '', '万凤云', '7118017', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('187', 'K11112', '751125', '青岛啤酒(马鞍山)有限公司', '23', '28', '1', '是', '是', '045', '是', '市属', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('188', 'M13111', '333333', '建威数码(马鞍山)有限公司', '23', '26', '1', '否', '是', '222', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('189', 'M13112', '1', '马鞍山迪嘉特科技发展有限公司', '23', '33', '1', '否', '是', '083', '是', '市开发区', '马鞍山市经济开发区湖西南路256号', '', '刘艳', '2763030', '', 'masdigart@yahoo.com', '', '2763030', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('190', 'A01003', '2811644', '东洋铁球（马鞍山）有限公司', '23', '26', '1', '否', '是', '222', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('191', 'A03004', '1', '马鞍山市鑫龙铸钢有限公司', '25', '26', '1', '否', '是', '222', '是', '金家庄区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('192', 'A03005', '1', '当涂县特种金属材料厂', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('193', 'A03006', '790829', '大久保技术引进(马鞍山)有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('194', 'B01008', '931020', '马鞍山嘉华汽车零部件有限公司', '23', '26', '1', '否', '是', '222', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('195', 'C01009', '1', '马鞍山开元新材料科技有限公司', '23', '34', '1', '否', '是', '222', '是', '其他重点企业', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('196', 'C01010', '1', '马鞍山万马高分子市政设施有限公司', '23', '26', '1', '否', '是', '222', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('197', 'C01012', '1', '马鞍山市休普技术陶瓷有限责任公司', '23', '26', '1', '否', '是', '222', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('198', 'C01013', '1', '马鞍山市鼎新复合材料有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('199', 'C01014', '2763127', '安徽华骐环保科技股份有限公司', '25', '38', '1', '是', '是', '222', '是', '雨山区', '马鞍山市经济技术开发区梅山路409号', '', '刘光春', '0555-2763126', '13305550943', 'hq@hqhb.com', '243061', '0555-2763127', '', '', 'www.hqhb.com', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('200', 'C01015', '', '马鞍山市宁大耐火材料科技有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('201', 'C01016', '', '马鞍山市益江高温陶瓷制造有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('202', 'C03016', '1', '马鞍山市金石新材料科技有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('203', 'C03017', '666666', '马鞍山市承成机械制造有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('204', 'C03018', '1', '马鞍山市华清科工贸有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('205', 'C03019', '1', '马鞍山市华鑫冶金机械厂', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('206', 'C03020', '1', '马鞍山海狮包装材料有限公司', '24', '26', '1', '否', '是', '222', '是', '雨山区', '', '', '何传军', '6757802', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('207', 'D03021', '2367409', '马鞍山市天狼涂料有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('208', 'D03022', '1', '马鞍山市锐生胶带有限责任公司', '24', '26', '1', '否', '是', '222', null, '雨山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('209', 'D03023', '', '马鞍山市华吉实业有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('210', 'D03024', '1', '马鞍山市东升化工有限责任公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('211', 'F01025', '1', '马鞍山中冶钢铁冶金科技实业开发有限公司', '23', '26', '1', '否', '是', '222', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('212', 'F03026', '1', '马鞍山市中兴焊管有限责任公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('213', 'F03027', '1', '马鞍山市华冶铝业有限责任公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('214', 'F03028', '229', '当涂县诚兴金属制品有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('215', 'F03029', '340502', '马鞍山市恒兴实业有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('216', 'F03030', '1', '马鞍山鼎泰稀土新材料股份有限公司', '25', '35', '1', '是', '是', '222', '是', '当涂工业园', '1', '', '1', '6615988', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('217', 'F03031', '515663', '马鞍山市龙腾五金钢管有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('218', 'G01032', '1', '宇广磁电(马鞍山)有限公司', '23', '26', '1', '否', '是', '222', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('219', 'G03033', '4430', '天源科技通力磁材有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('220', 'I01034', '1', '安徽惊天液压智控股份有限公司', '23', '32', '1', '是', '是', '222', '是', '市开发区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('221', 'I01035', '1', '马鞍山动力传动机械有限责任公司', '23', '32', '1', '否', '是', '222', '是', '市开发区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('222', 'I01036', '54842010', '康克科技(马鞍山)有限公司', '23', '26', '1', '否', '是', '222', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('223', 'I01037', '1', '安徽菲利特流体设备制造有限公司', '23', '26', '1', '否', '是', '222', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('224', 'I01038', '196508', '马鞍山正棱压缩机有限责任公司', '23', '26', '1', '否', '是', '222', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('225', 'I01039', '1', '马鞍山市巨龙机械制造有限公司', '23', '26', '1', '否', '是', '222', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('226', 'I03040', '1', '马鞍山博宇重机有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('227', 'I03041', '737302951', '马鞍山市金海冶金机械制造有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('228', 'I03042', '740321', '马鞍山市建隆机械制造有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('229', 'I03043', '', '马鞍山市华天机械制造有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('230', 'I03044', '1', '马鞍山市华宇环保设备制造有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('231', 'I03045', '1', '马鞍山市金艺机电设备制造有限公司', '24', '26', '1', '否', '是', '222', null, '雨山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('232', 'I03046', '1', '马鞍山市海天重工科技发展有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('233', 'I03047', '666666', '安徽安工机械制造有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('234', 'I03048', '2265888', '马鞍山市华达冶金机械有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('235', 'I03049', '2265888', '马鞍山博伟机械制造有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('236', 'I03050', '1', '马鞍山市向机制造有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('237', 'J03051', '1', '马鞍山市巨星(集团)江南锻压机床厂', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('238', 'J03052', '', '中美合资友邦重工机械有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('239', 'J03053', '1', '马鞍山市太平洋重机有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('240', 'J03054', '1', '马鞍山市华东机床厂', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('241', 'J03055', '6768401', '安徽中瑞机床制造有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('242', 'J03056', '1', '安徽长江机床制造(集团)有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('243', 'K03057', '1', '安徽马鞍山市采石矶食品有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('244', 'K03058', '1', '马鞍山市安康菌业有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('245', 'K03059', '1', '马鞍山采石矶酿酒有限责任公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('246', 'L03060', '1', '马鞍山市大永建筑材料有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('247', 'M01061', '1', '安徽工业大学华冶自动化工程公司', '23', '26', '1', '否', '是', '222', null, '花山区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('248', 'M03062', '212711', '马鞍山伏斯特科技发展有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('249', 'M03063', '1', '马鞍山迈世纪高科技有限责任公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('250', 'N03064', '1', '当涂县江海船舶制造有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('251', 'P03065', '821105', '安徽飞达消防设备工程有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('252', 'P03066', '428', '安民农副产品贸易有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('253', 'P03067', '1205', '安徽省梦都餐饮发展有限责任公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('254', 'P03068', '1', '马鞍山市马物实业有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('255', 'P03069', '1', '马鞍山市新亚实业有限责任公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('256', 'P03070', '1', '安徽鸿泰集团公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('257', 'P03071', '1', '青岛润泰事业有限公司马鞍山分公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('258', 'P03072', '1', '马鞍山市红梅实业发展有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('259', 'P03073', '1', '马鞍山新泰商贸发展有限公司', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('260', 'P03074', '2341884', '马鞍山市华联商厦', '25', '26', '1', '否', '是', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('261', 'D01075', '150522322', '安徽金星钛白（集团）有限公司', '23', '29', '1', '是', '是', '049', '是', '慈湖工业园', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('262', 'E01076', 'ahxly652', '马鞍山丰原制药有限公司', '23', '26', '1', '否', '是', '222', '是', '花山区', '', '', '张加凤', '2109123-8102', '13615551266', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('263', 'A03007', '1', '马鞍山天兴钢业有限公司', '25', '26', '1', '否', '否', '222', null, '金家庄区', null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('264', 'H03005', '1', '安徽红利来服装有限公司', '25', '30', '1', '是', '否', '222', '是', '雨山区', '雨山区工业园', '', '陶会计', '13965397317', '', '', '243010', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('265', 'A03008', '990116', '安徽长江矿业有限公司', '25', '38', '1', '是', '否', '222', '是', '雨山区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('266', 'D03001', '1', '安徽莱特气弹簧有限公司', '25', '27', '1', '是', '否', '222', '是', '当涂县', '安徽马鞍山当涂县博望镇东88号', '340521779080445', '朱秋鹤', '6769688', '15955542353', 'lant-an@263.com', '243100', '6769222', '', '', 'www.lant-an.com', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('267', 'F03005', '2106777', '安徽格瑞德机械制造有限公司', '25', '32', '1', '是', '否', '222', '是', '雨山区', '0', '', '蔡东雪', '2106560', '13965386966', '', '0', '', '', '', '', '1', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('268', 'A06010', '1', '安徽中杭股份有限公司', '25', '26', '1', '是', '否', '', '是', '金家庄区', '', '34050278859128X', '韩影', '3502308', '', '', '243000', '3500660', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('269', 'B03005', '1', '马鞍山市福马汽车零部件有限公司', '25', '27', '1', '是', '否', '', '是', '花山区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('270', 'K05003', '1', '马鞍山雨润食品有限公司', '23', '28', '1', '是', '否', '', '是', '市开发区', '马鞍山市太白大道188号', '', '张永奎', '2109801', '', '', '243000', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('271', 'D03002', '123456', '马鞍山立白日化有限公司', '23', '29', '1', '是', '否', '', '是', '慈湖工业园', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('272', 'E09002', '847710', '安徽国星生物化学有限公司', '25', '31', '1', '是', '否', '', '是', '当涂县', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('273', 'E03004', '1', '马鞍山阳晨生物科技有限公司', '25', '31', '1', '否', '否', '', '是', '雨山区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('274', 'I05006', '1', '马鞍山统力回转支承有限公司', '23', '32', '1', '是', '否', '', '是', '市开发区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('275', 'C05005', '1', '马鞍山石溪野水泥有限责任公司', '25', '36', '1', '是', '否', '', '是', '金家庄区', '', '', '王德雨', '2150580', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('276', 'F09001', '1', '安徽徽铝铝业有限公司', '25', '35', '1', '是', '否', '', '是', '当涂县', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('277', 'z09001', '888888', '马鞍山天狼涂料有限公司', '25', '29', null, '否', '是', null, '是', '花山区', '', '', '1', '1', '', '', '', '', '', '', '', '3', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('278', 'z09002', '888888', '马鞍山凯敏钢缆有限公司', '25', '33', null, '否', '是', null, '是', '花山区', '', '', '1', '1', '', '', '', '', '', '', '', '2', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('279', 'z09003', '888888', '马鞍山市星新机械材料有限公司', '25', '26', null, '否', '是', null, '否', '金家庄区', '', '', '1', '1', '', '', '', '', '', '', '', '2', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('280', 'dlsp', '2110516', '马鞍山达利食品有限公司', '23', '28', null, '是', '是', null, '否', '市开发区', '市开发区', '', '赖祝意', '2110516', '15255501869', '', '', '', '', '', '', '45', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('281', 'kdjd', '791226', '马鞍山科达机电有限公司', '23', '32', null, '是', '是', null, '是', '市开发区', '市开发区', '', '罗威', '2373989', '13805552612', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('282', 'rsgm', '8281110', '马鞍山锐生工贸有限公司', '25', '29', null, '是', '是', null, '是', '金家庄区', '', '', '何振铿', '8281110', '15105558306', '', '', '', '', '', '', '100', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('283', 'JTJX', '1111', '安徽金桐精细化学有限公司', '23', '29', null, '是', '是', null, '是', '慈湖工业园', '慈湖开发区', '', '高亮', '8323458', '', '', '', '', '', '', '', '200', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('284', 'ztwz', '0000', '中铁物资巢湖铁道水泥有限公司', '25', '36', null, '是', '是', null, '是', '含山县', '含山县', '', '居经理', '13956636647', '', '', '', '', '', '', '', '65', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('285', 'wdhb', '0000', '安徽威达环保科技股份有限公司', '25', '35', null, '是', '是', null, '是', '含山县', '', '', '含山县', '000000', '', '', '', '', '', '', '', '63', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('286', 'rjsn', '0000', '安徽省润基水泥有限责任公司', '25', '36', null, '是', '是', null, '是', '含山县', '', '', '李会计', '13965685856', '', '', '', '', '', '', '', '64', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('287', 'yotc', '0000', '安徽亚欧陶瓷有限责任公司', '25', '36', null, '是', '是', null, '是', '含山县', '', '', '含山县', '0000000', '', '', '', '', '', '', '', '65', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('288', 'pjsn', '141592', '安徽盘景水泥有限公司', '25', '36', null, '是', '是', null, '是', '和县', '', '340523664208330', '陈福康', '05655131698', '', '', '', '', '', '', '', '66', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('289', 'slby', 'sanlian', '安徽三联泵业股份有限公司', '25', '32', null, '是', '是', null, '是', '和县', '和县经济开发区', '70502925x', '江月', '5318001', '18856556067', '', '238200', '5328704', '', '', '', '66', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('290', 'hxhg', '0000', '安徽华星化工股份有限公司', '25', '29', null, '是', '是', null, '是', '和县', '安徽省和县乌江镇石跋河省精细化工园', '705040002', '毛益春', '0555-5962851', '15385115100', '', '', '', '', '', '', '67', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('291', 'hxxqh', '000000', '安徽香泉湖禽业有限公司', '25', '28', null, '是', '是', null, '是', '和县', '1', '', '1', '0555', '', '', '', '', '', '', '', '1', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('292', 'dpyz', '0000', '安徽大平油脂有限公司', '25', '28', null, '是', '是', null, '是', '含山县', '', '', '崇吉祥', '13956660773', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('293', 'txgzp', '0000', '马鞍山天兴钢制品有限公司', '24', '26', null, '否', '是', null, '是', '当涂县', '', '', '1', '0555', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('294', 'fmcq', '0000', '安徽福马车桥有限公司', '23', '27', null, '否', '是', null, '是', '市开发区', '', '', '1', '0555', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('295', 'mgekj', '0000', '马鞍山美格尔科技电器有限公司', '23', '32', null, '是', '是', null, '是', '示范园区', '', '', '1', '1', '', '', '', '', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('296', 'zhgf', '0000', '中弘光伏股份有限公司', '23', '37', null, '是', '是', null, '是', '示范园区', '马鞍山市承接产业转移示范园区', '340521560698347', '1', '1', '13355557476', '348972716@QQ.COM', '', '5236789', '', '', '', '0', '', '', null, null, null, null);
INSERT INTO `zy_corporation` VALUES ('297', 'mxgn', '0000', '马鞍山明鑫光能科技有限公司', '23', '26', null, '是', null, null, '是', '4', '', '', '1', '1', '阿斯蒂芬', '阿萨德', '', ' 阿斯蒂芬', '闲邪存诚vzx', '撒旦法阿萨德阿萨德', '地方阿萨德 ', '0', '', '', null, null, null, null);
