package hogwarts.model;

/**
 * Representa unha mascota que pode ter un personaxe de Hogwarts
 *
 * @author xaquin.alvesgonzalez
 */
public class Pet {

    /**
     * Tipo de animal
     */
    private String animal;
    /**
     * Nome da mascota
     */
    private String name;
    /**
     * Idade da mascota
     */
    private int age;

    /**
     * Para instanciar unha mascota
     *
     * @param animal Tipo de animal
     * @param name Nome da mascota
     * @param age Idade da mascota
     */
    public Pet(String animal, String name, int age) {
        this.animal = animal;
        this.name = name;
        this.age = age;
    }

    /**
     *
     * @return Tipo de animal
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Establece o Tipo de animal
     *
     * @param animal Tipo de animal
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }

    /**
     *
     * @return  Nome da mascota
     */
    public String getName() {
        return name;
    }

    /**
     * Establece o Nome da mascota
     *
     * @param name Nome da mascota
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Idade da mascota
     */
    public int getAge() {
        return age;
    }

    /**
     * Establece a Idade da mascota
     *
     * @param age Idade da mascota
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Establece o
     *
     * @param
     */
}
