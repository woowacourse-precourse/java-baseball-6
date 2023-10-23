package baseball;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class ComputerNumberGeneratorTest {

    final ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
    final List<Integer> computerNumberList = computerNumberGenerator.getAnswerNumberList();

    @Test
    void 랜덤수_서로_다른_3자리() {

        Set<Integer> answerNumberSet = new HashSet<>(computerNumberList);
        assertThat(answerNumberSet.size()).isEqualTo(3);

    }

    @Test
    void 랜덤수_각_숫자_1과9사이() {

        for (int i = 0; i < 3; i++) {
            assertThat(computerNumberList.get(i)).isBetween(1, 9);
        }
    }
}
