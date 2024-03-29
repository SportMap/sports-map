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
    (21, 'Na Stoku', '80-811', '42', 'A', 'Gdańsk'),
    (22, 'Tytusa Chałubińskiego', '80-807', '13', '', 'Gdańsk'),
    (23, 'Tytusa Chałubińskiego', '80-809', '13', '', 'Gdańsk'),
    (24, 'Tytusa Chałubińskiego', '80-807', '13', '', 'Gdańsk'),
    (25, 'Tytusa Chałubińskiego', '80-807', '31', '', 'Gdańsk'),
    (26, 'Tytusa Chałubińskiego', '80-807', '13', '', 'Gdańsk'),
    (27, 'Traugutta', '80-221', '29', '', 'Gdańsk'),
    (28, 'Cienista', '80-809', '30', '', 'Gdańsk'),
    (29, 'Cienista', '80-035', '28', '', 'Gdańsk'),
    (30, 'Cienista', '80-809', '28', '', 'Gdańsk'),
    (31, 'Ptasia', '80-035', '30', '', 'Gdańsk'),
    (32, 'Antoniego Suchanka', '80-980', '2', '', 'Gdańsk'),
    (33, 'Reformacka', '80-808', '18', '', 'Gdańsk'),
    (34, 'Kolonia Studentów', '80-878', '5', '', 'Gdańsk'),
    (35, '', '80-877 ', '', '', 'Gdańsk')
;

