
<!-----------Show all data-------------------------------------!>
DELIMITER //
CREATE PROCEDURE getAllEmp99()
BEGIN
     select * from emp99;
END //

DELIMITER ;

<!-----------get Single data-------------------------------------!>
DELIMITER //
CREATE PROCEDURE getEmp99ById(IN empId int)
BEGIN
     select * from emp99 where id = empId;
END //


<!-----------insert data-------------------------------------!>
DELIMITER //
CREATE PROCEDURE saveEmp99(IN empName VARCHAR(50),IN empSalary FLOAT,IN empDesignation VARCHAR(50))
BEGIN
     insert into emp99(name,salary,designation) values(empName,empSalary,empDesignation);
END //

DELIMITER ;

<!-----------update data-------------------------------------!>
DELIMITER //
CREATE PROCEDURE updateEmp99(IN empId int,IN empName VARCHAR(50),IN empSalary FLOAT,IN empDesignation VARCHAR(50))
BEGIN
     update emp99 set name=empName,salary=empSalary,designation=empDesignation where id=empId;
END //

DELIMITER ;

<!-----------delete data-------------------------------------!>
DELIMITER //
CREATE PROCEDURE deleteEmp99ById(IN empId int)
BEGIN
     delete from emp99 where id = empId;
END //

DELIMITER ;

<!-----------Create Table-------------------------------------!>
DELIMITER //
CREATE PROCEDURE getEmp99NameAndSalaryById(IN empId int,OUT empSalary FLOAT,OUT empName VARCHAR(50))
BEGIN
     select name,salary into empName,empSalary from emp99 where id = empId;
END //

DELIMITER ;

CALL getEmp99NameAndSalaryById(1,@empSalary,@empName);
select @empSalary,@empName;

<!-----------Create Table-------------------------------------!>
CREATE TABLE `emp99` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `SALARY` float DEFAULT NULL,
  `DESIGNATION` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

