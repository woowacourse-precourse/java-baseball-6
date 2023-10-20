package baseball.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 입력값에 대한 검증을 진행하는 클래스
 */
public class InputValidation {

    /**
     * 사용자의 숫자 입력값이 자연수로만 이루어져 있는지 검증한다.
     */
    public void validateNaturalNumber(String input) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력된 문자열은 자연수로만 이루어져야 합니다.");
        }
    }
}