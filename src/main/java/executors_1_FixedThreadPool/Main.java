package executors_1_FixedThreadPool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService pulaWatkow = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5000; i++) {
            final int finalI = i;
            pulaWatkow.submit(new Runnable() {// zakolejkuj zadanie
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(5));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(finalI);
                }
            });
        }

        System.out.println("Koniec.");
        // wątki dalej czekają na zadania, (trzeba je shut down)
//        pulaWatkow.shutdownNow();
    }
}
