package baseball;

public class Application {

    public static void main(String[] args) {
        OutputView.startGame();
        while (true) {
            BasketBallGame basketBallGame = new BasketBallGame();
            basketBallGame.playBasketBallGame();

            String restartOrQuit = InputView.getRestartOrQuit();

            Validator validator = new Validator();
            validator.validateRestartOrQuit(restartOrQuit);

            if (Integer.parseInt(restartOrQuit) == Constants.QUIT) {
                break;
            }
        }
    }
}