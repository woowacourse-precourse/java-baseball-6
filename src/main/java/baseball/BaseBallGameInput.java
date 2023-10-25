package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGameInput {
    private final int playInputLength;

    BaseBallGameInput(int playInputLength) {
        this.playInputLength = playInputLength;
    }

    public List<Integer> playInput() {
        String userInputStr = Console.readLine();
        validatePlayInput(userInputStr);
        List<Integer> numbers = convertStringToList(userInputStr);
        return numbers;
    }

    private void validatePlayInput(String input) {
        if (input.length() != playInputLength) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEndInput(String input) {
        if (input.length() != 1 || !input.matches("[0-9]")) {
            throw new IllegalArgumentException();
        }
    }

    public String endInput() {
        String userInputStr = Console.readLine();
        validateEndInput(userInputStr);
        return (userInputStr);
    }

    private List<Integer> convertStringToList(String input) {
        List<Integer> inputNumber = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inputNumber.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        return inputNumber;
    }
}
