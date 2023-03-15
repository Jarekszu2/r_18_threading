package executors_4_ScheduledThreadPool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ScheduledExecutorService pulaWatkow = Executors.newScheduledThreadPool(5); // pula wątków, która ma się wykonywać co czas
                                                                                                // zamiast matody submit korzystamy z schedule (ustawiamy przedziały czasowe)

        pulaWatkow.scheduleAtFixedRate(new Runnable() {
                                           public void run() {
                                               System.out.println("Sie ma!");
                                           }
                                       },
                5, // wystartuj po 5s
                2,    // co 2 s wykonuj zadanie
                TimeUnit.SECONDS);

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pulaWatkow.shutdownNow();

        System.out.println("Koniec.");
    }
}
