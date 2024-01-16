package eisenwerk;

public class Stack {

    // INSTANZVARIABLEN
    public int[] stapel;
    public int topindex;

    // KONSTRUKTOR
    public Stack() {
        stapel = new int[1000];
        topindex = 0;
    }

    // METHODEN
    public boolean isEmpty() {
        return topindex == 0;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("in pop(): Keller leer!");
        }
        topindex--;
        return stapel[topindex];
    }

    public void push(int x) {
        if (topindex == stapel.length) {
            throw new RuntimeException("in push(): Keller voll!");
        }
        stapel[topindex] = x;
        topindex++;
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("in top(): Keller leer!");
        }
        return stapel[topindex - 1];
    }

    public boolean hasItem(int nr) {
        Stack safe = new Stack();
        boolean has = false;

        while (!this.isEmpty()) {
            if (this.top() == nr) {
                has = true;
            }
            safe.push(this.pop());
        }

        while (!safe.isEmpty()) {
            this.push(safe.pop());
        }

        return has;

    }

}