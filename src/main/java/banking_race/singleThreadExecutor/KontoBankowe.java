package banking_race.singleThreadExecutor;

public class KontoBankowe {

    private double stan;

    public double getStan() {
        return stan;
    }

    public void przelewWychodzacy(double kwota) {
        stan = stan - kwota;
    }

    public void przelewPrzychodzacy(double kwota) {
        stan = stan + kwota;
    }
}
