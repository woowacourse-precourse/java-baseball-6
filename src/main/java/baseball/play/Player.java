package baseball.play;

import static baseball.util.Constant.DUP_NUM_ERR;
import static baseball.util.Constant.INPUT_MSG;
import static baseball.util.Constant.NUM_ERR_MSG;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> numbers;

    public Player() {
        numbers = new ArrayList<>();
    }

    public void inputUserNumber() {
        System.out.print(INPUT_MSG);
        String input = Console.readLine();
        validateUserInput(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateUserInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(NUM_ERR_MSG);
        }

        List<Integer> newNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);

            if (!isValidDigit(digit, newNumbers)) {
                throw new IllegalArgumentException(DUP_NUM_ERR);
            }

            newNumbers.add(digit);
        }

        numbers = newNumbers;
    }

    private boolean isValidDigit(int digit, List<Integer> newNumbers) {
        return digit >= 1 && digit <= 9 && !newNumbers.contains(digit);
    }
}
