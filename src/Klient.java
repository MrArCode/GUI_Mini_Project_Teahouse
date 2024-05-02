import java.util.ArrayList;

public class Klient {
    private String imie;
    private double portfel;
    private ListaZakupow listaZakupow;
    private Koszyk koszyk;

    public Klient(String imie, int budzet) {
        this.imie = imie;
        this.portfel = budzet;
        this.listaZakupow = new ListaZakupow(imie, new ArrayList<>());
        this.koszyk = new Koszyk(imie, new ArrayList<>());

    }

    public void dodaj(Herbata herbata) {
        listaZakupow.getListZakupow().add(herbata);
    }

    public ListaZakupow pobierzListeZakupow() {
        return listaZakupow;
    }

    public Koszyk pobierzKoszyk() {
        return koszyk;
    }

    public void przepakuj() {
        ArrayList<Herbata> nowaListaZakupow = new ArrayList<>();
        ArrayList<Herbata> nowyKoszyk = new ArrayList<>();

        for (Herbata herbata : listaZakupow.getListZakupow()) {
            if (herbata.getCena().getCenaDetaliczna() != -1) {
                nowyKoszyk.add(herbata);
            } else {
                nowaListaZakupow.add(herbata);
            }
        }
        listaZakupow.setListZakupow(nowaListaZakupow);
        koszyk.setListZakupow(nowyKoszyk);
    }

    public void zaplac(SposobPlatnosci sposobPlatnosci) {
        double wartoscZamowienia = 0;
        ArrayList<Herbata> ewntualnieNowaLista = new ArrayList<>();

        for (Herbata herbata : koszyk.getListZakupow()) {
            if (herbata.getCena().getCenaHurtowa() == -1) {
                wartoscZamowienia += herbata.getCena().getCenaDetaliczna() * herbata.getZamowienie();
            } else if (herbata.getZamowienie() > herbata.getCena().getIloscDoRabatu()) {
                wartoscZamowienia = herbata.getCena().getCenaHurtowa() * herbata.getZamowienie();
            } else {
                wartoscZamowienia += herbata.getCena().getCenaDetaliczna() * herbata.getZamowienie();
            }
        }

        if (portfel < wartoscZamowienia) {
            for (int i = 0; i < koszyk.getListZakupow().size(); i++) {
                Herbata herbata = koszyk.getListZakupow().get(i);
                int ileRazy = ((int) herbata.getZamowienie()) * 2;
                double wlasciwaCenaTmp = 0;
                int counter = 0;

                if (herbata.getCena().getCenaHurtowa() == -1) {
                    wlasciwaCenaTmp = herbata.getCena().getCenaDetaliczna();
                } else if (herbata.getZamowienie() > herbata.getCena().getIloscDoRabatu()) {
                    wlasciwaCenaTmp = herbata.getCena().getCenaHurtowa();
                } else {
                    wlasciwaCenaTmp = herbata.getCena().getCenaDetaliczna();
                }
                for (int j = 0; j < ileRazy; j++) {
                    if (portfel > wartoscZamowienia) {
                        break;
                    }
                    wartoscZamowienia -= (wlasciwaCenaTmp / 2);
                    counter++;

                }
                koszyk.getListZakupow().get(i).setZamowienie(counter * 0.5);
                counter = 0;
            }


        } else {
            koszyk.setListZakupow(new ArrayList<>());
        }

        for (Herbata herbat : koszyk.getListZakupow()) {
            if (herbat.getZamowienie() != 0) {
                ewntualnieNowaLista.add(herbat);
            }
        }


        double prowizja = wartoscZamowienia * 0.01;

        switch (sposobPlatnosci) {
            case KARTA -> wartoscZamowienia += prowizja;
        }


        koszyk.setListZakupow(ewntualnieNowaLista);
        portfel = portfel - wartoscZamowienia;

    }

    public void zwroc(RodzajHerbaty rodzajHerbaty, String smak, double ilosc) {
        Herbata herbata = switch (rodzajHerbaty) {
            case CZARNA -> new Czarna(smak, ilosc);
            case ZIELONA -> new Zielona(smak, ilosc);
            case CZERWONA -> new Czerwona(smak,ilosc);
            case NIEBIESKA -> new Niebieska(smak,ilosc);
        };

        double kwotaDoZwrotu = 0;
        koszyk.getListZakupow().add(herbata);
        if (herbata.getCena().getCenaHurtowa() == -1) {
            kwotaDoZwrotu = herbata.getCena().getCenaDetaliczna() * ilosc;
        } else if (herbata.getZamowienie() > herbata.getCena().getIloscDoRabatu()) {
            kwotaDoZwrotu = herbata.getCena().getCenaHurtowa() * ilosc;
        } else {
            kwotaDoZwrotu = herbata.getCena().getCenaDetaliczna() * ilosc;
        }
        portfel += kwotaDoZwrotu;

    }


    public double pobierzPortfel() {
        return portfel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public double getPortfel() {
        return portfel;
    }

    public void setPortfel(double portfel) {
        this.portfel = portfel;
    }

    public ListaZakupow getListaZakupow() {
        return listaZakupow;
    }

    public void setListaZakupow(ListaZakupow listaZakupow) {
        this.listaZakupow = listaZakupow;
    }

    public Koszyk getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(Koszyk koszyk) {
        this.koszyk = koszyk;
    }
}
