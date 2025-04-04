package hogwarts.view;

import hogwarts.controller.HogwartsController;
import hogwarts.exceptions.UnderConstructionException;
import hogwarts.model.HogwartsCharacter;
import hogwarts.model.Subject;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Interface de usuario da aplicacion en modo texto
 *
 * @author xaquin.alvesgonzalez
 */
public class TextAppHogwarts implements HogwartsView {

    /**
     * Referencia ao obxeto controlador
     */
    private HogwartsController controller;
    /**
     * Lista de personaxes a amosar
     */
    private ArrayList<HogwartsCharacter> shownCharacters;

    /**
     * Para instanciar esta clase
     *
     * @param controller obxeto controlador
     */
    public TextAppHogwarts(HogwartsController controller) {
        this.controller = controller;
    }
    
    @Override
    public void setCharacters(ArrayList<HogwartsCharacter> characters) throws UnderConstructionException {
        this.shownCharacters = characters;
    }
    
    @Override
    public void setSubjects(ArrayList<Subject> subjects) throws UnderConstructionException {
        throw new UnderConstructionException();
    }
    
    @Override
    public void showMenu() throws UnderConstructionException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                          Benvido a Hogwarts...
                          
                          1. Listar todas as personaxes
                          2. Mostrar os datos dunha personaxe
                          3. Listar todas as materias
                          4. Mostrar os datos dunha materia
                          5. Saír de Hogwarts
                          
                          Que queres facer?:""");
            
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> {
                    showCharacters();
                }
                case 2 -> {
                    System.out.print("Introduza o codigo do personaxe: ");
                    String characterCode = scanner.nextLine();
                    controller.showCharacterData(characterCode);
                }
                case 3 -> {
                }
                case 4 -> {
                    System.out.print("Introduza o codigo da materia: ");
                    String subjectCode = scanner.nextLine();
                    controller.showsubjectData(subjectCode);
                }
                case 5 -> {
                }
                default -> {
                    System.out.println("Opción non valida");
                }
            }
            
            System.out.println("");
        } while (choice != 5);
    }
    
    private void showCharacters() {
        System.out.println("Estas son todas as personaxes rexistradas: ");
        //Recorremos a lista de personaxes a amosar
        for (HogwartsCharacter character : shownCharacters) {
            //Creamos un string para os datos do personaxe
            //Pomos o codigo e o nome
            String characterInfo = character.getCharacterCode()
                    + " - " + character.getName();
            //Agregamoslle a casa en caso de que a teña
            if (!character.getHouse().isBlank()) {
                characterInfo = characterInfo.concat("(" + character.getHouse() + ")");
            }
            //Agregamoslle a descipcion
            characterInfo = characterInfo.concat(": "+character.getCharacteristics());
            //Amosamolo por pantalla
            System.out.println(characterInfo);
        }
    }
    
    @Override
    public void showCharacterData(HogwartsCharacter character) throws UnderConstructionException {
        throw new UnderConstructionException();
    }
    
    @Override
    public void showSubjectData(Subject subject) throws UnderConstructionException {
        throw new UnderConstructionException();
    }
    
    @Override
    public void showUnderConstructionMessage(String operationName) {
        System.out.println("A operacion " + operationName + "inda esta en construcción");
    }
    
}
