package padelmanager.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import padelmanager.controller.SessionController;
import padelmanager.model.Booking;
import padelmanager.model.PadelCourt;

/**
 * Vista do menu da sesion
 *
 * @author Xaquin Alves González
 */
public class SessionView {

    /**
     * Referencia ao obxeto controlador
     */
    private SessionController controller;

    /**
     * Para instanciar esta clase
     *
     * @param controller obxeto controlador
     */
    public SessionView(SessionController controller) {
        this.controller = controller;
    }

    /**
     * Amosa o menu da sesion
     *
     * @param bookings reservas do perfil en datas futuras
     */
    public void showSessionMenu(ArrayList<Booking> bookings) {
        Scanner scanner = new Scanner(System.in);

        //mensaxe de benvida
        System.out.println("Benvid@, " + controller.getSessionPlayer().getName());
        //Datos do usuario
        System.out.println("Saldo actual: " + String.valueOf(controller.getSessionPlayer().getBalance()));
        System.out.println("As túas reservas: ");
        for (Booking bk : bookings) {
            System.out.println(bk.getDescription());
        }
        int choice;
        do {
            //Menu de accions
            System.out.println("Que queres facer?");
            System.out.println("1. Crear unha reserva para un partido");
            System.out.println("2. Apuntarme a un partido");
            System.out.println("3. Pechar a sesion");
            //recollemos a escolla
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {//Crear unha reserva
                    Date date = introduceDate(scanner);
                    controller.createBooking(date);
                }
                case 2 -> {//Apuntarse a un partido
                    Date date = introduceDate(scanner);
                    controller.addPlayerToBooking(date);
                }
                case 3 -> {//Sair
                    System.out.println("Ata a vista!");
                }
                default -> {//Opcion non valida
                    System.out.println("Opción non válida");
                }
            }
        } while (choice < 1 || choice > 3);

    }

    private Date introduceDate(Scanner scanner) {
        Date date = null;
        do {
            System.out.println("Introduza unha data: ");
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
            } catch (ParseException ex) {
                System.out.println("Data introducida non valida");
            }
        } while (date == null);

        return date;
    }

    /**
     * Permite ao usuario selecionar pista e hora para unha reserva
     *
     * @param date
     * @param courts
     * @param bookings
     */
    public void selectCourtAndHour(Date date, ArrayList<PadelCourt> courts, ArrayList<Booking> bookings) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Estas son as horas dispoñibles para a data seleccionada: ");
        //Este for recorre as pistas dispoñibles
        for (PadelCourt court : courts) {
            String avaliableHours = "";

            boolean booked = false;
            //Dentro deste for comprobamos se hay reservas para as pistas
            for (Booking booking : bookings) {
                //Se hay unha reserva, gardamos as horas non reservadas
                if (booking.getCourt().getNumber() == court.getNumber()) {
                    for (String bookingHour : court.getBookingHours()) {
                        if (!booking.getHour().equals(bookingHour)) {
                            avaliableHours = avaliableHours.concat(bookingHour + " ");
                        }
                    }
                    //Indica que xa estan gardadas as horas
                    booked = true;
                }
            }
            //Se non hay reservas para a pista, pomos todas as horas
            if (!booked) {
                for (String bookingHour : court.getBookingHours()) {
                    avaliableHours = avaliableHours.concat(bookingHour + " ");
                }
            }

            //Mostramos toda a informacion da pista
            System.out.println("Pista " + court.getNumber() + " ");
            if (court.getType() == PadelCourt.SINGLE) {
                System.out.println("(Individual)");
            }
            System.out.println("Horas dispoñibles: " + avaliableHours);
        }

        PadelCourt selectedCourt = null;
        do {
            //Pedimos a pista ao usuario
            System.out.print("Indica o numero de pista: ");
            int choiceCourt = scanner.nextInt();
            //Obtemos unha referencia a pista seleccionada
            for (PadelCourt court : courts) {
                if (court.getNumber() == choiceCourt) {
                    selectedCourt = court;
                }
            }
            //Se se meteu un numero non valido, avisa e volve a pedilo
            if (selectedCourt == null) {
                System.out.println("Numero de pista non válido");
            }
        } while (selectedCourt == null);
        //Pedimos a hora da reserva ao usuario
        scanner.nextLine();
        System.out.print("Indica unha hora para a reserva: ");
        String choiceHour = scanner.nextLine();
        //Gardamos a reserva
        controller.completeBooking(date, choiceHour, selectedCourt);

    }
}
