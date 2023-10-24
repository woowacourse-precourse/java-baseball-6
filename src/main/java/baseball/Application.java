package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Computer {
    List<Integer> answer;
    final int answerSize = 3;


    private int createRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public void generateAnswer() {
        List<Integer> computerAnswer = new ArrayList<>();

        while (computerAnswer.size() < answerSize) {
            int randomNumber = createRandomNumber();
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
        answer = computerAnswer;
    }

    public List<Integer> compareAnswer(List<Integer> userInput) {
        int containCount = 0;
        int strikeCount = 0;
        List<Integer> guessResult = new ArrayList<>();
        for (int i = 0; i < answerSize; i++) {
            if (answer.contains(userInput.get(i))) {
                containCount++;
            }

        }
        if (containCount > 0) {
            for (int i = 0; i < answerSize; i++) {
                if (answer.get(i).equals(userInput.get(i))) {
                    strikeCount++;
                }

            }
            guessResult.add(0, containCount - strikeCount);
            guessResult.add(1, strikeCount);
        } else if (containCount == (0)) {
            guessResult.add(null);
        }
        return guessResult;

    }
}

class User {
    final int answerSize = 3;

    public List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");

        String playerStringNumsInput = Console.readLine();
        validateUserInput(playerStringNumsInput);

        List<Integer> playerNumsTemp = new ArrayList<>();

        for (int i = 0; i < answerSize; i++) {
            int numericValue = Character.getNumericValue(playerStringNumsInput.charAt(i));
            playerNumsTemp.add(numericValue);
        }
        return playerNumsTemp;
    }

    private void validateUserInput(String userInput) throws IllegalArgumentException {

        if (userInput.length() != answerSize) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < userInput.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (userInput.charAt(i) == (userInput.charAt(j))) {
                    throw new IllegalArgumentException();
                }
            }
        }
        if (userInput.contains("0")) {
            throw new IllegalArgumentException();

        }

    }
}

public class Application {
    public static void main(String[] args) {
        List<Integer> result;
        String endGameNumber = "2";
        System.out.println("숫자 야구 게임을 시작합니다.");
        final Computer computer = new Computer();
        computer.generateAnswer();
        final User user = new User();
        while (true) {
            result = computer.compareAnswer(user.getUserInput());
            if (!printGameResult(result)) {
                if (Console.readLine().equals(endGameNumber)) {
                    break;
                } else {
                    computer.generateAnswer();
                }
            }

        }

    }

    public static boolean printGameResult(List<Integer> result) {
        if (result.get(0) == (null)) {
            System.out.print("낫싱\n");
        } else if (result.get(1) > 2) {
            System.out.println("3스트라이크");
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return false;
        } else if (result.get(0).equals(0) && result.get(1) > 0) {
            System.out.printf("%d스트라이크\n", result.get(1));
        } else if (result.get(0) > 0 && result.get(1).equals(0)) {
            System.out.printf("%d볼\n", result.get(0));
        } else if (result.get(0) > 0 && result.get(1) > 0) {
            System.out.printf("%d볼 %d스트라이크\n", result.get(0), result.get(1));
        }
        return true;
    }
}
