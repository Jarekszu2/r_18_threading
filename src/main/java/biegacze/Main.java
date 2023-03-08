package biegacze;

public class Main {
    public static void main(String[] args) {

        Biegacz[] biegaczs = new Biegacz[5];
        for (int i = 0; i < biegaczs.length; i++) {
            biegaczs[i] = new Biegacz("Biegacz" + i);
        }

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(biegaczs[i]);
        }

        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }

        boolean czyKtosSkonczyl = false;

        while (!czyKtosSkonczyl) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("Biegacze przebiegli:");
            for (int i = 0; i < 5; i++) {
                System.out.print(biegaczs[i].getDystans() + " ");
                if (biegaczs[i].getDystans() >= 100) {
                    czyKtosSkonczyl = true;
                }
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            threads[i].interrupt();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
