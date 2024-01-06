INSERT INTO address (street, postal_code, building_number, apartment_number, city)
VALUES ('123 Maple Street', '12345', '10', '2A', 'Springfield'),
       ('456 Oak Avenue', '67890', '20', '3B', 'Greenville'),
       ('456 Oak Street', '45321', '20', '3B', 'Springfield'),
       ('456 Maple Avenue', '67890', '20', '3B', 'Greenville'),
       ('789 Pine Road', '11223', '30', '4C', 'Rivertown');


INSERT INTO sport_complexes (name, description, website, surface, category, latitude, longitude, address_id, open_24_7) VALUES
('Olympia Arena', 'A large outdoor stadium suitable for various sports, including running and team sports.', 'www.olympiaarena.com', 'GRASS', 'ATHLETICS', 54.361206, 18.658292, 1, FALSE),
('Aqua Sports Center', 'Indoor aquatic center with Olympic-size pools and diving facilities.', 'www.aquasportscenter.com', 'ARTIFICIAL_TURF', 'SWIMMING', 54.372158, 18.620951, 2, TRUE),
('Mountain Bike Park', 'Outdoor complex with trails and tracks for mountain biking enthusiasts.', 'www.mountainbikepark.com', 'CLAY', 'STRENGTH_SPORTS', 54.380570, 18.598446, 3, FALSE),
('Urban Fitness Hub', 'State-of-the-art fitness center with modern equipment and facilities.', 'www.urbanfitnesshub.com', 'WOODEN_FLOOR', 'FITNESS', 54.348629, 18.659222, 4, TRUE),
('Green Field Soccer Complex', 'Spacious outdoor fields suitable for football and other team sports.', 'www.greenfieldsoccer.com', 'SYNTHETIC_TRACK', 'FOOTBALL', 54.352025, 18.646638, 5, FALSE);


INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES (6, '06:27', '06:51', 2),
       (2, '08:10', '13:24', 2),
       (5, '08:21', '23:59', 2),
       (1, '01:09', '03:54', 2),
       (6, '18:11', '04:38', 3);

INSERT INTO users (nickname, email, password, salt)
VALUES
    ('UserOne', 'userone@example.com', 'password123', 'a1b2c3d4e5f6g7h8'),
    ('UserTwo', 'usertwo@example.com', 'password456', 'h8g7f6e5d4c3b2a1'),
    ('UserThree', 'userthree@example.com', 'password789', '1a2b3c4d5e6f7g8h'),
    ('UserFour', 'userfour@example.com', 'password101', '8h7g6f5e4d3c2b1a'),
    ('UserFive', 'userfive@example.com', 'password102', '1a1b1c1d1e1f1g1h');



INSERT INTO reviews (content, sport_complex_id, user_id)
VALUES
    ('Great facilities and well-maintained fields.', 1, 1),
    ('The staff is friendly and the equipment is top-notch.', 2, 2),
    ('Excellent location for swimming competitions, clean and accessible.', 3, 3),
    ('The gym has a wide range of equipment and is rarely overcrowded.', 4, 4),
    ('Perfect for weekend soccer games, the turf is in great condition.', 5, 5);

INSERT INTO events (description, sport_complex_id, start_time, end_time)
VALUES
    ('City Crossfit Challenge', 1, '2023-07-15 14:00:00', '2023-07-15 17:00:00'),
    ('National Gymnastics Competition', 2, '2023-08-20 09:00:00', '2023-08-20 18:00:00'),
    ('Urban Ice Skating Showdown', 3, '2023-09-10 06:00:00', '2023-09-10 14:00:00'),
    ('Beach Volleyball Summer Cup', 4,'2023-10-05 10:00:00', '2023-10-08 20:00:00'),
    ('Extreme Sports Expo 2023', 5, '2023-11-15 17:00:00', '2023-11-15 21:00:00');

INSERT INTO users_events (user_id, event_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);