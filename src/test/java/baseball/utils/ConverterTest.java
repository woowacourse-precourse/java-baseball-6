package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {
    @DisplayName("int를 List<Integer>로 변환한다")
    @Test
    void convertIntToList() {
        int number = 123;
        List<Integer> expected = List.of(1, 2, 3);

        List<Integer> actual = Converter.convertIntToList(number);

        assertThat(actual).isEqualTo(expected);
    }
}
