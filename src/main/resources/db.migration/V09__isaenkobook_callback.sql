CREATE TABLE call_back_form (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  email VARCHAR(255),
  message VARCHAR(255),
  callback_status VARCHAR(255),
  PRIMARY KEY (id)
);