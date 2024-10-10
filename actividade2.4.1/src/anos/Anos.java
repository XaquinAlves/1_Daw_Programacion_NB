package anos;

/**
 * Neste programa manexamos a clase Year creada por nos
 * @author Xaquin Alves Gonzalez
 */
public class Anos {

    public static void main(String[] args) {
        Year ano = new Year(false);
        
        ano.showDaysOfMonth(2);
        ano.showDaysOfMonth(8);
        ano.showDaysOfMonth(11);
        ano.showDaysOfMonth(14);
        ano.setLeapYear(true);
        ano.showDaysOfMonth(2);
    }
    
}
