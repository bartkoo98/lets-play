INSERT INTO UserProfile (user_id, sex, age, avatar, description, city)
VALUES
    (1, 'MALE', 25, 'avatar1.jpg', 'Lubi podróże i sport.', 'WARSAW'),
    (2, 'FEMALE', 30, 'avatar2.png', 'Miłośniczka książek i kawy.', 'KRAKOW'),
    (3, 'OTHER', 28, 'avatar3.webp', 'Fan gier i technologii.', 'WROCLAW'),
    (4, 'MALE', 28, 'avatar4.webp', 'Fan tibii.', 'WROCLAW');

INSERT INTO UserProfileLanguages (user_profile_id, language)
VALUES
    (1, 'PL'),
    (2, 'ENG'),
    (4, 'PL'),
    (4, 'DE'),
    (3, 'PL');
