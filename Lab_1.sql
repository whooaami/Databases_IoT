-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`vacancy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vacancy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `job_desciption` VARCHAR(45) NOT NULL,
  `project_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`candidate_cv`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`candidate_cv` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `job` VARCHAR(45) NULL,
  `work_experience` VARCHAR(45) NULL,
  `place_of_study` VARCHAR(45) NULL,
  `experience_of_candidatecol` VARCHAR(45) NULL,
  `hobby` VARCHAR(45) NULL,
  `skills` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`technical_interview`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`technical_interview` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `programming_language` VARCHAR(45) NOT NULL,
  `algorithm` VARCHAR(45) NOT NULL,
  `data_structure` VARCHAR(45) NULL,
  `database` VARCHAR(45) NOT NULL,
  `result_interview` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`english_interview`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`english_interview` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `level_of_technical` VARCHAR(45) NULL,
  `level_of_speaking` VARCHAR(45) NULL,
  `general_level` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`coment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`coment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rating` VARCHAR(45) NULL,
  `response` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`interview_mark`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`interview_mark` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `level` ENUM('excellent', 'good', 'satisfactory') NOT NULL,
  `coments_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_interview_mark_coments1`
    FOREIGN KEY (`coments_id`)
    REFERENCES `mydb`.`coment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_interview_mark_coments1_idx` ON `mydb`.`interview_mark` (`coments_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`potential_candidate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`potential_candidate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `github` VARCHAR(45) NULL,
  `linkedin` VARCHAR(45) NULL,
  `candidate_cv_id` INT NOT NULL,
  `technical_interview_id` INT NOT NULL,
  `english_interview_id` INT NOT NULL,
  `interview_mark_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_potential_candidate_candidate_cv1`
    FOREIGN KEY (`candidate_cv_id`)
    REFERENCES `mydb`.`candidate_cv` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_potential_candidate_technical_interview1`
    FOREIGN KEY (`technical_interview_id`)
    REFERENCES `mydb`.`technical_interview` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_potential_candidate_english_interview1`
    FOREIGN KEY (`english_interview_id`)
    REFERENCES `mydb`.`english_interview` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_potential_candidate_interview_mark1`
    FOREIGN KEY (`interview_mark_id`)
    REFERENCES `mydb`.`interview_mark` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_potential_candidate_candidate_cv1_idx` ON `mydb`.`potential_candidate` (`candidate_cv_id` ASC) VISIBLE;

CREATE INDEX `fk_potential_candidate_technical_interview1_idx` ON `mydb`.`potential_candidate` (`technical_interview_id` ASC) VISIBLE;

CREATE INDEX `fk_potential_candidate_english_interview1_idx` ON `mydb`.`potential_candidate` (`english_interview_id` ASC) VISIBLE;

CREATE INDEX `fk_potential_candidate_interview_mark1_idx` ON `mydb`.`potential_candidate` (`interview_mark_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`contact_person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`contact_person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`vacancy_has_contact_person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vacancy_has_contact_person` (
  `vacancy_id` INT NOT NULL,
  `contact_person_id` INT NOT NULL,
  PRIMARY KEY (`vacancy_id`, `contact_person_id`),
  CONSTRAINT `fk_vacancy_has_contact_person_vacancy`
    FOREIGN KEY (`vacancy_id`)
    REFERENCES `mydb`.`vacancy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacancy_has_contact_person_contact_person1`
    FOREIGN KEY (`contact_person_id`)
    REFERENCES `mydb`.`contact_person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_vacancy_has_contact_person_contact_person1_idx` ON `mydb`.`vacancy_has_contact_person` (`contact_person_id` ASC) VISIBLE;

CREATE INDEX `fk_vacancy_has_contact_person_vacancy_idx` ON `mydb`.`vacancy_has_contact_person` (`vacancy_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`vacancy_has_potential_candidate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vacancy_has_potential_candidate` (
  `vacancy_id` INT NOT NULL,
  `potential_candidate_id` INT NOT NULL,
  PRIMARY KEY (`vacancy_id`, `potential_candidate_id`),
  CONSTRAINT `fk_vacancy_has_potential_candidate_vacancy1`
    FOREIGN KEY (`vacancy_id`)
    REFERENCES `mydb`.`vacancy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacancy_has_potential_candidate_potential_candidate1`
    FOREIGN KEY (`potential_candidate_id`)
    REFERENCES `mydb`.`potential_candidate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_vacancy_has_potential_candidate_potential_candidate1_idx` ON `mydb`.`vacancy_has_potential_candidate` (`potential_candidate_id` ASC) VISIBLE;

CREATE INDEX `fk_vacancy_has_potential_candidate_vacancy1_idx` ON `mydb`.`vacancy_has_potential_candidate` (`vacancy_id` ASC) VISIBLE;

USE `mydb` ;

-- -----------------------------------------------------
-- Placeholder table for view `mydb`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`view1` (`id` INT);

-- -----------------------------------------------------
-- View `mydb`.`view1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`view1`;
USE `mydb`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
