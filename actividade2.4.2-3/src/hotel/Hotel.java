package hotel;

/**
 * Este programa mostra o precio de habitación dun hotel para unha persoas 
 * dependendo das seguintes condicions: idade, ter carne universitario, ter carne
 * de xubilado, estar en paro e ser familia numerosa
 * @author Xaquin Alves Gonzalez 
 */
public class Hotel {

    public static void main(String[] args) {
        //Creamos as variables para almacenar os valores que analizaremos coas condicions
        int age = 19;
        boolean universityCard = true;
        boolean retired = false;
        boolean unemployment = true;
        boolean familyCard = false;
        
        //Primeiro, cunha sentecia if else diferenciaremos os tres posibles casos por idade
        if(age < 30){//Dentro de cada franxa de idade, comprobamos se cumple as condicions específicas
            //Para menores de 30 anos, se ten carne universitario ou esta en paro, ou se cumple ambas
            if(universityCard && unemployment){
                System.out.println("Precio habitación: 35€");
            }
            else if(universityCard || unemployment){
                System.out.println("Precio habitación: 40€");
            }
            else{
                System.out.println("Precio habitación: 50€");
            }
        }
        else if (age > 55){
            //Para maiores de 55, se estan xubilados ou en paro
            if(retired || unemployment){
                System.out.println("Precio habitación: 45€");
            }
            else{
                System.out.println("Precio habitación: 60€");
            }
        }
        else{
            //Para os de 30 ata 55, seson familia numerosa
            if(familyCard){
                System.out.println("Precio habitación: 75€");
            }
            else{
                System.out.println("Precio habitación: 65€");
            }
        }
    }
    
}