package expresionloxica1;

/**
 * Este programa analiza a expresión lóxica 3+5<5*2|3>8&7>6-2 e mostra o resultado
 * por pantalla
 * @author Xaquín Alves González
 */
public class ExpresionLoxica1 {

    public static void main(String[] args) {
        boolean result;
        
        result = 3+5<5*2|3>8&7>6-2;
        
        System.out.println("3+5<5*2|3>8&7>6-2 is "+result);
        
        /*
        O resultado é verdadeiro, comprobamolo seguindo o seguinte análise:
        3+5 = 8; 5*2 = 10; 8 < 10 é verdadeiro, polo que o enunciado xa seria 
        verdadeiro; inda que ó utilizar o operador | (or sen cortocircuito) o
        programa segue analizando:
        3>8 é falso, o ter o operador &(and sen cortocircuito) o programa segue 
        analizando,7>4 é verdadeiro, pero 3>8&7>6-2 é falso
        */
    }
    
}
