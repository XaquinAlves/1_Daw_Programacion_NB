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
package incidencias.model;

/**
 * Clase User: representa un usuario de la aplicación.
 *
 * @author Xaquin Alves González
 */
public class User {

    /**
     * Login del usuario.
     */
    private String username;
    /**
     * Contraseña del usuario.
     */
    private String password;
    /**
     * Nombre real del usuario.
     */
    private String name;
    /**
     * Apellidos del usuario.
     */
    private String surname;
    /**
     * Tipo de usuario, definido en las constantes.
     */
    private int type;
    /**
     * Tipo de usuario estandar.
     */
    public static final int USER = 0;
    /**
     * Tipo de usuario administrador.
     */
    public static final int ADMIN = 1;

    /**
     * Constructor for User.
     *
     * @param username el Login del usuario.
     * @param password la Contraseña del usuario.
     * @param name el  Nombre real del usuario.
     * @param surname los Apellidos del usuario.
     * @param type Tipo de usuario, definido en las constantes(USER,ADMIN).
     */
    public User(String username, String password, String name, String surname, int type) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.type = type;
    }

    /**
     * Obtiene el Login del usuario.
     *
     * @return el Login del usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el Login del usuario.
     *
     * @param username el Login del usuario a establecer.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la Contraseña del usuario.
     *
     * @return la Contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la Contraseña del usuario.
     *
     * @param password la Contraseña del usuario a establecer.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el Nombre real del usuario.
     *
     * @return el Nombre real del usuario.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el Nombre real del usuario.
     *
     * @param name el Nombre real del usuario a establecer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene los Apellidos del usuario.
     *
     * @return los Apellidos del usuario.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Establece el Apellidos del usuario.
     *
     * @param surname  el Apellidos del usuario a establecer.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Obtiene el Tipo de usuario, definido en las constantes.
     *
     * @return el Tipo de usuario, definido en las constantes.
     */
    public int getType() {
        return type;
    }

    /**
     * Establece Tipo de usuario, definido en las constantes.
     *
     * @param type el Tipo de usuario a establecer, definido en las constantes.
     */
    public void setType(int type) {
        this.type = type;
    }

}
