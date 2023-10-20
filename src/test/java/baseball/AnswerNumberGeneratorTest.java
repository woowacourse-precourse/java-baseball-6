package baseball;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class AnswerNumberGeneratorTest {

    final AnswerNumberGenerator answerNumberGenerator = new AnswerNumberGenerator();
    final List<Integer> answerNumberList = answerNumberGenerator.getAnswerNumberList();

    @Test
    void 랜덤수_서로_다른_3자리() {

        Set<Integer> answerNumberSet = new HashSet<>(answerNumberList);
        assertThat(answerNumberSet.size()).isEqualTo(3);

    }

    @Test
    void 랜덤수_각_숫자_1과9사이() {

        for (int i = 0; i < 3; i++) {
            assertThat(answerNumberList.get(i)).isBetween(1, 9);
        }
    }
}
