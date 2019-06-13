-- create contact table in database
CREATE TABLE contact(
    contactID INTEGER AUTO_INCREMENT,
    name VARCHAR(200),
    phoneNumber VARCHAR(20),
    address VARCHAR(100),
    age SMALLINT,
    CONSTRAINT pk_contactID PRIMARY KEY (contactID)
);
-- insert some data to the table
INSERT INTO contact (name, phoneNumber, address, age)
 VALUES ('David Beck', '0906483596', '702 Nguyen Van Linh', 23),
        ('Thanos', '0906483526', '713 Nguyen Van Linh', 100),
        ('Tony Stank', '0916483526', '723 Nguyen Van Linh', 45),
        ('Steve Roger', '0906482126', '723 Nguyen Van Linh', 100);



