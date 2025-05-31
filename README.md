# 📄 Java curriculum PDF generator API

esta é uma API desenvolvida em Java com Spring Boot que gera currículos em PDF a partir de dados enviados no corpo da requisição. utiliza a biblioteca [OpenHTMLtoPDF](https://github.com/danfickle/openhtmltopdf) para converter HTML em PDF.

---

## funcionalidades

- geração de currículo em PDF com base em um objeto `Curriculum`.
- visualização do HTML gerado antes da conversão.
- endpoint de exemplo de estrutura do corpo (`body`) esperado.

---

## 🛠️ tecnologias utilizadas

- Java 17+
- Spring Boot
- OpenHTMLtoPDF
- Maven

---

### 1. clone o repositório:

```bash
git clone https://github.com/seu-usuario/java-curriculum-pdf-api.git
cd java-curriculum-pdf-api
```

### 2. compile e rode a aplicação:

```bash
./mvnw spring-boot:run
```

a API ficará disponível em: `http://localhost:8080`

---

##  endpoints disponíveis

### `GET /api`

retorna um modelo vazio da estrutura esperada do `Curriculum`.

### `POST /api/view`

gera o HTML baseado nos dados do currículo (útil para testes e preview).

- **Request body:** JSON com os dados do currículo.
- **Response:** HTML gerado como string.

### `POST /api/pdf`

gera um currículo em PDF a partir de um objeto `Curriculum` no corpo da requisição.

- **Request body:** JSON com os dados do currículo.
- **Response:** PDF (`application/pdf`) com o currículo.

---

## 📄 exemplo de `POST /api/pdf`

### request:

```json
{
  "name": "Weslley",
  "city": "São Paulo",
  "number": "(11) 77777-7777",
  "email": "weslley@email.com",
  "aboutMe": "Desenvolvedor backend com 1 ano de experiência.",
  "workExperience": [
    {
      "company": "Empresa X",
      "cargo": "Desenvolvedor FullStack",
      "workPeriod": "2024 - 2025",
      "description": "Desenvolvimento de APIs REST com TS e JAVA."
    }
  ],
  "skills": [
    { "description": "Java Spring Boot" },
    { "description": "JavaScript e TypeScript" }
    { "description": "Vue e Nest" }
  ],
  "objective": [
    { "description": "Atuar como desenvolvedor fullstack em projetos desafiadores." }
  ]
}
```

### response:
- arquivo PDF em anexo chamado `curriculum.pdf`.

---

##  possíveis melhorias

- integração com templates HTML externos.
- upload de imagem para foto de perfil.
- autenticação JWT.
- suporte a múltiplos idiomas.

---

## 🧑‍💻 Autor

Desenvolvido por [ Weslley ](https://github.com/weslley03) 🚀
