CREATE TABLE `lesson` (
  `lesson_id` bigint NOT NULL AUTO_INCREMENT,
  `current_num` int NOT NULL DEFAULT '0',
  `lesson_name` varchar(255) DEFAULT NULL,
  `max_num` int NOT NULL DEFAULT '20',
  `island_id` bigint DEFAULT NULL,
  PRIMARY KEY (`lesson_id`),
  KEY `FK2ej7b0mmau3xjup2w9wt0wglg` (`island_id`),
  CONSTRAINT `FK2ej7b0mmau3xjup2w9wt0wglg` FOREIGN KEY (`island_id`) REFERENCES `island` (`island_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;