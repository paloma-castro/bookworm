# The Bookworm Catalog
![Spring Boot 2.0](https://img.shields.io/badge/Spring%20Boot-3.3.4-brightgreen)
![JDK 17](https://img.shields.io/badge/JDK-17-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-4.0.0-yellowgreen.svg)


API desenvolvida como assignment para a F1rst.

Esse projeto é sobre uma API de leitura de dados sobre livros. É possível obter dados sobre livros, buscar por id, autor e gênero.

## **Índice**
- Stack
- Funcionalidades do projeto
- Como rodar este projeto
- Para utilizar

  ### **Stack**:
  - Spring Boot 3.3.4
  - Spring Data JPA
  - Maven
  - PostgresSQL
  - JDK 17
  - Spring Data JPA
  - Spring Cache
  - JUnit 5

  ## Estrutura do Projeto

  - `src/main/java`: Contém o código-fonte principal da aplicação.
  - `santander/bookstore/domain`: Contém as classes de domínio.
  - `santander/bookstore/repository`: Contém as interfaces de repositório.
  - `santander/bookstore/service`: Contém as implementações dos serviços.
  - `santander/bookstore/exceptions`: Contém as classes de exceção.
  - `src/test/java`: Contém os testes unitários.
  - `pom.xml`: Arquivo de configuração do Maven.

  ### **Funcionalidades do projeto:**
  O projeto conta com 4 endpoints:
  * **GET/books:** Lista todos os livros. Paginação, 10 por página.
  * **GET/books/:id:** Lista livro pelo ID.
  * **GET/books/genre/:genre:** Lista livros de um genero específico. Paginação, 10 por página.
  * **GET/books/author/:author:** Lista livros de um autor específico. Paginação, 10 por página.

  ### Pré-requisitos

  - **Java 17** ou superior
  - **Maven 3.6.0** ou superior
  - **PostgreSQL**

  ### **Como rodar este projeto**
  Para executar você deve clonar o repositório::
    ```sh
    git clone https://github.com/paloma-castro/bookstore.git
    ```
  ### Buildar, executar testes e instalar os artefatos da aplicação
  Para executar a aplicação, utilize o comando Maven:
  ```sh
  mvn clean install
  ```

  ### Executar a Aplicação
  Para executar a aplicação, utilize o comando Maven:
  ```sh
  mvn spring-boot:run
  ```

  ### **Para utilizar**
  Utilizar uma ferramenta que possibilite testar requisições e utilize os endpoints. Exemplo: Postman, Insomnia.

  ### **Valores para teste**
  - Exemplos generos:
    - "Noel Lang"
    - "Tamie Reinger"
    - "Cari Borer"
    - "Vance Berge"
    - "Rudy Marquardt"
    - "Lester Kuphal"
    - "Kimberli Gottlieb"
    - "Socorro Jacobi"
    - "Sunny Mante"
    - "Abby Kiehn"
    - "Galina Pfannerstill III"
  - Exemplos autores:
    - "Fantasy"
    - "Thriller"
    - "Comedy"
    - "Romance"
  
