CREATE TABLE `history` (
  `history_id` bigint NOT NULL AUTO_INCREMENT,
  `activity` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `lesson_id` bigint DEFAULT NULL,
  `parent_id` bigint DEFAULT NULL,
  PRIMARY KEY (`history_id`),
  KEY `FK6wtcgd2wxppn81a0ncnb6xaky` (`lesson_id`),
  KEY `FKardbv27xfkqsh3trn2crwn22k` (`parent_id`),
  CONSTRAINT `FK6wtcgd2wxppn81a0ncnb6xaky` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`lesson_id`),
  CONSTRAINT `FKardbv27xfkqsh3trn2crwn22k` FOREIGN KEY (`parent_id`) REFERENCES `parent` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;