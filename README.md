# proyecto_java_spring
En este proyecto se implementan los metodos de todo tipo para hacer una API REST lo mas robusta y completa posible.

## 1. Introducción



### ¿Qué es una API
Es una forma de describir la forma en que los programas o los sitios webs intercambian datos.
El formato de intercambio de datos normalmente es JSON o XML.

### ¿Para qué necesitamos una API?
* Ofrecer datos a aplicaciones que se ejecutan en un movil
* Ofrecer datos a otros desarrolladores con un formato más o menos estándar.
* Ofrecer datos a nuestra propia web/aplicación
* Consumir datos de otras aplicaciones o sitios Web



### ¿Que es una API REST?

1- Una API REST es un conjunto de definiciones y protocolos que permiten la comunicación entre aplicaciones.

### ¿Qué significa API REST?

REST viene de, `REpresentational State Transfer`

Es un tipo de arquitectura de desarrollo web que se apoya totalmente en el estándar HTTP.
REST se compone de una lista de reglas que se deben cumplir en el diseño de la arquitectura de una API.

Restful = adjetivo, Rest = Nombre


### Métodos

Los desarrolladores a menudo implementan API RESTful mediante el uso del protocolo de transferencia de hipertexto (HTTP). Un método de HTTP informa al servidor lo que debe hacer con el recurso. A continuación, se indican cuatro métodos de HTTP comunes:

#### GET

Los clientes utilizan GET para acceder a los recursos que están ubicados en el URL especificado en el servidor. Pueden almacenar en caché las solicitudes GET y enviar parámetros en la solicitud de la API RESTful para indicar al servidor que filtre los datos antes de enviarlos.

#### POST

Los clientes usan POST para enviar datos al servidor. Incluyen la representación de los datos con la solicitud. Enviar la misma solicitud POST varias veces produce el efecto secundario de crear el mismo recurso varias veces.

#### PUT

Los clientes utilizan PUT para actualizar los recursos existentes en el servidor. A diferencia de POST, el envío de la misma solicitud PUT varias veces en un servicio web RESTful da el mismo resultado.

#### DELETE

Los clientes utilizan la solicitud DELETE para eliminar el recurso. Una solicitud DELETE puede cambiar el estado del servidor. Sin embargo, si el usuario no cuenta con la autenticación adecuada, la solicitud fallará.


### Encabezados de HTTP

Los encabezados de solicitudes son los metadatos que se intercambian entre el cliente y el servidor. Por ejemplo, el encabezado de la solicitud indica el formato de la solicitud y la respuesta, proporciona información sobre el estado de la solicitud, etc.

#### Datos

Las solicitudes de la API REST pueden incluir datos para que los métodos POST, PUT y otros métodos HTTP funcionen de manera correcta.

#### Parámetros

Las solicitudes de la API RESTful pueden incluir parámetros que brindan al servidor más detalles sobre lo que se debe hacer. A continuación, se indican algunos tipos de parámetros diferentes:
* Los parámetros de ruta especifican los detalles del URL.
* Los parámetros de consulta solicitan más información acerca del recurso.
* Los parámetros de cookie autentican a los clientes con rapidez.


### Códigos de estado

`2xx` – Indican que la petición se ha satisfecho correctamente
Serán habituales el código 200 (todo fue bien y se ha encontrado el recurso y procesado la respuesta), el 201 (todo OK se ha creado el nuevo recurso) o 204 (todo bien pero no se ha devuelto ningún contenido).

`3xx`- indican que el recurso solicitado está en otra URI diferente
Son comunes la 301 (el recurso se ha cambiado de ubicación definitivamente y nos indica la nueva ubicación), el 302 (el recurso que solicitas se ha movido temporalmente a este otro recurso), aquellos que tengan nociones básicas de SEO estarán familiarizados con estos dos casos.

