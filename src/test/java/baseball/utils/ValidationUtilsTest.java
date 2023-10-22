package baseball.utils;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationUtilsTest {
    @Test
    void 숫자_길이_테스트(){
        assertThatThrownBy(()-> new ValidationUtils("121"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자_범위_테스트() {
        assertThatThrownBy(()-> new ValidationUtils("000"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 중복_테스트() {
        assertThatThrownBy(()-> new ValidationUtils("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}