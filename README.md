<h1 align="center">Exemplo de arquitetura de testes utilizando Rest-Assured</h1>

[![Java CI](https://github.com/maximilianoalves/restassured-arch-template/actions/workflows/java-test-with-allure.yml/badge.svg)](https://github.com/maximilianoalves/restassured-arch-template/actions/workflows/java-test-with-allure.yml)  
<p>Projeto criado para servir como exemplo de arquitetura para demais projetos de testes de API.</p>

## Tecnologias utilizadas
- [Java](https://www.java.com/pt-BR/)
- [Rest-Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
- [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)
- [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
- [Junit 5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
- [Allure](https://docs.qameta.io/allure/#_junit_5)
- [Java faker](https://github.com/DiUS/java-faker)

## Estrutura de arquivos.

📦src  
 ┣ 📂main  
 ┃ ┣ 📂java  
 ┃ ┗ 📂resources  
 ┗ 📂test  
 ┃ ┣ 📂java  
 ┃ ┃ ┗ 📂io  
 ┃ ┃ ┃ ┗ 📂github  
 ┃ ┃ ┃ ┃ ┗ 📂maximilianoalves  
 ┃ ┃ ┃ ┃ ┃ ┣ 📂payloads  
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂login  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoginModel.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂produtos  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProdutosModel.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂usuarios  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UsuariosModel.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginPayload.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ProdutosPayload.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UsuariosPayload.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📂runners  
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SchemasTestsRunner.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TodosTestsRunner.java  
 ┃ ┃ ┃ ┃ ┃ ┣ 📂tests  
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂base  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂requests  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BaseRequest.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂tests  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BaseTest.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂carrinhos  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂requests  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CarrinhosRequest.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂tests  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CarrinhosTest.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂login  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂requests  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoginRequest.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂tests  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoginTest.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂produtos  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂requests  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProdutosRequest.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂tests  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ListarProdutosTest.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂usuarios  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂requests  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UsuariosRequest.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂tests  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CadastrarUsuariosTest.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExcluirUsuariosTest.java  
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ListarUsuariosTest.java  
 ┃ ┃ ┃ ┃ ┃ ┗ 📂utils  
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Utils.java  
 ┃ ┗ 📂resources  
 ┃ ┃ ┣ 📂schemas  
 ┃ ┃ ┃ ┣ 📂produtos  
 ┃ ┃ ┃ ┃ ┣ 📜produto.json  
 ┃ ┃ ┃ ┃ ┗ 📜produtos.json  
 ┃ ┃ ┃ ┣ 📂usuarios  
 ┃ ┃ ┃ ┃ ┣ 📜usuario.json  
 ┃ ┃ ┃ ┃ ┗ 📜usuarios.json  

## Exemplos de execução

```java
    mvn test -Dgroups=todos
```

## Relatório de execução

- Job:
  - [https://github.com/maximilianoalves/restassured-arch-template/actions/workflows/java-test-with-allure.yml](https://github.com/maximilianoalves/restassured-arch-template/actions/workflows/java-test-with-allure.yml)  

- Relatório: 
  - [https://maximilianoalves.github.io/restassured-arch-template/](https://maximilianoalves.github.io/restassured-arch-template/)

## Melhorias, criticas ou dúvidas: 

Não hesite em abrir uma issue ou entrar em contato comigo: 

[![Twitter](https://badgen.net/badge/Twitter/%40max_dacruz?icon=twitter)](https://twitter.com/max_dacruz)
[![Medium](https://badgen.net/badge/Medium/%40maximilianoalves?icon=medium)](https://medium.com/@maximilianoalves)
[![Linkedin](https://badgen.net/badge/Linkedin/maximilianodacruz?icon=linkedin)](https://www.linkedin.com/in/maximilianodacruz/)
[![Instagram](https://badgen.net/badge/Instagram/max_dacruz?icon=instagram)](https://www.instagram.com/max_dacruz/)
[![Facebook](https://badgen.net/badge/Facebook/maximilianoalvesdacruz?icon=facebook)](https://www.facebook.com/maximilianoalvesdacruz)

