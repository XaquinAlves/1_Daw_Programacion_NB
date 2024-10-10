package circulo;

/**
 * Neste programa manexamos a clase Circle creada por nos
 * @author Xaquin Alves Gonzalez
 */
public class MainApp {

    public static void main(String[] args) {
        //Mostramos o limite establecido para os radios
        System.out.println("O radio máximo é "+Circle.getMAX_RADIUS());
        //Creamos os dous circulos dandolle o valor do radio
        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle(9);
        //Duplicamos os circulos co metodo enlarge
        circle1.enlarge();
        circle2.enlarge();
        //Invocamos o metodo show de cada circulo
        circle1.show();
        circle2.show();
    }
    
}
