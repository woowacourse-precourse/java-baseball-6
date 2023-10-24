package baseball.computer;

import baseball.domain.computer.Computer;
import baseball.domain.number.validation.DuplicateDigitValidator;
import baseball.generator.NumberGenerator;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("길이가 3인 숫자가 생성된다.")
    @Test
    void generateNumbers() {
        Computer computer = createComputer(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> gameNumbers = computer.getGameNumbers();

        Assertions.assertThat(gameNumbers).hasSize(3);
    }

    @DisplayName("생성된 숫자는 중복되지 않는다.")
    @Test
    void generateNoneDuplicateDigit() {
        Computer computer = createComputer(List.of(1, 1, 2, 2, 4, 5));
        List<Integer> gameNumbers = computer.getGameNumbers();

        Assertions.assertThatCode(() -> DuplicateDigitValidator.validate(gameNumbers))
                .doesNotThrowAnyException();
    }

    private Computer createComputer(List<Integer> numbers) {
        NumberGenerator generator = new TestNumberGenerator(new ArrayDeque<>(numbers));
        return new Computer(generator);
    }

    private record TestNumberGenerator(Queue<Integer> numbers) implements NumberGenerator {

        @Override
        public Integer generate(Integer minNumber, Integer maxNumber) {
            return numbers.poll();
        }
    }
}
