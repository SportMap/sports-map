INSERT INTO address (street, postal_code, building_number, apartment_number, city)
VALUES ('123 Maple Street', '12345', '10', '2A', 'Springfield'),
       ('456 Oak Avenue', '67890', '20', '3B', 'Greenville'),
       ('456 Oak Street', '45321', '20', '3B', 'Springfield'),
       ('456 Maple Avenue', '67890', '20', '3B', 'Greenville'),
       ('789 Pine Road', '11223', '30', '4C', 'Rivertown');


INSERT INTO sport_complexes
(name, description, website, surface, category, latitude, longitude, address_id, open_24_7, photo, phone_number, status)
VALUES
    ('New awaiting approval Olympic Fitness Center', 'An advanced fitness center with top-tier equipment and diverse training options.', 'http://www.newolympicfitness.com', 'ASFALT', 'BIEGANIE', 54.352025, 18.646638, 1, FALSE, 'new_olympic_fitness.jpg', '+48123456789', 'AWAITING_APPROVAL'),
    ('Green Park Wellness Center', 'Comprehensive wellness center offering various health and fitness services.', 'http://www.greenparkwellness.com', 'TRAWA', 'CROSSFIT', 54.356805, 18.658322, 2, TRUE, 'green_park_wellness.jpg', '+48111222334', 'APPROVED'),
    ('Mountain Peak Ski Lodge', 'Exclusive ski lodge with beginner to expert slopes and luxurious amenities.', 'http://www.mountainpeakski.com', 'LÓD', 'FITNESS', 54.341546, 18.649502, 3, FALSE, 'mountain_peak_ski.jpg', '+48123444556', 'APPROVED'),
    ('Sunset Yoga Retreat', 'Serene yoga retreat offering a variety of classes and wellness programs.', 'http://www.sunsetyoga.com', 'DREWNIANA_PODŁOGA', 'KOSZYKÓWKA', 54.360686, 18.635629, 4, FALSE, 'sunset_yoga.jpg', '+48123455667', 'APPROVED'),
    ('River Edge Tennis Academy', 'State-of-the-art tennis academy with professional training and facilities.', 'http://www.riveredgetennis.com', 'ASFALT', 'LEKKOATLETYKA', 54.348629, 18.676230, 5, TRUE, 'river_edge_tennis.jpg', '+48123466778', 'APPROVED'),
    ('New Olympic Fitness Center', 'An advanced fitness center with top-tier equipment and diverse training options.', 'http://www.newolympicfitness.com', 'ASFALT', 'BIEGANIE', 54.352025, 18.646638, 1, FALSE, 'new_olympic_fitness.jpg', '+48123456789', 'APPROVED'),
    ('Green Park Wellness Center', 'Comprehensive wellness center offering various health and fitness services.', 'http://www.greenparkwellness.com', 'TRAWA', 'CROSSFIT', 54.356805, 18.658322, 2, TRUE, 'green_park_wellness.jpg', '+48111222334', 'APPROVED'),
    ('Mountain Peak Ski Lodge', 'Exclusive ski lodge with beginner to expert slopes and luxurious amenities.', 'http://www.mountainpeakski.com', 'LÓD', 'FITNESS', 54.341546, 18.649502, 3, FALSE, 'mountain_peak_ski.jpg', '+48123444556', 'APPROVED'),
    ('Sunset Yoga Retreat', 'Serene yoga retreat offering a variety of classes and wellness programs.', 'http://www.sunsetyoga.com', 'DREWNIANA_PODŁOGA', 'KOSZYKÓWKA', 54.360686, 18.635629, 4, FALSE, 'sunset_yoga.jpg', '+48123455667', 'APPROVED'),
    ('River Edge Tennis Academy', 'State-of-the-art tennis academy with professional training and facilities.', 'http://www.riveredgetennis.com', 'ASFALT', 'LEKKOATLETYKA', 54.348629, 18.676230, 5, TRUE, 'river_edge_tennis.jpg', '+48123466778', 'APPROVED'),
    ('New Olympic Fitness Center', 'An advanced fitness center with top-tier equipment and diverse training options.', 'http://www.newolympicfitness.com', 'ASFALT', 'BIEGANIE', 54.352025, 18.646638, 1, FALSE, 'new_olympic_fitness.jpg', '+48123456789', 'APPROVED'),
    ('Green Park Wellness Center', 'Comprehensive wellness center offering various health and fitness services.', 'http://www.greenparkwellness.com', 'TRAWA', 'CROSSFIT', 54.356805, 18.658322, 2, TRUE, 'green_park_wellness.jpg', '+48111222334', 'APPROVED'),
    ('Mountain Peak Ski Lodge', 'Exclusive ski lodge with beginner to expert slopes and luxurious amenities.', 'http://www.mountainpeakski.com', 'LÓD', 'FITNESS', 54.341546, 18.649502, 3, FALSE, 'mountain_peak_ski.jpg', '+48123444556', 'APPROVED'),
    ('Sunset Yoga Retreat', 'Serene yoga retreat offering a variety of classes and wellness programs.', 'http://www.sunsetyoga.com', 'DREWNIANA_PODŁOGA', 'KOSZYKÓWKA', 54.360686, 18.635629, 4, FALSE, 'sunset_yoga.jpg', '+48123455667', 'APPROVED'),
    ('River Edge Tennis Academy', 'State-of-the-art tennis academy with professional training and facilities.', 'http://www.riveredgetennis.com', 'ASFALT', 'LEKKOATLETYKA', 54.348629, 18.676230, 5, TRUE, 'river_edge_tennis.jpg', '+48123466778', 'APPROVED'),
    ('New Olympic Fitness Center', 'An advanced fitness center with top-tier equipment and diverse training options.', 'http://www.newolympicfitness.com', 'ASFALT', 'BIEGANIE', 54.352025, 18.646638, 1, FALSE, 'new_olympic_fitness.jpg', '+48123456789', 'APPROVED'),
    ('Green Park Wellness Center', 'Comprehensive wellness center offering various health and fitness services.', 'http://www.greenparkwellness.com', 'TRAWA', 'CROSSFIT', 54.356805, 18.658322, 2, TRUE, 'green_park_wellness.jpg', '+48111222334', 'APPROVED'),
    ('Mountain Peak Ski Lodge', 'Exclusive ski lodge with beginner to expert slopes and luxurious amenities.', 'http://www.mountainpeakski.com', 'LÓD', 'FITNESS', 54.341546, 18.649502, 3, FALSE, 'mountain_peak_ski.jpg', '+48123444556', 'APPROVED'),
    ('Sunset Yoga Retreat', 'Serene yoga retreat offering a variety of classes and wellness programs.', 'http://www.sunsetyoga.com', 'DREWNIANA_PODŁOGA', 'KOSZYKÓWKA', 54.360686, 18.635629, 4, FALSE, 'sunset_yoga.jpg', '+48123455667', 'APPROVED'),
    ('River Edge Tennis Academy', 'State-of-the-art tennis academy with professional training and facilities.', 'http://www.riveredgetennis.com', 'ASFALT', 'LEKKOATLETYKA', 54.348629, 18.676230, 5, TRUE, 'river_edge_tennis.jpg', '+48123466778', 'APPROVED'),
    ('New Olympic Fitness Center', 'An advanced fitness center with top-tier equipment and diverse training options.', 'http://www.newolympicfitness.com', 'ASFALT', 'BIEGANIE', 54.352025, 18.646638, 1, FALSE, 'new_olympic_fitness.jpg', '+48123456789', 'APPROVED'),
    ('Green Park Wellness Center', 'Comprehensive wellness center offering various health and fitness services.', 'http://www.greenparkwellness.com', 'TRAWA', 'CROSSFIT', 54.356805, 18.658322, 2, TRUE, 'green_park_wellness.jpg', '+48111222334', 'APPROVED'),
    ('Mountain Peak Ski Lodge', 'Exclusive ski lodge with beginner to expert slopes and luxurious amenities.', 'http://www.mountainpeakski.com', 'LÓD', 'FITNESS', 54.341546, 18.649502, 3, FALSE, 'mountain_peak_ski.jpg', '+48123444556', 'APPROVED'),
    ('Sunset Yoga Retreat', 'Serene yoga retreat offering a variety of classes and wellness programs.', 'http://www.sunsetyoga.com', 'DREWNIANA_PODŁOGA', 'KOSZYKÓWKA', 54.360686, 18.635629, 4, FALSE, 'sunset_yoga.jpg', '+48123455667', 'APPROVED'),
    ('River Edge Tennis Academy', 'State-of-the-art tennis academy with professional training and facilities.', 'http://www.riveredgetennis.com', 'ASFALT', 'LEKKOATLETYKA', 54.348629, 18.676230, 5, TRUE, 'river_edge_tennis.jpg', '+48123466778', 'APPROVED');

