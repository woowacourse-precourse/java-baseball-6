package baseball.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputViewValidator {
    private final String REGEXP_ONLY_NUM = "^[0-9][0-9]*$";
    private final Pattern ONLY_NUM = Pattern.compile(REGEXP_ONLY_NUM);

    public void validateNum(String input) {
        Matcher matcher = ONLY_NUM.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않는 숫자 입니다. 숫자를 입력하세요");
        }
    }


}
