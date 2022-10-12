create schema java_crud;
use java_crud;
create table clientes(
	id int not null primary key auto_increment,
    nome varchar(40),
    cpf char(11),
    nascimento date,
    situacao char(7)

);

select * from clientes;

CREATE TABLE pedido (
    id int not null auto_increment PRIMARY KEY,
    idCliente int,
    quantidade int,
    idProduto int,
    dataPedido date,
    dataViagem date
);

select *from pedido;
select idCliente,

SELECT * FROM pedido WHERE idCliente =1; 

CREATE TABLE produto(
    id int not null auto_increment PRIMARY KEY,
    descricao varchar(50),
    valor double
);
select * from produto;
insert into produto(descricao,valor) values ("SAO - RIO",198.35);

select *from pedido;
update pedido set idCliente = 8 where id = 7;

select * from pedido where idCliente = 3;

select * from pedido,produto;



