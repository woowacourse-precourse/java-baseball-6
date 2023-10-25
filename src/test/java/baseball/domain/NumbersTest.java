package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumbersTest {

    @Test
    @DisplayName("Numbers 객체 생성 성공 케이스")
    void Numbers_객체_생성_성공() {
        Numbers numbers = Numbers.of(Arrays.asList(1, 2, 3));
        assertThat(numbers).isInstanceOf(Numbers.class);
    }

    @Test
    @DisplayName("Numbers 객체 생성 실패 케이스(중복 숫자)")
    void Numbers_객체_생성_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            Numbers.of(Arrays.asList(1, 1, 1));
        });
    }
}
