CREATE TABLE adres (
                       id SERIAL PRIMARY KEY,
                       ulica VARCHAR(255),
                       kod_pocztowy VARCHAR(10),
                       nr_budynku VARCHAR(10),
                       nr_lokalu VARCHAR(10),
                       miasto VARCHAR(255)
);


CREATE TABLE obiekt (
                        id SERIAL PRIMARY KEY,
                        nazwa CHAR(255) NOT NULL,
                        opis TEXT,
                        strona VARCHAR(255),
                        nawierzchnia VARCHAR(255),
                        kategoria VARCHAR(255),
                        koordynaty VARCHAR(255),
                        adres_id INT NOT NULL,
                        FOREIGN KEY (adres_id) REFERENCES adres(id)
);

CREATE TABLE godziny_otwarcia (
                                  id SERIAL PRIMARY KEY,
                                  godzina_otwarcia TIME,
                                  godzina_zamkniecia TIME,
                                  otwarte_24_7 BOOLEAN,
                                  obiekt_id INT NOT NULL,
                                  poniedzialek BOOLEAN NOT NULL,
                                  wtorek BOOLEAN NOT NULL,
                                  sroda BOOLEAN NOT NULL,
                                  czwartek BOOLEAN NOT NULL,
                                  piatek BOOLEAN NOT NULL,
                                  sobota BOOLEAN NOT NULL,
                                  niedziela BOOLEAN NOT NULL,
                                  FOREIGN KEY (obiekt_id) REFERENCES obiekt(id)
);

CREATE TABLE wydarzenie (
                            id SERIAL PRIMARY KEY,
                            opis TEXT,
                            obiekt_id INT NOT NULL,
                            kategoria VARCHAR(255),
                            data_rozpoczecia TIMESTAMP,
                            data_zakonczenia TIMESTAMP,
                            FOREIGN KEY (obiekt_id) REFERENCES obiekt(id)
);


CREATE TABLE uzytkownik (
                            id SERIAL PRIMARY KEY,
                            nickname VARCHAR(255) NOT NULL,
                            email VARCHAR(255) NOT NULL,
                            haslo VARCHAR(255) NOT NULL,
                            sol CHAR(16) NOT NULL
);


CREATE TABLE uzytkownik_wydarzenie (
                                       id SERIAL PRIMARY KEY,
                                       uzytkownik_id INT NOT NULL,
                                       wydarzenie_id INT NOT NULL,
                                       FOREIGN KEY (uzytkownik_id) REFERENCES uzytkownik(id),
                                       FOREIGN KEY (wydarzenie_id) REFERENCES wydarzenie(id)
);


CREATE TABLE opinia (
                        id SERIAL PRIMARY KEY,
                        tresc TEXT,
                        obiekt_id INT NOT NULL,
                        uzytkownik_id INT NOT NULL,
                        FOREIGN KEY (obiekt_id) REFERENCES obiekt(id),
                        FOREIGN KEY (uzytkownik_id) REFERENCES uzytkownik(id)
);
