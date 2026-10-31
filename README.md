🎓 EduData API
API REST desenvolvida em Java + Spring Boot para consulta e análise de dados educacionais brasileiros.

O projeto disponibiliza informações sobre escolas e sua infraestrutura por meio de endpoints REST, permitindo consultas por UF, município e código INEP, além de fornecer estatísticas sobre a infraestrutura das instituições de ensino.

O EduData v1.0 também possui um frontend publicado na Vercel, com Dashboard e página de Estatísticas integrados à API. Algumas funcionalidades da interface permanecem em desenvolvimento.
🔗 Links do projeto
Recurso	Link
🌐 Frontend — Vercel	 : https://edudatav10-frontend.vercel.app/
💻 Frontend — GitHub	EduData_v1.0
⚙️ Backend — GitHub	edudata-api-v1
🚀 API — Render : edudata-teste.onrender.com
📖 Swagger UI — Render	Documentação interativa : https://edudata-teste.onrender.com/swagger-ui/index.html)
📄 OpenAPI — Render	Especificação JSON


Observação: o endereço exato do deploy da Vercel precisa ser inserido na primeira linha da tabela. A disponibilidade dos serviços externos pode variar conforme a hospedagem.

📚 Sobre o projeto
A EduData API foi desenvolvida com o objetivo de disponibilizar dados educacionais de maneira estruturada e de fácil consulta.

Os dados são armazenados em um banco PostgreSQL hospedado no Supabase e acessados pela aplicação utilizando Spring Data JPA e Hibernate.

A API permite consultar informações como:
- escolas por estado;
- escolas por município;
- escola pelo código INEP;
- infraestrutura escolar;
- disponibilidade de internet;
- internet para alunos;
- biblioteca;
- laboratório de informática;
- laboratório de ciências;
- quadra de esportes;
- água potável;
- acessibilidade;
- salas utilizadas e climatizadas;
- estatísticas educacionais por UF e município.
🖥️ Frontend
O frontend do EduData v1.0 apresenta os dados da API em uma interface web. O Dashboard e a página de Estatísticas estão funcionais e consomem a API. Outras funcionalidades da interface ainda estão em desenvolvimento.
🛠️ Tecnologias utilizadas
- Java
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Hibernate
- PostgreSQL
- Supabase
- Gradle
- Lombok
- Swagger / OpenAPI
- Git
- GitHub
Hospedagem e integração: Render (API) e Vercel (frontend).
🏗️ Arquitetura
A aplicação utiliza uma arquitetura em camadas:
Frontend (Vercel) / Cliente HTTP
   ↓
API REST (Render)
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
JPA / Hibernate
   ↓
PostgreSQL / Supabase
Estrutura principal do backend:
src/main/java/com/edudata/edudata_api
│
├── config
│   └── OpenApiConfig.java
│
├── controller
│   ├── EscolaController.java
│   └── EstatisticaController.java
│
├── dto
│   ├── InfraestruturaDTO.java
│   └── EstatisticaDTO.java
│
├── entity
│   └── Escola.java
│
├── exception
│   ├── ApiError.java
│   ├── GlobalExceptionHandler.java
│   ├── ParametroInvalidoException.java
│   └── RecursoNaoEncontradoException.java
│
├── repository
│   └── EscolaRepository.java
│
├── service
│   ├── EscolaService.java
│   └── EstatisticaService.java
│
└── EdudataApiApplication.java
🔎 Endpoints
URL base em produção: https://edudata-teste.onrender.com
Listar escolas
GET /api/escolas
A listagem utiliza paginação.

Exemplo:
GET /api/escolas?page=0&size=20
Buscar escolas por UF
GET /api/escolas?uf=RO&page=0&size=20
Buscar escolas por município
GET /api/escolas?municipio=Porto%20Velho&page=0&size=20
Buscar escola pelo código INEP
GET /api/escolas/{codigoInep}
Exemplo:
GET /api/escolas/11024275
Consultar infraestrutura de uma escola
GET /api/escolas/{codigoInep}/infraestrutura
Exemplo:
GET /api/escolas/11024275/infraestrutura
📊 Estatísticas
Estatísticas por UF
GET /api/estatisticas/uf/{uf}
Exemplo:
GET /api/estatisticas/uf/RO
A resposta apresenta indicadores como:
- total de escolas;
- escolas com internet;
- escolas com internet disponível para alunos;
- biblioteca;
- laboratório de informática;
- laboratório de ciências;
- quadra de esportes;
- água potável;
- rampa de acessibilidade.
Estatísticas por município
GET /api/estatisticas/municipio/{municipio}
Exemplo:
GET /api/estatisticas/municipio/Porto%20Velho
📄 Exemplo de resposta
Exemplo de uma escola:
{
  "codigoInep": 11024275,
  "anoCenso": 2025,
  "nome": "CEEJA LUIZ VAZ DE CAMOES",
  "uf": "RO",
  "municipio": "Alta Floresta D'Oeste",
  "internet": 1,
  "internetAlunos": 1,
  "biblioteca": 1,
  "laboratorioInformatica": 1,
  "quadraEsportes": 1
}
📑 Paginação
O endpoint de listagem aceita os parâmetros:
Parâmetro	Descrição
page	Número da página, iniciando em 0
size	Quantidade de registros por página, entre 1 e 100
uf	Filtra as escolas pela UF
municipio	Filtra as escolas pelo município


