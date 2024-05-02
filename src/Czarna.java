public class Czarna extends Herbata{

    public Czarna(String smak, double zamowienie) {
        super(smak, zamowienie);
        super.setRodzajHerbaty(RodzajHerbaty.CZARNA);
        ustawCene();
    }

    public Czarna(String smak) {
        super(smak);
        super.setRodzajHerbaty(RodzajHerbaty.CZARNA);
        ustawCene();
    }
}
