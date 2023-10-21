package baseball;

import java.util.Set;
import java.util.stream.Collectors;

public class UserValidator {
    public boolean checkUserInput(String userInput) {
        return isRightLength(userInput, Constant.fixed_Number_Size) && isAllDigit(userInput) && isRightNumberRange(
                userInput) && isNotOverlap(userInput);
    }

    public boolean checkUserInputStatus(String userInputStatus) {
        return isRightLength(userInputStatus, 1) && isDigit(userInputStatus) && isRightStatus(userInputStatus);
    }

    private boolean isRightLength(String userInput, int number) {
        return userInput.length() == number;
    }

    private boolean isRightNumberRange(String userInput) {
        return userInput.chars().allMatch(c -> c >= Constant.Minimum_Range && c <= Constant.Maximum_Range);
    }

    private boolean isAllDigit(String userInput) {
        return userInput.chars().allMatch(Character::isDigit);
    }

    private boolean isDigit(String userInputStatus) {
        return userInputStatus.chars().allMatch(Character::isDigit) && userInputStatus.length() == 1;
    }

    private boolean isNotOverlap(String userInput) {
        Set<Character> inputDigits = userInput.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        return inputDigits.size() == Constant.fixed_Number_Size;
    }

    private boolean isRightStatus(String userInputStatus) {
        int status = Integer.parseInt(userInputStatus);
        return status == Constant.Input_Restart_Number || status == Constant.Input_Exit_Number;
    }
}
