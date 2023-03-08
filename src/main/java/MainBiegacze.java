public class MainBiegacze {
    public static void main(String[] args) {

        Zadanie[] zadania = new Zadanie[5];
        for (int i = 0; i < zadania.length; i++) {
            zadania[i] = new Zadanie("Zad " + i);
        }

        Thread[] tablicaThreadow = new Thread[5];
        for (int i = 0; i < tablicaThreadow.length; i++) {
            tablicaThreadow[i] = new Thread(zadania[i]);
        }

        for (Thread thread : tablicaThreadow) {
            thread.start();
        }

    }
}
