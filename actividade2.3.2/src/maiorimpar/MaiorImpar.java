package maiorimpar;

/**
 * Este programa analiza se un enteiro cumple a condicion de ser maior que 100
 * ou impar e mostrao por pantalla
 *
 * @author Xaquin Alves Gonzalez
 */
public class MaiorImpar {

    public static void main(String[] args) {
        //Creamos a variable e damoslle un valor
        int x = 77;
        //Comprobamos se se cumple a condicion cuan sentencia if, e amosamos por pantalla o resultado
        if(x>100 || (x%2!=0)){
            System.out.println("O número "+x+" cumple a condición");
        }
        else{
            System.out.println("O número "+x+" non cumple a condición");
        }
    }

}