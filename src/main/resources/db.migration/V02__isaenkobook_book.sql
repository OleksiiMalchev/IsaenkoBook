CREATE TABLE book (
  id BIGINT NOT NULL AUTO_INCREMENT,
  author_id BIGINT NOT NULL,
  title VARCHAR(255),
  cover VARCHAR(255),
  language VARCHAR(255),
  format_book VARCHAR(255),
  price DECIMAL(10, 2),
  article VARCHAR(255),
  PRIMARY KEY (id),
  FOREIGN KEY (author_id) REFERENCES author(id)
);


