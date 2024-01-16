package eisenwerk;

import java.util.Arrays;
import java.util.Scanner;

public class Bahnhof {
    private Gleis gleis1;
    private Gleis gleis2;
    private Gleis gleis3;

    public Bahnhof(Gleis gleis1, Gleis gleis2, Gleis gleis3) {
        this.gleis1 = gleis1;
        this.gleis2 = gleis2;
        this.gleis3 = gleis3;
    }

    public Queue sortieren(int[] reihenfolge) {

        Queue x = new QueueInt(reihenfolge.length);

        Arrays.sort(reihenfolge);

        for (int i = 0; i < reihenfolge.length; i++) {
            x.enqueue(reihenfolge[i]);
        }

        return x;
    }

    public void rangieren() {
        int[] reihenfolge = reihenfolge();
        einfahren(reihenfolge, this.gleis1.Stapel);
        Queue sortiert = sortieren(reihenfolge);
        int aktuelle;

        while (!sortiert.isEmpty()) {
            aktuelle = (int) sortiert.dequeue();
            verschieben(gleis1, gleis2, gleis3, aktuelle);
        }
    }

    void verschieben(Gleis gleis1, Gleis gleis2, Gleis gleis3, int nr) {
        if (gleis1.Stapel.hasItem(nr)) {
            while (gleis1.Stapel.top() != nr) {
                gleis2.Stapel.push(gleis1.Stapel.pop());
                System.out.println("Dieser Waggon wird von Gleis 1 auf Gleis 2 verschoben: " + gleis2.Stapel.top());
            }
            gleis3.Stapel.push(gleis1.Stapel.pop());
            System.out.println("Dieser Waggon wird von Gleis 1 auf Gleis 3 verschoben: " + gleis3.Stapel.top());
        } else {
            while (gleis2.Stapel.top() != nr) {
                gleis1.Stapel.push(gleis2.Stapel.pop());
                System.out.println(" Dieser Waggon wird von Gleis 2 auf Gleis 1 verschoben: " + gleis1.Stapel.top());
            }
            gleis3.Stapel.push(gleis2.Stapel.pop());
            System.out.println("Dieser Waggon wird von Gleis 2 auf Gleis 3 verschoben: " + gleis3.Stapel.top());
        }
    }

    public void einfahren(int[] array, Stack s) {
        for (int i = 0; i < array.length; i++) {
            s.push(array[i]);
        }
    }

    public static int[] reihenfolge() {
        // Zuerst wird die Laenge abgefragt
        int laenge;
        Scanner scan = new Scanner(System.in);
        System.out.println("Bitte die Anzahl der Waggons eingeben");
        laenge = scan.nextInt();
        int z[] = new int[laenge];
        // Dann werden die Nummern der Reihe nach eingegeben. Solange, bis so viele

        int zahl;
        for (int i = 0; i < laenge; i++) {
            System.out.println("Bitte die Reihenfolge der Waggons eingeben");
            zahl = scan.nextInt();
            z[i] = zahl;

        }
        scan.close();
        return z;
    }

    Queue sortierenAnders(int[] reihenfolge) {
        Queue sortiert = new QueueInt(reihenfolge.length);
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie die Waggonnummern in der gewünschten Reihenfolge ein!");
        for (int i = 0; i < reihenfolge.length; i++) {

            int input = Integer.parseInt(sc.next());

            for (int j = 0; j < reihenfolge.length; j++) {

                if (input == reihenfolge[j]) {
                    sortiert.enqueue(input);
                    System.out.println(input + " akzeptiert.");
                    break;
                }
            }
        }

        sc.close();
        System.out.println("Fertig!");
        return sortiert;
    }
}