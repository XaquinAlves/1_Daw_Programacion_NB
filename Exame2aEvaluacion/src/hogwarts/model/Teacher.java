package hogwarts.model;

/**
 * Esta clase representa un profesor da academia, que e un tipo de
 * HogwartsCharacter
 *
 * @author xaquin.alvesgonzalez
 */
public class Teacher extends HogwartsCharacter {

    /**
     * Curriculum do profesor
     */
    private String cv;

    /**
     * Para instanciar un profesor de Hogwarts
     *
     * @param name Nome do personaxe
     * @param characteristics Características do personaxe
     * @param hogw_code Codigo de Hogwarts que identifica o personaxe
     * @param house Casa de Hogwarts a que pertence o personaxe
     * @param pet Referencia a mascota do personaxe, se non ten valerá NULL
     * @param cv Curriculum do profesor
     */
    public Teacher(String name, String characteristics, String hogw_code, 
            String house, Pet pet, String cv) {
        super(name, characteristics, hogw_code, house, pet);
        this.cv = cv;
    }

    /**
     *
     * @return Curriculum do profesor
     */
    public String getCv() {
        return cv;
    }

    /**
     * Establece o Curriculum do profesor
     *
     * @param cv Curriculum do profesor
     */
    public void setCv(String cv) {
        this.cv = cv;
    }

}
