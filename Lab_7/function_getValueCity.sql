USE students;

DROP function IF EXISTS GetValueFromCityStudens;

DELIMITER //
CREATE FUNCTION GetValueFromCityStudens(studentID int)
RETURNS varchar(45)
DETERMINISTIC
BEGIN
    RETURN (SELECT city FROM city WHERE id = ANY(SELECT city_id FROM student where id = studentID));
END//
DELIMITER ;

SELECT *,GetValueFromCityStudens(id) FROM student;
