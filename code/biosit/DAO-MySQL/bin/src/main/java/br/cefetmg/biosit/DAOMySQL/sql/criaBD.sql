
/**
 * Author:  Pedro Gabriel
 * Created: 29 de out. de 2023
 */

CREATE DATABASE IF NOT EXISTS biositbd;

USE biositbd;

CREATE TABLE IF NOT EXISTS Pacientes (
    nome VARCHAR(25) NOT NULL,
    cpf VARCHAR(11) PRIMARY KEY,
    endereco VARCHAR(50),
    dataNascimento VARCHAR(20),
    rg VARCHAR(20),
    telefone VARCHAR(20)
);
