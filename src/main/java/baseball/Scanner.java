package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Scanner {
    private Integer minimumOfRange;
    private Integer maximumOfRange;
    private Integer numberOfNumbers;
    private Integer playOption;
    private Integer endOption;

    Scanner(Configurations configurations) {
        minimumOfRange = configurations.getMinimumOfRange();
        maximumOfRange = configurations.getMaximumOfRange();
        numberOfNumbers = configurations.getNumberOfNumbers();
        playOption = configurations.getPlayOption();
        endOption = configurations.getEndOption();
    }

    public List<Integer> inputUserNumber() {
        List<Integer> userNumbers = new ArrayList<>();
        String inStr = Console.readLine();
        validateLength(inStr);
        for (char cur : inStr.toCharArray()) {
            validateRange(cur);
            validateDuplication(cur, userNumbers);
            userNumbers.add(cur - '0');
        }
        return userNumbers;
    }

    public Integer inputReplayOption() {
        Integer option = Integer.parseInt(Console.readLine());
        validateReplayOption(option);
        return option;
    }

    private void validateReplayOption(Integer option) {
        if (!option.equals(playOption) && !option.equals(endOption)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(String input) {
        if (input.length() != numberOfNumbers) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(char number) {
        if (number < minimumOfRange + '0' || number > maximumOfRange + '0') {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(char number, List<Integer> inputList) {
        if (inputList.contains(number - '0')) {
            throw new IllegalArgumentException();
        }
    }
}
