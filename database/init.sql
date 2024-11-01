-- MySQL Script generated by MySQL Workbench
-- Ср 18 окт 2023 14:51:42
-- Model: New Model    Version: 1.0
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
create database if not exists javafxTest;
use javafxTest;


-- -----------------------------------------------------
-- Table `mydb`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `javafxTest`.`client` (
  `id_client` INT NOT NULL,
  ` surname` VARCHAR(45) NULL,
  ` name` VARCHAR(45) NULL,
  ` telefon` INT NULL,
  `city` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `e-mail` VARCHAR(45) NULL,
  PRIMARY KEY (`id_client`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`oplata`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `javafxTest`.`oplata` (
  `id` INT NOT NULL,
  ` №_zakaza` INT NULL,
  `summa_oplaty` INT NOT NULL,
  `pometka_ob_oplate` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`zakaz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `javafxTest`.`zakaz` (
  `№_zakaza` INT NOT NULL,
  ` id_client` INT NULL,
  ` data` DATE NULL,
  `summa_oplata` INT NULL,
  `client_id_client` INT NOT NULL,
  `oplata_kod` INT NOT NULL,
  PRIMARY KEY (`№_zakaza`),
  INDEX `fk_zakaz_client_idx` (`client_id_client` ASC) VISIBLE,
  INDEX `fk_zakaz_oplata1_idx` (`oplata_kod` ASC) VISIBLE,
  CONSTRAINT `fk_zakaz_client`
    FOREIGN KEY (`client_id_client`)
    REFERENCES `mydb`.`client` (`id_client`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_zakaz_oplata1`
    FOREIGN KEY (`oplata_kod`)
    REFERENCES `javafxTest`.`oplata` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`proizvoditel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `javafxTest`.`proizvoditel` (
  `id_proizvoditel` INT NOT NULL,
  ` proizvoditel` VARCHAR(45) NULL,
  ` telefon` INT NULL,
  ` city` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `e-mail` VARCHAR(45) NULL,
  PRIMARY KEY (`id_proizvoditel`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.` tovar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `javafxTest`.` tovar` (
  `id_tovara` INT NOT NULL,
  `proizvoditel` VARCHAR(45) NULL,
  ` name` VARCHAR(45) NULL,
  `tsena` INT NULL,
  `kolichestvo_tovara` VARCHAR(45) NULL,
  `proizvoditel_id_proizvoditel` INT NOT NULL,
  PRIMARY KEY (`id_tovara`),
  INDEX `fk_ tovar_proizvoditel1_idx` (`proizvoditel_id_proizvoditel` ASC) VISIBLE,
  CONSTRAINT `fk_ tovar_proizvoditel1`
    FOREIGN KEY (`proizvoditel_id_proizvoditel`)
    REFERENCES `mydb`.`proizvoditel` (`id_proizvoditel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`detali_zakaza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `javafxTest`.`detali_zakaza` (
  `id` INT NOT NULL,
  ` №_zakaza` INT NULL,
  `id_tovara` INT NULL,
  `kolichestvo_tovara` INT NULL,
  `zakaz_№_zakaza` INT NOT NULL,
  ` tovar_id_tovara` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_detali_zakaza_zakaz1_idx` (`zakaz_№_zakaza` ASC) VISIBLE,
  INDEX `fk_detali_zakaza_ tovar1_idx` (` tovar_id_tovara` ASC) VISIBLE,
  CONSTRAINT `fk_detali_zakaza_zakaz1`
    FOREIGN KEY (`zakaz_№_zakaza`)
    REFERENCES `javafxTest`.`zakaz` (`№_zakaza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detali_zakaza_ tovar1`
    FOREIGN KEY (` tovar_id_tovara`)
    REFERENCES `javafxTest`.` tovar` (`id_tovara`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