INSERT INTO sport_complexes (
    id, name, description, website, surface, category, latitude, longitude, address_id, open_24_7, photo, phone_number, status
)VALUES
     (1, 'Aquastacja i Sportstacja', 'Aquastacja to pełnowymiarowy basen pływacki z 6 torami, o głębokości 1,20 m do 1,80 m. Dodatkowo znajdują się dwa małe baseny o wymiarach 8x4 m, przeznaczone do nauki pływania niemowląt, dzieci i dorosłych oraz do aquaaerobiku. Strefa saun składa się z sauny suchej, łaźni parowej, laconium, misy do stóp oraz miejsc do schładzania. Sportstacja to multisportowa sala gimnastyczna o powierzchni 630 m2, przeznaczona do piłki nożnej, siatkówki, koszykówki, streetballa, badmintona oraz judo.', 'www.aquastacja.pl', 'TARTAN', 'PŁYWANIE', '54.39922', '18.57646', '1', '0', '1.jpg', '58 764 62 61', 'APPROVED'),
     (2, 'Gdański Klub Wioślarski', 'W naszej ofercie poza prowadzeniem zajęć wioślarskich dla dzieci i młodzieży mamy wynajem obiektów sportowych: hala do gry (piłka halowa, koszykówka, unihokej, siatkówka), siłownia, sala aerobiku, sala ergometrów oraz organizację obozów sportowych. Doskonale wyposażony obiekt sportowy z wyczynową sekcją wioślarską. W ofercie poza prowadzeniem zajęć wioślarskich dla dzieci i młodzieży do dyspozycji podmiotów zewnętrznych wynajmujemy obiekt sportowy: hala do gry (piłka nożna halowa, koszykówka, unihokej, siatkówka), siłownia, sala aerobiku, sala ergometrów oraz organizujemy obozy sportowe. ', 'www.gkw-drakkar.pl', 'TARTAN', 'LEKKOATLETYKA', '54.35748', '18.69177', '2', '0', '2.webp', '58 304 22 66', 'APPROVED'),
     (3, 'Gdański Klub Sportowy Gedania 1922', 'Gedania Gdańsk – najstarszy polski klub piłkarski działający w Gdańsku. Założony 15 sierpnia 1922 jako wielosekcyjny klub sportowy.', 'www.gedania1922.pl', 'TARTAN', 'LEKKOATLETYKA', '54.39702', '18.62312', '3', '0', '3.png', '517517879', 'APPROVED'),
     (4, 'Hala OLIVIA', 'Hala Sportowo-Widowiskowa Olivia znana jest nie tylko w Polsce, ale również poza jej granicami. Powstała w 1970 r.Do dzisiaj jest jedynym obiektem tego typu na Pomorzu. Podmiotem zarządzającym obiektem jest Gdański Klub Sportowy Stoczniowiec. W latach 1995 - 2000 obiekt został zmodernizowany. Obecnie jako jedyny w Polsce dysponuje dwoma zakrytymi lodowiskami i zapleczem sportowym o tak wysokim standardzie.', 'www.stoczniowiec.org.pl', 'LÓD', 'LYŻWIARSTWO', '54.40140', '18.57201', '4', '1', '4.jpg', '58 552 20 91', 'APPROVED'),
     (5, 'Centrum Sportowe U-7', 'Centrum U7 Gdańsk znajduje się w historycznym, poniemieckim bunkrze z 1942 roku. Otwarcie kręgielni nastąpiło 17 stycznia 1997 roku. Jednocześnie była to pierwsza automatyczna kręgielnia w Polsce. Obecnie znajduje się tam:   8 torów bowlingowych,    10 stołów do gry w bilarda (pool),    bogato wyposażony bar,    wygodne sofy i kanapy,    rzutnik wraz ekranem o przekątnej 100 cali.', 'https://www.u7.pl/', 'DREWNIANA_PODŁOGA', 'KRĘGLE', '54.35325', '18.65241', '5', '0', '5.jpg', '58 305 55 77', 'APPROVED'),
     (6, 'Klub Wodny Żabi Kruk', 'Wypożyczalnia Kajaków i Sprzętu Wodnego dla Klientów Indywidualnych Zapraszamy do zwiedzania Gdańska z zupełnie innej perspektywy. Wypożyczalnia czynna codziennie od 10:00 do 18:00 Dopasujemy sprzęt do twoich indywidualnych potrzeb. Zaplanuj trasę wycieczki – zadzwoń 58 305 73 10 i płyniesz… Nie ma potrzeby rezerwacji pojedynczych sztuk.', 'https://kajakiempogdansku.pl/', 'ASFALT', 'LEKKOATLETYKA', '54.34239', '18.64825', '6', '0', '6.jpg', '501710010', 'APPROVED'),
     (7, 'Obiekt Sportowy Zielonogórska', 'Ogólnodostępny obiekt sportowy znajduje się na gdańskim Chełmie przy ul. Zielonogórskiej 4 (dojazd autobusami linii 108 lub 118 do przystanku n/ż ul. Stoczniowców). Do dyspozycji mieszkańców są tutaj korty tenisowe, dwa wymiarowe boiska piłkarskie, na których są rozgrywane m.in. mecze ligowe klasy „B” oraz mini skatepark.', 'https://sportgdansk.pl/obiekty/obiekt-sportowy-zielonogorska/', 'TRAWA', 'PIŁKA_NOŻNA', '54.34293', '18.63472', '7', '1', '7.webp', '601653968', 'APPROVED'),
     (8, 'Kort tenisowy', 'brak', 'brak', 'TWARDY_KORT', 'TENIS', '54.35923', '18.62800', '8', '1', '8.jpg', '-', 'APPROVED'),
     (9, 'CrossFit Stocznia', 'Nasz Box ma charakter szkoły treningowej, z klasami według poziomu zaawansowania.', 'www.crossfitstocznia.com', 'DREWNIANA_PODŁOGA', 'SPORTY_SIŁOWE', '54.36180', '18.65440', '9', '0', '9.jpeg', '732884530', 'APPROVED'),
     (10, 'Strzelnica LOK Gdańsk', 'Nasz obiekt to doskonałe miejsce dla każdego, kto szuka oryginalnego sposobu na spędzenie wolnego czasu i wyśmienitej rozrywki. Możesz przekona jak strzela się z prawdziwej broni. Huk wystrzałów, zapach prochu i adrenalina towarzysząca strzelaniu przekłada się na satysfakcję wynikającą z kolejnych trafień. Dzięki wykwalifikowanej kadrze instruktorskiej poznasz zasady bezpieczeństwa, celowania i celnego oddania strzału. Możesz przyjść sam lub w grupie przyjaciół i znajomych', 'https://lokgdansk.pl/', 'DREWNIANA_PODŁOGA', 'LEKKOATLETYKA', '54.36266', '18.63517', '10', '0', '10.jpg', '785882825', 'APPROVED'),
     (11, 'Orlik', 'Boisko sportowe', 'brak', 'TRAWA', 'PIŁKA_NOŻNA', '54.34932', '18.63156', '11', '1', '11.jpg', '-', 'APPROVED'),
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
     (16, 'Stadion im. Zbigniewa Podleckiego', 'Początki żużla w Gdańsku sięgają pierwszych lat powojennych. Pierwszym obiektem z prawdziwego zdarzenia był stadion przy ul. Marynarki Polskiej. Obiekt, który wówczas służył również piłkarzom, teraz jest tylko wykorzystywany przez futbolistów Polonii Gdańsk. ', 'https://www.wybrzezegdansk.pl/stadion', 'TRAWA', 'PIŁKA_NOŻNA', '54.34615', '18.67157', '16', '1', '16.jpg', '58 346 30 27', 'APPROVED'),
     (17, 'KS Polonia', 'Polski klub piłkarski z siedzibą w Gdańsku, powstały 27 września 1945. Obecnie występuje w rozgrywkach Klasy okręgowej w Grupie Gdańskiej I', 'http://www.90minut.pl/skarb.php?id_klub=309&id_sezon=', 'TRAWA', 'PIŁKA_NOŻNA', '54.37396', '18.63485', '17', '1', '17.jpg', '795003803', 'APPROVED'),
     (18, 'FitYard', 'FitYard, kameralna siłownia dla ludzi lubiących przyjemną atmosferę i spokój. Na wyposażeniu profesjonalny sprzęt z pomocą którego zrobisz co chcesz, a nawet więcej.', 'https://fityard.pl/', 'DREWNIANA_PODŁOGA', 'SPORTY_SIŁOWE', '54.37211', '18.63409', '18', '0', '18.jpg', '48506602995', 'APPROVED'),
     (19, 'Pomorskie Centrum Hokejowe', 'Profesjonalne treningi hokejowe oraz ostrzenie łyżew optymalizowane pod wagę sportowca. Hala z lodowiskiem syntetycznym o wymiarach 8x24m pozwalającym rozgrywać mecze 3x3 plus bramkarze.', 'https://centrumhokejowe.pl/', 'LÓD', 'LYŻWIARSTWO', '54.37574', '18.63453', '19', '0', '19.jpg', '48504796999', 'APPROVED'),
     (20, 'Siłownia zewnętrzna', 'Siłownia zewnętrzna', 'brak', 'TRAWA', 'SPORTY_SIŁOWE', '54.34660', '18.64269', '20', '1', '20.jpg', '-', 'APPROVED'),
     (21, 'Boiska do koszykówki', 'Boiska do koszykówki', 'brak', 'SZTUCZNA_TRAWA', 'KOSZYKÓWKA', '54.34567', '18.64267', '21', '1', '21.jpg', '-', 'APPROVED'),
     (22, 'Pływalnia Chełm', 'Pływalnia CHEŁM przy ul. Chałubińskiego na gdańskim Chełmie jest ważnym ośrodkiem rekreacyjnym na mapie miasta. Już od 18 lat służy gdańszczanom, jako kompleks basenów o szerokim profilu działalności.Jest czynna przez 7 dni w tygodniu od godzin wczesnorannych, aż do godziny 22. Cieszy się bardzo dużą popularnością użytkowników w różnym wieku, ma opinię jednej z najlepszych w Gdańsku. Korzystają z niej zarówno klienci indywidualni, jak też zorganizowane grupy. W ciągu dnia do użytkowników pływalni należą szkoły miasta Gdańska. Dzieci i młodzież pod okiem instruktorów i nauczycieli oswajają się z wodą oraz doskonalą umiejętności pływackie. Dodatkowo, podczas ferii zimowych, GOS zaprasza młodych mieszkańców Gdańska na zajęcia, za które uczestnicy płacą zaledwie jedną złotówkę.', 'https://plywalniegdansk.pl/plywalnia-chelm/', 'TARTAN', 'PŁYWANIE', '54.33968', '18.62087', '22', '0', '22.jpg', '58 320 74 31', 'APPROVED'),
     (23, 'Forfit', 'Forfit to obiekt, w którym możesz skorzystać z podstawowych ćwiczeń dostępnych w każdej siłowni, czyli zajęcia siłowe i fitness, ale żeby się wyróżnić wprowadziliśmy do oferty zajęcia z CrossFitu.', 'https://www.trojmiasto.pl/Forfit-o61541.html', 'TARTAN', 'SPORTY_SIŁOWE', '54.33986', '18.62118', '23', '0', '23.jpeg', '513601272', 'APPROVED'),
     (24, 'Boiska sportowe', 'Kompleksu boisk przy Zespół Szkół Ogólnokształcących nr VII w Gdańsku', 'https://zso7.edu.gdansk.pl/pl', 'TARTAN', 'LEKKOATLETYKA', '54.33925', '18.62090', '24', '1', '24.jpg', '58 302 85 20', 'APPROVED'),
     (25, 'DSTeam Strzelnica', 'Jeśli interesuje Cię broń palna, lubisz adrenalinę i chciałbyś spróbować w życiu czegoś naprawdę ekscytującego, jesteś we właściwym miejscu! Nie potrzebujesz patentów, pozwoleń czy dopuszczeń do posiadania broni palnej!', 'https://dsteam.pl/', 'ASFALT', 'LEKKOATLETYKA', '54.33989', '18.61925', '25', '0', '25.jpeg', '665566997', 'APPROVED'),
     (26, 'Argonaut Fitness', 'Szkoła Argonaut Gdańsk – Fitness | Pływanie | Nurkowanie | Ratownictwo', 'https://argonaut.gda.pl/gdansku/', 'TARTAN', 'PŁYWANIE', '54.34182', '18.62194', '26', '1', '26.jpg', '510178819', 'APPROVED'),
     (27, 'Lechia Tennis Club', 'Lechia Tennis Club to obiekt  sportowy położony w zalesionej i zacisznej części Gdańska, jednak świetnie skomunikowany z centrum.  Do dyspozycji klubowiczów są cztery korty odkryte z nawierzchnią ceglaną. W sezonie zimowym zaś klubowicze mogą korzystać ze świeżo wyremontowanej hali z kortami o nawierzchni dywanowej.', 'http://lechiatennisclub.pl/', 'TWARDY_KORT', 'TENIS', '54.36650', '18.618921', '27', '0', '27.webp', '660 57 00 57', 'APPROVED'),
     (28, 'Premium Fitness & Gym', 'PREMIUM FITNESS & GYM to miejsce stworzone przez pasjonatów sportu i skierowane do wszystkich jego miłośników. Profesjonalnie wyposażona siłownia, bogata oferta zajęć fitness, wykwalifikowana kadra, a do tego świetna atmosfera. Stawiamy sobie za cel, abyś to Ty razem z nami zrealizował wszystkie swoje cele!', 'https://premiumgym.pl/', 'DREWNIANA_PODŁOGA', 'SPORTY_SIŁOWE', '54.33648', '18.62045', '28', '0', '28.jpg', '504413414', 'APPROVED'),
     (29, 'Boisko', 'Boisko', 'brak', 'TARTAN', 'LEKKOATLETYKA', '54.33685', '18.62205', '29', '1', '29.jpg', '-', 'APPROVED'),
     (30, 'Siłownia "Pod Chmurką" i sztuczny staw', 'Siłownia "Pod Chmurką" i sztuczny staw', 'brak', 'TRAWA', 'SPORTY_SIŁOWE', '54.33734', '18.62195', '30', '1', '30.jpg', '-', 'APPROVED'),
     (31, 'Siłownia "Pod chmurką"', 'Siłownia "Pod chmurką"', 'brak', 'TRAWA', 'SPORTY_SIŁOWE', '54.33587', '18.62271', '31', '1', '31.jpg', '-', 'APPROVED'),
     (32, 'Stół do gry w tenisa stołowego', 'Stół do gry w tenisa stołowego', 'brak', 'PIASEK', 'TENIS_STOŁOWY', '54.33579', '18.62491', '32', '1', '32.jpg', '-', 'APPROVED'),
     (33, 'Bieżnia przy Szkole Podstawowej nr 47', 'Bieżnia i obiekt sportowy przy Szkole Podstawowej nr 47', 'https://sp47.edu.gdansk.pl/pl', 'TARTAN', 'LEKKOATLETYKA', '54.34181', '18.63176', '33', '1', '33.jpg', '58 302 03 28', 'APPROVED'),
     (34, 'Skatepark im. Św. Nikodema małego', 'Skatepark im. Św. Nikodema małego', 'brak', 'ASFALT', 'LEKKOATLETYKA', '54.34346', '18.63448', '34', '1', '34.jpg', '-', 'APPROVED'),
     (35, 'Gdański Ośrodek Sportu', 'Boisko do piłki nożnej', 'https://sportgdansk.pl/', 'TRAWA', 'PIŁKA_NOŻNA', '54.34254', '18.63597', '35', '1', '35.jpg', '-', 'APPROVED')
