public class Osoba extends Wpis{
    private String name;
    private String surname;
    private Adres address;
    private NrTelefoniczny tel;

    public Osoba(String name, String surname, Adres address, NrTelefoniczny tel) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.tel = tel;
    }
    public NrTelefoniczny getTel() {
        return tel;
    }
    public Adres getAddress() {
        return address;
    }
    @Override
    public void description() {
        System.out.println("Imie: " + name + "\nNazwisko: " + surname);
        address.print();
        tel.print();
    }


}
