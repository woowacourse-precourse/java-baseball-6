package baseball.service;

import baseball.view.printGameMessage;
import baseball.view.printNumberFormat;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class gameManage implements gameManageInterface {
    private final printGameMessage gameMessage = new printGameMessage();
    private final playerService playerService = new playerService();

    public void init() {
        gameMessage.gameStartMessage();
        try {
            do {
                play();
            } while (isPlayAgain());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }

    public List<Integer> selectComputerNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < gameConstant.NUMBER_MAXSIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
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
        return printResultNumber(strikeCount, ballCount);
    }

    public Integer printResultNumber(int strikeCount, int ballCount) {
        String printResult = "";
        printNumberFormat printNumber = new printNumberFormat();
        if (strikeCount == gameConstant.ALL_STRIKE) {
            printResult = printNumber.printStrike(strikeCount);
            gameMessage.matchResultMessage(printResult);
            return gameConstant.MATCH;
        }
        if (strikeCount == gameConstant.NO_STRIKE && ballCount == gameConstant.NO_BALL) {
            printResult += printNumber.nothing();
        }
        if (ballCount != gameConstant.NO_BALL) {
            printResult += printNumber.printBall(ballCount);
        }
        if (strikeCount != gameConstant.NO_STRIKE) {
            printResult += printNumber.printStrike(strikeCount);
        }
        gameMessage.matchResultMessage(printResult);
        return gameConstant.NOT_MATCH;
    }

    public void play() {
        List<Integer> computerNumbers = selectComputerNumber();
        while (true) {
            List<Integer> playerNumbers = playerService.selectPlayerNumber();
            Integer matchResult = judgeNumber(playerNumbers, computerNumbers);
            if (matchResult == gameConstant.MATCH) {
                gameMessage.numberMatchMessage();
                break;
            }
        }
    }

    public boolean isPlayAgain() {
        gameMessage.gameRestartMessage();
        int checkAgain = Integer.parseInt(Console.readLine());
        if (checkAgain != gameConstant.PLAY_AGAIN && checkAgain != gameConstant.EXIT_GAME) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
        return checkAgain == gameConstant.PLAY_AGAIN;
    }
}
