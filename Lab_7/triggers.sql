-- region

DROP TRIGGER IF EXISTS regionCheckDeleteFK;
DELIMITER //
CREATE TRIGGER regionCheckDeleteFK
BEFORE DELETE
ON region FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT region_id from city))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Can`t delete region some city still have fk to region";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS regionCheckUpdateFK;
DELIMITER //
CREATE TRIGGER regionCheckUpdateFK
BEFORE UPDATE
ON region FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT region_id from city))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Can`t update region some city still have fk to region";
    END IF;
END //
DELIMITER ;

-- city
-- insert
DROP TRIGGER IF EXISTS cityCheckInsertFK;
DELIMITER //
CREATE TRIGGER cityCheckInsertFK
BEFORE INSERT
ON city FOR EACH ROW
BEGIN
	IF (new.region_id NOT IN (SELECT id from region))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Check city for insert no such region id";
    END IF;
END //
DELIMITER ;

-- update

DROP TRIGGER IF EXISTS cityCheckUpdateFK;
DELIMITER //
CREATE TRIGGER cityCheckUpdateFK
BEFORE UPDATE
ON city FOR EACH ROW
BEGIN
	IF (new.region_id NOT IN (SELECT id from region))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Can`t update city no such region id";
    END IF;
    IF (old.id  IN (SELECT city_id from school))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Can`t update city some school still have fk to city";
    END IF;
    IF (old.id  IN (SELECT city_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Can`t update city some student still have fk to city";
    END IF;
END //
DELIMITER ;

-- delete

DROP TRIGGER IF EXISTS cityCheckDeleteFK;
DELIMITER //
CREATE TRIGGER cityCheckDeleteFK
BEFORE DELETE
ON city FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT city_id from school))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Can`t delete city some school still have fk to city";
    END IF;
    IF (old.id IN (SELECT city_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Can`t delete city some student still have fk to city";
    END IF;
END //
DELIMITER ;

-- student
-- insert

DROP TRIGGER IF EXISTS studentCheckInsertFK;
DELIMITER //
CREATE TRIGGER studentCheckInsertFK
BEFORE INSERT
ON student FOR EACH ROW
BEGIN
	IF (new.id NOT IN (SELECT student_id from student_has_arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
    IF (new.student_has_arrear_id NOT IN (SELECT student_id from student_has_arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
	IF (new.city_id NOT IN (SELECT id from city))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such city";
    END IF;
    IF (new.student_group_id NOT IN (SELECT id from student_group))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such student_group";
    END IF;
END //
DELIMITER ;

-- update

DROP TRIGGER IF EXISTS studentCheckUpdateFK;
DELIMITER //
CREATE TRIGGER studentCheckUpdateFK
BEFORE UPDATE
ON student FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT student_id from student_has_arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Can`t update student some arrear still have fk to student";
    END IF;
    IF (new.id NOT IN (SELECT student_id from student_has_arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Can`t update student some arrear still have fk to student";
    END IF;
	IF (new.city_id NOT IN (SELECT id from city))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such city";
    END IF;
    IF (new.student_group_id NOT IN (SELECT id from student_group))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such student_group";
    END IF;
END //
DELIMITER ;

-- delete

DROP TRIGGER IF EXISTS studentCheckDeleteFK;
DELIMITER //
CREATE TRIGGER studentCheckDeleteFK
BEFORE DELETE
ON student FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT student_id from student_has_arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Can`t update student some student_has_arrear still have fk to student";
    END IF;
    IF (old.student_has_arrear_id IN (SELECT student_id from student_has_arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Can`t update student some student_has_arrear still have fk to student";
    END IF;
END //
DELIMITER ;

-- arrear
-- insert

DROP TRIGGER IF EXISTS arrearCheckInsertFK;
DELIMITER //
CREATE TRIGGER arrearCheckInsertFK
BEFORE INSERT
ON arrear FOR EACH ROW
BEGIN
	IF (new.id NOT IN (SELECT arrear_id from student_has_arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
    IF (new.student_has_arrear_id NOT IN (SELECT arrear_id from student_has_arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
END //
DELIMITER ;

-- update

DROP TRIGGER IF EXISTS arrearCheckUpdateFK;
DELIMITER //
CREATE TRIGGER arrearCheckUpdateFK
BEFORE UPDATE
ON arrear FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT arrear_id from student_has_arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
    
    IF (new.id NOT IN (SELECT arrear_id from student_has_arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
END //
DELIMITER ;

-- delete

DROP TRIGGER IF EXISTS arrearCheckDeleteFK;
DELIMITER //
CREATE TRIGGER arrearCheckDeleteFK
BEFORE DELETE
ON arrear FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT arrear_id from student_has_arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
    
    IF (old.student_has_arrear_id IN (SELECT arrear_id from student_has_arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
END //
DELIMITER ;

-- student_has_arrear
-- insert
-- update

DROP TRIGGER IF EXISTS studentHasArrearCheckUpdateFK;
DELIMITER //
CREATE TRIGGER studentHasArrearCheckUpdateFK
BEFORE Update
ON arrear FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT student_has_arrear_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
    IF (old.id IN (SELECT student_has_arrear_id from arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
    IF (new.id NOT IN (SELECT student_has_arrear_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
    IF (new.id NOT IN (SELECT student_has_arrear_id from arrear))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
END //
DELIMITER ;

-- student_group
-- update

DROP TRIGGER IF EXISTS studentGroupCheckInsertFK;
DELIMITER //
CREATE TRIGGER studentGroupCheckInsertFK
BEFORE UPDATE
ON student_group FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT student_group_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
END //
DELIMITER ;

-- delete

DROP TRIGGER IF EXISTS studentGroupCheckDeleteFK;
DELIMITER //
CREATE TRIGGER studentGroupCheckDeleteFK
BEFORE DELETE
ON student_group FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT student_group_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such arrear";
    END IF;
END //
DELIMITER ;

-- trigger task

DROP TRIGGER IF EXISTS studentTicketFornat;
DELIMITER //
CREATE TRIGGER studentTicketFornat
BEFORE INSERT
ON student FOR EACH ROW
BEGIN
	IF new.number_student_ticket NOT REGEXP '[^SEL][0-6,8-9]{8}'
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Number of ticket format invalid";
    END IF;
   
END //
DELIMITER ;

-- email validate trigger

DROP TRIGGER IF EXISTS studentTicketFornat;
DELIMITER //
CREATE TRIGGER studentTicketFornat
BEFORE INSERT
ON student FOR EACH ROW
BEGIN
	IF new.email LIKE('.ua')
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Email format invalid";
    END IF;
   
END //
DELIMITER ;

-- block update

DROP TRIGGER IF EXISTS regionCheckUpdateFK;
DELIMITER //
CREATE TRIGGER regionCheckUpdateFK
BEFORE UPDATE
ON region FOR EACH ROW
BEGIN
	SIGNAL SQLSTATE "45000"
	SET MESSAGE_TEXT = "Can`t update region some city still have fk to region";
END //
DELIMITER ;
