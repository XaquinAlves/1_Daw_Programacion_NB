package olasoneu;


/**
 *
 * @author Xaquin Alves González Este programa mostra o mensaxe "Ola, son Xaquín
 * Alves González" na consola usando o método System.out.println()
 */
public class OlaSonEu {

    public static void main(String[] args) {
        
        System.out.println("Ola, son Xaquín Alves González");  
    }
}
/**
 * Podemos facer unha version mais complexa donde primeiro se pida por teclado o
 * nome que se quere mostrar.
 * Para iso, precisamos importar a clase Scanner, que nos permite crear un obxeto
 * que se encargue de recoller os datos introducidos por teclado, usando o método
 * nextLine()
 * [xa que se introduce nome e apelidos con espacios, o metodo next()
 * non o recolle ben xa que para de leer se hay un espacio]
 * Tamén temos que usar unha variable tipo String para gardar o nome introducido
 * E usamos o metodo System.out.println() para mostrar a mensaxe.
 * Asi quedaría o codigo:
 *
package olasoneu;
import java.util.Scanner;
public class OlaSonEu {

    public static void main(String[] args) {
        String name;
        Scanner read = new Scanner (System.in);
        
        System.out.println("Introduzca su nombre:");
        name = read.nextLine();
        
        System.out.println("Ola, son "+name);
        }    
    }
 */