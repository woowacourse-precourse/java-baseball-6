package baseball;

public class Application {
    public static void main(String[] args) {
        PlayGame playGame = new PlayGame();
        boolean isContinue = true;

        while (isContinue) {
            playGame.run();
            if (!playGame.retryGame()) {
                isContinue = false;
            }
        }
    }
}
