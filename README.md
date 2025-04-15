# 🔍  Automação de Testes de API - PokeAPI

![Testes Automatizados da PokeAPI](https://github.com/ErickAugs/PokeApi-Rest-Assured/actions/workflows/api-tests.yml/badge.svg)

Este projeto tem como objetivo demonstrar habilidades em automação de testes de API utilizando a [PokeAPI](https://pokeapi.co/), com boas práticas de projeto, arquitetura desacoplada, relatórios e documentação.

---

## 🚀 Tecnologias utilizadas

- **Java 17**
- **Maven**
- **TestNG**
- **Rest-Assured**
- **Jackson** (para serialização e deserialização de dados)
- **Extent Reports** (para geração de relatórios HTML)
- **GitHub Actions** (CI/CD)
- **Gherkin** (para documentação dos cenários de teste)

---

## 🧱 Estrutura do projeto

```
src
├── main
│   └── java
│       ├── cliente           # Requisições brutas da API
│       ├── modelo            # Representação dos dados da resposta (POJOs)
│       ├── objeto            # Lógica de negócio + deserialização (Page Object)
│       └── util              # Utilitários como constantes e conversores
└── test
    └── java
        ├── testes            # Testes automatizados
        └── runners           # Classe base com Extent Reports
```

---

## 🧪 Como executar os testes

1. Clone o repositório:
   ```bash
   git clone https://github.com/ErickAugs/PokeApi-Rest-Assured.git
   cd PokeApi-Rest-Assured
   ```

2. Execute os testes via Maven:
   ```bash
   mvn clean test
   ```

3. Visualize o relatório HTML em:
   ```
   target/extent-report.html
   ```

---

## 📄 Cenários de Teste (Gherkin)

### 🔹 Funcionalidade: Consulta de informações de Pokémon

```gherkin
Cenário: Consultar Pokémon existente
  Dado que o Pokémon "pikachu" existe na PokeAPI
  Quando eu realizo uma requisição GET para o endpoint /pokemon/pikachu
  Então o nome do Pokémon retornado deve ser "pikachu"
  E o ID deve ser 25

Cenário: Validar estrutura mínima de um Pokémon
  Dado que o Pokémon "bulbasaur" existe na PokeAPI
  Quando eu realizo uma requisição GET para o endpoint /pokemon/bulbasaur
  Então o nome do Pokémon retornado deve ser "bulbasaur"
  E a altura e peso devem ser maiores que zero  

Cenário: Consultar Pokémon inexistente
  Dado que o Pokémon "pikachuchu" não existe
  Quando eu realizo uma requisição GET para o endpoint /pokemon/pikachuchu
  Então o status de resposta deve ser 404
```

---

### 🔹 Funcionalidade: Consulta de habilidades de Pokémon

```gherkin
Cenário: Consultar habilidade existente
  Dado que a habilidade "static" existe
  Quando eu realizo uma requisição GET para o endpoint /ability/static
  Então o nome da habilidade deve ser "static"
  E deve existir uma lista de efeitos
  E deve existir uma lista de Pokémon relacionados
   
Cenário: Validar Pokémon associados à habilidade
  Dado que a habilidade "overgrow" existe
  Quando eu realizo uma requisição GET para o endpoint /ability/overgrow
  Então deve existir pelo menos um Pokémon listado com essa habilidade
  E o campo "pokemon" deve conter a chave "name"

Cenário: Consultar habilidade inexistente
  Dado que a habilidade "super-salto-triplo" não existe
  Quando eu realizo uma requisição GET para o endpoint /ability/super-salto-triplo
  Então o status de resposta deve ser 404
```

---

### 🔹 Funcionalidade: Consulta de tipos de Pokémon

```gherkin
Cenário: Consultar tipo existente
  Dado que o tipo "electric" existe
  Quando eu realizo uma requisição GET para o endpoint /type/electric
  Então o nome do tipo retornado deve ser "electric"
  E deve existir uma lista de Pokémon associados ao tipo

Cenário: Verificar quantidade de Pokémon associados ao tipo "fire"
  Dado que o tipo "fire" existe
  Quando eu realizo uma requisição GET para o endpoint /type/fire
  Então a resposta deve conter uma lista de Pokémon
  E essa lista deve conter mais de 5 Pokémon

Cenário: Consultar tipo inexistente
  Dado que o tipo "banana-fire" não existe
  Quando eu realizo uma requisição GET para o endpoint /type/banana-fire
  Então o status de resposta deve ser 404
```

---

## 📦 Observações

- O projeto segue o padrão Page Object aplicado ao contexto de API.
- As respostas são deserializadas para objetos Java com atributos em português.
- Todos os testes geram evidências no relatório HTML via Extent Reports.
- Os testes negativos foram incluídos para validar comportamento em falhas.

---

## ✨ Autor

Feito com 💙 por [ErickAugs](https://github.com/ErickAugs) para o desafio técnico de automação de testes de API.