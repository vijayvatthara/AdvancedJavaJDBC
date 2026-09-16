USE advanced_java_lab;

DROP TABLE IF EXISTS students;

CREATE TABLE students (
                          id INT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          course VARCHAR(100) NOT NULL
);

INSERT INTO students (id, name, course) VALUES
                                            (1, 'Divitha', 'B.Tech IT'),
                                            (2, 'Deepu', 'B.Tech CSE'),
                                            (3, 'Nalini', 'B.Tech ECE');

SELECT * FROM students;