package baseball.util;

import baseball.domain.BaseballRestartOption;

public class BaseballRestartOptionConvertor {
    public static BaseballRestartOption convert(String input) {
        try {
            int optionValue = Integer.parseInt(input);
            return BaseballRestartOption.from(optionValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1 혹은 2의 숫자만 입력이 가능합니다.");
        }
    }
}
