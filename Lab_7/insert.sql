USE students;

INSERT INTO student (
name, 
surname, 
birthday_date, 
income_date, 
number_student_ticket, 
email, 
city_id, 
student_group_id, 
student_has_arrear_id ) 
VALUES
("Ivan", "Ivanov", "2003-03-03", "2020-01-09", 347898393, "ivan3@gmai.com", 1, 1, 1),
("Petro", "Petriv", "2002-02-02", "2019-02-10", 347778444, "petya@gmail.com", 2, 2, 2),
("Maksym", "Maksymiv", "1999-05-05", "2016-03-11", 999999393, "max99@gmail.com", 3, 3, 3);

INSERT INTO city (
city,
region_id
) 
VALUES
("Lviv", 1),
("Kyiv", 2),
("Sambir", 1);

INSERT INTO region (
region,
zip
)
VALUES
("Lvivskiy", 79049),
("Kyivskiy", 78003);

INSERT INTO arrear (
subject_name,
student_has_arrear_id
)
VALUES
("Math", 1),
("Algorithm", 2),
("Database", 3);

INSERT INTO student_group(
name_of_group,
number,
date_income
)
VALUES
("IoT",22,"2020-01-09"),
("Cb",32,"2019-02-10"),
("Ci",43,"2016-03-11");
