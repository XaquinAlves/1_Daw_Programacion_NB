package memorygame;

/**
 * Interfaz que deben implementar as clases xeneradoras de cartas
 *
 * @author Xaquin Alves
 */
public interface CardGenerator {

    /**
     * Xenera unha matriz de cartas co numero de filas e columnas indicado
     * 
     * @param rows numero de filas
     * @param cols numero de columnas
     * @return matriz de cartas
     * @throws GenerateCardsException se es intenta xerar mais cartas das permitidas
     */
    Card[][] generateCards(int rows, int cols) throws GenerateCardsException;
}
