package tablamultiplicar;

/**
 * Neste programa manexamos a clase Table creada por nos
 * @author Xaquin Alves Gonzalez
 */
public class MainApp {

    public static void main(String[] args) {
        Table tabla = new Table(3);
        tabla.show();
        tabla.setNumber(6);
        tabla.show();
        tabla.setNumber(9);
        tabla.show();
        tabla.setNumber(1);
        tabla.show();
    }
    
}
