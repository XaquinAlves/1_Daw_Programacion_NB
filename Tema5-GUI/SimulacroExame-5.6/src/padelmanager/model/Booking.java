package padelmanager.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Esta clase representa unha reserva, que sera instanciada en duas subclases
 * dependendo de se é un reserva individual ou dobr
 *
 * @author Xaquin Alves González
 */
public abstract class Booking {

    /**
     * Data da reserva
     */
    protected Date date;
    /**
     * Hora da reserva (hh:mm)
     */
    protected String hour;
    /**
     * Pista reservada
     */
    protected PadelCourt court;

    /**
     * Usado polas subclases, para crear unha instancia delas
     *
     * @param date Data da reserva
     * @param hour Hora da reserva
     * @param court Pista reservada
     */
    public Booking(Date date, String hour, PadelCourt court) {
        this.date = date;
        this.hour = hour;
        this.court = court;
    }

    /**
     *
     * @return data da reserva
     */
    public Date getDate() {
        return date;
    }

    /**
     * Establece unha nova data da reserva
     *
     * @param date nova data da reserva
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return hora da reserva
     */
    public String getHour() {
        return hour;
    }
    /**
     * Establece unha nova hora da reserva
     *
     * @param hour nova hora da reserva
     */
    public void setHour(String hour) {
        this.hour = hour;
    }

    /**
     *
     * @return pista da reserva
     */
    public PadelCourt getCourt() {
        return court;
    }
    /**
     * Establece unha nova pista da reserva
     *
     * @param court nova pista da reserva
     */
    public void setCourt(PadelCourt court) {
        this.court = court;
    }

    /**
     * Devolve o que tera que pagar cada xogador que se inscriba na resrva
     *
     * @return precio por xogador
     */
    public abstract double getPrice();

    /**
     * Indica se a reserva esta completa
     *
     * @return true se esta completa, se non false
     */
    public abstract boolean isCompleted();

    /**
     * Indica se o xogador do que se pasa o id como parametro esta inscrito.
     *
     * @param playerId id do xogador a buscar
     * @return true se esta inscrito, se non false
     */
    public abstract boolean containsPlayer(String playerId);

    /**
     * Devolve un texto cos datos da reserva: se está completa; a data, hora e
     * numero de pista da reserva.
     *
     * @return texto cos datos da reserva
     */
    public String getDescription() {
        //Engadimos a primeira linea que indica se esta completa
        String text = "Reserva ";
        if (isCompleted()) {
            text = text.concat("completa:\n");
        } else {
            text = text.concat("pendente:\n");
        }
        //Engadimos a segunda linea coa data, hora e pista
        text = text.concat("Data: " + new SimpleDateFormat("dd/MM/yyyy").format(date) + " ");
        text = text.concat("Hora: " + hour + " Pista: " + String.valueOf(court.getNumber()));
        //Devolvemos o resultado
        return text;
    }
}
