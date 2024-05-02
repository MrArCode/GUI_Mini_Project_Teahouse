import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cennik {
    public static Map<RodzajHerbaty, ArrayList<Herbata>> listaCen = new HashMap<>();

    public static Cennik pobierzCennik(){
        return new Cennik();
    }

    //metoda dodaj z ceną hurtową i ilością do rabatu
    public void dodaj(RodzajHerbaty rodzajHerbaty, String smak, double cenaDetaliczna, double cenaHurtowa, int iloscDoRabatu){
        if (!listaCen.containsKey(rodzajHerbaty)) {
            ArrayList<Herbata> values = new ArrayList<>();
            Cena cenaTmp = new Cena(cenaDetaliczna,cenaHurtowa,iloscDoRabatu);
            Herbata herbata = switch (rodzajHerbaty){
                case ZIELONA -> new Zielona(smak);
                case NIEBIESKA -> new Niebieska(smak);
                case CZARNA -> new Czarna(smak);
                case CZERWONA -> new Czerwona(smak);
            };
            herbata.setCena(cenaTmp);
            values.add(herbata);
            listaCen.put(rodzajHerbaty, values);
        } else {
            ArrayList<Herbata> existingValues = listaCen.get(rodzajHerbaty);
            Cena cenaTmp = new Cena(cenaDetaliczna,cenaHurtowa,iloscDoRabatu);
            Herbata herbata = switch (rodzajHerbaty){
                case ZIELONA -> new Zielona(smak);
                case NIEBIESKA -> new Niebieska(smak);
                case CZARNA -> new Czarna(smak);
                case CZERWONA -> new Czerwona(smak);
            };
            herbata.setCena(cenaTmp);
            existingValues.add(herbata);
        }
    }

    //metoda dodaj bez ceny hurtowej, wtedy cena hurotwa i ilosc do rabatu wynoszą -1
    public void dodaj(RodzajHerbaty rodzajHerbaty, String smak, double cenaDetaliczna) {
        if (!listaCen.containsKey(rodzajHerbaty)) {
            ArrayList<Herbata> values = new ArrayList<>();
            Cena cenaTmp = new Cena(cenaDetaliczna,-1,-1);
            Herbata herbata = switch (rodzajHerbaty){
                case ZIELONA -> new Zielona(smak);
                case NIEBIESKA -> new Niebieska(smak);
                case CZARNA -> new Czarna(smak);
                case CZERWONA -> new Czerwona(smak);
            };
            herbata.setCena(cenaTmp);
            values.add(herbata);
            listaCen.put(rodzajHerbaty, values);
        } else {
            ArrayList<Herbata> existingValues = listaCen.get(rodzajHerbaty);
            Cena cenaTmp = new Cena(cenaDetaliczna,-1,-1);
            Herbata herbata = switch (rodzajHerbaty){
                case ZIELONA -> new Zielona(smak);
                case NIEBIESKA -> new Niebieska(smak);
                case CZARNA -> new Czarna(smak);
                case CZERWONA -> new Czerwona(smak);
            };
            herbata.setCena(cenaTmp);
            existingValues.add(herbata);
        }
    }
}
