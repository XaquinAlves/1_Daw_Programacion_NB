package memorygame;

/**
 * Representa unha carta de memoria calquera dentro do xogo
 * 
 * @author Xaquin Alves
 */
public abstract class Card {

    //Texto que amosa a carta
    protected String text;
    //Se esta emparellada
    protected boolean hit;

    /**
     * Para instanciar unha carta
     *
     * @param text texto que amosa a carta
     */
    public Card(String text) {
        this.text = text;
        hit = false;
    }

    /**
     *
     * @return texto que amosa a carta
     */
    public String getText() {
        return text;
    }

    /**
     * Establece un novo texto que amosa a carta
     *
     * @param text texto que amosa a carta
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return se a carta foi emparellada
     */
    public boolean isHit() {
        return hit;
    }

    /**
     * Establece se a carta foi emparellada
     *
     * @param hit true se a carta foi emparellada
     */
    public void setHit(boolean hit) {
        this.hit = hit;
    }

    /**
     * Compara outra carta con esta, devolvendo true se estan emparelladas
     * 
     * @param card carta a comparar
     * @return true se estan emparelladas
     */
    public abstract boolean isEquals(Card card);

}
