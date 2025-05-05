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

/**
 * Clase Patient: esta clase representa a un paciente del hospital.
 *
 * @author Xaquin Alves González
 */
public class Patient {

    /**
     * El nombre del paciente.
     */
    private String name;
    /**
     * La presión arterial máxima del paciente.
     */
    private double maxPressure;
    /**
     * La presión arterial mínima del paciente.
     */
    private double minPressure;

    /**
     * Constructor para la clase Patient.
     *
     * @param name El nombre del paciente.
     * @param maxPressure La presión arterial máxima del paciente.
     * @param minPressure La presión arterial mínima del paciente.
     */
    public Patient(String name, double maxPressure, double minPressure) {
        this.name = name;
        this.maxPressure = maxPressure;
        this.minPressure = minPressure;
    }

    /**
     * El nombre del paciente.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * El nombre del paciente.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * La presión arterial máxima del paciente.
     *
     * @return the maxPressure
     */
    public double getMaxPressure() {
        return maxPressure;
    }

    /**
     * La presión arterial máxima del paciente.
     *
     * @param maxPressure the maxPressure to set
     */
    public void setMaxPressure(double maxPressure) {
        this.maxPressure = maxPressure;
    }

    /**
     * La presión arterial mínima del paciente.
     *
     * @return the minPressure
     */
    public double getMinPressure() {
        return minPressure;
    }

    /**
     * La presión arterial mínima del paciente.
     *
     * @param minPressure the minPressure to set
     */
    public void setMinPressure(double minPressure) {
        this.minPressure = minPressure;
    }

}
