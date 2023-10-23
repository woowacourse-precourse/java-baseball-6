package baseball.model.service;

import static baseball.model.constants.GameConstants.GAME_NUMBERS_MAX_VALUE;
import static baseball.model.constants.GameConstants.GAME_NUMBERS_MIN_VALUE;
import static baseball.model.constants.GameConstants.GAME_NUMBERS_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerNumbersGeneratorTest {
    @Test
    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 랜덤 수를 생성합니다.")
    void 세자리랜덤수생성() {
        ComputerNumbersGenerator computerNumbersGenerator = new ComputerNumbersGeneratorImp();

        List<Integer> randomNumbers = computerNumbersGenerator.generateComputerNumbers();

        for (int number : randomNumbers) {
            assertTrue(number >= GAME_NUMBERS_MIN_VALUE && number <= GAME_NUMBERS_MAX_VALUE);
        }

        Set<Integer> numbers = new HashSet<>(randomNumbers);
        assertEquals(GAME_NUMBERS_SIZE, numbers.size());
    }
}