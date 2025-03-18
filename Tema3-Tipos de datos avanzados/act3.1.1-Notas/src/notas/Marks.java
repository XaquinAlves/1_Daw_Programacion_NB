package notas;

import java.util.Scanner;

/**
 * Esta clase representa un conjunto de notas, que se almacenan como enteros, y
 * cuenta con un metodo que calcula la media en double
 *
 * @author Xaquin Alves Gonzalez
 */
public class Marks {
    //Garda notas de varios alumnos
    private int[] marks;

    /**
     * Creamos una instancia de Marks e invocamos sus metodos para testear su
     * funcionalidad
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Marks studentsMarks = new Marks();

        studentsMarks.setMarksKeyB();

        System.out.println("La nota media es: " + studentsMarks.getAverage());
    }

    /**
     * Constructo por defecto, crea un obxeto Marks con capacidade para 10 notas
     */
    public Marks() {
        marks = new int[10];
    }

    /**
     * Cronstructor alternativo, crea un obxeto Marks indicando a capacidade de
     * notas como parametro
     *
     * @param length numero de notas que se podran almacenar
     */
    public Marks(int length) {
        marks = new int[length];
    }

    /**
     * Recolle por teclado as notas que se queiran gardar
     */
    private void setMarksKeyB() {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < marks.length; i++) {
            System.out.print("Introduce la nota nº " + i + ": ");
            marks[i] = scan.nextInt();
            scan.nextLine();
        }
    }
    /**
     * 
     * @return a media das notas gardadas 
     */
    public double getAverage() {
        double avrg = 0;

        for (int i = 0; i < marks.length; i++) {
            avrg += marks[i];
        }

        avrg /= marks.length;

        return avrg;
    }
}
