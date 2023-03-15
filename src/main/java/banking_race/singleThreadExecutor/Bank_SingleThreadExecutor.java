package banking_race.singleThreadExecutor;

import banking_race.KierunekPrzelewu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bank_SingleThreadExecutor {

    private KontoBankowe kontoBankowe = new KontoBankowe();

    private ExecutorService serwer = Executors.newSingleThreadExecutor();

    public void dodajZleceniePrzelewu(double kwota, KierunekPrzelewu kierunekPrzelewu) {
        serwer.submit(new ZleceniePrzelewuSTE(kontoBankowe, kwota, kierunekPrzelewu));
    }

    public void sprawdzStan(){
        System.out.println(kontoBankowe.getStan());
    }
}
