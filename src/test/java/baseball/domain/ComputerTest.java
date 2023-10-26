package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.generator.BaseballNumbersGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Computer 클래스 테스트")
class ComputerTest {
    @Test
    @DisplayName("Computer 생성 테스트")
    void testComputerConstructor() {
        List<Integer> expected = List.of(5, 1, 4);
        BaseballNumbersGenerator numbersGenerator = new FakeBaseballNumbersGenerator(expected);

        Computer computer = new Computer(numbersGenerator);
        computer.generateAnswerNumbers();

        assertEquals(expected, computer.getAnswerNumbers());
    }

    static class FakeBaseballNumbersGenerator implements BaseballNumbersGenerator {
        private final List<Integer> expectedNumbers;

        public FakeBaseballNumbersGenerator(List<Integer> expectedNumbers) {
            this.expectedNumbers = expectedNumbers;
        }

        @Override
        public List<Integer> generate() {
            return expectedNumbers;
        }
    }
}
