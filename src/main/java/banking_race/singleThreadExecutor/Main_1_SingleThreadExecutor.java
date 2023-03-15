package banking_race.singleThreadExecutor;

import banking_race.KierunekPrzelewu;
import banking_race.singleThreadExecutor.Bank_SingleThreadExecutor;

public class Main_1_SingleThreadExecutor {
    public static void main(String[] args) {

        Bank_SingleThreadExecutor bank = new Bank_SingleThreadExecutor();
        bank.sprawdzStan();

        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                bank.dodajZleceniePrzelewu(10, KierunekPrzelewu.PRZYCHODZACY);
            } else {
                bank.dodajZleceniePrzelewu(10, KierunekPrzelewu.WYCHODZACY);
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bank.sprawdzStan();
    }
}
