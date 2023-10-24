package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    private final Computer computer = new Computer();

    @Test
    void 난수생성중복검사() {
        for (int i = 0; i < 100; i++) {
            Numbers numbers = computer.initComputerNumbers();

            List<Number> duplicateCheck = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                assertThat(duplicateCheck.contains(numbers.getNumberByIndex(j))).isFalse();
                duplicateCheck.add(numbers.getNumberByIndex(j));
            }
        }
    }
}
