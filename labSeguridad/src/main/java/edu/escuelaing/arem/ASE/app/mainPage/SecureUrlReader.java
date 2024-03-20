package edu.escuelaing.arem.ASE.app.mainPage;

import java.io.*;
import java.net.*;
import java.security.KeyStore;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/**
 * Clase que proporciona métodos para leer una URL de forma segura.
 */
public class SecureUrlReader {
    /**
     * Configura la seguridad para la conexión SSL utilizando el almacén de confianza especificado.
     * 
     * @param path   La ruta al archivo de almacén de confianza.
     * @param psswd  La contraseña del almacén de confianza.
     */
    public static void check(String path, String psswd) {
        
        try {
            
            File trustStoreFile = new File(path);
            char[] trustStorePassword = psswd.toCharArray();

            
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);

            
            TrustManagerFactory tmf = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            
            
            tmf.init(trustStore);
            
            
            for(TrustManager t: tmf.getTrustManagers()){
                System.out.println(t);
            }
            
            
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
            SSLContext.setDefault(sslContext);
            

        } catch (Exception ex) {
            Logger.getLogger(SecureUrlReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Lee el contenido de la URL especificada y muestra los encabezados y el cuerpo del mensaje.
     * 
     * @param sitetoread La URL que se va a leer.
     */
    public static void readURL(String sitetoread) {
        try {

            URL siteURL = new URL(sitetoread);
            
            URLConnection urlConnection = siteURL.openConnection();
            
            Map<String, List<String>> headers = urlConnection.getHeaderFields();
            
            Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
            
            for (Map.Entry<String, List<String>> entry : entrySet) {
                String headerName = entry.getKey();

                
                if (headerName != null) {
                    System.out.print(headerName + ":");
                }
                List<String> headerValues = entry.getValue();
                for (String value : headerValues) {
                    System.out.print(value);
                }
                System.out.println("");
            }

            System.out.println("-------message-body------");
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}