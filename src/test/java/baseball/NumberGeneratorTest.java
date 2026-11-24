package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    @DisplayName("1부터 9까지 서로 다른 숫자 3개를 생성한다.")
    void generateNumber() {
        NumberGenerator generator = new NumberGenerator();

        List<Integer> numbers = generator.generate();

        assertThat(numbers).hasSize(3);
        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers)
                .allSatisfy(number ->
                        assertThat(number).isBetween(1, 9));
    }
}
