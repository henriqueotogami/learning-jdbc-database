<div align="center">

# Estudos de JDBC Database

<img width="auto" src="https://github.com/henriqueotogami/learning-jdbc-database/blob/main/JDBC-DATABASE.png?raw=true">

<br>
<br>
<div align="center">
<img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/henriqueotogami/learning-jdbc-database">
</div>
<br>
<img src="https://img.shields.io/github/issues/henriqueotogami/learning-jdbc-database">
<img src="https://img.shields.io/github/forks/henriqueotogami/learning-jdbc-database">
<img src="https://img.shields.io/github/stars/henriqueotogami/learning-jdbc-database">
<img src="https://img.shields.io/github/license/henriqueotogami/learning-jdbc-database">
</div>
<br>
<div align=center>
<a href="https://wakatime.com/badge/user/1e53636e-c916-4d50-9ce1-f3ac75a883e3/project/6d2c64ad-2943-4a8d-9c3f-84c965a802f7"><img src="https://wakatime.com/badge/user/1e53636e-c916-4d50-9ce1-f3ac75a883e3/project/6d2c64ad-2943-4a8d-9c3f-84c965a802f7.svg" alt="wakatime"></a>
</div>
<br>
<hr>

**Data:** 08/01/2023 — Em andamento

**Curso:** [Cod3r | Java 2022 Completo](https://www.udemy.com/course/fundamentos-de-programacao-com-java/)

## Descrição

> Este repositório contém estudos de **JDBC (Java Database Connectivity)** com MySQL. Os exemplos cobrem conexão com banco de dados, criação de banco e tabelas, operações CRUD e o padrão DAO (Data Access Object).

<br>

## Conteúdo estudado

- [x] Conexão com MySQL via JDBC
- [x] Criação de banco de dados e tabelas
- [x] Uso de `Statement` e `PreparedStatement`
- [x] Operações CRUD (Create, Read, Update, Delete)
- [x] Padrão DAO e reuso de conexão
- [x] Configuração via arquivo de propriedades (`connection.properties`)
- [x] Consultas com parâmetros e filtros (`LIKE`)

<br>

## Estrutura do projeto

```
src/
├── connection.model          # Modelo do arquivo de configuração (copie como connection.properties)
├── FactoryConnection.java    # Fábrica de conexões (lê connection.properties)
├── Person.java               # Modelo/entidade Person (código, nome)
├── DAO.java                  # Data Access Object genérico (insert com PreparedStatement)
├── CreateDataBase.java       # Cria o banco course_java
├── CreateTablePeople.java    # Cria a tabela people
├── DataBaseConnectionTest.java # Teste simples de conexão
├── NewPerson.java            # Inserção de pessoa (entrada via Scanner)
├── TestDAO.java              # Inserção em lote via DAO
├── QueryPeopleOne.java       # Listagem de todas as pessoas (SELECT *)
├── QueryPeopleTwo.java       # Busca por nome (SELECT com LIKE)
├── UpdatePeople.java         # Atualização de nome por código
└── DeletePeople.java         # Exclusão de pessoa por código
```

<br>

## Pré-requisitos e configuração

### MySQL

- Tenha o **MySQL** instalado e em execução (ex.: servidor em `localhost`).
- Opcional: crie o banco manualmente ou execute `CreateDataBase` para criar o banco `course_java`.

### Arquivo de conexão

O projeto usa um arquivo `connection.properties` (não versionado). Use o modelo:

1. Na pasta **src**, copie `connection.model` para `connection.properties`.
2. Preencha com sua URL, usuário e senha:

```properties
database.url=jdbc:mysql://localhost/course_java?verifyServerCertificate=false&useSSL=true
database.user=root
database.password=sua_senha
```

> O arquivo `connection.properties` é ignorado pelo Git (`.gitignore`) para não expor credenciais.

<br>

## Dependências

| Dependência            | Observação                          |
|------------------------|-------------------------------------|
| MySQL JDBC Driver      | `mysql-connector-java-8.0.30.jar` (ou compatível) |

Adicione o JAR do driver MySQL ao classpath do projeto na sua IDE (IntelliJ: Project Structure → Libraries).

<br>

## Exemplos do repositório

| Classe                   | Descrição |
|--------------------------|-----------|
| **DataBaseConnectionTest** | Teste básico de conexão com o MySQL (credenciais em código). |
| **CreateDataBase**       | Cria o banco `course_java` se não existir. |
| **CreateTablePeople**    | Cria a tabela `people` (person_code, person_name) usando `FactoryConnection`. |
| **NewPerson**            | Insere uma pessoa: lê o nome via `Scanner` e usa `PreparedStatement`. |
| **TestDAO**              | Insere várias pessoas usando a classe `DAO` (retorna IDs gerados). |
| **QueryPeopleOne**       | Lista todas as pessoas da tabela e exibe código e nome. |
| **QueryPeopleTwo**       | Busca pessoas por parte do nome (entrada do usuário + `LIKE`). |
| **UpdatePeople**         | Atualiza o nome de uma pessoa a partir do código informado. |
| **DeletePeople**         | Remove uma pessoa pelo código e exibe quantidade de linhas afetadas. |

<br>

## Ambiente de desenvolvimento

### Sistema operacional

- macOS Monterey — Versão 12.6

### IDE

- **IntelliJ IDEA Community Edition** 2022.2

### Plugins

- [Atom Material Icons](https://plugins.jetbrains.com/plugin/10044-atom-material-icons)
- [Codota AI Autocomplete for Java](https://plugins.jetbrains.com/plugin/7638-codota-ai-autocomplete-for-java-and-javascript)
- [GitToolBox](https://plugins.jetbrains.com/plugin/7499-gittoolbox)
- [Nyan Progress Bar](https://plugins.jetbrains.com/plugin/8575-nyan-progress-bar)
- [Rainbow Brackets](https://plugins.jetbrains.com/plugin/10080-rainbow-brackets)
- [Wakatime](https://wakatime.com)
- [Xcode-Dark Theme](https://plugins.jetbrains.com/plugin/13106-xcode-dark-theme)

<br>

## Contribuições

> Caso você queira ajudar a melhorar este repositório, qualquer ajuda é bem-vinda.

- [ ] Faça um **fork** deste repositório ([link para fork](https://github.com/henriqueotogami/learning-jdbc-database/fork));
- [ ] Crie um **branch** para as suas modificações: `git checkout -b meu-novo-recurso`;
- [ ] Faça um **commit**: `git commit -am 'Adicionando um novo recurso ...'`;
- [ ] Faça um **push**: `git push origin meu-novo-recurso`;
- [ ] Abra uma **pull request** neste repositório.

**Depois que sua pull request for aceita e incorporada (merged) ao branch principal, você pode excluir sua branch com tranquilidade.**

<br>

## Leia meus artigos

- [Artigos no Medium](https://medium.com/@henriqueotogami)
- [Artigos no Dev.to](https://dev.to/henriqueotogami)

<br>

## Conecte-se comigo

- [Perfil no LinkedIn](https://www.linkedin.com/in/henrique-matheus-alves-pereira)

<br>
<hr>
<div align="center">

> ### **Muito obrigado, e que a Força esteja com você.**
>
> ### Desenvolvido por **HMAP | Henrique Matheus Alves Pereira** 🦁

</div>
