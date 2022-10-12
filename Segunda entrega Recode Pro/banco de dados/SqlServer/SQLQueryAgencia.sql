create database mydb;

use mydb;

/* Lógico_agenciaf: */

CREATE TABLE CLIENTE (
    IdCliente INT PRIMARY KEY,
    nomeCliente varchar(50),
    cidade varchar(50),
    uf varchar(50),
    cep varchar(50),
    cpf varchar(50),
    logadouro varchar(50),
    telefoneCelular varchar(50),
    dataCadastro varchar(50)
);

CREATE TABLE PEDIDO (
    NumPedido int PRIMARY KEY,
    IdCliente int,
    dataPedido varchar(50),
    dataViagem varchar(50),
    FK_CLIENTE_IdCliente INT
);

CREATE TABLE ItensPedido (
    IdItemPedido int PRIMARY KEY,
    NumPedido int,
    IdProduto int,
    Quantidade int,
    valorTotal decimal
);

CREATE TABLE PRODUTO (
    IdProduto int PRIMARY KEY,
    Descricao varchar(50),
    ValorUnit int
);

select * from CLIENTE
select * from PEDIDO