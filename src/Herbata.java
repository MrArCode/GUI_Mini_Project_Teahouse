import java.util.ArrayList;
import java.util.Map;

abstract class Herbata {
    private RodzajHerbaty rodzajHerbaty;
    private String smak;
    private Cena cena;
    private double zamowienie;

    public Herbata(String smak, double zamowienie) {
        this.smak = smak;
        this.zamowienie = zamowienie;
    }
    public Herbata(String smak) {
        this.smak = smak;
    }

    public void ustawCene (){
        Map<RodzajHerbaty, ArrayList<Herbata>> listaCen = Cennik.listaCen;

        if(listaCen.get(rodzajHerbaty) == null){
            this.cena = new Cena(-1,-1,-1);
        } else {
            for (Herbata herbata: listaCen.get(rodzajHerbaty)) {
                if(herbata.smak.equals(this.smak)){
                    Cena cenaTmp = herbata.getCena();
                    this.cena = new Cena(cenaTmp.getCenaDetaliczna(),cenaTmp.getCenaHurtowa(),cenaTmp.getIloscDoRabatu());
                    break;
                }
            }
        }

    }

    public RodzajHerbaty getRodzajHerbaty() {
        return rodzajHerbaty;
    }

    public void setRodzajHerbaty(RodzajHerbaty rodzajHerbaty) {
        this.rodzajHerbaty = rodzajHerbaty;
    }

    public String getSmak() {
        return smak;
    }

    public void setSmak(String smak) {
        this.smak = smak;
    }

    public Cena getCena() {
        return cena;
    }

    public void setCena(Cena cena) {
        this.cena = cena;
    }

    public double getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(double zamowienie) {
        this.zamowienie = zamowienie;
    }
}
