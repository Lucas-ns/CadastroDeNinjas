-- V1: Criar as tabelas tb_missoes e tb_ninjas

CREATE TABLE tb_missoes(
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    dificuldade VARCHAR(50)
);

CREATE TABLE tb_ninjas(
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    idade INT,
    email VARCHAR(255) UNIQUE,
    missao_id INT,
    CONSTRAINT fk_missao FOREIGN KEY (missao_id) REFERENCES tb_missoes(id)
);