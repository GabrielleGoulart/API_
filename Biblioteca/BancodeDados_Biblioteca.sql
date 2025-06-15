CREATE DATABASE Biblioteca;
USE Biblioteca;

CREATE TABLE Bibliotecario(
ID_Bibliotecario INT PRIMARY KEY AUTO_INCREMENT,
Nome VARCHAR(255) NOT NULL,
Email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE Livro(
    ID_Livro INT PRIMARY KEY AUTO_INCREMENT, 
    ID_Bibliotecario_Responsavel INT,
    Titulo VARCHAR(255) NOT NULL,
    Autor VARCHAR(255) NOT NULL,
    Genero VARCHAR(100),
    Status_Livro ENUM('Disponível', 'Emprestado', 'Reservado') DEFAULT 'Disponível', 
    Data_Cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ID_Bibliotecario_Responsavel) REFERENCES Bibliotecario(ID_Bibliotecario)
);