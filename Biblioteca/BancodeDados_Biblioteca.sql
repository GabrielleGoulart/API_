CREATE DATABASE Biblioteca;
USE Biblioteca;

CREATE TABLE Bibliotecario(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(255) NOT NULL,
Email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE Livro(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
id_bibliotecario BIGINT NOT NULL,
Titulo VARCHAR(255) NOT NULL,
Autor VARCHAR(255) NOT NULL,
Genero VARCHAR(100),
Status_Livro ENUM('Disponível', 'Emprestado', 'Reservado') DEFAULT 'Disponível', 
Data_Cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT fk_bibliotecario FOREIGN KEY (id_bibliotecario) 
							REFERENCES bibliotecario(id)
);