;
INSERT INTO users (username, email, password, authority, avatar)
VALUES
    ('UserOne', 'userone@example.com', 'password123', 'USER', 'avatar1.jpg'),
    ('UserTwo', 'usertwo@example.com', 'password123', 'USER', 'avatar4.jpg'),
    ('UserThree', 'userthree@example.com', 'password123', 'USER', 'avatar2.jpg'),
    ('UserFour', 'userfour@example.com', 'password123', 'USER', 'avatar3.jpg'),
    ('UserFive', 'userfive@example.com', 'password123', 'USER', 'avatar5.jpg'),
    ('admin', 'admin@test', '{bcrypt}$2a$10$1CjUGw14jTjULfj5WO66YOQMBsKe2Mh3dbhoT0DH23.1ECpBM5ViS', 'ADMIN', 'avatar5.jpg'); -- password: admin



INSERT INTO events (name, description, sport_complex_id, start_time, end_time, photo, user_id)
VALUES
    ('AquaFit Challenge', 'Zawody w fitness na wodzie dla wszystkich grup wiekowych. Dołącz do naszej zabawy i odkryj moc ćwiczeń w wodzie!', '1', '2024-04-28 10:00', '2024-04-28 17:00', '1_event.webp', '1'),
    ('Wioślarski Maraton Nadmorski', 'Wyścig wioślarski na otwartym morzu! Sprawdź swoje umiejętności i wytrzymałość na dystansie 20 kilometrów.', '2', '2024-04-27 10:00', '2024-04-27 17:00', '2_event.jpg', '1'),
    ('Turniej Piłki Nożnej Dla Młodzieży', 'Turniej piłkarski dla młodych talentów. Zapraszamy wszystkich pasjonatów futbolu do udziału i rywalizacji!', '3', '2024-04-28 11:00', '2024-04-28 16:00', '3_event.webp', '2'),
    ('Koncert Muzyczny: Jazzowa Noc w Hali Olivia', 'Wieczór pełen świetnej muzyki jazzowej w niepowtarzalnej atmosferze Hali Olivia. Nie przegap tego wyjątkowego wydarzenia!', '4', '2024-04-27 10:00', '2024-04-27 17:00', '4_event.jpg', '3'),
    ('Turniej Bilardowy', 'Turniej bilardowy dla miłośników gry w bilard. Sprawdź swoje umiejętności i zmierz się z innymi graczami!', '5', '2024-04-28 13:00', '2024-04-28 17:00', '5_event.jpg', '1'),
    ('Kajakowe Odkrywanie Gdańska', 'Spędź dzień na wodzie i odkryj uroki Gdańska z zupełnie innej perspektywy. Zapraszamy na wycieczkę kajakową!', '6', '2024-04-28 12:00', '2024-04-28 17:00', '6_event.jpg', '2'),
    ('Mecz Piłki Nożnej: Lokalne Derby', 'Emocjonujący mecz piłki nożnej pomiędzy drużynami lokalnymi. Przyjdź i wspieraj swoją ulubioną drużynę!', '7', '2024-04-28 07:00', '2024-04-28 17:00', '7_event.webp', '4'),
    ('Turniej Tenisowy dla Amatorów', 'Turniej tenisowy dla wszystkich amatorów. Doświadcz rywalizacji i zabawy na korcie tenisowym!', '8', '2024-04-21 10:00', '2024-04-21 17:00', '8_event.jpg', '5'),
    ('Wyzwanie CrossFit: 24-Godzinny Maraton Treningowy', 'Przygotuj się na 24-godzinny maraton treningowy CrossFit. Wyjątkowe wyzwanie dla najbardziej wytrwałych!', '9', '2024-04-21 10:00', '2024-04-21 17:00', '9_event.png', '1'),
    ('Wieczór Strzelecki: Turniej Strzelecki dla Początkujących', 'Zapraszamy na wieczór strzelecki dla początkujących. Sprawdź swoje umiejętności i zdobądź nowe doświadczenia!', '10', '2024-04-21 10:00', '2024-04-21 17:00', '10_event.jpg', '2'),
    ('Turniej Piłki Nożnej "Orlik Cup"', 'Zapraszamy do udziału w naszym turnieju piłki nożnej dla dzieci i młodzieży. Wspólnie świętujmy pasję do futbolu!', '11', '2024-04-21 10:00', '2024-04-21 17:00', '11_event.jpg', '3'),
    ('Kurs Pływania Dla Dzieci', 'Rozpocznij przygodę z pływaniem! Nasz kurs pływania dla dzieci to doskonała okazja, by nauczyć się podstawowych technik i bezpieczeństwa w wodzie.', '12', '2024-04-21 10:00', '2024-04-21 17:00', '12_event.webp', '4'),
    ('Siatkówka Plażowa: Turniej Studencki', 'Studenci, przygotujcie się na emocjonujący turniej siatkówki plażowej! Dołączcie do rywalizacji i przeżyjcie niezapomniane chwile na plaży.', '13', '2024-04-21 10:00', '2024-04-21 17:00', '13_event.jpg', '2'),
    ('Liga Młodych Talentów: Turniej Piłki Ręcznej', 'Szukamy młodych talentów piłki ręcznej! Dołącz do naszego turnieju i pokaż swoje umiejętności na boisku!', '14', '2024-04-14 10:00', '2024-04-14 17:00', '14_event.jpg', '3'),
    ('Wieczór Strzelecki: Zawody w Strzelaniu z Łuku', 'Czy jesteś gotowy na wyzwanie? Przyjdź na naszą strzelnicę i zmierz się z innymi łucznikami w emocjonujących zawodach!', '15', '2024-04-14 10:00', '2024-04-14 17:00', '15_event.jpg', '4'),
    ('Koncert Rockowy: "Rock na Stadionie"', 'Przygotuj się na niezapomniany wieczór pełen rockowej muzyki! Zapraszamy na koncert na naszym stadionie!', '16', '2024-04-14 10:00', '2024-04-14 17:00', '16_event.webp', '1'),
    ('Mecz Piłki Siatkowej: Polonia vs. Rywale', 'Przyjdź i wesprzyj naszą drużynę siatkówki w emocjonującym meczu przeciwko naszym rywalom!', '17', '2024-04-14 10:00', '2024-04-14 17:00', '17_event.jpg', '2'),
    ('Trening CrossFit: Wyzwanie na Najwyższym Poziomie', 'Przygotuj się na intensywny trening CrossFit, który sprawi, że przekroczysz swoje granice!', '18', '2024-04-14 10:00', '2024-04-14 17:00', '18_event.jpg', '3'),
    ('Turniej Hokeja na Lodzie: Pomorska Zimowa Liga', 'Zapraszamy do udziału w naszym turnieju hokeja na lodzie! Czekają na was emocje i niezapomniane chwile na lodowisku.', '19', '2024-04-14 10:00', '2024-04-14 17:00', '19_event.jpg', '4'),
    ('Trening Plenerowy: Zdrowe Życie na Świeżym Powietrzu', 'Dołącz do naszego treningu na świeżym powietrzu i poczuj korzyści zdrowego trybu życia!', '20', '2024-04-14 10:00', '2024-04-14 17:00', '20_event.png', '1'),
    ('Turniej Streetball: Koszykówka na Asfalcie', 'Zapraszamy do udziału w naszym turnieju streetballowej koszykówki! Grajcie na asfalcie i pokazujcie swoje umiejętności!', '21', '2024-04-14 10:00', '2024-04-14 17:00', '21_event.png', '1'),
    ('Kurs Pływania Dla Dorosłych', 'Nigdy nie jest za późno, by nauczyć się pływać! Dołącz do naszego kursu pływania dla dorosłych i odkryj radość z poruszania się w wodzie.', '22', '2024-04-27 10:00', '2024-04-27 17:00', '22_event.jpg', '1'),
    ('Trening Funkcjonalny: Siła, Wytrzymałość, Ruchomość', 'Zapraszamy na trening funkcjonalny, który pozwoli ci popracować nad siłą, wytrzymałością i ruchomością!', '23', '2024-04-27 10:00', '2024-04-27 17:00', '23_event.jpeg', '1'),
    ('Mecz Wsparcia Charytatywnego: Gwiazdy vs. Drużyna Lokalna', 'Dołącz do nas na meczu charytatywnym, gdzie gwiazdy sportu zmierzą się z drużyną lokalną w szczytnym celu!', '24', '2024-04-27 10:00', '2024-04-27 17:00', '24_event.jpg', '2'),
    ('Szkolenie Strzeleckie: Techniki Celowania i Bezpieczeństwa', 'Zapisz się na nasze szkolenie strzeleckie i opanuj techniki celowania oraz zasady bezpiecznego posługiwania się bronią.', '25', '2024-04-27 10:00', '2024-04-27 17:00', '25_event.jpeg', '3'),
    ('Trening HIIT: Spal Kalorie w Tempie Błyskawicy', 'Przygotuj się na intensywny trening HIIT, który pozwoli ci spalić kalorie w tempie błyskawicy i poprawić kondycję!', '26', '2024-04-27 10:00', '2024-04-27 17:00', '26_event.jpg', '3'),
    ('Turniej Tenisowy: Otwarte Mistrzostwa Klubu', 'Zapraszamy do udziału w otwartych mistrzostwach naszego klubu tenisowego! Czekają nagrody i wiele emocji na korcie!', '27', '2024-04-27 10:00', '2024-04-27 17:00', '27_event.jpg', '3'),
    ('Trening Pilates: Wzmacnianie Ciała i Uspokojenie Umysłu', 'Skoncentruj się na wzmocnieniu ciała i uspokojeniu umysłu podczas naszego treningu pilates!', '28', '2024-04-20 10:00', '2024-04-20 17:00', '28_event.png', '4'),
    ('Liga Amatorska: Mecz Piłki Nożnej', 'Dołącz do naszej ligi amatorskiej i graj w emocjonujących meczach piłki nożnej na naszym boisku!', '29', '2024-04-20 10:00', '2024-04-20 17:00', '29_event.jpg', '5'),
    ('Trening Outdoorowy: Siła i Energia wśród Natury', 'Wyrusz z nami na trening outdoorowy, gdzie siła i energia łączą się z pięknem natury wokół nas!', '30', '2024-04-20 10:00', '2024-04-20 17:00', '30_event.jpg', '5'),
    ('Trening Kettlebell: Zbuduj Siłę i Wytrzymałość', 'Przyjdź na nasz trening z kettlebellami i zbuduj siłę oraz wytrzymałość pod okiem naszych doświadczonych instruktorów!', '31', '2024-04-20 10:00', '2024-04-20 17:00', '31_event.jpg', '5'),
    ('Turniej Tenisa Stołowego: Mistrzostwa Szkolne', 'Szkoły, przygotujcie swoich zawodników na nasze mistrzostwa szkolne w tenisie stołowym! Czekają nagrody i wiele emocji przy stole!', '32', '2024-04-20 10:00', '2024-04-20 17:00', '32_event.jpg', '1'),
    ('Dzień Fitnessu: Zumba, Jogging, Stretching', 'Dołącz do nas na dzień fitnessu, gdzie czekają na ciebie zajęcia z zumbi, joggingu i stretchingu przy naszej bieżni!', '33', '2024-04-20 10:00', '2024-04-20 17:00', '33_event.jpg', '2'),
    ('Zawody Deskorolkowe: Skateboardingowe Szaleństwo', 'Przygotuj swoją deskorolkę i dołącz do nas na zawodach deskorolkowych! Pokaż swoje umiejętności na rampach i railach!', '34', '2024-04-20 10:00', '2024-04-20 17:00', '34_event.webp', '3'),
    ('Maraton Biegowy: Bieg przez Miasto', 'Biegacze, przygotujcie się na maraton przez nasze piękne miasto! Dołączcie do wyzwania i przebiegnijcie przez najpiękniejsze zakątki Gdańska!', '35', '2024-04-20 10:00', '2024-04-20 17:00', '35_event.webp', '3')
