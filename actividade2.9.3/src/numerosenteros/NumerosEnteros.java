package numerosenteros;

import java.util.Scanner;

/**
 * Esta é a clase NumerosEnteros que conta cun metodo que devolve o maior de
 * 10 enteiros que pide por teclado
 * @author Xaquin Alves Gonzalez
 */
public class NumerosEnteros {
    //Proba de funcionamento
    public static void main(String[] args) {
        System.out.println("O maior é: "+getBigger());
    }
    /**
     * Pide dez enteiros por teclado e obten o maior deles, utiliza os metodos
     * privados get2Bigger(int,int) e pideNum()
     * @return enteiro maior dos introducidos
     */
    public static int getBigger(){
        //Garda o numero maior
        int nBig;
        //Pide os numeros por teclado con pideNum() e gardaos
        int n0 = pideNum();
        int n1 = pideNum();
        int n2 = pideNum();
        int n3 = pideNum();
        int n4 = pideNum();
        int n5 = pideNum();
        int n6 = pideNum();
        int n7 = pideNum();
        int n8 = pideNum();
        int n9 = pideNum();
        //Compara todos os numeros co metodo is2Bigger(int,int)
        nBig = get2Bigger(n0, n1);
        nBig = get2Bigger(nBig, n2);
        nBig = get2Bigger(nBig, n3);
        nBig = get2Bigger(nBig, n4);
        nBig = get2Bigger(nBig, n5);
        nBig = get2Bigger(nBig, n6);
        nBig = get2Bigger(nBig, n7);
        nBig = get2Bigger(nBig, n8);
        nBig = get2Bigger(nBig, n9);
        
        return nBig;
    }
    /**
     * Obten o maior de dous enteiros introducidos como parametro
     * @param n0 numero enteiro
     * @param n1 numero enteiro
     * @return numero enteiro maior
     */
    private static int get2Bigger(int n0,int n1){
        if(n0>n1){
            return n0;
        }
        else return n1;
    }
    
    /**
     * Obten un enteiro pedindoo por teclado
     * @return enteiro introducido por teclado
     */
    private static int pideNum(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce un número enteiro: ");
        return scan.nextInt();
    }
        
}
