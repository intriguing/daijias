/*
Navicat MySQL Data Transfer

Source Server         : 23.94.123.193
Source Server Version : 50712
Source Host           : 23.94.123.193:3306
Source Database       : daijia

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-07 16:01:09
*/
CREATE SCHEMA `daijia` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminater_inf
-- ----------------------------
DROP TABLE IF EXISTS `adminater_inf`;
CREATE TABLE `adminater_inf` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `flag` varchar(50) DEFAULT NULL,
  `user_infor` varchar(255) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_pass` varchar(50) NOT NULL,
  `user_phone` varchar(18) NOT NULL,
  `user_sex` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminater_inf
-- ----------------------------
INSERT INTO `adminater_inf` VALUES ('1', '1', '呵呵', '123', '123', '15295600981', '0');

-- ----------------------------
-- Table structure for code_inf
-- ----------------------------
DROP TABLE IF EXISTS `code_inf`;
CREATE TABLE `code_inf` (
  `code_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(18) NOT NULL,
  `user_phone` varchar(18) NOT NULL,
  PRIMARY KEY (`code_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code_inf
-- ----------------------------
INSERT INTO `code_inf` VALUES ('1', '123', '15295600981');
INSERT INTO `code_inf` VALUES ('2', '123456', '15295600987');
INSERT INTO `code_inf` VALUES ('3', '123', '15195960613');
INSERT INTO `code_inf` VALUES ('4', '123', '15195960541');
INSERT INTO `code_inf` VALUES ('5', '123', '15195960613');
INSERT INTO `code_inf` VALUES ('6', '123', '18115185306');
INSERT INTO `code_inf` VALUES ('7', '123', '15295600981');
INSERT INTO `code_inf` VALUES ('8', '123', '15295600981');
INSERT INTO `code_inf` VALUES ('9', '456', '18115185305');
INSERT INTO `code_inf` VALUES ('10', '789', '15295600781');
INSERT INTO `code_inf` VALUES ('11', '123', '18115185304');
INSERT INTO `code_inf` VALUES ('12', '889了', '15195960613');
INSERT INTO `code_inf` VALUES ('13', '啦啦', '15275800941');
INSERT INTO `code_inf` VALUES ('14', '乐拉', '18115785354');
INSERT INTO `code_inf` VALUES ('15', '天哦来吧', '15195990613');
INSERT INTO `code_inf` VALUES ('16', '来来', '14851596087');
INSERT INTO `code_inf` VALUES ('17', '来来', '14789678211');
INSERT INTO `code_inf` VALUES ('18', '还吧还到', '15289500771');
INSERT INTO `code_inf` VALUES ('19', '124', '18112545673');
INSERT INTO `code_inf` VALUES ('20', '闷闷', '15748609952');
INSERT INTO `code_inf` VALUES ('21', '158', '18798005845');
INSERT INTO `code_inf` VALUES ('22', '890', '15740896548');
INSERT INTO `code_inf` VALUES ('23', '748', '14708006856');
INSERT INTO `code_inf` VALUES ('24', '啦啦', '15108726849');
INSERT INTO `code_inf` VALUES ('25', '587', '16408907868');
INSERT INTO `code_inf` VALUES ('26', '88', '15170894807');
INSERT INTO `code_inf` VALUES ('27', '123', '18115742315');
INSERT INTO `code_inf` VALUES ('28', '123', '18975423158');

-- ----------------------------
-- Table structure for driver_inf
-- ----------------------------
DROP TABLE IF EXISTS `driver_inf`;
CREATE TABLE `driver_inf` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `driverrange` int(11) DEFAULT NULL,
  `drivingYears` int(11) DEFAULT NULL,
  `imageUrl` varchar(255) NOT NULL,
  `user_infor` varchar(255) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `oauth` int(11) DEFAULT NULL,
  `user_pass` varchar(50) NOT NULL,
  `user_phone` varchar(18) NOT NULL,
  `pointX` int(11) DEFAULT NULL,
  `pointY` int(11) DEFAULT NULL,
  `user_sex` int(11) NOT NULL,
  `starLeave` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driver_inf
-- ----------------------------
INSERT INTO `driver_inf` VALUES ('2', '45', '4', 'image/20160602U8WE6L.png', '啦啦', '张三', '0', '123456', '18115185305', '31932412', '118888241', '1', '5', '3');
INSERT INTO `driver_inf` VALUES ('3', '30', '2', 'image/201606029Nv8y0.jpg', '呵呵', '李四', '1', '123456', '15295600781', '31932978', '118888941', '1', '3', '2');
INSERT INTO `driver_inf` VALUES ('4', '77', '2', 'image/20160602byL646.jpg', '乐天', '啦啦', '1', '123456', '15195960613', '31932442', '118888326', '0', '1', '1');
INSERT INTO `driver_inf` VALUES ('5', '60', '3', 'image/20160602r55P64.png', '乐乐乐吧', '钱一', '0', '123456', '18112545673', '31933572', '118888287', '0', '5', '1');
INSERT INTO `driver_inf` VALUES ('6', '87', '3', 'image/201606020N64j6.png', '12685', '天蝎座', '1', '123456', '15108726849', '31933981', '118888043', '0', '2', '1');
INSERT INTO `driver_inf` VALUES ('7', '45', '3', 'image/201606021XiNt6.jpg', '呵呵', '赵五', '1', '123456', '18115185304', '31933043', '118888267', '0', '3', '3');
INSERT INTO `driver_inf` VALUES ('8', '30', '4', 'image/20160603dRB5hs.png', '德德', '呵呵', '1', '123456', '18115185306', '31927816', '118895368', '0', '5', '2');
INSERT INTO `driver_inf` VALUES ('9', '35', '4', 'image/201606031a99a0.png', '楼上', '天天天', '0', '123456', '18115742315', '31926147', '118885140', '0', '5', '1');

-- ----------------------------
-- Table structure for driverComment_inf
-- ----------------------------
DROP TABLE IF EXISTS `driverComment_inf`;
CREATE TABLE `driverComment_inf` (
  `driverComment_id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_comment` varchar(18) NOT NULL,
  `driver_id` varchar(18) NOT NULL,
  `user_phone` varchar(18) NOT NULL,
  `starLevel` varchar(18) NOT NULL,
  PRIMARY KEY (`driverComment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driverComment_inf
-- ----------------------------
INSERT INTO `driverComment_inf` VALUES ('1', '来来天', '3', '15195960613', '3');
INSERT INTO `driverComment_inf` VALUES ('2', '啦啦', '1', '18115185306', '5');
INSERT INTO `driverComment_inf` VALUES ('3', '咔咔', '1', '18115185306', '2');
INSERT INTO `driverComment_inf` VALUES ('4', '\n来部还', '1', '18115185306', '5');
INSERT INTO `driverComment_inf` VALUES ('5', '来拉', '3', '15748609952', '2');
INSERT INTO `driverComment_inf` VALUES ('6', '西吧', '3', '15748609952', '1');
INSERT INTO `driverComment_inf` VALUES ('7', '乐来还吧来', '7', '15748609952', '3');
INSERT INTO `driverComment_inf` VALUES ('8', '解决', '6', '15748609952', '3');
INSERT INTO `driverComment_inf` VALUES ('9', '查哎', '4', '14708006856', '1');
INSERT INTO `driverComment_inf` VALUES ('10', '哈哈打', '4', '14708006856', '2');
INSERT INTO `driverComment_inf` VALUES ('11', '来问来', '3', '14708006856', '5');
INSERT INTO `driverComment_inf` VALUES ('12', '哦来来', '6', '14708006856', '3');
INSERT INTO `driverComment_inf` VALUES ('13', '啊了', '6', '15295600981', '3');
INSERT INTO `driverComment_inf` VALUES ('14', '\n\n', '3', '15295600981', '5');
INSERT INTO `driverComment_inf` VALUES ('15', '\n', '3', '15295600981', '5');
INSERT INTO `driverComment_inf` VALUES ('16', '替补', '6', '15295600981', '1');
INSERT INTO `driverComment_inf` VALUES ('17', '陆', '6', '15295600981', '1');

-- ----------------------------
-- Table structure for hour_inf
-- ----------------------------
DROP TABLE IF EXISTS `hour_inf`;
CREATE TABLE `hour_inf` (
  `hour_id` int(11) NOT NULL AUTO_INCREMENT,
  `hour_driverNum` int(11) NOT NULL,
  `hour_time` varchar(18) NOT NULL,
  `hour_time2` varchar(30) NOT NULL,
  PRIMARY KEY (`hour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=265 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hour_inf
-- ----------------------------
INSERT INTO `hour_inf` VALUES ('1', '1', '2016-05-27', '2016-05-27 05:00:00');
INSERT INTO `hour_inf` VALUES ('2', '1', '2016-05-27', '2016-05-27 06:00:00');
INSERT INTO `hour_inf` VALUES ('3', '1', '2016-05-27', '2016-05-27 07:00:00');
INSERT INTO `hour_inf` VALUES ('4', '1', '2016-05-27', '2016-05-27 08:00:00');
INSERT INTO `hour_inf` VALUES ('5', '1', '2016-05-27', '2016-05-27 09:00:00');
INSERT INTO `hour_inf` VALUES ('6', '1', '2016-05-27', '2016-05-27 10:00:00');
INSERT INTO `hour_inf` VALUES ('7', '1', '2016-05-27', '2016-05-27 11:00:00');
INSERT INTO `hour_inf` VALUES ('8', '1', '2016-05-27', '2016-05-27 12:00:00');
INSERT INTO `hour_inf` VALUES ('9', '1', '2016-05-27', '2016-05-27 13:00:00');
INSERT INTO `hour_inf` VALUES ('10', '1', '2016-05-27', '2016-05-27 14:00:00');
INSERT INTO `hour_inf` VALUES ('11', '1', '2016-05-27', '2016-05-27 15:00:00');
INSERT INTO `hour_inf` VALUES ('12', '1', '2016-05-27', '2016-05-27 16:00:00');
INSERT INTO `hour_inf` VALUES ('13', '1', '2016-05-27', '2016-05-27 17:00:00');
INSERT INTO `hour_inf` VALUES ('14', '1', '2016-05-27', '2016-05-27 18:00:00');
INSERT INTO `hour_inf` VALUES ('15', '1', '2016-05-27', '2016-05-27 19:00:00');
INSERT INTO `hour_inf` VALUES ('16', '1', '2016-05-27', '2016-05-27 20:00:00');
INSERT INTO `hour_inf` VALUES ('17', '1', '2016-05-27', '2016-05-27 21:00:00');
INSERT INTO `hour_inf` VALUES ('18', '1', '2016-05-27', '2016-05-27 22:00:00');
INSERT INTO `hour_inf` VALUES ('19', '1', '2016-05-27', '2016-05-27 23:00:00');
INSERT INTO `hour_inf` VALUES ('20', '1', '2016-05-28', '2016-05-28 00:00:00');
INSERT INTO `hour_inf` VALUES ('21', '1', '2016-05-28', '2016-05-28 01:00:00');
INSERT INTO `hour_inf` VALUES ('22', '1', '2016-05-28', '2016-05-28 02:00:00');
INSERT INTO `hour_inf` VALUES ('23', '1', '2016-05-28', '2016-05-28 03:00:00');
INSERT INTO `hour_inf` VALUES ('24', '1', '2016-05-28', '2016-05-28 04:00:00');
INSERT INTO `hour_inf` VALUES ('25', '1', '2016-05-28', '2016-05-28 05:00:00');
INSERT INTO `hour_inf` VALUES ('26', '1', '2016-05-28', '2016-05-28 06:00:00');
INSERT INTO `hour_inf` VALUES ('27', '1', '2016-05-28', '2016-05-28 07:00:00');
INSERT INTO `hour_inf` VALUES ('28', '1', '2016-05-28', '2016-05-28 08:00:00');
INSERT INTO `hour_inf` VALUES ('29', '1', '2016-05-28', '2016-05-28 09:00:00');
INSERT INTO `hour_inf` VALUES ('30', '1', '2016-05-28', '2016-05-28 10:00:00');
INSERT INTO `hour_inf` VALUES ('31', '1', '2016-05-28', '2016-05-28 11:00:00');
INSERT INTO `hour_inf` VALUES ('32', '1', '2016-05-28', '2016-05-28 12:00:00');
INSERT INTO `hour_inf` VALUES ('33', '1', '2016-05-28', '2016-05-28 13:00:00');
INSERT INTO `hour_inf` VALUES ('34', '1', '2016-05-28', '2016-05-28 14:00:00');
INSERT INTO `hour_inf` VALUES ('35', '1', '2016-05-28', '2016-05-28 15:00:00');
INSERT INTO `hour_inf` VALUES ('36', '1', '2016-05-28', '2016-05-28 16:00:00');
INSERT INTO `hour_inf` VALUES ('37', '1', '2016-05-28', '2016-05-28 17:00:00');
INSERT INTO `hour_inf` VALUES ('38', '1', '2016-05-28', '2016-05-28 18:00:00');
INSERT INTO `hour_inf` VALUES ('39', '1', '2016-05-28', '2016-05-28 19:00:00');
INSERT INTO `hour_inf` VALUES ('40', '1', '2016-05-28', '2016-05-28 20:00:00');
INSERT INTO `hour_inf` VALUES ('41', '1', '2016-05-28', '2016-05-28 21:00:00');
INSERT INTO `hour_inf` VALUES ('42', '1', '2016-05-28', '2016-05-28 22:00:00');
INSERT INTO `hour_inf` VALUES ('43', '1', '2016-05-28', '2016-05-28 23:00:00');
INSERT INTO `hour_inf` VALUES ('44', '1', '2016-05-29', '2016-05-29 00:00:00');
INSERT INTO `hour_inf` VALUES ('45', '1', '2016-05-29', '2016-05-29 01:00:00');
INSERT INTO `hour_inf` VALUES ('46', '1', '2016-05-29', '2016-05-29 02:00:00');
INSERT INTO `hour_inf` VALUES ('47', '1', '2016-05-29', '2016-05-29 03:00:00');
INSERT INTO `hour_inf` VALUES ('48', '1', '2016-05-29', '2016-05-29 04:00:00');
INSERT INTO `hour_inf` VALUES ('49', '1', '2016-05-29', '2016-05-29 05:00:00');
INSERT INTO `hour_inf` VALUES ('50', '1', '2016-05-29', '2016-05-29 06:00:00');
INSERT INTO `hour_inf` VALUES ('51', '1', '2016-05-29', '2016-05-29 07:00:00');
INSERT INTO `hour_inf` VALUES ('52', '1', '2016-05-29', '2016-05-29 08:00:00');
INSERT INTO `hour_inf` VALUES ('53', '1', '2016-05-29', '2016-05-29 09:00:00');
INSERT INTO `hour_inf` VALUES ('54', '1', '2016-05-29', '2016-05-29 10:00:00');
INSERT INTO `hour_inf` VALUES ('55', '1', '2016-05-29', '2016-05-29 11:00:00');
INSERT INTO `hour_inf` VALUES ('56', '1', '2016-05-29', '2016-05-29 12:00:00');
INSERT INTO `hour_inf` VALUES ('57', '1', '2016-05-29', '2016-05-29 13:00:00');
INSERT INTO `hour_inf` VALUES ('58', '1', '2016-05-29', '2016-05-29 14:00:00');
INSERT INTO `hour_inf` VALUES ('59', '1', '2016-05-29', '2016-05-29 15:00:00');
INSERT INTO `hour_inf` VALUES ('60', '1', '2016-05-29', '2016-05-29 16:00:00');
INSERT INTO `hour_inf` VALUES ('61', '1', '2016-05-29', '2016-05-29 17:00:00');
INSERT INTO `hour_inf` VALUES ('62', '1', '2016-05-29', '2016-05-29 18:00:00');
INSERT INTO `hour_inf` VALUES ('63', '1', '2016-05-29', '2016-05-29 19:00:00');
INSERT INTO `hour_inf` VALUES ('64', '1', '2016-05-29', '2016-05-29 20:00:00');
INSERT INTO `hour_inf` VALUES ('65', '1', '2016-05-29', '2016-05-29 21:00:00');
INSERT INTO `hour_inf` VALUES ('66', '1', '2016-05-29', '2016-05-29 22:00:00');
INSERT INTO `hour_inf` VALUES ('67', '1', '2016-05-29', '2016-05-29 23:00:00');
INSERT INTO `hour_inf` VALUES ('68', '1', '2016-05-30', '2016-05-30 00:00:00');
INSERT INTO `hour_inf` VALUES ('69', '1', '2016-05-30', '2016-05-30 01:00:00');
INSERT INTO `hour_inf` VALUES ('70', '1', '2016-05-30', '2016-05-30 02:00:00');
INSERT INTO `hour_inf` VALUES ('71', '1', '2016-05-30', '2016-05-30 03:00:00');
INSERT INTO `hour_inf` VALUES ('72', '1', '2016-05-30', '2016-05-30 04:00:00');
INSERT INTO `hour_inf` VALUES ('73', '1', '2016-05-30', '2016-05-30 05:00:00');
INSERT INTO `hour_inf` VALUES ('74', '1', '2016-05-30', '2016-05-30 06:00:00');
INSERT INTO `hour_inf` VALUES ('75', '1', '2016-05-30', '2016-05-30 07:00:00');
INSERT INTO `hour_inf` VALUES ('76', '1', '2016-05-30', '2016-05-30 08:00:00');
INSERT INTO `hour_inf` VALUES ('77', '1', '2016-05-30', '2016-05-30 09:00:00');
INSERT INTO `hour_inf` VALUES ('78', '1', '2016-05-30', '2016-05-30 10:00:00');
INSERT INTO `hour_inf` VALUES ('79', '1', '2016-05-30', '2016-05-30 11:00:00');
INSERT INTO `hour_inf` VALUES ('80', '1', '2016-05-30', '2016-05-30 12:00:00');
INSERT INTO `hour_inf` VALUES ('81', '1', '2016-05-30', '2016-05-30 13:00:00');
INSERT INTO `hour_inf` VALUES ('82', '1', '2016-05-30', '2016-05-30 14:00:00');
INSERT INTO `hour_inf` VALUES ('83', '1', '2016-05-30', '2016-05-30 15:00:00');
INSERT INTO `hour_inf` VALUES ('84', '1', '2016-05-30', '2016-05-30 16:00:00');
INSERT INTO `hour_inf` VALUES ('85', '1', '2016-05-30', '2016-05-30 17:00:00');
INSERT INTO `hour_inf` VALUES ('86', '1', '2016-05-30', '2016-05-30 18:00:00');
INSERT INTO `hour_inf` VALUES ('87', '1', '2016-05-30', '2016-05-30 19:00:00');
INSERT INTO `hour_inf` VALUES ('88', '1', '2016-05-30', '2016-05-30 20:00:00');
INSERT INTO `hour_inf` VALUES ('89', '1', '2016-05-30', '2016-05-30 21:00:00');
INSERT INTO `hour_inf` VALUES ('90', '1', '2016-05-30', '2016-05-30 22:00:00');
INSERT INTO `hour_inf` VALUES ('91', '1', '2016-05-30', '2016-05-30 23:00:00');
INSERT INTO `hour_inf` VALUES ('92', '45', '2016-05-31', '2016-05-31 00:00:00');
INSERT INTO `hour_inf` VALUES ('93', '34', '2016-05-31', '2016-05-31 01:00:00');
INSERT INTO `hour_inf` VALUES ('94', '1', '2016-05-31', '2016-05-31 02:00:00');
INSERT INTO `hour_inf` VALUES ('95', '45', '2016-05-31', '2016-05-31 03:00:00');
INSERT INTO `hour_inf` VALUES ('96', '1', '2016-05-31', '2016-05-31 04:00:00');
INSERT INTO `hour_inf` VALUES ('97', '14', '2016-05-31', '2016-05-31 05:00:00');
INSERT INTO `hour_inf` VALUES ('98', '1', '2016-05-31', '2016-05-31 06:00:00');
INSERT INTO `hour_inf` VALUES ('99', '14', '2016-05-31', '2016-05-31 07:00:00');
INSERT INTO `hour_inf` VALUES ('100', '13', '2016-05-31', '2016-05-31 08:00:00');
INSERT INTO `hour_inf` VALUES ('101', '42', '2016-05-31', '2016-05-31 09:00:00');
INSERT INTO `hour_inf` VALUES ('102', '23', '2016-05-31', '2016-05-31 10:00:00');
INSERT INTO `hour_inf` VALUES ('103', '45', '2016-05-31', '2016-05-31 11:00:00');
INSERT INTO `hour_inf` VALUES ('104', '23', '2016-05-31', '2016-05-31 12:00:00');
INSERT INTO `hour_inf` VALUES ('105', '34', '2016-05-31', '2016-05-31 13:00:00');
INSERT INTO `hour_inf` VALUES ('106', '23', '2016-05-31', '2016-05-31 14:00:00');
INSERT INTO `hour_inf` VALUES ('107', '14', '2016-05-31', '2016-05-31 15:00:00');
INSERT INTO `hour_inf` VALUES ('108', '43', '2016-05-31', '2016-05-31 16:00:00');
INSERT INTO `hour_inf` VALUES ('109', '13', '2016-05-31', '2016-05-31 17:00:00');
INSERT INTO `hour_inf` VALUES ('110', '23', '2016-05-31', '2016-05-31 18:00:00');
INSERT INTO `hour_inf` VALUES ('111', '12', '2016-05-31', '2016-05-31 19:00:00');
INSERT INTO `hour_inf` VALUES ('112', '56', '2016-05-31', '2016-05-31 20:00:00');
INSERT INTO `hour_inf` VALUES ('113', '13', '2016-05-31', '2016-05-31 21:00:00');
INSERT INTO `hour_inf` VALUES ('114', '14', '2016-05-31', '2016-05-31 22:00:00');
INSERT INTO `hour_inf` VALUES ('115', '1', '2016-05-31', '2016-05-31 23:00:00');
INSERT INTO `hour_inf` VALUES ('116', '12', '2016-06-01', '2016-06-01 00:00:00');
INSERT INTO `hour_inf` VALUES ('117', '20', '2016-06-01', '2016-06-01 01:00:00');
INSERT INTO `hour_inf` VALUES ('118', '30', '2016-06-01', '2016-06-01 02:00:00');
INSERT INTO `hour_inf` VALUES ('119', '16', '2016-06-01', '2016-06-01 03:00:00');
INSERT INTO `hour_inf` VALUES ('120', '12', '2016-06-01', '2016-06-01 04:00:00');
INSERT INTO `hour_inf` VALUES ('121', '28', '2016-06-01', '2016-06-01 05:00:00');
INSERT INTO `hour_inf` VALUES ('122', '32', '2016-06-01', '2016-06-01 06:00:00');
INSERT INTO `hour_inf` VALUES ('123', '24', '2016-06-01', '2016-06-01 07:00:00');
INSERT INTO `hour_inf` VALUES ('124', '12', '2016-06-01', '2016-06-01 08:00:00');
INSERT INTO `hour_inf` VALUES ('125', '32', '2016-06-01', '2016-06-01 09:00:00');
INSERT INTO `hour_inf` VALUES ('126', '33', '2016-06-01', '2016-06-01 10:00:00');
INSERT INTO `hour_inf` VALUES ('127', '24', '2016-06-01', '2016-06-01 11:00:00');
INSERT INTO `hour_inf` VALUES ('128', '50', '2016-06-01', '2016-06-01 12:00:00');
INSERT INTO `hour_inf` VALUES ('129', '34', '2016-06-01', '2016-06-01 13:00:00');
INSERT INTO `hour_inf` VALUES ('130', '25', '2016-06-01', '2016-06-01 14:00:00');
INSERT INTO `hour_inf` VALUES ('131', '34', '2016-06-01', '2016-06-01 15:00:00');
INSERT INTO `hour_inf` VALUES ('132', '33', '2016-06-01', '2016-06-01 16:00:00');
INSERT INTO `hour_inf` VALUES ('133', '3', '2016-06-01', '2016-06-01 17:00:00');
INSERT INTO `hour_inf` VALUES ('134', '44', '2016-06-01', '2016-06-01 18:00:00');
INSERT INTO `hour_inf` VALUES ('135', '4', '2016-06-01', '2016-06-01 19:00:00');
INSERT INTO `hour_inf` VALUES ('136', '43', '2016-06-01', '2016-06-01 20:00:00');
INSERT INTO `hour_inf` VALUES ('137', '25', '2016-06-01', '2016-06-01 21:00:00');
INSERT INTO `hour_inf` VALUES ('138', '44', '2016-06-01', '2016-06-01 22:00:00');
INSERT INTO `hour_inf` VALUES ('139', '24', '2016-06-01', '2016-06-01 23:00:00');
INSERT INTO `hour_inf` VALUES ('140', '13', '2016-06-02', '2016-06-02 00:00:00');
INSERT INTO `hour_inf` VALUES ('141', '4', '2016-06-02', '2016-06-02 01:00:00');
INSERT INTO `hour_inf` VALUES ('142', '7', '2016-06-02', '2016-06-02 02:00:00');
INSERT INTO `hour_inf` VALUES ('143', '11', '2016-06-02', '2016-06-02 03:00:00');
INSERT INTO `hour_inf` VALUES ('144', '18', '2016-06-02', '2016-06-02 04:00:00');
INSERT INTO `hour_inf` VALUES ('145', '19', '2016-06-02', '2016-06-02 05:00:00');
INSERT INTO `hour_inf` VALUES ('146', '18', '2016-06-02', '2016-06-02 06:00:00');
INSERT INTO `hour_inf` VALUES ('147', '12', '2016-06-02', '2016-06-02 07:00:00');
INSERT INTO `hour_inf` VALUES ('148', '24', '2016-06-02', '2016-06-02 08:00:00');
INSERT INTO `hour_inf` VALUES ('149', '14', '2016-06-02', '2016-06-02 09:00:00');
INSERT INTO `hour_inf` VALUES ('150', '8', '2016-06-02', '2016-06-02 10:00:00');
INSERT INTO `hour_inf` VALUES ('151', '16', '2016-06-02', '2016-06-02 11:00:00');
INSERT INTO `hour_inf` VALUES ('152', '32', '2016-06-02', '2016-06-02 12:00:00');
INSERT INTO `hour_inf` VALUES ('153', '27', '2016-06-02', '2016-06-02 13:00:00');
INSERT INTO `hour_inf` VALUES ('154', '23', '2016-06-02', '2016-06-02 14:00:00');
INSERT INTO `hour_inf` VALUES ('155', '12', '2016-06-02', '2016-06-02 15:00:00');
INSERT INTO `hour_inf` VALUES ('156', '18', '2016-06-02', '2016-06-02 16:00:00');
INSERT INTO `hour_inf` VALUES ('157', '32', '2016-06-02', '2016-06-02 17:00:00');
INSERT INTO `hour_inf` VALUES ('158', '17', '2016-06-02', '2016-06-02 18:00:00');
INSERT INTO `hour_inf` VALUES ('159', '20', '2016-06-02', '2016-06-02 19:00:00');
INSERT INTO `hour_inf` VALUES ('160', '33', '2016-06-02', '2016-06-02 20:00:00');
INSERT INTO `hour_inf` VALUES ('161', '56', '2016-06-02', '2016-06-02 21:00:00');
INSERT INTO `hour_inf` VALUES ('162', '32', '2016-06-02', '2016-06-02 22:00:00');
INSERT INTO `hour_inf` VALUES ('163', '28', '2016-06-02', '2016-06-02 23:00:00');
INSERT INTO `hour_inf` VALUES ('164', '20', '2016-06-03', '2016-06-03 00:00:00');
INSERT INTO `hour_inf` VALUES ('165', '24', '2016-06-03', '2016-06-03 01:00:00');
INSERT INTO `hour_inf` VALUES ('166', '38', '2016-06-03', '2016-06-03 02:00:00');
INSERT INTO `hour_inf` VALUES ('167', '44', '2016-06-03', '2016-06-03 03:00:00');
INSERT INTO `hour_inf` VALUES ('168', '33', '2016-06-03', '2016-06-03 04:00:00');
INSERT INTO `hour_inf` VALUES ('169', '25', '2016-06-03', '2016-06-03 05:00:00');
INSERT INTO `hour_inf` VALUES ('170', '33', '2016-06-03', '2016-06-03 06:00:00');
INSERT INTO `hour_inf` VALUES ('171', '56', '2016-06-03', '2016-06-03 07:00:00');
INSERT INTO `hour_inf` VALUES ('172', '45', '2016-06-03', '2016-06-03 08:00:00');
INSERT INTO `hour_inf` VALUES ('173', '55', '2016-06-03', '2016-06-03 09:00:00');
INSERT INTO `hour_inf` VALUES ('174', '45', '2016-06-03', '2016-06-03 10:00:00');
INSERT INTO `hour_inf` VALUES ('175', '77', '2016-06-03', '2016-06-03 11:00:00');
INSERT INTO `hour_inf` VALUES ('176', '65', '2016-06-03', '2016-06-03 12:00:00');
INSERT INTO `hour_inf` VALUES ('177', '38', '2016-06-03', '2016-06-03 13:00:00');
INSERT INTO `hour_inf` VALUES ('178', '67', '2016-06-03', '2016-06-03 14:00:00');
INSERT INTO `hour_inf` VALUES ('179', '78', '2016-06-03', '2016-06-03 15:00:00');
INSERT INTO `hour_inf` VALUES ('180', '77', '2016-06-03', '2016-06-03 16:00:00');
INSERT INTO `hour_inf` VALUES ('181', '65', '2016-06-03', '2016-06-03 17:00:00');
INSERT INTO `hour_inf` VALUES ('182', '44', '2016-06-03', '2016-06-03 18:00:00');
INSERT INTO `hour_inf` VALUES ('183', '39', '2016-06-03', '2016-06-03 19:00:00');
INSERT INTO `hour_inf` VALUES ('184', '66', '2016-06-03', '2016-06-03 20:00:00');
INSERT INTO `hour_inf` VALUES ('185', '93', '2016-06-03', '2016-06-03 21:00:00');
INSERT INTO `hour_inf` VALUES ('186', '65', '2016-06-03', '2016-06-03 22:00:00');
INSERT INTO `hour_inf` VALUES ('187', '45', '2016-06-03', '2016-06-03 23:00:00');
INSERT INTO `hour_inf` VALUES ('188', '4', '2016-06-04', '2016-06-04 00:00:00');
INSERT INTO `hour_inf` VALUES ('189', '4', '2016-06-04', '2016-06-04 01:00:00');
INSERT INTO `hour_inf` VALUES ('190', '4', '2016-06-04', '2016-06-04 02:00:00');
INSERT INTO `hour_inf` VALUES ('191', '4', '2016-06-04', '2016-06-04 03:00:00');
INSERT INTO `hour_inf` VALUES ('192', '4', '2016-06-04', '2016-06-04 04:00:00');
INSERT INTO `hour_inf` VALUES ('193', '4', '2016-06-04', '2016-06-04 05:00:00');
INSERT INTO `hour_inf` VALUES ('194', '4', '2016-06-04', '2016-06-04 06:00:00');
INSERT INTO `hour_inf` VALUES ('195', '4', '2016-06-04', '2016-06-04 07:00:00');
INSERT INTO `hour_inf` VALUES ('196', '4', '2016-06-04', '2016-06-04 08:00:00');
INSERT INTO `hour_inf` VALUES ('197', '4', '2016-06-04', '2016-06-04 09:00:00');
INSERT INTO `hour_inf` VALUES ('198', '4', '2016-06-04', '2016-06-04 10:00:00');
INSERT INTO `hour_inf` VALUES ('199', '4', '2016-06-04', '2016-06-04 11:00:00');
INSERT INTO `hour_inf` VALUES ('200', '4', '2016-06-04', '2016-06-04 12:00:00');
INSERT INTO `hour_inf` VALUES ('201', '4', '2016-06-04', '2016-06-04 13:00:00');
INSERT INTO `hour_inf` VALUES ('202', '4', '2016-06-04', '2016-06-04 14:00:00');
INSERT INTO `hour_inf` VALUES ('203', '4', '2016-06-04', '2016-06-04 15:00:00');
INSERT INTO `hour_inf` VALUES ('204', '4', '2016-06-04', '2016-06-04 16:00:00');
INSERT INTO `hour_inf` VALUES ('205', '4', '2016-06-04', '2016-06-04 17:00:00');
INSERT INTO `hour_inf` VALUES ('206', '4', '2016-06-04', '2016-06-04 18:00:00');
INSERT INTO `hour_inf` VALUES ('207', '4', '2016-06-04', '2016-06-04 19:00:00');
INSERT INTO `hour_inf` VALUES ('208', '4', '2016-06-04', '2016-06-04 20:00:00');
INSERT INTO `hour_inf` VALUES ('209', '4', '2016-06-04', '2016-06-04 21:00:00');
INSERT INTO `hour_inf` VALUES ('210', '4', '2016-06-04', '2016-06-04 22:00:00');
INSERT INTO `hour_inf` VALUES ('211', '4', '2016-06-04', '2016-06-04 23:00:00');
INSERT INTO `hour_inf` VALUES ('212', '4', '2016-06-05', '2016-06-05 00:00:00');
INSERT INTO `hour_inf` VALUES ('213', '4', '2016-06-05', '2016-06-05 01:00:00');
INSERT INTO `hour_inf` VALUES ('214', '4', '2016-06-05', '2016-06-05 02:00:00');
INSERT INTO `hour_inf` VALUES ('215', '4', '2016-06-05', '2016-06-05 03:00:00');
INSERT INTO `hour_inf` VALUES ('216', '4', '2016-06-05', '2016-06-05 04:00:00');
INSERT INTO `hour_inf` VALUES ('217', '4', '2016-06-05', '2016-06-05 05:00:00');
INSERT INTO `hour_inf` VALUES ('218', '4', '2016-06-05', '2016-06-05 06:00:00');
INSERT INTO `hour_inf` VALUES ('219', '4', '2016-06-05', '2016-06-05 07:00:00');
INSERT INTO `hour_inf` VALUES ('220', '4', '2016-06-05', '2016-06-05 08:00:00');
INSERT INTO `hour_inf` VALUES ('221', '4', '2016-06-05', '2016-06-05 09:00:00');
INSERT INTO `hour_inf` VALUES ('222', '4', '2016-06-05', '2016-06-05 10:00:00');
INSERT INTO `hour_inf` VALUES ('223', '4', '2016-06-05', '2016-06-05 11:00:00');
INSERT INTO `hour_inf` VALUES ('224', '4', '2016-06-05', '2016-06-05 12:00:00');
INSERT INTO `hour_inf` VALUES ('225', '4', '2016-06-05', '2016-06-05 13:00:00');
INSERT INTO `hour_inf` VALUES ('226', '4', '2016-06-05', '2016-06-05 14:00:00');
INSERT INTO `hour_inf` VALUES ('227', '4', '2016-06-05', '2016-06-05 15:00:00');
INSERT INTO `hour_inf` VALUES ('228', '4', '2016-06-05', '2016-06-05 16:00:00');
INSERT INTO `hour_inf` VALUES ('229', '4', '2016-06-05', '2016-06-05 17:00:00');
INSERT INTO `hour_inf` VALUES ('230', '4', '2016-06-05', '2016-06-05 18:00:00');
INSERT INTO `hour_inf` VALUES ('231', '4', '2016-06-05', '2016-06-05 19:00:00');
INSERT INTO `hour_inf` VALUES ('232', '4', '2016-06-05', '2016-06-05 20:00:00');
INSERT INTO `hour_inf` VALUES ('233', '4', '2016-06-05', '2016-06-05 21:00:00');
INSERT INTO `hour_inf` VALUES ('234', '4', '2016-06-05', '2016-06-05 22:00:00');
INSERT INTO `hour_inf` VALUES ('235', '4', '2016-06-05', '2016-06-05 23:00:00');
INSERT INTO `hour_inf` VALUES ('236', '4', '2016-06-06', '2016-06-06 00:00:00');
INSERT INTO `hour_inf` VALUES ('237', '4', '2016-06-06', '2016-06-06 01:00:00');
INSERT INTO `hour_inf` VALUES ('238', '4', '2016-06-06', '2016-06-06 02:00:00');
INSERT INTO `hour_inf` VALUES ('239', '4', '2016-06-06', '2016-06-06 03:00:00');
INSERT INTO `hour_inf` VALUES ('240', '4', '2016-06-06', '2016-06-06 04:00:00');
INSERT INTO `hour_inf` VALUES ('241', '4', '2016-06-06', '2016-06-06 05:00:00');
INSERT INTO `hour_inf` VALUES ('242', '4', '2016-06-06', '2016-06-06 06:00:00');
INSERT INTO `hour_inf` VALUES ('243', '4', '2016-06-06', '2016-06-06 07:00:00');
INSERT INTO `hour_inf` VALUES ('244', '4', '2016-06-06', '2016-06-06 08:00:00');
INSERT INTO `hour_inf` VALUES ('245', '4', '2016-06-06', '2016-06-06 09:00:00');
INSERT INTO `hour_inf` VALUES ('246', '4', '2016-06-06', '2016-06-06 10:00:00');
INSERT INTO `hour_inf` VALUES ('247', '4', '2016-06-06', '2016-06-06 11:00:00');
INSERT INTO `hour_inf` VALUES ('248', '4', '2016-06-06', '2016-06-06 12:00:00');
INSERT INTO `hour_inf` VALUES ('249', '4', '2016-06-06', '2016-06-06 13:00:00');
INSERT INTO `hour_inf` VALUES ('250', '4', '2016-06-06', '2016-06-06 14:00:00');
INSERT INTO `hour_inf` VALUES ('251', '4', '2016-06-06', '2016-06-06 15:00:00');
INSERT INTO `hour_inf` VALUES ('252', '4', '2016-06-06', '2016-06-06 16:00:00');
INSERT INTO `hour_inf` VALUES ('253', '4', '2016-06-06', '2016-06-06 17:00:00');
INSERT INTO `hour_inf` VALUES ('254', '4', '2016-06-06', '2016-06-06 18:00:00');
INSERT INTO `hour_inf` VALUES ('255', '4', '2016-06-06', '2016-06-06 19:00:00');
INSERT INTO `hour_inf` VALUES ('256', '4', '2016-06-06', '2016-06-06 20:00:00');
INSERT INTO `hour_inf` VALUES ('257', '4', '2016-06-06', '2016-06-06 21:00:00');
INSERT INTO `hour_inf` VALUES ('258', '4', '2016-06-06', '2016-06-06 22:00:00');
INSERT INTO `hour_inf` VALUES ('259', '4', '2016-06-06', '2016-06-06 23:00:00');
INSERT INTO `hour_inf` VALUES ('260', '4', '2016-06-07', '2016-06-07 00:00:00');
INSERT INTO `hour_inf` VALUES ('261', '4', '2016-06-07', '2016-06-07 01:00:00');
INSERT INTO `hour_inf` VALUES ('262', '4', '2016-06-07', '2016-06-07 02:00:00');
INSERT INTO `hour_inf` VALUES ('263', '4', '2016-06-07', '2016-06-07 03:00:00');
INSERT INTO `hour_inf` VALUES ('264', '4', '2016-06-07', '2016-06-07 04:00:00');

-- ----------------------------
-- Table structure for username_inf
-- ----------------------------
DROP TABLE IF EXISTS `username_inf`;
CREATE TABLE `username_inf` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_infor` varchar(255) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_pass` varchar(50) NOT NULL,
  `user_phone` varchar(18) NOT NULL,
  `user_sex` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of username_inf
-- ----------------------------
INSERT INTO `username_inf` VALUES ('3', '我', '周天晓', '123456', '15295600981', '0');
INSERT INTO `username_inf` VALUES ('8', '嘻嘻', '天天', '123456', '15275800941', '0');
INSERT INTO `username_inf` VALUES ('9', '应该', '本', '123459', '18115785354', '0');
INSERT INTO `username_inf` VALUES ('10', '拉加', '周一', '123456', '15195990613', '1');
INSERT INTO `username_inf` VALUES ('11', '邋遢', '王五', '123456', '14851596087', '1');
INSERT INTO `username_inf` VALUES ('12', '哈哈哒', '莱尔', '123456', '14789678211', '0');
INSERT INTO `username_inf` VALUES ('13', '来吧哦到来', '哈哈西', '123456', '15289500771', '0');
INSERT INTO `username_inf` VALUES ('15', '小小', '滴滴', '123456', '15748609952', '1');
INSERT INTO `username_inf` VALUES ('16', '付出', '啦啦拉', '123456', '18798005845', '0');
INSERT INTO `username_inf` VALUES ('17', '流程', '天哦天还来', '123456', '15740896548', '0');
INSERT INTO `username_inf` VALUES ('18', '天句句子', '得意', '123456', '14708006856', '1');
INSERT INTO `username_inf` VALUES ('20', '付出', '狮子座', '123456', '16408907868', '0');
INSERT INTO `username_inf` VALUES ('21', '德德', '拉拉西', '123456', '15170894807', '0');
INSERT INTO `username_inf` VALUES ('23', '哦哦哦', '天1234', '123456', '18975423158', '1');
