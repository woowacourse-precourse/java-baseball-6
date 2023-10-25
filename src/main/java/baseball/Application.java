package baseball;

public class Application {
    public static void main(String[] args) {
        OutputView.printGameStartMessage();
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();

        } while (askRetry());
    }

    public static boolean askRetry() {
        RetryNumber retryNumber = new RetryNumber(InputView.readRetryNumber());

        return retryNumber.getRetryNumber().equals("1");
    }


}
