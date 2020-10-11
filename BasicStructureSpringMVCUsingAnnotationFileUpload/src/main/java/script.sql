CREATE TABLE `test`.`file_upload` (
  `file_id` INT NOT NULL AUTO_INCREMENT,
  `file_name` VARCHAR(100) NULL,
  `file_type` VARCHAR(100) NULL,
  `file_data` BLOB NULL,
  PRIMARY KEY (`file_id`));