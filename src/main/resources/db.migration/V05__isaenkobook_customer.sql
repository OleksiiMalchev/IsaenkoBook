CREATE TABLE customer (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255),
  middle_name VARCHAR(255),
  last_name VARCHAR(255),
  mobile VARCHAR(20),
  email VARCHAR(255),
  PRIMARY KEY (id)
);