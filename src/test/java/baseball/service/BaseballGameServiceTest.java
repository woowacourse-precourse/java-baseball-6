package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballGameServiceTest {

    @Test
    public void generateRandomNums_size_3() {
        // when
        List<Integer> numbers = BaseballGameService.generateRandomNums();

        // then
        assertEquals(numbers.size(), 3);
    }
}