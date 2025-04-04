package hogwarts.persistence;

import hogwarts.model.HogwartsCharacter;
import java.util.ArrayList;

/**
 * Manexa a persistencia dos personaxes
 *
 * @author xaquin.alvesgonzalez
 */
public class HogwartsCharacterDB {

    /**
     * Lista de personaxes gardados
     */
    private static ArrayList<HogwartsCharacter> characters = new ArrayList<>();

    /**
     * Obten a lista de personaxes gardados
     *
     * @return Lista de personaxes gardados
     */
    public static ArrayList<HogwartsCharacter> getHogwartsCharacters() {
        return characters;
    }

    /**
     * Busca un personaxe polo seu codigo, devolvendoo se atopa unha
     * coincidencia, e se non devolve null
     *
     * @param characterCode codigo do personaxe a buscar
     * @return personaxe se existe, se non null
     */
    public static HogwartsCharacter findByCode(String characterCode) {
        HogwartsCharacter foundCharacter = null;

        for (HogwartsCharacter character : characters) {
            if (character.getCharacterCode().equals(characterCode)) {
                foundCharacter = character;
            }
        }

        return foundCharacter;
    }

    /**
     * Garda a personaxe pasada como parametro na lista
     *
     * @param hogwartsCharacter personaxe a gadar
     */
    public static void save(HogwartsCharacter hogwartsCharacter) {
        characters.add(hogwartsCharacter);
    }

    /**
     * Sin implementar, actualiza os datos dun personaxe na BD
     *
     * @param hogwartsCharacter personaxe a actualixar
     */
    public static void update(HogwartsCharacter hogwartsCharacter) {
    }

    /**
     * Borra a personaxe pasada como parámetro da lista
     *
     * @param hogwartsCharacter personaxe a borrar
     */
    public static void delete(HogwartsCharacter hogwartsCharacter) {
        characters.remove(hogwartsCharacter);
    }
}
