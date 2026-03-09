# Projeto Hexagonal - Validação de CPF 🚀

Este projeto implementa uma arquitetura hexagonal para o gerenciamento de clientes, utilizando **Java**, **Spring Boot**, **MongoDB** e **WireMock** para integração com serviços externos de CEP.

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot**
* **MongoDB** (Persistência)
* **Docker & Docker Compose** (Infraestrutura)
* **WireMock** (Mock de API externa)
* **ArchUnit** (Testes de Arquitetura)

---

## 🚀 Como Iniciar a Aplicação

### 1. Iniciar Infraestrutura (Docker)

Certifique-se de que o Docker está rodando e execute:

```bash
docker-compose up -d

```

> **Comandos úteis do Docker:**
> * `docker ps`: Lista os containers ativos.
> * `docker-compose stop`: Para os serviços.
>

### 2. Iniciar o WireMock (Simulação de CEP)

O WireMock é necessário para validar os endereços durante o cadastro:

```bash
java -jar .\wiremock-standalone-4.0.0-beta.29.jar --port 8082

```

*Para parar o serviço, use `CTRL + C`.*

### 3. Executar o Projeto

Acesse a URL base da API:

* [http://localhost:8081/api/v1/customers](https://www.google.com/search?q=http://localhost:8081/api/v1/customers)

---

## 🧪 Testes e Dados de Exemplo

### Dados para Inserção (Insomnia/Postman)

**Endpoint:** `POST /api/v1/customers`
**JSON:**

```json
{
  "name": "Margarida",
  "zipCode": "38400000",
  "cpf": "09876543245"
}

```

> **CEPs válidos para teste:** `38400000`, `38400001`.

---

## 🗄️ Acessando o Banco de Dados (MongoDB)

Para validar se os dados foram persistidos corretamente via terminal:

1. **Acessar o container:**
```bash
winpty docker exec -it [ID_DO_CONTAINER] bash

```


2. **Entrar no console do Mongo:**
```bash
mongosh -u root -p

```

*A senha padrão é: `example`.*
3. **Comandos de navegação:**
* `use hexagonal`: Seleciona o banco.
* `show collections`: Lista as tabelas.
* `db.customerEntity.find()`: Lista todos os clientes registrados.
* **Pesquisa por ID específico:**
```javascript
db.customerEntity.find({ _id: ObjectId("ID_AQUI") })

```

---

## 🏛️ Regras de Arquitetura (ArchUnit)

O projeto utiliza **ArchUnit** para garantir a integridade da arquitetura hexagonal

* **Ports & Adapters**: Garantia de que o Core não dependa de infraestrutura
* **Convenção de Nomes**: Validação automática de sufixos como `*UseCase`, `*Adapter` e `*Controller`


### 1. Testes de Nomenclatura (NamingConventionTest)

Garante a consistência visual e a localização correta dos componentes:

* Isolamento do Core: O domínio nunca depende diretamente de detalhes de infraestrutura

* Padronização de Sufixos: Classes devem terminar obrigatoriamente com UseCase, Adapter, Controller, Port, etc

* Organização de Pacotes: Cada componente deve residir estritamente em seu pacote (Inbound, Outbound ou Core)

### 2. Testes de Camadas (LayeredArchitectureTest)

Verifica se as dependências entre os pacotes respeitam a hierarquia da Arquitetura Hexagonal:

* AdaptersIn/Out: Só podem ser acessados pela camada de Configuração

* UseCase: Centraliza a lógica de negócio e é acessado pelas portas de entrada

* PortsIn/Out: Definem as interfaces de comunicação que os adaptadores devem implementar ou utilizar

* Config: Camada externa que orquestra a injeção de dependências e não deve ser acessada por nenhuma outra camada.s: Cada componente deve residir estritamente em seu pacote (Inbound, Outbound ou Core)