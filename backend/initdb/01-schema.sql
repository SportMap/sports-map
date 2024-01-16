CREATE TABLE address (
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
                        phone_number VARCHAR(15)

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
                      nickname VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      salt CHAR(16) NOT NULL,
                      avatar VARCHAR(255) NOT NULL
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