package anos;

/**
 * Esta clase representa un ano, cun atributo tipo boolean que representa se 
 * é bisiexto
 * @author Xaquin Alves Gonzalez
 */
public class Year {
    //Variable que representa se é bisiexto
    private boolean leapYear;
    /** Constructor 
     * @param leapYear se é ano bisiexto ou non (true/false) 
     */
    public Year(boolean leapYear) {
        this.leapYear = leapYear;
    }
    /** 
     * Obten se este ano é bisiexto
     * @return se é ano bisiexto ou non
     */
    public boolean isLeapYear() {
        return leapYear;
    }
    /** 
     * Establece se este ano é bisiexto
     * @param leapYear se é bisiexto ou non (true/false)
     */
    public void setLeapYear(boolean leapYear) {
        this.leapYear = leapYear;
    }
    /** 
     * Este método mostra por pantalla os días do mes dado para este ano
     * @param month o mes do que se queiran saber os días
     */
    public void showDaysOfMonth(int month) {
        //Primeiro, usamos un if para comprobar que o valor introducido é correcto
        if(month>12 || month<=0){
            System.out.println("O mes introducido non é valido");
        }
        else{//Detro deste else, implementamos o método para os valores correctos
        //Utilizamos un switch para diferenciar os meses de 30 e 31 dias e febreiro
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println("O mes introducido ten 31 días");
                break;
            case 4: case 6: case 9: case 11:
                System.out.println("O mes introducido ten 30 días");
                break;
            case 2:  // No caso de febreiro, debemos comprobar o valor de leapYear
                if(leapYear){
                    System.out.println("O mes introducido ten 29 días");
                    break;
                }
                else{
                    System.out.println("O mes introducido ten 28 días");
                    break;
                }
        }}
    }
}

