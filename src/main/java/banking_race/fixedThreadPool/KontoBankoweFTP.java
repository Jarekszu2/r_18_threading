package banking_race.fixedThreadPool;

public class KontoBankoweFTP {

    private double stan;
    private final Object lock = new Object();

    public double getStan() {
        return stan;
    }

    public void przelewWychodzacy(double kwota) {
        synchronized (lock){
            stan = stan - kwota;
        }
    }

    public void przelewPrzychodzacy(double kwota) {
        synchronized (lock) {
            stan = stan + kwota;}
    }
}
