package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Integer> numbers;

    public User() {
        this.numbers = new ArrayList<>();
    }

    public void inputNumber() {
        String input = Console.readLine();
        char[] inputCharArray = input.toCharArray();
        validateInput(inputCharArray);
    }

    private void validateInput(char[] arr) {
        validateInputLength(arr);
        validateInputType(arr);
    }

    private void validateInputLength(char[] arr) {
        if (arr.length != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputType(char[] arr) {
        for (char c : arr) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
