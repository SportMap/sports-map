CREATE TABLE "address" (
                         id SERIAL PRIMARY KEY,
                         street VARCHAR(255),
                         postal_code VARCHAR(10),
                         building_number VARCHAR(10),
                         apartment_number VARCHAR(10),
                         city VARCHAR(255)
);

CREATE TABLE sport_complexes (
                                 id SERIAL PRIMARY KEY,
                                 name VARCHAR(255) NOT NULL,
                                 description TEXT,
                                 website VARCHAR(255),
                                 surface VARCHAR(255),
                                 category VARCHAR(255),
                                 latitude DECIMAL(8,6),
                                 longitude DECIMAL(9,6),
                                 address_id INT NOT NULL,
                                 open_24_7 BOOLEAN,
                                 FOREIGN KEY (address_id) REFERENCES address(id),
                                 photo VARCHAR(255),
                                 phone_number VARCHAR(15),
                                 status VARCHAR(25)
);

CREATE TABLE opening_hours (
                               id SERIAL PRIMARY KEY,
                               day_of_week INT NOT NULL,
                               opening_time TIME,
                               closing_time TIME,
                               sport_complex_id INT NOT NULL,
                               FOREIGN KEY (sport_complex_id) REFERENCES sport_complexes(id)
);



CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       authority CHAR(16) NOT NULL DEFAULT 'USER',
                       avatar VARCHAR(255)
);
CREATE TABLE events (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        description TEXT,
                        sport_complex_id INT NOT NULL,
                        start_time TIMESTAMP,
                        end_time TIMESTAMP,
                        photo VARCHAR(255),
                        user_id INT NOT NULL,
                        FOREIGN KEY (sport_complex_id) REFERENCES sport_complexes(id),
                        FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE users_events (
                              id SERIAL PRIMARY KEY,
                              user_id INT NOT NULL,
                              event_id INT NOT NULL,
                              FOREIGN KEY (user_id) REFERENCES users(id),
                              FOREIGN KEY (event_id) REFERENCES events(id)
);

CREATE TABLE reviews (
                         id SERIAL PRIMARY KEY,
                         content TEXT,
                         sport_complex_id INT NOT NULL,
                         user_id INT NOT NULL,
                         rate INT NOT NULL,
                         review_date DATE NOT NULL,
                         FOREIGN KEY (sport_complex_id) REFERENCES sport_complexes(id),
                         FOREIGN KEY (user_id) REFERENCES users(id)
);


INSERT INTO address (id, street, postal_code, building_number, apartment_number, city)
VALUES
    (1, 'al. Grunwaldzka', '80-309', '411', '', 'Gdańsk'),
    (2, 'Sienna', '80-605', '37', '', 'Gdańsk'),
    (3, 'al. gen. Józefa Hallera', '80-416', '201', '', 'Gdańsk'),
    (4, 'al. Grunwaldzka', '80-309', '470', '', 'Gdańsk'),
    (5, 'Plac Dominikański', '80-844', '7', '', 'Gdańsk'),
    (6, 'Żabi Kruk ', '80-822', '15', '', 'Gdańsk'),
    (7, 'Zielonogórska', '80-812', '4', '', 'Gdańsk'),
    (8, 'Marszałka Ferdynanda Focha', '80-156', '', '', 'Gdańsk'),
    (9, 'Doki', '80-863 ', '1', '', 'Gdańsk'),
    (10, 'Mikołaja Kopernika', '80-208', '16', '', 'Gdańsk'),
    (11, 'Jacka Malczewskiego', '80-980', '', '', 'Gdańsk'),
    (12, 'Traugutta', '80-221', '29', '', 'Gdańsk'),
    (13, 'ul. Narutowicza', '80-233', '11/12', '', 'Gdańsk'),
    (14, 'Grobla IV', '80-837', '8', '', 'Gdańsk'),
    (15, 'Zawodników', '80-729', '1', 'A', 'Gdańsk'),
    (16, 'Zawodników', '80-980', '1', '', 'Gdańsk'),
    (17, 'Marynarki Polskiej', '80-868', '177', '', 'Gdańsk'),
    (18, 'Marynarki Polskiej', '80-869', '163', '', 'Gdańsk'),
    (19, 'Twarda', '80-871', '6', 'd', 'Gdańsk'),
    (20, 'Salwator', '80-875', '', '', 'Gdańsk'),
    (21, 'Na Stoku', '80-811', '42', 'A', 'Gdańsk')
;

INSERT INTO sport_complexes (
    id, name, description, website, surface, category, latitude, longitude, address_id, open_24_7, photo, phone_number, status
)VALUES
     (1, 'Aquastacja i Sportstacja', 'Aquastacja to pełnowymiarowy basen pływacki z 6 torami, o głębokości 1,20 m do 1,80 m. Dodatkowo znajdują się dwa małe baseny o wymiarach 8x4 m, przeznaczone do nauki pływania niemowląt, dzieci i dorosłych oraz do aquaaerobiku. Strefa saun składa się z sauny suchej, łaźni parowej, laconium, misy do stóp oraz miejsc do schładzania. Sportstacja to multisportowa sala gimnastyczna o powierzchni 630 m2, przeznaczona do piłki nożnej, siatkówki, koszykówki, streetballa, badmintona oraz judo.', 'www.aquastacja.pl', 'TARTAN', 'PŁYWANIE', '54.39922', '18.57646', '1', '0', '1.jpg', '58 764 62 61', 'APPROVED'),
     (2, 'Gdański Klub Wioślarski', 'W naszej ofercie poza prowadzeniem zajęć wioślarskich dla dzieci i młodzieży mamy wynajem obiektów sportowych: hala do gry (piłka halowa, koszykówka, unihokej, siatkówka), siłownia, sala aerobiku, sala ergometrów oraz organizację obozów sportowych. Doskonale wyposażony obiekt sportowy z wyczynową sekcją wioślarską. W ofercie poza prowadzeniem zajęć wioślarskich dla dzieci i młodzieży do dyspozycji podmiotów zewnętrznych wynajmujemy obiekt sportowy: hala do gry (piłka nożna halowa, koszykówka, unihokej, siatkówka), siłownia, sala aerobiku, sala ergometrów oraz organizujemy obozy sportowe. ', 'www.gkw-drakkar.pl', 'TARTAN', 'LEKKOATLETYKA', '54.35748', '18.69177', '2', '0', '2.webp', '58 304 22 66', 'APPROVED'),
     (3, 'Gdański Klub Sportowy Gedania 1922', 'Gedania Gdańsk – najstarszy polski klub piłkarski działający w Gdańsku. Założony 15 sierpnia 1922 jako wielosekcyjny klub sportowy.', 'www.gedania1922.pl', 'TARTAN', 'LEKKOATLETYKA', '54.39702', '18.62312', '3', '0', '3.png', '517517879', 'APPROVED'),
     (4, 'Hala OLIVIA', 'Hala Sportowo-Widowiskowa Olivia znana jest nie tylko w Polsce, ale również poza jej granicami. Powstała w 1970 r.Do dzisiaj jest jedynym obiektem tego typu na Pomorzu. Podmiotem zarządzającym obiektem jest Gdański Klub Sportowy Stoczniowiec. W latach 1995 - 2000 obiekt został zmodernizowany. Obecnie jako jedyny w Polsce dysponuje dwoma zakrytymi lodowiskami i zapleczem sportowym o tak wysokim standardzie.', 'www.stoczniowiec.org.pl', 'LÓD', 'LYŻWIARSTWO', '54.40140', '18.57201', '4', '0', '4.jpg', '58 552 20 91', 'APPROVED'),
     (5, 'Centrum Sportowe U-7', 'Centrum U7 Gdańsk znajduje się w historycznym, poniemieckim bunkrze z 1942 roku. Otwarcie kręgielni nastąpiło 17 stycznia 1997 roku. Jednocześnie była to pierwsza automatyczna kręgielnia w Polsce. Obecnie znajduje się tam:   8 torów bowlingowych,    10 stołów do gry w bilarda (pool),    bogato wyposażony bar,    wygodne sofy i kanapy,    rzutnik wraz ekranem o przekątnej 100 cali.', 'https://www.u7.pl/', 'TARTAN', 'KRĘGLE', '54.35325', '18.65241', '5', '0', '5.jpg', '58 305 55 77', 'APPROVED'),
     (6, 'Klub Wodny Żabi Kruk', 'Wypożyczalnia Kajaków i Sprzętu Wodnego dla Klientów Indywidualnych Zapraszamy do zwiedzania Gdańska z zupełnie innej perspektywy. Wypożyczalnia czynna codziennie od 10:00 do 18:00 Dopasujemy sprzęt do twoich indywidualnych potrzeb. Zaplanuj trasę wycieczki – zadzwoń 58 305 73 10 i płyniesz… Nie ma potrzeby rezerwacji pojedynczych sztuk.', 'https://kajakiempogdansku.pl/', 'ASFALT', 'LEKKOATLETYKA', '54.34239', '18.64825', '6', '0', '6.jpg', '501710010', 'APPROVED'),
     (7, 'Obiekt Sportowy Zielonogórska', 'Ogólnodostępny obiekt sportowy znajduje się na gdańskim Chełmie przy ul. Zielonogórskiej 4 (dojazd autobusami linii 108 lub 118 do przystanku n/ż ul. Stoczniowców). Do dyspozycji mieszkańców są tutaj korty tenisowe, dwa wymiarowe boiska piłkarskie, na których są rozgrywane m.in. mecze ligowe klasy „B” oraz mini skatepark.', 'https://sportgdansk.pl/obiekty/obiekt-sportowy-zielonogorska/', 'TRAWA', 'PIŁKA_NOŻNA', '54.34293', '18.63472', '7', '0', '7.webp', '601653968', 'APPROVED'),
     (8, 'Kort tenisowy', 'brak', 'brak', 'TWARDY_KORT', 'TENIS', '54.35923', '18.62800', '8', '1', '8.jpg', 'brak', 'APPROVED'),
     (9, 'CrossFit Stocznia', 'Nasz Box ma charakter szkoły treningowej, z klasami według poziomu zaawansowania.', 'www.crossfitstocznia.com', 'DREWNIANA_PODŁOGA', 'SPORTY_SIŁOWE', '54.36180', '18.65440', '9', '0', '9.jpeg', '732884530', 'APPROVED'),
     (10, 'Strzelnica LOK Gdańsk', 'Nasz obiekt to doskonałe miejsce dla każdego, kto szuka oryginalnego sposobu na spędzenie wolnego czasu i wyśmienitej rozrywki. Możesz przekona jak strzela się z prawdziwej broni. Huk wystrzałów, zapach prochu i adrenalina towarzysząca strzelaniu przekłada się na satysfakcję wynikającą z kolejnych trafień. Dzięki wykwalifikowanej kadrze instruktorskiej poznasz zasady bezpieczeństwa, celowania i celnego oddania strzału. Możesz przyjść sam lub w grupie przyjaciół i znajomych', 'https://lokgdansk.pl/', 'DREWNIANA_PODŁOGA', 'LEKKOATLETYKA', '54.36266', '18.63517', '10', '0', '10.jpg', '785882825', 'APPROVED'),
     (11, 'Orlik', 'Boisko sportowe', 'brak', 'TRAWA', 'PIŁKA_NOŻNA', '54.34932', '18.63156', '11', '1', '11.jpg', 'brak', 'APPROVED'),
     (12, 'Gdański Ośrodek Sportu', 'W jego skład wchodzą:
    stadion z zapleczem socjalnym i widownią o poj. 11.811 miejsc – w tym trybuna kryta 1919 miejsc
    płyta trawiasta o wymiarach 68 m x 105 m
    boisko treningowe trawiaste z oświetleniem o wymiarach 68 m x 105 m i widownią na 510 miejsc
    boisko treningowe ze sztuczną nawierzchnią i oświetleniem o wymiarach 54 m x 90 m
    hala sztuk walk
    hala LA
    bieżnia krótka
    skocznia d skoku w dal
    rzutnia LA
    siłownia z zapleczem socjalnym
    Sala konferencyjna w budynku administracyjnym GOS na 25-30 miejsc', 'https://sportgdansk.pl/obiekty/kompleks-sportowy-ul-traugutta-29/', 'DREWNIANA_PODŁOGA', 'PIŁKA_NOŻNA', '54.36873', '18.62460', '12', '0', '12.jpg', '58 524 34 73', 'APPROVED'),
     (13, 'Centrum Sportu Akademickiego Politechniki Gdańskiej', 'Ośrodek sportowy z pełnowymiarowym boiskiem piłkarskim z certyfikatem FIFA, halą sportową, boiskiem do siatkówki, plenerowymi kortami tenisowymi i halą tenisową, salą aerobiku, siłownią, wioślarnią, salą judo, sauną, a także oferujący zajęcia fitness i sportowe dla dzieci i dorosłych.', 'http://csa.pg.edu.pl/', 'DREWNIANA_PODŁOGA', 'LEKKOATLETYKA', '54.36936', '18.63143', '13', '0', '13.jpg', '583472500', 'APPROVED'),
     (14, 'Boisko sportowe (Szkolne)', 'brak', 'http://sp50.edu.gdansk.pl/', 'TARTAN', 'PIŁKA_NOŻNA', '54.35291', '18.65599', '14', '0', '14.jpg', '58 301 18 48', 'APPROVED'),
     (15, 'Strzelnica Sportowa Klub Strzelających Inaczej KSI', 'Klub Strzelających Inaczej „KSI”, powstał z inicjatywy obywateli szukających alternatyw w strzelectwie oraz możliwości rozwoju w zakresie strzelania sytuacyjnego', 'https://www.strzelamyinaczej.pl/', 'ASFALT', 'LEKKOATLETYKA', '54.34748', '18.67131', '15', '0', '15.webp', '530386445', 'APPROVED'),
     (16, 'Stadion im. Zbigniewa Podleckiego', 'Początki żużla w Gdańsku sięgają pierwszych lat powojennych. Pierwszym obiektem z prawdziwego zdarzenia był stadion przy ul. Marynarki Polskiej. Obiekt, który wówczas służył również piłkarzom, teraz jest tylko wykorzystywany przez futbolistów Polonii Gdańsk. ', 'https://www.wybrzezegdansk.pl/stadion', 'TRAWA', 'PIŁKA_NOŻNA', '54.34615', '18.67157', '16', '0', '16.jpg', '58 346 30 27', 'APPROVED'),
     (17, 'KS Polonia', 'Polski klub piłkarski z siedzibą w Gdańsku, powstały 27 września 1945. Obecnie występuje w rozgrywkach Klasy okręgowej w Grupie Gdańskiej I', 'http://www.90minut.pl/skarb.php?id_klub=309&id_sezon=', 'TRAWA', 'PIŁKA_NOŻNA', '54.37396', '18.63485', '17', '0', '17.jpg', '795003803', 'APPROVED'),
     (18, 'FitYard', 'FitYard, kameralna siłownia dla ludzi lubiących przyjemną atmosferę i spokój. Na wyposażeniu profesjonalny sprzęt z pomocą którego zrobisz co chcesz, a nawet więcej.', 'https://fityard.pl/', 'DREWNIANA_PODŁOGA', 'SPORTY_SIŁOWE', '54.37211', '18.63409', '18', '0', '18.jpg', '48506602995', 'APPROVED'),
     (19, 'Pomorskie Centrum Hokejowe - Profesjonalne treningi hokejowe oraz ostrzenie łyżew optymalizowane pod wagę sportowca', 'Hala z lodowiskiem syntetycznym o wymiarach 8x24m pozwalającym rozgrywać mecze 3x3 plus bramkarze.', 'https://centrumhokejowe.pl/', 'LÓD', 'LYŻWIARSTWO', '54.37574', '18.63453', '19', '0', '19.jpg', '48504796999', 'APPROVED'),
     (20, 'Siłownia zewnętrzna', 'Siłownia zewnętrzna', 'brak', 'TRAWA', 'SPORTY_SIŁOWE', '54.34660', '18.64269', '20', '0', '20.jpg', 'brak', 'APPROVED'),
     (21, 'Boiska do koszykówki', 'Boiska do koszykówki', 'brak', 'SZTUCZNA_TRAWA', 'KOSZYKÓWKA', '54.34567', '18.64267', '21', '0', '21.jpg', 'brak', 'APPROVED');
;
--godziny wyplute z chatu:
-- Obiekt 1
-- Sport Complex 1
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '06:00', '22:00', 1),
    (1, '06:00', '22:00', 1),
    (2, '06:00', '22:00', 1),
    (3, '06:00', '22:00', 1),
    (4, '06:00', '22:00', 1),
    (5, '07:00', '21:00', 1),
    (6, '07:00', '21:00', 1);

-- Sport Complex 2
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '08:00', '22:00', 2),
    (1, '08:00', '22:00', 2),
    (2, '08:00', '22:00', 2),
    (3, '08:00', '22:00', 2),
    (4, '08:00', '22:00', 2),
    (5, '08:00', '22:00', 2),
    (6, '08:00', '22:00', 2);

