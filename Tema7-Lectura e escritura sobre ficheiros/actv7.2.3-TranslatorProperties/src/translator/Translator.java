/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * 
 * 
 * MIT License
 * 
 * Copyright (c) 2025 Xaquin Alves Gonzalez
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package translator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * Clase Translator: traduce un fichero usando un diccionario localizado en un
 * fichero de configuracion, y muestra la traduccion por pantalla.
 *
 * @author Xaquin Alves González
 */
public class Translator {

    /**
     * Ejecuta la aplicacion.
     *
     * @param args Ruta del archivo
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                translate(args[0]);
            } catch (IOException ex) {
                System.err.println("Erro: " + ex.getMessage());
            }
        } else {
            System.out.println("Debe indicar a ruta do arquivo");
        }
    }

    /**
     * Traduce el fichero en la ruta pasada como parametro, usando el
     * diccionario situado en el directorio config.
     *
     * @param sourceFilePath Ruta del archivo a traducir.
     * @throws IOException Si se produce un problema con el archivo.
     */
    public static void translate(String sourceFilePath) throws IOException {
        InputStream input = Translator.class.getClassLoader().getResourceAsStream("config/dictionary.properties");
        if (input == null) {
            System.out.println("Non se pode ler o ficheiro de propiedades");
        } else {
            // Cargamos as propiedades do ficheiro
            Properties prop = new Properties();
            prop.load(input);
            // Obtemos o valor de dúas propiedades e pechamos o fluxo
            try (Scanner in = new Scanner(new BufferedReader(new FileReader(sourceFilePath)))) {
                in.useDelimiter(" ");

                while (in.hasNext()) {
                    String nextTk = in.next();
                    String translation = prop.getProperty(nextTk);

                    if (translation == null) {
                        System.out.print(nextTk);
                    } else {
                        System.out.print(translation);
                    }
                    System.out.print(" ");
                }

            }

            input.close();

        }
    }

}
