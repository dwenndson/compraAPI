# Sistema de Cadastro de Compras

**Uma API RESTful para gerenciar compras de forma eficiente.**

## Introdução

Este projeto tem como objetivo criar API de comprar para teste tecnico da NTConsult

## Funcionalidades

* **Cadastro de Compras:** Cadastre novas compras com validação do limite de compras por CPF.
* **Busca de Compras:** Realize buscas flexíveis por diversos critérios, como CPF, produto e data.
* **Relatórios de Vendas:** Gere relatórios personalizados para analisar as vendas por produto e período.

## Tecnologias

* **Spring Boot:** Framework Java para desenvolvimento rápido de aplicações web.
* **Spring Data JPA:** Simplicidade na persistência de dados.
* **H2 Database:** Banco de dados leve e ideal para desenvolvimento.
* **Spring Validation:** Validação de dados de entrada.

**Exemplo de requisição:**

```bash
curl -X POST http://localhost:8080/compras -H "Content-Type: application/json" -d '{
  "cpf": "12345678901",
  "produto": "Smartphone",
  "quantidade": 1,
  "valorUnitario": 1500
}'
