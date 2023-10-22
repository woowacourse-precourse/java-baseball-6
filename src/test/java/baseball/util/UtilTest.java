package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {

    @Test
    @DisplayName("숫자 타입 검증 성공 케이스")
    void 숫자_타입_검증_성공() {
        boolean result = Util.validNumberType(1);
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("숫자 타입 검증 실패 케이스")
    void 숫자_타입_검증_실패() {
        boolean result = Util.validNumberType("String");
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("숫자 범위 검증 성공 케이스")
    void 숫자_범위_검증_성공() {
        boolean result = Util.validNumberRange(1, 9, 3);
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("숫자 범위 검증 실패 케이스")
    void 숫자_범위_검증_실패() {
        boolean result = Util.validNumberRange(1, 9, 3);
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("숫자 중복 검증 성공 케이스")
    void 숫자_중복_검증_성공() {
        boolean result = Util.validDuplicatedNumbers(Arrays.asList(1, 2, 3));
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("숫자 중복 검증 실패 케이스")
    void 숫자_중복_검증_실패() {
        boolean result = Util.validDuplicatedNumbers(Arrays.asList(1, 1, 1));
        assertThat(result).isFalse();
    }
}
