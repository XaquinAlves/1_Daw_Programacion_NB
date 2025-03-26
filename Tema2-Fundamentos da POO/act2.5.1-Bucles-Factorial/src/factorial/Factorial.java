package factorial;

/**
 * Este programa calcula o factorial dun numero cun bucle while
 * @author Xaquin Alves Gonzalez
 */
public class Factorial {

    public static void main(String[] args) {
        // 5! = 5 * 4 * 3 * 2 * 1
        /**
         * Creamos unha variable na que almacenar o numero do que calculamos e
         * outra para o resultado IMPORTANTE: por como calculamos, result debe
         * empezar tendo 1 como valor asignador
         */
        int number, result = 1;
        number = 5;

        System.out.println("O factorial de " + number);

        /**
         * Facemos un bucle while que multiplique result polo numero introducido
         * e que vaia restando 1 a number en cada iteración, que pare cando
         * number sexa 0 (debe parar antes de facer a operacion con 0 ou perderase
         * o valor)
         */
        while (number > 0) {
            result *= number;
            number--;
        }

        System.out.println("é " + result);

    }

}