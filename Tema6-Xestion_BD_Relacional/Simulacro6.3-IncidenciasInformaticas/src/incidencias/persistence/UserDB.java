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
package incidencias.persistence;

import incidencias.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Clase UserBD: maneja la persistencia de los objetos de la clase {@link User}
 *
 * @author Xaquin Alves González
 */
public class UserDB {

    private static Connection connection = null;

    /**
     * Usuarios guardados.
     */
    private static User[] users = new User[]{
        new User("antonio", "abc123.", "Antonio", "de Andres", User.ADMIN),
        new User("susana", "abc123.", "Susana", "Alvarez", User.ADMIN),
        new User("pedro", "abc123.", "Pedro", "Gomez", User.USER),
        new User("raquel", "abc123.", "Raquel", "Hazas", User.USER)
    };

    /**
     * Permite obtener un usuario por su Login.
     *
     * @param username el Logind del usuario a buscar.
     * @return el User si existe, si no null.
     */
    public static User findByName(String username) {
        //User que devolveremos
        User user = null;
        //Preparamos la consulta para obtener el User
        try (PreparedStatement pst = getConnection().
                prepareStatement("SELECT username, password, name, surname, "
                        + "type FROM User WHERE username = (?)")) {
            //Introducimos el username en el statement
            pst.setString(1, username);
            //Obtenemos el resultado de las consultas
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    user = new User(rs.getString("username"),
                            rs.getString("password"), rs.getString("name"),
                            rs.getString("surname"), rs.getInt("type"));
                }

                return user;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }

        return user;
    }

    /**
     * Devuelve unha conexion con la BD, creandola si no existe
     *
     * @return conexion con la BD
     * @throws SQLException si hay algun problema con la BD
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:sqlite:incidences.db");
        }
        return connection;
    }

    /**
     * Cierra la conexión con la BD.
     *
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

}
