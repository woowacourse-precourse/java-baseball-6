package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Computer {
    final List<Integer> answer;
    final int answerSize = 3;


    private int createRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public Computer() {
        List<Integer> computerAnswer = new ArrayList<>();

        while (computerAnswer.size() < answerSize) {
            int randomNumber = createRandomNumber();
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
        answer = computerAnswer;
    }

    public List<Integer> compare(List<Integer> userInput) {
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

    public List<Integer> userInput() {
        String playerStringNumsInput = Console.readLine();
        List<Integer> playerNumsTemp = new ArrayList<>();

        for (int i = 0; i < answerSize; i++) {
            int numericValue = Character.getNumericValue(playerStringNumsInput.charAt(i));
            playerNumsTemp.add(numericValue);
        }
        return playerNumsTemp;
    }

}

public class Application {
    public static void main(String[] args) {
        List<Integer> result;

        final Computer computer = new Computer();
        final User user = new User();
        System.out.println(computer.answer);

        result = computer.compare(user.userInput());
        System.out.println(result);

    }
}
