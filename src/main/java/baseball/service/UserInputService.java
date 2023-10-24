package baseball.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class UserInputService {

    public List<Integer> userInput(int size) {
        String inputStr = Console.readLine();

        return getIntegerList(inputStr, size);
    }

    private List<Integer> getIntegerList(String inputStr, int size) {
        checkUserInput(inputStr, size);

        return inputStr.chars()
                .mapToObj(c -> Character.getNumericValue((char) c))
                .collect(Collectors.toList());
    }

    private void checkUserInput(String inputStr, int size) {
        sizeCheck(inputStr, size);
        numberCheck(inputStr);
    }

    private void numberCheck(String inputStr) {
        try {
            Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void sizeCheck(String inputStr, int size) {
        if (inputStr.length() != size) {
            throw new IllegalArgumentException();
        }
    }

}
