/*
Navicat MySQL Data Transfer

Source Server         : WindowsMySql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : jfinal_demo

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-05-31 22:22:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `publishTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '十万个为什么', 'Story', '2016-05-31 20:44:25');
INSERT INTO `blog` VALUES ('2', null, null, null);
INSERT INTO `blog` VALUES ('3', '牛叉电影', '发觉了高科技啊看了感觉了卡机了', null);
INSERT INTO `blog` VALUES ('4', '加勒比海盗', '经典电影', null);

-- ----------------------------
-- Table structure for blog2
-- ----------------------------
DROP TABLE IF EXISTS `blog2`;
CREATE TABLE `blog2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `publishTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of blog2
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户唯一识别id',
  `uname` varchar(20) CHARACTER SET utf8 NOT NULL,
  `upwd` varchar(20) NOT NULL,
  `usex` varchar(2) CHARACTER SET utf8 NOT NULL,
  `uemail` varchar(30) NOT NULL,
  `remark` text,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'nixinsheng', '123', '男', '1911398892@qq.com', 'info of mine');
INSERT INTO `user` VALUES ('2', '倪新生', '123', '男', '19...', 'mine');
