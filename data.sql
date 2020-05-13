DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  phone_number VARCHAR(250) DEFAULT NULL,
  version int default 0,
  createdDate timestamp default null,
  createdBy varchar(250) default null,
  updatedDate timestamp default null,
  updatedBy timestamp default null,
  isDeleted int default 0,
  username varchar(250) default null
);

INSERT INTO user (first_name, last_name, phone_number) VALUES
  ('Aliko', 'Dangote', '081809669575');