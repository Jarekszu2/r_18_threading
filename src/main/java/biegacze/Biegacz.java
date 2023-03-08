package biegacze;

import java.util.Random;

public class Biegacz implements Runnable {

    private String imie;
    private long dystans = 0;

    public Biegacz(String imie) {
        this.imie = imie;
    }

    public long getDystans() {
        return dystans;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                e.printStackTrace(); // zamiast drukowania stosu przerywamy działanie
                break;
            }
            int dystansKtoryPrzebieglemWTymObiegu = new Random().nextInt(10) + 1;

            System.out.println(imie + " przebiegłem " + dystansKtoryPrzebieglemWTymObiegu);

            dystans += dystansKtoryPrzebieglemWTymObiegu;
        }



    }
}
