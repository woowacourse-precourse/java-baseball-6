package baseball.model.service;

import static baseball.model.constants.Constant.NUMBER_MAX_VALUE;
import static baseball.model.constants.Constant.NUMBER_MIN_VALUE;
import static baseball.model.constants.Constant.NUMBER_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerNumberTest {
    @Test
    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 랜덤 수를 생성합니다.")
    void 세자리랜덤수생성() {
        ComputerNumber computerNumber = new ComputerNumberImpl();

        List<Integer> randomNumbers = computerNumber.generate();

        for (int number : randomNumbers) {
            assertTrue(number >= NUMBER_MIN_VALUE && number <= NUMBER_MAX_VALUE);
        }

        Set<Integer> numbers = new HashSet<>(randomNumbers);
        assertEquals(NUMBER_SIZE, numbers.size());
    }
}