package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private final UserInputValidation userInputValidation;

    public Baseball() {
        userInputValidation = new UserInputValidation();
    }

    public void run() {

    }

    public void startGame() {
        System.out.println(OutputStatement.GAME_START_OUTPUT.getOutput());
        BaseBallNumber answerNumber = new BaseBallNumber(generateNumber());
        while (true) {
            BaseBallNumber userNumber = new BaseBallNumber(inputUserNumber());
            Integer strikeCount = answerNumber.getStrikeCount(userNumber);
            if (strikeCount == 3) {
                System.out.println("3스트라이크");
                break;
            }
            Integer ballCount = answerNumber.getBallCount(userNumber);
            if (ballCount == 0 && strikeCount == 0) {
                System.out.println("낫싱");
                continue;
            }
            StringBuilder outputString = new StringBuilder();
            if (ballCount > 0) {
                outputString.append(ballCount).append("볼 ");
            }
            if (strikeCount > 0) {
                outputString.append(strikeCount).append("스트라이크");
            }
            System.out.println(outputString);
        }
        System.out.println(OutputStatement.GAME_END_OUTPUT.getOutput());
        restartGame();
    }

    public List<Integer> generateNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    public List<Integer> inputUserNumber() {
        System.out.print(OutputStatement.INPUT_NUMBER_OUTPUT.getOutput());
        String inputNumber = Console.readLine();
        List<Integer> integerList = new ArrayList<>();
        if (!userInputValidation.isValidGameNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; ++i) {
            char c = inputNumber.charAt(i);
            if (integerList.contains(Character.getNumericValue(c))) {
                throw new IllegalArgumentException();
            }
            integerList.add(Character.getNumericValue(c));
        }

        return integerList;
    }

    public void restartGame() {
        System.out.println(OutputStatement.RESTART_OUTPUT.getOutput());
        String inputNumber = Console.readLine();
        if (!userInputValidation.isValidRestartNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
        if (inputNumber.length() != 1) {
            throw new IllegalArgumentException();
        }
        Integer restartNumber = Integer.parseInt(inputNumber);
        if (restartNumber > 3 || restartNumber <= 0) {
            throw new IllegalArgumentException();
        }
        if (restartNumber == 2) {
            return;
        }
        if (restartNumber == 1) {
            startGame();
        }
    }

}
