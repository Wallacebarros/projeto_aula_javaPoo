# projeto_aula_javaPoo
projeto fullstack focado em java e orientação a objeto, projeto valendo nota académico na matéria de poo

como usar:
baixe as dependencias mavem e o jdk 17 +

execute o spring boot aprtir do arquivo PoojavaaAplication.java

usando o postimen ou o thunder:
criar novo usuario
POST http://localhost:8080/user body: {"name":"","email":"","password":""}

pegar todos os usuarios
GET http://localhost:8080/user

atualizar usuario
PUT http://localhost:8080/user?email=email_do_usuario body: {"name":"","email":"","password":""}

deletar usuario
DELETE http://localhost:8080/user?email=email_do_usuario