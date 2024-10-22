package adivinas;

import java.util.Scanner;

/**
 * Este programa consiste nun xogo de adivinanzas. O programa xera un numero 
 * aleatorio e pidelle ao usuario que o adivine. O numero maximo que pode xerar
 * asi como o número de intentos son pedidos ao usuario para introducir por teclado
 * @author Xaquin Alves Gonzalez
 */
public class Adivinas {
    
    /**
     * Pide por teclado o maximo e os intentos ao usuario e executa o xogo con
     * estes parametros
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int max,tries;
        
        System.out.println("Bienvenido a: Adivina el Numero");
        
        System.out.print("Introduce el numero hasta el que puedo contar: ");
        max = scan.nextInt();
        scan.nextLine();
        
        System.out.print("Introduce el número de intentos que quieres tener: ");
        tries = scan.nextInt();
        scan.nextLine();
        
        game(tries, max);
        
    }
    /**
     * Obten un enteiro pseudo-aleatorio menor que o introducido como parametro
     * @param MAX numero máximo
     * @return enteiro aleatorio
     */
    public static int getRandom(int MAX) {
        return new java.util.Random().nextInt(MAX);
    }
    
    /**
     * Xera un numero aleatorio co metodo getRandom(int) e pidelle ao usuario 
     * que o adivine, introducindoo por teclado
     * @param tries numero de intentos
     * @param MAX numero aleatorio maximo
     */
    public static void game(int tries, int MAX) {

        Scanner scan = new Scanner(System.in);
        //Xera o numero a adiviñar
        int number = getRandom(MAX), guess, i = 0;
        
        System.out.println("Estoy pensando en un número menor que: "+MAX);
        
        //Executase mentres queden intentos e non se acerte o numero
        do {
            System.out.print("Introduce el numero en el que crees que pienso: ");
            guess = scan.nextInt();
            scan.nextLine();
            i++;
        } while (guess != number && i < tries);
        
        //Comproba se a salida do bucle foi por acerto ou por intentos gastados
        if(guess == number){
            System.out.println("Ganaste, el número era "+number);
        }
        else{
            System.out.println("Sin intentos, has perdido");
        }
    }
}
