package padelmanager.model;

/**
 * Esta clase representa un xogador de Pádel
 *
 * @author Xaquin Alves González
 */
public class Player {

    /**
     * Identificador do xogador
     */
    private String id;
    /**
     * Contrasinal da conta do xogador
     */
    private String password;
    /**
     * Nome do xogador
     */
    private String name;
    /**
     * Puntuación que indica o nivel do xogador
     */
    private double score;
    /**
     * Saldo de cartos do xogador
     */
    private double balance;

    /**
     * Para instanciar un xogador
     *
     * @param id Identificador do xogador
     * @param password Contrasinal da conta
     * @param name Nome do xogador
     * @param score Puntuación de nivel
     * @param balance Saldo de cartos
     */
    public Player(String id, String password, String name, double score, double balance) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.score = score;
        this.balance = balance;
    }

    /**
     *
     * @return o identificador do xogador
     */
    public String getId() {
        return id;
    }

    /**
     * Establece un novo identificador para o xogador
     *
     * @param id novo identificador do xogador
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     *
     * @return contrasinal da conta
     */
    public String getPassword() {
        return password;
    }
    /**
     * Establece un novo contrasinal da conta
     *
     * @param password novo contrasinal da conta
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     *
     * @return nome do xogador
     */
    public String getName() {
        return name;
    }
    /**
     * Establece un novo nome do xogador
     *
     * @param name novo nome do xogador
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @return puntuacion de nivel do xogador
     */
    public double getScore() {
        return score;
    }
    /**
     * Establece a nova puntuacion de nivel do xogador
     *
     * @param score nova puntuacion de nivel do xogador
     */
    public void setScore(double score) {
        this.score = score;
    }
    /**
     *
     * @return saldo monetario do xogador
     */
    public double getBalance() {
        return balance;
    }
    /**
     * Establece o novo saldo monetario do xogador
     *
     * @param balance novo saldo monetario do xogador
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

}
