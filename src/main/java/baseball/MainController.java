package baseball;

import java.util.List;

public class MainController {

    private final InputController inputController;
    private final Referee referee = new Referee();
    private final OutputView outputView = new OutputView();

    public MainController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        inputController.printStart();
        play();
    }

    private void play() {
        referee.initComputer();
        playGame();
        askNewGame();
    }

    private void playGame() {
        playUntilThreeStrike();
        outputView.printGameFinish();
    }

    private void playUntilThreeStrike() {
        GameResult gameResult;
        do {
            List<Integer> numbers = inputController.getPlayerNumbers();
            gameResult = new GameResult();
            calculateGameResult(gameResult, numbers);
            outputView.printResult(gameResult);
        } while (!gameResult.isThreeStrike());
    }

    private void askNewGame() {
        String command = inputController.getRestartCommand();
        ProgramCommand.validate(command);
        if (ProgramCommand.isRetry(command)) {
            play();
        }
        if (ProgramCommand.isFinish(command)) {
            finishProgram();
        }
    }

    private void calculateGameResult(GameResult gameResult, List<Integer> numbers) {
        for (int index = 0; index < 3; index++) {
            Judgement judgement = referee.judge(new Player(numbers), index);
            gameResult.updateScore(judgement);
        }
    }

    private void finishProgram() {
    }
}