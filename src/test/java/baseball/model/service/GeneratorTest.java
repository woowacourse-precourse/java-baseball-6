package baseball.model.service;

import static baseball.model.constants.Rule.GAME_NUMBERS_MAX_VALUE;
import static baseball.model.constants.Rule.GAME_NUMBERS_MIN_VALUE;
import static baseball.model.constants.Rule.GAME_NUMBERS_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GeneratorTest {
    private List<Integer> randomNumbers;

    @BeforeEach
    void setUp() {
        Generator generator = new GeneratorImp();
        randomNumbers = generator.generateComputerNumbers();
    }

    @Test
    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 랜덤 수를 생성합니다.")
    void 세자리_랜덤_숫자_생성_범위_검사() {
        for (int number : randomNumbers) {
            assertTrue(number >= GAME_NUMBERS_MIN_VALUE.getValue() && number <= GAME_NUMBERS_MAX_VALUE.getValue());
        }
    }

    @Test
    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 랜덤 수를 생성합니다.")
    void 세자리_랜덤_숫자_생성_중복_검사() {
        Set<Integer> numbers = new HashSet<>(randomNumbers);
        assertEquals(GAME_NUMBERS_SIZE.getValue(), numbers.size());
    }
}