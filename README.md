# exacta

## Swagger
http://localhost:8080/swagger-ui/index.html

Após o start da API spring, será possivel acessar o swagger

## Banco de dados Postgres AWS (Intância RDS)
  - `Host:` ####
  - `Port:` 5432
  - `Username`: postgres
  - `Password`: 12345678

## Acesso console AWS (Para incluir ip se necessário ao grupo de segurança do banco de dados)
  - `Usuário root`: ####
  - `Senha`: ####

Após a avaliação irei excluir a instância para não se cobrado pelo tempo de uso.

## Entidades
  - User (Usuário)
  - Person (Pessoa)
  - Spending (Gasto)
  
A entidade de usuário foi criada apenas para representar a autenticação da API, mas não tem relacionamento com nenhuma das outras entidades.

A API está autenticada com JWT cuja as credencias ficam no banco de dados, `Email:` exacta@gmail.com, `Senha:` 123

Ao fazer o start do Spring `localhost`, o flyway ficará responsável por criar as tabelas, no entanto é super importante criar o a database `POSTGRES` com o nome `exacta` ou de sua escolha, definir as credencias e configurar o `application-dev`.

Embora exista três applications: `application`, `application-dev` e `application-hml`:
  - `application`: onde se define o spring-profile: dev ou hml
  - `application-dev`: Configurações para executar o spring localmente
  - `application-hml`: A string de conexão já está apontando para uma instância RDS

Se apontando para o application-hml talvez seja necessário incluir no grupo de segurança seu IP Local, as credencias para logar no AWS é `Usuário root`: exatactaprocessoseletivo@gmail.com, `Senha`: Exacta2022#

## Exemplo de como obter o token para acessar os recurso da API
```
curl --location --request POST 'http://localhost:8080/api/auth' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=77CE304114CEFE8FDAB8BAC6C9D0FEC3' \
--data-raw '{
    "email": "exacta@gmail.com",
    "password": "123"
}'
```
