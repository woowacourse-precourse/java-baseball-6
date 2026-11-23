package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseBallNumbersTest {
    @ParameterizedTest
    @ValueSource(strings = {"123","456","789","987","654"})
    void 정상_입력이면_예외가_발생하지_않는다(String input){
        assertThatCode(() -> BaseballNumbers.from(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"113","226","339","447","655","656"})
    void 중복된_숫자가_입력되면_예외가_발생한다(String input){
        assertThatThrownBy(() -> BaseballNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a13","2a6","33a","4-7","65y","65k"})
    void 숫자가_아닌_다른_값이_입력되면_예외가_발생한다(String input){
        assertThatThrownBy(() -> BaseballNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"13","26","33","47","6534","6"})
    void 길이가_3이_아닌_값이_입력되면_예외가_발생한다(String input){
        assertThatThrownBy(() -> BaseballNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
