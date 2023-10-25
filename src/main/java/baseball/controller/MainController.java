package baseball.controller;

import baseball.ComputerNumberGenerator;
import baseball.ProgramCommand;
import baseball.domain.GameResult;
import baseball.domain.Judgement;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.view.OutputView;
import java.util.List;

public class MainController {

    private final InputController inputController;
    private final OutputView outputView = new OutputView();
    private final Referee referee = new Referee();

    public MainController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        inputController.printStart();
        playNewGame();
    }

    private void playNewGame() {
        setComputerNumbers();
        play();
        askNewGame();
    }

    private void setComputerNumbers() {
        List<Integer> numbers = ComputerNumberGenerator.generate();
        referee.newComputerWith(numbers);
    }

    private void play() {
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
            playNewGame();
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