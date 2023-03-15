package banking_race.singleThreadExecutor;

import banking_race.KierunekPrzelewu;
import banking_race.fixedThreadPool.KontoBankoweFTP;
import banking_race.singleThreadExecutor.KontoBankowe;

public class ZleceniePrzelewuSTE implements Runnable {
    private KontoBankowe kontoBankowe;
    private double kwota;
    private KierunekPrzelewu kierunekPrzelewu;

    public ZleceniePrzelewuSTE(KontoBankowe kontoBankowe, double kwota, KierunekPrzelewu kierunekPrzelewu) {
        this.kontoBankowe = kontoBankowe;
        this.kwota = kwota;
        this.kierunekPrzelewu = kierunekPrzelewu;
    }

    public void run() {
        if (kierunekPrzelewu == KierunekPrzelewu.WYCHODZACY) {
            kontoBankowe.przelewWychodzacy(kwota);
        } else {
            kontoBankowe.przelewPrzychodzacy(kwota);
        }
    }
}