Exemplo:
GET /api/escolas?uf=RO&page=0&size=10
As escolas são retornadas ordenadas pelo nome.
⚠️ Tratamento de erros
A API possui tratamento centralizado de exceções.

Os principais códigos HTTP utilizados são:
Código	Significado
200	Requisição realizada com sucesso
400	Parâmetro informado é inválido
404	Recurso não encontrado
500	Erro interno da aplicação


Exemplo de parâmetro inválido:
GET /api/escolas?page=-1
Resposta:
{
  "status": 400,
  "erro": "Parâmetro inválido",
  "mensagem": "O parâmetro 'page' não pode ser negativo.",
  "caminho": "/api/escolas"
}
Exemplo de escola inexistente:
GET /api/escolas/99999999
Retorna:
404 Not Found
📖 Swagger / OpenAPI
A API possui documentação interativa utilizando Swagger/OpenAPI.

Swagger em produção (Render):

https://edudata-teste.onrender.com/swagger-ui/index.html

OpenAPI JSON em produção:

https://edudata-teste.onrender.com/v3/api-docs

Swagger local:
http://localhost:8080/swagger-ui.html
http://localhost:8080/swagger-ui/index.html
OpenAPI local:
http://localhost:8080/v3/api-docs
No Swagger é possível visualizar e testar os endpoints diretamente pelo navegador.
⚙️ Configuração do banco
A aplicação utiliza PostgreSQL hospedado no Supabase.

As credenciais não são armazenadas diretamente no código.

São utilizadas as seguintes variáveis de ambiente:
DB_URL
DB_USERNAME
DB_PASSWORD
O application.properties utiliza:
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
Dessa forma, informações sensíveis não precisam ser publicadas no GitHub.
▶️ Como executar
Pré-requisitos
Para executar o projeto localmente é necessário:
- Java/JDK compatível com o projeto;
- Git;
- acesso ao PostgreSQL utilizado pela aplicação.
Clone o repositório:
git clone https://github.com/PedroBentoDev/edudata-api-v1.git
Entre na pasta:
cd edudata-api-v1
Configuração no Windows PowerShell
Configure as variáveis:
$env:DB_URL="jdbc:postgresql://HOST:5432/postgres?sslmode=require"
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="SUA_SENHA"
Nunca publique a senha real do banco no GitHub.

Execute:
.\gradlew.bat bootRun
Quando aparecer:
Started EdudataApiApplication
a aplicação estará disponível em:
http://localhost:8080
🧪 Testando a API
Alguns exemplos:
Listar cinco escolas de Rondônia
GET http://localhost:8080/api/escolas?uf=RO&page=0&size=5
Consultar uma escola
GET http://localhost:8080/api/escolas/11024275
Consultar infraestrutura
GET http://localhost:8080/api/escolas/11024275/infraestrutura
Consultar estatísticas
GET http://localhost:8080/api/estatisticas/uf/RO
Também é possível realizar esses testes pela interface do Swagger.
🔐 Segurança
As informações sensíveis são fornecidas através de variáveis de ambiente.

O repositório não deve conter:
- senha do PostgreSQL;
- tokens de acesso;
- chaves privadas;
- credenciais do Supabase.
O consumidor da API não precisa conhecer as credenciais do banco.

O fluxo é:
Cliente
   ↓
EduData API
   ↓
Spring Data JPA
   ↓
PostgreSQL / Supabase
🎯 Objetivo acadêmico
O projeto foi desenvolvido para aplicar conceitos relacionados a:
- desenvolvimento de APIs REST;
- Java e Spring Boot;
- arquitetura em camadas;
- integração com banco PostgreSQL;
- Spring Data JPA;
- Hibernate;
- repositories;
- services;
- controllers;
- DTOs;
- filtros;
- paginação;
- consultas agregadas;
- tratamento de exceções;
- códigos HTTP;
- Swagger/OpenAPI;
- variáveis de ambiente;
- versionamento com Git e GitHub;
- integração entre frontend e backend;
- deploy de aplicações web.
👨‍💻 Autor
Pedro Henrique Bento Martins

GitHub: PedroBentoDev
