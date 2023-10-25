package baseball.gameutil.validate;

import java.util.HashSet;
import java.util.Set;

/**
 * 이 클래스는 ValidateInput을 구현하는 클래스들의 공통 메서드를 모아놓은 클래스이다.
 */
public class ValidateInputCommon {

    /**
     * 입력값의 길이를 검증한다.
     * @param input 입력값
     * @param expectedLength 예상 길이
     * @return 입력값의 길이가 예상 길이와 같으면 true, 다르면 false
     */
    protected boolean checkLength(String input, Integer expectedLength) {
        return input.length() == expectedLength;
    }

    /**
     * 입력값이 모두 숫자인지 검증한다.
     * @param input 입력값
     * @return 입력값이 모두 숫자이면 true, 아니면 false
     */
    protected boolean checkIsAllNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 입력값이 모두 숫자이고, start와 end 사이의 숫자인지 검증한다.
     * @param input 입력값
     * @return 입력값이 모두 숫자이고, start와 end 사이의 숫자이면 true, 아니면 false
     */
    protected boolean checkBetween(String input, Integer start, Integer end) {
        for (char ch : input.toCharArray()) {
            int number = Character.getNumericValue(ch);
            if (start > number || number > end) {
                return false;
            }
        }
        return true;
    }

    /**
     * 입력값에서 각각의 숫자가 중복되지 않는지 검증한다.
     * @param input 입력값
     * @return 입력값에서 각각의 숫자가 중복되지 않으면 true, 아니면 false
     */
    protected boolean checkUnique(String input) {
        Set<Character> inputSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            inputSet.add(c);
        }

        return inputSet.size() == input.length();
    }
}
