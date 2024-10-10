package persoas;

/**
 * Esta é a clase Person, que representa unha persoa gardando o seu nome e ano de nacemento
 * @author Xaquin Alves Gonzalez
 */
public class Person {
    /** Nome da persoa */
    private String name;
    /** Ano de nacemento da persoa */
    private int birthYear;
    /** Crea unha nova instancia de persoa con:
     * @param name nome
     * @param birthYear ano de nacemento*/
    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }
    /** @return O nome desta persoa*/
    public String getName() {
        return name;
    }
    /** @param name O nome que se queira establecer para esta persoa*/
    public void setName(String name) {
        this.name = name;
    }
    /** @return O ano de nacemento desta persoa */
    public int getBirthYear() {
        return birthYear;
    }
    /** @param birthYear o ano de nacemento que se queira establecer para esta persoa*/
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    /** Mostra a idade que terá esta persoa en 2030 */
    public void future(){
        int n = 2030 - birthYear;
        System.out.println("Son "+name+", e no ano 2030 terei "+n+" anos.");
    }
}
