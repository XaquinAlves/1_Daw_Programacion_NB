package cualificacion;

/**
 * Este programa mostra por pantalla a que equivale unha calificacion dada
 * @author Xaquin Alves Gonzalez
 */
public class Cualificacion {

    public static void main(String[] args) {
        int qualification = 7;
        
        switch(qualification){
            case 10:
                System.out.println("Matrícula de Honra");
                break;
            case 9:
                System.out.println("Sobresainte");
                break;
            case 8: case 7:
                System.out.println("Notable");
                break;
            case 6:
                System.out.println("Ben");
                break;
            case 5:
                System.out.println("Aprobado");
                break;
            default :
                System.out.println("Suspenso");
        }
    }
    
}
