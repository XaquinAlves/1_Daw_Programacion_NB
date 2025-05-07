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
package model;

import java.io.Serializable;

/**
 * Esta e a clase Client, que representa a un cliente gardando NIF, nome e
 * apelido
 *
 * @author Xaquin Alves Gonzalez
 */
public class Client implements Serializable {

    private String nif;
    private String name;
    private String surname;

    /**
     * Crea unha nova instancia de Client
     *
     * @param nif NIF do cliente
     * @param name nome do cliente
     * @param surname apelido do cliente
     */
    public Client(String nif, String name, String surname) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
    }

    /**
     * @return NIF do cliente
     */
    public String getNif() {
        return nif;
    }

    /**
     * @param nif NIF do cliente a establecer
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * @return nome do cliente
     */
    public String getName() {
        return name;
    }

    /**
     * @param name nome do cliente a establecer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return apelido do cliente
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname apelido do cliente a establecer
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
