import java.util.ArrayList;
import java.util.List;

public class ListaZakupow {
    public String wlasciciel;
    private List<Herbata> listZakupow = new ArrayList<>();

    public ListaZakupow(String wlasciciel, List listaZakupow) {
        this.wlasciciel = wlasciciel;
        this.listZakupow = listaZakupow;
    }

    public String toString() {
        String answer = "";
        answer += wlasciciel + ":\n";

        if(listZakupow.isEmpty()){
            String empty = wlasciciel + ": --pusto";
            return empty;

        }

        for (Herbata herbata : listZakupow) {
            if(herbata.getCena().getCenaHurtowa() == -1){
                answer += herbata.getRodzajHerbaty() + ", smak: " + herbata.getSmak() +
                        ", ilosc: " + herbata.getZamowienie() + " kg, cena: " + herbata.getCena().getCenaDetaliczna() + "\n";
            } else if (herbata.getZamowienie() > herbata.getCena().getIloscDoRabatu()) {
                answer += herbata.getRodzajHerbaty() + ", smak: " + herbata.getSmak() +
                        ", ilosc: " + herbata.getZamowienie() + " kg, cena: " + herbata.getCena().getCenaHurtowa() + "\n";
            }else{
                answer += herbata.getRodzajHerbaty() + ", smak: " + herbata.getSmak() +
                        ", ilosc: " + herbata.getZamowienie() + " kg, cena: " + herbata.getCena().getCenaDetaliczna() + "\n";
            }
        }
        return answer;
    }


    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public List<Herbata> getListZakupow() {
        return listZakupow;
    }

    public void setListZakupow(List<Herbata> listZakupow) {
        this.listZakupow = listZakupow;
    }
}
