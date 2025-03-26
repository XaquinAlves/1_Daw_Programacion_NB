package diatraballo;

/**
 * Esta é a clase WorkingDay, que representa un dia de traballo cos atributos
 * shift[quenda]('d' = dia ,'n' = noite); day('d' = domingo , 'x' = resto ) e
 * hours
 * @author Xaquin Alves González
 */
public class WorkingDay {
    private char shift;
    private char day;
    private double hours;
    
    /**
     * Crea un novo WorkingDay cun turno, dia e horas determinados 
     * @param shift turno 'd' dia 'n' noite
     * @param day dia 'd' doming 'x' para o resto
     * @param hours horas trabajadas
     */
    public WorkingDay(char shift, char day, double hours) {
        this.shift = shift;
        this.day = day;
        this.hours = hours;
    }
    /**
     * Obten o turno deste día de traballo
     * @return turno de traballo
     */
    public char getShift() {
        return shift;
    }
    /**
     * Estable o turno deste dia de traballo
     * @param shift turno 'd' dia 'n' noite
     */
    public void setShift(char shift) {
        this.shift = shift;
    }
    /**
     * Obten o dia deste dia de traballo
     * @return dia 'd' domingo 'x' resto    
     */
    public char getDay() {
        return day;
    }
    /**
     * Establece o dia deste dia de traballo
     * @param day dia 'd' domingo 'x' resto
     */
    public void setDay(char day) {
        this.day = day;
    }
    /**
     * Obten as horas deste dia de traballo
     * @return horas traballadas
     */
    public double getHours() {
        return hours;
    }
    /**
     * Establece as horas deste dia de traballo
     * @param hours horas traballadas
     */
    public void setHours(double hours) {
        this.hours = hours;
    }
    /**
     * Obten o salario para este día de traballo
     * @return salario
     */
    public double income(){
        //Para o domingo
        if(day == 'd'){
          //Turno noite
          if(shift == 'n'){
            return (hours*12)*1.2;  
          }//Turno dia
          else{
            return (hours*8)*1.2;  
          }
        }//Para os dias non domingo
        else{
          //Turno noite  
          if(shift == 'n'){
              return hours*12;
          }
          else{//Turno dia
              return hours*8;
          }            
        }
    }
}
