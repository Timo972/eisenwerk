import eisenwerk.Gleis;
import eisenwerk.Bahnhof;

public class Main {

    public static void main(String[] args) {
        Gleis gleis1 = new Gleis(1);
        Gleis gleis2 = new Gleis(2);
        Gleis gleis3 = new Gleis(3);
        Bahnhof bahnhof = new Bahnhof(gleis1, gleis2, gleis3);

        bahnhof.rangieren();
    }

}