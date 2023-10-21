package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BaseBalGameValidatorTest {
    private static String[] notNumberSource() {
        return new String[]{null, "", " ", "DJ", "dj", "baseball", "야구", "1야구1", "야구가좋아", "★", "11★", "O", "Z", "l"};
    }


    @ParameterizedTest
    @MethodSource({"notNumberSource"})
    public void 전부_숫자가아니면_예외를_반환한다(String baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBalGameValidator().validBaseBallValue(baseBallValue))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 숫자가 아닙니다.", baseBallValue));
    }

    @ParameterizedTest
    @CsvSource({
            "111", "112", "1", "100", "101", "999", "-1", "-12", "-122", "-999"
    })
    public void 세자리_숫자가아니거나_값은값이_있다면_예외를_반환한다(String baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBalGameValidator().validBaseBallValue(baseBallValue))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 세자리 숫자가 아니거나, 값은 값이 존재합니다.", baseBallValue));
    }

    @ParameterizedTest
    @CsvSource({
            "-123", "-456", "-789", "-321"
    })
    public void 세자리가_각각다른_음수이면_예외를_반환한다(String baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBalGameValidator().validBaseBallValue(baseBallValue))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 세자리가 각각다른 음수입니다.", baseBallValue));
    }

}