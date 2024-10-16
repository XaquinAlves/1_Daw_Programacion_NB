package multiplos5;

/**
 * Este programa calcula a suma dos multiplos de 5 que hay entre dous números
 * @author Xaquin Alves González
 */
public class Multiplos5 {

    public static void main(String[] args) {
        //Creanse duas variables int para gardar os numeros e unha para o resultado
        int number1, number2,result = 0;
        number1 = 7;
        number2 = 33;
        //Crease un bucle for que recorra os numeros que están entre os introducidos
        for(int i = number1; i <= number2;i++ ){
            //Crease unha sentecia if que comprobe se o numero e multiplo de 5
            if(i % 5 == 0){
                result += i;
            }
        }
        
        System.out.println("A suma é: "+result);
                    
    }
    
}
