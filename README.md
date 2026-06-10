# Sistema de Gerenciamento de Equipamentos Avariados (TI Educação)

## 📌 Descrição do Projeto
Este projeto web foi desenvolvido para solucionar problemas de gestão de ativos físicos de informática no Setor de T.I. da Secretaria de Educação do Município de Penedo. O sistema digitaliza o fluxo de descarte e registro de máquinas sem conserto, provendo um controle digital ágil que centraliza os laudos técnicos e as datas de baixa patrimonial.

O projeto foi construído em **Java EE**, aplicando os conceitos ensinados nas disciplinas de Programação para Web, evoluindo de uma simulação estática (AB1) para um sistema dinâmico e persistente com Banco de Dados (AB2).

## 🎯 Critérios Atendidos (Avaliação AB2)
Este sistema cumpre integralmente os requisitos estipulados para a Avaliação AB2:
- **Formulário de Cadastro:** Interface em HTML para registro de equipamentos avariados.
- **Métodos POST e GET:** Uso do método POST para envio seguro de dados no cadastro e UPDATE, e uso do método GET para consultas (READ), exclusões (DELETE) e passagem de parâmetros via URL (id).
- **Arquitetura MVC:** Separação clara entre Modelo (`Equipamento.java` e `DAO.java`), Visão (`.jsp` e `.html`) e Controle (`Controlador.java`).
- **Classe Servlet:** Utilização de Servlets (`@WebServlet`) para o roteamento e gerenciamento das requisições do sistema.
- **Banco de Dados (MySQL):** Conexão estabelecida via driver JDBC.
- **CRUD Completo:**
  - **C**reate: Inserção de novos laudos no banco (Rota `/insert`).
  - **R**ead: Leitura e listagem dinâmica dos equipamentos do banco (Rota `/read`).
  - **U**pdate: Seleção e alteração de laudos já existentes (Rotas `/select` e `/update`).
  - **D**elete: Exclusão de registros do banco (Rota `/delete`).

## 🛠️ Tecnologias Utilizadas
- **Java (JEE)** e **JSP**
- **Servlets**
- **HTML5 & CSS3**
- **MySQL** (Banco de Dados)
- **MySQL Connector/J** (Driver JDBC)
- **Apache Tomcat** (Servidor Web)
- **Eclipse IDE**

## ⚙️ Como Executar o Projeto

### 1. Pré-requisitos
Certifique-se de ter instalado em sua máquina:
- Java JDK
- Eclipse IDE (versão Enterprise Java and Web Developers)
- Apache Tomcat (versão 10+)
- MySQL Server e MySQL Workbench

### 2. Configuração do Banco de Dados
Abra o MySQL Workbench e execute o script abaixo para criar o Schema e a Tabela necessários:

"sql
CREATE DATABASE sistema_ti;
USE sistema_ti;

CREATE TABLE equipamentos (
    id int primary key auto_increment,
    nome varchar(100) not null,
    defeito varchar(255) not null,
    dataBaixa varchar(20) not null
);"
3. Configuração do Projeto no Eclipse
Clone este repositório para o seu computador.
No Eclipse, vá em File > Import > Existing Projects into Workspace e selecione a pasta do projeto.
Baixe o MySQL Connector/J (mysql-connector-j-8.0.XX.jar) no site oficial da Oracle.
Adicione o arquivo .jar do conector dentro da pasta WebContent/WEB-INF/lib/ do projeto no Eclipse.
Abra o arquivo src/main/java/model/DAO.java e altere a variável password para a senha do seu usuário root do MySQL local.
4. Rodando o Sistema
Clique com o botão direito na pasta raiz do projeto no Eclipse.
Selecione Run As > Run on Server.
Escolha o seu servidor Apache Tomcat e clique em Finish.
O sistema abrirá na tela inicial index.html. A partir dela, você pode testar todas as funcionalidades do CRUD interagindo com o Banco de Dados.
🗂️ Estrutura de Rotas do Controlador (Servlet)
index.html -> Página inicial.
/insert -> (POST) Recebe os dados do formulário e cria um novo equipamento no BD.
/read -> (GET) Consulta os equipamentos no BD e redireciona para a lista.
/select -> (GET) Carrega os dados de um equipamento específico para edição.
/update -> (POST) Atualiza as informações do equipamento editado no BD.
/delete -> (GET) Exclui o equipamento selecionado do BD baseado no ID.
