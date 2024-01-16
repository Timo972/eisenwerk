package eisenwerk;

public interface Queue {
     // Fuegt x hinten an
     public void enqueue(int x);

     // Entfernt und liefert vorderstes Element
     public int dequeue();

     // Liefert vorderstes Element
     public int head();

     // Testet, ob Schlange leer ist
     public boolean isEmpty();
}