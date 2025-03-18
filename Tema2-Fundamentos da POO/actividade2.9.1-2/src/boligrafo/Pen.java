package boligrafo;

/**
 * Esta clase representa un boligrafo cun atributo ink que garda as unidades de
 * tinta e un metodo write que escribe unha palabra o numero de veces que se lle
 * pasan como parámetro, comprobando que hay suficiente tinta (1ud por palabra)
 * @author Xaquin Alves Gonzalez
 */
public class Pen {
    private int ink;
    /**
     * Crea un novo Pen con 30 ud de tinta
     */
    public Pen() {
        this.ink = 30;
    }
    /**
     * Escribe unha palabra o numero de veces que se pasen como parametro,
     * gastando tinta
     * @param number veces que se quere escribir a palabra
     */
    public void write(int number){
        if(number > ink){
            System.out.println("Non queda tinta suficiente");
        }
        else{
            for(int i=0;i < number;i++){
                System.out.print("Ola ");
            }
            ink = ink - number;
            System.out.println("");
        }
    }
    /**
     * Obten as unidades de tinta deste boligrafo
     * @return unidades de tinta
     */
    public int getInk() {
        return ink;
    }
    /**
     * Establece as unidades de tinta para este boligrafo
     * @param ink unidades de tinta
     */
    public void setInk(int ink) {
        this.ink = ink;
    }
    
    
}
