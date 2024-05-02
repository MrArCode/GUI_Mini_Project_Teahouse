public class Cena {
    private double cenaDetaliczna;
    private double cenaHurtowa;
    private double iloscDoRabatu;

    public Cena(double cenaDetaliczna, double cenaHurtowa, double iloscDoRabatu) {
        this.cenaDetaliczna = cenaDetaliczna;
        this.cenaHurtowa = cenaHurtowa;
        this.iloscDoRabatu = iloscDoRabatu;
    }

    public double getCenaDetaliczna() {
        return cenaDetaliczna;
    }

    public void setCenaDetaliczna(double cenaDetaliczna) {
        this.cenaDetaliczna = cenaDetaliczna;
    }

    public double getCenaHurtowa() {
        return cenaHurtowa;
    }

    public void setCenaHurtowa(double cenaHurtowa) {
        this.cenaHurtowa = cenaHurtowa;
    }

    public double getIloscDoRabatu() {
        return iloscDoRabatu;
    }

    public void setIloscDoRabatu(double iloscDoRabatu) {
        this.iloscDoRabatu = iloscDoRabatu;
    }
}
