CREATE TABLE IF NOT EXISTS libri (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    titolo        VARCHAR(50) NOT NULL,
    autore        VARCHAR(50) NOT NULL,
    pubblicazione INT NOT NULL
);