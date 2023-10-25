package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class User {
    private static final int INPUT_LENGTH = 3;
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_REGEX = "^[1-9]{3}$";

    private static final String INPUT_NOT_MATCH_ERROR_MESSAGE = "입력값이 잘못되었습니다.";
    private static final String INPUT_DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 있습니다.";

    int[] userBaseBallNumber = new int[INPUT_LENGTH];

    public void getUserInput() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        validateUserInput(input);
        for (int i = 0; i < INPUT_LENGTH; i++) {
            this.userBaseBallNumber[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
    }

    private void validateUserInput(String input) {
        validateInputLengthAndType(input);
        validateDuplicateNumber(input);
    }

    private void validateInputLengthAndType(String input) {
        if (!input.matches(INPUT_REGEX)) {
            throw new IllegalArgumentException(INPUT_NOT_MATCH_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateNumber(String input) {
        Set<Character> duplicateCheckSet = new HashSet<>();

        for (char num : input.toCharArray()) {
            duplicateCheckSet.add(num);
        }

        if (duplicateCheckSet.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_ERROR_MESSAGE);
        }
    }


}
