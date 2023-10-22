package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> randomInt;
    private List<Integer> userInput;
    final int randomLength = 3;

    public Game() {
        SetRandomInt();
    }

    public void SetRandomInt() {
        randomInt = new ArrayList<>();
        while (randomInt.size() < randomLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomInt.contains(randomNumber)) {
                randomInt.add(randomNumber);
            }
        }
    }

    public void getUserInput() {
        userInput = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateUserInput(input);
        for (int j = 0; j < input.length(); j++) {
            userInput.add(input.charAt(j) - '0');
        }
    }

    private void validateUserInput(String input) {
        if (input.length() != randomLength) {
            throw new IllegalArgumentException("input has to be 3 digits.");
        }
        for (int i = 0; i < input.length(); i++) {
            if ('1' > input.charAt(i) || input.charAt(i) > '9') {
                throw new IllegalArgumentException("input has to be formed with digits between 1 to 9.");
            }
            if (input.lastIndexOf(input.charAt(i)) != i) {
                throw new IllegalArgumentException("input has to be formed with different digits.");
            }
        }
    }
}
