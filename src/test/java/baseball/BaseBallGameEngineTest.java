package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseBallGameEngineTest {
    @ParameterizedTest
    @CsvSource({
            "111", "112", "1", "100", "101", "999", "-1", "-12", "-122", "-999"
    })
    public void 세자리_숫자가아니거나_값은값이_있다면_예외를_반환한다(int baseBallValue) {
        Assertions.assertThatCode(() -> new BaseBallGameEngine(baseBallValue, new BaseBalGameValidator()))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%S는 세자리 숫자가 아니거나, 값은 값이 존재합니다.", baseBallValue));
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
            "123,201,0,2",
            "123,210,0,2",
            "123,231,0,3",
            "456,564,0,3",
            "823,879,1,0",
            "823,793,1,0",
            "803,701,1,0",
            "803,301,1,1",
            "803,108,1,1",
            "123,321,1,2",
            "654,456,1,2",
            "123,124,2,0",
            "654,754,2,0",
            "789,780,2,0",
            "789,789,3,0",
            "890,890,3,0",
            "123,123,3,0",
    })
    public void 점수를_체점해준다(int generateValue, int baseBallValue, int strike, int ball) {
        BaseBallScore expect = new BaseBallScore(strike, ball);
        BaseBallScore result = new BaseBallGameEngine(generateValue, new BaseBalGameValidator()).calculatingBaseBallScore(baseBallValue);
        Assertions.assertThat(result.getStrike()).isEqualTo(expect.getStrike());
        Assertions.assertThat(result.getBall()).isEqualTo(expect.getBall());

    }

}