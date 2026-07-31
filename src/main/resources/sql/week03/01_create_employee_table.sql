USE advanced_java_lab;

DROP TABLE IF EXISTS employee;

CREATE TABLE employee(
                         id INT PRIMARY KEY,
                         name VARCHAR(50),
                         salary DOUBLE
);