-- Sport Complex 3
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '08:00', '16:00', 3),
    (1, '08:00', '16:00', 3),
    (2, '08:00', '16:00', 3),
    (3, '08:00', '16:00', 3),
    (4, '08:00', '16:00', 3);

-- Sport Complex 5
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '10:00', '00:00', 5),
    (1, '10:00', '00:00', 5),
    (2, '10:00', '00:00', 5),
    (3, '10:00', '00:00', 5),
    (4, '10:00', '00:00', 5),
    (5, '10:00', '01:00', 5),
    (6, '10:00', '01:00', 5);

-- Sport Complex 6
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '10:00', '18:00', 6),
    (1, '10:00', '18:00', 6),
    (2, '10:00', '18:00', 6),
    (3, '10:00', '18:00', 6),
    (4, '10:00', '18:00', 6),
    (5, '10:00', '18:00', 6),
    (6, '10:00', '18:00', 6);

-- Sport Complex 8
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '00:00', '00:00', 8),
    (1, '00:00', '00:00', 8),
    (2, '00:00', '00:00', 8),
    (3, '00:00', '00:00', 8),
    (4, '00:00', '00:00', 8),
    (5, '00:00', '00:00', 8),
    (6, '00:00', '00:00', 8);

-- Sport Complex 9
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '05:30', '10:00', 9),
    (1, '05:30', '10:00', 9),
    (2, '05:30', '10:00', 9),
    (3, '05:30', '10:00', 9),
    (4, '05:30', '10:00', 9),
    (5, '08:30', '13:30', 9),
    (6, '08:30', '13:30', 9);

