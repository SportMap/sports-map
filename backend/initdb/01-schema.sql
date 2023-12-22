CREATE TABLE address (
                         id SERIAL PRIMARY KEY,
                         street VARCHAR(255),
                         postal_code VARCHAR(10),
                         building_number VARCHAR(10),
                         apartment_number VARCHAR(10),
                         city VARCHAR(255)
);

CREATE TABLE object (
                        id SERIAL PRIMARY KEY,
                        name CHAR(255) NOT NULL,
                        description TEXT,
                        website VARCHAR(255),
                        surface VARCHAR(255),
                        category VARCHAR(255),
                        coordinates VARCHAR(255),
                        address_id INT NOT NULL,
                        FOREIGN KEY (address_id) REFERENCES address(id)
);

CREATE TABLE opening_hours (
                               id SERIAL PRIMARY KEY,
                               opening_time TIME,
                               closing_time TIME,
                               open_24_7 BOOLEAN,
                               object_id INT NOT NULL,
                               monday BOOLEAN NOT NULL,
                               tuesday BOOLEAN NOT NULL,
                               wednesday BOOLEAN NOT NULL,
                               thursday BOOLEAN NOT NULL,
                               friday BOOLEAN NOT NULL,
                               saturday BOOLEAN NOT NULL,
                               sunday BOOLEAN NOT NULL,
                               FOREIGN KEY (object_id) REFERENCES object(id)
);

CREATE TABLE event (
                       id SERIAL PRIMARY KEY,
                       description TEXT,
                       object_id INT NOT NULL,
                       category VARCHAR(255),
                       start_time TIMESTAMP,
                       end_time TIMESTAMP,
                       FOREIGN KEY (object_id) REFERENCES object(id)
);

CREATE TABLE user (
                      id SERIAL PRIMARY KEY,
                      nickname VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      salt CHAR(16) NOT NULL
);

CREATE TABLE user_event (
                            id SERIAL PRIMARY KEY,
                            user_id INT NOT NULL,
                            event_id INT NOT NULL,
                            FOREIGN KEY (user_id) REFERENCES user(id),
                            FOREIGN KEY (event_id) REFERENCES event(id)
);

CREATE TABLE review (
                        id SERIAL PRIMARY KEY,
                        content TEXT,
                        object_id INT NOT NULL,
                        user_id INT NOT NULL,
                        FOREIGN KEY (object_id) REFERENCES object(id),
                        FOREIGN KEY (user_id) REFERENCES user(id)
);
