package padelmanager.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import padelmanager.model.Booking;
import padelmanager.model.DoubleBooking;
import padelmanager.model.PadelCourt;
import padelmanager.model.Player;
import padelmanager.model.SingleBooking;
import padelmanager.persistence.BookingDB;
import padelmanager.persistence.PadelCourtDB;
import padelmanager.view.SelectBookingJDialog;
import padelmanager.view.SessionView;

/**
 * Clase controladora do menu de sesion
 *
 * @author Xaquin Alves González
 */
public class SessionController {

    /**
     * Referencia ao obxeto vista
     */
    private SessionView view;
    /**
     * Referencia ao perfil da sesion
     */
    private Player sessionPlayer;

    /**
     * Para instanciar a clase
     *
     * @param sessionPlayer perfil da sesion
     */
    public SessionController(Player sessionPlayer) {
        this.sessionPlayer = sessionPlayer;
        view = new SessionView(this);
    }

    /**
     *
     * @return xogador da sesion
     */
    public Player getSessionPlayer() {
        return sessionPlayer;
    }

    /**
     * Establece un novo xogador da sesión
     *
     * @param sessionPlayer novo xogador da sesion
     */
    public void setSessionPlayer(Player sessionPlayer) {
        this.sessionPlayer = sessionPlayer;
    }

    /**
     * Carga as reservas do usuario e chama a vista para amosar o menu
     */
    public void loadSession() {
        ArrayList<Booking> bookings = BookingDB.findByUserAndDate(Calendar.getInstance().getTime(), sessionPlayer.getId());
        view.showSessionMenu(bookings);
    }

    /**
     * Permite crear unha nova reserva
     *
     * @param date data da reserva
     */
    public void createBooking(Date date) {
        ArrayList<Booking> bookings = BookingDB.findByDate(date);
        ArrayList<PadelCourt> courts = PadelCourtDB.getAllCourts();
        view.selectCourtAndHour(date, courts, bookings);
    }

    /**
     * Crea o obxeto para a reserva
     *
     * @param date fecha da reserva
     * @param hour hora da reserva
     * @param court pista da reserva
     */
    public void completeBooking(Date date, String hour, PadelCourt court) {
        Booking booking;
        //Crea a reserva dependendo do tipo de pista e garda o xogador
        if (court.getType() == PadelCourt.SINGLE) {
            booking = new SingleBooking(date, hour, court);
            ((SingleBooking) booking).addPlayer(sessionPlayer);
        } else {
            booking = new DoubleBooking(date, hour, court);
            ((DoubleBooking) booking).addPlayer(sessionPlayer, 0);
        }

        BookingDB.save(booking);

        loadSession();
    }

    /**
     * Amosa o usuario un dialogo cas reservas as que se pode unir na data pasada como
     * parametro, e permite seleccionar unha para unirse
     *
     * @param date data da resrva
     */
    public void addPlayerToBooking(Date date) {
        //Reservas da data dada como parametro
        ArrayList<Booking> dateBookings = BookingDB.findByDate(date);
        //Quitamos as completas da lista
        for (int i = 0; i < dateBookings.size(); i++) {
            if (dateBookings.get(i).isCompleted()) {
                dateBookings.remove(i);
            }
        }
        //Creamos o diaogo, engadimos as reservas e amosamolo
        SelectBookingJDialog sbDialog = new SelectBookingJDialog(null, true);
        sbDialog.setBookings(dateBookings);
        sbDialog.setVisible(true);

        Booking selectedBooking;
        //Se aceptou o cadro de dialogo
        if (sbDialog.isActionAccepted()) {
            //Obtemos a reserva seleccionada
            selectedBooking = sbDialog.getSelectedBooking();
            int selectedTeam = -1;
            //Comprobamos que o xogador non este xa inscrito nela
            if (!selectedBooking.containsPlayer(sessionPlayer.getId())) {
                //Se a reserva e doble, obtemos o equipo elixido
                if (selectedBooking instanceof DoubleBooking) {
                    selectedTeam = sbDialog.getSelectedTeam();
                    ((DoubleBooking) selectedBooking).addPlayer(sessionPlayer,selectedTeam);
                }
            } else { //Se a reserva e simple
                ((SingleBooking) selectedBooking).addPlayer(sessionPlayer);
            }
        }
        //Actualizamos a BD e recargamos o perfil
        BookingDB.update();
        loadSession();
    }

}
