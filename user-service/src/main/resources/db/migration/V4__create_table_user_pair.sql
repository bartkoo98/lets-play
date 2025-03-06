CREATE TABLE UserPair (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user1_id BIGINT NOT NULL,
    user2_id BIGINT NOT NULL,
    status ENUM('pending', 'matched', 'blocked') DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (user1_id, user2_id),
    FOREIGN KEY (user1_id) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (user2_id) REFERENCES User(id) ON DELETE CASCADE
);
