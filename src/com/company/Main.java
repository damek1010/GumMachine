package com.company;

import com.company.exceptions.AutomatWyjatek;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        int choice;
        float coin;
        Automat automat = new Automat();

        while(true) {
            System.out.println("Wybierz co chcesz zrobić zgodnie z podanym menu (wpisz cyfrę).\n");
            System.out.println("1. Wrzuć monetę\n");
            System.out.println("2. Pobierz kulkę\n");
            System.out.println("3. Odbierz resztę\n");
            System.out.println("4. Wyjdź\n");

            try {
                choice = input.nextInt();
                if(choice==1) {
                    System.out.println("Podaj nominał:\n");
                    coin = input.nextFloat();
                    System.out.println(automat.wrzucMonete(coin));
                }
                else if(choice==2) {
                    automat.wydajKulke();
                }
                else if(choice==3) {
                    System.out.println(automat.zwrocMonete());
                }
                else {
                    break;
                }

            } catch (AutomatWyjatek wyjatek) {
                System.out.println(wyjatek.getMessage());
            }
        }
    }
}
