package matriz5x5;

/**
 * Este programa mostra por pantalla unha matriz de 5x5 que comenza en 10 e vai
 * decrementando 1 en fila e columna
 * @author Xaquin Alves Gonzalez
 */
public class Matriz5x5 {

    public static void main(String[] args) {

        
        //Recorre as columnas 
        for(int i=10;i > 5;i--){
            //Variable na que gardaremos o valor a mostrar
            int x = i;
            //Recorre as filas
            for(int j=0; j < 5; j++){                
                
                System.out.print(" "+x+" ");
                x--;
            }
            System.out.println("");
        }
        
        /**
         * SUXERENCIA DE SOLUCION
         * for (int i=10; i>=6; i--) {
         *      for (int j=0; j<5; j++) {
         *          System.out.print(i-j+" ");} 
         *      System.out.println();}
         */
    }
    
}
