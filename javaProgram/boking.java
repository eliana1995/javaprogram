public class Booking {
    private String time;
    private String category;
    private String note;

    public Booking(String time, String category, String note) {
        this.time = time;
        this.category = category;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Tid: " + time + ", Kategori: " + category + ", Anteckning: " + note;
    }
}