INSERT INTO opening_hours (day_of_week, opening_time, closing_time, sport_complex_id)
VALUES (6, '06:27', '06:51', 2),
       (2, '08:10', '13:24', 2),
       (5, '08:21', '23:59', 2),
       (1, '01:09', '03:54', 2),
       (6, '18:11', '04:38', 3);

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
    ('itStartsInHolidays', 'asda.', 1, '2024-07-15 14:00:00', '2024-07-15 17:00:00', 'city_crossfit_challenge.jpg', 1),
    ('shouldBeAvailableNow', 'asda.', 1, '2024-01-13 14:00:00', '2024-02-15 17:00:00', 'city_crossfit_challenge.jpg', 1),
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

-- Setup location in Gdańsk
UPDATE sport_complexes SET latitude = 54.352025, longitude = 18.646638 WHERE id = 1; -- Central Gdańsk
UPDATE sport_complexes SET latitude = 54.356805, longitude = 18.658322 WHERE id = 2; -- Near Oliwa Park
UPDATE sport_complexes SET latitude = 54.341546, longitude = 18.649502 WHERE id = 3; -- Wrzeszcz district
UPDATE sport_complexes SET latitude = 54.360686, longitude = 18.635629 WHERE id = 4; -- Near Brzeźno Beach
UPDATE sport_complexes SET latitude = 54.348629, longitude = 18.676230 WHERE id = 5; -- Przymorze area
