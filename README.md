# Sistema Bancário em Java

Projeto desenvolvido em Java para praticar Programação Orientada a Objetos.

O sistema simula operações básicas de um banco através de uma aplicação de console.

## Funcionalidades

- Criação de contas
- Login
- Consulta de saldo
- Depósito
- Saque
- Transferência entre contas
- Extrato bancário
- Histórico de transações
- Geração automática do número da conta

## Tecnologias

- Java
- Programação Orientada a Objetos
- ArrayList
- enum
- LocalDateTime
- Git/GitHub

## Estrutura

- `SistemaBancario` → inicialização e menu principal
- `Banco` → gerenciamento das contas e transferências
- `Conta` → dados e operações da conta
- `Transacao` → registro das transações
- `TipoTransacao` → tipos de transação
- `Autenticacao` → login
- `Menu` → menu após o login

## Como executar

### Requisitos

Java JDK 21 ou superior.

### Executando

```bash
git clone https://github.com/gabrielfurlanetto/sistema-bancario-java.git
cd sistema-bancario-java
javac *.java
java SistemaBancario
```

## Próximos passos

- Melhorar o tratamento de entradas inválidas
- Implementar persistência dos dados
- Carregar as contas ao iniciar o sistema
- Melhorar o menu
