DROP DATABASE IF EXISTS students;
CREATE DATABASE IF NOT EXISTS students;
USE students;

DROP TABLE IF EXISTS student;
CREATE TABLE student (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  surname VARCHAR(45) NOT NULL,
  birthday_date DATE NOT NULL,
  income_date DATE NOT NULL,
  number_student_ticket VARCHAR(9) NOT NULL,
  email VARCHAR(45) NOT NULL,
  city_id INT NOT NULL,
  student_group_id INT NOT NULL,
  student_has_arrear_id INT NULL,
  PRIMARY KEY (id),
  UNIQUE (number_student_ticket));

DROP TABLE IF EXISTS city;
CREATE TABLE city (
  id INT NOT NULL AUTO_INCREMENT,
  city VARCHAR(45) NOT NULL,
  region_id INT NOT NULL,
  PRIMARY KEY (id));

DROP TABLE IF EXISTS region;
CREATE TABLE region (
  id INT NOT NULL AUTO_INCREMENT,
  region VARCHAR(45) NOT NULL,
  zip INT NOT NULL,
  PRIMARY KEY (id));

DROP TABLE IF EXISTS arrear;
CREATE TABLE arrear (
  id INT NOT NULL AUTO_INCREMENT,
  subject_name VARCHAR(45) NOT NULL,
  student_has_arrear_id INT NOT NULL,
  PRIMARY KEY (id));

DROP TABLE IF EXISTS student_group;
CREATE TABLE student_group (
  id INT NOT NULL AUTO_INCREMENT,
  name_of_group VARCHAR(45) NOT NULL,
  number INT NOT NULL,
  date_income DATE NOT NULL,
  PRIMARY KEY (id));

DROP TABLE IF EXISTS student_has_arrear;
CREATE TABLE student_has_arrear (
  id INT NOT NULL AUTO_INCREMENT,
  student_id INT NOT NULL,
  arrear_id INT NOT NULL,
  PRIMARY KEY (id));
  