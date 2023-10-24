package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @DisplayName("3자리의 컴퓨터 수를 만든다.")
    @Test
    void make3Numbers() {
        List<Integer> computerNumbers = new NumberGenerator().createComputerNumbers();
        assertThat(computerNumbers).hasSize(3);
    }
}
