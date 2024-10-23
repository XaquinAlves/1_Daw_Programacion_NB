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
        //Crea unha variable para gardar o número a evaluar
        Scanner scan = new Scanner(System.in);
        int number;

        /**
         * Bucle principal que mantendra o programa en execución ata que se
         * introduzca 0
         */
        do {
            //Pedimos un número por teclado, gardandoo en number
            System.out.println("Introduce un número enteiro(0 para salir): ");
            number = scan.nextInt();

            //Contador 
            int i = 2;

            //Comproba se ten divisores a parte de el e a unidade
            while (number % i != 0 && i < number) {
                i++;
            }

            /**
             * Comprobamos se a salida do bucle while anterior foi por un
             * 0(salida do programa), por atopar un divisor(non primo) ou se
             * chegou por esgotar as posibilidades(primo)
             */
            if (number == 0) {
                System.out.println("Ata a proxima");
            } else if (i == number) {
                System.out.println("O número é primo");
            } else {
                System.out.println("O número non é primo");
            }

        } while (number != 0);
    }

}
