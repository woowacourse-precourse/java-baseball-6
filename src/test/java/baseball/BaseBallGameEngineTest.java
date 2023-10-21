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


}