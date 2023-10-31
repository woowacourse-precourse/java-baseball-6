package baseball.domain.util.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerGeneratorTest {
    @Test
    void getTarget_ShouldGenerateValidNumbers() {
        List<Integer> targetNumbers = ComputerGenerator.getTarget();

        assertThat(targetNumbers).hasSize(3).allMatch(number -> number >= 0 && number <= 9);
    }
}