package baseball.domain.player;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.Baseball;
import baseball.domain.BaseballGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class PitcherImplTest extends NsTest {
    private List<Baseball> pitchedBalls;
    private final Map<Integer, Baseball> expectedResult = new HashMap<>();
    private int[] randomNumbers = new int[BaseballGame.BALL_COUNT];

    @Test
    void pitchBalls가_올바르게_공을_생성() {
        // Given
        setRandomNumbers();
        setExpectedResult();

        // Then
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    pitchedBalls.forEach(this::assertIsStrike);
                },
                randomNumbers[0],
                randomNumbers[1],
                randomNumbers[2]
        );
    }

    @Override
    protected void runMain() {
        pitchedBalls = new PitcherImpl().pitchBalls();
    }

    private Baseball createBaseBall(int ballOrder) {
        return Baseball.of(ballOrder, randomNumbers[ballOrder]);
    }

    private int getValidBallNumber(Set<Integer> existNumbers) {
        if (existNumbers.size() >= Baseball.MAX_POSITION) {
            throw new IllegalArgumentException();
        }
        while (true) {
            int newNumber = (int)( Math.random() * Baseball.MAX_POSITION) + 1;
            if (!existNumbers.contains(newNumber)) {
                existNumbers.add(newNumber);
                return newNumber;
            }
        }
    }

    private void assertIsStrike(Baseball baseball) {
        assertTrue(baseball.isStrike(expectedResult));
    }

    private void setRandomNumbers() {
        Set<Integer> existBallNumbers = new HashSet<>();
        randomNumbers = Arrays.stream(randomNumbers)
                .map(randomNumber -> getValidBallNumber(existBallNumbers))
                .toArray();
    }

    private void setExpectedResult() {
        IntStream.range(0, BaseballGame.BALL_COUNT)
                .forEach(ballOrder -> expectedResult.put(ballOrder, createBaseBall(ballOrder)));
    }
}
