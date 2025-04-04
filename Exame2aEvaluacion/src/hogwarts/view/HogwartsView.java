package hogwarts.view;

import hogwarts.exceptions.UnderConstructionException;
import hogwarts.model.HogwartsCharacter;
import hogwarts.model.Subject;
import java.util.ArrayList;

/**
 * Interface que deben implementar as distintas interfaces de usuario do
 * programa
 *
 * @author xaquin.alvesgonzalez
 */
public interface HogwartsView {

    /**
     * Usado pola clase controladora para indicar a lista de personaxes da
     * academia que hay que mostrar
     *
     * @param characters lista de personaxes
     * @throws UnderConstructionException se esta funcion inda non estivese
     * implementada
     */
    public void setCharacters(ArrayList<HogwartsCharacter> characters)
            throws UnderConstructionException;

    /**
     * Usado pola clase controladora para indicar a lista de materias que hay
     * que mostrar
     *
     * @param subjects Lista de materias
     * @throws UnderConstructionException se esta funcion inda non estivese
     * implementada
     */
    public void setSubjects(ArrayList<Subject> subjects)
            throws UnderConstructionException;

    /**
     * Mostra o menú coas opcions da aplicación
     *
     * @throws UnderConstructionException se esta funcion inda non estivese
     * implementada
     */
    public void showMenu() throws UnderConstructionException;

    /**
     * Usado pola clase controladora para mostrar os datos dun personaxe
     *
     * @param character personaxe a amosar
     * @throws UnderConstructionException se esta funcion inda non estivese
     * implementada
     */
    public void showCharacterData(HogwartsCharacter character) throws UnderConstructionException;

    /**
     * Usado pola clase controladora para mostrar os datos dunha materia
     *
     * @param subject materoa a amosar
     * @throws UnderConstructionException se esta funcion inda non estivese
     * implementada
     */
    public void showSubjectData(Subject subject) throws UnderConstructionException;

    /**
     * Metodo chamado pola clase controladora cando se produce unha
     * UnderCOnstructionException para amosar un mensaxe ao usuario
     *
     * @param operationName
     */
    public void showUnderConstructionMessage(String operationName);
}
