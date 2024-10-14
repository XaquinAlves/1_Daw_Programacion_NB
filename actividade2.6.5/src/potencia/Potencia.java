package potencia;

/**
 * Este programa calcula o resultado de elevar number1 a number2 utilizando un
 * bucle for para facer as multiplicacións equivalentes
 *
 * @author Xaquin Alves González
 */
public class Potencia {

    public static void main(String[] args) {
        /**
         * Creanse duas variables int na que gardar os valores coas que se opera
         * e unha para o resultado IMPORTANTE: a variable result debe empezar a
         * execución con 1 como valor asignado para que o programa funcione
         */
        int number1, number2, result = 1;
        number1 = 7;
        number2 = 8;
        
        for (int i = 0; i < number2; i++) {
            result *= number1;
        }

        System.out.println(number1 + " ^ " + number2 + " = " + result);
    }

}