-- DDL Task 1: Create the structure
CREATE DATABASE school_db CHARACTER SET utf8mb4;
USE school_db;

SET SESSION sql_safe_updates = 0;

CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    age INT NOT NULL,
    city VARCHAR(50) DEFAULT 'Delhi',
    admission_date DATE,
    CONSTRAINT chk_students_name CHECK (CHAR_LENGTH(TRIM(name)) > 0),
    CONSTRAINT chk_students_age CHECK (age >= 5)
) ENGINE = InnoDB;

-- DDL Task 2: Modify the structure
CREATE TABLE marks (
    mark_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    subject VARCHAR(30) NOT NULL,
    score INT NOT NULL,
    CONSTRAINT fk_marks_student FOREIGN KEY (student_id)
        REFERENCES students (student_id) ON DELETE RESTRICT
) ENGINE = InnoDB;

ALTER TABLE students ADD COLUMN phone VARCHAR(10);
ALTER TABLE students MODIFY COLUMN phone VARCHAR(15);
ALTER TABLE students RENAME COLUMN city TO hometown;
CREATE INDEX idx_students_name ON students (name);
CREATE TABLE students_backup LIKE students;
DROP TABLE students_backup;

-- DML Task 1: Insert data
INSERT INTO students (student_id, name, email, age, admission_date)
VALUES (1, 'Aarav Sharma', 'aarav@example.com', 12, '2025-04-01');

INSERT INTO students (student_id, name, email, age, hometown, admission_date)
VALUES
    (2, 'Diya Gupta', 'diya@example.com', 15, 'Ghaziabad', '2025-04-01'),
    (3, 'Ananya Singh', 'ananya@example.com', 10, 'Delhi', '2025-04-02'),
    (4, 'Kabir Verma', 'kabir@example.com', 16, 'Noida', '2025-04-02'),
    (5, 'Meera Joshi', 'meera@example.com', 13, 'Jaipur', '2025-04-03'),
    (6, 'Rohan Mehta', 'rohan@example.com', 11, 'Delhi', '2025-04-03');

INSERT INTO marks (mark_id, student_id, subject, score)
VALUES
    (1, 1, 'Maths', 82), (2, 1, 'Science', 78), (3, 1, 'English', 72),
    (4, 2, 'Maths', 89), (5, 2, 'Science', 91), (6, 2, 'English', 85),
    (7, 3, 'Maths', 55), (8, 3, 'Science', 65), (9, 3, 'English', 18),
    (10, 4, 'Maths', 75), (11, 4, 'Science', 68), (12, 4, 'English', 76),
    (13, 6, 'Maths', 58), (14, 6, 'English', 62);


DELIMITER $$
CREATE PROCEDURE demo_duplicate_student_email()
BEGIN
    DECLARE error_text TEXT;
    DECLARE EXIT HANDLER FOR 1062
    BEGIN
        GET DIAGNOSTICS CONDITION 1 error_text = MESSAGE_TEXT;
        SELECT 1062 AS mysql_error, error_text AS error_message;
    END;
    INSERT INTO students (name, email, age)
    VALUES ('Duplicate Student', 'aarav@example.com', 12);
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Expected duplicate email error';
END$$
DELIMITER ;

CALL demo_duplicate_student_email();
DROP PROCEDURE demo_duplicate_student_email;

-- DML Task 2: Update and delete
UPDATE marks SET score = score + 5 WHERE subject = 'Maths';
UPDATE students SET hometown = 'Noida' WHERE student_id = 2;
UPDATE students SET age = age + 1 WHERE hometown = 'Delhi';

DELIMITER $$
CREATE PROCEDURE demo_restricted_student_delete()
BEGIN
    DECLARE error_text TEXT;
    DECLARE EXIT HANDLER FOR 1451
    BEGIN
        GET DIAGNOSTICS CONDITION 1 error_text = MESSAGE_TEXT;
        SELECT 1451 AS mysql_error, error_text AS error_message;
    END;
    DELETE FROM students WHERE student_id = 6;
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Expected foreign key error';
END$$
DELIMITER ;

CALL demo_restricted_student_delete();
DROP PROCEDURE demo_restricted_student_delete;
SELECT * FROM marks WHERE student_id = 6;

-- Delete the dependent marks first, then remove the student.
START TRANSACTION;
DELETE FROM marks WHERE student_id = 6;
DELETE FROM students WHERE student_id = 6;
COMMIT;

