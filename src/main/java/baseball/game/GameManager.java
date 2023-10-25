package baseball.game;

import baseball.Ball;
import baseball.CompareResult;
import baseball.computer.Computer;
import baseball.util.StringUtils;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameManager {
    private final Computer computer = new Computer();
    private boolean isEnd;

    public void startGame() {
        initializeGame();
        printStartMessage();
        while (!isEnd) {
            printThrowBallMessage();
            throwBall();
        }
    }

    public void initializeGame() {
        computer.initializeBall();
        isEnd = false;
    }

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void throwBall() {
        CompareResult compareResult = computer.balls.compareBall(new Ball(inputPlayerBall()));

        printResultMessage(compareResult.getResultMessage());
        if (compareResult.isAnswer()) {
            printEndMessage();
            checkRetry(inputRetryCommand());
        }
    }

    private void printThrowBallMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    private List<Integer> inputPlayerBall() {
        return StringUtils.stringToIntegerList(Console.readLine());
    }

    private void printResultMessage(String resultMessage) {
        System.out.println(resultMessage);
    }

    private void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
