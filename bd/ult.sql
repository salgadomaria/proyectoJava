-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema esibd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema esibd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `esibd` DEFAULT CHARACTER SET utf8 ;
USE `esibd` ;

-- -----------------------------------------------------
-- Table `esibd`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `esibd`.`categoria` (
  `nombreCategoria` VARCHAR(30) NOT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`nombreCategoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esibd`.`jornadas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `esibd`.`jornadas` (
  `referenteInstitucional` VARCHAR(20) NOT NULL,
  `objetivo` VARCHAR(45) NOT NULL,
  `tituloJornada` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tituloJornada`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esibd`.`materiales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `esibd`.`materiales` (
  `tituloMaterial` VARCHAR(45) NOT NULL,
  `nomCategoria` VARCHAR(30) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `fuente` VARCHAR(45) NOT NULL,
  `enlaceDocumento` VARCHAR(45) NOT NULL,
  `prioritario` VARCHAR(3) NULL DEFAULT NULL,
  `procedencia` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`tituloMaterial`),
  INDEX `nombreCategoria_idx` (`nomCategoria` ASC) VISIBLE,
  CONSTRAINT `nomCategoria`
    FOREIGN KEY (`nomCategoria`)
    REFERENCES `esibd`.`categoria` (`nombreCategoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esibd`.`materialesjornadas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `esibd`.`materialesjornadas` (
  `tituloMaterial` VARCHAR(45) NOT NULL,
  `tituloJornadas` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tituloMaterial`),
  INDEX `tituloJornadas_idx` (`tituloJornadas` ASC) ,
  CONSTRAINT `tituloJornadas`
    FOREIGN KEY (`tituloJornadas`)
    REFERENCES `esibd`.`jornadas` (`tituloJornada`),
  CONSTRAINT `tituloMateriales`
    FOREIGN KEY (`tituloMaterial`)
    REFERENCES `esibd`.`materiales` (`tituloMaterial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esibd`.`propuestas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `esibd`.`propuestas` (
  `origen` VARCHAR(20) NOT NULL,
  `nombreCategoria` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NULL DEFAULT NULL,
  `fecha` DATE NOT NULL,
  `tituloPropuesta` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `motivacion` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(10) NULL DEFAULT NULL,
  `motivoRechazo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`tituloPropuesta`),
  INDEX `nombreCategoria_idx` (`nombreCategoria` ASC) VISIBLE,
  CONSTRAINT `nombreCategoria`
    FOREIGN KEY (`nombreCategoria`)
    REFERENCES `esibd`.`categoria` (`nombreCategoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `esibd`.`materialpropuestas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `esibd`.`materialpropuestas` (
  `tituloPropuesta` VARCHAR(45) NOT NULL,
  `tituloMaterial` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tituloPropuesta`),
  INDEX `tituloPropuesta_idx` (`tituloPropuesta` ASC) VISIBLE,
  CONSTRAINT `tituloMaterial`
    FOREIGN KEY (`tituloMaterial`)
    REFERENCES `esibd`.`materiales` (`tituloMaterial`),
  CONSTRAINT `tituloPropuesta`
    FOREIGN KEY (`tituloPropuesta`)
    REFERENCES `esibd`.`propuestas` (`tituloPropuesta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
