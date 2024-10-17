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
        //Crea unha instancia de Tarot para comprobar o funcionamento
        Tarot miTarot = new Tarot(10,9,1999);
        System.out.println(miTarot.getDay()+"/"+miTarot.getMonth()+"/"+miTarot.getYear());
        System.out.println("É o ano bisiexto? "+miTarot.isLeapYear(miTarot.year));
        System.out.println("É a data correcta? "+miTarot.checkDate(miTarot.day, miTarot.month, miTarot.year));
        System.out.println("O número de Tarot é: "+miTarot.calculateTarot(miTarot.day, miTarot.month, miTarot.year));

    }

    /** 
     * Crea tarot cunha fecha de nacemento determinada
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
            //Comproba se o mes e correcto e os dias que pode ter
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
     * @return numero de tarot para esta clase
     */
    public int calculateTarot(int day, int month, int year) {
        //Crea un int para gardar a suma de day month e year
        int number= day + month + year,result;
        //Usa o metodo sumNumbers ata que devolva un valor dun so dixito
        do{
            result= sumNumbers(number);
            number = result;
        }while(result >= 10);
        
        return result;

    }
    /**
     * Obten a suma dos díxitos dun número dado
     * @param number numero do que se desexan sumar os díxitos
     * @return suma dos dixitos do numero introducido como parametro
     */
    private int sumNumbers(int number){
        int result =0;            

        do{
            result += number%10;
            number /= 10;
        }while(number > 0);
        
        return result;
    }
    /** 
     * Obten o día de nacemento
     * @return dia de nacemento
     */
    public int getDay() {
        return day;
    }
    /** 
     * Establece un novo dia de nacemento
     * @param day dia de nacemento
     */
    public void setDay(int day) {
        this.day = day;
    }
    /**
     * Obten o mes de nacemento
     * @return mes de nacemento
     */
    public int getMonth() {
        return month;
    }
    /**
     * Establece un novo mes de nacemento
     * @param month mes de nacemento
     */
    public void setMonth(int month) {
        this.month = month;
    }
    /**
     * Obten o ano de nacemento
     * @return ano de nacemento
     */
    public int getYear() {
        return year;
    }
    /**
     * Establece un novo ano de nacemento
     * @param year ano de nacemento
     */
    public void setYear(int year) {
        this.year = year;
    }

}
