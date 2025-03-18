package primosmenores;

import java.util.Scanner;

/**
 * Este programa mostra por pantalla os numeros primos menores que un numero
 * introducido por teclado
 * @author Xaquin Alves Gonzalez
 */
public class PrimosMenores {

    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        //Pide o numero
        System.out.println("Introduce un número enteiro: ");
        n = scan.nextInt();
        
        System.out.println("Os numeros primos menores que "+n+" son: ");
        //Aplica isPrime() aos numeros menores o introducido
        for(int i=1;i < n;i++){
            isPrime(i);
        }
        System.out.println("");


    }
    
    /**
     * Comproba se o número introducido como parámetro é primo, imprimindoo por
     * pantalla se o é
     * @param number numero a comprobar
     */
    private static void isPrime(int number){
        //Variable que servira de contador para carcular se é primo
        int i = 2;

        //Comproba se ten divisores a parte de el e a unidade
        while (number % i != 0 && i < number) {
            i++;
        }

        /**
         * Comproba se a salida do bucle while anterior foi por esgotar as 
         * posibilidades(primo)
         */
        if (i == number) {
            System.out.print(number+", ");
        }
    }

}
