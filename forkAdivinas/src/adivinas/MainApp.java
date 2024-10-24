package adivinas;

import java.util.Scanner;

/**
 * Juego adivina el número
 * 
 * @author Xaquin Alves Gonzalez
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        menu();

    }

    /**
     * Recoje los datos necesarios para empezar una partida por teclado y la
     * empieza
     */
    public static void partida() {
        //Variables de funcionamiento de la partida
        Scanner scan = new Scanner(System.in);
        int max, tries;
        
        System.out.print("Introduce el numero hasta el que puedo contar: ");
        max = scan.nextInt();
        scan.nextLine();

        System.out.print("Introduce el número de intentos que quieres tener: ");
        tries = scan.nextInt();
        scan.nextLine();
        //Ejecuta una partida con los parametros
        Adivinas.game(tries, max);

    }

    /**
     * Menu que mantiene el programa en ejecucion hasta que se escoja salir
     */
    public static void menu() {
        //Variables de funcionamiento del menu
        Scanner scan = new Scanner(System.in);
        char selection;

        System.out.println("Bienvenido a: Adivina el Numero");
        //Bucle de ejecucion del programa
        do {
            //Selección
            System.out.println("Desea empezar una nueva partida?(s/n)");
            selection = scan.nextLine().charAt(0);
            //Empieza partida
            if (selection == 's' || selection == 'S') {
                partida();
            }

        } while (selection == 's' || selection == 'S');

        System.out.println("Hasta la vista");
    }
}
