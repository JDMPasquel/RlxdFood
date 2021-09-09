/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.rlxdfood.client.infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 * Utilidades varias utilizadas por otras clases
 *
 * @author Libardo, Daniel Paz
 */
public class Utilities {

    /**
     * Cargar una propiedadd de config.properties
     *
     * @param key llave de la propiedad
     * @return valor de la propiedad
     */
    public static String loadProperty(String key) {
        Properties prop = new Properties();
        InputStream is;

        try {
            is = new FileInputStream("./config.properties");
            prop.load(is);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo");
        }

        return prop.getProperty(key);
    }

    /**
     * Verifica si un String contiene sólo digitos
     *
     * @param str Cadena a verificvar
     * @return true si contiene sólo digitos, false en caso contrario
     */
    public static boolean isNumeric(String str) {

        boolean resultado;

        try {
            Integer.parseInt(str);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    /**
     * Carga una imagen y la devuelve como un String de base64
     * @param image nombre del archivo o de la imagen
     * @return imagen codificada en base64
     */
    public static String loadImage(String image) {
        String path = loadProperty("base.images.path") + image;
        File pathFile = new File(path);
        if (pathFile.isFile()) {
            try {
                byte[] fileContent = FileUtils.readFileToByteArray(pathFile);
                String encodedImage = Base64.getEncoder().encodeToString(fileContent);
                return encodedImage;
            } catch (IOException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, "Error cargando la imagen", ex);
            }
        }
        return "";

    }
    /**
     * Carga la imagen y la devuelve en un String base 65
     * @param data arreglo de bytes
     * @return imagen codificada en base64
     */
    public static String loadImage(byte[] data) {          
            String imageStr = Base64.getEncoder().encodeToString(data);
            return imageStr;


    }    
}