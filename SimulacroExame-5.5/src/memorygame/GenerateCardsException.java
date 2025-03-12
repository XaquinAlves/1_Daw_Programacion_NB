package memorygame;

/**
 * Excepcion que se produce cando se intentan xerar máis cartas das permitidas
 *
 * @author Xaquin Alves
 */
public class GenerateCardsException extends Exception {

    /**
     * Instancia unha nova excepcion
     * 
     * @param message mensaxe da excepcion
     */
    public GenerateCardsException(String message) {
        super(message);
    }

}
