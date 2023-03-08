package biegacze2;

import java.util.Random;

public class Biegacz2 implements Runnable {

    private String imie;
    private long dystans = 0;
    private boolean czyBiegnie = true;
    int time = 0;

    public Biegacz2(String imie) {
        this.imie = imie;
    }

    public String getImie() {
        return imie;
    }

    public long getDystans() {
        return dystans;
    }

    public int getTime() {
        return time;
    }

    public boolean zatrzymaj() {
        return czyBiegnie = false;
    }

    public void run() {
        while (czyBiegnie) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int dystansKtoryPrzebieglemWTymObiegu = new Random().nextInt(10) + 1;

            System.out.println(imie + " przebiegłem " + dystansKtoryPrzebieglemWTymObiegu);

            dystans += dystansKtoryPrzebieglemWTymObiegu;

            time++;
        }
    }
}
