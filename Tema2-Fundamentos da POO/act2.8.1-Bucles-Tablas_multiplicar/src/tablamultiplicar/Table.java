package tablamultiplicar;

/**
 * Esta é a clase Table, que representa unha tabla de multiplicar cun atributo
 * que seria o numero da taboa e un método show() que mostra a tabla por pantalla
 * @author Xaquin Alves Gonzalez
 */
public class Table {
    
    private int number;
    /** 
     * Crea un Table cun numero determinado
     * @param number numero deseado para a tabla
     */
    public Table(int number) {
        this.number = number;
    }
    /**
     * Obten o numero desta tabla
     * @return numero desta tabla
     */
    public int getNumber() {
        return number;
    }
    /**
     * Establece o numero desta tabla
     * @param number numero para esta tabla
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /**
     * Mostra por pantalla a tabla de multiplicar de number
     */
    public void show(){
        
        System.out.println("TABLA DEL "+number);
        
        for(int i=0; i <= 10;i++){
            System.out.println(number+" x "+i+" = "+i*number);
        }
    }
    
}
