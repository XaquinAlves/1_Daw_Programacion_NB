package ascensor;

import java.util.Scanner;

/**
 * Este programa implementa unha selección de accións para un ascensor
 * @author Xaquin Alves González
 */
public class Ascensor {

    public static void main(String[] args) {
        //Creamos a variable que usaremos para o switch
        char selection;
        //Creamos un scarnner para leer a instrucción
        Scanner scan = new Scanner(System.in);
        //Pedimos que se introduza unha instrucción e gardamola en selection
        System.out.println("Introduce una instrucción para el ascensor: abrir/bajar/parar/subir (a/b/p/s): ");
        selection = scan.nextLine().charAt(0);
        //Implementamos o switch que diferencia a instrucción gardada en selection
        switch(selection){
            case 'a':
                System.out.println("Abrir");
                break;
            case 'b':
                System.out.println("Bajar");
                break;
            case 'p':
                System.out.println("Parar");
                break;
            case 's':
                System.out.println("Subir");
                break;
            default:
                System.out.println("Error");
        }
    }
    
}