CREATE TABLE `island` (
  `island_id` bigint NOT NULL AUTO_INCREMENT,
  `island_name` varchar(255) DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  PRIMARY KEY (`island_id`),
  KEY `FKop5gaolgiacf8xnsivk1ologo` (`address_id`),
  CONSTRAINT `FKop5gaolgiacf8xnsivk1ologo` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;