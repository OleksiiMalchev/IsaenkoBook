create TABLE order_details (
  id bigint NOT NULL AUTO_INCREMENT,
  order_id bigint NOT NULL,
  book_id bigint NOT NULL,
  quantity int DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (order_id) REFERENCES orders (id)
)