package padelmanager.controller;

import padelmanager.model.PadelCourt;
import padelmanager.model.Player;
import padelmanager.persistence.PadelManagerDB;
import padelmanager.persistence.PlayerDB;
import padelmanager.view.InitMenuView;

/**
 * Clase controladora do menu inicial
 *
 * @author Xaquin Alves González
 */
public class InitMenuController {

    /**
     * Referencia a clase vista
     */
    private InitMenuView view;

    /**
     * Para instanciar esta clase
     */
    public InitMenuController() {
        view = new InitMenuView(this);
    }

    /**
     * Inicia a aplicacion e mantena en execucion ata que o usuario escolle sair
     */
    @SuppressWarnings("empty-statement")
    public void initApp() {
        while (!view.showLoginMenu());
    }

    /**
     * Permite inciar sesion
     *
     * @param playerId id do usuario
     * @param password contrasinal do usuario
     */
    public void login(String playerId, String password) {
        //Buscamos o xogador na BD
        Player player = PlayerDB.findByIdAndPassword(playerId, password);
        if (player != null) { //Se se atopa o xogador inicia sesion
            SessionController sessionController = new SessionController(player);
            sessionController.loadSession();
        } else {//Se non amosa unha mensaxe
            view.showInvalidUser();
        }
    }

    /**
     * Executa a aplicación
     *
     * @param args
     */
    public static void main(String[] args) {
        // Creamos os datos de partida
        Player player1 = new Player("luisf", "abc", "Luis Fdez", 2.5, 25.90);
        Player player2 = new Player("maria", "abc", "Maria Insua", 2.83, 70);
        PadelCourt court1 = new PadelCourt(1, PadelCourt.DOUBLE, new String[]{"9:00", "11:00", "13:00", "16:00"});
        PadelCourt court2 = new PadelCourt(2, PadelCourt.SINGLE, new String[]{"9:00", "11:00", "13:00", "16:00"});
        PadelCourt court3 = new PadelCourt(3, PadelCourt.DOUBLE, new String[]{"9:00", "11:00"});
        // Engadimos os datos á base de datos
        PadelManagerDB.getPlayers().put(player1.getId(), player1);
        PadelManagerDB.getPlayers().put(player2.getId(), player2);
        PadelManagerDB.getCourts().add(court1);
        PadelManagerDB.getCourts().add(court2);
        PadelManagerDB.getCourts().add(court3);
        // Creamos un obxecto InitMenuController para iniciar a aplicacion
        InitMenuController imc = new InitMenuController();
        imc.initApp();
    }
}
