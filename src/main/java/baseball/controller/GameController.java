package baseball.controller;

import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private static final String GAME_RESTART_STATE = "1";
    private static final String GAME_END_STATE = "2";
    private static final int GAME_NUMBER_LENGTH = 3;
    private final Computer computer;
    private final Player player;
    private final Hint hint;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.computer = new Computer();
        this.player = new Player();
        this.hint = new Hint();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        outputView.printGameStartMessage();

        do {
            progress();
        } while (isRestartState());
    }

    private void progress() {
        computer.setRandomNumbers();

        do {
            setPlayerNumbers();
        } while (!compareNumbers(computer.getNumbers(), player.getNumbers()));

        outputView.printGameEndMessage();
    }

    private boolean isRestartState() {
        String input = inputView.inputRestartState();

        if(input.equals(GAME_RESTART_STATE)){
            return true;
        }

        if (input.equals(GAME_END_STATE)) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    private boolean compareNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = hint.getStrikeCount(computerNumbers, playerNumbers);
        int ballCount = hint.getBallCount(computerNumbers, playerNumbers);

        outputView.printHint(strikeCount, ballCount);

        return strikeCount == GAME_NUMBER_LENGTH;
    }

    private void setPlayerNumbers() {
        String input = inputView.inputPlayerNumber();
        player.setPlayerNumbersWithString(input);
    }
}
