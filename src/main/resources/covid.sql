CREATE DATABASE  IF NOT EXISTS `covid-dashboard` ;
USE `covid-dashboard`;

CREATE TABLE `records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(45) NOT NULL,
  `total_cases` double DEFAULT NULL,
  `new_cases` double DEFAULT NULL,
  `total_deaths` double DEFAULT NULL,
  `new_deaths` double DEFAULT NULL,
  `total_recovered` double DEFAULT NULL,
  `active_cases` double DEFAULT NULL,
  `critical` double DEFAULT NULL,
  `cases_pop` double DEFAULT NULL,
  `deaths-pop` double DEFAULT NULL,
  `first_case` varchar(45)  NULL,
  PRIMARY KEY (`id`)
  ADD UNIQUE INDEX `country_UNIQUE` (`country` ASC);
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8;