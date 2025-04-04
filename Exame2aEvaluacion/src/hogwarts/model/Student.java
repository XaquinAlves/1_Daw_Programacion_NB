package hogwarts.model;

/**
 * Representa un estudante da academia, que é un tipo de HogwartsCharacter
 *
 * @author xaquin.alvesgonzalez
 */
public class Student extends HogwartsCharacter {

    /**
     * Posicion na que xoga o alumno no quidditch
     */
    private String quidditch;
    /**
     * Curso no que esta o alumno
     */
    private int curso;

    /**
     * Para instanciar un alumno de Hogwarts
     *
     * @param name Nome do personaxe
     * @param characteristics Características do personaxe
     * @param hogw_code Codigo de Hogwarts que identifica o personaxe
     * @param house Casa de Hogwarts a que pertence o personaxe
     * @param pet Referencia a mascota do personaxe, se non ten valerá NULL
     * @param quidditch Posicion na que xoga o alumno no quidditch
     * @param curso Curso no que esta o alumno
     */
    public Student( String name, String characteristics, String hogw_code, 
            String house, Pet pet, String quidditch, int curso) {
        super(name, characteristics, hogw_code, house, pet);
        this.quidditch = quidditch;
        this.curso = curso;
    }

    /**
     *
     * @return Posicion na que xoga o alumno no quidditch
     */
    public String getQuidditch() {
        return quidditch;
    }

    /**
     * Establece a Posicion na que xoga o alumno no quidditch
     *
     * @param quidditch Posicion na que xoga o alumno no quidditch
     */
    public void setQuidditch(String quidditch) {
        this.quidditch = quidditch;
    }

    /**
     *
     * @return Curso no que esta o alumno
     */
    public int getCurso() {
        return curso;
    }

    /**
     * Establece o Curso no que esta o alumno
     *
     * @param curso Curso no que esta o alumno
     */
    public void setCurso(int curso) {
        this.curso = curso;
    }

}
