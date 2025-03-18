package conversorsegundos;


/**
 * Este programa fai a conversion de segundos a horas, minutos e segundos, amosando
 * o resultado por pantalla.
 * @author Xaquin Alves González
 */
public class ConversorSegundos {

    public static void main(String[] args) {
        //Declaramos as variables necesarias, unha para almacenar os segundos iniciais e tres para as horas minutos e segundos de resultado
       int initialSecs = 150000,secs,mins,hours;
       //Calcula os segundos coa operación módulo(resto division) sobre os segundos iniciais
       secs = initialSecs % 60;
       //Calcula intermedio de minutos
       mins = initialSecs / 60;
       //Calcula as horas dividindo os minutos do calculo intermedio
       hours = mins / 60;
       //Calcula os minutos finais coa operación modulo
       mins %= 60;
       //Mostra o resultado por pantalla
       System.out.println(initialSecs+" segundos son: "+hours+"horas, "+mins+" minutos, "+secs+" segundos");              
    }
    
}

