public class Zielona extends Herbata{
    public Zielona(String smak, double zamowienie) {
        super(smak, zamowienie);
        super.setRodzajHerbaty(RodzajHerbaty.ZIELONA);
        ustawCene();
    }
    public Zielona(String smak) {
        super(smak);
        super.setRodzajHerbaty(RodzajHerbaty.ZIELONA);
        ustawCene();
    }
}
