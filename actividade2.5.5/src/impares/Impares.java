package impares;

/**
 * Este programa mostra por pantalla os 10 primeiros impares usando un bucle
 * do while e unha sentencia if
 * @author Xaquin Alves Gonzalez
 */
public class Impares {

    public static void main(String[] args) {
        int number=0,i=0;
        
        do{
           if(number%2 != 0){
               System.out.println(number);
               i++;
           }
           number ++;
        }while(i < 10);
    }
    
}