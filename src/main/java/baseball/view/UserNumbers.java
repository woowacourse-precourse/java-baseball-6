package baseball.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UserNumbers {

    private final List<Integer> userNumbers;

    public UserNumbers(String inputString) {
        validateInput(inputString);
        this.userNumbers = userInputToIntegerList(inputString);
    }

    public List<Integer> userInputToIntegerList(String inputString) {
        return Arrays.stream(inputString.split("")).map(Integer::parseInt).toList();
    }

    private boolean hasLengthOfThree(String userInput) {
        if (userInput.length() == 3) {
            return true;
        }
        return false;
    }

    private boolean isAllDigit(String userInput) {
        for (char c : userInput.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUniqueNumber(String userInput) {
        Set<Character> numberSet = new HashSet<>();
        for (char c : userInput.toCharArray()) {
            numberSet.add(c);
        }
        if (numberSet.size() == 3) {
            return true;
        }
        return false;
    }

    private boolean isInRangeOfOneToNine(String userInput) {
        for (String c : userInput.split("")) {
            int number = Integer.parseInt(c);
            if (number <= 0 || number > 9) {
                return false;
            }
        }
        return true;
    }

    private void validateInput(String inputString) {
        if (!hasLengthOfThree(inputString)) {
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요");
        }
        if (!isAllDigit(inputString)) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
        if (!isUniqueNumber(inputString)) {
            throw new IllegalArgumentException("서로 다른 세 수를 입력해주세요");
        }
        if (!isInRangeOfOneToNine(inputString)) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 세 개 입력해주세요");
        }
    }

    public int valueOfIndex(int index) {
        return userNumbers.get(index);
    }

}
