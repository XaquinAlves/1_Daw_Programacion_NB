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
package hogwarts.sax;

import hogwarts.model.Student;
import hogwarts.model.Subject;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Xaquin Alves González
 */
public class SAXListener extends DefaultHandler {

    /**
     * As Materias{Subject} gardadas en XML
     */
    private ArrayList<Subject> subjects = new ArrayList<>();
    /**
     * Os Alumnos{Student} gardados en XML
     */
    private ArrayList<Student> students = new ArrayList<>();

    private String selectedElement = null;
    private String parentElement = null;

    /**
     * As Materias{Subject} gardadas en XML
     *
     * @return the subjects
     */
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Os Alumnos{Student} gardados en XML
     *
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public void startElement(String namespace, String sName, String qName, Attributes atrs) {
        /*        
        System.out.println(qName + ": ");
        if (atrs != null) {
            for (int i = 0; i < atrs.getLength(); i++) {
                System.out.println("-" + atrs.getQName(i) + ": " + atrs.getValue(i));
            }
        }
         */
        if (selectedElement != null) {
            parentElement = selectedElement;
            selectedElement = qName;
        } else {
            selectedElement = qName;
        }
        switch (selectedElement) {
            case "personaxes" ->
                System.out.println("");
            case "personaxe" -> {
                System.out.print("Personaxe: ");
            }
            case "hogwarts" -> {
                System.out.println("-Datos de Hogwarts:");
                if (atrs != null) {
                    for (int i = 0; i < atrs.getLength(); i++) {
                        System.out.println("\t-" + atrs.getQName(i) + ": " + atrs.getValue(i));
                    }
                }
            }
            case "codigo", "curso", "quidditch" -> {
                System.out.print("\t-" + qName + ": ");
            }
            case "caracteristicas" -> {
                System.out.print("-Características: ");
            }
            case "mascota" -> {
                System.out.println("-Mascota:");
                if (atrs != null) {
                    for (int i = 0; i < atrs.getLength(); i++) {
                        System.out.println("\t-" + atrs.getQName(i) + ": " + atrs.getValue(i));
                    }
                }
            }
            case "protagonista" -> {
                if (atrs != null) {
                    if (atrs.getValue(0).equals("true")) {
                        System.out.println("-É protagonista");
                    } else {
                        System.out.println("-Non é protagonista");
                    }
                }
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (parentElement != null) {
            selectedElement = parentElement;
        } else {
            selectedElement = null;
        }
    }

    @Override
    public void characters(char buf[], int offset, int len) {
        // Quitamos os espazos en branco para non mostrar textos baleiros
        String aux = new String(buf, offset, len).trim();
        if (aux.length() > 0) {
            if (selectedElement.equals("mascota:")) {
                System.out.println("\t-Nombre: " + aux);
            } else {
                System.out.println(aux);
            }
        }

    }

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
