DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    PROCEDURE `advancejavapractical`.`add_student`()
    IN nam VARCHAR(20),
    IN passwd VARCHAR(20),
    IN email VARCHAR(20),
    IN address VARCHAR(20),
    IN phone_number DECIMAL(10),
    IN id INT
	BEGIN
	INSERT INTO student (nam, passwd, email, address, phone_number, id)
	VALUES (nam, passwd, email, address, phone_number, id);
	END$$

DELIMITER ;