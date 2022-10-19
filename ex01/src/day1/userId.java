import java.util.Random;

public class userId {
    int id;

    public userId() {
        Random rand = new Random();

        // random id will have 9 digits
        id = rand.nextInt(999999999 - 900000000) + 100000000;
    }

    public int get() {
        return id;
    }
}
