package baseball;

import baseball.model.Computer;
import baseball.model.GameNumbers;
import baseball.model.GameResult;
import baseball.utils.Parser;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private final OutputView outputView;
    private final InputView inputView;
    private final Computer computer;
    private static final int MAX_STRIKES = 3;

    private Game(OutputView outputView, InputView inputView, Computer computer) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.computer = computer;
    }

    public static Game getInstance(final OutputView outputView, InputView inputView, Computer computer) {
        return new Game(outputView, inputView, computer);
    }

    public void run() {
        computer.pickRandomNumbers();

        while (true) {
            GameNumbers gameNumbersOfPlayer = getGameNumbersOfPlayer();
            GameResult result = computer.getResult(gameNumbersOfPlayer);
            outputView.printResult(result);
            if (result.isCorrect(MAX_STRIKES)) {
                outputView.printEndMessage();
                break;
            }
        }
    }

    private GameNumbers getGameNumbersOfPlayer() {
        String gameNumberOfPlayerBeforeParsing = inputView.readGameNumbersOfPlayer();
        return GameNumbers.getInstance(Parser.stringToIntegerList(gameNumberOfPlayerBeforeParsing));
    }
}
