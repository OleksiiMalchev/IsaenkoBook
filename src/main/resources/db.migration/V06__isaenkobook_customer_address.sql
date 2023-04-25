CREATE TABLE customer_address (
    id BIGINT NOT NULL AUTO_INCREMENT,
    customer_id BIGINT,
    country VARCHAR(255),
    city VARCHAR(255),
    address VARCHAR(255),
    post_office VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);