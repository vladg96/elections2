-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema elections
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema elections
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `elections` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `elections` ;

-- -----------------------------------------------------
-- Table `elections`.`Party`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `elections`.`Party` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `elections`.`Politicians`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `elections`.`Politicians` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `Party_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `Party_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Politicians_Party_idx` (`Party_id` ASC) VISIBLE,
  CONSTRAINT `fk_Politicians_Party`
    FOREIGN KEY (`Party_id`)
    REFERENCES `elections`.`Party` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `elections`.`Votes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `elections`.`Votes` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `CPR` VARCHAR(45) NOT NULL,
  `Politicians_id` INT UNSIGNED NOT NULL,
  `Party_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `Politicians_id`, `Party_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `CPR_UNIQUE` (`CPR` ASC) VISIBLE,
  INDEX `fk_Votes_Politicians1_idx` (`Politicians_id` ASC) VISIBLE,
  INDEX `fk_Votes_Party1_idx` (`Party_id` ASC) VISIBLE,
  CONSTRAINT `fk_Votes_Politicians1`
    FOREIGN KEY (`Politicians_id`)
    REFERENCES `elections`.`Politicians` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Votes_Party1`
    FOREIGN KEY (`Party_id`)
    REFERENCES `elections`.`Party` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
