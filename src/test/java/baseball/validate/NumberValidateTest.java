package baseball.validate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.model.BaseballGameRuleTest;
import org.junit.jupiter.api.Test;
public class NumberValidateTest {
    BaseballGameRuleTest baseballGameRuleTest = new BaseballGameRuleTest();
    @Test
    public void 숫자_범위_확인_1_9_test(){
        assertThat(GameValidate.isInRange(baseballGameRuleTest.getBaseballMinValue())).isTrue();
        assertThat(GameValidate.isInRange(baseballGameRuleTest.getBaseballMaxValue())).isTrue();
        assertThat(GameValidate.isInRange(baseballGameRuleTest.getBaseballMinValue()-1)).isFalse();
        assertThat(GameValidate.isInRange(baseballGameRuleTest.getBaseballMinValue()+1)).isFalse();
    }
    @Test
    public void 문자열_숫자_인지_확인_test(){
        assertThat(NumberValidate.isNumber("1")).isTrue();
        assertThatThrownBy(()->NumberValidate.isNumber("!")).isInstanceOf(IllegalArgumentException.class);
    }
}
