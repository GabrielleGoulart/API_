-- Criar o banco de dados
CREATE DATABASE ControleEstoque;
USE ControleEstoque;

-- Criar tabela usuario
CREATE TABLE usuario (
  id_usuario INT AUTO_INCREMENT PRIMARY KEY,
  nome_usuario VARCHAR(150) NOT NULL,
  endereço VARCHAR(200) NOT NULL,
  setor VARCHAR(100) NOT NULL
);

-- Criar tabela produtos
CREATE TABLE produtos (
  id_produto INT AUTO_INCREMENT PRIMARY KEY,
  nome_produto VARCHAR(150) NOT NULL,
  quantidade INT NOT NULL,
  status_produto VARCHAR(20) NOT NULL
);

-- Criar tabela saida
CREATE TABLE saida (
  id_saida INT AUTO_INCREMENT PRIMARY KEY,
  data_ DATETIME,
  id_usuario INT NOT NULL,
  id_produto INT NOT NULL,
  quantidade_saida INT,
  FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
  FOREIGN KEY (id_produto) REFERENCES produtos(id_produto)
);

-- Inserir dados na tabela usuario
INSERT INTO usuario (nome_usuario, endereço, setor) VALUES
('João Silva', 'Rua A, 123', 'Financeiro'),
('Maria Oliveira', 'Av. Central, 45', 'RH'),
('Carlos Souza', 'Rua B, 99', 'TI'),
('Ana Paula', 'Travessa das Flores, 7', 'TI'),
('Rafael Lima', 'Rua C, 888', 'Logística');

-- Inserir dados na tabela produtos
INSERT INTO produtos (nome_produto, quantidade, status_produto) VALUES
('Caneta Azul', 100, 'Ativo'),
('Caderno 200 folhas', 50, 'Ativo'),
('Monitor 24"', 10, 'Ativo'),
('Teclado USB', 30, 'Ativo'),
('Mouse Óptico', 25, 'Ativo');

-- Inserir dados na tabela saida
INSERT INTO saida (data_, id_usuario, id_produto, quantidade_saida) VALUES
(NOW(), 1, 1, 5),
(NOW(), 2, 2, 2),
(NOW(), 3, 3, 1),
(NOW(), 4, 4, 3),
(NOW(), 5, 1, 3);
