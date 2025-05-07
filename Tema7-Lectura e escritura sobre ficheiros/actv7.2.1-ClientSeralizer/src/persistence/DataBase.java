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
package persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Client;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Esta e a clase DataBase, que representa unha base de datos de clientes,
 * implementado cun ArrayList da clase Client
 *
 * @author Xaquin Alves Gonzalez
 */
public class DataBase {

    private ArrayList<Client> clients;

    /**
     * Crea unha nova instancia de DataBase
     */
    public DataBase() {
        this.clients = new ArrayList<>();
    }

    /**
     * @return ArrayList de clientes (Client)
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * @param clients ArrayList de clientes (Client)
     */
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void loadClients() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clients"))) {
            clients = (ArrayList<Client>) in.readObject();
        }
    }
    
    public void saveClients() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clients"))) {
            out.writeObject(clients);
        }
    }

    /**
     * Pide por teclado os datos dun cliente e agregao a base de datos
     */
    public void addClient() {
        Scanner scanner = new Scanner(System.in);
        String nif, name, surname;

        System.out.print("Introduce o nif do cliente a rexistrar: ");
        nif = scanner.nextLine();

        System.out.print("Introduce o nome do cliente a rexistrar: ");
        name = scanner.nextLine();

        System.out.print("Introduce o apelido do cliente a rexistrar: ");
        surname = scanner.nextLine();

        System.out.println();

        Client client = new Client(nif, name, surname);
        clients.add(client);
    }

    /**
     * Mostra por pantalla os nif dos clientes gardados
     */
    public void showClients() {
        System.out.println("LISTA DE CLIENTES");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println("Cliente " + i + " NIF: " + clients.get(i).getNif());
        }
        System.out.println();
    }

    /**
     * Elimina o cliente que ten o nif que se introduce como parametro, no caso
     * de que exista
     *
     * @param nif do cliente a eliminar
     */
    public void removeClient(String nif) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getNif().equals(nif)) {
                clients.remove(i);
            }
        }
    }

    /**
     *
     * @return numero de clientes rexistrados na base de datos
     */
    public int numClients() {
        return clients.size();
    }

    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        
        try {
            dataBase.loadClients();

            String nifEliminate;
            Scanner scanner = new Scanner(System.in);

            dataBase.addClient();
            dataBase.addClient();
            dataBase.addClient();

            dataBase.showClients();
            System.out.println("A base de datos ten " + dataBase.numClients() + " clientes.");

            System.out.print("Introduce el nif de un cliente a eliminar: ");
            nifEliminate = scanner.nextLine();
            dataBase.removeClient(nifEliminate);

            dataBase.showClients();
            System.out.println("A base de datos ten " + dataBase.numClients() + " clientes.");

            dataBase.saveClients();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Erro: " + ex.getMessage());
        }
    }
}
