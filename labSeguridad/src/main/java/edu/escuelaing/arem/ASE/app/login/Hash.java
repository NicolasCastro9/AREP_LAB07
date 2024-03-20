package edu.escuelaing.arem.ASE.app.login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase para generar un hash de una cadena utilizando el algoritmo SHA-256.
 */
public class Hash {
    /**
     * Genera un hash SHA-256 para la cadena de entrada.
     *
     * @param input La cadena de entrada para la cual se generará el hash.
     * @return El hash SHA-256 de la cadena de entrada.
     * @throws RuntimeException Si ocurre un error al calcular el hash.
     */
    public static String toHash(String input) {
        try {
            // Obtiene una instancia de MessageDigest para el algoritmo SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // Calcula el hash de la cadena de entrada
            byte[] hash = md.digest(input.getBytes());
            // Convierte el hash en una cadena hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
             // Devuelve la representación hexadecimal del hash
            return hexString.toString();
        } catch (NoSuchAlgorithmException e){
            // Si no se encuentra el algoritmo, lanza una excepción
            throw new RuntimeException(e);
        }
    }
}