package alertas;

/**
 * Este programa mostra por pantalla o nivel de alerta dependendo da humidade e
 * temperatura
 *
 * @author Xaquin Alves Gonzalez
 */
public class Alertas {

    public static void main(String[] args) {
        //Declaramos as constantes e damoslle un valor
        final double TEMPERATURE = 30;
        final double HUMIDITY = 48;
        
        //Usamos unha sentencia if else para comprobar se as constantes superan os valores establecidos
        //Primeiro, se ambas superan o valor
        if (TEMPERATURE > 24 && HUMIDITY > 50) {
            System.out.println("Alerta vermella");    
        }//Despois, se unha soa supera o valor
        else if (TEMPERATURE > 24 || HUMIDITY > 50) {
            System.out.println("Alerta amarela");
        }//Se non supera ningun dos valores 
        else {
            System.out.println("Alerta verde");
        }
    }
}


