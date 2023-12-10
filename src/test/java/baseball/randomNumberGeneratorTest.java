package baseball;

import baseball.domain.randomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class randomnumbergeneratortest {
    @Test
    void createRandomNumbers() {
        List<Integer> testComputer = randomNumberGenerator.generateComputer();
        assertThat(testComputer.size()).isEqualTo(3);
        for (int i=1; i<3; i++) {
            assertThat(testComputer.get(i)).isNotEqualTo(testComputer.get(i-1));
        }
    }
}
