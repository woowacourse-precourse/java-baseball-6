package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.Computer;
import baseball.domain.Game;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


public class ComputerTest extends NsTest {

    @Override
    protected void runMain() {
    }

    @Test
    public void testGenerateRandomNumbers() {
        int startInclusive = 1;
        int endInclusive = 100;
        int count = 3;

        Computer computer = new Computer();

        List<Integer> randomNumbers = computer.generateRandomNumbers(startInclusive, endInclusive, count);

        assertNotNull(randomNumbers);
        assertEquals(count, randomNumbers.size());

        // 범위 확인
        for (int number : randomNumbers) {
            assertTrue(number >= startInclusive && number <= endInclusive);
        }

        // 중복된 숫자 없는지 확인
        for (int i = 0; i < randomNumbers.size(); i++) {
            for (int j = i + 1; j < randomNumbers.size(); j++) {
                assertNotEquals(randomNumbers.get(i), randomNumbers.get(j));
            }
        }
    }

    @Test
    public void testComputeResult() {
        Computer computer = new Computer();

        // 시크릿 넘버 [1, 2, 3]
        List<Integer> secretNumbers = new ArrayList<>();
        secretNumbers.add(1);
        secretNumbers.add(2);
        secretNumbers.add(3);

        computer.setSecretNumbers(secretNumbers);

        // 입력 숫자 [3, 2, 1]
        List<Integer> userInputNumbers = new ArrayList<>();
        userInputNumbers.add(3);
        userInputNumbers.add(2);
        userInputNumbers.add(1);

        Game game = computer.computeResult(userInputNumbers);

        assertNotNull(game);
        assertEquals(1, game.getStrikes());
        assertEquals(2, game.getBalls());
    }
}
