package multiplos5;

/**
 * Este programa calcula a suma dos multiplos de 5 que hay entre dous números,
 * intercambiando as variables se o primeiro número e maior ca o segundo
 *
 * @author Xaquin Alves González
 */
public class Multiplos5 {

    public static void main(String[] args) {
        //Crea dous int para gardar os numeros e un para o resultado
        int number1, number2, result = 0;
        number1 = 33;
        number2 = 7;
        //Comproba se o primeiro numero e menor
        if (number1 > number2) {
            //Crea un int para facer o intercambio de variables
            int tempNumber = number1;
            number1 = number2;
            number2 = tempNumber;
        }
        //Recorre os numeros que están entre os introducidos
        for (int i = number1; i <= number2; i++) {
            //Comproba se o numero e multiplo de 5
            if (i % 5 == 0) {
                result += i;
            }
        }
        System.out.println("A suma é: " + result);

    }

}
