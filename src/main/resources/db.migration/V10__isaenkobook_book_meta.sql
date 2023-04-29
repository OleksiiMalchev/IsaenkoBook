CREATE TABLE book_meta (
  id BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  background_image VARCHAR(255),
  book_hero_title VARCHAR(255),
  book_hero_text TEXT,
  book_hero_img VARCHAR(255),
  book_info_group_f TEXT,
  book_info_title VARCHAR(255),
  book_info_group_s TEXT,
  p_s VARCHAR(255),
  book_info_ps VARCHAR(255),
  article VARCHAR(255),
  locale VARCHAR(255)
);