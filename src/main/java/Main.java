public class Main {
    public static void main(String[] args) {

        Thread[] tablicaThredow = new Thread[5];

        for (int i = 0; i < tablicaThredow.length; i++) {
            tablicaThredow[i] = new Thread(new Zadanie("Wątek " + i));
        }
        for (Thread thread : tablicaThredow) {
            thread.start();
        }

        System.out.println("Koniec");
    }
}
