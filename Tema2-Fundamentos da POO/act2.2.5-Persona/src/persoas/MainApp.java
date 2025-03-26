package persoas;

/**
 * Neste programa manexamos a clase Person creada por nos
 * @author Xaquin Alves Gonzalez
 */
public class MainApp {

    public static void main(String[] args) {
        //Creamos as persoas dandolles un nome e un ano de nacemento
        Person person1 = new Person("Pepe", 1997);
        Person person2 = new Person("Paco", 1999);
        //Invocamos o metodo future() para as duas instancias de Person
        person1.future();
        person2.future();
    }
    
}