# Marvel Rivals Java API

API REST desenvolvida em **Java com Spring Boot** para estudar desenvolvimento back-end e consumir dados do universo de _Marvel Rivals_. A aplicação disponibiliza endpoints para consultar heróis, mapas, skins e informações de proficiência, encaminhando as requisições para uma API externa.

> **Status:** projeto de estudo em desenvolvimento.

## Sumário

- [Sobre o projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Tecnologias](#tecnologias)
- [Arquitetura](#arquitetura)
- [Pré-requisitos](#pré-requisitos)
- [Configuração](#configuração)
- [Como executar](#como-executar)
- [Endpoints](#endpoints)
- [Exemplos de requisição](#exemplos-de-requisição)
- [Tratamento de erros](#tratamento-de-erros)
- [Possíveis melhorias](#possíveis-melhorias)
- [Contribuição](#contribuição)
- [Aviso legal](#aviso-legal)

## Sobre o projeto

O **Marvel Rivals Java API** é uma aplicação REST construída com Spring Boot. Ela funciona como uma camada intermediária entre clientes HTTP e uma API externa que fornece dados de Marvel Rivals.

O projeto tem como objetivo praticar conceitos importantes do desenvolvimento back-end, como criação de controllers e services, organização de rotas REST, consumo de APIs externas, injeção de dependências e configuração de credenciais.

## Funcionalidades

- Consulta da lista de heróis.
- Consulta de heróis por ID.
- Listagem de mapas.
- Consulta de skins associadas a um herói.
- Consulta de detalhes de uma skin.
- Consulta de recompensas de proficiência.
- Consulta de missões de proficiência.
- Consulta dos níveis de proficiência.

## Tecnologias

| Tecnologia        | Utilização                               |
| ----------------- | ---------------------------------------- |
| Java 21           | Linguagem de programação                 |
| Spring Boot 4.1.2 | Estrutura principal da aplicação         |
| Spring Web MVC    | Criação dos endpoints HTTP               |
| Spring RestClient | Consumo da API externa                   |
| Lombok            | Redução de código repetitivo             |
| Maven             | Gerenciamento de dependências e execução |

## Arquitetura

O projeto organiza as responsabilidades em pacotes:

| Pacote       | Responsabilidade                                           |
| ------------ | ---------------------------------------------------------- |
| `controller` | Recebe as requisições HTTP e expõe os endpoints            |
| `service`    | Coordena as consultas e chama o cliente externo            |
| `client`     | Configura o `RestClient` e realiza as requisições externas |
| `constants`  | Centraliza os caminhos utilizados na API externa           |

O fluxo de uma requisição é:

`Cliente HTTP → Controller → Service → RestClient → API externa`

Atualmente, os serviços retornam as respostas externas como `String`, sem transformar o conteúdo em DTOs próprios.

## Pré-requisitos

Antes de executar a aplicação, instale:

- [JDK 21](https://adoptium.net/)
- [Git](https://git-scm.com/)
- Uma chave de API válida e a URL base do serviço externo utilizado pelo projeto.

O repositório contém o Maven Wrapper, portanto não é necessário instalar o Maven separadamente.

## Configuração

A aplicação utiliza duas propriedades:

- `API.LINK`: URL base da API externa.
- `API.KEY`: chave de autenticação enviada pelo cabeçalho `x-api-key`.

Configure essas propriedades em `src/main/resources/application.properties`. Caso o arquivo ainda não exista, crie-o:

```properties
API.LINK=${API_LINK}
API.KEY=${API_KEY}
```

Defina `API_LINK` e `API_KEY` no ambiente com os valores fornecidos pelo serviço externo. Como alternativa, você pode informar os valores diretamente no arquivo local, mas **não publique sua chave de API no GitHub**.

A URL base e a chave corretas são necessárias para que as consultas externas funcionem.

## Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/lucimarjo/marvel-rivals-java-api.git
cd marvel-rivals-java-api
```

### 2. Configure as propriedades

Preencha as configurações da API externa conforme explicado na seção anterior.

### 3. Inicie a aplicação

**Linux / macOS:**

```bash
./mvnw spring-boot:run
```

**Windows:**

```powershell
.\mvnw.cmd spring-boot:run
```

Por padrão, o Spring Boot utiliza a porta `8080`, salvo configuração diferente.

A base local será:

```text
http://localhost:8080
```

## Endpoints

Todos os endpoints documentados abaixo utilizam o método HTTP `GET`.

| Método | Endpoint                    | Descrição                                           |
| ------ | --------------------------- | --------------------------------------------------- |
| `GET`  | `/heroes/all`               | Retorna a lista de heróis                           |
| `GET`  | `/heroes/{id}`              | Consulta um herói pelo ID                           |
| `GET`  | `/maps`                     | Retorna a lista de mapas                            |
| `GET`  | `/skins?heroId={heroId}`    | Consulta as skins de um herói                       |
| `GET`  | `/skins/{skinId}`           | Consulta os detalhes de uma skin                    |
| `GET`  | `/proficiency/{id}/rewards` | Consulta as recompensas de proficiência de um herói |
| `GET`  | `/proficiency/{id}/quests`  | Consulta as missões de proficiência de um herói     |
| `GET`  | `/proficiency/levels`       | Retorna os níveis de proficiência                   |

### Parâmetros

| Parâmetro | Tipo    | Descrição                                           |
| --------- | ------- | --------------------------------------------------- |
| `id`      | Inteiro | Identificador do herói                              |
| `heroId`  | Inteiro | Identificador do herói utilizado para filtrar skins |
| `skinId`  | Inteiro | Identificador da skin                               |

Substitua os parâmetros entre chaves pelos valores desejados. Por exemplo, `/heroes/1050` consulta o herói de ID `1050`.

## Exemplos de requisição

Com a aplicação em execução, você pode testar os endpoints pelo navegador, pelo [Postman](https://www.postman.com/), pelo [Insomnia](https://insomnia.rest/) ou pelo terminal com `curl`.

### Listar heróis

```bash
curl http://localhost:8080/heroes/all
```

### Consultar um herói por ID

```bash
curl http://localhost:8080/heroes/1050
```

### Listar mapas

```bash
curl http://localhost:8080/maps
```

### Consultar skins de um herói

```bash
curl "http://localhost:8080/skins?heroId=1050"
```

### Consultar detalhes de uma skin

```bash
curl http://localhost:8080/skins/1
```

### Consultar recompensas de proficiência

```bash
curl http://localhost:8080/proficiency/1050/rewards
```

### Consultar missões de proficiência

```bash
curl http://localhost:8080/proficiency/1050/quests
```

### Consultar níveis de proficiência

```bash
curl http://localhost:8080/proficiency/levels
```

> Os IDs usados nos exemplos são ilustrativos. A existência de cada registro depende dos dados disponíveis na API externa.

## Possíveis melhorias

Algumas evoluções que podem fortalecer o projeto:

- Implementar DTOs para tipar as respostas.
- Padronizar o tratamento de exceções e os códigos HTTP.
- Adicionar validação de parâmetros.
- Criar testes automatizados para controllers e services.
- Documentar a API com OpenAPI/Swagger.
- Implementar logs e configurações separadas por ambiente.
- Avaliar cache para reduzir chamadas repetidas à API externa.

## Aviso legal

Este é um projeto independente de estudo e **não é afiliado, endossado ou mantido pela Marvel Games ou pela NetEase Games**. Marvel Rivals e os nomes, personagens e demais elementos relacionados pertencem aos respectivos titulares.

O funcionamento da aplicação depende da disponibilidade e das condições de uso da API externa configurada.
