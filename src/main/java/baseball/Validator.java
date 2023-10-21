package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public boolean validateGuessNumber(String inputValue) {

        char[] inputCharArray = inputValue.toCharArray();

        return isNumbers(inputCharArray) && isThreeLength(inputCharArray)
                && isNotRepeat(inputCharArray);
    }

    public boolean validateRestart(String inputValue) {

        return inputValue.equals("1") || inputValue.equals("2");

    }

    private boolean isNumbers(char[] inputCharArray) {

        for (char ch : inputCharArray) {
            if (ch < '0' || ch > '9') {
                return false;
            }
        }

        return true;
    }

    private boolean isThreeLength(char[] inputCharArray) {

        return inputCharArray.length == 3;

    }

    private boolean isNotRepeat(char[] inputCharArray) {

        // 중복을 제거하는 set에 넣은 후에도 크기가 동일한지 확인합니다.
        Set<Character> setNumbers = new HashSet<>();

        for (char ch : inputCharArray) {
            setNumbers.add(ch);
        }

        return setNumbers.size() == 3;

    }

}
