package primos;

import java.util.Scanner;

/**
 * Este programa mostra se un numero que se introduce por teclado e primo ou
 * non.O programa executase en bucle ata que se introduce un 0
 *
 * @author Xaquin Alves González
 */
public class Primos {

    public static void main(String[] args) {
        /**
         * Crease un scanner para leer o numero por teclado e unha variable int
         * para gardalo
         */
        Scanner scan = new Scanner(System.in);
        int number;

        /**
         * Implementase un bucle do while principal que mantendra o programa en
         * execución ata que se introduzca 0
         */
        do {
            //Pedimos un número e recollemolo por teclado, gardandoo en number
            System.out.println("Introduce un número enteiro(0 para salir): ");
            number = scan.nextInt();

            /**
             * Creamse unha variable int que servira de contador para carcular
             * se o numero é primo
             */
            int i = 2;

            /**
             * Creamse un bucle while que comproba se o número ten divisores a
             * parte del mesmo e a unidade
             */
            while (number % i != 0 && i < number) {
                i++;
            }
            
            /**
             * Con esta sentencia if else, comprobamos se a salida do bucle
             * while anterior foi por atopar un divisor(non primo) ou se chegou
             * por esgotar as posibilidades(primo)
             */
            if (i == number) {
                System.out.println("O número é primo");
            } else {
                System.out.println("O número non é primo");
            }
            
        } while (number != 0);
    }

}