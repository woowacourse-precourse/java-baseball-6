package baseball.validate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
public class NumberValidateTest {
    @Test
    public void 숫자_범위_확인_1_9_test(){
        assertThat(GameValidate.isInRange(1)).isTrue();
        assertThat(GameValidate.isInRange(9)).isTrue();
        assertThat(GameValidate.isInRange(0)).isFalse();
        assertThat(GameValidate.isInRange(10)).isFalse();
    }
    @Test
    public void 문자열_숫자_인지_확인_test(){
        assertThat(NumberValidate.isNumber("1")).isTrue();
        assertThatThrownBy(()->NumberValidate.isNumber("!")).isInstanceOf(IllegalArgumentException.class);
    }
}
