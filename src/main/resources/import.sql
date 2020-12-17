insert into user (ID, EMAIL, PASSWORD, USER_TYPE, USERNAME, ADDRESS_ID) values ('1', 'javastartsping@gmail.com', 'admin', 'GOLD', 'Klient1', null);
insert into user (ID, EMAIL, PASSWORD, USER_TYPE, USERNAME, ADDRESS_ID) values ('2', 'javastartsping@gmail.com', 'pass', 'SILVER', 'Admin', null);

insert into address (id, city, first_name, house_number, last_name, street, street_number, zip_code, user_id) values ('22', 'Warszawa', 'Jan', '15', 'Kowalski', 'Woronicza', '15', '06-500', '1');
insert into address (id, city, first_name, house_number, last_name, street, street_number, zip_code, user_id) values ('23', 'Wrocław', 'Krystyna', '5', 'Krystyńska', 'Pamiętna', '1', '02-450', '2');

-- update user set address_id = '22' where id = '1';
-- update user set address_id = '23' where id = '2';

insert into role (id, name) values ('1', 'ADMIN');
insert into role (id, name) values ('2', 'USER');

insert into user_role (user_id, role_id) values(1,2);
insert into user_role (user_id, role_id) values(2,1);

insert into movie (id, average_rating, description, genre, number_of_ratings, price, release_date, title) values ('100', '8.76', 'Adaptacja opowiadania Stephena Kinga. Niesłusznie skazany na dożywocie bankier stara się przetrwać w brutalnym więziennym świecie', 'DRAMA', '12', '10', '1994-10-10', 'Skazani na Shawshank');
insert into movie (id, average_rating, description, genre, number_of_ratings, price, release_date, title) values ('200', '8.7', 'Sparaliżowany milioner zatrudnia do opieki młodego chłopaka z przedmieścia który właśnie wyszedł z więzienia.', 'COMEDY', '14' , '15',  '2011-01-01', 'Nietykalni');
insert into movie (id, average_rating, description, genre, number_of_ratings, price, release_date, title) values ('300', '8.6', 'Emerytowany strażnik więzienny opowiada przyjaciółce o niezwykłym mężczyźnie którego skazano na śmierć za zabójstwo dwóch 9-letnich dziewczynek.', 'DRAMA', '45', '5', '1999-01-01', 'Zielona mila');
insert into movie (id, average_rating, description, genre, number_of_ratings, price, release_date, title) values ('400', '8.0', 'Targany niesłusznymi wyrzutami sumienia po śmierci ojca mały lew Simba skazuje się na wygnanie rezygnując z przynależnego mu miejsca na czele stada.', 'FAMILY', '42', '8', '1994-01-01', 'Król Lew');
insert into movie (id, average_rating, description, genre, number_of_ratings, price, release_date, title) values ('500', '8.1', 'Potężny Thanos zbiera Kamienie Nieskończoności w celu narzucenia swojej woli wszystkim istnieniom we wszechświecie. Tylko drużyna superbohaterów znanych jako Avengers może go powstrzymać.', 'FANTASY', '45', '30', '2018-01-01', ' Avengers: Wojna bez granic');
insert into movie (id, average_rating, description, genre, number_of_ratings, price, release_date, title) values ('600', '8.2', 'Stary mężczyzna czyta chorej na Alzheimera kobiecie pamiętnik opisujący historię miłości dziewczyny z zamożnego domu i ubogiego pracownika tartaku.', 'ROMANCE', '75', '12', '2020-12-11', 'Pamiętnik');


insert into copy_movie (id, is_available, movie_id) values ('101', 'true', '100');
insert into copy_movie (id, is_available, movie_id) values ('102', 'true', '100');
insert into copy_movie (id, is_available, movie_id) values ('103', 'true', '100');
insert into copy_movie (id, is_available, movie_id) values ('201', 'false', '200');
insert into copy_movie (id, is_available, movie_id) values ('202', 'true', '200');
insert into copy_movie (id, is_available, movie_id) values ('203', 'false', '200');
insert into copy_movie (id, is_available, movie_id) values ('204', 'false', '200');
insert into copy_movie (id, is_available, movie_id) values ('205', 'false', '200');
insert into copy_movie (id, is_available, movie_id) values ('301', 'true', '300');
insert into copy_movie (id, is_available, movie_id) values ('405', 'true', '400');
insert into copy_movie (id, is_available, movie_id) values ('402', 'false', '400');
insert into copy_movie (id, is_available, movie_id) values ('403', 'false', '400');
insert into copy_movie (id, is_available, movie_id) values ('404', 'false', '400');
insert into copy_movie (id, is_available, movie_id) values ('501', 'true', '500');
insert into copy_movie (id, is_available, movie_id) values ('502', 'true', '500');
insert into copy_movie (id, is_available, movie_id) values ('601', 'true', '600');

insert into order_table (order_id, create_date, delivery_option, order_status) values ('1000', '2020-10-05 09:13:38', 'DHL', 'IN_RETURN');
insert into order_table (order_id, create_date, delivery_option, order_status) values ('2000', '2020-12-05 09:13:38', 'DHL', 'IN_RETURN');
