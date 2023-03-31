public class Firma extends Wpis{
    private String name;
    private Adres address;
    private NrTelefoniczny tel;

    public Firma(String name, Adres address, NrTelefoniczny tel) {
        this.name = name;
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
        System.out.println("Nazwa: " + name);
        address.print();
        tel.print();
    }

}
