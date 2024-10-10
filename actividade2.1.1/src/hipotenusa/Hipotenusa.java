package hipotenusa;

/**
 * Este programa mostra por pantalla a hipotenusa de dous catetos que se introduzan 
 * por teclado, manexando variables tipo double;
 * @author Xaquin Alves González
 */
public class Hipotenusa {

    public static void main(String[] args) {
        //Declaracion das variables para almacenar os catetos e o resultado 
        double cateto1= 4.5, cateto2 = 7.8, result;
        //Asigna a result o resultado do metodo hipotenusa cos dous catetos como atributos
        result = hipotenusa(cateto1,cateto2);
        //Mostra o resultado por pantalla 
        System.out.println("A hipotenusa dos catetos: "+cateto1+" , "+cateto2+" é "+result);        
    }

    /**@return a hipotenusa,que é raiz cadrada da suma dos catetos ao cadrado, en double */
    private static double hipotenusa(double cateto1,double cateto2){
        return Math.sqrt(Math.pow(cateto1,2)+Math.pow(cateto2,2));
    }
    
}

