package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
public class NumberValidateTest {
    @Test
    public void v(){
        assertThat(NumberValidate.isInRange(1)).isTrue();
        assertThat(NumberValidate.isInRange(9)).isTrue();
        assertThat(NumberValidate.isInRange(0)).isFalse();
        assertThat(NumberValidate.isInRange(10)).isFalse();
    }
}
