--User

CREATE TABLE `libsys`.`user` (
  `user_id` INT(11) NOT NULL,
  `name_first` VARCHAR(100) NOT NULL,
  `name_last` VARCHAR(100) NOT NULL,
  `status` VARCHAR(10) NOT NULL DEFAULT 'I',
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin
COMMENT = 'The user table';

ALTER TABLE `libsys`.`user` 
CHANGE COLUMN `user_id` `user_id` INT(11) NOT NULL AUTO_INCREMENT ;


--Books

CREATE TABLE `libsys`.`book` (
  `book_id` INT(11) NOT NULL,
  `isbn` VARCHAR(100) NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  `author` VARCHAR(100) NOT NULL,
  `status` VARCHAR(10) NOT NULL DEFAULT 'I',
  PRIMARY KEY (`book_id`),
  UNIQUE INDEX `isbn_UNIQUE` (`isbn` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin
COMMENT = 'The book table';

ALTER TABLE `libsys`.`book` 
CHANGE COLUMN `book_id` `book_id` INT(11) NOT NULL AUTO_INCREMENT ;


CREATE TABLE `libsys`.`user_book_rel` (
  `user_book_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `book_id` INT(11) NOT NULL,
  `status` VARCHAR(10) NOT NULL DEFAULT 'P',
  `requested_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `issued_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `return_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_book_id`),
  INDEX `user_id_idx` (`user_id` ASC),
  INDEX `book_id_idx` (`book_id` ASC),
  CONSTRAINT `user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `libsys`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `book_id_fk`
    FOREIGN KEY (`book_id`)
    REFERENCES `libsys`.`book` (`book_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'The user-book relation table.';

CREATE TABLE `libsys`.`roles` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NOT NULL,
  `status` VARCHAR(10) NOT NULL DEFAULT 'I',
  PRIMARY KEY (`role_id`),
  INDEX `role_id_idx` (`role_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin
COMMENT = 'The roles table';


CREATE TABLE `libsys`.`role_access` (
  `role_access_id` INT NOT NULL AUTO_INCREMENT,
  `role_id` INT(11) NOT NULL,
  `access` VARCHAR(100) NOT NULL DEFAULT 'LIB',
  PRIMARY KEY (`role_access_id`),
  INDEX `role_id_idx` (`role_id` ASC),
  CONSTRAINT `role_id_fk`
    FOREIGN KEY (`role_id`)
    REFERENCES `libsys`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin
COMMENT = 'The role access table.';

