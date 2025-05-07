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
package fileio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase CharReplacer: remplaza todas las ocurrencias de un caracter en un
 * archivo, creando una copia con el resultado.
 *
 * @author Xaquin Alves González
 */
public class CharReplacer {

    /**
     * Ejecuta la aplicación.
     *
     * @param args Ruta del Archivo, Caracter a remplazar, Caracter de remplazo.
     */
    public static void main(String[] args) {
        if (args.length == 3) {
            try {
                replaceCharFromFile(args[0], args[1].charAt(0), args[2].charAt(0));
            } catch (IOException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        } else {
            System.out.println("Parámetros incorrectos, introduza a ruta do "
                    + "arquivo, o caracter a remplazar e o carater de remplazo ");
        }
    }

    /**
     * Remplaza las ocurrencias de un caracter por otro en un archivo, creando
     * un archivo .copia con el resultado.
     *
     * @param sourceFilePath Archivo fuente.
     * @param oldChar Caracter a remplazar.
     * @param replaceChar Caracter de remplazo.
     * @throws IOException si se produce un fallo con el archivo.
     */
    public static void replaceCharFromFile(String sourceFilePath, char oldChar,
            char replaceChar) throws IOException {
        // Declaramos e abrimos o reader e o writer
        try (FileReader in = new FileReader(sourceFilePath)) {
            try (FileWriter out = new FileWriter(sourceFilePath + ".copia")) {
                // Usamos os métodos read e write para ler e escribir caracter a caracter
                int oneChar;
                while ((oneChar = in.read()) != -1) {
                    //Si o caracter coincide, remplazamolo, se non copiamolo
                    if (oneChar == oldChar) {
                        out.write(replaceChar);
                    } else {
                        out.write(oneChar);
                    }
                }
            }
        }
    }

}
