# Farmu Interview Challenge

Este repositorio contiene un proyecto de Spring Boot para el Desafío de Farmu Interview. Está diseñado para proporcionar dos funcionalidades clave: redimensionar imágenes y crear URLs acortadas. En este README, proporcionaremos una descripción general de la estructura del proyecto y sus componentes principales.

## Tabla de contenidos
- [Repositorio](#repositorio)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Redimensionamiento de imágenes](#redimensionamiento-de-imágenes)
- [Acortamiento de URLs](#acortamiento-de-urls)
- [Entorno de desarrollo](#entorno-de-desarrollo)
- [Configuración de la base de datos H2](#configuración-de-la-base-de-datos-h2)

## Repositorio
Para trabajar con este proyecto, necesitarás clonarlo desde el repositorio de GitHub. Sigue estos pasos para hacerlo:

1. Abre tu terminal o línea de comandos.
2. Navega al directorio donde deseas clonar el proyecto utilizando el comando cd.
3. En la terminal ejecuta el siguiente comando para clonar el repositorio: 'git clone https://github.com/FedericoFortuna/farmu-interview.git'

## Estructura del proyecto

El proyecto está organizado en dos controladores principales, cada uno responsable de una funcionalidad específica:

1. **ImageController**: Este controlador maneja el redimensionamiento de imágenes. Expone un punto final `/image/resize` para cargar un archivo de imagen y especificar el ancho y alto deseados para el redimensionamiento. La imagen redimensionada se devuelve como respuesta.

2. **UrlController**: Este controlador gestiona el acortamiento y la redirección de URLs. Proporciona dos puntos finales:
    - `/url`: Acepta una URL y devuelve una versión acortada.
    - `/url/shortened`: Redirige desde una URL acortada a su ruta original.

Además, el proyecto incluye Maven para la gestión de dependencias y utiliza H2 como base de datos en memoria con fines de prueba.

## Redimensionamiento de imágenes

El controlador `ImageController` es responsable del redimensionamiento de imágenes. Cuando se realiza una solicitud POST a `/image/resize`, el controlador recibe un archivo de imagen y el ancho y alto de destino para el redimensionamiento. La imagen se redimensiona utilizando el servicio `ImageService` y se devuelve como respuesta.

Para hacer uso de este servicio podemos utilizar la aplicación Postman.
Cabe aclarar que el metodo HTTP utilizado es POST.
1. Cargamos la imagen que querramos y en la dirección url indicamos: 'http://localhost:8080/image/resize?width=xxx&height=yyy' reemplazando xxx e yyy por los valores deseados.


## Acortamiento de URLs

El controlador `UrlController` maneja el acortamiento y la redirección de URLs. Cuando se proporciona una URL a `/url`, genera una versión acortada y la devuelve. El punto final `/url/shortened` se utiliza para redirigir desde una URL acortada a la URL original.
* Es importante tener en cuenta que los url proporcionados para obtener un url acortado, deben ser enviados con el protocolo https al inicio de esta.


Las funcionalidades pueden ser probadas desde un navegador accediendo a: 
1. http://localhost:8080/url?path=REPLACE_ME_WITH_URL para obtener un url acortado
2. http://localhost:8080/url/shortened?url=REPLACE_ME_WITH_SHORTENED_URL para ser redirigido al url original

## Entorno de desarrollo

Para configurar el entorno de desarrollo, asegúrate de tener Java 17 instalado y sigue estos pasos:

1. Importa el proyecto en tu IDE preferido como un proyecto Maven.

2. Compila y ejecuta el proyecto localmente utilizando el soporte de Spring Boot de tu IDE o ejecutando `mvn spring-boot:run` en el directorio del proyecto.

3. Accede a los puntos finales de la API como se describe anteriormente.

## Configuración de la base de datos H2

El proyecto utiliza la base de datos H2 en memoria con fines de prueba. La configuración de la base de datos se encuentra en `application.properties`. La base de datos se crea automáticamente al iniciar la aplicación, y puedes acceder a la Consola H2 en [http://localhost:8080/h2-console/](http://localhost:8080/h2-console/) para gestionar la base de datos.

- **URL**: jdbc:h2:mem:testdb
- **Nombre de usuario**: farmu
- **Contraseña**: farmu


Este README proporciona una descripción general del proyecto Farmu Interview Challenge. Para obtener más detalles, consulta el código fuente y la documentación en el repositorio de GitHub.