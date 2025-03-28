package padelmanager.persistence;

import java.util.ArrayList;
import java.util.Date;
import padelmanager.model.Booking;

/**
 * Esta clase inclúe os métodos para gardar e acceder ás reservas da aplicación
 *
 * @author Xaquin Alves Gonzalez
 */
public class BookingDB {

    /**
     * Devolve todas as reservas dunha data pasada como parametro
     *
     * @param date data a buscar
     * @return lista de resrvas para esa data
     */
    public static ArrayList<Booking> findByDate(Date date) {
        ArrayList<Booking> dateBookings = new ArrayList<>();

        for (Booking booking : PadelManagerDB.getBookings()) {
            if (booking.getDate().compareTo(date) == 0) {
                dateBookings.add(booking);
            }
        }

        return dateBookings;
    }
    
    /**
     * Devolve todas as reservas do xogador pasado que teñan una data igual ou superior
     * a pasada
     * @param date data da reserva
     * @param playerId id do xogador
     * @return lista de reservas;
     */
    public static ArrayList<Booking> findByUserAndDate(Date date, String playerId) {
        ArrayList<Booking> playerDateBookings = new ArrayList<>();
        for (Booking booking : PadelManagerDB.getBookings()) {
            if(booking.containsPlayer(playerId) && booking.getDate().compareTo(date) >= 0){
                playerDateBookings.add(booking);
            }
        }
        return playerDateBookings;
    }

    /**
     * Garda unha reserva
     *
     * @param booking reserva a gardar
     */
    public static void save(Booking booking) {
        PadelManagerDB.getBookings().add(booking);
    }
    
    public static void update(){
        
    }
}
