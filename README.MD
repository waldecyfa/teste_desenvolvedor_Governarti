## CRIAR UMA API JAVA MAVEM PIlOTOS DE CORRIDA

<h4 align="left">
TESTE DESENVOLVEDOR - GOVERNARTI
 CRUD DRIVERS Concluído 
</h4>

<!--ts-->

* [Passo a Passo](#features)
* [Tecnologias](#tecnologias)
* [Pre-requisitos](#prerequisitos)
* [Baixar e executar](#baixar)
* [Exemplo de utilização dos verbos HTML](#como-usar)
    * [POST](#exemplo-json-body-post)
    * [PUT](#exemplo-json-body-put)
    * [GET by ID](#exemplo-json-sada-get-by-id)
   
<!--te-->


### Passo a Passo

- [x] Busca de Clientes pagindo com verbo GET /drivers
- [x] Busca de Clientes por id com verbo GET /drivers/id
---

### Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Spring Boot](https://spring.io/projects)
- [Java 11](https://docs.oracle.com/en/java/javase/11/)
- [Hibernate + JPA](https://hibernate.org/)
- [SQL]

--

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:

* IDE para desenvolvimento JAVA como Eclipse(a mesma que usei) ou Spring Tool Suite 4
* Gerenciador de dependencias maven
* para testar os verbos HTTP utilizo o Postman

---

### Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone <https://github.com/waldecyfa/teste_desenvolvedor_Governarti.git>

# Importe o projeto na sua IDE

# Aguarde a sincronização das dependencias do Maven

# Execute a aplicação (está no profile test por se tratar de um projeto desenvolvido com intuito de estudo)

#caso queira alterar o seed do banco de dados altere os dados no arquivo resoruces/data.sql

# O servidor inciará na porta:8087 - abra o Insominia/Postman e execute os verbos HTML na url <http://localhost:8087/drivers>

```

---

###Exemplo JSON body POST Endpoint
#### Enviar no caminho: http://localhost:8087/drivers/winning
```bash
{
  "name": "Hamilton",
  "nationality": "British",
  "birthDate": "1985-01-07T10:30:00Z"
 
}
```

###Exemplo JSON body GET Endpoint
#### Enviar no caminho: http://localhost:8087/drivers/winning
```bash
{
  "name": "Heidfeld",
  "nationality": "German",
  "birthDate": "1977-05-10T10:30:00Z"
 
}
```


###Exemplo JSON Saída GET by ID Endpoint
#### Enviar no caminho: http://localhost:8087/drivers/winning/4
```bash
{
  "id": 4,
  "name": "Rosberg",
  "nationality": "German",
  "birthDate": "1985-06-27T20:50:07.123450Z"
 
}
```

###Exemplo JSON Saída GET all pageable Endpoint
#### Enviar no caminho: http://localhost:8087/drivers?page=0&linesPerPage=6&direction=ASC&orderBy=name
```bash
{
  "content": [
    {
      "id": 13,
      "name": "Kovailainem",
      "nationality": "Finish",
      "birthDate": "1981-07-29T20:50:07.123450Z"
     
    },
    {
      "id": 10,
      "name": "Alonso",
      "nationality": "Spaninsh",
      "birthDate": "1981-07-29T20:50:07.123450Z"
      
    },
    {
      "id": 3,
      "name": "Nakajima",
      "nationality": "Japan",
      "birthDate": "1985-01-11T20:50:07.123450Z",
      
    },
    {
      "id": 1,
      "name": "Bourdais",
      "nationality": "French",
      "birthDate": "1979-02-28T20:50:07.123450Z"
      
    },
    {
      "id": 8,
      "name": "Glock",
      "nationality": "German",
      "birthDate": "1982-03-18T20:50:07.123450Z"
     
    },
    {
      "id": 12,
      "name": "Sato",
      "nationality": "12585269354",
      "birthDate": "1977-01-28T20:50:07.123450Z"
      
    }
  ],
  "pageable": {
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    },
    "pageNumber": 0,
    "pageSize": 6,
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "last": false,
  "totalPages": 3,
  "totalElements": 14,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "first": true,
  "number": 0,
  "numberOfElements": 6,
  "size": 6,
  "empty": false
}
```
