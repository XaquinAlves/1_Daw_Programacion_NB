package padelmanager.view;

import java.util.Scanner;
import padelmanager.controller.InitMenuController;

/**
 * Vista do menu principal en modo texto
 *
 * @author Xaquin Alves González
 */
public class InitMenuView {

    /**
     * Referencia ao controllador
     */
    private InitMenuController controller;

    /**
     * Para instanciar esta clase
     *
     * @param controller referencia ao controlador
     */
    public InitMenuView(InitMenuController controller) {
        this.controller = controller;
    }

    /**
     * Mostra unha mensaxe de crendenciales incorrectas.
     */
    public void showInvalidUser() {
        System.out.println("Usuario ou contrasinal incorrectos");
    }

    /**
     * Mostra o menu de incio de sesión
     *
     * @return true se o usuario quere salir
     */
    public boolean showLoginMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduza o usuario: ");
        String userId = scanner.nextLine();

        if (userId.isEmpty()) {
            return true;
        } else {
            System.out.print("Introduza o contrasinal: ");
            String userPass = new String(System.console().readPassword());
            //String userPass = scanner.nextLine();
            controller.login(userId, userPass);
        }

        return false;
    }
}
