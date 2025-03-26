package alertas;

/**
 * Este programa mostra por pantalla o nivel de alerta dependendo da humidade e
 * temperatura
 *
 * @author Xaquin Alves Gonzalez
 */
public class Alertas {
    //Declaramos as constantes e damoslle un valor    
    public final static double ALERT_TEMPERATURE = 24;
    public final static double ALERT_HUMIDITY = 50;
    
    public static void main(String[] args) {
        //Variables para gardar temperatura e humidade
        double temperature = 30;
        double humidity = 48;

        
        //Usamos unha sentencia if else para comprobar se as constantes superan os valores establecidos
        //Primeiro, se ambas superan o valor
        if (temperature > ALERT_TEMPERATURE && humidity > ALERT_HUMIDITY) {
            System.out.println("Alerta vermella");    
        }//Despois, se unha soa supera o valor
        else if (temperature > ALERT_TEMPERATURE || humidity > ALERT_HUMIDITY) {
            System.out.println("Alerta amarela");
        }//Se non supera ningun dos valores 
        else {
            System.out.println("Alerta verde");
        }
    }
}


