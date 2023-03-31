public class Adres {
    private String city;
    private String street;
    private int nr;

    public Adres(String city, String street, int nr) {
        this.city = city;
        this.street = street;
        this.nr = nr;
    }
    public String getStreet() {
        return street;
    }
    public void print() {
        System.out.println("Adres: " + city + " " + street + " " + nr);
    }
}
