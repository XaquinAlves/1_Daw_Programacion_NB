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
package peliculas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;

/**
 * Esta clase conectase coa BD bd_peliculas mediante JDCB, permitindo insertar,
 * borrar ou consultar as peliculas gardadas, usando SQLite
 *
 * @author Xaquin Alves González
 */
public class PeliculasBD {

    private static int numOfFilms = 0;

    public static void main(String[] args) {

        try (Connection c = DriverManager.getConnection("jdbc:sqlite:peliculas.db")) {
            System.out.println("Conexión realizada con exito");
            try (Statement st = c.createStatement()){
                String sql = "CREATE TABLE IF NOT EXISTS films (id INTEGER " 
                        + " PRIMARY KEY AUTOINCREMENT,title TEXT NOT NULL,year"
                        + "INTEGER NOT NULL);";
                
                st.executeUpdate(sql);
            } catch (SQLException e){
                System.out.println("Error creando tabla");
            }


            showMenu(c);
        } catch (SQLException ex) {
            System.out.println("A conexión co servidor de bases de datos non se puido establecer");
        }

    }

    /**
     * Mostra un menu con opcións para traballar sobre a BD de peliculas.
     *
     * @param c Conexion coa BD.
     */
    private static void showMenu(Connection c) {
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Benvido ao xestor de Películas");
            System.out.println("""
                           Escolla que desexa facer:
                           1.Insertar unha nova pelicula
                           2.Mostrar todas as películas
                           3.Buscar unha película
                           4.Pechar a aplicación""");

            System.out.print("Elección: ");
            choice = scan.nextInt();
            scan.nextLine();
            System.out.println();
            switch (choice) {
                case 1 -> {//Pide os datos da pelicula a insertar 
                    System.out.println("Introduza os datos da pelicaula a insertar: ");
                    System.out.print("Titulo: ");
                    String title = scan.nextLine();
                    System.out.print("Ano estreno:");
                    int year = scan.nextInt();
                    scan.nextLine();
                    //Chama ao metodo para insertar unha nova pelicula
                    insertFilm(c, title, year);
                }
                case 2 ->
                    showFilms(c);
                case 3 -> {//Pide o ID da pelicula a buscar
                    System.out.println("Introduzca o ID numerico da película a buscar");
                    int filmID = scan.nextInt();
                    scan.nextLine();
                    //Chama o metodo para buscar a pelicula
                    searchFilm(c, filmID);
                }
                case 4 ->
                    System.out.println("Ata a próxima!");
                default ->
                    System.out.println("Opción non válida");
            }
            System.out.println();
        } while (choice != 4);
    }

    /**
     * Inserta unha pelicula nova na BD.
     *
     * @param c Conexión coa BD .
     * @param title Titulo da pelicula.
     * @param year Ano de estreno da pelicula.
     */
    private static void insertFilm(Connection c, String title, int year) {

        try (PreparedStatement st = c.prepareStatement("INSERT INTO films VALUES(?,?,?)")) {
            st.setInt(1, numOfFilms + 1);
            st.setString(2, title);
            st.setInt(3, year);
            st.executeUpdate();
            numOfFilms++;
        } catch (SQLException e) {
            System.out.println("Error coa BD");
        }

    }

    /**
     * Amosa todas as películas gardadas na BD
     *
     * @param c Conexión coa BD
     */
    private static void showFilms(Connection c) {
        //Creamos o statement para a consulta que devolve as peliculas
        try (Statement st = c.createStatement();) {
            String sql = "SELECT * FROM films";
            //Creamos o result set para procesar os datos
            try (ResultSet rst = st.executeQuery(sql)) {
                //Mentres queden peliculas sen amosar, amosa a seguinte
                while (rst.next()) {
                    System.out.println("IDPelicula: " + rst.getInt("id")
                            + " Titulo: " + rst.getString("title") + " Ano estreno: "
                            + rst.getInt("year"));

                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro coa BD");
        }

    }

    /**
     * Busca unha pelicula polo ID pasado. En caso de atopala amosa os datos por
     * pantalla, e se non avisa de que non se atopou
     *
     * @param c Conexion coa BD.
     * @param filmID ID da pelicula (enteiro).
     */
    private static void searchFilm(Connection c, int filmID) {
        //Creamos un statement para a colsuta    
        try (Statement st = c.createStatement()) {
            String sql = "SELECT * FROM films WHERE id = " + filmID;
            //Creamos o result set para procesar os resultados
            try (ResultSet rst = st.executeQuery(sql)) {
                if (rst.next()) {
                    System.out.println("Pelicula atopada: ");
                    System.out.println("IDPelicula: " + rst.getInt("id")
                            + " Titulo: " + rst.getString("title")
                            + " Ano estreno: " + rst.getInt("year"));
                } else {
                    System.out.println("Pelicula non atopada");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro coa BD");
        }
    }

}
