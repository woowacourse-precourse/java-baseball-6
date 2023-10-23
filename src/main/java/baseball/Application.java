package baseball;

public class Application {

    public static void main(String[] args) {
        OutputView.startGame();
        while (true) {
            BasketBallGame.playBasketBallGame();

            String restartOrQuit = InputView.getRestartOrQuit();
            Validator.validateRestartOrQuit(restartOrQuit);

            if (Integer.parseInt(restartOrQuit) == Constants.QUIT) {
                break;
            }
        }
    }
}