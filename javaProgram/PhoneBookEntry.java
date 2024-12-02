import java.util.List;

public class PhoneBookEntry {
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private List<String> phoneNumbers;

    public PhoneBookEntry(String firstName, String lastName, int age, String address, List<String> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public void update(String address, List<String> phoneNumbers) {
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Namn: " + firstName + " " + lastName +
               ", Ålder: " + age +
               ", Adress: " + address +
               ", Telefonnummer: " + phoneNumbers;
    }
}
