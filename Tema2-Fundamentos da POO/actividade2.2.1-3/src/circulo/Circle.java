package circulo;

/**
 * Esta e a clase Circle, representa un círculo almacenando o seu radio en double
 *
 * @author Xaquin Alves Gonzalez
 */
public class Circle {

    private double radius;
    private static final int MAX_RADIUS = 10;

    //Este e o constructor da clase, usando o radio como parametro
    public Circle(double radius) {
        //Comprobamos que o radio dado como parametro non supere o maximo establecido
        if (radius > MAX_RADIUS) {
            System.out.println("O radio intruducido, " + radius + " é maior ao límite permitido, " + MAX_RADIUS);
        }
        else{
            this.radius = radius;
        }        
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        //Comprobamos que o radio dado como parametro non supere o maximo establecido
        if (radius > MAX_RADIUS) {
            System.out.println("O radio intruducido, " + radius + " é maior ao límite permitido, " + MAX_RADIUS);
        }
        else{
            this.radius = radius;
        }
    }

    public static int getMAX_RADIUS() {
        return MAX_RADIUS;
    }

    //Este metodo mostra por pantalla o radio deste circulo
    public void show() {
        System.out.println("Son un círculo de radio " + radius);
    }
    //Este metodo duplica o radio deste circulo
    public void enlarge() {
        //Comprobamos se ao duplicar o radio superaría o limite estableido
        if (radius * 2 > MAX_RADIUS) {
            //Se o supera, mostramos que non se pode realizar a operacion cun texto
            System.out.println("Non se pode agrandar este círculo de radio " + radius + ", xa que superaría o límite establecido");
        } else {
            radius *= 2;
        }
    }
}
