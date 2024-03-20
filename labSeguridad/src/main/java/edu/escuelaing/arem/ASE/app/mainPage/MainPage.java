package edu.escuelaing.arem.ASE.app.mainPage;
import static spark.Spark.*;


/**
 * Clase que define la página principal de la aplicación.
 */
public class MainPage {



    /**
     * Método principal que configura el servidor Spark y maneja la página principal.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        secure(getKey(), getKeyPwd(), null, null);
        get("/mainpage", (request, response) -> {
            SecureUrlReader.check(getTrust(),getKeyPwd());
            response.type("text/html");
            return "<html><head><title>Admin logueado</title></head><body><h1>BIENVENIDO</h1><img src=\"/img/welcome.gif\" alt=\"Welcome GIF\"></body></html>";

        });
    }
    /**
     * Obtiene el puerto en el que se ejecutará el servidor Spark para la página principal.
     *
     * @return El puerto del servidor Spark para la página principal.
     */
    public static Integer getPort() {
        return 5001;
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