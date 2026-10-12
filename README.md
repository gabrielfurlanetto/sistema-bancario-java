# Sistema Bancário em Java

Sistema bancário desenvolvido em Java para praticar Programação Orientada a Objetos (POO), encapsulamento, validação de dados e gerenciamento de transações.

A aplicação funciona pelo terminal e permite realizar operações bancárias básicas, com registro do histórico de movimentações de cada conta.

## Funcionalidades

- Criação de contas com número gerado automaticamente
- Login com nome e senha
- Consulta de saldo
- Depósitos e saques com validação dos valores
- Transferências entre contas
- Validação de transferências para evitar operações na própria conta
- Extrato bancário com histórico de transações
- Registro de data, tipo e valor das movimentações
- Tratamento de entradas inválidas no menu e nas operações numéricas

## Tecnologias e conceitos

- Java 21+
- Programação Orientada a Objetos
- Encapsulamento e separação de responsabilidades
- `ArrayList` para gerenciamento de contas e transações
- `enum` para representar os tipos de transação
- `LocalDateTime` para registrar as datas das movimentações
- Git e GitHub para controle de versão

## Estrutura do projeto

- `SistemaBancario.java` — inicialização da aplicação
- `Banco.java` — gerenciamento das contas e lógica de transferência
- `Conta.java` — dados, validações e operações da conta
- `Autenticacao.java` — processo de login
- `Menu.java` — interação com o usuário após o login
- `LeitorEntrada.java` — leitura e validação de entradas numéricas
- `Transacao.java` — representação dos registros de movimentação
- `TipoTransacao.java` — enumeração dos tipos de transação

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

- Implementar persistência dos dados para manter as contas após encerrar o programa
- Carregar as contas e o histórico de transações ao iniciar a aplicação
- Melhorar a organização e a experiência de uso do menu
- Estudar integração com banco de dados
- Evoluir o projeto futuramente para uma API REST

## Objetivo do projeto

Este projeto faz parte dos meus estudos em Ciência da Computação e tem como objetivo consolidar os fundamentos de Java por meio da implementação e evolução gradual de uma aplicação prática.