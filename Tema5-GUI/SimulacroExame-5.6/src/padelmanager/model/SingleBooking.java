package padelmanager.model;

import java.util.Date;

/**
 * Esta clase representa unha reserva para unha pista individual
 *
 * @author Xaquin Alves González
 */
public class SingleBooking extends Booking {

    /**
     * Almacena os dous xogadores da reserva
     */
    private Player[] players;

    /**
     * Para instanciar unha reserva individual
     *
     * @param date data da reserva
     * @param hour hora da resreva
     * @param court pista reservada
     */
    public SingleBooking(Date date, String hour, PadelCourt court) {
        super(date, hour, court);
        players = new Player[2];
    }

    /**
     *
     * @return o array cos xogadores inscritos
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Establece un novo array de xogadores inscritos
     *
     * @param players novo array de xogadores inscritos
     */
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     * Devolve o que tera que pagar cada xogador que se inscriba na resrva
     *
     * @return precio por xogador
     */
    @Override
    public double getPrice() {
        return 0;
    }

    /**
     * Indica se a reserva esta completa
     *
     * @return true se esta completa, se non false
     */
    @Override
    public boolean isCompleted() {
        return !(players[0] == null || players[1] == null);
    }

    /**
     * Indica se o xogador do que se pasa o id como parametro esta inscrito.
     *
     * @param playerId id do xogador a buscar
     * @return true se esta inscrito, se non false
     */
    @Override
    public boolean containsPlayer(String playerId) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null && players[i].getId().equals(playerId)){
                return true;
            }       
        }
        
        return false;
    }

    /**
     * Devolve un texto cos datos da reserva: se está completa; a data, hora e
     * numero de pista da reserva e xogadores inscritos
     *
     * @return texto cos datos da reserva
     */
    @Override
    public String getDescription() {
        String text = super.getDescription() + "\n Xogadores: ";

        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                text = text.concat("PENDENTE ");
            } else {
                text = text.concat(players[i].getId() + " (" + String.valueOf(players[i].getScore()) + ") ");
            }
        }

        return text;
    }

    /**
     * Engade un xogador a reserva
     *
     * @param player xogador a engadir
     */
    public void addPlayer(Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = player;
            }
        }
    }

}