`4xx` – indican códigos de error en el lado del cliente
En este caso el uso de 400 nos indica que hay un error en el formato o que es demasiado largo, 401 para decirnos que no tenemos autorización para ese recurso o 403, para indicarnos que el acceso al recurso no está permitido y el servidor ha rechazado nuestra petición. También es relevante el error 405 que nos indica que el método no se admite en la API.

`5xx`- indican códigos de error en el lado del servidor
En este último grupo están el error 500, cuando ha habido algún error interno del servidor, 502, cuando el servidor hace de Gateway o proxy y ha recibido una respuesta de error a donde quiera que intentase conectarse o el 503 cuando el servicio en el servidor no está accesible, normalmente debido a una sobrecarga o algún problema similar.


## 2- Dependencias de Spring

### `Spring Boot Starter Web`

Starter of Spring web utiliza Spring MVC, REST y Tomcat como servidor integrado predeterminado. La única dependencia spring-boot-starter-web extrae transitivamente todas las dependencias relacionadas con el desarrollo web. También reduce el recuento de dependencias de compilación. Spring-boot-starter-web depende transitivamente de lo siguiente:

* org.springframework.boot:spring-boot-starter
* org.springframework.boot:spring-boot-starter-tomcat
* org.springframework.boot:spring-boot-starter-validation
* com.fasterxml.jackson.core:jackson-databind
* org.springframework:spring-web
* org.springframework:spring-webmvc

### `Spring Boot Starter Data JPA`

Spring Data es un proyecto Spring Source de alto nivel. Su propósito es unificar y facilitar el acceso a los diferentes tipos de almacenes persistentes, tanto sistemas de bases de datos relacionales como almacenes de datos NoSQL.

Cuando implementamos una nueva aplicación, debemos centrarnos en la lógica comercial en lugar de la complejidad técnica y el código repetitivo. Es por eso que la especificación Java Persistent API (JPA) y Spring Data JPA son extremadamente populares.

Spring Data JPA agrega una capa en la parte superior de JPA. Significa que Spring Data JPA usa todas las funciones definidas por la especificación JPA, especialmente la entidad, las asignaciones de asociación y las capacidades de consulta de JPA. Spring Data JPA agrega sus propias características, como la implementación sin código del patrón de repositorio y la creación de consultas de base de datos a partir del nombre del método.

### `Spring Boot Starter Test`

Spring-boot-starter-test es la dependencia principal de la prueba. Contiene la mayoría de los elementos necesarios para nuestras pruebas.

Hay varios tipos diferentes de pruebas que podemos escribir para ayudar a probar y automatizar el estado de una aplicación. Antes de comenzar cualquier prueba, necesitamos integrar el marco de prueba.

Con Spring Boot, necesitamos agregar starter a nuestro proyecto, para probar solo necesitamos agregar la dependencia spring-boot-starter-test.

### `Spring Security Test`

Para usar Spring Security en sus pruebas unitarias, debe agregar spring-security-test a su proyecto Spring Boot.

De esta manera, la configuración contextual de las pruebas se puede combinar con Spring Security, y los siguientes trucos te enseñarán.

### `jjwt`

jjwt es una biblioteca de Java para crear y analizar JSON Web Tokens (JWT). Los JWT son una forma compacta y segura de transmitir información entre partes como un objeto JSON. Los JWT se pueden firmar usando un secreto (con el algoritmo HMAC) o una clave pública / privada usando RSA o ECDSA.

### `Swagger`

Swagger es una herramienta de código abierto para diseñar, construir, documentar y usar servicios web RESTful. Swagger incluye documentación automática, pruebas de interfaz de usuario y herramientas de generación de código para clientes y servidores.

Swagger se puede usar para documentar y consumir servicios RESTful. Swagger es una especificación de API abierta que define una interfaz común para describir RESTful APIs. Swagger incluye una interfaz de usuario para explorar las APIs documentadas, una herramienta de generación de código para crear clientes y servidores y una colección de extensiones para agregar funcionalidad a las APIs.



## 3- Listado de endpoints, de cada modelo


#### PERSONAJES