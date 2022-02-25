set foreign_key_checks = 0;

truncate table book;

insert into book (id, title, author, page_count, year_of_publishing)
values(12, 'Think big', 'Ben Carson', 201, 2015),
      (13, 'Good Morning Holyspirit', 'Benny Hinn', 156, 2005),
      (14, 'Java Programming', 'Deitel Deitel', 321, 2000);

insert into user_wish_list(id)
values(105),
(106);

insert into book_user(id, first_name, last_name, email, wish_list_id)
values (510, 'John', 'Doe', 'john@gmail.com', 105),
(511, 'Henry', 'Thomas', 'henry@gmail.com', 106);

set foreign_key_checks = 1;
