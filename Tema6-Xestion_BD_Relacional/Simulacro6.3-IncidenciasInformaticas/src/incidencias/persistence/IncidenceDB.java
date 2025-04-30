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

import incidencias.model.Incidence;
import incidencias.model.User;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase IncidenceDB: maneja la persistencia de los objetos de la clase
 * {@link Incidence}
 *
 * @author Xaquin Alves González
 */
public class IncidenceDB {

    /**
     * Incidencias guardadas.
     */
    private static ArrayList<Incidence> incidences = new ArrayList<>();

    /**
     * Obtiene las incidencias mandadas por un usuario.
     *
     * @param username el Login del usuario.
     * @return lista de incidencias.
     */
    public static ArrayList<Incidence> findByUser(String username) {
        ArrayList<Incidence> userIncidences = new ArrayList<>();

        for (Incidence incidence : incidences) {
            if (incidence.getSender().getUsername().equals(username)) {
                userIncidences.add(incidence);
            }
        }

        String statement = "SELECT id, description, computer, resolution, status, sender "
                + "FROM Incidence WHERE sender = (?)";

        try (PreparedStatement pst = UserDB.getConnection().prepareStatement(statement)) {
            pst.setString(1, username);

            try (ResultSet rs = pst.executeQuery()) {
                userIncidences.add(new Incidence(rs.getInt("id"),
                        rs.getString("description"), rs.getString("computer"), 
                        rs.getString("resolution"), rs.getInt("status"),
                        new User(rs.getString("sender"), null, null,null,0)));
            }

        } catch (SQLException ex) {

        }

        return userIncidences;
    }

    /**
     * Guarda una incidencia.
     *
     * @param incidence incidencia a guardar.
     */
    public static void save(Incidence incidence) {
        incidence.setId(incidences.size());
        incidences.add(incidence);
    }

    /**
     * Obtiene todas las incidencias que estan en el estado indicado.
     *
     * @param status el estado, definido en constatntes en la clase
     * {@link Incidence}.
     * @return lista de incidencias.
     */
    public static ArrayList<Incidence> findByStatus(int status) {
        ArrayList<Incidence> statusIncidences = new ArrayList<>();

        for (Incidence incidence : incidences) {
            if (incidence.getStatus() == status) {
                statusIncidences.add(incidence);
            }
        }

        return statusIncidences;
    }

    /**
     * Actualiza la información de una incidencia. Por implementar.
     *
     * @param incidence la incidencia a actualizar.
     */
    public static void update(Incidence incidence) {

    }
}
