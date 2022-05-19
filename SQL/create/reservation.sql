CREATE TABLE `reservation` (
  `reservation_id` bigint NOT NULL AUTO_INCREMENT,
  `date` datetime(6) DEFAULT NULL,
  `number` int NOT NULL,
  `lesson_id` bigint DEFAULT NULL,
  `parent_id` bigint DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `FK3rw3m062ihh4c9g2kj22vukk5` (`lesson_id`),
  KEY `FKse9uxg456ufnmnhudr8rt06lw` (`parent_id`),
  CONSTRAINT `FK3rw3m062ihh4c9g2kj22vukk5` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`lesson_id`),
  CONSTRAINT `FKse9uxg456ufnmnhudr8rt06lw` FOREIGN KEY (`parent_id`) REFERENCES `parent` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;