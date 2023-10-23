package baseball.domain;

import baseball.domain.generator.BaseballNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Computer 클래스 테스트")
class ComputerTest {
    @Test
    @DisplayName("Computer 생성 테스트")
    void testComputerConstructor() {
        BaseballNumbersGenerator numbersGenerator = new FakeBaseballNumbersGenerator();

        Computer computer = new Computer(numbersGenerator);
        computer.generateAnswerNumbers();

        assertEquals(List.of(5, 1, 4), computer.getAnswerNumbers());
    }

    static class FakeBaseballNumbersGenerator implements BaseballNumbersGenerator {
        @Override
        public List<Integer> generate() {
            return List.of(5, 1, 4);
        }
    }
}
