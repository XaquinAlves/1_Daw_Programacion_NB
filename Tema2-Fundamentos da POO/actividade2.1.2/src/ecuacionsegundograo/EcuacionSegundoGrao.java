package ecuacionsegundograo;

/**
 * Este programa mostra por pantalla a resolución dunha ecución de segundo grao,
 * manexando variables tipo double.
 * @author Xaquin Alves Gonzalez
 */
public class EcuacionSegundoGrao {

    public static void main(String[] args) {
        // ax²+bx+c=0 -> x²-2x-15=0
        //Crea as variables nas que almacena os coeficientes da ecuación
        double a,b,c;
        a=1; b=-2; c=-15;
        
        //Crea un if para os casos nos que non hay solución, cando o interior da raiz é negativo
        if(Math.pow(b,2)-4*a*c<0){
            System.out.println("A ecuación non ten resultados");
        }//E dentro do else mostramos as solucións nos casos que si existe
        else{
        System.out.println("Para a ecuación "+a+"*x²+"+b+"*x+"+c+", x pode ter os valores "+resolucionPositiva(a,b,c)+" e "+resolucionNegativa(a,b,c));}
        
    }
    /**@return a solucion positiva para os valores dados dunha ecuacion de 2o grao en double */
    private static double resolucionPositiva(double a,double b,double c){
        return (-b+Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
    }
    /**@return a solucion negativa para os valores dados dunha ecuacion de 2o grao en double*/
    private static double resolucionNegativa(double a,double b,double c){
        return (-b-Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
    }
    
}
