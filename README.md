# Spring Rest - Books

Este é um projeto simples desenvolvido para testes de conhecimento na IDE Eclipse STS (Spring Tools Suites)

## Passos iniciais

Não é necessário utilizar nenhum banco de dados, este projeto utiliza apenas o H2 Database.

### Pre-requisitos

```
- JDK 11
- Postman ou Insomnia ou a documentação do swagger.
```
<br>
 
**URL DO BANCO:** [localhost:8080/h2](http://localhost:8080/h2 "Fork do projeto");  
**URL DOCUMENTAÇÃO:** [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html);   

<br>

## Clonando e configurando o projeto pelo Eclipse
- - -

1. #### Fork do projeto:  
1.1. Clique em `FORK` ou [clique aqui](https://github.com/thiagoalvesfoz/Books/fork "Fork do projeto");  
1.2. Uma cópia do projeto será feita e você será redirecionado para o seu perfil;    
1.3. Localize o projeto no seu repositório e clique em clone. 

2. #### Clone seu fork pelo Eclipse:
2.1. Abra seu Eclipse;   
2.2. Acesse `File > Import...`          
2.3. Escolha a opção `Projects from Git`       
2.4. Escolha a opção `Clone URI`;  
    `Os campos referente a localização devem ser preenchidos automaticamente. Caso contrário, retorne ao item 1.3.`    
2.5. Clique em Next;  
2.6. Em `Local destination` você pode alterar o local onde o projeto será clonado, definindo por exemplo seu workspace;        
2.7. Em `Select a wizard to use importing projects` escolha a opção `Import as general project`  
2.8. Finish.

3. #### Configurando como Maven Project:
3.1. Clique com o botão direito sobre o projeto e escolha a opção `Configure > Convert to Maven Project`          
3.2. Espere o download de todas as dependecias do projeto


Se tudo ocorreu conforme o esperado você está pronto para executar o projeto.
- - -


## Tecnologias Utilizadas
```
* Spring Boot
* Spring Data JPA
* Apache Tomcat
* H2 Database
* Mavem
* Java JDK 11
```

## Alguns links de recursos utilizados

* [HTTP_Status](https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status) - Significado de códigos de status HTTP
* [Spring Data JPA](https://maven.apache.org/) - Para implementação de repositórios baseados JPA

