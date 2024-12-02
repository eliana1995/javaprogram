import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBookManager phoneBookManager = new PhoneBookManager();
        BookingManager bookingManager = new BookingManager();

        System.out.println("Välkommen till Telefonbok och Bokningssystem!");
        System.out.println("Logga in som: 1. Gäst  2. Admin");
        int role = scanner.nextInt();
        scanner.nextLine(); // Ta bort newline

        boolean isAdmin = (role == 2);

        while (true) {
            System.out.println("\nHuvudmeny:");
            System.out.println("1. Telefonbok");
            System.out.println("2. Bokningssystem");
            System.out.println("3. Avsluta");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    phoneBookManager.menu(scanner, isAdmin);
                    break;
                case 2:
                    bookingManager.menu(scanner, isAdmin);
                    break;
                case 3:
                    System.out.println("Avslutar programmet. Tack för att du använde systemet!");
                    return;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }
}
