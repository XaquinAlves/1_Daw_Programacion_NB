package hogwarts.controller;

import hogwarts.exceptions.UnderConstructionException;
import hogwarts.model.HogwartsCharacter;
import hogwarts.model.Pet;
import hogwarts.model.Student;
import hogwarts.model.Subject;
import hogwarts.model.Teacher;
import hogwarts.persistence.HogwartsCharacterDB;
import hogwarts.persistence.SubjectDB;
import hogwarts.view.HogwartsView;
import hogwarts.view.JFrameHogwarts;


/**
 * Xestiona as funcionalidades da aplicación
 *
 * @author xaquin.alvesgonzalez
 */
public class HogwartsController {

    /**
     * Referencia ao obxeto vista
     */
    private HogwartsView view;

    /**
     * Para instanciar esta clase
     */
    public HogwartsController() {
        view = new JFrameHogwarts(this);
    }

    /**
     * Inicia a aplicacion, obtendo os personaxes a amosar da clase
     * HogwartsCharacterDB e pasandollos a vista, e chamando o metodo showMenu()
     * da vista
     */
    public void initApp() {
        //Chama a clase de persistencia e pasa os personaxes a vista
        try {
            view.setCharacters(HogwartsCharacterDB.getHogwartsCharacters());
            view.showMenu();
        } catch (UnderConstructionException ex) { //En caso de que non este implementado
            view.showUnderConstructionMessage("Mostrar o menu inicial ");
        }
    }

    /**
     * Obten un personaxe a partir do codigo pasado e pidelle a vista que amose
     * os seus datos
     *
     * @param hogwartsCode codigo do personaxe a amosar
     */
    public void showCharacterData(String hogwartsCode) {
        //Busca o personaxe na BD
        HogwartsCharacter character = HogwartsCharacterDB.findByCode(hogwartsCode);
        //Pidelle a vista que amose a informacion
        try {
            view.showCharacterData(character);
        } catch (UnderConstructionException ex) {//En caso de que non este implementado
            view.showUnderConstructionMessage("Mostrar os datos dunha personaxe ");
        }
    }

    /**
     * Obten unha materia a partir do codigo pasado e pidelle a vista que amose
     * os seus datos
     *
     * @param subjectCode codigo da materia
     */
    public void showsubjectData(String subjectCode) {
        //Busca a materia na BD
        Subject subject = SubjectDB.finByCode(subjectCode);
        //Pidelle a vista que amose a informacion
        try {
            view.showSubjectData(subject);
        } catch (UnderConstructionException ex) { //Se inda non esta implementado
            view.showUnderConstructionMessage("Mostrar os datos dunha materia ");
        }
    }

    /**
     * Carga personaxes e materias por defecto nas BD ao iniciar a aplicacion
     */
    public void loadSampleData() {
        // Creamos uns alumnos e uns profesores
        Student harry = new Student("Harry Potter", "Cicatriz en forma de raio na fronte",
                "A-1992-0001", "Griffindor", new Pet("Curuxa", "Hedwig", 3), "Buscador", 3);
        Student hermione = new Student("Hermione Granger", "Moi observadora e boa estudante",
                "A-1992-0002", "Griffindor", new Pet("Gata", "Crookshanks", 2), "", 3);
        Student draco = new Student("Draco Malfoy", "Inimigo de Harry Potter",
                "A-1992-0004", "Slytherin", null, "Buscador", 3);
        Teacher dumbledore = new Teacher("Albus Dumbledore", "Longa barba", "P-001",
                "", new Pet("Fénix", "Fawkes", 150), "500 anos de experiencia na maxia");
        Teacher minerva = new Teacher("Minerva McGonagall",
                "Moi estrita", "P-002", "Griffindor", null, "Experta en feitizos");
        Teacher snape = new Teacher("Severus Snape", "Apariencia escura", "P-003",
                "Slytherin", null, "Experto en maxia negra");

        // Creamos unhas materias
        Subject trans4 = new Subject("MM-401", "Transformacións 4", 4, minerva);
        trans4.getStudents().add(harry);
        trans4.getStudents().add(hermione);
        trans4.getStudents().add(draco);
        Subject pot4 = new Subject("MM-402", "Pocións 4", 4, snape);

        // Engadimos os alumnos e profes ás personaxes de Howgwarts
        HogwartsCharacterDB.getHogwartsCharacters().add(harry);
        HogwartsCharacterDB.getHogwartsCharacters().add(hermione);
        HogwartsCharacterDB.getHogwartsCharacters().add(draco);
        HogwartsCharacterDB.getHogwartsCharacters().add(dumbledore);
        HogwartsCharacterDB.getHogwartsCharacters().add(minerva);
        HogwartsCharacterDB.getHogwartsCharacters().add(snape);

        // Engadimos as materias á lista de materias de Hogwarts
        SubjectDB.getSubjects().add(trans4);
        SubjectDB.getSubjects().add(pot4);
    }

    /**
     * Permite gardar un novo personaxe na academia
     *
     * @param hogwartsCharacter personaxe a gardar
     */
    public void saveCharacter(HogwartsCharacter hogwartsCharacter) {
        //Gardamos o personaxe na BD
        HogwartsCharacterDB.save(hogwartsCharacter);
        //Indicamos a vista a nova lista de personaxes
        try {
            view.setCharacters(HogwartsCharacterDB.getHogwartsCharacters());
        } catch (UnderConstructionException ex) {//en caso de que non este implemetado
            view.showUnderConstructionMessage("mostrar as personaxes ");
        }
    }

    /**
     * Permite actualizar os datos dun perxsonaxe
     *
     * @param hogwartsCharacter personaxe a actualizar
     */
    public void updateCharacter(HogwartsCharacter hogwartsCharacter) {
        //modificamos o personaxe na BD
        HogwartsCharacterDB.update(hogwartsCharacter);
        //Indicamos a vista a nova lista de personaxes
        try {
            view.setCharacters(HogwartsCharacterDB.getHogwartsCharacters());
        } catch (UnderConstructionException ex) {//en caso de que non este implemetado
            view.showUnderConstructionMessage("mostrar as personaxes ");
        }
    }

    /**
     * Permite borrar un personaxe da academia
     *
     * @param hogwartsCharacter personaxe a borrar
     */
    public void deleteCharacter(HogwartsCharacter hogwartsCharacter) {
        //Borramos o personaxe da BD
        HogwartsCharacterDB.delete(hogwartsCharacter);
        //Indicamos a vista a nova lista de personaxes
        try {
            view.setCharacters(HogwartsCharacterDB.getHogwartsCharacters());
        } catch (UnderConstructionException ex) {//en caso de que non este implemetado
            view.showUnderConstructionMessage("mostrar as personaxes ");
        }
    }

    /**
     * Para executar a aplicación
     *
     * @param args
     */
    public static void main(String[] args) {
        HogwartsController controller = new HogwartsController();
        controller.loadSampleData();
        controller.initApp();
    }
}
