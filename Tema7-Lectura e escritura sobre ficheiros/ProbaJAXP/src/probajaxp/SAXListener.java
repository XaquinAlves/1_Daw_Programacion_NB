/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Exemplo dun oínte SAX para procesar un documento XML.
 *
 * @author xaquin.alvesgonzalez
 */
public class SAXListener extends DefaultHandler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
            PROCESAMIENTO DE XML CON SAX
         */
        try {
            //Instanciamos unha SAXParserFactory para crear un parser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            // Ficheiro a procesar
            File XMLfile = new File("src/resources/biblioteca.xml");
            
            // Creamos o obxecto oínte
            DefaultHandler listener = new SAXListener();
            
            // Lanzamos o proceso de parseo
            System.out.println("Procesamento de XML con SAX");
            parser.parse(XMLfile, listener);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.err.println(ex.getMessage());
        }
        /*
            VALIDACION CON SAX CON SCHEMA
         */
        try {
            //Instanciamos unha SAXParserFactory para crear un parser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            
            // Establecemos estas propidades para validar o documento XML
            factory.setNamespaceAware(true);
            factory.setValidating(true);
            //Creamos o parser
            SAXParser parser = factory.newSAXParser();
            
            // Esta propiedade só a establecemos se validamos o documento cun esquema
            parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                    "http://www.w3.org/2001/XMLSchema");
            
            // Ficheiro a procesar
            File XMLfile = new File("src/resources/validacion-schema.xml");
            // Creamos o obxecto oínte
            DefaultHandler listener = new SAXListener();
            // Lanzamos o proceso de parseo
            System.out.println("Procesamento de XML con SAX, Validado con SCHEMA");
            parser.parse(XMLfile, listener);
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Erro ao procesar o documento XML: " + e.getMessage());
        }
        /*
            VALIDACION CON SAX CON DTD
         */
        try {
            //Instanciamos unha SAXParserFactory para crear un parser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            
            // Establecemos estas propidades para validar o documento XML
            factory.setNamespaceAware(true);
            factory.setValidating(true);
            //Creamos o parser
            SAXParser parser = factory.newSAXParser();
            
            // Ficheiro a procesar
            File XMLfile = new File("src/resources/validacion-dtd.xml");
            // Creamos o obxecto oínte
            DefaultHandler listener = new SAXListener();
            // Lanzamos o proceso de parseo
            System.out.println("Procesamento de XML con SAX, Validado con DTD");
            parser.parse(XMLfile, listener);
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Erro ao procesar o documento XML: " + e.getMessage());
        }
    }

    /*
        METODOS BÁSICOS PARA MANEJO DE XML
     */
    @Override
    public void startDocument() {
        System.out.println("Comezo do documento");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Final do documento");
    }

    @Override
    public void startElement(String namespace, String sName, String qName, Attributes atrs) {
        System.out.println("Elemento: " + qName);
        if (atrs != null) {
            for (int i = 0; i < atrs.getLength(); i++) {
                System.out.println("Atributo: " + atrs.getQName(i) + " = " + atrs.getValue(i));
            }
        }
    }

    @Override
    public void characters(char buf[], int offset, int len) {
        // Quitamos os espazos en branco para non mostrar textos baleiros
        String aux = new String(buf, offset, len).trim();
        if (aux.length() > 0) {
            System.out.println("Texto: " + aux);
        }
    }

    /*
        METODOS BÁSICOS PARA VALIDACIÓN
     */
    @Override
    public void warning(SAXParseException spe) throws SAXException {
        System.out.println("Aviso: " + spe.getMessage());
    }

    @Override
    public void error(SAXParseException spe) throws SAXException {
        String message = "Erro: " + spe.getMessage();
        throw new SAXException(message);
    }

    @Override
    public void fatalError(SAXParseException spe) throws SAXException {
        String message = "Erro grave: " + spe.getMessage();
        throw new SAXException(message);
    }
}
