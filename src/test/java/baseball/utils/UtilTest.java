package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilTest {

    @Test
    @DisplayName("숫자 타입 검증 성공 케이스")
    void 숫자_타입_검증_성공() {
        boolean result = NumberUtil.validNumberType(1);
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("숫자 타입 검증 실패 케이스")
    void 숫자_타입_검증_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtil.validNumberType("String");
        });
    }

    @Test
    @DisplayName("숫자 범위 검증 성공 케이스")
    void 숫자_범위_검증_성공() {
        boolean result = NumberUtil.validNumberRange(1, 9, 3);
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("숫자 범위 검증 실패 케이스")
    void 숫자_범위_검증_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtil.validNumberRange(1, 9, 10);
        });
    }

    @Test
    @DisplayName("숫자 중복 검증 성공 케이스")
    void 숫자_중복_검증_성공() {
        boolean result = NumberUtil.validDuplicatedNumbers(Arrays.asList(1, 2, 3));
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("숫자 중복 검증 실패 케이스")
    void 숫자_중복_검증_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtil.validDuplicatedNumbers(Arrays.asList(1, 1, 1));
        });
    }

    @Test
    @DisplayName("숫자 3자리 수 인지 검증 성공 케이스")
    void 숫자_자리수_검증_성공() {
        boolean result = NumberUtil.validNumbersCount(Arrays.asList(1, 2, 3), 3);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("숫자 3자리 수 인지 검증 실패 케이스")
    void 숫자_자리수_검증_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtil.validNumbersCount(Arrays.asList(1, 2), 3);
        });
    }
}
