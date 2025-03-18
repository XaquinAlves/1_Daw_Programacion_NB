package carteira;

/**
 * Esta clase reprensenta unha carteira, que almacena nos seus atributos o 
 * diñeiro(money) e se ten tarxeta ou non (card)
 * @author Xaquin Alves Gonzalez 
 */
public class Wallet {
    //Definimos as variables
    private double money;
    private boolean card;
    /**
     * Constructor da clase, crea unha nova carteira cos parametros dados
     * @param money o diñeiro que estaá na carteira
     * @param card se ten tarxeta ou non
     */
    public Wallet(double money, boolean card) {
        this.money = money;
        this.card = card;
    }
    /**
     * Obten o diñeiro que hay nesta carteira
     * @return o diñeiro que ten esta carteira 
     */
    public double getMoney() {
        return money;
    }
    /**
     * Establece o diñeiro para esta carteira
     * @param money o diñeiro que se quera establecer para esta carteira
     */
    public void setMoney(double money) {
        this.money = money;
    }
    /** 
     * Obten se esta carteira ten unha tarxeta
     * @return se esta carteira ten tarxeta ou non
     */
    public boolean isCard() {
        return card;
    }
    /**
     * Establece se esta carteira ten unha tarxeta
     * @param card establece se esta carteira ten tarxeta ou non 
     */
    public void setCard(boolean card) {
        this.card = card;
    }
    /**
     * Obten un recordatorio de se tes efectivo ou debes sacar
     * @return que debes facer dependendo do que tes na carteira
     */
    public String avaliable(){
        if(money < 100 && card){
            return "Vai a un caixeiro";
        }
        else if(money < 100 && !card){
            return "Vai a unha sucursal";
        }
        else{
            return "Si teño efectivo";
        }
    }
    
}
