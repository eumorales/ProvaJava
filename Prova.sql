CREATE DATABASE prova;
USE prova;

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    endereco VARCHAR(255) NOT NULL,
    telefone VARCHAR(15) NOT NULL
);

INSERT INTO cliente (nome, cpf, endereco, telefone)
VALUES
    ('Gilberto', '123.456.789-00', 'Rua da minha casa 309', '(55) 987654321'),
    ('Maria', '234.567.890-11', 'Rua sei que la 3', '(55) 998765432'),
    ('Pedro', '345.678.901-22', 'Rua longe 23', '(55) 912345678'),
    ('Romeo', '456.789.012-33', 'Rua perto 40', '(55) 923455789'),
    ('Ricardo', '567.890.123-44', 'Rua tal tal tal 12', '(53) 934567890');

