package memorygame;

/**
 *
 * @author Xaquin Alves
 */
public class MathCard extends Card {

    //Operandos
    private int operator1, operator2;
    //Operador
    private char operation;

    //Constantes para o tipo de operacion
    public static final char SUM = '+';
    public static final char SUB = '-';
    public static final char MULT = '*';
    //Constantes para o tipo de carta
    public static final int OPERATION_CARD = 0;
    public static final int RESULT_CARD = 1;

    /**
     * Instancia unha carta de matematicas
     *
     * @param operator1 primer operando
     * @param operator2 segundo operando
     * @param operation tipo de operacion
     * @param cardType tipo de carta
     */
    public MathCard(int operator1, int operator2, char operation, int cardType) {
        super("");
        this.operator1 = operator1;
        this.operator2 = operator2;
        this.operation = operation;
        if (cardType == OPERATION_CARD) {
            setText(String.valueOf(operator1) + operation + String.valueOf(operator2));
        }
        else if (cardType == RESULT_CARD) {
            setText(String.valueOf(getValue()));
        }
    }

    /**
     * Calcula o resultado da operacion
     *
     * @return resultado da operación
     */
    private int getValue() {
        return switch (operation) {
            case SUM ->
                operator1 + operator2;
            case SUB ->
                operator1 - operator2;
            case MULT ->
                operator1 * operator2;
            default ->
                0;
        };
    }

    /**
     * Compara outra carta con esta, devolvendo true se estan emparelladas
     *
     * @param card carta a comparar
     * @return true se estan emparelladas
     */
    @Override
    public boolean isEquals(Card card) {
        if (card instanceof MathCard mathCard) {
            return mathCard.getValue() == this.getValue();
        }
        else {
            return false;
        }
    }

}
