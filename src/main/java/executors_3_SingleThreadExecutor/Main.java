package executors_3_SingleThreadExecutor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService pulaWatkow = Executors.newSingleThreadExecutor(); // tylko jeden wątek - może wykonywać na raz pojedyncze zadanie
                                                                          // zadania będą wykonywane po kolei FIFO
                                                                          // wada - trzeba go zamknąc

        for (int i = 0; i < 3000; i++) {
            final int finalI = i;
            pulaWatkow.submit(new Runnable() {// zakolejkuj zadanie
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(4));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(finalI);
                }
            });
        }

        System.out.println("Koniec.");
    }
}
