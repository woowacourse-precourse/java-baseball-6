package baseball;

public class PlayGame {

    private static final String INPUT_RESTART_NUMBER = "1";

    private final InputView inputView;
    private final OutputView outputView;
    private final Judge judge;
    public PlayGame(InputView inputView, OutputView outputView, Judge juge) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.judge = juge;
    }

    public void startGame() {
        outputView.printStartGameMessage();
        playGame();
    }

    private void playGame() {
        ComputerBaseBall computerBaseBall = initComputer();
        PlayerBaseBall playerBaseBall;
        judge.init();

        while (!judge.isSuccessed()) {
            outputView.printInputMessage();

            playerBaseBall = initPlayer(inputView.inputNumbers());
            JugeResult jugeResult = judge.inProgress(computerBaseBall.getBalls(), playerBaseBall.getBalls());

            outputView.printGameResult(jugeResult);
        }
        outputView.printGameSuccessMessage();
        restartGame(inputView.inputRestartOrEndGame());
    }

    private void restartGame(String inputNumber) {
        outputView.printRestartOrEndMessage();
        if (inputNumber.equals(INPUT_RESTART_NUMBER)) {
            playGame();
        }
    }

    private ComputerBaseBall initComputer() {
        return new ComputerBaseBall();
    }

    private PlayerBaseBall initPlayer(String inputNumbers) {
        return new PlayerBaseBall(inputNumbers);
    }
}
