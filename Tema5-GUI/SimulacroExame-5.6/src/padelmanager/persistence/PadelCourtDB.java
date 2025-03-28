package padelmanager.persistence;

import java.util.ArrayList;
import padelmanager.model.PadelCourt;

/**
 * Esta clase inclúe o método para acceder ás pistas da aplicación
 * 
 * @author Xaquin Alves González
 */
public class PadelCourtDB {
    /**
     * 
     * @return todas as pistas gardadas na aplicación
     */
    public static ArrayList<PadelCourt> getAllCourts(){
        return PadelManagerDB.getCourts();
    }
}
