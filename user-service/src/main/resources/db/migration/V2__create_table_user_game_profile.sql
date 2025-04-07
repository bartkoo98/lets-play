CREATE TABLE UserGameProfile (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    game VARCHAR(255) NOT NULL,
    elo VARCHAR(255),
    approach VARCHAR(255),
    role VARCHAR(255),
    peak VARCHAR(255),
    accountLink VARCHAR(255),
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);
