package padelmanager.model;

/**
 * Esta clase reprensenta unha pista de padel, que pode ser individual ou dobre
 *
 * @author Xaquin Alves González
 */
public class PadelCourt {

    /**
     * Numero que identifica a pista
     */
    private int number;
    /**
     * Tipo de pista (individual ou dobre)
     */
    private int type;
    /**
     * Lista de horas nas que a pista esta dispoñible (hh:mm)
     */
    private String[] bookingHours;
    /**
     * Constante que garda o valor do tipo de pista individual
     */
    public static final int SINGLE = 1;
    /**
     * Constante que garda o valor do tipo de pista dobre
     */
    public static final int DOUBLE = 2;

    /**
     * Para instanciar unha pista de padel
     *
     * @param number numero de pista
     * @param type tipo de pista
     * @param bookingHours horas dispoñibles
     */
    public PadelCourt(int number, int type, String[] bookingHours) {
        this.number = number;
        this.type = type;
        this.bookingHours = bookingHours;
    }

    /**
     *
     * @return numero da pista
     */
    public int getNumber() {
        return number;
    }

    /**
     * Establece un novo numero de pista
     *
     * @param number novo numero de pista
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *
     * @return tipo de pista
     */
    public int getType() {
        return type;
    }
    /**
     * Establece un novo tipo de pista
     *
     * @param type novo tipo de pista
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     *
     * @return array de horas dispoñibles
     */
    public String[] getBookingHours() {
        return bookingHours;
    }
    /**
     * Establece un novo array de horas dispoñibles
     *
     * @param bookingHours novo array de horas dispoñibles
     */
    public void setBookingHours(String[] bookingHours) {
        this.bookingHours = bookingHours;
    }

}
