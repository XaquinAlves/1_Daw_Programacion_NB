package comparadorstring;

/**
 * Esta é a clase StringComparator, que posee tres atributos tipo String e un 
 * método que devolve o String mais largo
 * @author Xaquin Alves González
 */
public class StringComparator {
     
    private String chain1;
    private String chain2;
    private String chain3;
    
    /** 
     * Constructor da clase que recibe 3 parametros:      
     * @param chain1 unha cadea de texto calquera     
     * @param chain2 unha cadea de texto calquera
     * @param chain3 unha cadea de texto calquera 
     */
    public StringComparator(String chain1, String chain2, String chain3) {
        this.chain1 = chain1;
        this.chain2 = chain2;
        this.chain3 = chain3;
    }
    
    /**
     * Este método compara a lonxitude dos String valendose do metodo length()
     * da clase String e unha sentencia if else
     * @return O String de maior lonxitude dos 3 almacenados 
     */
    public String getBigger(){
        if(chain1.length() > chain2.length() && chain1.length() > chain3.length()){
            return chain1;
        }
        else if(chain2.length() > chain1.length() && chain2.length() > chain3.length()){
            return chain2;
        }
        else if(chain3.length() > chain1.length() && chain3.length() > chain2.length()){
            return chain3;
        }
        else{
            System.out.println("Hay dous textos de igual lonxitude");
            return null;
        }
    }
}
