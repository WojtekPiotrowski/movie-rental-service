insert into user (ID, EMAIL, PASSWORD, USERNAME, ADDRESS_ID) values ('1', 'javastartsping@gmail.com', 'admin', 'Klient1', null);
insert into user (ID, EMAIL, PASSWORD, USERNAME, ADDRESS_ID) values ('2', 'javastartsping@gmail.com', 'pass' , 'Admin', null);

insert into address (id, city, first_name, house_number, last_name, street, street_number, zip_code, user_id) values ('22', 'Warszawa', 'Jan', '15', 'Kowalski', 'Woronicza', '15', '06-500', '1');
insert into address (id, city, first_name, house_number, last_name, street, street_number, zip_code, user_id) values ('23', 'Wrocław', 'Krystyna', '5', 'Krystyńska', 'Pamiętna', '1', '02-450', '2');

update user set address_id = '22' where id = '1';
update user set address_id = '23' where id = '2';

insert into movie (id, average_rating, description, genre, number_of_ratings, price, release_date, title) values ('100', '8.76', 'Adaptacja opowiadania Stephena Kinga. Niesłusznie skazany na dożywocie bankier stara się przetrwać w brutalnym więziennym świecie', 'DRAMA', '12', '0', '1994-10-10', 'Skazani na Shawshank');
insert into movie (id, average_rating, description, genre, number_of_ratings, price, release_date, title) values ('200', '8.7', 'Sparaliżowany milioner zatrudnia do opieki młodego chłopaka z przedmieścia który właśnie wyszedł z więzienia.', 'COMEDY', '14' , '0',  '2011-01-01', 'Nietykalni');
insert into movie (id, average_rating, description, genre, number_of_ratings, price, release_date, title) values ('300', '8.6', 'Emerytowany strażnik więzienny opowiada przyjaciółce o niezwykłym mężczyźnie którego skazano na śmierć za zabójstwo dwóch 9-letnich dziewczynek.', 'DRAMA', '45', '0', '1999-01-01', 'Zielona mila');
insert into movie (id, average_rating, description, genre, number_of_ratings, price, release_date, title) values ('400', '8.0', 'Targany niesłusznymi wyrzutami sumienia po śmierci ojca mały lew Simba skazuje się na wygnanie rezygnując z przynależnego mu miejsca na czele stada.', 'FAMILY', '42', '0', '1994-01-01', 'Król Lew');
insert into movie (id, average_rating, description, genre, number_of_ratings, price, release_date, title) values ('500', '8.1', 'Potężny Thanos zbiera Kamienie Nieskończoności w celu narzucenia swojej woli wszystkim istnieniom we wszechświecie. Tylko drużyna superbohaterów znanych jako Avengers może go powstrzymać.', 'FANTASY', '45', '0', '2018-01-01', ' Avengers: Wojna bez granic');
insert into movie (id, average_rating, description, genre, number_of_ratings, price, release_date, title) values ('600', '8.2', 'Stary mężczyzna czyta chorej na Alzheimera kobiecie pamiętnik opisujący historię miłości dziewczyny z zamożnego domu i ubogiego pracownika tartaku.', 'ROMANCE', '75', '0', '2004-01-01', 'Pamiętnik');


insert into copy_movie (id, is_available) values ('101', 'true');
insert into copy_movie (id, is_available) values ('102', 'true');
insert into copy_movie (id, is_available) values ('103', 'true');
insert into copy_movie (id, is_available) values ('201', 'false');
insert into copy_movie (id, is_available) values ('202', 'true');
insert into copy_movie (id, is_available) values ('203', 'false');
insert into copy_movie (id, is_available) values ('204', 'false');
insert into copy_movie (id, is_available) values ('205', 'false');
insert into copy_movie (id, is_available) values ('301', 'true');
insert into copy_movie (id, is_available) values ('405', 'true');
insert into copy_movie (id, is_available) values ('402', 'false');
insert into copy_movie (id, is_available) values ('403', 'false');
insert into copy_movie (id, is_available) values ('404', 'false');
insert into copy_movie (id, is_available) values ('501', 'true');
insert into copy_movie (id, is_available) values ('502', 'true');
insert into copy_movie (id, is_available) values ('601', 'true');