;
INSERT INTO users_events (user_id, event_id) VALUES
                                                 (1, 1),
                                                 (1, 5),
                                                 (1, 9),
                                                 (1, 16),
                                                 (1, 20),
                                                 (1, 21),
                                                 (1, 22),
                                                 (1, 23),
                                                 (1, 32),
                                                 (2, 2),
                                                 (2, 3),
                                                 (2, 6),
                                                 (2, 10),
                                                 (2, 13),
                                                 (2, 17),
                                                 (2, 24),
                                                 (2, 33),
                                                 (3, 4),
                                                 (3, 7),
                                                 (3, 11),
                                                 (3, 14),
                                                 (3, 18),
                                                 (3, 25),
                                                 (3, 26),
                                                 (3, 27),
                                                 (3, 34),
                                                 (3, 35),
                                                 (4, 8),
                                                 (4, 12),
                                                 (4, 15),
                                                 (4, 28),
                                                 (5, 29),
                                                 (5, 30),
                                                 (5, 31);

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

-- Sport Complex 19
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '07:00', '23:00', 19),
    (1, '07:00', '23:00', 19),
    (2, '07:00', '23:00', 19),
    (3, '07:00', '23:00', 19),
    (4, '07:00', '23:00', 19),
    (5, '07:00', '23:00', 19),
    (6, '07:00', '23:00', 19);

