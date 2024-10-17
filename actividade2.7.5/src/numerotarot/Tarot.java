package numerotarot;

/**
 * Esta é a clase Tarot, que traballa con tres variables int representando unha
 * data de nacemento (dia/mes/ano) e conta con 3 métodos
 *
 * @author Xaquin Alves Gonzalez
 */
public class Tarot {

    private int day;
    private int month;
    private int year;

    public static void main(String[] args) {

        Tarot miTarot = new Tarot(10,9,1999);
        System.out.println(miTarot.getDay()+"/"+miTarot.getMonth()+"/"+miTarot.getYear());
        System.out.println("É o ano bisiexto? "+miTarot.isLeapYear(1999));
        System.out.println("É a data correcta? "+miTarot.checkDate(10, 9, 1999));
        System.out.println("O número de Tarot é: "+miTarot.calculateTarot(10, 9, 1999));

    }

    /** 
     * @param day dia de nacemento
     * @param month mes de nacemento
     * @param year ano de nacemento
     */
    public Tarot(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Calcula se un ano dado é bisiexto
     * @param year o ano de nacemento
     * @return se o ano de nacemento é bisiexto
     */
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 != 0;
    }

    /**
     * Compoba que unha data dada sea correcta
     * @param day dia de nacemento
     * @param month mes de nacemento
     * @param year ano de nacemento
     * @return se a data introducida é correcta
     */
    public boolean checkDate(int day, int month, int year) {
            /** 
             * Crease un switch para comprobar se o mes é correcto
             * e diferenciar meses de 30, 31 dias e febreiro 
             */
            switch (month) {
                //Meses de 31 dias
                case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                    return day > 0 && day <= 31;
                //Meses de 30 dias
                case 4:case 6:case 9:case 11:                
                    return day > 0 && day < 31;
                case 2:// No caso de febreiro, debemos usar o metodo isLeapYear()
                    if (isLeapYear(year)) {
                        return day > 0 && day <= 29;
                    } else {
                        return day > 0 && day < 29;
                    }
                //Mes incorrecto
                default: return false;
            }
    }
    /**
     * Calcula o número de tarot para unha fecha de nacemento dada, usando o 
     * metodo sumNumbers() para funcionar
     * @param day dia de nacemento
     * @param month mes de nacemento
     * @param year ano de nacemento
     * @return o numero de tarot para esta clase
     */
    public int calculateTarot(int day, int month, int year) {
        //Crease unha variable donde gardar a suma de day monthe e year
        int number= day + month + year,result;
        //Aplicamos o metodo sumNumbers en bucle ata que nos devolva un numero dun solo díxito
        do{
            result= sumNumbers(number);
            number = result;
        }while(result >= 10);
        
        return result;

    }
    /**
     * Obten a suma dos díxitos dun número dado
     * @param number o numero do que se desexan sumar os díxitos
     * @return a suma dos dixitos do numero introducido como parametro
     */
    private int sumNumbers(int number){
        int result =0;            
        do{
            result += number%10;
            number /= 10;
        }while(number > 0);
        
        return result;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
