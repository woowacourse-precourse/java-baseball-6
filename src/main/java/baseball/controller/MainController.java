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

    private static final int START_INDEX = 0;
    private static final int END_INDEX = 3;
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
        referee.createNewComputerWith(numbers);
    }

    private void play() {
        playUntilThreeStrike();
        outputView.printGameFinish();
    }

    private void playUntilThreeStrike() {
        GameResult gameResult;
        do {
            gameResult = new GameResult();
            List<Integer> numbers = inputController.getPlayerNumbers();
            calculateGameResult(gameResult, numbers);
            outputView.printResult(gameResult);
        } while (!gameResult.isThreeStrike());
    }

    private void calculateGameResult(GameResult gameResult, List<Integer> numbers) {
        for (int index = START_INDEX; index < END_INDEX; index++) {
            Judgement judgement = referee.judge(new Player(numbers), index); // Player.of(numbers) 등 정적팩토리메서드 적용 고려
            gameResult.updateScore(judgement);
        }
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

    private void finishProgram() {
    }
}