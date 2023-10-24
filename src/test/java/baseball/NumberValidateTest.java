package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.validate.NumberValidate;
import org.junit.jupiter.api.Test;
public class NumberValidateTest {
    @Test
    public void 숫자_범위_확인_1_9_test(){
        assertThat(NumberValidate.isInRange(1)).isTrue();
        assertThat(NumberValidate.isInRange(9)).isTrue();
        assertThat(NumberValidate.isInRange(0)).isFalse();
        assertThat(NumberValidate.isInRange(10)).isFalse();
    }
    @Test
    public void 문자열_숫자_인지_확인_test(){
        assertThat(NumberValidate.isNumber("1")).isTrue();
        assertThat(NumberValidate.isNumber("!")).isFalse();
    }
}
