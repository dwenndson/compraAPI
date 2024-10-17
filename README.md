#Sistema de Cadastro de Compras
Este projeto é uma API RESTful construída com Spring Boot para gerenciar um sistema de cadastro de compras. A API permite cadastrar compras, realizar buscas com base em filtros, e gerar relatórios de vendas. Além disso, inclui uma camada de tratamento de erros centralizada.

##Funcionalidades Principais
Cadastro de Compras: Cria novos registros de compras, com validações e regra cpf não pode comprar mais 3 produtos, mesmo em diferentes compras.
Busca de Compras: Permite buscar compras com filtros como CPF do comprador, nome do produto e intervalo de datas.
Relatório de Compras: Gera um relatório das compras em um período, agrupado por produto.

##Tecnologias Usadas
Spring Boot: Framework para criação de aplicações Java.
Spring Data JPA: Para persistência de dados.
H2 Database: Banco de dados em memória para facilitar o desenvolvimento e testes.
Spring Validation: Para validação de dados de entrada.
Controller Advice: Para tratamento centralizado de exceções. 
 
login do banco h2
rota: http://localhost:8080/h2-console/login.jsp
JDBC URL: jdbc:h2:mem:comprasdb
user: sa
senha: sa
