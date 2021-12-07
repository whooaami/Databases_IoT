USE students;

DROP PROCEDURE IF EXISTS InsertGroup;

DELIMITER //
CREATE PROCEDURE InsertGroup(
	name_of_group VARCHAR(45),
    number INT,
    date_income DATE
)
BEGIN
	INSERT INTO student_group(name_of_group, number, date_income)
	VALUES (name_of_group, number, date_income);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS RandomInsertArrear;

DELIMITER //
CREATE PROCEDURE RandomInsertArrear()
BEGIN
	DECLARE str varchar(45);
	DECLARE counter INT;
    DECLARE exist_seed INT;
    DECLARE seed INT;
	SET str = '', counter = 1, seed = RAND();
    label1:WHILE counter < 11 DO
		SET seed = ((seed+RAND()) + 1) + counter;
		IF NOT EXISTS (SELECT student_id FROM arrear WHERE seed = student_id)
		THEN
			SET counter = counter + 1;
            SET str = CONCAT('Noname',seed);
			INSERT INTO arrear(subject_name,student_id) VALUES (str,seed);
		END IF;
	END WHILE;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CreateTableByStudentsNameCursor;

DELIMITER //
CREATE PROCEDURE CreateTableByStudentsNameCursor()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE Name, Surname VARCHAR(45);
    DECLARE StudentsNameCursor CURSOR FOR
    SELECT name, surname FROM student;
    DECLARE CONTINUE HANDLER FOR NOT FOUND
    SET done = TRUE;
    SET @request= 'CREATE TABLE IF NOT EXISTS student_name (id INT AUTO_INCREMENT, name VARCHAR(45), surname VARCHAR(45),PRIMARY KEY (id));';
    PREPARE myQuery FROM @request;
    EXECUTE myQuery;
    OPEN StudentsNameCursor;
    StudentsNameCursorLoop: LOOP
        FETCH StudentsNameCursor INTO Name, Surname;
        IF done = TRUE THEN LEAVE StudentsNameCursorLoop;
        END IF;
        SET @request = CONCAT('INSERT INTO student_name (name, surname) VALUES ("',Name,'","',Surname,'");');
		PREPARE myQuery FROM @request;
		EXECUTE myQuery;
    END LOOP;
    DEALLOCATE PREPARE myQuery;
CLOSE StudentsNameCursor;
END//
DELIMITER ;