-- Sport Complex 22
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '16:00', '22:00', 22),
    (1, '16:00', '22:00', 22),
    (2, '16:00', '22:00', 22),
    (3, '16:00', '22:00', 22),
    (4, '16:00', '22:00', 22),
    (5, '07:00', '21:00', 22),
    (6, '07:00', '21:00', 22);

-- Sport Complex 23
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '08:00', '22:00', 23),
    (1, '08:00', '22:00', 23),
    (2, '08:00', '22:00', 23),
    (3, '08:00', '22:00', 23),
    (4, '08:00', '22:00', 23),
    (5, '10:00', '18:00', 23),
    (6, '10:00', '16:00', 23);

-- Sport Complex 25
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '13:00', '21:00', 25),
    (2, '13:00', '21:00', 25),
    (3, '13:00', '21:00', 25),
    (4, '13:00', '21:00', 25),
    (5, '12:00', '22:00', 25),
    (6, '12:00', '20:00', 25);

-- Sport Complex 27
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '08:00', '22:00', 27),
    (1, '08:00', '22:00', 27),
    (2, '08:00', '22:00', 27),
    (3, '08:00', '22:00', 27),
    (4, '08:00', '22:00', 27),
    (5, '08:00', '22:00', 27),
    (6, '08:00', '22:00', 27);

