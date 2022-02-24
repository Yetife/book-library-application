create database if not exists book_db;

create user if not exists 'book_user'@'localhost' identified by 'Book@123';
grant all privileges on book_db.* to 'book_user'@'localhost';
flush privileges;