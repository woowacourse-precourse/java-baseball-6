package baseball.gameManage;

import baseball.service.playerService;
import baseball.util.printGameMessage;
import baseball.util.printNumberFormat;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class gameManage implements gameManageInterface {
    private static final int NUMBER_MAXSIZE = 3;
    private static final int ALL_STRIKE = 3;
    private static final int NO_STRIKE = 0;
    private static final int NO_BALL = 0;
    private static final int MATCH = 4;
    private static final int NOT_MATCH = 5;
    private static final int PLAY_AGAIN = 1;
    private static final int EXIT_GAME = 2;
    private final printGameMessage GameMessage = new printGameMessage();

    private final playerService playerService = new playerService();

    public void init() {
        GameMessage.gameStartMessage();
        try {
            play();
            playAgain();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }

    public List<Integer> selectComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_MAXSIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public Integer judgeNumber(List<Integer> playerNumber, List<Integer> computerNumber) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < playerNumber.size(); i++) {
            if (Objects.equals(playerNumber.get(i), computerNumber.get(i))) {
                strikeCount++;
            } else if (computerNumber.contains(playerNumber.get(i))) {
                ballCount++;
            }
        }
        return PrintNumber(strikeCount, ballCount);
    }

    public Integer PrintNumber(int strikeCount, int ballCount) {
        String printResult = "";
        printNumberFormat printNumber = new printNumberFormat();
        if (strikeCount == ALL_STRIKE) {
            printResult = printNumber.printStrike(strikeCount);
            GameMessage.matchResultMessage(printResult);
            return MATCH;
        }
        if (strikeCount == NO_STRIKE && ballCount == NO_BALL) {
            printResult += printNumber.nothing();
        }
        if (ballCount != NO_BALL) {
            printResult += printNumber.printBall(ballCount);
        }
        if (strikeCount != NO_STRIKE) {
            printResult += printNumber.printStrike(strikeCount);
        }
        GameMessage.matchResultMessage(printResult);
        return NOT_MATCH;
    }

    public void play() {
        List<Integer> computerNumber = selectComputerNumber();
        while (true) {
            List<Integer> playerNumber = playerService.selectPlayerNumber();
            Integer isMatched = judgeNumber(playerNumber, computerNumber);
            if (isMatched == MATCH) {
                GameMessage.numberMatchMessage();
                break;
            }
        }
    }

    public void playAgain() {
        GameMessage.gameRestartMessage();
        while (true) {
            int checkAgain = Integer.parseInt(Console.readLine());
            if (checkAgain != PLAY_AGAIN && checkAgain != EXIT_GAME) {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            }
            if (checkAgain == EXIT_GAME) {
                break;
            }
            play();
        }
    }
}
