package padelmanager.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import padelmanager.model.Booking;
import padelmanager.model.PadelCourt;
import padelmanager.model.Player;

/**
 * Esta clase mantén as estruturas dinámicas que almacenan todos os obxectos da
 * aplicación
 *
 * @author Xaquin Alves Gonzalez
 */
public class PadelManagerDB {

    /**
     * Persistencia dos xogadores
     */
    private static HashMap<String, Player> players = new HashMap<>();
    /**
     * Persistencia das pistas
     */
    private static ArrayList<PadelCourt> courts = new ArrayList<>();
    /**
     * Persistencia das reservas
     */
    private static ArrayList<Booking> bookings = new ArrayList<>();

    /**
     *
     * @return HashMap cos xogadores gardados
     */
    public static HashMap<String, Player> getPlayers() {
        return players;
    }

    /**
     *
     * @return ArrayList coas pistas gardadas
     */
    public static ArrayList<PadelCourt> getCourts() {
        return courts;
    }

    /**
     *
     * @return ArrayList coas reservas gardadas
     */
    public static ArrayList<Booking> getBookings() {
        return bookings;
    }

}
