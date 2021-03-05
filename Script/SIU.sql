DROP DATABASE siu;
CREATE DATABASE siu;
USE siu;

-- -----------------------------------------------------
-- Table `educativo`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE usuario
 (
  id_usuario INT AUTO_INCREMENT,
  username_usuario VARCHAR(45),
  password_usuario VARCHAR(45),
  PRIMARY KEY (id_usuario)
) ENGINE = InnoDB DEFAULT CHARSET=latin1;
-- -----------------------------------------------------
-- Table `educativo`.`Sedes`
-- -----------------------------------------------------
CREATE TABLE sedes
(
  codigo_sede VARCHAR(5),
  nombre_sede VARCHAR(45),
  estatus_sede VARCHAR(1),
  PRIMARY KEY (codigo_sede)
) ENGINE = InnoDB DEFAULT CHARSET=latin1;