DELETE FROM marks WHERE score < 20;

-- DQL Task 1: Filtering and sorting
SELECT * FROM students ORDER BY student_id;

SELECT name AS `Student Name`, hometown
FROM students
ORDER BY student_id;

SELECT * FROM students WHERE age BETWEEN 10 AND 15 ORDER BY student_id;
SELECT * FROM students WHERE name LIKE 'A%' ORDER BY student_id;

SELECT *
FROM students
WHERE hometown IN ('Delhi', 'Noida')
ORDER BY age DESC, student_id;

SELECT * FROM students ORDER BY age DESC, student_id LIMIT 3;
SELECT DISTINCT hometown FROM students ORDER BY hometown;

-- DQL Task 2: Aggregates and joins
SELECT hometown, COUNT(*) AS student_count
FROM students
GROUP BY hometown
ORDER BY hometown;

SELECT subject, AVG(score) AS average_score, MAX(score) AS highest_score,
       MIN(score) AS lowest_score
FROM marks
GROUP BY subject
ORDER BY subject;

SELECT subject, AVG(score) AS average_score
FROM marks
GROUP BY subject
HAVING AVG(score) > 60
ORDER BY subject;

SELECT s.name, m.subject, m.score
FROM students AS s
INNER JOIN marks AS m ON m.student_id = s.student_id
ORDER BY s.student_id, m.subject;

SELECT s.name, m.subject, m.score
FROM students AS s
LEFT JOIN marks AS m ON m.student_id = s.student_id
ORDER BY s.student_id, m.subject;

SELECT s.student_id, s.name
FROM students AS s
WHERE s.student_id IN (
    SELECT student_id
    FROM marks
    WHERE score > (SELECT AVG(score) FROM marks)
)
ORDER BY s.student_id;

WITH student_totals AS (
    SELECT s.student_id, s.name, COALESCE(SUM(m.score), 0) AS total_marks
    FROM students AS s
    LEFT JOIN marks AS m ON m.student_id = s.student_id
    GROUP BY s.student_id, s.name
)
SELECT student_id, name, total_marks,
       RANK() OVER (ORDER BY total_marks DESC) AS marks_rank
FROM student_totals
ORDER BY marks_rank, student_id;

-- TCL Task 1: Commit and rollback
SET @original_autocommit = @@SESSION.autocommit;
SET autocommit = 0;

START TRANSACTION;
UPDATE marks SET score = 100 WHERE mark_id = 1;
SELECT 'Before rollback' AS stage, score FROM marks WHERE mark_id = 1;
ROLLBACK;
-- ROLLBACK restores the original score of 87.
SELECT 'After rollback' AS stage, score FROM marks WHERE mark_id = 1;

START TRANSACTION;
UPDATE marks SET score = 100 WHERE mark_id = 1;
SELECT 'Before commit' AS stage, score FROM marks WHERE mark_id = 1;
COMMIT;
-- COMMIT persists 100.
SELECT 'After commit' AS stage, score FROM marks WHERE mark_id = 1;

-- TCL Task 2: Savepoints
START TRANSACTION;

INSERT INTO students (name, email, age, admission_date)
VALUES ('Ishaan Rao', 'ishaan@example.com', 12, CURRENT_DATE);
SET @first_savepoint_student = LAST_INSERT_ID();
SAVEPOINT s1;

INSERT INTO students (name, email, age, admission_date)
VALUES ('Tara Das', 'tara@example.com', 14, CURRENT_DATE);
SET @second_savepoint_student = LAST_INSERT_ID();
SAVEPOINT s2;

DELETE FROM marks WHERE mark_id = 3;
ROLLBACK TO SAVEPOINT s2;
-- Both student inserts remain and mark 3 is restored.
SELECT student_id, name
FROM students
WHERE student_id IN (@first_savepoint_student, @second_savepoint_student)
ORDER BY student_id;
SELECT * FROM marks WHERE mark_id = 3;

ROLLBACK TO SAVEPOINT s1;
-- Only Ishaan's insert remains. Mark 3 is still present.
SELECT student_id, name
FROM students
WHERE student_id IN (@first_savepoint_student, @second_savepoint_student)
ORDER BY student_id;
SELECT * FROM marks WHERE mark_id = 3;
COMMIT;
SET autocommit = @original_autocommit;

