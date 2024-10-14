package multiplicar;


/**
 * Esta clase multiplica dous numeros mediante un bucle for que realiza a
 * operación equivalente con sumas
 *
 * @author Xaquin Alves González
 */
public class Multiplicar {

    public static void main(String[] args) {
        int number1, number2, result = 0;
        number1 = 7;
        number2 = 8;

        for (int i = 0; i < number2; i++) {
            result += number1;
        }

        System.out.println(number1 + " * " + number2 + " = " + result);
    }

}
