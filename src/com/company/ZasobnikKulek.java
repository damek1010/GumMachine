package com.company;

import com.company.exceptions.ZasobnikWyjatek;

public class ZasobnikKulek {
    private int maxKulek;
    private int liczbaKulek;

    public ZasobnikKulek(int maxKulek) {
        this.maxKulek = maxKulek;
        this.liczbaKulek = maxKulek;
    }

    public int dodajKulkiDoZasobnika(int noweKulki)throws ZasobnikWyjatek {
        if (maxKulek+noweKulki > maxKulek){
            throw new ZasobnikWyjatek("Błąd: dodano za dużo kulek");
        }
        liczbaKulek += noweKulki;
        return liczbaKulek;
    }

    public boolean pobierzKulkeZZasobnika()/*throws ZasobnikWyjatek*/ {
        if (liczbaKulek<=0){
//            throw new ZasobnikWyjatek("Błąd: brak kulek w zasobniku");
            return false;
        }
        liczbaKulek -= 1;
        return true;
    }

    public int wezLiczbeKulek() {
        return this.liczbaKulek;
    }

}
