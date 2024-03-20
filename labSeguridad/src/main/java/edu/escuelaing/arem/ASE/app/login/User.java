package edu.escuelaing.arem.ASE.app.login;

/**
 * Clase que representa un usuario del sistema.
 */
public class User {
    private String name, password;

    /**
     * Constructor de la clase User.
     * 
     * @param name     El nombre del usuario.
     * @param password La contraseña del usuario.
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */
    public String getname() {
        return name;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param name El nuevo nombre del usuario.
     */
    public void setname(String name) {
        this.name = name;
    }
    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Establece la contraseña del usuario.
     * 
     * @param password La nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}