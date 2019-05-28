CREATE DATABASE `sigi` /*!40100 DEFAULT CHARACTER SET latin1 */;
CREATE TABLE `user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `isActive` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `audit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `eventId` bigint(3) NOT NULL,
  `creationDate` datetime NOT NULL,
  `responsibleId` varchar(45) NOT NULL,
  `responsibleType` varchar(45) NOT NULL,
  `remoteIp` varchar(45) NOT NULL,
  `tableName` varchar(45) NOT NULL,
  `registerId` varchar(45) NOT NULL,
  `originalValues` text,
  `newValues` text,
  `extra` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_audit_event1` (`eventId`),
  CONSTRAINT `fk_audit_event1` FOREIGN KEY (`eventId`) REFERENCES `event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `country` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `shortName` varchar(5) DEFAULT NULL,
  `code` varchar(5) DEFAULT NULL,
  `alternativeName1` varchar(255) DEFAULT NULL,
  `alternativeName2` varchar(255) DEFAULT NULL,
  `alternativeName3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=latin1;

CREATE TABLE `country_translation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryId` bigint(3) NOT NULL,
  `languageId` int(3) NOT NULL,
  `alias` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dist_country_traslation_country` (`countryId`),
  KEY `FK_dist_country_traslation_language` (`languageId`),
  CONSTRAINT `FK_dist_country_traslation_country` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`),
  CONSTRAINT `FK_dist_country_traslation_language` FOREIGN KEY (`languageId`) REFERENCES `language` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=360 DEFAULT CHARSET=latin1;

CREATE TABLE `currency` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `symbol` varchar(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `enterprise` (
  `id` int(3) NOT NULL,
  `currencyId` int(3) NOT NULL,
  `countryId` bigint(3) NOT NULL,
  `name` varchar(45) NOT NULL,
  `url` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `atcNumber` varchar(45) NOT NULL,
  `address` varchar(255) NOT NULL,
  `invoiceAddress` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `infoEmail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_enterprise_currency1` (`currencyId`),
  KEY `fk_enterprise_country1` (`countryId`),
  CONSTRAINT `fk_enterprise_country1` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`),
  CONSTRAINT `fk_enterprise_currency1` FOREIGN KEY (`currencyId`) REFERENCES `currency` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `event` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `language` (
  `id` int(3) NOT NULL,
  `iso` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `permission` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `permissionGroupId` bigint(3) NOT NULL,
  `action` varchar(45) NOT NULL,
  `entity` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_constraint_permission_permissionGroup1` (`permissionGroupId`),
  CONSTRAINT `fk_constraint_permission_permissionGroup1` FOREIGN KEY (`permissionGroupId`) REFERENCES `permission_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `permission_data` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `permissionId` bigint(3) NOT NULL,
  `languageId` int(3) NOT NULL,
  `alias` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_permission_data_permission1` (`permissionId`),
  KEY `fk_permission_data_language1` (`languageId`),
  CONSTRAINT `fk_permission_data_language1` FOREIGN KEY (`languageId`) REFERENCES `language` (`id`),
  CONSTRAINT `fk_permission_data_permission1` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `permission_group` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `permission_group_data` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `permissionGroupId` bigint(3) NOT NULL,
  `languageId` int(3) NOT NULL,
  `alias` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_permission_group_data_permission_group1` (`permissionGroupId`),
  KEY `fk_permission_group_data_language1` (`languageId`),
  CONSTRAINT `fk_permission_group_data_language1` FOREIGN KEY (`languageId`) REFERENCES `language` (`id`),
  CONSTRAINT `fk_permission_group_data_permission_group1` FOREIGN KEY (`permissionGroupId`) REFERENCES `permission_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `permission_has_profile` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `permissionId` bigint(3) NOT NULL,
  `profileId` bigint(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_permission_has_profile_profile1` (`profileId`),
  KEY `fk_permission_has_profile_permission1` (`permissionId`),
  CONSTRAINT `fk_permission_has_profile_permission1` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`),
  CONSTRAINT `fk_permission_has_profile_profile1` FOREIGN KEY (`profileId`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `profile` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `profile_data` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `profileId` bigint(3) NOT NULL,
  `languageId` int(3) NOT NULL,
  `alias` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_profile_data_profile1` (`profileId`),
  KEY `fk_profile_data_language1` (`languageId`),
  CONSTRAINT `fk_profile_data_language1` FOREIGN KEY (`languageId`) REFERENCES `language` (`id`),
  CONSTRAINT `fk_profile_data_profile1` FOREIGN KEY (`profileId`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `provider` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `isActive` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `user_has_profile` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `profileId` bigint(3) NOT NULL,
  `enterpriseId` int(3) NOT NULL,
  `userId` bigint(10) NOT NULL,
  `beginningDate` datetime NOT NULL,
  `endingDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_has_profile_has_enterprise_profile1` (`profileId`),
  KEY `fk_user_has_profile_has_enterprise_enterprise1` (`enterpriseId`),
  KEY `fk_user_has_profile_has_enterprise_user1` (`userId`),
  CONSTRAINT `fk_user_has_profile_has_enterprise_enterprise1` FOREIGN KEY (`enterpriseId`) REFERENCES `enterprise` (`id`),
  CONSTRAINT `fk_user_has_profile_has_enterprise_profile1` FOREIGN KEY (`profileId`) REFERENCES `profile` (`id`),
  CONSTRAINT `fk_user_has_profile_has_enterprise_user1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE  `services`.`profile_has_profile` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `parentId` bigint(3) NOT NULL,
  `childId` bigint(3) NOT NULL,
  `beginningDate` datetime NOT NULL,
  `endingDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_profile_has_profile_profile2` (`childId`),
  KEY `fk_profile_has_profile_profile1` (`parentId`),
  CONSTRAINT `fk_profile_has_profile_profile1` FOREIGN KEY (`parentId`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_has_profile_profile2` FOREIGN KEY (`childId`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;