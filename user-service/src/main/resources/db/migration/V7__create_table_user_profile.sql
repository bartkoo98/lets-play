CREATE TABLE UserProfile (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              user_id BIGINT UNIQUE,
                              sex VARCHAR(20),
                              age INT,
                              avatar VARCHAR(255),
                              description TEXT,
                              city VARCHAR(100),
                              CONSTRAINT fk_user_profile_user FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE UserProfileLanguages (
                                        user_profile_id BIGINT NOT NULL,
                                        language VARCHAR(50) NOT NULL,
                                        CONSTRAINT fk_user_profile_languages_profile FOREIGN KEY (user_profile_id) REFERENCES UserProfile(id)
);