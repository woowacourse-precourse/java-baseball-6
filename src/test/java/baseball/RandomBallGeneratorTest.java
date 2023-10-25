package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomBallGeneratorTest {

    @Test
    void 서로_다른_수_3개_뽑기() {
        RandomBallGenerator randomBallGenerator = new RandomBallGenerator();
        List<Integer> pickedList = randomBallGenerator.generateRandomNumber();
        assertThat(pickedList.get(0)).isNotEqualTo(pickedList.get(1))
                .isNotEqualTo(pickedList.get(2));
    }

    @Test
    void 모든_수가_1이상_9이하() {
        RandomBallGenerator randomBallGenerator = new RandomBallGenerator();
        List<Integer> pickedList = randomBallGenerator.generateRandomNumber();
        for (Integer pickedNumber : pickedList) {
            assertThat(pickedNumber).isBetween(0, 10);
        }
    }
}