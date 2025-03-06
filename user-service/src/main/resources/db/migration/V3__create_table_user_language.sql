CREATE TABLE UserLanguage (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    language ENUM('PL', 'EN', 'DE', 'FR', 'ES') NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);
