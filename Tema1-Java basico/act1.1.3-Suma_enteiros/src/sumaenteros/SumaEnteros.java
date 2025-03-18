package sumaenteros;

/**
 *
 * @author Xaquin Alves González 
 * Este programa mostra o resultado da suma de dous enteiros. Temos que crear 
 * 2 variables tipo int para almacenar os dous numeros a sumar,
 * [neste caso, damoslle nos un valor desde o principio] e unha terceira 
 * na que almacenar o resultado, para despois mostralo por pantalla con
 * System.out.println(), concatenando a frase "O resultado da suma é " coa 
 * variable resultado
 */
public class SumaEnteros {

    public static void main(String[] args) {
        int number1 = 313;
        int number2 = 20;
        int result;

        result = number1 + number2;

        System.out.println("O resultado da suma é: " + result);
    }

}
/*
*Tamén se podería pedir por teclado os números, utilizando a clase Scanner

package sumaenteros;
import java.util.Scanner;
public class SumaEnteros {

    public static void main(String[] args) {
        int number1;
        int number2;
        int result;
        Scanner read = new Scanner (System.in);

        System.out.println("Introduzca un número entero:");
        number1 = read.nextInt();
        System.out.println("Introduzca otro número entero:")
        number2 = read.nextInt();
        
        result = number1 + number2;

        System.out.println("O resultado da suma " + number1 + " + " + number2 +" é: " + result);
        }    
    }
*/
