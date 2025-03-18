package estadisticas;

import java.util.Scanner;

/**
 * Esta e a clase Statistics, que conten unha lista de numeros cuanha cantidade
 * impar e un metodo que amosa a mediana de dita lista
 *
 * @author Xaquin Alves Gonzalez
 */
public class Statistics {

    private int[] numberList;

    /**
     * Creamos unha instancia de Statistics para testeala
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Statistics stats = new Statistics();

        System.out.println("La mediana es : " + stats.median());
    }

    /**
     * Constructor que pide por teclado a cantidade de números e os números en
     * si
     */
    public Statistics() {
        Scanner scan = new Scanner(System.in);
        int length;

        System.out.println("Indique el número de elementos que introducirá(debe ser impar):  ");
        length = scan.nextInt();
        scan.nextLine();

        while (length % 2 == 0) {
            System.out.println("El número de elementos debe ser impar. Vuelva a introducirlo: ");
            length = scan.nextInt();
            scan.nextLine();
        }

        numberList = new int[length];

        for (int i = 0; i < length; i++) {
            System.out.print("Introduce el número nº " + i + ": ");
            numberList[i] = scan.nextInt();
            scan.nextLine();
        }
    }

    /**
     *
     * @return a mediana dos números gardados
     */
    public int median() {

        int[] minors = new int[(numberList.length - 1) / 2];
        int[] greaters = new int[(numberList.length - 1) / 2];
        int result = numberList[(numberList.length - 1) / 2];
        //Gardamos a metade dos numeros nun array
        for (int i = 0; i < (numberList.length - 1) / 2; i++) {
            minors[i] = numberList[i];
        }
        //Gardamos a outra metade dos numeros(deixando 1 fora de ambos arrays en result
        for (int i = ((numberList.length - 1) / 2) + 1, j = 0; i < numberList.length; i++, j++) {
            greaters[j] = numberList[i];
        }
        //Pomos no array minors os menores e no greaters os maiores
        for (int i = 0; i < minors.length; i++) {
            if (minors[i] > greaters[i]) {
                int temp = minors[i];
                minors[i] = greaters[i];
                greaters[i] = temp;
            }
        }
        //Comparamos o numero deixado fora cos dous arrays pa obter a mediana
        for (int i = 0; i < minors.length; i++) {
            if (minors[i] > result) {
                int temp = minors[i];
                minors[i] = result;
                result = temp;
            } else if (greaters[i] < result) {
                int temp = greaters[i];
                greaters[i] = result;
                result = temp;
            }
        }

        return result;
    }
}
