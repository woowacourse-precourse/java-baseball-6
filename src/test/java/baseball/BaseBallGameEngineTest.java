package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BaseBallGameEngineTest {
    private static String[] notOneOrTwoSource() {
        return new String[]{null, "", " ", "DJ", "dj", "baseball", "야구", "1야구1", "야구가좋아", "★", "11★", "O", "Z", "l", " 123", "12 3", "123 "
                , " 1", " 2", "1 ", "2 ", "01", "02"};
    }

    @ParameterizedTest
    @CsvSource({
            "111", "112", "1", "999", "-1", "-12", "-122", "-999"
    })
    public void 세자리_숫자가아니거나_값은값이_있다면_예외를_반환한다(int baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBallGameEngine(baseBallValue, new BaseBalGameValidator()))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 세자리 숫자가 아니거나, 값은 값이 존재합니다.", baseBallValue));
    }

    @ParameterizedTest
    @CsvSource({
            "102", "302", "102", "120", "780", "970", "012", "570"
    })
    public void 숫자가_0이_있다면_예외를_반환한다(int baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBallGameEngine(baseBallValue, new BaseBalGameValidator()))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 0이 포함되어있다.", baseBallValue));
    }


    @ParameterizedTest
    @CsvSource({
            "-123", "-456", "-789", "-321"
    })
    public void 세자리가_각각다른_음수이면_예외를_반환한다(int baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBallGameEngine(baseBallValue, new BaseBalGameValidator()))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 세자리가 각각다른 음수입니다.", baseBallValue));
    }

    @ParameterizedTest
    @CsvSource({
            "123,456,0,0",
            "123,789,0,0",
            "123,451,0,1",
            "123,452,0,1",
            "123,435,0,1",
            "123,241,0,2",
            "123,214,0,2",
            "123,231,0,3",
            "456,564,0,3",
            "823,879,1,0",
            "823,793,1,0",
            "823,841,1,0",
            "873,371,1,1",
            "873,178,1,1",
            "123,321,1,2",
            "654,456,1,2",
            "123,124,2,0",
            "654,754,2,0",
            "789,781,2,0",
            "789,789,3,0",
            "891,891,3,0",
            "123,123,3,0",
    })
    public void 점수를_체점해준다(int generateValue, String baseBallValue, int strike, int ball) {
        BaseBallScore expect = new BaseBallScore(strike, ball);
        BaseBallScore result = new BaseBallGameEngine(generateValue, new BaseBalGameValidator()).calculatingBaseBallScore(baseBallValue);
        Assertions.assertThat(result.getStrike()).isEqualTo(expect.getStrike());
        Assertions.assertThat(result.getBall()).isEqualTo(expect.getBall());

    }

    @ParameterizedTest
    @CsvSource({
            "111", "112", "1", "999", "-1", "-12", "-122", "-999"
    })
    public void 추측_값이_세자리가_각자_다르지_않거나_세자리가_아닌_수이거나_음수이면_예외를_반환한다(String baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBallGameEngine(123, new BaseBalGameValidator()).calculatingBaseBallScore(baseBallValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 세자리 숫자가 아니거나, 값은 값이 존재합니다.", baseBallValue));

    }


    @ParameterizedTest
    @CsvSource({
            "-123", "-456", "-789", "-321"
    })
    public void 추측_값이_세자리가_각각다른_음수이면_예외를_반환한다(String baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBallGameEngine(123, new BaseBalGameValidator()).calculatingBaseBallScore(baseBallValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 세자리가 각각다른 음수입니다.", baseBallValue));
    }

    @ParameterizedTest
    @CsvSource({
            "102", "120", "780"
    })
    public void 추측_값이_0이_있으면_예외를_반환한다(String baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBallGameEngine(123, new BaseBalGameValidator()).calculatingBaseBallScore(baseBallValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 0이 포함되어있다.", baseBallValue));
    }


    @ParameterizedTest
    @CsvSource({
            "1,false", "2,true"
    })
    public void 엔드커멘드는_1이나2는_반환값이_나온다(String command, boolean expect) {
        Assertions.assertThat(new BaseBallGameEngine(123, new BaseBalGameValidator()).isEnd(command))
                .isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("notOneOrTwoSource")
    public void 엔드커멘드는_1이나2이아니면_예외를_반환한다(String command) {
        Assertions.assertThatCode(() -> new BaseBallGameEngine(123, new BaseBalGameValidator()).isEnd(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 1이거나 2가 아닙니다.", command));
    }
}