package biegacze2;

public class MainB2 {
    public static void main(String[] args) {

        Biegacz2[] tabBieg2 = new Biegacz2[5];
        for (int i = 0; i < 5; i++) {
            tabBieg2[i] = new Biegacz2("Zawodnik" + i);
        }

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(tabBieg2[i]);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        boolean czyKtosSkonczyl = false;
        int czasWyscigu = 0;

        while (!czyKtosSkonczyl) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("Przebiegnięty dystans: ");
            for (int i = 0; i < 5; i++) {
                System.out.print(tabBieg2[i].getDystans() + " ");
                if (tabBieg2[i].getDystans() >= 50) {
                    czyKtosSkonczyl = true;
                    czasWyscigu = tabBieg2[i].getTime();
                }
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            tabBieg2[i].zatrzymaj();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Czas wyścigu: " + czasWyscigu);
    }
}
