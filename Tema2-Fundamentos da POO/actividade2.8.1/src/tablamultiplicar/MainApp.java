package tablamultiplicar;

/**
 * Neste programa manexamos a clase Table creada por nos
 * @author Xaquin Alves Gonzalez
 */
public class MainApp {

    public static void main(String[] args) {
        Table tabla = new Table(1);
        tabla.show();
        for (int i = 2; i < 10; i++) {
            tabla.setNumber(i);
            tabla.show();
        }
    }
    
}
