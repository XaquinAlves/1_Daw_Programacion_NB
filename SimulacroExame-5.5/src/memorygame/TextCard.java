package memorygame;

/**
 * Representa unha carta de memoria de texto dentro do xogo
 *
 * @author Xaquin Alves
 */
public class TextCard extends Card {

    /**
     * Instancia unha carta de texto
     *
     * @param text texto que amosa a carta
     */
    public TextCard(String text) {
        super(text);
    }

    /**
     * Compara outra carta con esta, devolvendo true se estan emparelladas
     *
     * @param card carta a comparar
     * @return true se estan emparelladas
     */
    @Override
    public boolean isEquals(Card card) {
        return card.getText().equals(this.getText());
    }

}
