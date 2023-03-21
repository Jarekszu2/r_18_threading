package zad3;

import java.util.Random;

public class Child implements Runnable {

    private final static String[] KRZYKI ={ // final static istnieje tylko jedna instancja tej tablicy, gdyby nie było final można by było podmienieć tablicę, gdyby nie było static to każde dziecko miałoby własna kopię tablicy i można by np. podmienić stringi w tablicy, a tak jest tylko jedna i wszystkie referencje odnoszą sie do tej tablicy - optymalizacja
            "Czy to już?",
            "Daleko jeszcze?",
            "Dojechaliśmy?",
            "Mamo kiedy już będziemy?",
            "Jest mi niedobrze!"
    };

    private boolean czyDojechalismy = false;

    public void run() {
        do {
            int los = new Random().nextInt(5); // exclusive <0, 4> == <0,5)

            System.out.println(KRZYKI[los]);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Error, interrupted.");
                break;
            }

        } while (!czyDojechalismy);
    }

    public void dojechalismy() {
        czyDojechalismy = true;
    }
}
