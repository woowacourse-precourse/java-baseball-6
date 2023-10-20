package baseball;

public class Application {

    public static void main(String[] args) {
        boolean isGameOver = false;
        Output.start();
        while (!isGameOver) {
            isGameOver = new Game().start();
        }
    }
}
