package com.company;

import com.company.exceptions.AutomatWyjatek;

public class Main {

    public static void main(String[] args) {
        Automat automat = new Automat();
        try {
            System.out.println(automat.wrzucMonete(2.0f));
            System.out.println(automat.wrzucMonete(0.5f));
            automat.wydajKulke();
            System.out.println(automat.zwrocMonete());
        } catch (AutomatWyjatek wyjatek) {
            System.out.println(wyjatek.getMessage());
        }
    }
}
