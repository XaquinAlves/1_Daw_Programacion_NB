package carteira;

/**
 * Neste programa manexamos a clase Wallet creada por nos
 * @author Xaquin Alves Gonzalez 
 */
public class Carteira {

    public static void main(String[] args) {
        //Creamos as 3 carteiras
        Wallet carteira1 = new Wallet(250, false);
        Wallet carteira2 = new Wallet(25, true);
        Wallet carteira3 = new Wallet(10, false);
        //Mostramos por pantalla o método avaliable() de cada carteira creada
        System.out.println(carteira1.avaliable());
        System.out.println(carteira2.avaliable());
        System.out.println(carteira3.avaliable());
    }
    
}

