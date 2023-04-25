CREATE TABLE orders (
  id bigint NOT NULL AUTO_INCREMENT,
  customer_id bigint NOT NULL,
  created_at datetime DEFAULT NULL,
  change_at datetime DEFAULT NULL,
  order_status varchar(128) DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (customer_id) REFERENCES customer (id)
);
