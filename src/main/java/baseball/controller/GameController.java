package baseball.controller;

import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.Player;
import baseball.model.Util;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private static final int RANDOM_NUMBER_LENGTH = 3;
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

//    public void gameStart() {
//        boolean progress = true;
//        outputView.printGameStartMessage();
//
//        while(progress) {
//            progress();
//
//            progress = isRestart();
//        }
//    }

    private void progress() {
        boolean isCorrect = false;
        List<Integer> computerNumbers = computer.getNumbers();

        while(!isCorrect) {
            setPlayerNumbers();
            isCorrect = compareNumbers(computerNumbers, player.getNumbers());
        }

        outputView.printEndMessage();
    }

    private boolean compareNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = hint.getStrikeCount(computerNumbers, playerNumbers);
        int ballCount = hint.getBallCount(computerNumbers, playerNumbers);

        outputView.printHint(strikeCount, ballCount);

        return strikeCount == RANDOM_NUMBER_LENGTH;
    }

    private void setPlayerNumbers() {
        String input = inputView.inputPlayerNumber();
        player.setPlayerNumbersWithString(input);
    }
}