-- Sport Complex 10
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (1, '12:00', '20:00', 10),
    (2, '12:00', '20:00', 10),
    (3, '12:00', '20:00', 10),
    (4, '12:00', '20:00', 10),
    (5, '12:00', '20:00', 10);

-- Sport Complex 11
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '00:00', '00:00', 11),
    (1, '00:00', '00:00', 11),
    (2, '00:00', '00:00', 11),
    (3, '00:00', '00:00', 11),
    (4, '00:00', '00:00', 11),
    (5, '00:00', '00:00', 11),
    (6, '00:00', '00:00', 11);

-- Sport Complex 12
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '07:30', '15:30', 12),
    (1, '07:30', '15:30', 12),
    (2, '07:30', '15:30', 12),
    (3, '07:30', '15:30', 12),
    (4, '07:30', '15:30', 12);

-- Sport Complex 13
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '07:00', '22:00', 13),
    (1, '07:00', '22:00', 13),
    (2, '07:00', '22:00', 13),
    (3, '07:00', '22:00', 13),
    (4, '07:00', '22:00', 13),
    (5, '09:00', '21:00', 13),
    (6, '09:00', '21:00', 13);

-- Sport Complex 15
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '16:00', '22:00', 15),  -- Monday
    (1, '16:00', '22:00', 15),  -- Tuesday
    (2, '16:00', '22:00', 15),  -- Wednesday
    (3, '16:00', '22:00', 15),  -- Thursday
    (4, '10:00', '22:00', 15),  -- Friday
    (5, '10:00', '22:00', 15),  -- Saturday
    (6, '10:00', '22:00', 15);  -- Sunday

