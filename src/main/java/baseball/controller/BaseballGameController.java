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
            System.out.println(computerNumbers);
            playing(computerNumbers);
            gameStatus = isGameReStart();
        }
    }

    private void playing(List<Integer> computerNumbers) {
        boolean correct = false;

        while (!correct) {
            List<Integer> playerNumbers = getPlayerNumbers();
            comparator.compare(playerNumbers, computerNumbers);
            correct = getGameResult(comparator.getStrikeCount(), comparator.getBallCount());
        }
    }

    private List<Integer> getPlayerNumbers() {
        return player.getPlayerNumbers(InputView.inputNumber());
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

    private boolean getGameResult(int strikeCount, int ballCount) {

        if (strikeCount == 3) {
            OutputView.printStrikeHintMessage(strikeCount);
            OutputView.printEndGameMessage();
            return true;
        } else if (strikeCount != 0 && ballCount == 0) {
            OutputView.printStrikeHintMessage(strikeCount);
        } else if (strikeCount == 0 && ballCount != 0) {
            OutputView.printBallHintMessage(ballCount);
        } else if (strikeCount != 0 && ballCount != 0) {
            OutputView.printStrikeAndBallHintMessage(strikeCount, ballCount);
        } else if (strikeCount == 0 && ballCount == 0) {
            OutputView.printNothingHintMessage();
        }
        return false;
    }
}