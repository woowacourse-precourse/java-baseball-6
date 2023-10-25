package baseball;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BaseballGameTest {
    @DisplayName("정상적인 게임동작 테스트")
    @Test
    void goodGame() {
        Input input = Mockito.mock(ConsoleInput.class);
        OutPut outPut = Mockito.mock(ConsoleOutput.class);
        Comparator comparator = Mockito.mock(Comparator.class);
        RandomGenerator randomGenerator = Mockito.mock(DiffNumberRandomGenerator.class);

        BaseballGame baseballGame = new BaseballGame(input, outPut, comparator, randomGenerator);

        Mockito.when(randomGenerator.make(3)).thenReturn("123");
        Mockito.when(input.getGameInput()).thenReturn("123");

        Map<String, Integer> map = new HashMap<>();
        map.put("strike", 3);
        map.put("ball", 0);

        Mockito.when(comparator.getResult("123", "123")).thenReturn(map);
        Mockito.when(input.getRestartInput()).thenReturn("2");

        baseballGame.start();
    }
}