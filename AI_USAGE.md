# Registro de Uso de IA Generativa

> **Política da disciplina:** O uso de IA generativa é permitido como
> assistente. O discente é **integralmente responsável** por testar, auditar e
> defender todo o código entregue, independentemente de como foi gerado.

## Instruções

Para cada aula ou entrega, registre abaixo:
- **Data**
- **Ferramenta** (ChatGPT, Copilot, Claude, etc.)
- **Prompt(s) utilizado(s)** (resumo ou cópia)
- **O que foi feito com a saída** (copiado integralmente, adaptado, usado como referência, descartado)

---

## Registro

| Data | Aula | Ferramenta | Prompt (resumo) | Uso da saída |
|------|------|------------|-----------------|--------------|
| 02/10/2026 | A1 | ChatGPT | Solicitei uma explicação dos requisitos da avaliação e dos componentes necessários para o módulo de Produtos. | Usei como referência para organizar as etapas de implementação. |
| 02/10/2026 | A1 | ChatGPT | Solicitei orientação sobre a estrutura de uma API Spring Boot utilizando Entity, DTO, Repository, Service e Controller. | Usei como referência e adaptei à estrutura existente do projeto. |
| 02/10/2026 | A1 | ChatGPT | Solicitei explicação sobre a criação de uma entidade Produto utilizando JPA e os campos definidos na avaliação. | Usei como referência para revisar a implementação da Entity. |
| 02/10/2026 | A1 | ChatGPT | Solicitei orientação sobre migrations do Flyway e a criação da tabela de produtos no PostgreSQL. | Usei como referência e conferi a migration no projeto. |
| 02/10/2026 | A1 | ChatGPT | Solicitei explicação sobre records em Java e sobre Bean Validation para os DTOs. | Usei como referência para compreender e revisar os DTOs. |
| 02/10/2026 | A1 | ChatGPT | Solicitei orientação sobre como validar estoque não negativo e em qual camada aplicar a regra de negócio. | Usei como referência para revisar a validação no projeto. |
| 02/10/2026 | A1 | ChatGPT | Solicitei explicação sobre como determinar quando o campo `estoqueBaixo` deve ser verdadeiro. | Usei como referência para revisar a regra implementada. |
| 02/10/2026 | A1 | ChatGPT | Solicitei orientação sobre como verificar nomes de produtos duplicados utilizando Spring Data JPA. | Usei como referência para revisar a regra de unicidade e o tratamento do conflito. |
| 02/10/2026 | A1 | ChatGPT | Solicitei explicação sobre os códigos HTTP esperados nos endpoints de criação, consulta, atualização e exclusão. | Usei como referência para revisar a semântica HTTP dos endpoints. |
| 02/10/2026 | A1 | ChatGPT | Solicitei orientação sobre Problem Details e o tratamento padronizado de erros em uma API Spring. | Usei como referência para compreender o tratamento das exceções. |
| 02/10/2026 | A1 | ChatGPT | Solicitei orientação sobre documentação de endpoints utilizando SpringDoc/OpenAPI e anotações como `@Tag`, `@Operation` e `@ApiResponse`. | Usei como referência para revisar a documentação do Swagger. |
| 02/10/2026 | A1 | ChatGPT | Solicitei orientação para executar a aplicação Spring Boot pelo IntelliJ IDEA. | Segui as orientações para executar e verificar a aplicação localmente. |
| 02/10/2026 | A1 | ChatGPT | Solicitei ajuda para conferir a configuração de conexão da aplicação com PostgreSQL. | Usei como referência para verificar host, porta, banco, usuário e configuração do projeto. |
| 02/10/2026 | A1 | ChatGPT | Solicitei orientação sobre como utilizar o Swagger para testar os endpoints do módulo de Produtos. | Usei como referência para realizar os testes manualmente. |

---

## Uso de IA — Avaliação A1

### Ferramenta utilizada

- [x] ChatGPT
- [ ] Copilot / Codeium
- [ ] Claude / Gemini
- [ ] Nenhuma

### Como utilizei

Utilizei o ChatGPT como ferramenta de apoio durante o desenvolvimento da
Avaliação A1, principalmente para esclarecer dúvidas, compreender os
requisitos e revisar a implementação.

O uso da ferramenta envolveu:

- análise dos requisitos da avaliação;
- compreensão da arquitetura utilizada no projeto;
- esclarecimento de dúvidas sobre Spring Boot;
- orientação sobre Entity, DTO, Repository, Service e Controller;
- orientação sobre JPA e PostgreSQL;
- esclarecimento sobre migrations utilizando Flyway;
- revisão das validações dos dados;
- compreensão das regras de negócio relacionadas ao estoque;
- orientação sobre códigos HTTP e tratamento de exceções;
- orientação sobre documentação utilizando Swagger/OpenAPI;
- auxílio na execução da aplicação pelo IntelliJ IDEA;
- orientação para realização dos testes dos endpoints pelo Swagger.

A IA foi utilizada como ferramenta de apoio e consulta. A implementação foi
verificada no projeto e a aplicação foi executada localmente para conferência
do funcionamento.

### O que foi feito com as respostas da IA

As respostas foram utilizadas principalmente como:

- material de consulta;
- explicação de conceitos;
- orientação para implementação;
- referência para revisão do código;
- auxílio na identificação e correção de possíveis problemas.

Os exemplos e orientações foram adaptados à estrutura já existente do projeto,
em vez de serem utilizados de forma automática sem conferência.

### O que devo compreender

Ao entregar a atividade, devo ser capaz de explicar:

- a estrutura da Entity `Produto`;
- a função do `CategoriaProduto`;
- a utilização dos DTOs de entrada e saída;
- as validações aplicadas aos dados;
- a regra de estoque não negativo;
- o cálculo do campo `estoqueBaixo`;
- a validação de nome único;
- a função do Repository;
- a responsabilidade da camada Service;
- a responsabilidade do Controller;
- a paginação e os filtros dos produtos;
- os códigos HTTP utilizados pelos endpoints;
- o tratamento de erros utilizando Problem Details;
- a utilização do Flyway para versionamento do banco;
- a documentação dos endpoints no Swagger/OpenAPI;
- a configuração da conexão com PostgreSQL.

### Pontos que precisei estudar mais

Durante o desenvolvimento, alguns assuntos exigiram maior atenção:

- migrations e versionamento de banco com Flyway;
- validações customizadas;
- regras de negócio na camada Service;
- tratamento de exceções e Problem Details;
- documentação detalhada dos endpoints no Swagger;
- testes dos endpoints por meio do Swagger;
- testes automatizados com Mockito;
- testes de integração utilizando Testcontainers.

### Testes realizados

Após a implementação, a aplicação foi executada localmente e os endpoints
foram verificados utilizando o Swagger.

Entre os cenários considerados estão:

- criação de produto com dados válidos;
- listagem de produtos;
- busca de produto por ID;
- atualização de produto;
- exclusão de produto;
- tentativa de cadastrar estoque negativo;
- tentativa de cadastrar produto com nome duplicado;
- consulta de produto inexistente.

### Declaração

Ao submeter este repositório, confirmo que a IA generativa foi utilizada como
ferramenta de apoio ao desenvolvimento e aprendizado.

Também confirmo que sou responsável por revisar, testar e compreender o código
entregue, incluindo as regras de negócio, estrutura da aplicação, endpoints,
validações, persistência e documentação da API.