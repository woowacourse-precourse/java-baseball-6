package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BaseBalGameValidatorTest {
    private static String[] notNumberSource() {
        return new String[]{null, "", " ", "DJ", "dj", "baseball", "야구", "1야구1", "야구가좋아", "★", "11★", "O", "Z", "l", " 123", "12 3", "123 "};
    }

    private static String[] notOneOrTwoSource() {
        return new String[]{null, "", " ", "DJ", "dj", "baseball", "야구", "1야구1", "야구가좋아", "★", "11★", "O", "Z", "l", " 123", "12 3", "123 "
                , " 1", " 2", "1 ", "2 ", "01", "02"};
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
            "111", "112", "1", "999", "-1", "-12", "-122", "-999"
    })
    public void 세자리_숫자가아니거나_값은값이_있다면_예외를_반환한다(String baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBalGameValidator().validBaseBallValue(baseBallValue))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 세자리 숫자가 아니거나, 값은 값이 존재합니다.", baseBallValue));
    }

    @ParameterizedTest
    @CsvSource({
            "102", "302", "102", "120", "780", "970"
    })
    public void 숫자가_0이_있다면_예외를_반환한다(String baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBalGameValidator().validBaseBallValue(baseBallValue))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 0이 포함되어있다.", baseBallValue));
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

    @ParameterizedTest
    @CsvSource({
            "123", "456", "789", "321"
    })
    public void 세자리가_각각다른_양수이면_예외를_반환하지_않는다(String baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBalGameValidator().validBaseBallValue(baseBallValue))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2"
    })
    public void 엔드커멘드는_1이거나2이면_예외를_던지지_않는다(String command) {
        Assertions.assertThatCode(() -> new BaseBalGameValidator().validEndCommand(command))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("notOneOrTwoSource")
    public void 엔드커멘드는_1이거나2아니면_예외를_던지지_않는다(String command) {
        Assertions.assertThatCode(() -> new BaseBalGameValidator().validEndCommand(command))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 1이거나 2가 아닙니다.", command));
    }

}