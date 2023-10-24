package baseball.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.model.GameResult;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallServiceTest {

    private BaseBallService baseBallService;

    @BeforeEach
    public void setUp() {
        baseBallService = new BaseBallService();
    }

    @Test
    @DisplayName("랜덤 생성된 숫자의 길이가 3이고, 고유 하며, 1~9까지의 숫자인지")
    public void testGenerateRandomNumbers() {
        List<Integer> numbers = baseBallService.generateRandomNumbers();

        assertEquals(3, numbers.size());
        assertEquals(numbers.stream().distinct().count(), numbers.size());
        numbers.forEach(number -> {
            assertTrue(number >= 1 && number <= 9);
        });
    }

    @Test
    @DisplayName("1스트라이크 1볼일 경우")
    public void testGetGameResult_1Strikes_1Ball() {
        List<Integer> target = Arrays.asList(1, 2, 3);
        List<Integer> userInput = Arrays.asList(2, 7, 3);

        GameResult result = baseBallService.getGameResult(target, userInput);

        assertEquals(1, result.strike);
        assertEquals(1, result.ball);
    }

    @Test
    @DisplayName("3스트라이크일 경우")
    public void testGetGameResult_3Strikes() {
        List<Integer> target = Arrays.asList(1, 2, 3);
        List<Integer> userInput = Arrays.asList(1, 2, 3);

        GameResult result = baseBallService.getGameResult(target, userInput);

        assertEquals(3, result.strike);
        assertEquals(0, result.ball);
    }

    @Test
    @DisplayName("다 틀렸을 경우")
    public void testGetGameResult_Nothing() {
        List<Integer> target = Arrays.asList(1, 2, 3);
        List<Integer> userInput = Arrays.asList(4, 5, 6);

        GameResult result = baseBallService.getGameResult(target, userInput);

        assertEquals(0, result.strike);
        assertEquals(0, result.ball);
    }


}