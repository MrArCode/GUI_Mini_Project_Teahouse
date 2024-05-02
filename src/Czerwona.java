public class Czerwona extends Herbata{
    public Czerwona(String smak, double zamowienie) {
        super(smak, zamowienie);
        super.setRodzajHerbaty(RodzajHerbaty.CZERWONA);
        ustawCene();
    }
    public Czerwona(String smak) {
        super(smak);
        super.setRodzajHerbaty(RodzajHerbaty.CZERWONA);
        ustawCene();
    }
}
