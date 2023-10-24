package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseballNumberTest {

    @Test
    @DisplayName("숫자가 1부터 9 이하면 생성 가능")
    void create_between_1_to_9_success() {
        assertThat(new BaseballNumber(1)).isNotNull();
    }

    @Test
    @DisplayName("숫자가 1부터 9 이하가 아니면 예외 발생 - 0")
    void create_0_fail() {
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(0));
    }

    @Test
    @DisplayName("숫자가 1부터 9 이하가 아니면 예외 발생 - 10")
    void create_10_fail() {
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(10));
    }

    @Test
    @DisplayName("숫자가 같은 경우 같은 객체")
    void contain_same_number_is_equal_object() {
        BaseballNumber baseballNumber = new BaseballNumber(1);
        BaseballNumber compareNumber = new BaseballNumber(1);
        assertThat(baseballNumber).isEqualTo(compareNumber);
    }

    @Test
    @DisplayName("숫자가 다른 경우 같은 객체")
    void contain_different_number_is_not_equal_object() {
        BaseballNumber baseballNumber = new BaseballNumber(1);
        BaseballNumber compareNumber = new BaseballNumber(5);
        assertThat(baseballNumber).isNotEqualTo(compareNumber);
    }
}
