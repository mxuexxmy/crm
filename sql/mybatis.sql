/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.5.22 : Database - mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatis` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `mybatis`;

/*Table structure for table `contact` */

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `ct_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户联系人主键',
  `ct_name` varchar(50) NOT NULL COMMENT '姓名',
  `ct_gender` int(11) NOT NULL COMMENT '性别。0-女；1-男',
  `ct_phone` varchar(30) NOT NULL COMMENT '联系电话',
  `ct_title` varchar(100) DEFAULT NULL COMMENT '职位',
  `ct_notes` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `cus_no` int(11) NOT NULL COMMENT '客户编号',
  PRIMARY KEY (`ct_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `contact` */

insert  into `contact`(`ct_id`,`ct_name`,`ct_gender`,`ct_phone`,`ct_title`,`ct_notes`,`cus_no`) values 
(1,'张三',1,'13567890987','经理','爱喝酒',1),
(2,'李四',0,'13356789876','','爱唱歌',1),
(3,'王五',1,'13056781356',NULL,NULL,2);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `cus_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `cus_name` varchar(100) NOT NULL COMMENT '客户名称',
  `cus_region` int(11) NOT NULL COMMENT '客户地区。1-东北；2-西北；3-华北；4-华中；5-华南；6-西南；7-华东',
  `cus_url` varchar(200) DEFAULT NULL COMMENT '客户网址',
  `cus_level` int(11) NOT NULL COMMENT '客户等级。1-战略合作伙伴；2-VIP客户；3-大客户；4-普通客户',
  `cus_credit` int(11) NOT NULL COMMENT '信用等级，5级为最高等级。1-一级；2-二级；3-三级；4-四级；5-五级',
  PRIMARY KEY (`cus_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `customer` */

insert  into `customer`(`cus_no`,`cus_name`,`cus_region`,`cus_url`,`cus_level`,`cus_credit`) values 
(5,'中国银行',5,'www.iibc.com',1,5),
(37,'1',1,'1',1,3),
(38,'2',2,'2',2,3),
(39,'3',2,'3',2,3),
(40,'4',2,'4',2,4),
(41,'5',3,'5',3,4),
(42,'6',2,'6',1,4);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`department_name`) values 
(1,'AA');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int(2) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
