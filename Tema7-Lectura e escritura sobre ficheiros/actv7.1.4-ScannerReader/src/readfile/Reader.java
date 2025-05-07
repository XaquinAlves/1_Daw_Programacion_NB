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
package readfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase Reader: lee un fichero pasado como parametro, separando por el
 * delimitador indicado como segundo parametro, y lo muestra por pantalla.
 *
 * @author Xaquin Alves González
 */
public class Reader {

    /**
     * Ejecuta la aplicación.
     *
     * @param args Ruta del Archivo, Delimitador.
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                readTokens(args[0], args[1]);
            } catch (IOException ex) {
                System.err.println("Erro: " + ex.getMessage());
            }
        } else {
            System.out.println("Debes introducir a ruta do arquivo e o delimitador");
        }
    }

    /**
     * Lee un archivo y lo muestra por pantalla.
     *
     * @param sourceFilePath Ruta del archivo.
     * @param delimiter Delimitador de los tokens.
     * @throws IOException Si se produce un error con el archivo.
     */
    public static void readTokens(String sourceFilePath, String delimiter)
            throws IOException {
        // Declaramos o scanner e abrimolo sobre un reader con buffer
        try (Scanner in = new Scanner(new BufferedReader(new FileReader(sourceFilePath)))) {
            // Establecemos como delimitador o proporcinado como parámetro
            in.useDelimiter(delimiter);
            // Lemos todos os doubles e os mostramos
            while (in.hasNext()) {
                System.out.println(in.next());
            }
        }
    }
}
