create TABLE book (
       id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
       author_id BIGINT NOT NULL,
       title VARCHAR(128) DEFAULT NULL,
       cover VARCHAR(128) DEFAULT NULL,
       language VARCHAR(128) DEFAULT NULL,
       format_book VARCHAR(128) DEFAULT NULL,
       price DECIMAL(7,2) DEFAULT NULL,
 FOREIGN KEY (author_id) REFERENCES author (id));