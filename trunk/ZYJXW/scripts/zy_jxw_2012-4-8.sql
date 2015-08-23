/*
Navicat MySQL Data Transfer

Source Server         : zy_jxw
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : zy_jxw

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2012-04-08 14:58:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `zy_article`
-- ----------------------------
DROP TABLE IF EXISTS `zy_article`;
CREATE TABLE `zy_article` (
  `articleId` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `come_from` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `partment_id` int(11) DEFAULT NULL,
  `content` text NOT NULL,
  `img_flag` char(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remarks` text,
  `keywords` varchar(255) DEFAULT NULL,
  `description` text,
  `img_url` varchar(255) DEFAULT NULL,
  `article_type` char(1) DEFAULT NULL,
  `inner_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`articleId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_article
-- ----------------------------
INSERT INTO `zy_article` VALUES ('8', '阿萨德发射点发速度发生的阿斯蒂芬', 'asdfasdf', '0', '1', '1', '2', 'sadfasdfasdfa阿萨德发射点发撒旦法阿斯蒂芬阿斯蒂芬sdfasdfasd<br />', '1', '2012-03-29 22:07:33', '2012-03-29 22:07:33', '阿斯蒂芬阿斯蒂芬', 'asdfasd', 'fasdfasdf', '撒旦法阿斯蒂芬', null, '0');
INSERT INTO `zy_article` VALUES ('10', '搞个', '发给', '1', '1', '1', '1', '&nbsp;&nbsp; 放到电话光放大<br />', null, '2012-03-30 23:34:18', '2012-03-30 23:34:18', '发给发', '', '发给地方地方', '发给放到', '0', '0');
INSERT INTO `zy_article` VALUES ('11', '的方式发到过分的话', '东方红大反攻', '1', '1', '1', '1', '梵蒂冈化蝶飞化蝶飞 大幅度<br />', '0', '2012-03-31 20:41:39', '2012-03-31 20:41:39', '的发给', '发', ' 反对搞活 ', '', '0', '0');
INSERT INTO `zy_article` VALUES ('12', '好东方', '地方恢复搞活', '0', '50', '1', '2', '该行还将干活sdssd好', '0', '2012-03-31 20:41:57', '2012-04-01 22:24:10', '地方很反sdsd感', 'sdfd', '飞过海ssd发', '', null, '0');
INSERT INTO `zy_article` VALUES ('13', '说到底是 ', ' 速度速度', '0', '13', '1', '0', '撒旦法阿斯蒂芬啊', null, '2012-03-31 20:46:35', '2012-04-01 22:03:39', '', '阿斯蒂芬是', ' 适当放松的是', '', null, '0');
INSERT INTO `zy_article` VALUES ('14', '化工股份 飞过海发给', '地方个好地方', '1', '19', '1', '1', '的个好地方更好地发挥<br />', null, '2012-03-31 20:50:04', '2012-04-01 22:36:43', '飞过海发', '固定很多好', '的个好地方', '', null, '0');
INSERT INTO `zy_article` VALUES ('15', 'cxxc', 'xcvxxcv', '1', '1', '1', '2', 'xccvxcvx<br />', null, '2012-04-01 21:35:39', '2012-04-01 21:35:39', '', 'xvcvxc', 'vcvc', '', '0', null);
INSERT INTO `zy_article` VALUES ('16', 'sdfdsdfsfd', 'dfdfdf', '1', '21', '1', '2', 'dffddfdf', '0', '2012-04-01 22:24:49', '2012-04-01 22:24:49', 'dfsfsd', 'dfsdffsd', 'dfsfdsfds', 'dfsfds', '0', '0');
INSERT INTO `zy_article` VALUES ('17', 'dadssda', 'sadsaddsaf', '1', '20', '1', '2', 'dsadsdsadasfdsfa', null, '2012-04-01 22:26:28', '2012-04-01 22:26:42', '', 'sdafsad', 'asddsa', 'asddsasda', null, '0');
INSERT INTO `zy_article` VALUES ('18', 'gfyf', 'ffddd', '1', '5', '1', '2', 'dfdfdhdfhdhdf', null, '2012-04-01 22:27:16', '2012-04-01 22:27:16', '', '', '', '', '0', null);
INSERT INTO `zy_article` VALUES ('19', 'asdfasd', 'asdfasd', '1', '33', '1', '2', 'asdfasdfasdf<br />', null, '2012-04-03 21:24:20', '2012-04-03 21:24:20', '', 'asdfasd', '', '', '0', null);
INSERT INTO `zy_article` VALUES ('20', 'asdfasdfffffffff', 'fffff', '1', '33', '1', '2', 'asdasdfasdfas', null, '2012-04-03 21:24:41', '2012-04-03 21:24:41', '', '', 'asdfasdfasd', '', '0', null);
INSERT INTO `zy_article` VALUES ('21', 'dfdfd', 'dfdf', '1', '33', '1', '2', 'dffdffd<br />', null, '2012-04-05 20:38:21', '2012-04-05 20:38:21', '', '', 'dsfddsf', '', '0', null);
INSERT INTO `zy_article` VALUES ('22', 'dffdfd', 'dfdffd', '1', '28', '1', '2', 'fdfsdfffd', null, '2012-04-05 20:44:21', '2012-04-05 20:44:21', 'sfdfss', '', 'sfdgffds', '', '0', null);
INSERT INTO `zy_article` VALUES ('23', 'sdfgsdfgsdfgs', 'dsdfgsdfgsdfgsdfg', '1', '33', '1', '2', 'sdfgsdfgsdfgsdfgsdfgsdfg', null, '2012-04-05 20:45:21', '2012-04-05 20:45:21', '', '', '', '', '0', null);
INSERT INTO `zy_article` VALUES ('26', 'sssssssssssss', 'sssssssssssssssss', '1', '33', '1', '2', '', null, '2012-04-05 21:06:14', '2012-04-05 21:06:14', '', '', '', '', '0', null);
INSERT INTO `zy_article` VALUES ('28', 'hdfghdf', 'ghdghdghdf', '1', '32', '1', '2', 'fddffhhhjgh<br />', null, '2012-04-07 14:45:58', '2012-04-07 14:47:24', '', '', '', '', null, null);

-- ----------------------------
-- Table structure for `zy_article_type`
-- ----------------------------
DROP TABLE IF EXISTS `zy_article_type`;
CREATE TABLE `zy_article_type` (
  `link` varchar(255) DEFAULT NULL,
  `visiable` char(1) NOT NULL,
  `type` char(255) DEFAULT NULL,
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_article_type
-- ----------------------------
INSERT INTO `zy_article_type` VALUES ('x', '1', '2', '1', '0', '我的栏目', '2012-03-27 22:28:14', '2012-04-08 11:13:55');
INSERT INTO `zy_article_type` VALUES (null, '0', '2', '2', '0', '2222', '2012-03-27 22:28:32', '2012-03-29 21:37:34');
INSERT INTO `zy_article_type` VALUES ('cvzxc', '0', '2', '3', '0', '3333', '2012-03-27 22:28:44', '2012-03-27 22:28:45');
INSERT INTO `zy_article_type` VALUES ('', '0', '0', '4', '1', '视频', '2012-03-28 20:03:57', '2012-04-08 11:13:40');
INSERT INTO `zy_article_type` VALUES ('zxcvzx', '0', '2', '5', '1', '5555', '2012-03-28 20:18:44', '2012-03-28 20:18:44');
INSERT INTO `zy_article_type` VALUES ('cvzxcvzx', '0', '2', '6', '4', '6666', '2012-03-28 20:19:52', '2012-03-28 20:19:52');
INSERT INTO `zy_article_type` VALUES ('zxcvzx', '0', '2', '7', '6', '7777', '2012-04-01 22:06:54', '2012-04-01 22:06:54');
INSERT INTO `zy_article_type` VALUES ('', '0', '0', '8', '4', '8888', '2012-04-02 14:20:08', '2012-04-02 14:20:08');
INSERT INTO `zy_article_type` VALUES ('www.baidu.com', '0', '2', '51', '7', 'gggg', '2012-04-08 10:38:27', '2012-04-08 10:38:27');
INSERT INTO `zy_article_type` VALUES ('', '0', '0', '52', '5', '566666', '2012-04-08 10:38:44', '2012-04-08 10:38:44');
INSERT INTO `zy_article_type` VALUES ('', '0', '0', '53', '1', '新闻2', '2012-04-08 11:13:29', '2012-04-08 11:13:29');
INSERT INTO `zy_article_type` VALUES ('', '0', '0', '54', '53', '国内新闻', '2012-04-08 11:14:13', '2012-04-08 11:14:13');

-- ----------------------------
-- Table structure for `zy_company`
-- ----------------------------
DROP TABLE IF EXISTS `zy_company`;
CREATE TABLE `zy_company` (
  `companyId` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) DEFAULT NULL,
  `company_address` varchar(255) DEFAULT NULL,
  `post_code` varchar(10) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_company
-- ----------------------------
INSERT INTO `zy_company` VALUES ('1', 'fff', 'fff', 'f', 'ffff', null, null);
INSERT INTO `zy_company` VALUES ('2', 'rrrrrr', 'rrrrrrr', '656', '56565665', null, null);
INSERT INTO `zy_company` VALUES ('3', 'fggggggg', 'ggggg', 'gg', 'ggg', null, null);
INSERT INTO `zy_company` VALUES ('5', 'sdssd', 'ssss', 'ss', 'ssssss', null, '2012-04-04 22:58:47');
INSERT INTO `zy_company` VALUES ('7', 'lll', 'lll', '', 'lll', null, '2012-04-04 23:01:00');
INSERT INTO `zy_company` VALUES ('9', 'rrt', 'rrr', 'rr', 'rrrr', '2012-04-04 23:28:37', '2012-04-04 23:28:37');

-- ----------------------------
-- Table structure for `zy_navigation`
-- ----------------------------
DROP TABLE IF EXISTS `zy_navigation`;
CREATE TABLE `zy_navigation` (
  `naviId` int(11) NOT NULL AUTO_INCREMENT,
  `navi_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`naviId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_navigation
-- ----------------------------

-- ----------------------------
-- Table structure for `zy_partment`
-- ----------------------------
DROP TABLE IF EXISTS `zy_partment`;
CREATE TABLE `zy_partment` (
  `partmentId` int(11) NOT NULL AUTO_INCREMENT,
  `partment_name` varchar(255) NOT NULL,
  PRIMARY KEY (`partmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_partment
-- ----------------------------
INSERT INTO `zy_partment` VALUES ('1', '财务sds');
INSERT INTO `zy_partment` VALUES ('2', 'dssfsdfsd');
INSERT INTO `zy_partment` VALUES ('3', 'ffff');
INSERT INTO `zy_partment` VALUES ('4', '94594');
INSERT INTO `zy_partment` VALUES ('6', '651561');

-- ----------------------------
-- Table structure for `zy_premission`
-- ----------------------------
DROP TABLE IF EXISTS `zy_premission`;
CREATE TABLE `zy_premission` (
  `premissionId` int(11) NOT NULL AUTO_INCREMENT,
  `section_id` int(11) NOT NULL,
  `premission_type` char(1) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`premissionId`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_premission
-- ----------------------------
INSERT INTO `zy_premission` VALUES ('1', '1', '0', '查看');
INSERT INTO `zy_premission` VALUES ('2', '1', '2', '删除、修改');
INSERT INTO `zy_premission` VALUES ('3', '1', '1', '删除、修改');
INSERT INTO `zy_premission` VALUES ('4', '2', '0', '查看');
INSERT INTO `zy_premission` VALUES ('5', '2', '1', '审核');
INSERT INTO `zy_premission` VALUES ('6', '2', '2', null);
INSERT INTO `zy_premission` VALUES ('7', '3', '0', null);
INSERT INTO `zy_premission` VALUES ('8', '3', '1', null);
INSERT INTO `zy_premission` VALUES ('9', '3', '2', null);
INSERT INTO `zy_premission` VALUES ('10', '41', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('11', '41', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('12', '41', '2', '审核');
INSERT INTO `zy_premission` VALUES ('13', '42', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('14', '42', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('15', '42', '2', '审核');
INSERT INTO `zy_premission` VALUES ('16', '43', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('17', '43', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('18', '43', '2', '审核');
INSERT INTO `zy_premission` VALUES ('19', '44', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('20', '44', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('21', '44', '2', '审核');
INSERT INTO `zy_premission` VALUES ('22', '45', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('23', '45', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('24', '45', '2', '审核');
INSERT INTO `zy_premission` VALUES ('25', '46', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('26', '46', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('27', '46', '2', '审核');
INSERT INTO `zy_premission` VALUES ('28', '47', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('29', '47', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('30', '47', '2', '审核');
INSERT INTO `zy_premission` VALUES ('31', '48', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('32', '48', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('33', '48', '2', '审核');
INSERT INTO `zy_premission` VALUES ('34', '49', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('35', '49', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('36', '49', '2', '审核');
INSERT INTO `zy_premission` VALUES ('37', '50', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('38', '50', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('39', '50', '2', '审核');
INSERT INTO `zy_premission` VALUES ('40', '51', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('41', '51', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('42', '51', '2', '审核');
INSERT INTO `zy_premission` VALUES ('43', '52', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('44', '52', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('45', '52', '2', '审核');
INSERT INTO `zy_premission` VALUES ('46', '53', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('47', '53', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('48', '53', '2', '审核');
INSERT INTO `zy_premission` VALUES ('49', '54', '0', '查看访问');
INSERT INTO `zy_premission` VALUES ('50', '54', '1', '添加，修改，删除');
INSERT INTO `zy_premission` VALUES ('51', '54', '2', '审核');

-- ----------------------------
-- Table structure for `zy_role`
-- ----------------------------
DROP TABLE IF EXISTS `zy_role`;
CREATE TABLE `zy_role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_role
-- ----------------------------
INSERT INTO `zy_role` VALUES ('1', '管理员');
INSERT INTO `zy_role` VALUES ('2', '撒打算');
INSERT INTO `zy_role` VALUES ('3', 'ghhh');
INSERT INTO `zy_role` VALUES ('4', 'asaas');
INSERT INTO `zy_role` VALUES ('5', 'gff');
INSERT INTO `zy_role` VALUES ('6', 'sdsdsd');

-- ----------------------------
-- Table structure for `zy_role_premission`
-- ----------------------------
DROP TABLE IF EXISTS `zy_role_premission`;
CREATE TABLE `zy_role_premission` (
  `role_id` int(11) NOT NULL,
  `premission_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_role_premission
-- ----------------------------
INSERT INTO `zy_role_premission` VALUES ('2', '2');
INSERT INTO `zy_role_premission` VALUES ('2', '1');
INSERT INTO `zy_role_premission` VALUES ('2', '3');
INSERT INTO `zy_role_premission` VALUES ('2', '4');
INSERT INTO `zy_role_premission` VALUES ('2', '5');
INSERT INTO `zy_role_premission` VALUES ('1', '1');
INSERT INTO `zy_role_premission` VALUES ('1', '3');
INSERT INTO `zy_role_premission` VALUES ('1', '4');
INSERT INTO `zy_role_premission` VALUES ('1', '5');
INSERT INTO `zy_role_premission` VALUES ('1', '2');

-- ----------------------------
-- Table structure for `zy_user`
-- ----------------------------
DROP TABLE IF EXISTS `zy_user`;
CREATE TABLE `zy_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `active` char(1) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `user_type` char(1) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `company_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zy_user
-- ----------------------------
INSERT INTO `zy_user` VALUES ('1', 'lion', '2', 'String', '12345', '0', 'remarks', '0', '1', '0', '2012-03-23 21:36:31', '2012-03-31 23:40:01');
INSERT INTO `zy_user` VALUES ('2', 'lionest23', '1', '2222222', 'eeeee', '0', 'remarks', '0', '1', '122', '2012-03-23 21:42:01', '2012-03-23 21:42:01');
INSERT INTO `zy_user` VALUES ('3', 'lionest23d', '1', '2222222', 'eeeee', '0', 'remarks', '0', '1', '1', '2012-03-23 21:42:16', '2012-03-31 23:33:49');
INSERT INTO `zy_user` VALUES ('5', 'fgf', '2', 'fgfg', 'fgfgfg', '0', 'fggffg', '0', '1', '0', '2012-03-31 23:42:36', '2012-03-31 23:42:36');
INSERT INTO `zy_user` VALUES ('6', 'sdsdsd', '2', 'sdds', 'dsds', '0', 'sdsdds', '0', '1', '0', '2012-04-04 21:33:29', '2012-04-04 21:33:29');
INSERT INTO `zy_user` VALUES ('7', 'fdf', '2', 'dfd', 'fff', '0', 'dffdfdf', '0', '1', '0', '2012-04-04 22:11:09', '2012-04-04 22:11:09');
INSERT INTO `zy_user` VALUES ('8', 'dfdf', '2', 'dffd', 'dfdf', '0', 'fffffff', '1', '1', '7', '2012-04-04 22:11:48', '2012-04-04 22:11:48');
INSERT INTO `zy_user` VALUES ('9', 'ttrr', '2', 'rt', 'rtrt', '0', 'tytyyt', '0', '1', '0', '2012-04-04 22:13:34', '2012-04-04 22:13:34');
INSERT INTO `zy_user` VALUES ('10', 'eryer', '2', 'ertyer', 'rtyre', '0', '56655', '1', '1', '9', '2012-04-04 22:14:00', '2012-04-04 22:14:00');
INSERT INTO `zy_user` VALUES ('13', 'test', '3', 'sss', '123245', '0', 'dssdds', '1', '1', '0', '2012-04-04 23:00:28', '2012-04-04 23:01:00');
INSERT INTO `zy_user` VALUES ('14', 'qwe', '2', 'qwewq', 'weq', '0', 'wqewqe', '1', '1', '9', '2012-04-04 23:27:54', '2012-04-04 23:28:37');
