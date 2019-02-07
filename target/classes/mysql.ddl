CREATE TABLE `user` (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  phone varchar(50) NOT NULL,
  role varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO `user` (id, name, email, password, phone, role) VALUES (1, 'daniel', 'admin@dc.com', 'admin1010', '555-777-9999', 'Administrator');
