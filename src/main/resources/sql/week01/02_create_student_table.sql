USE advanced_java_lab;

DROP TABLE IF EXISTS student;

CREATE TABLE student (
                         RollNo INT PRIMARY KEY,
                         name VARCHAR(50),
                         address VARCHAR(100)
);