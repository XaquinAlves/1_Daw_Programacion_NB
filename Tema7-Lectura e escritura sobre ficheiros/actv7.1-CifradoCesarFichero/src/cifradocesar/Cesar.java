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
package cifradocesar;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Clase Cesar: permite cifrar y descifrar archivos en Código Cesar.
 *
 * @author Xaquin Alves González
 */
public class Cesar {

    /**
     * Indica que el archivo se debe cifrar
     */
    public static final String OPERATION_ENCRYPT = "-c";
    /**
     * Indica que el archivo se debe descifrar
     */
    public static final String OPERATION_DECODE = "-d";

    /**
     * Ejecuta el programa.
     *
     * @param args <ul>
     * <li>-c para cifrar o -d para descifrar</li>
     * <li>ruta del archivo</li>
     * </ul>
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            if (args[0].equals(OPERATION_ENCRYPT)) {
                init(OPERATION_ENCRYPT, args[1]);
            } else if (args[0].equals(OPERATION_DECODE)) {
                init(OPERATION_DECODE, args[1]);
            } else {
                System.out.println("Parámetro de función incorrecto: "
                        + "-c cifrar, -d descifrar");
            }
        } else {
            System.out.println("Debes introducir o parámetro de función:"
                    + " -c cifrar, -d descifrar; e a ruta do arquivo");
        }
    }

    /**
     * Incia la aplicación, pidiendo la clave de cifrado al usuario y realizando
     * la operación correspondiente segun el parámetro introducido en linea de
     * comandos.
     *
     * @param operation Si se cifra("-c") o se descifra("-d").
     * @param sourceFilePath Ruta del archivo.
     */
    public static void init(String operation, String sourceFilePath) {
        //Obtiene una consola para leer la clave de forma oculta
        Console console = System.console();
        //Pide y lee la clave
        System.out.println("Cifrado Cesar. Introduza unha clave de cifrado: ");
        int key = Integer.parseInt(new String(console.readPassword()));
        //Ejecuta la operación correspondiente
        try {
            if (operation.equals(OPERATION_ENCRYPT)) {
                encryptFile(sourceFilePath, key);
            } else if (operation == OPERATION_DECODE) {
                decodeFile(sourceFilePath, key);
            }
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    /**
     * Cifra un archivo con Código César usando la clave proporcionada.
     *
     * @param sourceFilePath Ruta del archivo.
     * @param key Clave de cifrado.
     * @throws IOException Si ocurre un problema con el archivo.
     */
    public static void encryptFile(String sourceFilePath, int key)
            throws IOException {
        // Declaramos e abrimos os streams de entrada e saída        
        try (InputStream in = new FileInputStream(sourceFilePath)) {
            try (OutputStream out = new FileOutputStream(sourceFilePath + ".cif")) {

                // Usamos os métodos read e write para ler e escribir byte a byte
                int oneByte;
                while ((oneByte = in.read()) != -1) {
                    out.write(oneByte + key);
                }
            }
        }
    }

    /**
     * Descifra un archivo con Código César usando la clave proporcionada.
     *
     * @param sourceFilePath Ruta del archivo.
     * @param key Clave de cifrado.
     * @throws IOException Si ocurre un problema con el archivo.
     */
    public static void decodeFile(String sourceFilePath, int key)
            throws IOException {
        // Declaramos e abrimos os streams de entrada e saída        
        try (InputStream in = new FileInputStream(sourceFilePath)) {
            try (OutputStream out = new FileOutputStream(sourceFilePath + ".des")) {

                // Usamos os métodos read e write para ler e escribir byte a byte
                int oneByte;
                while ((oneByte = in.read()) != -1) {
                    out.write(oneByte - key);
                }
            }
        }
    }
}
