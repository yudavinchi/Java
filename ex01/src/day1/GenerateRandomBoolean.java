import java.util.Random;

public class GenerateRandomBoolean {
    private boolean bool;
    public GenerateRandomBoolean(){
        Random rd = new Random(); // creating Random object
        bool = rd.nextBoolean(); // displaying a random boolean
    }

    public boolean get(){
        return bool;
    }
}
