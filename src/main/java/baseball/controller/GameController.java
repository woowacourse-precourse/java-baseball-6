package baseball.controller;

import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.Player;
import baseball.model.Util;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private static final String GAME_RESTART_STATE = "1";
    private static final String GAME_END_STATE = "2";
    private final int settingNumberLength;
    private final Computer computer;
    private final Player player;
    private final Hint hint;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(int numberLength) {
        this.settingNumberLength = numberLength;
        this.computer = new Computer(settingNumberLength);
        this.player = new Player(settingNumberLength);
        this.hint = new Hint();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void gameStart() {
        boolean gameProgress = true;

        outputView.printGameStartMessage();

        while(gameProgress) {
            progress();

            gameProgress = isRestartState();
        }
    }

    private void progress() {
        boolean isCorrect = false;
        List<Integer> computerNumbers = computer.getNumbers();

        while(!isCorrect) {
            setPlayerNumbers();
            isCorrect = compareNumbers(computerNumbers, player.getNumbers());
        }

        outputView.printEndMessage();
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

        return strikeCount == settingNumberLength;
    }

    private void setPlayerNumbers() {
        String input = inputView.inputPlayerNumber();
        player.setPlayerNumbersWithString(input);
    }
}
