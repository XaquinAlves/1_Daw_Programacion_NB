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
package probajaxp;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Xaquin Alves González
 */
public class ProbaDOM {

    public static void main(String[] args) {
        /*
            PROCESAMENTO XML CON DOM
         */
        try {
            //Instanciamos unha DocumentBuilderFactory para crear un DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Lectura do documento XML con DOM
            File file = new File("src/resources/biblioteca.xml");
            Document doc = builder.parse(file);
            
            // Creación dunha ábore baleira
            Document doc2 = builder.newDocument();
            
            System.out.println("Procesamento de XML con DOM");
            // Obtemos os nodos fillos do elemento raíz
            NodeList list = doc.getDocumentElement().getChildNodes();
            
            for (int i = 0; i < list.getLength(); i++) {
                // Se o nodo é un elemento, interpretámolo como elemento e
                // mostramos a etiqueta os atributos
                if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element e = (Element) list.item(i);
                    System.out.println("Elemento " + e.getTagName());
                    System.out.print("Atributos: ");
                    
                    // Mostramos todos os atributos do elemento e o seu valor
                    for (int j = 0; j < e.getAttributes().getLength(); j++) {
                        Attr a = (Attr) e.getAttributes().item(j);
                        System.out.print(a.getName() + "(" + a.getValue() + ") ");
                    }
                    System.out.println();
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.err.println(ex.getMessage());
        }
        /*
            PROCESAMENTO XML CON DOM, VALIDADO CON SCHEMA
        */
        try {
            // Creamos unha factoría para validar o documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setValidating(true);
            factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                    "http://www.w3.org/2001/XMLSchema");
            
            // Creamos o parser e establecemos a manexadora de erros
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new MyErrorHandler());
            
            // Lectura do documento XML con DOM
            File file = new File("src/resources/validacion-schema.xml");
            Document doc = builder.parse(file);
            
            System.out.println("Procesamento de XML con DOM, validado con SCHEMA");
            // Obtemos os nodos fillos do elemento raíz
            NodeList list = doc.getDocumentElement().getChildNodes();
            
            for (int i = 0; i < list.getLength(); i++) {
                // Se o nodo é un elemento, interpretámolo como elemento e
                // mostramos a etiqueta os atributos
                if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element e = (Element) list.item(i);
                    System.out.println("Elemento " + e.getTagName());
                    System.out.print("Atributos: ");
                    
                    // Mostramos todos os atributos do elemento e o seu valor
                    for (int j = 0; j < e.getAttributes().getLength(); j++) {
                        Attr a = (Attr) e.getAttributes().item(j);
                        System.out.print(a.getName() + "(" + a.getValue() + ") ");
                    }
                    System.out.println();
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Erro ao procesar o documento XML: " + e.getMessage());
        }
    }

}
