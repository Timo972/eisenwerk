package eisenwerk;

public class QueueInt

        implements Queue {
    private int[] array; // Array fuer Schlangenelemente

    private int count; // Anzahl Elemente in Schlange

    public QueueInt(int N) { // Konstruktor fuer leere Schlange
        array = new int[N]; // besorge Platz fuer N Objekte
        count = 0; // initialisiere Anzahl
    }

    private boolean full() { // Testet, ob Schlange voll ist
        return count == array.length; // Anzahl gleich Arraylaenge?
    }

    public boolean isEmpty() { // Testet, ob Schlange leer ist
        return count == 0; // Anzahl gleich 0?
    }

    public void enqueue(int x) { // Fuegt x hinten ein
        if (full())
            throw new RuntimeException("in ArraySchlange.anhaengen");
        array[count] = x; // Element einfuegen
        count++; // Anzahl inkrementieren
    }

    public int dequeue() { // Entfernt vorderstes Element
        if (isEmpty())
            throw new RuntimeException("in ArraySchlange.entnehmen");
        int hilfe = array[0];
        for (int i = 0; i < count - 1; i++)
            array[i] = array[i + 1]; // ruecke die Inhalte der Schlange
        // um je eine Position vor
        array[count - 1] = 0; // setze ueberzaehliges Element
        // auf den Wert null
        count--; // aktualisiere die Anzahl der Elemente

        return hilfe;
    }

    public int head() { // Liefert Element,
        if (isEmpty())
            throw new RuntimeException("in ArraySchlange.inhaltGeben");
        return array[0]; // welches am Anfang-Index steht
    }
}