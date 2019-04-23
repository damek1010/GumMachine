package com.company;

import com.company.exceptions.AutomatWyjatek;

import java.util.Random;

public class Automat {
    private float moneta;
    private boolean czyJestMoneta;
    private ZasobnikKulek zasobnik;
    private float cenaKulki;

    public Automat() {
        this.moneta = 0.0f;
        this.czyJestMoneta = false;
        this.zasobnik = new ZasobnikKulek(100);
        this.cenaKulki = 1.0f;
    }

    public boolean wrzucMonete(float moneta) throws AutomatWyjatek {
        if (this.czyJestMoneta) return false;
        if (zasobnik.wezLiczbeKulek() <= 0) throw new AutomatWyjatek("Nie ma kulek w automacie");
        if (moneta == 0.1 || moneta == 0.2 || moneta == 0.5 || moneta == 1.0 || moneta == 2.0) {
            Random gen = new Random();
            if (gen.nextBoolean()) {
                this.moneta = moneta;
                this.czyJestMoneta = true;
                return true;
            }
        }
        return false;
    }

    public void wydajKulke() throws AutomatWyjatek {
        if (!zasobnik.pobierzKulkeZZasobnika()) {
            throw new AutomatWyjatek("Nie ma kulek w zasobniku :(");
        }
        if (this.moneta < this.cenaKulki) {
            throw new AutomatWyjatek("Nie stac Cie na te kulki frajerze");
        }
        this.moneta -= this.cenaKulki;
    }

    public float zwrocMonete() throws AutomatWyjatek {
        if (!this.czyJestMoneta) {
            throw new AutomatWyjatek("Nie ma monety. Nie oszukasz nas cawniaczku ;)");
        }
        float tmp = this.moneta;
        this.moneta = 0.0f;
        this.czyJestMoneta = false;
        return tmp;
    }
}
