package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class randomNumberGeneratorTest {

    @Test
    void createRandomNumbers() {
        List<Integer> testComputer = randomNumberGenerator.generateComputer();
        assertThat(testComputer.size()).isEqualTo(3);
        for (int i=1; i<3; i++) {
            assertThat(testComputer.get(i)).isNotEqualTo(testComputer.get(i-1));
        }
    }
}
