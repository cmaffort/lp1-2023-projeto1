
/**
 * Author:  Pedro Gabriel
 * Created: 29 de out. de 2023
 */

CREATE DATABASE IF NOT EXISTS biositbd;

USE biositbd;

CREATE TABLE IF NOT EXISTS pacientes (
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) PRIMARY KEY,
    endereco VARCHAR(100),
    dataNascimento VARCHAR(20),
    rg VARCHAR(20),
    telefone VARCHAR(20)
);

CREATE TABLE prontuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cpf CHAR(11) NOT NULL,
    titulo VARCHAR(20) NOT NULL,
    dataReg VARCHAR(20) NOT NULL,
    descricao VARCHAR(500) NOT NULL
);

CREATE TABLE IF NOT EXISTS Usuario (
    idUsuario INT PRIMARY KEY,
    nomeUsuario VARCHAR(50),
    senhaUsuario VARCHAR(50),
    tipoUsuario VARCHAR(20)
);

INSERT INTO Usuario (idUsuario, nomeUsuario, senhaUsuario, tipoUsuario)
VALUES
    (1, 'admin', '123', 'admin'),
    (2, 'medico', '123', 'medico'),
    (3, 'secretario','123','secretario'),
    (4, 'sec2','123','secretarioTriagem'),
    (5, 'enfermeiro','123','enfermeiro');
