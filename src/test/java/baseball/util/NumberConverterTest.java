package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumberConverterTest {
    @Test
    void 사용자가_입력한_글자의_수가_3개인지_확인한다() {
        assertThat(NumberConverter.from("123"))
                .isEqualTo(List.of(1, 2, 3));
    }
}