-- DCL Task 1: Create users and grant access
CREATE USER 'teacher1'@'localhost' IDENTIFIED BY 'Teacher1!Demo5wQ';
GRANT SELECT, INSERT, UPDATE ON school_db.marks TO 'teacher1'@'localhost';
SHOW GRANTS FOR 'teacher1'@'localhost';

-- DCL Task 2: Revoke and roles
REVOKE UPDATE ON school_db.marks FROM 'teacher1'@'localhost';
SHOW GRANTS FOR 'teacher1'@'localhost';

CREATE ROLE 'viewer';
GRANT SELECT ON school_db.* TO 'viewer';
SHOW GRANTS FOR 'viewer';

CREATE USER 'guest1'@'localhost' IDENTIFIED BY 'Guest1!Demo6zK';
GRANT 'viewer' TO 'guest1'@'localhost';
SET DEFAULT ROLE 'viewer' TO 'guest1'@'localhost';
SHOW GRANTS FOR 'guest1'@'localhost' USING 'viewer';

DROP USER 'teacher1'@'localhost', 'guest1'@'localhost';

-- Data Types and Constraints Task 1: Choose the right type
CREATE TABLE library_books (
    title VARCHAR(255) NOT NULL,
    isbn CHAR(13) CHARACTER SET ascii COLLATE ascii_bin PRIMARY KEY,
    price DECIMAL(10, 2) UNSIGNED NOT NULL,
    number_of_copies INT UNSIGNED NOT NULL DEFAULT 0,
    available BOOLEAN NOT NULL,
    category ENUM('Fiction', 'Science', 'History') NOT NULL,
    published_year YEAR,
    description LONGTEXT,
    CONSTRAINT chk_books_isbn CHECK (isbn REGEXP '^[0-9]{13}$'),
    CONSTRAINT chk_books_available CHECK (available IN (0, 1)),
    CONSTRAINT chk_books_category CHECK (category IN ('Fiction', 'Science', 'History'))
) ENGINE = InnoDB;

-- Data Types and Constraints Task 2: Constraints
CREATE TABLE teachers (
    teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    joining_date DATE NOT NULL DEFAULT (CURRENT_DATE),
    CONSTRAINT chk_teachers_salary CHECK (salary > 0)
) ENGINE = InnoDB;

INSERT INTO teachers (email, name, salary)
VALUES ('asha@example.com', 'Asha Sharma', 45000.00);

-- Each block captures the expected error from one invalid INSERT.
DELIMITER $$
CREATE PROCEDURE demo_teacher_constraints()
BEGIN
    DECLARE error_text TEXT;

    -- Error 1062 (23000): Duplicate entry for the unique email.
    BEGIN
        DECLARE EXIT HANDLER FOR 1062
        BEGIN
            GET DIAGNOSTICS CONDITION 1 error_text = MESSAGE_TEXT;
            SELECT 1062 AS mysql_error, error_text AS error_message;
        END;
        INSERT INTO teachers (email, name, salary)
        VALUES ('asha@example.com', 'Ravi Kumar', 40000.00);
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Expected duplicate email error';
    END;

    -- Error 1048 (23000): Column 'name' cannot be null.
    BEGIN
        DECLARE EXIT HANDLER FOR 1048
        BEGIN
            GET DIAGNOSTICS CONDITION 1 error_text = MESSAGE_TEXT;
            SELECT 1048 AS mysql_error, error_text AS error_message;
        END;
        INSERT INTO teachers (email, name, salary)
        VALUES ('ravi@example.com', NULL, 40000.00);
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Expected NOT NULL error';
    END;

    -- Error 3819 (HY000): Check constraint 'chk_teachers_salary' is violated.
    BEGIN
        DECLARE EXIT HANDLER FOR 3819
        BEGIN
            GET DIAGNOSTICS CONDITION 1 error_text = MESSAGE_TEXT;
            SELECT 3819 AS mysql_error, error_text AS error_message;
        END;
        INSERT INTO teachers (email, name, salary)
        VALUES ('ravi@example.com', 'Ravi Kumar', 0.00);
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Expected salary check error';
    END;
END$$
DELIMITER ;

CALL demo_teacher_constraints();
DROP PROCEDURE demo_teacher_constraints;
SELECT * FROM teachers ORDER BY teacher_id;

