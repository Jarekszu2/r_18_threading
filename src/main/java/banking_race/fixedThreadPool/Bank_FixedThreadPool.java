package banking_race.fixedThreadPool;

import banking_race.KierunekPrzelewu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bank_FixedThreadPool {

    private KontoBankoweFTP kontoBankoweFTP = new KontoBankoweFTP();

    private ExecutorService serwer = Executors.newFixedThreadPool(5);

    public void dodajZleceniePrzelewu(double kwota, KierunekPrzelewu kierunekPrzelewu) {
        serwer.submit(new ZleceniePrzelewuFTP(kontoBankoweFTP, kwota, kierunekPrzelewu));
    }

    public void sprawdzStan(){
        System.out.println(kontoBankoweFTP.getStan());
    }
}
