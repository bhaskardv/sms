DROP SCHEMA IF EXISTS `sms` ;
CREATE SCHEMA `sms` ;

GRANT ALL PRIVILEGES ON sms.* TO 'admin'@'localhost' IDENTIFIED BY 'admin' WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON sms.* TO 'admin'@'%' IDENTIFIED BY 'admin' WITH GRANT OPTION;

use `sms` ;

--
-- Table structure for table `smsuser`
--
DROP TABLE IF EXISTS `smsuser`;
CREATE TABLE `smsuser` (
  `id` varchar(45) NOT NULL,
  `password` text NOT NULL,
  `name` varchar(100) NOT NULL,
  `emailid` varchar(100) DEFAULT NULL,
  `is_admin` int(2) NOT NULL,
  `created_time` datetime NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sms_user1_idx` (`created_by`),
  CONSTRAINT `fk_sms_user1` FOREIGN KEY (`created_by`) REFERENCES `smsuser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `server`
--
DROP TABLE IF EXISTS `server`;
CREATE TABLE `server` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `serverid` text NOT NULL,
  `ip_address` varchar(45) NOT NULL,
  `created_time` datetime NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_server_sms_user1_idx` (`created_by`),
  CONSTRAINT `fk_server_sms_user1` FOREIGN KEY (`created_by`) REFERENCES `smsuser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `user`
--
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `userid` text NOT NULL,
  `name` varchar(100) NOT NULL,
  `created_time` datetime NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_sms_user1_idx` (`created_by`),
  CONSTRAINT `fk_user_sms_user1` FOREIGN KEY (`created_by`) REFERENCES `smsuser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `domain`
--
DROP TABLE IF EXISTS `domain`;
CREATE TABLE `domain` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `group`
--
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `ugroup`
--
DROP TABLE IF EXISTS `ugroup`;
CREATE TABLE `ugroup` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `authtool`
--
DROP TABLE IF EXISTS `authtool`;
CREATE TABLE `authtool` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `version` varchar(100) NOT NULL,
  `type` enum('SSH','WINRM') NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `server_domain`
--
DROP TABLE IF EXISTS `server_domain`;
CREATE TABLE `server_domain` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `hostname` varchar(100) NOT NULL,  
  `server_id` int(5) NOT NULL,
  `domain_id` int(5) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_server_domain_1` (`server_id`,`domain_id`),
  KEY `fk_server_domain_server1_idx` (`server_id`),
  KEY `fk_server_domain_domain1_idx` (`domain_id`),
  CONSTRAINT `fk_server_domain_server1` FOREIGN KEY (`server_id`) REFERENCES `server` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_server_domain_domain1` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `user_ugroup`
--
DROP TABLE IF EXISTS `user_ugroup`;
CREATE TABLE `user_ugroup` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `user_id` int(5) NOT NULL,
  `ugroup_id` int(5) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_user_ugroup_1` (`user_id`,`ugroup_id`),
  KEY `fk_user_ugroup_user1_idx` (`user_id`),
  KEY `fk_user_ugroup_ugroup1_idx` (`ugroup_id`),
  CONSTRAINT `fk_user_ugroup_user11` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_ugroup_ugroup1` FOREIGN KEY (`ugroup_id`) REFERENCES `ugroup` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `server_authtool`
--
DROP TABLE IF EXISTS `server_authtool`;
CREATE TABLE `server_authtool` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `server_id` int(5) NOT NULL,
  `authtool_id` int(5) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_server_authtool_1` (`server_id`,`authtool_id`),
  KEY `fk_server_authtool_server1_idx` (`server_id`),
  KEY `fk_server_authtool_authtool1_idx` (`authtool_id`),
  CONSTRAINT `fk_server_authtool_server1` FOREIGN KEY (`server_id`) REFERENCES `server` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_server_authtool_authtool1` FOREIGN KEY (`authtool_id`) REFERENCES `authtool` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `server_user`
--
DROP TABLE IF EXISTS `server_user`;
CREATE TABLE `server_user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `server_id` int(5) NOT NULL,
  `user_id` int(5) NOT NULL,
  `password` text NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_server_user_1` (`server_id`,`user_id`),
  KEY `fk_server_user_server1_idx` (`server_id`),
  KEY `fk_server_user_user1_idx` (`user_id`),
  CONSTRAINT `fk_server_user_server1` FOREIGN KEY (`server_id`) REFERENCES `server` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_server_user_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `server_group`
--
DROP TABLE IF EXISTS `server_group`;
CREATE TABLE `server_group` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `server_id` int(5) NOT NULL,
  `group_id` int(5) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_server_group_1` (`server_id`,`group_id`),
  KEY `fk_server_group_server1_idx` (`server_id`),
  KEY `fk_server_group_group1_idx` (`group_id`),
  CONSTRAINT `fk_server_group_server1` FOREIGN KEY (`server_id`) REFERENCES `server` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_server_group_group1` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sms`.`smsuser` (
`id`, 
`password`, 
`name`, 
`emailid`, 
`is_admin`, 
`created_time`,
 `created_by`,
 `status`) VALUES (
 'admin', 
 '$2a$10$Cg8yrs0BlbqUzlKFaUIYWuzytjxhfXFqmRBk.6I36DAO3Cp44wzSy',
 'Administrator', 
 'bhaskard@vedams.com', 
 '1', 
 now(), 
 'admin', 
 '1');