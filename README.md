# 🥟 Baozi Store - API REST

Trabalho prático da disciplina de **Desenvolvimento Web Back-End** para o desenvolvimento de uma API REST baseada em uma loja de pãozinho chinês (*Baozi Store*), utilizando Java e o ecossistema Spring Boot.

---

## 🛠️ Tecnologias e Arquitetura

* **Linguagem:** Java
* **Framework:** Spring Boot & Spring Data JPA
* **Banco de Dados Relacional:** MySQL / H2
* **Ferramenta de Teste:** Postman
* **Arquitetura (MVC):** 
  * `model`: Entidades JPA (`Cliente`, `Produto`, `Pedido`)
  * `repository`: Interfaces de persistência de dados
  * `controller`: Endpoints REST da API

---

## 📋 Descrição do Estudo de Caso

A **Baozi Store** é uma pequena loja local que vende pão chinês. Para informatizar o controlo básico de clientes, produtos e pedidos, a API gere as seguintes entidades e relações:

* **Cliente:** Registo do cliente com nome e data de cadastro (`clienteDesde`).
* **Produto:** Gestão do pão chinês vendido por unidade (nome, preço e controlo de estoque/quantidade).
* **Pedido:** Registo que vincula um cliente a um produto comprado em determinada quantidade (`clienteId`, `produtoId`, `quantidade`).

---

## 🚀 Endpoints Implementados (Padrão REST)

Para cada entidade obrigatória (`/clientes`, `/produtos`, `/pedidos`), a API disponibiliza os seguintes endpoints:

* **`POST`** — Criar um novo registo.
* **`GET`** — Listar todos os registos.
* **`GET /{id}`** — Consultar um registo específico por ID.
* **`DELETE /{id}`** — Apagar um registo pelo ID.

---

## 🧪 Como Executar o Projeto

1. **Clonar o Repositório:**
   ```bash
   git clone [https://github.com/teu-utilizador/baozi-store-api.git](https://github.com/teu-utilizador/baozi-store-api.git)
