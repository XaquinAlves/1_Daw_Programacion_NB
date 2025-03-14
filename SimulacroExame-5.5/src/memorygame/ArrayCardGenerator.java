package memorygame;

/**
 *
 * @author Xaquin Alves
 */
public class ArrayCardGenerator implements CardGenerator {

    private static final String[] words = new String[]{"Elefante", "Pataca", "Pera"};
    private static final int[] operators1 = new int[]{3, 5, 6};
    private static final int[] operators2 = new int[]{9, 2, 3};
    private static final char[] operations = new char[]{MathCard.SUM, MathCard.MULT,
                                                        MathCard.SUB};

    /**
     * Xera unha nova matriz de cartas
     *
     * @param rows numero de filas
     * @param cols numero de columnas
     * @return matriz de cartas
     * @throws GenerateCardsException
     */
    @Override
    public Card[][] generateCards(int rows, int cols) throws GenerateCardsException {
        if (rows * cols > 12) {
            throw new GenerateCardsException(
                    "Se queres tantas cartas, debes mercar a versión PRO");
        }
        else {
            Card[][] generatedCards = new Card[rows][cols];
            for (int i = 0; i < (rows * cols) / 4; i++) {
                Card[] textCardPair = {
                    new TextCard(words[i]),
                    new TextCard(words[i])
                };
                insertPair(textCardPair, generatedCards, rows, cols);

                Card[] mathCardPair = {
                    new MathCard(operators1[i], operators2[i],
                                 operations[i], MathCard.OPERATION_CARD),
                    new MathCard(operators1[i], operators2[i],
                                 operations[i], MathCard.RESULT_CARD)
                };

                insertPair(mathCardPair, generatedCards, rows, cols);
            }
            return generatedCards;
        }
    }

    /**
     * Inserta un array de duas cartas aleatoriamente nun array bidimensional de cartas
     * que ten o número de filas e de columnas indicado
     *
     * @param cardPair Array con dúas cartas
     * @param cards Array bidimensional no que se queren colocar as cartas
     * @param rows Número de filas
     * @param columns Número de columnas
     */
    private void insertPair(Card[] cardPair, Card[][] cards,
                            int rows, int columns) {
        // Recorremos o array co par de cartas para colocar as dúas cartas
        for (int i = 0; i < 2; i++) {
            boolean cardInserted = false;
            do {
                // Xeramos aleatoriamente unha fila e unha columna para colocar
                // a carta
                int row = new java.util.Random().nextInt(rows);
                int column = new java.util.Random().nextInt(columns);
                // Se na posición xerada non hai ningunha carta, colocamos
                // a carta nesa posición e marcamos que está insertada
                if (cards[row][column] == null) {
                    cards[row][column] = cardPair[i];
                    cardInserted = true;
                }
            } while (!cardInserted);
        }
    }

}
