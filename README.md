# Sistema Bancário em Java

Sistema bancário desenvolvido em Java para praticar Programação Orientada a Objetos (POO), encapsulamento, validação de dados e gerenciamento de transações.

A aplicação funciona pelo terminal e permite realizar operações bancárias básicas, com registro do histórico de movimentações de cada conta e persistência dos dados em arquivo local.

## Funcionalidades

- Criação de contas com número gerado automaticamente
- Login com nome e senha
- Consulta de saldo
- Depósitos e saques com validação dos valores
- Transferências entre contas
- Validação de transferências para evitar operações na própria conta
- Extrato bancário com histórico de transações durante a execução
- Registro de data, tipo e valor das movimentações
- Tratamento de entradas inválidas no menu e nas operações numéricas
- Persistência dos dados das contas em arquivo local
- Carregamento automático das contas ao iniciar a aplicação

## Tecnologias e conceitos

- Java 21+
- Programação Orientada a Objetos
- Encapsulamento e separação de responsabilidades
- `ArrayList` para gerenciamento de contas e transações
- `enum` para representar os tipos de transação
- `LocalDateTime` para registrar as datas das movimentações
- Manipulação de arquivos com `java.nio.file`
- Git e GitHub para controle de versão

## Estrutura do projeto

- `SistemaBancario.java` — inicialização da aplicação
- `Banco.java` — gerenciamento das contas e lógica de transferência
- `Conta.java` — dados, validações e operações da conta
- `Autenticacao.java` — processo de login
- `Menu.java` — interação com o usuário após o login
- `LeitorEntrada.java` — leitura e validação de entradas numéricas
- `PersistenciaContas.java` — carregamento e gravação dos dados das contas
- `Transacao.java` — representação dos registros de movimentação
- `TipoTransacao.java` — enumeração dos tipos de transação

## Persistência de dados

Os dados das contas são armazenados localmente no arquivo `contas.txt`, permitindo que as contas e seus saldos sejam recuperados quando a aplicação for iniciada novamente.

O arquivo é gerado localmente e está incluído no `.gitignore` para evitar o envio dos dados das contas ao repositório.

**Limitação atual:** o histórico de transações ainda não é persistido entre execuções.

## Como executar

### Requisitos

- JDK 21 ou superior
- Terminal ou IDE com suporte a Java

### Execução pelo terminal

Clone o repositório e entre na pasta do projeto:

```bash
git clone https://github.com/gabrielfurlanetto/sistema-bancario-java.git
cd sistema-bancario-java
```

Compile os arquivos Java:

```bash
javac *.java
```

Execute a aplicação:

```bash
java SistemaBancario
```

## Próximos passos

- Persistir o histórico de transações entre execuções
- Melhorar a organização e a experiência de uso do menu
- Estudar integração com banco de dados SQL
- Evoluir o projeto futuramente para uma API REST com Java e Spring Boot

## Objetivo do projeto

Este projeto faz parte dos meus estudos em Ciência da Computação e tem como objetivo consolidar os fundamentos de Java por meio da implementação e evolução gradual de uma aplicação prática.