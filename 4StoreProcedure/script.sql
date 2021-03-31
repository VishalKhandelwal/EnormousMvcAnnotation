-- Create Table
CREATE TABLE `emp99` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `SALARY` float DEFAULT NULL,
  `DESIGNATION` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- save Procedure
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `saveEmp99`(IN empName VARCHAR(50),IN empSalary FLOAT,IN empDesignation VARCHAR(50))
BEGIN
     insert into emp99(name,salary,designation) values(empName,empSalary,empDesignation);
END$$
DELIMITER ;

-- update pocedure
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateEmp99`(IN empId int,IN empName VARCHAR(50),IN empSalary FLOAT,IN empDesignation VARCHAR(50))
BEGIN
     update emp99 set name=empName,salary=empSalary,designation=empDesignation where id=empId;
END$$
DELIMITER ;

-- delete procedure
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteEmp99ById`(IN empId int)
BEGIN
     delete from emp99 where id = empId;
END$$
DELIMITER ;

-- get employee By id Procedure
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEmp99ById`(IN empId int)
BEGIN
     select * from emp99 where id = empId;
END$$
DELIMITER ;

--getAll Employee
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllEmp99`()
BEGIN
select * from emp99;
END$$
DELIMITER ;

