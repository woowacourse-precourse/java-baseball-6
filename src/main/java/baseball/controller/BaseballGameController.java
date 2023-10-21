package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.util.NumericComparator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGameController {
    private Computer computer;
    private Player player;
    private final NumericComparator comparator;

    public BaseballGameController() {
        this.computer = new Computer();
        this.comparator = new NumericComparator();
        this.player = new Player();
    }

    public void start() {
        boolean gameStatus = true;
        OutputView.printStartGameMessage();
        while (gameStatus) {
            List<Integer> computerNumbers = computer.generateComputerNumbers();
            playing(computerNumbers);
            gameStatus = isGameReStart();
        }
    }

    private void playing(List<Integer> computerNumbers) {
        boolean correct = false;

        while (!correct) {
            List<Integer> playerNumbers = player.getPlayerNumbers(InputView.inputNumber());

            comparator.compare(playerNumbers, computerNumbers);

            if (isCorrectAnswer()) {
                OutputView.printStrikeHintMessage(comparator.getStrikeCount());
                OutputView.printEndGameMessage();
                correct = true;

            } else if (isStrikeAnswer()) {
                OutputView.printStrikeHintMessage(comparator.getStrikeCount());
            } else if (isBallAnswer()) {
                OutputView.printBallHintMessage(comparator.getBallCount());
            } else if (isNothingAnswer()) {
                OutputView.printNothingMessage();
            } else if (isStrikeAndBallAnswer()) {
                OutputView.printStrikeAndBallMessage(comparator.getStrikeCount(), comparator.getBallCount());
            }
        }
    }

    // 재시작이면 true, 종료이면 false를 반환한다.
    private boolean isGameReStart() {
        int answer = Integer.parseInt(InputView.getRetryNumber());
        if (answer == 1) {
            return true;
        } else if (answer == 2) {
            return false;
        }
        throw new IllegalArgumentException("잘못된 입력값입니다.");
    }

    private boolean isStrikeAnswer() {
        return comparator.getStrikeCount() != 0 && comparator.getBallCount() == 0;
    }

    private boolean isBallAnswer() {
        return comparator.getStrikeCount() == 0 && comparator.getBallCount() != 0;
    }

    private boolean isStrikeAndBallAnswer() {
        return comparator.getStrikeCount() != 0 && comparator.getBallCount() != 0;
    }

    private boolean isCorrectAnswer() {
        return comparator.getStrikeCount() == 3;
    }

    private boolean isNothingAnswer() {
        return comparator.getStrikeCount() == 0 && comparator.getBallCount() == 0;
    }

}
