# Aplicación Web Segura

El proyecto consiste en una aplicación Java para gestionar el proceso de inicio de sesión de usuarios, proporcionando una página principal segura. Utiliza el framework Spark para Java para crear un servidor web y realizar el enrutamiento de las solicitudes. La seguridad se implementa utilizando certificados SSL/TLS para establecer conexiones seguras. Además, se incluyen funcionalidades para leer el contenido de una URL de forma segura.

# Clases

Login.java: Esta clase gestiona el proceso de inicio de sesión de usuarios. Define una ruta para manejar las solicitudes POST de inicio de sesión, verifica las credenciales de los usuarios y crea una sesión para usuarios autenticados.

User.java: Representa un usuario del sistema. Almacena el nombre y la contraseña del usuario, proporcionando métodos para acceder y modificar estos atributos.

MainPage.java: Define la página principal de la aplicación. Configura el servidor Spark para servir la página principal y establece la seguridad utilizando certificados SSL/TLS.

SecureUrlReader.java: Proporciona métodos para leer una URL de forma segura. Configura la seguridad SSL utilizando un almacén de confianza y proporciona un método para leer el contenido de una URL, mostrando los encabezados y el cuerpo del mensaje de manera segura.

Hash.java: Esta clase proporciona un método estático para generar un hash SHA-256 de una cadena de entrada. Se utiliza para hashear las contraseñas de usuario antes de almacenarlas en la base de datos, mejorando la seguridad del sistema de autenticación.

# Pre-Requisitos

Java: Es un lenguaje de programación de propósito general orientado a objetos, portátil y muy versátil.

Maven: Es una herramienta que maneja el ciclo de vida del programa.

Git: Es un sistema de control de versiones distribuido (VCS).

Docker: Es un proyecto de código abierto que automatiza el despliegue de aplicaciones dentro de contenedores de software.

# Dependencias

Spark: Framework web para Java que se utiliza para crear el servidor web y manejar las solicitudes HTTP.

Java Standard Library: Utilizada para operaciones de E/S, manipulación de archivos y gestión de seguridad.

javax.net.ssl: Proporciona clases para la configuración de conexiones seguras utilizando SSL/TLS.

java.security: Utilizada para la generación de hash de contraseñas utilizando el algoritmo SHA-256.

# INSTRUCCION DE USO

1. Clonamos el repositorio

   ```
   git clone https://github.com/NicolasCastro9/AREP_LAB07.git
   ```
2. En la consola de comandos navegar hasta el directorio donde se encuentra el pom del proyecto

```
cd labSeguridad
```

3. Ejecuta el siguiente comando para compilar el proyecto y descargar las dependencias definidas en el archivo

  ```
  mvn clean install
  ```

4. Corremos las instancias con los siguientes comandos en diferentes terminales

```
java -cp "target/classes;target/dependency/*" edu.escuelaing.arem.ASE.app.login.Login
java -cp "target/classes;target/dependency/*" edu.escuelaing.arem.ASE.app.mainPage.MainPage
```

5. En el navegador ingresamos la siguiente URL

```
https://localhost:5000/
```
![image](https://github.com/NicolasCastro9/AREP_LAB07/assets/98556822/087eb8e3-97de-4516-b4fd-c5a7d2ac7c22)


6. Probamos con credenciales incorrectas:

![image](https://github.com/NicolasCastro9/AREP_LAB07/assets/98556822/4a176ca9-c915-4c1c-8856-d62a01dceab9)

7. Probamos con credenciales correctas: user: admin, password: 123456

![image](https://github.com/NicolasCastro9/AREP_LAB07/assets/98556822/4a443ff8-8536-49d5-a5f3-30241d9683e3)