-- Sport Complex 28
INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES
    (0, '06:00', '00:00', 28),
    (1, '06:00', '00:00', 28),
    (2, '06:00', '00:00', 28),
    (3, '06:00', '00:00', 28),
    (4, '06:00', '00:00', 28),
    (5, '06:00', '00:00', 28),
    (6, '06:00', '00:00', 28);




--INSERT INTO reviews (content, sport_complex_id, user_id, rate, review_date)
--VALUES
--    ('Great facilities and well-maintained fields.', 1, 1, 5, '2023-01-15'),
--    ('The staff is friendly and the equipment is top-notch.', 2, 2, 4, '2023-02-20'),
--    ('Excellent location for swimming competitions, clean and accessible.', 3, 3, 5, '2023-03-10'),
--    ('The gym has a wide range of equipment and is rarely overcrowded.', 4, 4, 4, '2023-04-05'),
--    ('Perfect for weekend soccer games, the turf is in great condition.', 5, 5, 5, '2023-05-15');

INSERT INTO reviews (content, sport_complex_id, user_id, rate, review_date)
VALUES
    ('Świetne miejsce do aktywnego spędzania czasu. Basen czysty, dobrze utrzymany. Bardzo profesjonalna obsługa. Polecam!', '1', '1', '5', '2023-11-25'),
    ('Piękne otoczenie nad rzeką, idealne miejsce do uprawiania wioślarstwa. Klub dobrze wyposażony, instruktorzy kompetentni.', '2', '1', '4', '2023-10-17'),
    ('Solidne zaplecze sportowe, ale nieco przestarzałe. Potrzebna modernizacja i ulepszenia.', '3', '1', '3', '2023-09-02'),
    ('Świetne miejsce na różnego rodzaju wydarzenia sportowe i kulturalne. Dużo przestrzeni, dobra organizacja.', '4', '1', '5', '2023-12-10'),
    ('Średnie centrum sportowe. Infrastruktura wymaga ulepszeń, ale ogólnie przyjemne miejsce do aktywności.', '5', '1', '3', '2023-11-30'),
    ('Bardzo przyjazna atmosfera i kompetentna kadra instruktorska. Baseny czyste i dobrze utrzymane.', '6', '1', '5', '2023-12-02'),
    ('Brak wystarczającej infrastruktury, obiekt wymaga modernizacji. Można poprawić warunki dla aktywności sportowej.', '7', '1', '2', '2023-08-20'),
    ('Świetne korty, dobrze utrzymane. Często zorganizowane turnieje i zajęcia.', '8', '1', '4', '2023-11-18'),
    ('Profesjonalne podejście do treningu. Instruktorzy z dużym doświadczeniem. Świetna atmosfera.', '9', '1', '5', '2023-12-05'),
    ('Bezpieczne i dobrze zarządzane miejsce do strzelania. Instruktorzy zapewniają solidne wsparcie dla początkujących.', '10', '1', '4', '2023-09-28'),
    ('Przyjazne dla dzieci boiska do gry w piłkę. Dobrze utrzymane i bezpieczne.', '11', '1', '4', '2023-10-10'),
    ('Duży kompleks sportowy, ale nie zawsze odpowiednio utrzymany. Potrzebne lepsze zarządzanie i dbałość o czystość.', '12', '1', '3', '2023-11-15'),
    ('Doskonałe miejsce dla studentów do uprawiania różnych dyscyplin sportowych. Dobrze wyposażone i zorganizowane.', '13', '1', '5', '2023-12-12'),
    ('Standardowe boisko szkolne, często zajęte przez uczniów. Warunki mogą być lepsze.', '14', '1', '3', '2023-10-25'),
    ('Bardzo przyjazne miejsce dla pasjonatów strzelectwa. Instruktorzy z dużą wiedzą i cierpliwością dla początkujących.', '15', '1', '5', '2023-12-15'),
    ('Duży stadion z dobrym zapleczem. Często organizowane są tu ważne wydarzenia sportowe. Dobrze utrzymany i zorganizowany obiekt.', '16', '1', '4', '2023-11-28'),
    ('Tradycyjny klub sportowy z bogatą historią. Infrastruktura wymaga modernizacji, ale atmosfera i zaangażowanie członków są nienaganne.', '17', '1', '3', '2023-10-20'),
    ('Świetne miejsce dla osób szukających różnorodnych zajęć fitness. Instruktorzy kompetentni, atmosfera sprzyjająca motywacji do treningu.', '18', '1', '5', '2023-12-02'),
    ('Profesjonalne zaplecze dla miłośników hokeja. Dobrze wyposażone, często odbywają się tu treningi i zawody.', '19', '1', '4', '2023-11-15'),
    ('Fantastyczna alternatywa dla treningu na świeżym powietrzu. Dobrze utrzymane urządzenia, dostępność przez cały rok.', '20', '1', '5', '2023-12-05'),
    ('Solidne boiska, dobrze utrzymane. Popularne miejsce do gry w koszykówkę zarówno dla amatorów, jak i profesjonalistów.', '21', '1', '4', '2023-10-30'),
    ('Świetne miejsce do nauki pływania i rekreacji. Baseny czyste, dobrze nadzorowane. Atmosfera sprzyjająca rodzinnej zabawie.', '22', '1', '5', '2023-12-10'),
    ('Nowoczesne centrum fitness z szeroką gamą zajęć. Sprzęt wysokiej jakości, instruktorzy pomocni i profesjonalni.', '23', '1', '5', '2023-11-25'),
    ('Standardowe boiska, dobrze utrzymane. Często zajęte, ale ogólnie przyjemne miejsce do uprawiania różnych dyscyplin sportowych.', '24', '1', '3', '2023-09-18'),
    ('Bezpieczne miejsce do treningu strzeleckiego. Instruktorzy profesjonalni, dobra organizacja. Idealne dla pasjonatów strzelectwa.', '25', '1', '4', '2023-10-05'),
    ('Przyjazne dla użytkowników miejsce fitness. Zróżnicowane zajęcia, dobra atmosfera. Czasami jednak tłoczno.', '26', '1', '4', '2023-11-08'),
    ('Klub tenisowy oferujący wysokiej jakości korty i dobre warunki do gry. Często organizowane są tu turnieje i treningi dla różnych grup wiekowych.', '27', '1', '4', '2023-12-05'),
    ('Doskonałe miejsce do treningu zarówno dla początkujących, jak i zaawansowanych. Bogaty wybór sprzętu i profesjonalna obsługa.', '28', '1', '5', '2023-11-20'),
    ('Standardowe boisko, często wykorzystywane przez okolicznych mieszkańców i szkoły. Warunki do gry są dobre, jednak brakuje nieco lepszego utrzymania.', '29', '1', '3', '2023-10-15'),
    ('Urocze miejsce do ćwiczeń na świeżym powietrzu. Siłownia jest dobrze wyposażona, a obecność sztucznego stawu dodaje uroku temu miejscu.', '30', '1', '4', '2023-11-28'),
    ('Proste, ale funkcjonalne miejsce do treningu na zewnątrz. Brak zaawansowanego sprzętu, ale atmosfera sprzyja aktywności fizycznej.', '31', '1', '3', '2023-09-30'),
    ('Poprawne miejsce do gry w tenisa stołowego. Czasami stół wymaga konserwacji, ale ogólnie jest przyzwoicie utrzymany.', '32', '1', '3', '2023-10-10'),
    ('Podstawowa bieżnia, używana głównie przez uczniów i okolicznych mieszkańców. Warunki do biegania są przeciętne, ale czasami brakuje konserwacji.', '33', '1', '2', '2023-11-05'),
    ('Fantastyczne miejsce dla miłośników jazdy na deskorolce i rowerze. Park jest dobrze zaprojektowany i utrzymany, co przyciąga wielu entuzjastów sportów ekstremalnych.', '34', '1', '5', '2023-12-10'),
    ('Duży kompleks sportowy oferujący różnorodne obiekty i zajęcia. Infrastruktura wymaga pewnej modernizacji, ale ogólnie jest to solidne miejsce do uprawiania sportu.', '35', '1', '4', '2023-11-15'),
    ('Doskonałe miejsce do aktywności wodnych i sportowych. Oferuje szeroki wybór atrakcji dla różnych grup wiekowych.', '1', '2', '5', '2023-12-10'),
    ('Klub wioślarski z profesjonalnym podejściem do treningu. Świetne warunki do rozwoju umiejętności i organizacji zawodów.', '2', '2', '4', '2023-11-25'),
    ('Tradycyjny klub sportowy z bogatą historią i aktywną społecznością. Oferuje różnorodne dyscypliny i programy treningowe.', '3', '2', '4', '2023-11-20'),
    ('Wspaniała hala sportowa z wieloma możliwościami. Często organizowane są tu wydarzenia sportowe i kulturalne, co przyciąga wielu mieszkańców i turystów.', '4', '2', '5', '2023-12-05'),
    ('Nowoczesny kompleks sportowy z różnorodnymi obiektami. Doskonałe miejsce dla rodzin i osób aktywnych fizycznie.', '5', '2', '4', '2023-12-02'),
    ('Przyjemne miejsce do uprawiania sportów wodnych i rekreacji na świeżym powietrzu. Atmosfera sprzyja relaksowi i aktywności fizycznej.', '6', '2', '4', '2023-11-15'),
    ('Solidny obiekt sportowy, często wykorzystywany przez lokalną społeczność. Brak zaawansowanych udogodnień, ale warunki są przyzwoite.', '7', '2', '3', '2023-10-30'),
    ('Standardowy kort tenisowy, który spełnia podstawowe potrzeby graczy. Czasami wymaga drobnych napraw, ale ogólnie jest w dobrym stanie.', '8', '2', '3', '2023-11-10'),
    ('Świetne miejsce dla miłośników intensywnych treningów. Profesjonalna kadra instruktorska i różnorodne zajęcia dostosowane do różnych poziomów zaawansowania.', '9', '2', '5', '2023-12-08'),
    ('Bezpieczna strzelnica oferująca treningi dla różnych grup wiekowych i poziomów umiejętności. Instruktorzy są kompetentni i pomocni.', '10', '2', '4', '2023-11-28'),
    ('Popularne boisko wielofunkcyjne, często odwiedzane przez młodzież i amatorów sportu. Brakuje nieco lepszego utrzymania, ale ogólnie jest akceptowalne.', '11', '2', '3', '2023-11-05'),
    ('Duży kompleks sportowy oferujący różnorodne obiekty i zajęcia. Infrastruktura wymaga pewnej modernizacji, ale ogólnie jest to solidne miejsce do uprawiania sportu.', '12', '2', '4', '2023-11-15'),
    ('Nowoczesny kompleks sportowy, głównie dla studentów, ale otwarty dla wszystkich. Oferuje różnorodne zajęcia i doskonałe warunki do treningu.', '13', '2', '5', '2023-12-12'),
    ('Standardowe boisko szkolne, wykorzystywane głównie przez uczniów i lokalną społeczność. Potrzebuje odświeżenia, ale spełnia swoje podstawowe funkcje.', '14', '2', '3', '2023-11-18'),
    ('Interesujące miejsce dla miłośników strzelectwa. Organizowane są tu różne konkursy i warsztaty.', '15', '2', '4', '2023-12-01'),
    ('Majestatyczny stadion z bogatą historią sportową. Doskonałe miejsce na wielkie wydarzenia sportowe i koncerty.', '16', '2', '5', '2023-12-10'),
    ('Klub z długoletnią tradycją i lojalną społecznością. Świetne miejsce dla miłośników piłki nożnej i lokalnych rozgrywek.', '17', '2', '4', '2023-11-25'),
    ('Nowoczesny klub fitness z profesjonalną obsługą i różnorodnymi zajęciami. Idealne miejsce dla osób dbających o kondycję i zdrowie.', '18', '2', '5', '2023-12-05'),
    ('Wspaniałe centrum hokejowe, gdzie rozwijają się zarówno profesjonaliści, jak i amatorzy tego sportu. Doskonała infrastruktura.', '19', '2', '5', '2023-12-02'),
    ('Innowacyjne podejście do ćwiczeń na świeżym powietrzu. Świetne miejsce dla tych, którzy cenią sobie trening na wolnym powietrzu.', '20', '2', '4', '2023-11-15'),
    ('Popularne boiska, często zajęte przez entuzjastów koszykówki. Potrzebują nieco lepszego utrzymania, ale są w dobrym stanie ogólnym.', '21', '2', '3', '2023-11-10'),
    ('Przyjazna pływalnia dla rodzin i osób szukających relaksu. Czysta woda i dobre warunki.', '22', '2', '4', '2023-11-20'),
    ('Świetne miejsce dla fanatyków fitnessu i zdrowego stylu życia. Różnorodne zajęcia i kompetentna kadra instruktorska.', '23', '2', '5', '2023-12-08'),
    ('Standardowe boiska, wykorzystywane przez lokalną społeczność i szkoły. Potrzebują regularnej konserwacji.', '24', '2', '3', '2023-11-28'),
    ('Profesjonalna strzelnica oferująca szkolenia dla początkujących i zaawansowanych strzelców. Bezpieczne i dobrze zarządzane miejsce.', '25', '2', '4', '2023-12-01'),
    ('Klub fitness z energiczną atmosferą i nowoczesnym wyposażeniem. Doskonałe miejsce do osiągania fitnessowych celów.', '26', '2', '4', '2023-11-18'),
    ('Doskonałe miejsce dla miłośników tenisa, zarówno amatorów, jak i profesjonalistów. Dobrze utrzybane korty i przyjazna atmosfera.', '27', '2', '5', '2023-01-10'),
    ('Luksusowy klub fitness oferujący szeroki zakres usług i wysokiej jakości sprzęt. Idealne miejsce dla osób poszukujących profesjonalnej opieki.', '28', '2', '5', '2023-01-05'),
    ('Standardowe boisko, często wykorzystywane przez lokalną społeczność do różnych sportowych aktywności.', '29', '2', '3', '2023-01-12'),
    ('Niezwykłe połączenie siłowni na świeżym powietrzu z możliwością relaksu przy sztucznym stawie. Ciekawa propozycja dla aktywnych na świeżym powietrzu.', '30', '2', '4', '2023-01-08'),
    ('Świetna alternatywa dla tradycyjnych siłowni. Oferuje świetne widoki i świeże powietrze podczas treningu.', '31', '2', '4', '2023-01-07'),
    ('Znakomita rozrywka dla osób lubiących aktywność w pomieszczeniach. Idealne miejsce do rywalizacji z przyjaciółmi.', '32', '2', '4', '2023-01-09'),
    ('Prosta, ale funkcjonalna bieżnia, świetna do krótkich biegów i rozgrzewki.', '33', '2', '3', '2023-01-11'),
    ('Miejsce, gdzie miłośnicy sportów ekstremalnych mogą rozwijać swoje umiejętności. Dobrze zaprojektowany i utrzymany skatepark.', '34', '2', '4', '2023-01-14'),
    ('Duży kompleks sportowy oferujący różnorodne możliwości aktywnego spędzania czasu.', '35', '2', '5', '2023-01-13')
;