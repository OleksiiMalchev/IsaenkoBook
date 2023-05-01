ALTER TABLE book
CHANGE COLUMN format_book format_book_uk VARCHAR(255),
ADD COLUMN format_book_en VARCHAR(255),
ADD COLUMN format_book_ru VARCHAR(255);