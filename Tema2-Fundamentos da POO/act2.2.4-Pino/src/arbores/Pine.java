package arbores;

/**
 * Esta é a clase Pine, que representa un pino coa sua altura
 * @author Xaquin Alves Gonzalez
 */
public class Pine {
    
    private double height;
    
    public Pine(double heigth){
        this.height = heigth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    //Este metodo modifica a aultura restandolle o valor do parametro
    public void cut(double meters){
        height -= meters;
    }
}
