USE advanced_java_lab;

DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
                          emp_id INT PRIMARY KEY,
                          emp_name VARCHAR(100),
                          salary DOUBLE
);

INSERT INTO employee VALUES
                         (201, 'Ravi', 45000),
                         (202, 'Sneha', 50000),
                         (203, 'Anil', 55000);

SELECT * FROM employee;