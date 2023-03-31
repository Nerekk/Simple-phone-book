import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<NrTelefoniczny, Wpis> myMap = new TreeMap<>();

        Wpis osoba1 = new Osoba("Mariusz", "Pudzianowski", new Adres("Warszawa", "Złota", 44), new NrTelefoniczny(48, 746234192));
        Wpis osoba2 = new Osoba("Andrzej", "Gołota", new Adres("Pruszków", "Zielona", 13), new NrTelefoniczny(42, 645234086));
        Wpis osoba3 = new Osoba("Adam", "Małysz", new Adres("Zakopane", "Biała", 120), new NrTelefoniczny(40, 420975349));

        Wpis firma1 = new Firma("Google", new Adres("Warszawa", "Złota", 14), new NrTelefoniczny(45, 534786567));
        Wpis firma2 = new Firma("Oracle", new Adres("Wrocław", "Czerwona", 52), new NrTelefoniczny(41, 785367123));
        Wpis firma3 = new Firma("Samsung", new Adres("Poznań", "Piękna", 126), new NrTelefoniczny(43, 864268356));

        myMap.put(osoba1.getTel(), osoba1);
        myMap.put(osoba2.getTel(), osoba2);
        myMap.put(osoba3.getTel(), osoba3);
        myMap.put(firma1.getTel(), firma1);
        myMap.put(firma2.getTel(), firma2);
        myMap.put(firma3.getTel(), firma3);

        printMap(myMap);

        Map<NrTelefoniczny, Wpis> uniquemyMap = new TreeMap<>();
        removeDuplicates(uniquemyMap, myMap);

        System.out.println("PO USUNIECIU IDENTYCZNYCH ULIC\n");
        printMap(uniquemyMap);

    }
    public static void printMap(Map<NrTelefoniczny, Wpis> myMap){
        Iterator<Map.Entry<NrTelefoniczny, Wpis>> iter = myMap.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry<NrTelefoniczny, Wpis> entry = iter.next();
            Wpis tempwpis = entry.getValue();
            tempwpis.description();
            System.out.println();
        }
    }
    public static void removeDuplicates(Map<NrTelefoniczny, Wpis> uniquemyMap, Map<NrTelefoniczny, Wpis> myMap) {

        Iterator<Map.Entry<NrTelefoniczny, Wpis>> iter = myMap.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry<NrTelefoniczny, Wpis> entry = iter.next();
            Wpis zewnwpis = entry.getValue();
            String ulica1 = zewnwpis.getAddress().getStreet();
            Iterator<Map.Entry<NrTelefoniczny, Wpis>> iter2 = myMap.entrySet().iterator();
            boolean check = false;
            while (iter2.hasNext())
            {
                Map.Entry<NrTelefoniczny, Wpis> entry2 = iter2.next();
                Wpis wewnwpis = entry2.getValue();
                String ulica2 = wewnwpis.getAddress().getStreet();
                if (!Objects.equals(zewnwpis, wewnwpis) && ulica1.equals(ulica2) && checkmapfindelement(uniquemyMap, wewnwpis))
                {

                    check = true;
                }
            }
            if (!check)
            {
                uniquemyMap.put(zewnwpis.getTel(), zewnwpis);
            }
        }
    }
    public static boolean checkmapfindelement(Map<NrTelefoniczny, Wpis> uniquemyMap, Wpis o) {
        Iterator<Map.Entry<NrTelefoniczny, Wpis>> iter = uniquemyMap.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry<NrTelefoniczny, Wpis> entry = iter.next();
            Wpis tempwpis = entry.getValue();
            if (Objects.equals(tempwpis, o)) return true;
        }
        return false;
    }
}