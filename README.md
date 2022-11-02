# exacta

## Entidades
  - User (Usuário)
  - Person (Pessoa)
  - Spending (Gasto)
  
A entidade de usuário foi criada apenas para representar a autenticação da API, mas não tem relacionamento com nenhuma das outras entidades.

A API está autenticada com JWT cuja as credencias ficam no banco de dados, `Email:` exacta@gmail.com, `Senha:` 123

Ao fazer o start do Spring `localhost`, o flyway ficará responsável por criar as tabelas, no entanto é super importante criar o a database `POSTGRES` com o nome `exacta` ou de sua escolha, definir as credencias e configurar o `application-dev`.

Embora exista três applications: `application`, `application-dev` e `application-hml`:
  - `application`: onde se define o spring-profile: dev ou hml;
  - `application-dev`: Configurações para executar o spring localmente;
  - `application-hml`: A string de conexão já está apontando para uma instância RDS

Se apontando para o application-hml talvez seja necessário incluir no grupo de segurança seu IP Local, as credencias para logar no AWS é `Usuário root`: exatactaprocessoseletivo@gmail.com, `Senha`: Exacta2022#
