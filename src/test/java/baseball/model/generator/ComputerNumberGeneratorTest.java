package baseball.model.generator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ComputerNumberGeneratorTest {
    @Test
    void 컴퓨터의_정답은_3글자이고_중복이_없다() {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        List<Integer> list = computerNumberGenerator.generateList();

        assertAll(
                () -> assertThat(list.size()).isEqualTo(3),
                () -> assertThat(list).doesNotHaveDuplicates()
        );
    }
}