package comparadorstring;

/**
 * Este programa manexa a clase StringComparator creada por nos
 *
 * @author Xaquin Alves González
 */
public class ComparadorString {

    public static void main(String[] args) {
        //Creamos unha nova instancia da clase StringComparator
        StringComparator comparador = new StringComparator("Hola que tal", "Buenas tardes", "Buenos dias");
        //Mostramos por pantalla o método getBigger() para comprobar o funcionamento
        System.out.println("O texto máis largo é: " + comparador.getBigger());
    }

}
