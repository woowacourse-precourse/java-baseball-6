package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager {

    Validator validator = new Validator();

    public List<Integer> getGuessNumbers() {

        String inputValue = getInput();

        List<Integer> guessNumbers = new ArrayList<>();

        if (validator.validateGuessNumber(inputValue)) {

            char[] charGuessNumber = inputValue.toCharArray();

            for (char i : charGuessNumber) {
                guessNumbers.add(i - '0');
            }

        }

        return guessNumbers;

    }

    private String getInput() {

        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();

        return inputValue;

    }

}
