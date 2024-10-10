package ordenarenteros;

/**
 * Este programa mostra por pantalla o maior de tres enteiros
 * @author Xaquin Alves González
 */
public class OrdenarEnteros {

    public static void main(String[] args) {
        //Creamos as variables tipo int e damoslle un valor
        int a,b,c;
        a= 6;
        b= 23;
        c= 12;
        //Usamos unha sentencia if else que determina que numero é maior, e mostrao por pantalla
        if(a>b && a>c){
            System.out.println("O numero maior é "+a);
        }
        else if(b>a && b>c){
            System.out.println("O numero maior é "+b);
        }
        else if(c>a && c>b){
            System.out.println("O numero maior é "+c);
        }
        else{
            System.out.println("Hay dous numeros iguais");
        }
    }
    
}