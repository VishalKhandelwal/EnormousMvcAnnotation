CREATE TABLE `file_upload` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) DEFAULT NULL,
  `file_type` varchar(100) DEFAULT NULL,
  `file_data` blob,
  `file` longblob,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `filemanager` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `FilePath` varchar(100) DEFAULT NULL,
  `ContentType` varchar(100) DEFAULT NULL,
  `FileSize` float DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci