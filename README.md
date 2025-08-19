# Itaú Unibanco - Desafio de Programação

Este projeto consiste em um desafio de desenvolvimento de software e engenharia de software. O objetivo é criar uma **API REST** que recebe transações financeiras e retorna estatísticas sobre elas. O projeto foi desenvolvido utilizando **Java** e **Spring Boot**.

---

## 1. Introdução

O desafio propõe:

* Criar uma API REST que recebe transações (`POST /transacao`) e calcula estatísticas das transações dos últimos 60 segundos (`GET /estatistica`).
* Permitir que todas as transações sejam apagadas (`DELETE /transacao`).
* Trabalhar apenas com **dados em memória**.
* Seguir rigorosamente os formatos de JSON e endpoints especificados.

> **Observação:** A avaliação será feita considerando a **qualidade do código**, **clareza**, **organização**, **testes**, **segurança** e outros fatores.

---

## 2. Tecnologias Utilizadas

* Java 17+
* Spring Boot 3+
* Maven
* JUnit / Mockito (para testes)
* (Opcional) Docker para containerização

---

## 3. Funcionalidades da API

### 3.1. Receber Transações: `POST /transacao`

Recebe transações no seguinte formato:

```json
{
  "valor": 123.45,
  "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

**Regras de validação:**

* `valor` deve ser maior ou igual a 0
* `dataHora` não pode ser futura
* JSON deve estar no formato ISO 8601 para datas

**Respostas esperadas:**

| Status                   | Significado                              |
| ------------------------ | ---------------------------------------- |
| 201 Created              | Transação aceita e registrada            |
| 422 Unprocessable Entity | Transação inválida (ex.: valor negativo) |
| 400 Bad Request          | JSON mal formado ou não compreendido     |

### 3.2. Limpar Transações: `DELETE /transacao`

Apaga todas as transações armazenadas em memória.

**Resposta esperada:**

* `200 OK` — Todas as transações apagadas com sucesso

### 3.3. Calcular Estatísticas: `GET /estatistica`

Retorna estatísticas das transações dos últimos 60 segundos:

```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
```

* `count`: quantidade de transações
* `sum`: soma total das transações
* `avg`: média dos valores
* `min`: menor valor
* `max`: maior valor

> Se não houver transações nos últimos 60 segundos, todos os valores devem ser `0`.

---

## 4. Extras / Funcionalidades Adicionais

* **Testes automatizados:** Unitários e funcionais
* **Containerização:** Suporte a Docker
* **Logs:** Informações sobre operações realizadas
* **Healthcheck:** Endpoint de verificação de saúde da API
* **Performance:** Monitoramento do tempo de cálculo das estatísticas
* **Tratamento de erros:** Mensagens detalhadas para cada tipo de erro
* **Documentação da API:** Integrável com Swagger ou RAML
* **Configurações:** Tempo de cálculo das estatísticas configurável (padrão 60 segundos)

---

## 5. Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/CaioDalNegro/itau-transaction-challenge.git
cd itau-desafio
```

2. Execute com Maven:

```bash
mvn spring-boot:run
```

3. Teste os endpoints via **Postman**, **Insomnia** ou **curl**.

4. (Opcional) Build e execução via Docker:

```bash
docker build -t itau-desafio .
docker run -p 8080:8080 itau-desafio
```

---

## 6. Exemplos de Requisição

**POST /transacao**

```bash
curl -X POST http://localhost:8080/transacao \
-H "Content-Type: application/json" \
-d '{"valor": 150.0, "dataHora": "2025-08-18T12:00:00-03:00"}'
```

**GET /estatistica**

```bash
curl http://localhost:8080/estatistica
```

**DELETE /transacao**

```bash
curl -X DELETE http://localhost:8080/transacao
```

---

## 7. Observações Finais

* Todos os dados são **armazenados em memória** e não persistem após reinício da aplicação.
* Código organizado em camadas para **facilidade de manutenção e testes**.
* Todos os commits do repositório devem representar **evolução do projeto**, com mínimo de 3 commits correspondentes aos endpoints.
* Este README serve como documentação completa para entendimento, execução e teste da API.
