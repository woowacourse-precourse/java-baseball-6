package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTest {
    private Computer com = new Computer();

    @Test
    @DisplayName("낫싱 테스트")
    public void countTest_noStrikeNoBall(){
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(4, 5, 6);

        List<Integer> result = com.count(computer, player);
        assertEquals(Arrays.asList(0, 0), result);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    public void countTest_onlyStrike(){
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(1, 2, 3);

        List<Integer> result = com.count(computer, player);
        assertEquals(Arrays.asList(3, 0), result);
    }

    @Test
    @DisplayName("볼 테스트")
    public void countTest_onlyBall(){
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(3, 1, 2);

        List<Integer> result = com.count(computer, player);
        assertEquals(Arrays.asList(0, 3), result);
    }

    @Test
    @DisplayName("스트라이크&볼 테스트")
    public void countTest_strikeAndBall(){
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(1, 3, 6);

        List<Integer> result = com.count(computer, player);
        assertEquals(Arrays.asList(1, 1), result);
    }
}
