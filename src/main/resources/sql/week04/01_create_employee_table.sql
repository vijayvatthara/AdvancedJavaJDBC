USE advanced_java_lab;

DROP TABLE IF EXISTS employee1;

CREATE TABLE employee1 (
                           emp_id INT PRIMARY KEY,
                           emp_name VARCHAR(100),
                           salary DOUBLE
);

INSERT INTO employee1 VALUES
                          (101, 'Alice', 50000),
                          (102, 'Bob', 55000),
                          (103, 'Charlie', 60000),
                          (104, 'Diana', 65000);

SELECT * FROM employee1;