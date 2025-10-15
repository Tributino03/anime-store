# Anime Store API 🚀

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen)
![Docker](https://img.shields.io/badge/Docker-🐳-blue)

API RESTful para um sistema de gerenciamento de animes, desenvolvida como parte do curso **Spring Boot Essentials** do [DevDojo](https://www.youtube.com/channel/UCjF0h_n3-G6qg_TRU2FlwZg).

O projeto é totalmente containerizado utilizando Docker e Docker Compose, incluindo um banco de dados MySQL, a aplicação Spring Boot, e um stack de monitoramento com Prometheus e Grafana.



[Image of a modern software architecture diagram]


---

## ✨ Features

* **API REST Completa:** Endpoints para operações CRUD (Create, Read, Update, Delete) de animes.
* **Segurança:** Endpoints protegidos utilizando Spring Security.
* **Documentação da API:** Geração automática de documentação interativa com Springdoc (Swagger UI).
* **Monitoramento:** Métricas da aplicação expostas para o Prometheus e visualização em dashboards no Grafana.
* **Containerização Total:** Ambiente de desenvolvimento e produção 100% gerenciado pelo Docker Compose.
* **Build de Imagens Simplificado:** Utilização do plugin Jib para criar imagens Docker otimizadas diretamente pelo Maven, sem a necessidade de um `Dockerfile`.

---

## 🛠️ Stack de Tecnologias

* **Backend:**
    * [Java 17](https://www.oracle.com/java/)
    * [Spring Boot 3](https://spring.io/projects/spring-boot)
    * [Spring Data JPA (Hibernate)](https://spring.io/projects/spring-data-jpa)
    * [Spring Security](https://spring.io/projects/spring-security)
* **Banco de Dados:**
    * [MySQL 8.0](https://www.mysql.com/)
* **DevOps & Monitoramento:**
    * [Docker](https://www.docker.com/) & [Docker Compose](https://docs.docker.com/compose/)
    * [Prometheus](https://prometheus.io/)
    * [Grafana](https://grafana.com/)
    * [Jib (Google)](https://github.com/GoogleContainerTools/jib) para build de imagens
* **Outras Ferramentas:**
    * [Maven](https://maven.apache.org/)
    * [Lombok](https://projectlombok.org/)
    * [MapStruct](https://mapstruct.org/)
    * [Springdoc OpenAPI (Swagger)](https://springdoc.org/)

---

## 🐳 Como Executar o Projeto (com Docker)

A forma mais simples e recomendada de executar este projeto é utilizando Docker e Docker Compose.

### Pré-requisitos

* [Docker](https://docs.docker.com/get-docker/) instalado e em execução.
* [Docker Compose](https://docs.docker.com/compose/install/) (geralmente já vem com o Docker Desktop).
* [Git](https://git-scm.com/downloads) para clonar o repositório.

### Passos para a Execução

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/Tributino03/anime-store.git](https://github.com/Tributino03/anime-store.git)
    ```

2.  **Navegue até a pasta do projeto:**
    ```bash
    cd anime-store
    ```

3.  **Inicie todos os serviços com Docker Compose:**
    ```bash
    docker-compose up -d
    ```
    Este comando irá baixar as imagens necessárias (MySQL, Prometheus, Grafana e a da aplicação) e iniciará os contêineres em segundo plano.

---

## 🌐 Acessando os Serviços

Após iniciar os contêineres, os seguintes serviços estarão disponíveis nos seus respectivos endereços:

* **API (Swagger UI):**
    * Acesse `http://localhost:8080/swagger-ui.html` para ver a documentação da API e interagir com os endpoints.
    

* **Prometheus:**
    * Acesse `http://localhost:9090` para ver a interface do Prometheus e consultar as métricas coletadas.

* **Grafana:**
    * Acesse `http://localhost:3000` para visualizar os dashboards. (Login padrão: `admin` / `admin`).

---

## 👨‍💻 Para Desenvolvedores (Build a partir do código-fonte)

Se você deseja modificar o código e construir sua própria imagem Docker.

### Pré-requisitos
* JDK 17
* Apache Maven 3.9+
* Docker

### Comandos
1.  **Construir a imagem e carregá-la no seu Docker local:**
    ```bash
    # Limpa o projeto, empacota e cria a imagem Docker localmente
    mvn clean install jib:dockerBuild
    ```
    *Após este passo, você precisaria ajustar o `docker-compose.yml` para usar a imagem local.*

2.  **Construir a imagem e enviá-la para o Docker Hub:**
    *Primeiro, ajuste a propriedade `<docker.image.name>` no `pom.xml` para o seu usuário do Docker Hub.*
    ```bash
    # Autentique no Docker Hub
    docker login

    # Construa e envie a imagem
    mvn clean install jib:build
    ```

---

## 🙏 Agradecimentos

* Este projeto foi desenvolvido com base nos ensinamentos do curso **Spring Boot Essentials 2** do canal **DevDojo**.
