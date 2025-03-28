package padelmanager.model;

import java.util.Date;

/**
 * Esta clase representa unha reserva dunha pista dobre
 *
 * @author Xaquin Alves González
 */
public class DoubleBooking extends Booking {

    /**
     * Almacena os dous equipos, con dous xogadores, da reserva
     */
    private Player[][] teams;

    /**
     * Instancia unha reserva dobre
     *
     * @param date data da reserva
     * @param hour hora da reserva
     * @param court pista reservada
     */
    public DoubleBooking(Date date, String hour, PadelCourt court) {
        super(date, hour, court);
        teams = new Player[2][2];
    }

    /**
     *
     * @return array cos equipos da reserva
     */
    public Player[][] getTeams() {
        return teams;
    }

    /**
     * Establece un novo array de equipos para a reserva
     *
     * @param teams novo array de equipos
     */
    public void setTeams(Player[][] teams) {
        this.teams = teams;
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
        for (int i = 0; i < teams.length; i++) {
            for (int j = 0; j < teams[i].length; j++) {
                if (teams[i][j] == null) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Indica se o xogador do que se pasa o id como parametro esta inscrito.
     *
     * @param playerId id do xogador a buscar
     * @return true se esta inscrito, se non false
     */
    @Override
    public boolean containsPlayer(String playerId) {
        for (int i = 0; i < teams.length; i++) {
            for (int j = 0; j < teams[i].length; j++) {
                if (teams[i][j] != null && teams[i][j].getId().equals(playerId)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Devolve un texto cos datos da reserva: se está completa; a data, hora e
     * numero de pista da reserva, equipos e xogadores inscritos;
     *
     * @return texto cos datos da reserva
     */
    @Override
    public String getDescription() {
        String text = super.getDescription() + "\n Xogadores: ";
        for (int i = 0; i < teams.length; i++) {
            text = text.concat("Equipo " + String.valueOf(i + 1) + ": ");
            for (int j = 0; j < teams[i].length; j++) {
                if (teams[i][j] == null) {
                    text = text.concat("PENDENTE ");
                } else {
                    text = text.concat(teams[i][j].getId() + " (" + String.valueOf(teams[i][j].getScore()) + ") ");
                }
            }
        }

        return text;
    }

    /**
     * Coloca o xogador pasado como parametro no primeiro oco libre do equipo
     * indicado
     *
     * @param player xogador a gardar
     * @param teamNumber numero do equipo(0/1)
     */
    public void addPlayer(Player player, int teamNumber) {
        boolean done = false;

        for (int i = 0; i < teams[teamNumber].length && !done; i++) {
            if (teams[teamNumber][i] == null) {
                teams[teamNumber][i] = player;
                done = true;
            }
        }
    }
}
