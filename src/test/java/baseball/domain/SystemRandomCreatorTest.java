package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("SystemRandomCreator 클래스")
class SystemRandomCreatorTest {

    private final SystemRandomCreator randomCreator = SystemRandomCreator.getInstance();

    @Test
    void 올바른_범위_내의_숫자를_생성하는지_확인() {
        int randomNumber = randomCreator.createRandomNumber();

        assertTrue(randomNumber >= SystemRandomCreator.MIN_NUMBER
            && randomNumber <= SystemRandomCreator.MAX_NUMBER);
    }

    @Test
    void 세_자리_수를_올바르게_생성하는지_확인() {
        List<Integer> randomNumbers = randomCreator.createRandomNumbers();
        assertEquals(Referee.NUMBERS_SIZE, randomNumbers.size());
    }

    @Test
    void 중복되지_않는_숫자를_생성하는지_확인() {
        List<Integer> randomNumbers = randomCreator.createRandomNumbers();
        Set<Integer> validationSet = new HashSet<>(randomNumbers);
        assertEquals(Referee.NUMBERS_SIZE, validationSet.size());
    }
}