-- Sport Complex 18
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '13:00', '21:00', 18),  -- Monday
    (1, '13:00', '21:00', 18),  -- Tuesday
    (2, '13:00', '21:00', 18),  -- Wednesday
    (3, '13:00', '21:00', 18),  -- Thursday
    (4, '13:00', '21:00', 18);  -- Friday


INSERT INTO users (username, email, password, authority, avatar)
VALUES
    ('UserOne', 'userone@example.com', 'password123', 'USER', 'avatar1.jpg'),
    ('UserTwo', 'usertwo@example.com', 'password123', 'USER', 'avatar4.jpg'),
    ('UserThree', 'userthree@example.com', 'password123', 'USER', 'avatar2.jpg'),
    ('UserFour', 'userfour@example.com', 'password123', 'USER', 'avatar3.jpg'),
    ('UserFive', 'userfive@example.com', 'password123', 'USER', 'avatar5.jpg'),
    ('admin', 'admin@test', '{bcrypt}$2a$10$1CjUGw14jTjULfj5WO66YOQMBsKe2Mh3dbhoT0DH23.1ECpBM5ViS', 'ADMIN', 'avatar5.jpg'); -- password: admin


INSERT INTO reviews (content, sport_complex_id, user_id, rate, review_date)
VALUES
    ('Great facilities and well-maintained fields.', 1, 1, 5, '2023-01-15'),
    ('The staff is friendly and the equipment is top-notch.', 2, 2, 4, '2023-02-20'),
    ('Excellent location for swimming competitions, clean and accessible.', 3, 3, 5, '2023-03-10'),
    ('The gym has a wide range of equipment and is rarely overcrowded.', 4, 4, 4, '2023-04-05'),
    ('Perfect for weekend soccer games, the turf is in great condition.', 5, 5, 5, '2023-05-15');

