import java.util.Random;

public class Coin {
    private String side;
    private final String HEADS = "HEADS";
    private final String TAILS = "TAILS";

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void flip() {
        Random random = new Random();
        int max = 2;
        int generateRandom = random.nextInt(max) + 1;
        switch (generateRandom) {
            case 1 -> setSide(HEADS);
            case 2 -> setSide(TAILS);
        }
    }
}
