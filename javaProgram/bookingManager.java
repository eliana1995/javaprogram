import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();

    public void menu(Scanner scanner, boolean isAdmin) {
        while (true) {
            System.out.println("\nBokningssystem:");
            System.out.println("1. Lägg till bokning");
            System.out.println("2. Visa bokningar");
            System.out.println("3. Tillbaka till huvudmenyn");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBooking(scanner);
                    break;
                case 2:
                    viewBookings();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }

    private void addBooking(Scanner scanner) {
        System.out.println("Ange tid:");
        String time = scanner.nextLine();
        System.out.println("Ange kategori:");
        String category = scanner.nextLine();
        System.out.println("Ange anteckning:");
        String note = scanner.nextLine();

        bookings.add(new Booking(time, category, note));
        System.out.println("Bokning tillagd!");
    }

    private void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("Inga bokningar tillgängliga.");
        } else {
            bookings.forEach(booking -> System.out.println(booking));
        }
    }
}
