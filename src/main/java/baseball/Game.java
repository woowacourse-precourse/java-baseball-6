package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> randomNumbers;

    public Game() {
    }

    public void play() {
        randomNumbers = new ArrayList<>();

        boolean correctAnswer = false;
        do {
            System.out.print("숫자를 입력해주세요 : ");

            String userInput = getUserInput();

            int[] validInput = InputValidator.validateAndParseUserInput(userInput);
        } while (!correctAnswer);

        generateRandomNumbers();
    }

    private void generateRandomNumbers() {
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
