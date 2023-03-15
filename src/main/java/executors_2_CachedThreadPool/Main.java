package executors_2_CachedThreadPool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService pulaWatkow = Executors.newCachedThreadPool(); // pula wątków, która na żądanie alokuje nowy wątek - jeżeli brakuje zasobów na wykonywanie zadań, których przybywa, pula tworzy dodatkowe wątki
                                                                      // jeżeli nie ma więcej zadań, wątki będą czekać 60 s, a potem się zamykać (nie będą trwać w nieskończoność)
                                                                      // najbardziej optymalne rozwiązanie dla zadań, jeśli nie wiemy dokładnie ile ich jest/będzie

        for (int i = 0; i < 4000; i++) {
            final int finalI = i;
            pulaWatkow.submit(new Runnable() {// zakolejkuj zadanie
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(6));
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
