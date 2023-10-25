package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printGameStartMessage();
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();

        } while (askRetry());
    }

    public static boolean askRetry() {
        RetryNumber retryNumber = new RetryNumber(InputView.setRetryNumber());

        if (retryNumber.getRetryNumber().equals("1")) {
            return true;
        }

        return false;
    }


}
