public class NrTelefoniczny implements Comparable<NrTelefoniczny>{
    private int code;
    private int nrtel;

    public NrTelefoniczny(int code, int nrtel) {
        this.code = code;
        this.nrtel = nrtel;
    }

    @Override
    public int compareTo(NrTelefoniczny o) {
        if (this.nrtel == o.getNrtel() && this.code == o.getCode()) return 0;
        if (this.nrtel > o.getNrtel()) return 1;
        return -1;
    }

    public int getCode() {
        return code;
    }

    public int getNrtel() {
        return nrtel;
    }

    public void print() {
        System.out.println("Numer tel: +" + code + " " + nrtel);
    }

}