INSERT INTO events (name, description, sport_complex_id, start_time, end_time, photo, user_id)
VALUES
    ('City Crossfit Challenge', 'An exciting crossfit competition in the city.', 1, '2023-07-15 14:00:00', '2023-07-15 17:00:00', 'city_crossfit_challenge.jpg', 1),
    ('aaaaa', 'asda.', 1, '2023-07-15 14:00:00', '2023-07-15 17:00:00', 'city_crossfit_challenge.jpg', 1),
    ('itStartsInHolidays', 'asda.', 1, '2024-07-15 14:00:00', '2030-07-15 17:00:00', 'city_crossfit_challenge.jpg', 1),
    ('shouldBeAvailableNow', 'asda.', 1, '2024-01-13 14:00:00', '2030-02-15 17:00:00', 'city_crossfit_challenge.jpg', 1),
    ('City Crossfit Challenge', 'An exciting crossfit competition in the city.', 1, '2023-07-15 14:00:00', '2023-07-15 17:00:00', 'city_crossfit_challenge.jpg', 1),
    ('National Gymnastics Competition', 'Watch the best gymnasts compete nationally.', 2, '2023-08-20 09:00:00', '2023-08-20 18:00:00', 'national_gymnastics_competition.jpg', 2),
    ('Urban Ice Skating Showdown', 'Experience thrilling ice skating performances.', 3, '2023-09-10 06:00:00', '2023-09-10 14:00:00', 'urban_ice_skating_showdown.jpg', 3),
    ('Beach Volleyball Summer Cup', 'Enjoy beach volleyball action in the summer sun.', 4, '2023-10-05 10:00:00', '2023-10-08 20:00:00', 'beach_volleyball_summer_cup.jpg', 4),
    ('Extreme Sports Expo 2023', 'Explore the latest trends in extreme sports.', 5, '2023-11-15 17:00:00', '2023-11-15 21:00:00', 'extreme_sports_expo_2023.jpg', 5);

INSERT INTO users_events (user_id, event_id) VALUES
                                                 (1, 1),
                                                 (2, 2),
                                                 (3, 3),
                                                 (4, 4),
                                                 (5, 5);
