# tmtrial-integration

TOKEN DE FACEBOOK:

Para que el integrador funcione y retorne informacion se debe obtener un token del API GRAPH de Facebook, pueden avisarme para enviarles el mio cuando vayan a probar o pueden crear una cuenta como developer y obtener un Token por medio del Explorador de la API Graph con todos los permisos. No puede quedar fijo ya que por seguridad FB expira los tokens y por eso la razon de tener que obtener uno al momento de probar ya que el previo habra vencido.

Una vez obtenido el token deben ir al directorio "../(raiz del proyecto)/src/main/resources/" y abrir el archivo "application.properties" y reemplazar el atributo de nombre "application.properties" por el token nuevo.

CORRER POR CONSOLA:

Requisitos: (Debe instalarse todo lo que se nombra a continuacion)
* Java  JDK 8
* SDK 1.8
* Maven (Ultima version)

1.- Navegar por la consola hasta la carpeta raiz del del proyecto.
2.- Podemos ejecutar el comando "mvn clean install" para recompilar y reempaquetar el proyecto.
3.- Iniciamos el servlet container embedido de tomcat por medio de spring boot con el comando "mvn spring-boot:run"

Una vez desplegado el integrador se vera por consola como deployed y podemos comenzar a usar el frontend Web una vez que configuremos el mismo.

CORRER POR OTRO SERVICIO:

Requisitos:
* Cualquier servidor de contenedor (Recomiendo Tomcat version 8)

1.- Configurar e instalar el servidor de su eleccion (si es tomcat 8 podemos configurar el manager).
2.- Desplegar el archivo "TMTrial-1.0-SNAPSHOT.war" que se encuentra dentro de la carpeta "(raiz del proyecto)/target/".

Cualquier duda pueden comunicarse conmigo.

Gracias.
