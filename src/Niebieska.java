public class Niebieska extends Herbata{
    public Niebieska(String smak, double zamowienie) {
        super(smak, zamowienie);
        super.setRodzajHerbaty(RodzajHerbaty.NIEBIESKA);
        ustawCene();
    }
    public Niebieska(String smak) {
        super(smak);
        super.setRodzajHerbaty(RodzajHerbaty.NIEBIESKA);
        ustawCene();
    }
}
