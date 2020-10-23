DROP SCHEMA IF EXISTS `transaction`;

CREATE SCHEMA IF NOT EXISTS `transaction`;

USE `transaction`;

CREATE TABLE `info` (
	`id` VARCHAR(255) NOT NULL PRIMARY KEY,
    `date` DATETIME NOT NUll,
    `amount` DOUBLE NOT NULL,
    `merchant` VARCHAR(255) NOT NULL,
    `type` VARCHAR(255) NOT NULL
);

INSERT INTO `info` (`id`, `date`, `amount`, `merchant`, `type`)
VALUES ('WLMFRDGD', '2018-08-20 12:45:33', 59.99, 'Kwik E-Mart', 'PAYMENT');

INSERT INTO `info` (`id`, `date`, `amount`, `merchant`, `type`)
VALUES ('YGXKOEIA', '2018-08-20 12:46:17', 10.95, 'Kwik E-Mart', 'PAYMENT');

INSERT INTO `info` (`id`, `date`, `amount`, `merchant`, `type`)
VALUES ('LFVCTEYM', '2018-08-20 12:50:02', 5.00, 'MacLaren', 'PAYMENT');

INSERT INTO `info` (`id`, `date`, `amount`, `merchant`, `type`)
VALUES ('SUOVOISP', '2018-08-20 13:12:22', 5.00, 'Kwik E-Mart', 'PAYMENT');

INSERT INTO `info` (`id`, `date`, `amount`, `merchant`, `type`)
VALUES ('AKNBVHMN', '2018-08-20 13:14:11', 10.95, 'Kwik E-Mart', 'REVERSAL');

INSERT INTO `info` (`id`, `date`, `amount`, `merchant`, `type`)
VALUES ('JYAPKZFZ', '2018-08-20 14:07:10', 99.50, 'MacLaren', 'PAYMENT');




