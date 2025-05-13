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
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Xaquin Alves González
 */
public class Translator {

    public static void main(String[] args) {

    }

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
                
                try (BufferedWriter out = new BufferedWriter(new FileWriter(sourceFilePath + ".translated"))) {
                    
                }
                
            }
           
            input.close();
            
        }
    }

}
