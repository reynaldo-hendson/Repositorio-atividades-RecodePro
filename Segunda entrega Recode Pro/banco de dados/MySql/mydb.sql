use mydb;
show tables;
select * from cliente;

select * from pedido;
select * from pedido where IdCliente = "2";
select * from produto;
insert into produto(descricao,valorunit) values ("FOR - RIO",545.00);
select IdCliente, nomeCliente,cpf from cliente where IdCLiente = 1;
