package banking_race.fixedThreadPool;

import banking_race.KierunekPrzelewu;
public class ZleceniePrzelewuFTP implements Runnable{

    private KontoBankoweFTP kontoBankowe;
    private double kwota;
    private KierunekPrzelewu kierunekPrzelewu;

    public ZleceniePrzelewuFTP(KontoBankoweFTP kontoBankowe, double kwota, KierunekPrzelewu kierunekPrzelewu) {
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
