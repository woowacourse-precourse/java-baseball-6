package baseball;

public class Application {

    static boolean gameOver = false;

    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();

        while (!gameOver) {
            gameOver = baseBall.start();
        }
    }
}
