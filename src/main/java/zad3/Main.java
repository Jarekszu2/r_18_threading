package zad3;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ExecutorService pula = Executors.newCachedThreadPool();

        Child[] childrens = new Child[5];

        for (int i = 0; i < 5; i++) {
            childrens[i] = new Child();
            pula.submit(childrens[i]); // przekaż zadanie do wykonania
        }

        int stoppedChildren = 0;

        Scanner scanner = new Scanner(System.in);
        do {
            String linia = scanner.nextLine();
            if (linia.contains("s")){ // s + Enter
                childrens[stoppedChildren++].dojechalismy();
                System.err.println("Zatrzymuję: " + (stoppedChildren - 1));
//                childrens[stoppedChildren].dojechalismy();
//                System.err.println("Zatrzymuje: " + (stoppedChildren));
//                stoppedChildren++;
            } else {
                System.err.println("buka: " + linia);
            }
        } while ((stoppedChildren < childrens.length));
/**
 * Jeżeli nasz wątek chce poczekać na zakończenie czyjejś pracy, to robimy join() - wątek czeka na zakończenie pracy i kontynuuje po zakończeniu.
 *
 * Zaleta puli wątków: w przypadku tworzenia wątków przez Thread, wątek wykonuje jakieś zadanie i po jakimś czasie (60 s?)
 * ginie (albo go specjalnie podtrzymujemy przy zyciu); w przypadku puli wątki żyją dłużej (można je wskrzesić gdy sa potrzebne) lub dla puli Fixed żyją cały czas.
 *
 * Wątek to nie to samo co zadanie. Pula uruchamia wątki, do których z kolejki trafiają przekazywane zadania; po wykonaniu (przerwaniu) zadania, program się nie wyłącza, bo wątki czekają
 * na kolejne zadania; dopiero shut down zamyka program.
 */
        try {
            pula.awaitTermination(10, TimeUnit.SECONDS); // robi to samo co join
        } catch (InterruptedException e) {
            System.err.println("Nie doczekałem się zatrzymania pracy puli.");
        }

        System.out.println("Nareszcie.");
    }
}
