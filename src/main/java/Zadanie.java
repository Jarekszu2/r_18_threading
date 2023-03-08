import java.util.Random;

public class Zadanie implements Runnable {

    private String nazwaZadania; // nadają sobie nazwę zadania/wątku (w konstruktorze)
    private int czasDoOdczekania; // nadaję randomowo zwłokę uruchomienia

    public Zadanie(String nazwaZadania) {
        this.nazwaZadania = nazwaZadania;
        this.czasDoOdczekania = new Random().nextInt(1000) + 1;
    }

    public void run() {
        // to jest metoda, która sie wywyoła kiedy wątek wystartuje
        try {
            Thread.sleep(czasDoOdczekania);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Siema! Jestem " + nazwaZadania + " " + czasDoOdczekania);
    }
}
