package baseball;

public class Application {
    public static void main(String[] args) {
        try {
            new GameManager().runGame();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
