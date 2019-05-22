use musicbd;

insert into singer(first_name, last_name, birth_date)
    value ('John', 'Mayer', '1977-10-16');
insert into singer(first_name, last_name, birth_date)
    value ('Eric', 'Clapton', '1945-03-30');
insert into singer(first_name, last_name, birth_date)
    value ('John', 'Butler', '1875-04-01');

insert into album(singer_id, title, release_date)
    value (1, 'The Search For Everything', '2017-01-20');
insert into album(singer_id, title, release_date)
    value (1, 'Battle Studies', '2009-11-17');
insert into album(singer_id, title, release_date)
    value (2, 'From The Cradle', '1994-09-13');