package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class ComputerTest {
    private Computer computer;
    final int MAX_SIZE = 3;
    final int LOWER_INCLUSIVE = 1;
    final int UPPER_INCLUSIVE = 9;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        computer.generateRandomNumbers();
    }

    @RepeatedTest(100)
    @DisplayName("컴퓨터는 1이상 9이하의 서로 다른 숫자 3개를 생성한다.")
    void generateRandomNumbers_1이상_9이하_서로_다른_숫자_3개_생성_테스트() {
        List<Integer> numbers = computer.getNumbers();

        assertThat(numbers).hasSize(MAX_SIZE);

        for (Integer number : numbers) {
            assertThat(number).isBetween(LOWER_INCLUSIVE, UPPER_INCLUSIVE);
        }

        assertThat(numbers).doesNotHaveDuplicates();
    }
}