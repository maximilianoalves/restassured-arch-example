<h1 align="center">Architecture example using Rest-Assured for api tests</h1>

[![Java CI](https://github.com/maximilianoalves/restassured-arch-template/actions/workflows/java-test-with-allure.yml/badge.svg)](https://github.com/maximilianoalves/restassured-arch-template/actions/workflows/java-test-with-allure.yml)  

<b>Para acessar a versão em Português do Brasil, basta clicar [aqui](/docs/README-pt_BR.md)! :brazil:</b>

<p>This project was created for example of structure for api testing using Java and Rest-Assured. </p>

## Technologies and tools used:
- [Java](https://www.java.com/pt-BR/)
- [Rest-Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
- [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)
- [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
- [Junit 5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
- [Allure](https://docs.qameta.io/allure/#_junit_5)
- [Java faker](https://github.com/DiUS/java-faker)

## File structure:

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

## Execution Examples:

```java
    mvn test -Dgroups=todos
```

## Execution report

- Job:
  - [https://github.com/maximilianoalves/restassured-arch-template/actions/workflows/java-test-with-allure.yml](https://github.com/maximilianoalves/restassured-arch-template/actions/workflows/java-test-with-allure.yml)  

- Report: 
  - [https://maximilianoalves.github.io/restassured-arch-template/](https://maximilianoalves.github.io/restassured-arch-template/)

## Doubts or improvements !? contact me:

[![Twitter](https://badgen.net/badge/Twitter/%40max_dacruz?icon=twitter)](https://twitter.com/max_dacruz) [![Medium](https://badgen.net/badge/Medium/%40maximilianoalves?icon=medium)](https://medium.com/@maximilianoalves) [![Linkedin](https://badgen.net/badge/Linkedin/maximilianodacruz?icon=linkedin)](https://www.linkedin.com/in/maximilianodacruz/) [![Instagram](https://badgen.net/badge/Instagram/max_dacruz?icon=instagram)](https://www.instagram.com/max_dacruz/) [![Facebook](https://badgen.net/badge/Facebook/maximilianoalvesdacruz?icon=facebook)](https://www.facebook.com/maximilianoalvesdacruz)

