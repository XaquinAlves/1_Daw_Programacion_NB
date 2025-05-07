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
package lines;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase Lines: crea una copia de un archivo con formato .copia con las lineas
 * numeradas.
 *
 * @author Xaquin Alves González
 */
public class Lines {

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                countLinesFromFile(args[0]);
                System.out.println("Operación completada");
            } catch (IOException ex) {
                System.err.println("Erro: " + ex.getMessage());
            }
        } else {
            System.out.println("Debes introducir a ruta do arquivo");
        }
    }

    /**
     * Crea una copia de un archivo con las lineas numeradas.
     *
     * @param sourceFilePath Ruta del archivo.
     * @throws IOException Si hay un problema con el archivo.
     */
    public static void countLinesFromFile(String sourceFilePath)
            throws IOException {
        // Declaramos e abrimos o reader e o writer con buffer
        try (BufferedReader in = new BufferedReader(new FileReader(sourceFilePath))) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(sourceFilePath + ".lines"))) {
                // Usamos os métodos readLine, write e writeLine para 
                // ler e escribir liña a liña
                String line;
                int lineCount = 0;
                while ((line = in.readLine()) != null) {
                    out.write(lineCount++ + "." + line);
                    out.newLine();
                }
                // Non sería necesario, pero forzamos o volcado do buffer ao rematar
                out.flush();
            }
        }
    }
}
