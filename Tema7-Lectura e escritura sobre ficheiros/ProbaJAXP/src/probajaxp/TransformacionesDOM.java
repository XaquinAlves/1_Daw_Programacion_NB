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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Clase de proba, para ver como se crea un XML con DOM.
 *
 * @author Xaquin Alves González
 */
public class TransformacionesDOM {

    public static void main(String[] args) {
        try {
            // Creamos unha factoría para crear o documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // Xeramos o elemento raíz
            Element rootElement = doc.createElement("clientes");
            doc.appendChild(rootElement);

            // Engadimos un elemento
            Element client = doc.createElement("cliente");
            client.setAttribute("tipo", "basico");
            client.setTextContent("Roberto López García");
            rootElement.appendChild(client);

            // Xeramos a fonte DOM a partir do documento
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);

            // Establecemos esta propiedade para identar o XML xerado
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            //Creamos o archivo sobre o que escribiremos
            File file = new File("src/resources/clientes.xml");

            // Xeramos un fluxo de saída sobre un ficheiro
            StreamResult result = new StreamResult(file);

            // Transformamos a fonte DOM sobre o fluxo
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
