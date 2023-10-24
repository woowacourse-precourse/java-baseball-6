package baseball;

public class Application {
    public static void main(String[] args) {
        PlayGame playGame = new PlayGame();
        boolean flag = true;

        while (flag) {
            playGame.run();
            if (!playGame.retryGame()) {
                flag = false;
            }
        }
    }
}
