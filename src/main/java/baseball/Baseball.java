package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private final UserInputNumber userInputNumber;

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

    public void startGame() {
        BaseBallNumber answerNumber = generateNumber();
        while (true) {
            BaseBallNumber userNumber = inputUserNumber();
            if (isSuccessGame(answerNumber, userNumber)) {
                break;
            }
        }
        OutputStatement.GAME_END_OUTPUT.printOutput();
    }

    public boolean isSuccessGame(BaseBallNumber answerNumber, BaseBallNumber userNumber) {
        Integer strikeCount = answerNumber.getStrikeCount(userNumber);
        if (strikeCount == 3) {
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


    public BaseBallNumber generateNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return new BaseBallNumber(numberList);
    }

    public BaseBallNumber inputUserNumber() {
        OutputStatement.INPUT_NUMBER_OUTPUT.printOutput();
        String inputNumber = Console.readLine();
        BaseBallNumber baseBallNumber = userInputNumber.parseBaseBallNumber(inputNumber);
        if (baseBallNumber == null) {
            throw new IllegalArgumentException();
        }
        return baseBallNumber;
    }

    public boolean restartGame() {
        OutputStatement.RESTART_OUTPUT.printOutput();
        String inputNumber = Console.readLine();
        if (!userInputNumber.isValidRestartNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
        int restartNumber = Integer.parseInt(inputNumber);
        return restartNumber == 1;
    }
}
