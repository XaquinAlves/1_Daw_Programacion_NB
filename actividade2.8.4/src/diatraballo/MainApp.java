package diatraballo;

/**
 * Este programa calcula o salario dunha semana partindo dunha quenda(dia/noite)
 * e un booleano que indica se se traballa en Domingo, usando na clase WorkingDay
 * @author Xaquin Alves González
 */
public class MainApp {

    public static void main(String[] args) {
        
        char quenda;
        boolean enDomingo;
        double salario = 0;
        
        quenda = 'd';
        enDomingo = true;
        
        //Comproba se se traballa domingo
        if(enDomingo){
            //Crea un WorkingDay a partir da quenda
            WorkingDay diaT = new WorkingDay(quenda,'d',8);
            //Suma a remuneracion do Domingo
            salario = diaT.income();
            diaT.setDay('x');
            //Suma a remuneracion do resto de dias
            for(int i=0;i < 4;i++){
                salario += diaT.income();
            }
        }
        else{
            //Crea un WorkingDay a partir da quenda
            WorkingDay diaT = new WorkingDay(quenda,'x',8);
            //Suma a remuneracion de todos os dias 
            for(int i=0;i < 5;i++){
                salario += diaT.income();
            }
        }
        
        System.out.println("O salario é "+salario+"€");
    }
    
}
