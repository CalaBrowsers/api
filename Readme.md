# API Project

Este é um projeto Spring Boot com PostgreSQL que utiliza Docker Compose para configuração do ambiente de desenvolvimento.

## Pré-requisitos

- Java 21
- Maven
- Docker e Docker Compose
- Git

## Configuração do Ambiente

### 1. Banco de Dados com Docker Compose

O projeto utiliza Docker Compose para configurar o PostgreSQL e pgAdmin. Para iniciar os containers:

```bash
docker-compose up -d
```

Isso irá iniciar:
- PostgreSQL na porta 5432
- pgAdmin na porta 5050

Credenciais do PostgreSQL:
- Usuário: postgres
- Senha: postgres
- Banco de dados: postgres
- Porta: 5432

Credenciais do pgAdmin:
- Email: admin@admin.com
- Senha: admin
- URL: http://localhost:5050

### 2. Configuração do Projeto

1. Clone o repositório:
```bash
git clone [URL_DO_REPOSITÓRIO]
cd api
```

2. Compile o projeto:
```bash
./mvnw clean install
```

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`

## Estrutura do Projeto

- `src/main/java`: Código fonte Java
- `src/main/resources`: Arquivos de configuração
- `src/test`: Testes automatizados

## Tecnologias Utilizadas

- Spring Boot 3.5.0
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven
- Docker

## Desenvolvimento

### Configuração do Banco de Dados

O projeto inclui um script SQL inicial (`elumini.sql`) que contém a estrutura do banco de dados. Para executar este script:

1. Inicie os containers com Docker Compose:
```bash
docker-compose up -d
```

2. Execute o script SQL usando o pgAdmin:
    - Acesse o pgAdmin em http://localhost:5050
    - Conecte ao servidor PostgreSQL
    - Clique com o botão direito no banco de dados 'postgres'
    - Selecione "Query Tool"
    - Cole o conteúdo do arquivo `elumini.sql`
    - Clique em "Execute" (F5)

Alternativamente, você pode executar o script diretamente via linha de comando:
```bash
docker exec -i postgres-db psql -U postgres -d postgres < elumini.sql
```         