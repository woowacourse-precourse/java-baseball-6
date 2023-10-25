package baseball.game;

import baseball.Ball;
import baseball.CompareResult;
import baseball.computer.Computer;
import baseball.util.StringUtils;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameManager {
    private final Computer computer = new Computer();

    private boolean isEnd;

    public void startGame() {
        initializeGame();
        GameView.printStartMessage();
        while (!isEnd) {
            GameView.printThrowBallMessage();
            throwBall();
        }
    }

    public void initializeGame() {
        computer.initializeBall();
        isEnd = false;
    }

    public void throwBall() {
        CompareResult compareResult = computer.balls.compareBall(new Ball(inputPlayerBall()));

        GameView.printResultMessage(compareResult.getResultMessage());
        if (compareResult.isAnswer()) {
            GameView.printEndMessage();
            checkRetry(inputRetryCommand());
        }
    }

    private List<Integer> inputPlayerBall() {
        return StringUtils.stringToIntegerList(Console.readLine());
    }

    private void checkRetry(int retryCommand) {
        if (retryCommand == 1) {
            initializeGame();
        }

        if (retryCommand == 2) {
            isEnd = true;
        }

        if (retryCommand > 2) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

    private int inputRetryCommand() {
        return StringUtils.stringToNumber(Console.readLine());
    }
}
