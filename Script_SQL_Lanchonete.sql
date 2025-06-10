-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS lanchoneteCRUD;
USE lanchoneteCRUD;

-- Tabela de usuários
CREATE TABLE IF NOT EXISTS user_tbl (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Inserção do usuário administrador
INSERT INTO user_tbl (username, password) VALUES
('admin', 'admin123');

-- Tabela de produtos
CREATE TABLE IF NOT EXISTS product_tbl (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pname VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    qty INT NOT NULL
);