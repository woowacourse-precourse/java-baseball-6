package baseball.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Baseball;
import baseball.dto.BattedBallsDTO;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BatterImplTest {

    private static final String BATTED_BALLS_STRING = "123";

    private Batter batter;

    @BeforeEach
    void setUp() {
        batter = new BatterImpl();
    }

    @Test
    void tryBatting이_문자열을_올바르게_야구공으로_변환() {
        // Given
        BattedBallsDTO battedBallsDTO = BattedBallsDTO.from(BATTED_BALLS_STRING);
        Map<Integer, Baseball> expectedBalls = getExpectedBalls();

        // When
        List<Baseball> actualResult = batter.tryBatting(battedBallsDTO);

        // Then
        assertThat(actualResult)
                .allMatch(ball -> ball.isStrike(expectedBalls));
    }

    private static Map<Integer, Baseball> getExpectedBalls() {
        Map<Integer, Baseball> expectedBalls = new HashMap<>();
        Arrays.stream(BATTED_BALLS_STRING.split(""))
                .mapToInt(Integer::parseInt)
                .forEach(battedBall -> expectedBalls.put(battedBall - 1,
                        Baseball.of(battedBall - 1, battedBall)));

        return expectedBalls;
    }
}
