package baseball;

public class GameController {
    private final ComputerNumbers computerNumbers = new ComputerNumbers();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private GameResult gameResult;

    public void start() {
        outputView.printStartMessage();
        play();
    }

    public void play() {
        computerNumbers.selectNumbers();
        boolean isNotThreeStrike;
        do {
            isNotThreeStrike = compare(computerNumbers, inputView.readNumbers());
            outputView.printResult(gameResult);
        } while(isNotThreeStrike);
        outputView.printThreeStrike();
        restartOrExit();
    }

    public void restartOrExit() {
        if (inputView.readReplayNumber() == RestartStatus.RESTART) {
            computerNumbers.init();
            play();
            return;
        }
        outputView.printExit();
    }

    public boolean compare(ComputerNumbers computerNumbers, PlayerNumbers playerNumbers) {
        outputView.printInputNumberMessage();
        CompareSystem compareSystem = new CompareSystem(computerNumbers, playerNumbers);
        gameResult = compareSystem.compare();
        return gameResult.isNotThreeStrike();
    }
}
