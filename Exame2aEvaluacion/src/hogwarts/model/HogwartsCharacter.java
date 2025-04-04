package hogwarts.model;

/**
 * Esta clase implementa as características dun personaxe da academia, xa sexa
 * alumno ou profesor
 *
 * @author xaquin.alvesgonzalez
 */
public class HogwartsCharacter {

    /**
     * Nome do personaxe
     */
    protected String name;
    /**
     * Características do personaxe
     */
    protected String characteristics;
    /**
     * Codigo de Hogwarts que identifica o personaxe
     */
    protected String characterCode;
    /**
     * Casa de Hogwarts a que pertence o personaxe
     */
    protected String house;
    /**
     * Referencia a mascota do personaxe, se non ten valerá NULL
     */
    protected Pet pet;

    /**
     * Para instanciar un personaxe de Hogwarts
     *
     * @param name Nome do personaxe
     * @param characteristics Características do personaxe
     * @param hogw_code Codigo de Hogwarts que identifica o personaxe
     * @param house Casa de Hogwarts a que pertence o personaxe
     * @param pet Referencia a mascota do personaxe, se non ten valerá NULL
     */
    public HogwartsCharacter(String name, String characteristics, String hogw_code, String house, Pet pet) {
        this.name = name;
        this.characteristics = characteristics;
        this.characterCode = hogw_code;
        this.house = house;
        this.pet = pet;
    }

    /**
     *
     * @return Nome do personaxe
     */
    public String getName() {
        return name;
    }

    /**
     * Establece o Nome do personaxe
     *
     * @param name Nome do personaxe
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Características do personaxe
     */
    public String getCharacteristics() {
        return characteristics;
    }

    /**
     * Establece o texto cas Características do personaxe
     *
     * @param characteristics texto vas Características do personaxe
     */
    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    /**
     *
     * @return Codigo de Hogwarts que identifica o personaxe
     */
    public String getCharacterCode() {
        return characterCode;
    }

    /**
     * Establece o Codigo de Hogwarts que identifica o personaxe
     *
     * @param characterCode Codigo de Hogwarts que identifica o personaxe
     */
    public void setCharacterCode(String characterCode) {
        this.characterCode = characterCode;
    }

    /**
     *
     * @return Casa de Hogwarts a que pertence o personaxe
     */
    public String getHouse() {
        return house;
    }

    /**
     * Establece a Casa de Hogwarts a que pertence o personaxe
     *
     * @param house Casa de Hogwarts a que pertence o personaxe
     */
    public void setHouse(String house) {
        this.house = house;
    }

    /**
     *
     * @return
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Establece a Referencia a mascota do personaxe, se non ten valerá NULL
     *
     * @param pet Referencia a mascota do personaxe, se non ten valerá NULL
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

}
