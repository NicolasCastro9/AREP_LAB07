package edu.escuelaing.arem.ASE.app.login;
import edu.escuelaing.arem.ASE.app.mainPage.SecureUrlReader;

import spark.Session;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



import static spark.Spark.*;

/**
 * Clase que gestiona el proceso de inicio de sesión de usuarios.
 */
public class Login {
    // Mapa para almacenar los usuarios y sus contraseñas hasheadas
    private static final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>(Map.of(
            "admin", new User("admin", Hash.toHash("123456"))
    ));

    /**
     * Método principal que configura el servidor Spark y maneja el proceso de inicio de sesión.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        secure(getKey(), getKeyPwd(), null, null);
        post("/login", (request, response) -> {
            String name = request.queryParams("name");
            String password = request.queryParams("password");

            if (users.containsKey(name) && users.get(name).getPassword().equals(Hash.toHash(password))) {
                Session session = request.session(true);
                session.attribute("name", name);
                SecureUrlReader.check(getTrust(), getKeyPwd());
                response.redirect("https://localhost:5001/mainpage");
                return null;
            }

            return "USUARIO DESCONOCIDO";
        });
    }

    /**
     * Obtiene el puerto en el que se ejecutará el servidor Spark.
     *
     * @return El puerto del servidor Spark.
     */
    public static Integer getPort() {
        return 5000;
    }
    /**
     * Obtiene la ruta del archivo de clave privada para la configuración de seguridad.
     *
     * @return La ruta del archivo de clave privada.
     */
    public static String getKey() {
        return "certificados/ecikeystore.p12";
    }
    /**
     * Obtiene la ruta del archivo de confianza para la configuración de seguridad.
     *
     * @return La ruta del archivo de confianza.
     */
    public static String getTrust() {
        return  "certificados/myTrustStore";
    }
    /**
     * Obtiene la contraseña de la clave privada para la configuración de seguridad.
     *
     * @return La contraseña de la clave privada.
     */
    public static String getKeyPwd() {
        return  "123456";
    }

}