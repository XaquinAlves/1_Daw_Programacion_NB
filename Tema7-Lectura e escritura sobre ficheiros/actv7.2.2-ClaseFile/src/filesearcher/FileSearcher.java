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
package filesearcher;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase FileSearcher: busca el fichero indicado, en el directorio indicado,
 * proporcionando datos si existe y creandolo si no.
 *
 * @author Xaquin Alves González
 */
public class FileSearcher {

    /**
     * Pide los datos al usuario y ejecuta la aplicacion.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce o nome do ficheiro: ");
        String fileName = scanner.nextLine();

        System.out.print("Introduce o directorio ao que pertence: ");
        String directoryName = scanner.nextLine();

        File file = new File(directoryName, fileName);
        try {
            if (file.exists()) {
                System.out.println("Nome: " + file.getName() + "\n"
                        + "Directorio pai: " + file.getParent() + "\n"
                        + "Ruta absoluta: " + file.getAbsolutePath() + "\n"
                        + "Ruta relativa: " + file.getPath() + " \n"
                        + "Numero de 'a': " + countA(file));
            } else {
                file.createNewFile();
                System.out.println("Arquivo creado");
            }
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
        }
    }

    /**
     * Cuenta el numero de ocurrencias del caracter 'a' en el archivo.
     *
     * @param file Archivo a buscar.
     * @return Numero de ocurrencias.
     * @throws Exception Si hay un problema con el archivo.
     */
    public static int countA(File file) throws Exception {
        try (FileReader in = new FileReader(file)) {
            int count = 0;
            int oneChar;
            while ((oneChar = in.read()) != -1) {
                if (oneChar == 'a') {
                    count++;
                }
            }
            return count;
        } catch (IOException ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
