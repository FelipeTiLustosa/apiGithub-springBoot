# API de Repositórios do GitHub com Spring Boot <img src="https://skillicons.dev/icons?i=spring,java" alt="Spring Boot and Java Icon" style="vertical-align: middle; height: 35px;"/>

## 1. Visão Geral

Este projeto implementa uma API para recuperar informações sobre repositórios de um usuário do GitHub, usando **Spring Boot**. Através de uma API RESTful, é possível consultar os repositórios de um usuário do GitHub, utilizando seu **Personal Access Token** para autenticação.

## 2. Funcionalidades

| Funcionalidade                  | Descrição                                                                 |
|---------------------------------|---------------------------------------------------------------------------|
| **Listar Repositórios**         | Recupera uma lista de repositórios de um usuário do GitHub, podendo filtrar por visibilidade. |
| **Autenticação via Token**      | O projeto autentica as requisições por meio de um **Personal Access Token** do GitHub. |
| **Customização da Visibilidade** | Filtra os repositórios do GitHub conforme a visibilidade (público ou privado). |

## 3. Tecnologias Utilizadas

- **Linguagem de Programação**: [Java](https://www.java.com/)
- **Framework Backend**: [Spring Boot](https://spring.io/projects/spring-boot)
- **WebClient**: Para realizar requisições HTTP para a API do GitHub.
- **Autenticação via Token**: Utiliza o Personal Access Token do GitHub para autenticação.
- **Gerenciamento de Dependências**: [Maven](https://maven.apache.org/)
- **IDE**: [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- **Gerenciamento de Versão**: [Git](https://git-scm.com/)

## 4. Estrutura de Pastas

Abaixo está a organização das pastas e classes do projeto:

```bash
github-api/
│
├── src/
│   ├── main/
│   │   ├── java/com/apiGithab/dev/
│   │   │   ├── client/                                           # Pacote contendo a lógica de comunicação com a API do GitHub
│   │   │   │   ├── GithubClient.java                             # Interface que define as chamadas à API do GitHub
│   │   │   │   ├── githubClientConfig.java                       # Configuração do WebClient para interagir com a API GitHub
│   │   │   │   ├── RepositoryResponse.java                       # Classe que representa a resposta da API de repositórios do GitHub
│   │   │   ├── controller/                                        # Controladores REST
│   │   │   │   ├── ApiController.java                            # Controlador para lidar com as requisições da API
│   ├── resources/
│   │   ├── application.properties                                # Configurações do Spring Boot
│
├── DemoApplication.java                                            # Classe principal que inicia a aplicação
└── pom.xml                                                        # Gerenciador de dependências do projeto
```

## 5. Endpoints da API

Abaixo estão os endpoints disponíveis na API, juntamente com exemplos de requisições:

| **Método** | **Endpoint**     | **Descrição**                                          | **Exemplo de Requisição**                                      |
|------------|------------------|--------------------------------------------------------|---------------------------------------------------------------|
| `GET`      | `/api/v1/repos`  | Retorna os repositórios de um usuário do GitHub.       | `GET /api/v1/repos?token=<SEU_TOKEN_AQUI>&visibility=public`   |

### Parâmetros da Requisição:
* **token**: Personal Access Token do GitHub para autenticação.
* **visibility** (opcional): Visibilidade dos repositórios. Valores válidos: `public`, `private`. O valor padrão é `public`.

## 6. Estrutura das Respostas

A API retorna uma lista de repositórios no seguinte formato:

```json
[
    {
        "id": "12345",
        "url": "https://github.com/usuario/repo1",
        "isPrivate": false,
        "name": "repo1"
    },
    {
        "id": "67890",
        "url": "https://github.com/usuario/repo2",
        "isPrivate": true,
        "name": "repo2"
    }
]
```
## 7. Configuração e Execução

### 7.1. Pré-requisitos

Antes de executar o projeto, verifique se você possui os seguintes itens instalados:

* **Java**: JDK 11 ou superior.
* **Maven**: Gerenciador de dependências e automação de builds.

### 7.2. Instruções

#### 1. Clone o repositório:

```bash
git clone https://github.com/usuario/github-api.git
cd github-api
```
#### 2. Compile e execute o projeto:

Para compilar e executar o projeto, utilize o Maven com o seguinte comando:

```bash
mvn spring-boot:run
```
#### 3. Acesse a API com o Postman ou outra ferramenta

Com o aplicativo rodando em `http://localhost:8080`, você pode realizar uma requisição **GET** para o endpoint de repositórios. Para testar no Postman ou qualquer outra ferramenta de API, use a seguinte URL:

```bash
http://localhost:8080/api/v1/repos?token=<seu token>
```
Adicione o seu Personal Access Token do GitHub na URL para autenticar a requisição.
## 8. Tratamento de Erros

A API pode retornar diferentes códigos de status HTTP, dependendo do resultado da operação. Os erros mais comuns incluem:

| **Erro** | **Código HTTP** | **Descrição** |
| --- | --- | --- |
| **Token Inválido** | `401` | O token de acesso fornecido é inválido. Certifique-se de que o token está correto e válido. |
| **Repositório Não Encontrado** | `404` | Não foi encontrado nenhum repositório com os parâmetros fornecidos, como o nome ou a visibilidade. Verifique se o nome do repositório está correto e se existem repositórios com as configurações informadas. |
| **Erro Interno do Servidor** | `500` | Um erro interno ocorreu no servidor durante o processamento. Isso pode ocorrer por diversos motivos, como falhas na comunicação com o GitHub ou problemas no backend da aplicação. |

Esses erros são retornados com uma mensagem clara e um código HTTP apropriado, facilitando o diagnóstico de falhas e problemas durante a execução das requisições. Quando ocorrer um erro, você receberá um corpo de resposta contendo informações sobre o erro e o status.
