CREATE DATABASE biblioteca;
USE Biblioteca;

CREATE TABLE Bibliotecario(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(255) NOT NULL,
Email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE livro(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    Titulo VARCHAR(255) NOT NULL,
    Autor VARCHAR(255) NOT NULL,
    Genero VARCHAR(100) NOT NULL,
    Status_Livro ENUM('Disponível', 'Emprestado', 'Reservado') DEFAULT 'Disponível',
    Data_Cadastro date not null,
	id_Bibliotecario BIGINT NOT NULL,
    FOREIGN KEY (id_Bibliotecario) REFERENCES Bibliotecario(id_Bibliotecario) );NCES bibliotecario(id)
);
