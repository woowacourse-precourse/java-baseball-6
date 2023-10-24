package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Baseball {
    private final UserInputNumber userInputNumber;
    private static final Integer GAME_NUMBER_SIZE = 3;
    private static final Integer RESTART_NUMBER = 1;
    private static final Integer MIN_GAME_NUMBER = 1;
    private static final Integer MAX_GAME_NUMBER = 9;

    public Baseball() {
        userInputNumber = new UserInputNumber();
    }

    public void run() {
        OutputStatement.GAME_START_OUTPUT.printOutput();
        while (true) {
            startGame();
            boolean restartFlag = restartGame();
            if (!restartFlag) {
                break;
            }
        }
    }

    private void startGame() {
        BaseBallNumber answerNumber = generateNumber();
        while (true) {
            BaseBallNumber userNumber = inputUserNumber();
            if (isSuccessGame(answerNumber, userNumber)) {
                break;
            }
        }
        OutputStatement.GAME_END_OUTPUT.printOutput();
    }

    private boolean isSuccessGame(BaseBallNumber answerNumber, BaseBallNumber userNumber) {
        Integer strikeCount = answerNumber.getStrikeCount(userNumber);
        if (Objects.equals(strikeCount, GAME_NUMBER_SIZE)) {
            OutputStatement.THREE_STRIKE.printOutput();
            return true;
        }
        Integer ballCount = answerNumber.getBallCount(userNumber);
        if (ballCount == 0 && strikeCount == 0) {
            OutputStatement.NOTHING.printOutput();
            return false;
        }
        printResult(ballCount, strikeCount);
        return false;
    }

    private void printResult(int ballCount, int strikeCount) {
        StringBuilder outputString = new StringBuilder();
        if (ballCount > 0) {
            outputString.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            outputString.append(strikeCount).append("스트라이크");
        }
        System.out.println(outputString);
    }


    private BaseBallNumber generateNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < GAME_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_GAME_NUMBER, MAX_GAME_NUMBER);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return new BaseBallNumber(numberList);
    }

    private BaseBallNumber inputUserNumber() {
        OutputStatement.INPUT_NUMBER_OUTPUT.printOutput();
        String inputNumber = Console.readLine();
        BaseBallNumber baseBallNumber = userInputNumber.parseBaseBallNumber(inputNumber);
        if (baseBallNumber == null) {
            throw new IllegalArgumentException();
        }
        return baseBallNumber;
    }

    private boolean restartGame() {
        OutputStatement.RESTART_OUTPUT.printOutput();
        String inputNumber = Console.readLine();
        if (!userInputNumber.isValidRestartNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
        int restartNumber = Integer.parseInt(inputNumber);
        return restartNumber == RESTART_NUMBER;
    }
}
