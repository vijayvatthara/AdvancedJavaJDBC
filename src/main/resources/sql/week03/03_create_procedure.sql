USE advanced_java_lab;

DROP PROCEDURE IF EXISTS UpdateSalary;

DELIMITER $$

CREATE PROCEDURE UpdateSalary(
    IN empId INT,
    IN newSalary DOUBLE
)
BEGIN
    UPDATE employee
    SET salary = newSalary
    WHERE id = empId;
END $$

DELIMITER ;