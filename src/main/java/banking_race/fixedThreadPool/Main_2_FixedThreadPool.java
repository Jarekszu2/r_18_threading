package banking_race.fixedThreadPool;

import banking_race.KierunekPrzelewu;
// synchronized na metodzie oznacza, że daną metodę może wykonywać co najwyżej 1-en wątek

// uruchomienie programu bez synchronizacji powoduje, że dodanie 400 razy 10 i odjęcie 400 razy 10 może dawać za każdym razem inny wynik
// aby tego uniknąć synchronizujemy metody (działanie to: ustalenie aktualnego stanu konta, rejestracja zmiany, zapisanie stanu po zmianie; może się zdarzyć, że po ustaleniu stanu konta dla jednego wątku, wykona sięzmiana stanu dla drugiego wątku, który dostanie większy priorytet i zostanie zapisane błędne saldo); synchronizacja zapobiegnie wciskaniu się różnych wątków z tą samą metodą np. przelewWychodzący, ale nadal mogą sobie przeszkadzać wątki na różnych metodach
// aby tego uniknąć można zrobić blok dla metod, żeby się wykonywała albo jedna albo druga, ale nie obie jednocześnie (lock - żeby mieć pewność, że się on nie zmieni, tworzę go jako finalny)


public class Main_2_FixedThreadPool {
    public static void main(String[] args) {

        Bank_FixedThreadPool bank = new Bank_FixedThreadPool();
        bank.sprawdzStan();

        for (int i = 0; i < 800; i++) {
            if (i % 2 == 0) {
                bank.dodajZleceniePrzelewu(10, KierunekPrzelewu.PRZYCHODZACY);
            } else {
                bank.dodajZleceniePrzelewu(10, KierunekPrzelewu.WYCHODZACY);
            }
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bank.sprawdzStan();
    }
}
