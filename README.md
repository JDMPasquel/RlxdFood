# RlxdFood_Microservices
Delivery application

Cada uno de los microservicios está implementado con base de datos MySQL, por lo que si desea probarlos, 
debe crear un esquema en SQL workbench (o cualquier cliente de MSQL) y cambiar, en el archivo "application.properties"
que se encuentra en src>>main>>resources de cada uno de los servicios los siguientes atributos
spring.datasource.url=jdbc:mysql://localhost:3306/restaurants_db?useSSL=false&serverTimeZone=LATAM
spring.datasource.username=root
spring.datasource.password=ingesis

spring.datasource.url --> únicamente se debe hacer el cambio donde dice restaurants_db por el nombre del esquema de su base de datos
spring.datasource.username --> su correspondiente usuario del esquema creado
spring.datasource.password --> Su correspondiente contraseña del esquema creado

PROBAR LOS SERVICIOS EN POSTMAN DE LA SIGUIENTE MANERA:

Component-service
Postman >> url = localhost:7777/api/components
POST:
body>>raw>>text - JSON
{
    "name":"Nombre que desee",
    "type":"Tipo que puede ser START, MAIN_COURSE, PROTEIN, DRINK"
}

GET:
 componente específico: url = localhost:7777/api/components/id
 Todos los componentes: url = localhost:7777/api/components/


user-service
Postman >> url = localhost:7890/api/clients
POST:
body>>raw>>text - JSON
{
    "name":"Nombre que desee",
    "biologicGender": "Valor que puede ser FEMALE O MALE",
    "birthDate": "Fecha de nacimiento en formato yyyy-MM-dd por ejemplo 1990-09-09",
    "phoneNumber": "número cualquiera"
    "email": "El que se desee"
    "password": "La que se desee"
}

NO SE PUEDE HACER GET

restaurant-handler-service
Postman >> url = localhost:8790/api/restaurants
POST:
body>>raw>>text - JSON
{
    
}

GET:
    Restaurante específico: localhost:8790/api/restaurants/nit
    Todos restaurantes: localhost:8790/api/restaurants/
