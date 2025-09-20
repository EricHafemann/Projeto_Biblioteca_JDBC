# 📚 Sistema de Biblioteca (Java + JDBC)

Este é um projeto simples de **sistema de gerenciamento de biblioteca**, desenvolvido em **Java** com **JDBC** para integração com banco de dados MySQL.  
O sistema permite o **cadastro de usuários, livros e empréstimos**, além do controle de disponibilidade de cada livro.

---

## 🚀 Funcionalidades

- **Usuários**
  - Cadastro de usuários (admin ou usuário comum)
  - Login por `username` e `senha`

- **Livros**
  - Cadastro de livros
  - Consulta de livros disponíveis

- **Empréstimos**
  - Registrar empréstimos
  - Registrar devoluções
  - Controle automático de disponibilidade do livro

---

## 📂 Estrutura de Pacotes

```plaintext
src/main/java/org/example/biblioteca/
│
├── config/
│   └── ConnectionFactory.java   # Conexão com o SQL
│
├── model/
│   ├── Usuario.java             # Classe Usuário
│   ├── Livro.java               # Classe Livro
│   └── Emprestimo.java          # Classe Empréstimo
│
├── dao/
│   ├── UsuarioDao.java          # CRUD de usuários
│   ├── LivroDao.java            # CRUD de livros
│   └── EmprestimoDao.java       # CRUD de empréstimos
│
└── main/
│   └── BibliotecaApp.java       # Classe principal para executar o sistema
│
│
└── application.properties       # Configurações do banco (URL, usuário, senha)

