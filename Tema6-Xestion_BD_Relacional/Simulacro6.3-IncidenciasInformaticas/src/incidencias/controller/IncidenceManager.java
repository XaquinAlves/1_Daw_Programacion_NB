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
package incidencias.controller;

import incidencias.model.Incidence;
import incidencias.model.User;
import incidencias.persistence.IncidenceDB;
import incidencias.persistence.UserDB;
import incidencias.view.IncidenceAdmin;
import incidencias.view.IncidenceDialog;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase IncidenceManager: clase principal, inicia la ejecución y controla la
 * lógica de la aplicación.
 *
 * @author Xaquin Alves González
 */
public class IncidenceManager {

    /**
     * Incia la ejecución de la aplicación.
     *
     * @param args
     */
    public static void main(String[] args) {
        IncidenceManager manager = new IncidenceManager();

        manager.showInitMenu();

    }

    /**
     * Muestra el menú de iniciar sesión
     */
    public void showInitMenu() {
        //Para leer datos
        Scanner scanner = new Scanner(System.in);
        //Para saber si el usuario quiere salir al final;
        char exit;
        //Mantiene en ejecucion el programa hasta que se escoja salir
        do {
            //Muestra el mensaje de bienvenida y pide el Login y la Contraseña
            System.out.println("Benvid@ a aplicacion de notificacion de incidencias");
            //Pide las crendenciales hasta que sean correctas
            //Para marcar que las credenciales son correctas
            boolean rightCredentials;
            //Usuario que iniciara sesion
            User user;
            //Vuelve a pedir los crendenciales hata que son correctos
            do {
                System.out.print("Nome de usuario: ");
                String login = scanner.nextLine();
                System.out.print("Contrasinal:");
                String passwd = scanner.nextLine();

                user = UserDB.findByName(login);
                if (user == null) {
                    //Si el Login no es correcto, vuelve a pedir credenciales
                    rightCredentials = false;
                    System.out.println("Usuario descoñecido");
                } else if (user.getPassword().equals(passwd)) {
                    //Si el login es correcto, y la pass tambien continua
                    rightCredentials = true;

                } else {
                    //Si la contraseña no es correcta, vuelve a pedir credenciales
                    rightCredentials = false;
                    System.out.println("Contrasinal incorrecta");
                }
                System.out.println("");
            } while (!rightCredentials);
            //Inicia sesion
            if (user.getType() == User.USER) {//Usuario normal
                showIncidencesMenu(user);
            } else {//Admin
                IncidenceAdmin incidenceAdmin = new IncidenceAdmin();
                incidenceAdmin.setVisible(true);
                
            }
            //Pregunta si quiere salir
            System.out.println("Quere pechar a aplicación?(s/n)");
            exit = scanner.nextLine().charAt(0);
        } while (exit == 'n' || exit == 'N');

    }

    /**
     * Muestra el menú de usuario.
     *
     * @param user usuario que inicia sesión.
     */
    private void showIncidencesMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        //Mantiene la ejecuciión hasta que se escoje salir
        do {
            //Muestra el mensaje de bienvenida.
            System.out.println("Benvid@, " + user.getName() + "\n"
                    + "As túas incidencias:");
            //Muestra las incidencias
            ArrayList<Incidence> incidences = IncidenceDB.findByUser(user.getUsername());
            for (Incidence incidence : incidences) {
                System.out.println(incidence);
            }
            System.out.println("");
            //Muestra el menu
            System.out.println("""
                           Escolle unha opción:
                                1. Crear unha incidencia
                                2. Pechar a sesión""");
            //Recojemos la opcion escogida
            choice = scanner.nextInt();
            scanner.nextLine();
            //Si escoje crear una incidencia, pedimos la descripcion y nombre del equipo
            if (choice == 1) {
                System.out.println("Introduza a descrición do problema:");
                String description = scanner.nextLine();
                System.out.print("Introduza o nome do equipo relacionado: ");
                String computer = scanner.nextLine();
                //Guardamos la incidencia
                IncidenceDB.save(new Incidence(-1, description, computer, "",
                        Incidence.STATUS_UNSOLVED, user));
            } else if (choice == 2) {
                System.out.println("Ata a proxima!");
            } else {
                System.out.println("Opción non válida");
            }
            System.out.println("");
        } while (choice != 2);
    }
}
