package arbores;

/**
 * Neste programa manexamos a clase Pine creada por nos, que representa un pino
 * @author Xaquin Alves Gonzalez
 */
public class MainApp {

    public static void main(String[] args) {
        //Creamos dous obxetos da clase Pine
        Pine pine1 = new Pine(34);
        Pine pine2 = new Pine(25);
        //Invocamos o método cut de ambos
        pine1.cut(7);
        pine2.cut(12);
        //Mostramos a altura dos pinos
        System.out.println("Os pinos miden "+pine1.getHeight()+" metros e "+pine2.getHeight()+" metros");
    }
    
}
