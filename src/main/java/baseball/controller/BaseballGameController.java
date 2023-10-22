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
            int gameResult = comparator.getResult(playerNumbers, computerNumbers);

            switch (gameResult) {
                case 1:
                    OutputView.printStrikeHintMessage(comparator.getStrikeCount());
                    break;

                case 2:
                    OutputView.printBallHintMessage(comparator.getBallCount());
                    break;
                case 3:
                    OutputView.printStrikeHintMessage(comparator.getStrikeCount());
                    OutputView.printEndGameMessage();
                    correct = true;
                    break;
                case 4:
                    OutputView.printStrikeAndBallMessage(comparator.getStrikeCount(), comparator.getBallCount());
                    break;
                case 5:
                    OutputView.printNothingMessage();
                    break;
            }
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

}
