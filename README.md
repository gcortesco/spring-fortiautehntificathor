# Demo Oauth-Forti

El proyecto tiene la funcionalidad de demostrar como se debe realizar la configuración de un proyecto springboot con sping security para validar un token producido por fortiAutenticator.

> Toda la configuración se encuentra dentro de la carpeta "src/main/java/com/riu/fortiSpring/config"

## Ejecutar el proyecto

Como primer paso se debe instalar el certificado HTTPS (en formato .cer) en un trustore de java. Para ello se tiene que ejecutar el siguiente comando:

```
keytool.exe -import -trustcacerts -alias riu -file <path al certificado>  -keystore <path al truststore> -storepass <password del truststore>
```

Luego procede a compilar la solución:

```
mvn clean package spring-boot:repackage
```

Finalmente se puede ejecutar la solución con el siguiente comando
 
```
java jar FortiautenticatorSpingApplication-0.0.1-SNAPSHOT.jar -Djavax.net.ssl.trustStore="<path al truststore>" -Djavax.net.ssl.trustStorePassword="<password al truststore>"
```

### endpoints

1. GET "http://localhost:8081/actuator" -> Endpoint sin seguridad con la información de actuator
2. GET "http://localhost:8081/users" -> Endpoint CON seguridad para listar los usuarios creados
3. GET "http://localhost:8081/users (Body: {"username":"","name":""}) -> Endpoint CON seguridad para crear un usuario