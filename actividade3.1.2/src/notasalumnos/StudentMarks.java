package notasalumnos;

import java.util.Scanner;

/**
 * Esta clase representa un listaxe de alumnos con unha nota asociada a cada un,
 * e dous metodos que devolven o alumnos con maior e o alumno con menor nota
 *
 * @author Xaquin Alves Gonzalez
 */
public class StudentMarks {

    //Garda os nomes dos alumnos
    private String[] students;
    //Garda a nota do alumno que esta na mesma posicion
    private int[] marks;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StudentMarks studentMarks = new StudentMarks();

        studentMarks.SetDataKeyB();

        System.out.println("La peor nota es de " + studentMarks.min());
        System.out.println("La mejor nota es de " + studentMarks.max());
    }

    /**
     * Constructor por defecto, crea unha instancia que almacena 10 alumnos
     */
    public StudentMarks() {
        students = new String[10];
        marks = new int[10];
    }

    /**
     * Constructor alternativo, crea unha instancia que almacena o numero de
     * alumnos dado
     *
     * @param length numero de alumnos que se almacenará
     */
    public StudentMarks(int length) {
        students = new String[length];
        marks = new int[length];
    }

    /**
     * Recolle por teclado os alumnos coas suas notas correspondentes
     */
    private void SetDataKeyB() {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < students.length; i++) {

            System.out.print("Introduce el alumno nº " + i + ":  ");
            students[i] = scan.nextLine();

            System.out.print("Introduce la nota del alumno " +students[i]  + ": ");
            marks[i] = scan.nextInt();
            scan.nextLine();

        }
    }
    /**
     * 
     * @return nombre del alumno con peor nota
     */
    public String min() {
        int minor = 0;

        for (int i = 1; i < students.length; i++) {
            if (marks[i] < marks[minor]) {
                minor = i;
            }
        }

        return students[minor];
    }
/**
 * 
 * @return nombre del alumno con mejor nota
 */
    public String max() {
        int greater = 0;

        for (int i = 1; i < students.length; i++) {
            if (marks[i] > marks[greater]) {
                greater = i;
            }
        }

        return students[greater];
    }
}
