import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookManager {
    private List<PhoneBookEntry> phoneBook = new ArrayList<>();

    public void menu(Scanner scanner, boolean isAdmin) {
        while (true) {
            System.out.println("\nTelefonbok:");
            System.out.println("1. Lägg till profil");
            System.out.println("2. Visa profiler");
            System.out.println("3. Sök profiler");
            System.out.println("4. Ta bort profil");
            System.out.println("5. Tillbaka till huvudmenyn");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (isAdmin) addEntry(scanner);
                    else System.out.println("Endast administratörer kan lägga till profiler.");
                    break;
                case 2:
                    viewEntries();
                    break;
                case 3:
                    searchEntry(scanner);
                    break;
                case 4:
                    if (isAdmin) deleteEntry(scanner);
                    else System.out.println("Endast administratörer kan ta bort profiler.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }

    private void addEntry(Scanner scanner) {
        System.out.println("Ange förnamn:");
        String firstName = scanner.nextLine();
        System.out.println("Ange efternamn:");
        String lastName = scanner.nextLine();
        System.out.println("Ange ålder:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ange adress:");
        String address = scanner.nextLine();
        System.out.println("Ange telefonnummer (komma-separerade):");
        String[] numbers = scanner.nextLine().split(",");
        List<String> phoneNumbers = List.of(numbers);

        phoneBook.add(new PhoneBookEntry(firstName, lastName, age, address, phoneNumbers));
        System.out.println("Profil tillagd!");
    }

    private void viewEntries() {
        if (phoneBook.isEmpty()) {
            System.out.println("Telefonboken är tom.");
        } else {
            phoneBook.forEach(entry -> System.out.println(entry));
        }
    }

    private void searchEntry(Scanner scanner) {
        System.out.println("Ange efternamn för att söka:");
        String lastName = scanner.nextLine();
        phoneBook.stream()
                 .filter(entry -> entry.getLastName().equalsIgnoreCase(lastName))
                 .forEach(entry -> System.out.println(entry));
    }

    private void deleteEntry(Scanner scanner) {
        System.out.println("Ange efternamn för att ta bort:");
        String lastName = scanner.nextLine();
        phoneBook.removeIf(entry -> entry.getLastName().equalsIgnoreCase(lastName));
        System.out.println("Profil(er) borttagna.");
    }
}
