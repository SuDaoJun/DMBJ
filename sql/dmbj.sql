/*
Navicat MySQL Data Transfer

Source Server         : lying
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2017-10-16 08:23:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dmbj`
-- ----------------------------
DROP TABLE IF EXISTS `dmbj`;
CREATE TABLE `dmbj` (
  `id` varchar(30) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dmbj
-- ----------------------------
INSERT INTO `dmbj` VALUES ('1507943000810', 'e', 'e', '2017-10-14', 'Hello World');
INSERT INTO `dmbj` VALUES ('1508113165921', 'hb', '123', null, null);
INSERT INTO `dmbj` VALUES ('1508113197904', 'hb', null, '2017-10-16', 'The long load');
