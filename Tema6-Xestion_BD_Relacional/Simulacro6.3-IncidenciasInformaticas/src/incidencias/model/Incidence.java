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
 * Clase Incidence: representa una incidencia producida en el sistema.
 *
 * @author Xaquin Alves González
 */
public class Incidence {

    /**
     * Identificador de la incidencia.
     */
    private int id;
    /**
     * Descripcion del problema.
     */
    private String description;
    /**
     * Nombre del equipo relacionado con la incidencia.
     */
    private String computer;
    /**
     * Descripción de la resolución del problema.
     */
    private String resolution;
    /**
     * Estado de la incidencia.
     */
    private int status;
    /**
     * Estado de incidencia no resuelta.
     */
    public static final int STATUS_UNSOLVED = 0;
    /**
     * Estado de incidencia pendiente de resolución.
     */
    public static final int STATUS_PENDING = 1;
    /**
     * Estado de incidencia resuelta
     */
    public static final int STATUS_SOLVED = 2;
    /**
     * Usuario que generó la incidencia.
     */
    private User sender;

    /**
     * Constructor de la clase Incidence.
     *
     * @param id Identificador de la incidencia.
     * @param description Descripcion del problema.
     * @param computer Nombre del equipo relacionado con la incidencia.
     * @param resolution Descripción de la resolución del problema.
     * @param status Estado de la incidencia.
     * @param sender Usuario que generó la incidencia.
     */
    public Incidence(int id, String description, String computer, String resolution, int status, User sender) {
        this.id = id;
        this.description = description;
        this.computer = computer;
        this.resolution = resolution;
        this.status = status;
        this.sender = sender;
    }

    /**
     * Obtiene la Descripción de la resolución del problema.
     *
     * @return la Descripción de la resolución del problema.
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Establece la Descripción de la resolución del problema.
     *
     * @param resolution la Descripción de la resolución del problema a
     * establecer.
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * Obtiene el Estado de la incidencia.
     *
     * @return el Estado de la incidencia.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Establece el estado de la incidencia.
     *
     * @param status el Estado de la incidencia a establecer.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Obtiene el Identificador de la incidencia.
     *
     * @return el Identificador de la incidencia.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el Identificador de la incidencia.
     *
     * @param id el Identificador de la incidencia a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la Descripcion del problema.
     *
     * @return la Descripcion del problema.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la Descripcion del problema.
     *
     * @param description la Descripcion del problema a establecer.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene el Nombre del equipo relacionado con la incidencia.
     *
     * @return el Nombre del equipo relacionado con la incidencia.
     */
    public String getComputer() {
        return computer;
    }

    /**
     * Establece el Nombre del equipo relacionado con la incidencia.
     *
     * @param computer el Nombre del equipo relacionado con la incidencia a
     * establecer.
     */
    public void setComputer(String computer) {
        this.computer = computer;
    }

    /**
     * Obtiene el Usuario que generó la incidencia.
     *
     * @return el Usuario que generó la incidencia.
     */
    public User getSender() {
        return sender;
    }

    /**
     * Establece el Usuario que generó la incidencia.
     *
     * @param sender el Usuario que generó la incidencia a establecer.
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        String incidence = id + " (";

        switch (status) {
            case STATUS_UNSOLVED ->
                incidence += "sen resolver";
            case STATUS_PENDING ->
                incidence += "pendiente";
            case STATUS_SOLVED ->
                incidence += "solucionada";
        }

        incidence += "): " + description;

        return incidence;
    }
}
