<h1 align="center">
  Desafio Eloware 2023
</h1>

<div align="center">

  <h3>Construido com</h3>

  <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white" height="30px"/>
  <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" height="30px"/>

  <!-- Badges source: https://dev.to/envoy_/150-badges-for-github-pnk -->
</div>

<br/>

# Sumário

- [Documentação das rotas da API](#api)

  - [Rotas das Pessoas](#people-routes)
    - [Criar uma pessoa](#post-people)
    - [Editar uma pessoa](#put-people)
    - [Consultar uma pessoa](#get-people-by-id)
    - [Listar Pessoas](#get-people)
  - [Rotas dos Endereços](#address-routes)
    - [Criar um endereço](#post-address)
    - [Listar endereços da pessoa](#get-address-by-people)

  <div id='api'/>

# Documentação das rotas da API

<div id='people-routes'/>

## Rotas das Pessoas

<div id='post-people'/>

### Criar uma pessoa

```http
POST /people
```

<h3>Mandar pelo body da requisição:</h3>

| Parâmetro   | Tipo     | Descrição                      |
| :---------- | :------- | :----------------------------- |
| `name`      | `string` | **Obrigatório**; **não vazio** |
| `birthDate` | `string` | **Obrigatório**; **não vazio** |

<h3>Em caso de sucesso:</h3>

- Status code 201

```json
{
  "id": 1,
  "name": "José",
  "birthDate": "13/05/2002"
}
```

#

<div id='put-people'/>

### Editar uma pessoa

```http
PUT /people/{id}
```

<h3>Mandar pelo Params da requisição</h3>

| Parâmetro | Tipo   | Descrição                      |
| :-------- | :----- | :----------------------------- |
| `id`      | `Long` | **Obrigatório**; **não vazio** |

<h3>Mandar pelo body da requisição:</h3>

| Parâmetro   | Tipo     | Descrição                      |
| :---------- | :------- | :----------------------------- |
| `name`      | `string` | **Obrigatório**; **não vazio** |
| `birthDate` | `string` | **Obrigatório**; **não vazio** |

<h3>Em caso de sucesso:</h3>

- Status code 200

```json
{
  "id": 1,
  "name": "José",
  "birthDate": "13/05/2002"
}
```

#

<div id='get-people-by-id'/>

### Consultar uma pessoa

```http
GET /people/{id}
```

<h3>Mandar pelo Params da requisição</h3>

| Parâmetro | Tipo   | Descrição                      |
| :-------- | :----- | :----------------------------- |
| `id`      | `Long` | **Obrigatório**; **não vazio** |

<h3>Em caso de sucesso:</h3>

- Status code 200

```json
{
  "id": 1,
  "name": "José",
  "birthDate": "13/05/2002"
}
```

#

<div id='get-people'/>

### Listar pessoas

```http
GET /people
```

<h3>Em caso de sucesso:</h3>

- Status Code: 200

```json
[
  {
    "id": 1,
    "name": "José",
    "birthDate": "13/05/2002"
  },
  {
    "id": 2,
    "name": "Vinicius",
    "birthDate": "20/04/2002"
  }
]
```

#

<div id='adress-routes'/>

## Rotas dos Endereços

<div id='post-address'/>

### Criar um endereço

```http
POST /adress
```

<h3>Mandar pelo body da requisição:</h3>

| Parâmetro       | Tipo      | Descrição                      |
| :-------------- | :-------- | :----------------------------- |
| `peopleId`      | `number`  | **Obrigatório**; **não vazio** |
| `publicArea`    | `string`  | **Obrigatório**; **não vazio** |
| `cep`           | `string`  | **Obrigatório**; **não vazio** |
| `city`          | `string`  | **Obrigatório**; **não vazio** |
| `number`        | `string`  | **Obrigatório**; **não vazio** |
| `isMainAddress` | `boolean` | **Obrigatório**; **não vazio** |

<h3>Em caso de sucesso:</h3>

- Status code 201

```json
{
  "id": 1,
  "publicArea": "Avenida Getulio Vargas",
  "cep": "16920000",
  "number": "123",
  "city": "Castilho",
  "isMainAddress": false
}
```

#

<div id='get-address-by-people'/>

### Listar endereços da pessoa

```http
GET /address/people/{id}
```

<h3>Mandar pelo params da requisição:</h3>

| Parâmetro | Tipo     | Descrição                      |
| :-------- | :------- | :----------------------------- |
| `id`      | `number` | **Obrigatório**; **não vazio** |

<h3>Em caso de sucesso:</h3>

- Status code: 200

```json
[
  {
    "id": 1,
    "publicArea": "Avenida Getulio Vargas",
    "cep": "16920000",
    "number": "123",
    "city": "Castilho",
    "isMainAddress": false
  },
  {
    "id": 2,
    "publicArea": "Avenida Brasil",
    "cep": "16920000",
    "number": "123",
    "city": "Castilho",
    "isMainAddress": false
  }
]
```
