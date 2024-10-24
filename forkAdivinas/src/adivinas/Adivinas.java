package adivinas;

import java.util.Scanner;

/**
 * Este programa consiste nun xogo de adivinanzas. O programa xera un numero
 * aleatorio e pidelle ao usuario que o adivine. O numero maximo que pode xerar
 * asi como o número de intentos son pedidos ao usuario para introducir por
 * teclado
 *
 * @author Xaquin Alves Gonzalez
 */
public class Adivinas {

    /**
     * Obten un enteiro pseudo-aleatorio menor que o introducido como parametro
     *
     * @param MAX numero máximo
     * @return enteiro aleatorio
     */
    public static int getRandom(int MAX) {
        return new java.util.Random().nextInt(MAX);
    }

    /**
     * Xera un numero aleatorio co metodo getRandom(int) e pidelle ao usuario
     * que o adivine, introducindoo por teclado
     *
     * @param tries numero de intentos
     * @param MAX numero aleatorio maximo
     */
    public static void game(int tries, int MAX) {

        Scanner scan = new Scanner(System.in);
        //Xera o numero a adiviñar
        int number = getRandom(MAX), guess, i = 0;

        System.out.println("Estoy pensando en un número,desde 0 y menor que: " + MAX);

        //Executase mentres queden intentos e non se acerte o numero
        do {

            System.out.print("Introduce el numero en el que crees que pienso: ");
            guess = scan.nextInt();
            scan.nextLine();
            while (guess >= MAX) {
                System.out.println("Ese número es mayor al permitido, introduce un numero menor que "+MAX+":");
                guess = scan.nextInt();
                scan.nextLine();
            }

            i++;

            if (guess != number) {
                System.out.println("Fallaste");
            }

        } while (guess != number && i < tries);

        //Comproba se a salida do bucle foi por acerto ou por intentos gastados
        if (guess == number) {
            System.out.println("Ganaste, el número era " + number);
        } else {
            System.out.println("Sin intentos, has perdido");
        }
    }
}
